package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class testCaseForDropdowns {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/* Automating static drop downs using select class */
		driver.get("http://Spicejet.com");
		
		/* 1. Create select object and then pass web element xpath or css as argument for select object 
		 * 2. Use methods provided by selenium for select class. .
		 * 3. For byValue method : need to pass value of that option which needs to be selected 
		 * 4. For byIndex method : just pass the index value which starts from 0 
		 * 5. For byVisibleText : can pass text visible in drop down as argument */
		
		Select sel = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		sel.selectByValue("USD");
		sel.selectByIndex(1);
		sel.selectByVisibleText("AED");
		
		
	}
}
