package Section10To20;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4WindowSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/*** Req: Open URL, navigate to multiple windows URL, click on link new window should be displayed. 
		 * Print text present in new window, switch back to parent window and print text present in parent window. ***/
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		/*** Before switching, we need to get total count of windows and thier id's to switch into child window. ***/		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentWindow = it.next();
		//String childWindow = it.next(); -- Here instead of this, next() can be used directly in first switch.
		
		//Switch into child window
		driver.switchTo().window(it.next());
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
		
		//Again switch back to parent window
		driver.switchTo().window(parentWindow);
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
		
	}

}
