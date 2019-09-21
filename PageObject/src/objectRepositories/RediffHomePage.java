package objectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffHomePage {
	
	WebDriver driver;
	
	public RediffHomePage(WebDriver driver)
	{
		this.driver=driver;
		//Here we need to call pagefactory init elements method initialize all objects in this class with 
		//first as test case driver object & anaother as pageClass driver which is assigned to this in above lin.
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "srchword")
	WebElement searchBox;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement searchBtn;
	
	public WebElement SearchBox()
	{
		 searchBox.sendKeys("abc");
		 return searchBox;
	}
	
	public WebElement Search()
	{
		return searchBtn;
	}
}

