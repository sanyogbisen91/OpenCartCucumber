package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
  
	WebDriver driver;
	
  @BeforeClass
  public void setup() throws InterruptedException {
	  
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
  }
  
  @Test
  public void testLogin() {
	  LoginPage lp=new LoginPage(driver);
	  lp.setUserName("Admin");
	  lp.setPassword("admin123");
	  lp.clickLogin();
	  
	  Assert.assertEquals(driver.getTitle(), "OrangeHRM");
  }

  @AfterClass
  public void tearDown() {
	  driver.quit();
  }

}
