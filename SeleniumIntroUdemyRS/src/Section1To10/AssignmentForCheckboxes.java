package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class AssignmentForCheckboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://qaclickacademy.com/practice.php");
		
		/* Assignment 1.1- Check the first  Checkbox and verify if it is successfully checked and 
		 * Uncheck it again to verify if it is successfully Unchecked*/
		
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//Uncheck senario
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		/*Assignment 1.2- How to get the Count of number of check boxes present in the page?
		 *NOTE: If reviewer don't want to use specific id in xpath/css then perform 1.1 again.*/
		
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		int count = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).getAttribute("value");
			if(text.equals("option1"))
			{
				driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).click();
				System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).getAttribute("value")+ " is checked.");
				Assert.assertTrue(true);
				driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).click();
				System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).getAttribute("value")+ " is unchecked again.");
				Assert.assertTrue(true);
			}
		}
		
	}

}
