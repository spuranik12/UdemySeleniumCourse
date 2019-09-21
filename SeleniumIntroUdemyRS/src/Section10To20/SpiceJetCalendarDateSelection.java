package Section10To20;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpiceJetCalendarDateSelection {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://spicejet.com");
		
		/** Req: Need to select - August 29 for One way trip only **/
		
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		
		/*** MONTH SELECTION BEFORE DATE SELECTION ***/
		
		while(!driver.findElement(By.cssSelector("[class='ui-datepicker-title']")).getText().contains("September"))
		{
			driver.findElement(By.cssSelector("[data-handler='next']")).click();
		}
		
		/*** SELECTION OF DATES IRRESPECTIVE OF MONTH ***/
		
		//Grab common attribute for list of dates.
		List<WebElement> dates = driver.findElements(By.cssSelector("[class='ui-datepicker-calendar'] td[data-handler='selectDay']"));
		
		//Get count of dates web elements displaying calendar.
		int count = dates.size();
		
		for(int i=0;i<count;i++)
		{
			String text = dates.get(i).getText();
			if(text.equalsIgnoreCase("13"))
			{
				dates.get(i).click();
				break; //If given input is found at start of the iteration itself, but still for loop keeps on iterating until the total count.
			}
		}
	}

}
