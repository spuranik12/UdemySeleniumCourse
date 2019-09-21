package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class testCaseForAutoSuggestiveDdl {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://makemytrip.com/");
		driver.findElement(By.id("fromCity")).click();
		WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
		from.sendKeys("Ban");
		Thread.sleep(2000);
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("fromCity")).getAttribute("value"));
		
		driver.findElement(By.id("toCity")).click();
		WebElement to = driver.findElement(By.xpath("//input[@placeholder='To']"));
		to.sendKeys("Del");
		Thread.sleep(2000);
		for(int i=1; i<4; i++)
		{
			to.sendKeys(Keys.ARROW_DOWN);
		}
		to.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("toCity")).getAttribute("value"));
	}

}
