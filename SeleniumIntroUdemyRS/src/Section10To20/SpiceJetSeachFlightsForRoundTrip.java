package Section10To20;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SpiceJetSeachFlightsForRoundTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://spicejet.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*** SEARCH FLIGHTS FOR ROUND TRIP ***/
		
		//Select Round Trip Option.
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		//Select From & To Cities
		driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[text='Bengaluru (BLR)']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@text='Delhi (DEL)'])[2]")).click();
		
		//Verify Return date is enabled once round trip option is selected.
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("Return date is enabled...");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Return date is not enabled. Something wrong in condition...");
			Assert.assertTrue(false);
		}
		
		//Departure Date Selection for 21-September-2019
		
		while(!driver.findElement(By.cssSelector("[class='ui-datepicker-title']")).getText().contains("September"))
		{
			driver.findElement(By.cssSelector("[data-handler='next']")).click();
		}
		
		List<WebElement> departureDates = driver.findElements(By.cssSelector("[class='ui-datepicker-calendar'] td[data-handler='selectDay']"));
		
		int departureDatesCount = departureDates.size();
		
		for(int i=0;i<departureDatesCount;i++)
		{
			String text = departureDates.get(i).getText();
			if(text.equalsIgnoreCase("21"))
			{
				departureDates.get(i).click();
				break;
			}
		}
		
		//Return Date Selection for 6-October-2019
		
		Thread.sleep(1000);
		
		/*WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_mainContent_view_date2']")));
		
		System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).isEnabled());*/
		
		//Return Date Selection for 6-October-2019
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).click();
		
		while(!driver.findElement(By.cssSelector("[class='ui-datepicker-title']")).getText().contains("October"))
		{
			driver.findElement(By.cssSelector("[data-handler='next']")).click();
		}
		
		List<WebElement> returnDates = driver.findElements(By.cssSelector("[class='ui-datepicker-calendar'] td[data-handler='selectDay']"));
		
		int returnDatesCount = returnDates.size();
		
		for(int i=0;i<returnDatesCount;i++)
		{
			String text = returnDates.get(i).getText();
			if(text.equalsIgnoreCase("6"))
			{
				returnDates.get(i).click();
				break;
			}
		}
		
		//Select Family and Friends Checkbox
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		
		//Select Passengers
		//Thread.sleep(1000);
		driver.findElement(By.id("divpaxinfo")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefIncAdt")));
		
		for(int i=1; i<4; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//Select Currency
		Select sel = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		sel.selectByValue("USD");
		
		//Click on search button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
