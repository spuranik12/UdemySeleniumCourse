package testCases;

import objectRepositories.RediffHomePage;
import objectRepositories.RediffLoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginAppTest {
	
	@Test
	public void Login()
	{
		//1- Here we all defining where exactly we need to execute our test cases.
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		//2- Now we need to access all objects of reposoitory created to execute test cases.
		// for that we need create object of that partiocular class & access those.
		//IMP: In Object, we need to pass webDriver object, so that it comes to know that where to execute all
		//those objects which we are fecthing from page classes. Once we pass argument as driver, it searches for
		// method/contructor with className pasing with one argument. For that we need to create constructor
		// in page class with one argument as driver.
		
		RediffLoginPage rd = new RediffLoginPage(driver);
		
		//3rd step in respective page classes by creating constructor & methods
		//4 - Call required methods from page class & perform operation
		
		rd.Email().sendKeys("hello");
		rd.Password().sendKeys("1235");
		//rd.Submit().click();
		rd.Home().click();
		
		//NOTE: By seeing code, we can say that this effectively structred & easy to read for any one & there is no
		//hard coded objects seen in testcases and all of those are maintained in systematic way in single page class.
		
		RediffHomePage rh = new RediffHomePage(driver);
		rh.SearchBox();
		rh.Search();
	}
}
