package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testCase5ParentChildXpath {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		
		/* Create parent child xpath to enter into search box */
		
		//Case 1:-
		driver.findElement(By.xpath("//div[@class='SDkEP']/div/input")).sendKeys("Parent Child Xpath");
		
		//Case 2:-
		driver.findElement(By.xpath("//div[@id='gbw']/div/div/div/div[2]/a")).click();
		
	}

}
