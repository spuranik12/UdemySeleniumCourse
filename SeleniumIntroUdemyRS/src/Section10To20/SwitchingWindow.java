package Section10To20;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://chandanachaitanya.github.io/selenium-practice-site/");
		driver.findElement(By.xpath("//button[@id='win2']")).click();
		System.out.println("Before switching...");
		System.out.println(driver.getTitle());
		
		/*** Req: How to handle window switching 
		 * First we need to get total how windows are opening. By using getWindowHandles() we can get total count of windows and
		 * store it as string. Once done, need to iterate using Iterator() to get id's of all windows and store it in some variables ***/
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		/*** Now switch to desired child window. ***/
		
		driver.switchTo().window(childId);
		System.out.println("After switching...");
		System.out.println(driver.getTitle());
		
		/*** Switch back again to parent window. ***/
		
		driver.switchTo().window(parentId);
		System.out.println("Switching back to parent window...");
		System.out.println(driver.getTitle());
		
		
		
	}

}
