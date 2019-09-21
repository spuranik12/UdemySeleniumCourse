package Section10To20;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7AutocompleteDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		
		/*** Req: Enter some values of your desired country and go to desired option from list and check that if selected option is present in
		edit box or not. ***/
		
		driver.findElement(By.id("autocomplete")).sendKeys("Uni");
		Thread.sleep(2000);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
		
		/*We can also use getAttribute, instead of Javascript executor to get text from edit box before selecting completely from auto complete.*/
		//System.out.println(driver.findElement(By.id("autocomplete")).getText());
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		
		String jsScript = "return document.getElementById(\"autocomplete\").value;";
		String text = (String) js.executeScript(jsScript);
		
		int i=0;
		while(!text.equalsIgnoreCase("United Kingdom"))
		{
			i++;
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
			text = (String) js.executeScript(jsScript);
			//System.out.println(text);
			if(i>10)
			{
				break;
			}
		}
		if(i>10)
		{
			System.out.println("Option not found in list.");
		}
		else
		{
			System.out.println(text + " - selected.");
		}*/
		
	}

}
