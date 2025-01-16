package Test_001;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
    WebDriver driver=new EdgeDriver();
		
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		WebDriverWait myWait=new WebDriverWait(driver,Duration.ofSeconds(10));
		/*
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(5000);
		
		Alert myAlert=driver.switchTo().alert();
		System.out.println(myAlert.getText());
		myAlert.accept();
		*/
		
		/*
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(2000);
		
		driver.switchTo().alert().dismiss();
		*/
		
		//prompt alert
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(2000);
		
		//Alert myAlert=driver.switchTo().alert();
		Alert myAlert=myWait.until(ExpectedConditions.alertIsPresent());
		
		myAlert.sendKeys("Maddy");
		Thread.sleep(3000);
		myAlert.accept();

	}

}
