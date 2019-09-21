package Section10To20;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassScenarios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com");
		
		/**** Req1: We need to mouse hover on sign-in link, pop-up with other links should be displayed. ****/
		
		WebElement signInBtn = driver.findElement(By.cssSelector("#nav-link-accountList"));
		
		Actions a = new Actions(driver);
		a.moveToElement(signInBtn).build().perform();
		
		/*** Req 2: Enter text in to searchbox, with capital letters and select all entered text ***/
		
		WebElement textBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		a.moveToElement(textBox).click().keyDown(Keys.SHIFT).sendKeys("mobile").doubleClick().build().perform();
		
		/**** Req 3: Right click on link. ****/
		
		a.moveToElement(signInBtn).contextClick().build().perform();
	}

}
