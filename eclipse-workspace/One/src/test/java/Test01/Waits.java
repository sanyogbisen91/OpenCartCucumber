package Test01;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//explicitwait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		
		//fluent wait
		Wait<WebDriver> wait1=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		WebElement txtUsername = wait1.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver)
			{
				return driver.findElement(By.xpath("//input[@placeholder='Username']"));
			}
		});
				      
				
		
		driver.close();
		

	}

}
