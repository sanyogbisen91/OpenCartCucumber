package Test01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement inputBox = driver.findElement(By.xpath("//input[@id='name']"));
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		//passing text into inputbox - alternate of sendKeys()
		js.executeScript("arguments[0].setAttribute('value','john')",inputBox);
		
		//clicking on element - alternate of click()
		WebElement radiobtn = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", radiobtn);

	}

}
