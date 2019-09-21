package Section10To20;

import java.awt.Checkbox;
import java.util.concurrent.TimeUnit;

import javax.swing.Box;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6WithoutHardCoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		/*** Req: 1- Select any Checkbox.
			 2- Grab the label of selected checkbox - Hint: Store in temp variable.
			 3- Select an option in drop down. Here option to select should come from step 2. No hardcoded values.
			 4- Enter the step 2 grabbed label text in alert edit Box.
			 5- Click on alert and then verify if text grabbed from step 2 is present in pop-up message. ***/

		driver.findElement(By.xpath("//div[@id='checkbox-example']//label[3]/input")).click();

		String optionSelected = driver.findElement(By.xpath("//div[@id='checkbox-example']//label[3]")).getText();
		System.out.println(optionSelected);

		WebElement selectDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select sel = new Select(selectDropdown);
		sel.selectByVisibleText(optionSelected);

		driver.findElement(By.cssSelector("#name")).sendKeys(optionSelected);

		driver.findElement(By.id("alertbtn")).click();

		String popupText = driver.switchTo().alert().getText();
		if(popupText.contains(optionSelected))
		{
			System.out.println("Selected checkbox text present in alert message");
		}
		else
		{
			System.out.println("Something went wrong with execution.");
		}
	}

}
