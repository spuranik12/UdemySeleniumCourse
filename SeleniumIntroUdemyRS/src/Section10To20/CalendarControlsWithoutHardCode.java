package Section10To20;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarControlsWithoutHardCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://path2usa.com/travel-companions");
		
		/*** Req: User wants to select date as Dec 10 in calendar without hardcoding. ***/
		
		driver.findElement(By.id("travel_date")).click();
		
		/*** SELECT DATE FROM SPECIFIC MONTH. 
		 * 1- Locate month web element & get text 
		 * 2- Using while loop, go on clicking on frwd/reverse arrow whichever is needed.
		 * 3- While Loop, stops until it's condition is false.***/
		
		WebElement month = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']"));
		
		//Here negation "!" is used, bcoz if month is Jan then instead of false it makes true, so that it can go inside loop.
		while(!month.getText().contains("October"))
		{
			//click on frwd arrow to change month.
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}
		
		//Store list of dates as web elements.
		List<WebElement> dates = driver.findElements(By.className("day"));
		
		//Get count of dates which has classname as day.
		int count = dates.size();
		
		//Using for loop to iterate with total count, find input text matches with list of dates.
		for(int i=0; i<count; i++)
		{
			//Grab text, if it's matched with input date then click on that.
			String text = driver.findElements(By.className("day")).get(i).getText();
			
			if(text.equalsIgnoreCase("10"))
			{
				driver.findElements(By.className("day")).get(i).click();
				//Add break, bcoz in loop at start itself desired date is clicked why to iterate till all listed dates.
				break;
			}
		}
	}	

}
