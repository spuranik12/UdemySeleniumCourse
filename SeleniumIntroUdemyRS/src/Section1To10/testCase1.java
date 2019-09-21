package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class testCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create driver for InternetExplorerDriver driver
		
		//invoke third party IE driver which is .exe file
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://facebook.com");  //URL in browser
		//System.out.println(driver.getTitle());
		/*driver.findElement(By.id("email")).sendKeys("This is my first code..");
		driver.findElement(By.name("pass")).sendKeys("123456");
		driver.findElement(By.linkText("Forgotten account?")).click();*/
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("hello");
		driver.findElement(By.cssSelector("#pass")).sendKeys("1234");
	}

}
