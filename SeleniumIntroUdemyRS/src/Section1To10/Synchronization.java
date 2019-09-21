package Section1To10;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Synchronization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels?MDPCID=ALASKA-US.TPS.BRAND.hotels.HOTEL");
		
		/**** Excercise to implement 'Implicit Wait'. 
		 * Here it waits for maximum of 5 seconds for each step as its is applied globally****/
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("FH-origin")).sendKeys("nyc");
		driver.findElement(By.id("FH-destination")).sendKeys("Ont");
		driver.findElement(By.id("FH-destination")).sendKeys(Keys.ENTER);
		
		/**** Here loader appears, waits for 10 sec and closed the pop-up once it appears. ****/
		//driver.findElement(By.xpath("//button[@id='modalCloseButton']")).click();
		
		/**** Here we are using Explicit Wait. Wait is applied only to click on close icon not for entire script. ****/
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='modalCloseButton']")));
		
		driver.findElement(By.xpath("//button[@id='modalCloseButton']")).click();
	}

}
