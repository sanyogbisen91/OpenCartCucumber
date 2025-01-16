package Test01;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import sun.net.www.protocol.http.HttpURLConnection;

public class BrokenLinks {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//driver.get("http://www.deadlinkcity.com/");
		driver.get("https://bstackdemo.com/");
		driver.manage().window().maximize();
		
		//get all the links from the website
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total number of links:"+links.size());
		
		int noOfBrokenLinks = 0;
		
		for(WebElement linkElement:links)
		{
			String hrefAttValue=linkElement.getAttribute("href");
			
			if(hrefAttValue== null || hrefAttValue.isEmpty())
			{
				System.out.println("href attribute value is null or empty, so not possible to check");
				continue;
			}
			
			//hit url to server
			try
			{
				URL linkURL=new URL(hrefAttValue); // converted href value from string to URL
				HttpURLConnection conn=(HttpURLConnection) linkURL.openConnection(); // open connection to the server
				conn.connect(); //connect to the server and send the request
				
				if(conn.getResponseCode()>=400)
				{
					System.out.println(hrefAttValue+"======> Broken Link");
					noOfBrokenLinks++;
				}
				else
				{
					System.out.println(hrefAttValue+"======> Not an Broken Link");
				}
			}
			catch(Exception e)
			
			{
				
			}
					
		}
		System.out.println("Number of broken links:"+noOfBrokenLinks);
	

	}

}
