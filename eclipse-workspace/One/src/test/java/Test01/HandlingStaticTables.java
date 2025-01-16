package Test01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingStaticTables {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.testautomationpractice.blogpost.com/");
		driver.manage().window().maximize();
		
		//find total number of columns in a table
		int rows =driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Number of rows:"+rows);
		
		//find total number of rows in a table
		int cols =driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Number of columns:"+cols);
		
		//read data from specific row and column 
		String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println(bookName);
		
		

	}

}
