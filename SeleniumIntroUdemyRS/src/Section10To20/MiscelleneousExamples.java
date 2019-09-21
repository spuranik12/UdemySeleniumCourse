package Section10To20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MiscelleneousExamples {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://azcaptcha.com/demo");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//Use below generic method to perform into frame.
		int numberOfFrames = findFrames(driver,By.xpath("//*[@id='switch_div']/label[2]/div"));
		driver.switchTo().frame(numberOfFrames);
		driver.findElement(By.xpath("//*[@id='switch_div']/label[2]/div")).click();
	}
	
	
	//Create utility generic method, pass driver as argument so that above webdriver is used.
	public static int findFrames(WebDriver driver, By locator)
	{
		int i;
		
		//Get size of frames present.
		int framesCount = driver.findElements(locator).size();
		
		//When count is present, check in which frame desired locator object is present using for loop
		for (i=0; i<framesCount; i++)
		{
			driver.switchTo().frame(i);
			
			//Get count of that locator which is present in any of these frames.
			int count = driver.findElements(locator).size();
			
			if(count>0)
			{
				break;
			}
			else
			{
				System.out.println("continue..");
			}
		}
		
		//Once desired object is found in any frame then switch to default content of page
		driver.switchTo().defaultContent();
		
		//Need to return with frame id to use this method.
		return i;
	}
}
