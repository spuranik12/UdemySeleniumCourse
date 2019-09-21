package objectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {
	
	//Constructor created to access this class as we are sending driver with this class object in test cases.
	public RediffLoginPage(WebDriver driver) {
		//Argument passed here is local page class driver. Now we need to link testcase driver with this driver.
		this.driver = driver;
		//Means, test case class driver is assigned to "this.driver" i.e., local class driver. Keyword 'this'
		//refers to local driver.
	}
	
	WebDriver driver;
	
	//Colecting all login page objects in loginPage class using 'By' keyword.
	
	By username = By.xpath("//input[@id='login1']");
	By password = By.id("password");
	By go = By.name("proceed");
	By homeLink = By.linkText("Home");
	
	//Create methods which should return
	public WebElement Email()
	{
		return driver.findElement(username);
	}
	
	public WebElement Password()
	{
		return driver.findElement(password);
	}
	
	public WebElement Submit()
	{
		return driver.findElement(go);
	}
	
	public WebElement Home()
	{
		return driver.findElement(homeLink);
	}
}
