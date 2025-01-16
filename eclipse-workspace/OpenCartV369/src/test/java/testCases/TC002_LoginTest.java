package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	
  @Test(groups= {"Sanity","Master"})
  public void verify_Login() 
  {
	  logger.info("***Starting TC002_LoginTest***");
	  
	  try
	  {
	  HomePage hp=new HomePage(driver);
	  hp.clickMyAccount();
	  hp.clickLogin();
	  
	  Properties p = new Properties();
	  FileInputStream file = new FileInputStream("./src/test/resources/config.properties");
	  p.load(file); // Load properties file
      
      // Get email and password from properties
      String email = p.getProperty("email");
      String password = p.getProperty("password");

      // Ensure the values are not null
      if (email == null || password == null) {
          throw new IllegalArgumentException("Email or password is missing in the properties file.");
      }
	  
	  //login
	  LoginPage lp=new LoginPage(driver);
	  lp.setEmail(p.getProperty("email"));
	  lp.setPassword(p.getProperty("password"));
	  lp.clickLogin();
	  
	  //MyAccount
	  MyAccount macc=new MyAccount(driver);
	  boolean targetPage=macc.isMyAccountPageExists();
	  
	  Assert.assertTrue(targetPage);
	  }
	  catch (IOException e) {
	        logger.error("Error loading properties file: " + e.getMessage());
	        e.printStackTrace();
	    } catch (Exception e) {
	        logger.error("Test failed: " + e.getMessage());
	        e.printStackTrace();
	    }
	  
	  
	  
	  logger.info("*** Finished TC_002_LoginTest ***");
	  
	  
  }
}
