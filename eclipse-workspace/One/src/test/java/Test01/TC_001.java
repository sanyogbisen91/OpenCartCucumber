package Test01;
import org.openqa.selenium.chrome.ChromeDriver;
public class TC_001 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
		//Thread.sleep(5000);
		//driver.close();

	}

}
