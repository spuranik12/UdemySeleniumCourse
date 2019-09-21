package Section10To20;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveWithJavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/");
		driver.manage().window().maximize();
		
		/*** Req: Open KSRTC Url, enter chars as 'BENG' and check if Bengaluru International Airport option is displayed in list or not. ***/
		
		driver.findElement(By.id("fromPlaceName")).sendKeys("Ben");
		Thread.sleep(1000);
		//Press down in list to get option.
		//driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ARROW_DOWN);
		
		
		//Get text of selected option
		System.out.println(driver.findElement(By.id("fromPlaceName")).getText());
		
		/*** We have to use JavaScript executor when there are any hidden elements in html from which we have to perform some actions.
		Javascript DOM can extract hidden elements, because selenium cannot identify hidden elements - Ajax implementation.
		Firstly, we have to investigate the properties of object if it has any hidden elements. ***/
		
		//Using Javascript executor...
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Write script from which text is extracted. For this go to chrome console and HTML document from w3schools.
		//1- copy script from console, add backward slash bcoz double quotes within double quotes will not work.
		//2- Add semiclon, at end of value and add return keyword to return value at start within double quotes.
		String script = "return document.getElementById(\"fromPlaceName\").value;";
		
		//execute above script
		String text = (String) js.executeScript(script);
		System.out.println("Before search - " + text);
		
		//If we pass any wrong text value in while loop, then it executes for infinite.
		//So, for that we have to set some limit as below.
		
		int i=0;
		
		while(!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT"))
		{
			i++;
			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ARROW_DOWN);
			text = (String) js.executeScript(script);
			System.out.println(text);
			
			if(i>10)
			{
				break;
			}
		}
		
		if(i>10)
		{
			System.out.println("Element not found");
		}
		else
		{
			System.out.println("Element found");
		}
		
	}	

}
