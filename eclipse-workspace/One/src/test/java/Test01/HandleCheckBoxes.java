package Test01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckBoxes {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//case 1: select specific checkbox
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//case 2: select all the checkboxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input']"));
		
		/*for(int i=0;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}
		*/
		/*for(WebElement checkbox:checkboxes)
		{
			checkbox.click();
		}*/
		
		//select last 3 checkboxes
		//starting index 4
		for(int i=4;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}
		

	}

}
