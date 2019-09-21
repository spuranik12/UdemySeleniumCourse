package Section10To20;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeTestCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/*** Req 1: Get total counts of links in entire page. 
		 * Hint- Ideally, all links are created with anchor tag "a". ***/
		
		driver.get("http://qaclickacademy.com/practice.php");
		
		System.out.println("Total links present in entire page - " + driver.findElements(By.tagName("a")).size());
		
		/*** Req 2: Find total links count in footer section of page. 
		 * Here basically, we need to create mini driver which would be sub set of main driver.
		 * Get locator of section and store it in webelement. FooterDriver is mini driver.***/
		
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG")); //Limiting web driver scope.
		
		System.out.println("Total links present in footer section - " + footerDriver.findElements(By.tagName("a")).size());
		
		/*** Req 3- Get count of links present in one column of footer. 
		 * However, we have come upto footer using mini driver. By considering that, we will go again.***/
		
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")); //Limiting mini driver scope again.
		
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		/*** Req 4- Now we want to check whether all links in first column of footer are working or not.
		Instead, of go through individual xpath for all links, we can do it using loop. As sometimes site may be dynamically 
		adding or removing links. ***/
		
		for(int i=1; i<columnDriver.findElements(By.tagName("a")).size(); i++)
		{
			
			//By using CNTRL key from keyboard it gets opened in new tab.
			String clickOnLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
			
			//click on each links. If we just click it will fail as first time when it clicks redirected to another page
			//& searches for another link. Pass above click but as it is of keyboard events, web driver understands in sendKeys method.
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinks);
			Thread.sleep(3000);
		}
		
		/*** Req 5- Once all links are opened in tabs, grab there title and print. 
		 * For this again we will use windowHandles() using while loop. ***/
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());	
			System.out.println(driver.getTitle());
		}
		
	}

}
