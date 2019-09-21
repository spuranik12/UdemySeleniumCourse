package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class AssignmentForE2EClearTripSearchFlights {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://cleartrip.com");
		
		/***Req: Select 2 Adults, 1 Child; Select Depart Date as Today; Click on more options & Enter preferred airline & click on search flights
		Grab the error message which occurs and print on console.****/
		
		Select selAdult = new Select(driver.findElement(By.id("Adults")));
		selAdult.selectByValue("2");
		
		WebElement children = driver.findElement(By.id("Childrens"));
		Select selChild = new Select(children);
		selChild.selectByIndex(1);
		
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();
		
		driver.findElement(By.id("MoreOptionsLink")).click();
		
		driver.findElement(By.cssSelector("#AirlineAutocomplete")).sendKeys("SpiceJet");
		
		driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
		
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
	}

}
