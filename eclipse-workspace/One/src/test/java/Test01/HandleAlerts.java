package Test01;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/javasript_alerts");
		driver.manage().window().maximize();
		
		//normal alert with OK button
		Alert myalert = driver.switchTo().alert();
		System.out.println(myalert.getText());
		myalert.accept();
		
		

	}

}
