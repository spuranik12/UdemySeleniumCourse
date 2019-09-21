package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testCaseForRadioBtns {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		//driver.findElement(By.xpath("//input[@value='Cheese']")).click();
		
		/*****1 Req: We want to find total number of radio buttons and print the count.*/
		//System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).size());
		
		/*****2 Req: Now i want to select all radio buttons one by one without setting with value*/
		/*int count = driver.findElements(By.xpath("//input[@name='group1']")).size();
		for(int i=0; i<count; i++)
		{
			driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
		}*/
		
		/****3 Req: If we want to click on any desired radio button without using value in xpath.
		 * a- First take count of total radio buttons.
		 * b- Second get attribute value of desired radio button using for loop.
		 * c- Third if value received is matched then click on that value using if loop.*/
		
		int count = driver.findElements(By.xpath("//input[@name='group1']")).size();
		for(int i=0;i<count;i++)
		{
			//System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value"));
			String text = driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");
			if(text.equals("Cheese"))
			{
				System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value"));
				driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
			}
		}
		
	}
}
