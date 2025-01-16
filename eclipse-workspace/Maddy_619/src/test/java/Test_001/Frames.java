package Test_001;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Frames {
	
	WebDriver driver;
	
	@BeforeClass
	
	
		      void setup() throws InterruptedException {
			  
			  driver=new ChromeDriver();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  driver.get("https://ui.vision/demo/webtest/frames/");
			  driver.manage().window().maximize();
			  Thread.sleep(3000);
	}
	
  @Test(priority=1)
  void frameTest() {
	  WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1']"));
	  driver.switchTo().frame(frame1);
	  driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome");
	  Assert.assertEquals(frame1.isDisplayed(), true);
	  
	  driver.switchTo().defaultContent();
	  
  }
  
  @Test(priority=2)
  void frameTest2() {
	  WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
	  driver.switchTo().frame(frame2);
	  driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Selenium");
	  Assert.assertEquals(frame2.isDisplayed(), true);
	  
	  driver.switchTo().defaultContent();
  
  
}
  
  @Test(priority=3)
  void frameTest3() {
	  WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
	  driver.switchTo().frame(frame3);
	  driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Java");
	  Assert.assertEquals(frame3.isDisplayed(), true);
	  
	  driver.switchTo().defaultContent();
	  
  }
}
  
