package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class testCaseForCalendarControls {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://Spicejet.com");
		
		/***Select checkbox and check if it is selected or not.
		 **** Added assertions*/
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		//System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		/*Also get count for total number of checkboxes on site using commom attribute.
		 **** Added assertions for expected results*/
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		/**** NEED TO VERIFY RETURN DATE IS ENABLED OR NOT WHEN CLICKED ON ROUND TRIP.
		 * NOTE: SOMETIMES, DUE TO RECENT TECHNOLOGIES CONTROLS GET ENABLED ONCE CLICKED, IN THAT CASE isEnabled()
		 * 				METHOD DOESN'T WORK WHICH IS PROVIDED BY SELENIUM.****/
		
		//IN SUCH CASES, NEED TO FIND ATTRIBUTE WHICH IS CHANGING ON CLICK. USING THAT CHECK IF IT'S ENABLED....
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			Assert.assertTrue(true);
			System.out.println("Return date is enabled...");		
		}
		//This is required, when IF condition fails, it will come into else and return false. Mean to say, user will come to
		//know something wrong in IF condition specified.
		else
		{
			Assert.assertTrue(false);
		}
		
		/*****NOW I WANT TO SELECT FROM & TO CITIES, BEFORE SELECTING DATES******/
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(1000);
		
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
		
		/*****SELECT DEPARTURE DATE*****
		* CASE 1: CURRENT DATE SELECTION*/
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
	}

}
