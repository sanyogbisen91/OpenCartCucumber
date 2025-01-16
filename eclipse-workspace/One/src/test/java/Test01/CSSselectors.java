package Test01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSselectors {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//tag id tag#id
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");
		//Thread.sleep(5000);
		
		//#id
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Pants");
		//Thread.sleep(5000);
		
		//tag class tag.classname
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Saree");
		//Thread.sleep(5000);
		
		// .classname
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Purse");
		//Thread.sleep(5000);
		
		//tag attribute
		driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Sunglasses");
		Thread.sleep(5000);
		
		
		driver.quit();
		
		

	}

}
