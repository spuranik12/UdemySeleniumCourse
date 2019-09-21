package Section10To20;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class FrameTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		/*** Req: How to handle frames along with Drag & Drop actions method. ***/
		
		//Switch to Frame using locator.
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		//driver.findElement(By.id("draggable")).click();
		
		//If we want to switch into frame using index method then first need to get total frame counts.
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		
		
		/*** Implement drag and drop action within frame using actions class. 
		 * Here, for drag & drop method we need source & target web elements.***/
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		
		/*** If user want to switch out of frame and perform any other action on page. ***/
		driver.switchTo().defaultContent();
		
		//This is just top open link in new tab after coming out of frame.
		WebElement element = driver.findElement(By.cssSelector("a[href*='sortable']"));
		a.moveToElement(element).keyDown(Keys.CONTROL).click().build().perform();
		
		/*** Once opened in new tab switch into child tab and validate child tab ***/
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		driver.switchTo().window(it.next());
		String textPresent = driver.findElement(By.className("entry-title")).getText();
		Assert.assertEquals(textPresent, "Sortable");
		System.out.println(textPresent);

	}

}
