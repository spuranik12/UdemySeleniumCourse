package testDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class BaseTest {
	
	public WebDriver driver = null;
	
	@Test
	public void openBrowserWithoutHardcoding() throws IOException{
		
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("D:\\spuranik\\Selenium\\Udemy\\TestNGCourse_Udemy\\src\\testDemo\\dataDrivenTest.properties");
		
		prop.load(fis);
		
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("url"));
	}
}
