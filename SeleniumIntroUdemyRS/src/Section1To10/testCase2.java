package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class testCase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create driver for InternetExplorerDriver driver
		
		//invoke third party IE driver which is .exe file
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com/?locale=in");  //URL in browser
		//System.out.println(driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("Hello");
		driver.findElement(By.name("pw")).sendKeys("123456");
		//driver.findElement(By.className("button r4 wide primary")).click(); //Error
		/*--- Here it throws error, as class name contains spaces b/w two word
		i.e., Compound class names are not allowed in selenium webdriver.*/
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());
	}

}
