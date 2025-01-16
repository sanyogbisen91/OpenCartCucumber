package Test01;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		//switch to frame
		driver.switchTo().frame(0);
		
		//method1: using sendKeys()
		//driver.findElement(By.xpath("//input[@id='datepicker')]")).sendKeys("12/19/2024"); //mm:dd:yyyy
		
		//method2 : using date tracker
		String year = "2024";
		String month = "December";
		String date = "01";
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();    //opens date picker
		
		//select month and year
		static void selectFutureDate(WebDriver driver,String year,String month,String date)
		{
		while(true)
		{
			String currentMonth=driver.findElement(By.xpath("//span[@class='datepicker-month'])")).getText(); //actual month
			String currentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(); //actual year
			
			if(currentMonth.equals(month) && currentYear.equals(year))
			{
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //Next
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //previous
			
		}
		
		//select the date
		//driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td//a")).click();
		
		{
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepaicker-calendar']//tbody//tr//td//a"));
		
		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
		}
		
		
		
		
		

	}

}
