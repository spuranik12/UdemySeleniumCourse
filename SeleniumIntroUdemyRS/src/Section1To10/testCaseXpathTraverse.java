package Section1To10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testCaseXpathTraverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/* How to traverse xpath from one sibling to another with help of relative xpath i.e, from parent to child */
		
		driver.get("http://qaclickacademy.com");
		driver.findElement(By.cssSelector("a[href*='interview']")).click(); //Here Css is with regular expression.
		driver.findElement(By.xpath("//li[@id='tablist1-tab1']")).click();
		driver.findElement(By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[1]")).click(); //1st sibling followed by its another sibling.
		driver.findElement(By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[2]")).click(); //2nd Sibling
		driver.findElement(By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[3]")).click(); //3rd Sibling
		
		/* How to traverse back from child to parent from xpath */
		System.out.println(driver.findElement(By.xpath("//li[@id='tablist1-tab4']/parent::ul")).getAttribute("role"));
		
		/* Xpath using text based */
		System.out.println(driver.findElement(By.xpath("//*[text()=' Testing ']")).getText());
	}

}
