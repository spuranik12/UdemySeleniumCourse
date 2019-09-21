package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testCase4WithRExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://rediff.com");
		driver.findElement(By.xpath("//a[contains(@title,'Sign')]")).click(); //Xpath regular expn
		driver.findElement(By.cssSelector("input#login1")).sendKeys("helloworld"); //Normal CSS with # for Id
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("byeee"); //Normal Xpath
		driver.findElement(By.cssSelector("input[name*='proc']")).click(); //CSS regular expn which searches only for text 'proc'
	}

}
