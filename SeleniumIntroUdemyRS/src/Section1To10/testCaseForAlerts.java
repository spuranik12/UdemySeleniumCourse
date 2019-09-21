package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testCaseForAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
		
		/*1. Req: We want to click on 'OK/YES/DONE' in alert or 'NO/CANCEL' in alert & also print text and enter some text if exists.*/
		
		driver.findElement(By.xpath("//input[@value='Confirmation Alert']")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
		
		/*NOTE: If want to enter text in alert then use 'sendkeys' after switching to alert & if want to click on Cancel use dismiss().*/
	}

}
