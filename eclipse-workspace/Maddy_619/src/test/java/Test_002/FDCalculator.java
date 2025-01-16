package Test_002;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String filePath=System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		int rows=ExcelUtils.getRowCount(filePath, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			//read data from excel
			String principal=ExcelUtils.getCellData(filePath, "Sheet1",i,0);
			String rateOfInterest=ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String per1=ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String per2=ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String frequency=ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			String exp_value=ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
			
			//pass above data into application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principal);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			
			Select perdrp=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			perdrp.selectByVisibleText(per2);
			
			Select fredrp=new Select(driver.findElement(By.xpath("//select[@id='frequency')]")));
			fredrp.selectByVisibleText(frequency);
			
			//validation
			String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(exp_value)==Double.parseDouble(act_mvalue))
			{
				System.out.println("Test Passed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
			}
			else
			{
				System.out.println("Test Failed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
				
			}
			Thread.sleep(5000);
			
			}

	}

}
