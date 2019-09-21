package Section1To10;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;


public class FluentWait {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
			
			/**** Req: How to use fluent wait ****/
			
			driver.findElement(By.cssSelector("[id='start'] button")).click();
			
			//Implementation of Fluent Wait---
			
			Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
			
			WebElement element = wait.until(new Function<WebDriver, WebElement>()
				{
					public WebElement apply(WebDriver driver)
					{
						if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed())
						{
							return driver.findElement(By.cssSelector("[id='finish'] h4"));
						}
						else
							return null;
						}
				});
			
			System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
		
	}
}
