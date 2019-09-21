package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testCaseForDynamicDropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://Spicejet.com");
		
		/*Now i want to select departure and arrival city*/
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(1000);
		
		/*Here, we can see that we have used index 2 as there multiple elements for same xpath.*/
		//driver.findElement(By.xpath("(//a[@value='BOM'])[2]")).click();
		
		/*Now to avoid indexes when there are multiple elements for same xpath, we can use parent-child relationship.
		 * Identify parent xpath smartly and with one space add child xpath/css
		 *By Xpath--*/
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		Thread.sleep(1000);
		
		/*By Css for above concept*/
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.cssSelector("div[id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='BOM']")).click();
		
	}

}
