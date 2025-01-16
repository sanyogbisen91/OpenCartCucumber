package Test01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.opencart.com");
		driver.manage().window().maximize();
		
		//xpath with single attribute
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("TShirts");
		
		//xpath with multiple attributes
		driver.findElement(By.xpath("//input[@placeholder='Search'][@name='search']")).sendKeys("Shirts");
		
		driver.findElement(By.xpath("//input[@placeholder='Search' and @name='search']")).sendKeys("Saree");
		driver.findElement(By.xpath("//input[@placeholder='Search' or @name='search']")).sendKeys("Pants");
		
		
		
		
		

	}

}
