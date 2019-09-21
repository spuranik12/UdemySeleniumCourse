package Section10To20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5FramesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		
		/*** Req: Click on Nested frames link and print 'Middle' text present in console. ***/
		
		driver.findElement(By.linkText("Nested Frames")).click();
		
		//Check total how many frames are present in page
		System.out.println("Total frames in page - " + driver.findElements(By.tagName("frame")).size());
		
		//Switch to desired frame using locator
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
		
		//Once entered into desired frame, there multiple nested frames. Find total count of them.
		System.out.println("Total nested frames present in single frame - " + driver.findElements(By.tagName("frame")).size());
		
		//Now switch to middle frame based on index/locator to print text in console.
		//driver.switchTo().frame(1);
		
		/*** Here we can directly pass argument with value of name, id attributes. ***/
		
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());
	}

}
