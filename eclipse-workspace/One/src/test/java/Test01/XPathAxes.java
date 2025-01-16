package Test01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//self - selects the current node
		//String text = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[54]/td[1]/a")).getText();
		String text = driver.findElement(By.xpath("//a[contains(text(),'L&T)]/self::a")).getText();
		System.out.println("Self :"+ text);
		
		//Parent - selects the parent of the current node
		String text1 = driver.findElement(By.xpath("//a[contains(text(),'L&T')]/parent::td")).getText();
		System.out.println("Parent :"+ text1);
		
		//Child - selects all children of the current node(one or many)
		List<WebElement> childs = driver.findElements(By.xpath("//a[contains(text(),'L&T')]/ancestor::tr/child::td"));
		System.out.println("Number of child elements: "+childs.size());
		
		//Ancestor - selects all ancestors(parent, grandparent, etc.)
		String text3 = driver.findElement(By.xpath("//a[contains(text(),'L&T')]/ancestor::tr")).getText();
		System.out.println("Ancestor: "+text3);
		
		//Descendants - Selects all descendants (Children, grandchildren, etc) of the current node
		List<WebElement> descendats = driver.findElements(By.xpath("//a[contains(text(),'L&T')]/ancestor::tr/descendant::*"));
		System.out.println("Number of descendant nodes: "+descendats.size());
		
		//precedings - selects all nodes appear before the currenr node in the document
		List<WebElement> precedings = driver.findElements(By.xpath("//a[contains(text(),'L&T')]//ancestor::tr/preceding::tr"));
		System.out.println("Number of preceding nodes: "+precedings.size());
		
		//following-siblings : selects all the siblings after the current node
		List<WebElement> followingSiblings = driver.findElements(By.xpath("//a[contains(text(),'L&T')]/ancestor::tr/following-siblings::tr"));
		System.out.println("Number of following siblings :"+followingSiblings.size());
		
		//preceding-siblings : selects all the siblings before the current node
		List<WebElement> precedingSiblings = driver.findElements(By.xpath("//a[contains(text(),'L&T')]/ancestor::tr/preceding-sibling::tr"));
		System.out.println("Number of preceding siblings :"+precedingSiblings.size());
		
		
		
		
		
		
		
		
		
		
		driver.quit();
	}

}
