package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class E2ESpiceJetFlightSearchTC {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://spicejet.com");
		
		/**** SELECT FROM & TO CITIES ****/
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value"));

		/*Here, we can see that we have used index 2 as there multiple elements for same xpath.*/
		//driver.findElement(By.xpath("(//a[@value='BOM'])[2]")).click();

		/*Now to avoid indexes when there are multiple elements for same xpath, we can use parent-child relationship.
		 * Identify parent xpath smartly and with one space add child xpath/css
		 *By Xpath--*/

		//		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		//		Thread.sleep(1000);

		/*By Css for above concept*/

		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.cssSelector("div[id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='BOM']")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_destinationStation1_CTXT")).getAttribute("value"));
		
		/***** SELECT DEPARTURE DATE *****/
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		/**** VERIFY RETURN DATE AS DISABLED. ****/
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			Assert.assertTrue(true);
			System.out.println("Return date is disabled...");		
		}
		//This is required, when IF condition fails, it will come into else and return false. Mean to say, user will come to
		//know something wrong in IF condition specified.
		else
		{
			Assert.assertTrue(false);
		}
		
		/**** SELECT SENIOR CITIZEN CHECKBOX ****/
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		//System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		/**** SELECT 4 ADULTS IN PASSENGER DROP DOWN. ****/
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		
		/* Requirement need to select 4 adults.
		 * Instead of writing same line for 3 to 4 times, need to use either for/while loop which is good practice always.  */
		
		/* For while/for loop, need to initialize variable, compare with condition, & increment/decrement.
		 * If not incremented/decremented, then loop gets executed for infinite */
		
		/*int i=1;
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}*/
		
		for(int i =1; i<4; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		//Click on done
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//Validating by printing
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		/**** SELECT CURRENCY, 1st as USD and at the end as INR ****/
		
		Select sel = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		sel.selectByValue("USD");
		sel.selectByIndex(1);
		sel.selectByVisibleText("INR");
		
		/**** CLICK ON SEARCH TO FIND FLIGHTS. ****/
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}
}

						/**** THIS IS END OF FLIGHT SEARCH FROM END TO END.... *****/

