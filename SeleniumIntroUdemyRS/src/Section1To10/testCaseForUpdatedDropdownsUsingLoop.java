package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testCaseForUpdatedDropdownsUsingLoop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/* Automating dynamic drop downs when any application is updated. */
		driver.get("http://Spicejet.com");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		
		/* Requirement need to select 4 adults.
		 * Instead of writing same line for 3 to 4 times, need to use either for/while loop which is good practice always.  */
		
		/* For while/for loop, need to initialize variable, compare with condition, & increment/decrement.
		 * If not incremented/decremented, then loop gets executed for infinite */
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		int i=1;
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		/*for(int i =1; i<5; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}*/
		
		//Click on done
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//Validating by printing
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
	}

}
