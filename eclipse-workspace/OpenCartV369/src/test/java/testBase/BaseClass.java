package testBase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
  
  public static WebDriver driver;
  public Logger logger;
  Properties p;
	
  @BeforeClass(groups= {"Regression","Sanity","Master","DataDriven"})
  @Parameters({"os", "browser"})
  public void setup(String os, String browser) throws IOException 
  {
	  //loading config.properties file
	  FileReader file = new FileReader("./src/test/resources/config.properties");
	  
          p= new Properties();
          p.load(file);
	  
	  
	  logger=LogManager.getLogger(this.getClass());
	  
	  //remote
	  if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	  {
		  DesiredCapabilities capabilities=new DesiredCapabilities();
		  
		 //os
		  if(os.equalsIgnoreCase("windows"))
		  {
			  capabilities.setPlatform(Platform.WIN11);
		  }
		  else if(os.equalsIgnoreCase("mac"))
		  {
			  capabilities.setPlatform(Platform.MAC);
		  }
		  else if(os.equalsIgnoreCase("linux"))
		  {
			  capabilities.setPlatform(Platform.LINUX);
		  }
		  else
		  {
			  System.out.println("No matching os");
			  return;
		  }
		  
		  //browser
		  switch(browser.toLowerCase())
		  {
		  case "chrome" : capabilities.setBrowserName("chrome"); break;
		  case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
		  case "firefox" : capabilities.setBrowserName("Firefox");
		  default : System.out.println("No matching os");
		  }
		  
		  driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	  }
	  
	  //local
	  if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	  {
		  
		  switch(browser.toLowerCase())
		  {
		  case "chrome" : driver=new ChromeDriver();break;
		  case "edge" : driver=new EdgeDriver();break;
		  default : System.out.println("Invalid Browser name");return;
		  }
	  }
	  
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.get(p.getProperty("appURL"));
	  driver.manage().window().maximize();
  }

  @AfterClass(groups= {"Regression","Sanity","Master","DataDriven"})
  public void tearDown() 
  {
	  driver.quit();
  }
  
  public String randomeString() 
  {
	String generatedstring=RandomStringUtils.randomAlphabetic(5);
	return generatedstring;
	
  }

	public String randomeNumber() 
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomAlphaNumeric() 
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+generatednumber);
	}
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath= System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+ timeStamp +".png";
		
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
		
	}

}
