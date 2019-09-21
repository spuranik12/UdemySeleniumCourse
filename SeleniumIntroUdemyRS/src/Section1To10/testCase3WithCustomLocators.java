package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testCase3WithCustomLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
		/* Custom Xpath */
//		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("myown xpath");
//		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123455");
//		driver.findElement(By.xpath("//*[@value='Log In']")).click();
		
		/* Custom CSS */
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("myown Css");
		driver.findElement(By.cssSelector("#password")).sendKeys("12345");
		driver.findElement(By.cssSelector("[value='Log In']")).click();
		
	}

}
