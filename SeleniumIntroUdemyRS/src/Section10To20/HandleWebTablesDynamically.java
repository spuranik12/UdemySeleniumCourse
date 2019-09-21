package Section10To20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWebTablesDynamically {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\spuranik\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/20715/eng-vs-aus-1st-test-the-ashes-2019");
		
		/*** Req: Open Scoreboard and get each batsman scored runs ans sum. Match total score of team. */
		
		//Variable to get total sum
		int sum=0;
		
		//1- Scoreboard are stored in web tables. To handles tables get common css for that entire table.
		WebElement scorecardTable = driver.findElement(By.cssSelector("div[id=innings_1] div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']:nth-child(1)"));
		
		//2- Once we table is found, get total how many rows are present. because, total 11 players are there in cricket and we need to take individual score of each batsman.
		//tommorow assume if batsman is 20 then how to handle. So get commom css row locators.
		//One more point - if we use driver.findelement, then common css which are present in entire page will be found. But we want to just find rows of above found scorecard table.
		int rowsCount = scorecardTable.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
		
		//3- We got table& rows. Now we need to get all batsman scorecard which is column basically in table. So get in which column score is present and loop for same.
		int count = scorecardTable.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		
		//4- Use for loop to get score from each row. But we found apart from loop some other details also fetched from extras & total rows. 
		//To exclude those, make count-2 in loop condition.
		//Get sum of each batsman score.
		for(int i=0; i<count-2; i++)
		{
			String runsStringValue = scorecardTable.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			
			//runs are stored in string. To sum, we need to parse into integer & store in variable.
			int runsIntegerValue = Integer.parseInt(runsStringValue);
			sum = sum + runsIntegerValue;
		}
		
		//System.out.println(sum);
		
		//5- get extras and total from scorecard table. Here we use sibling concept using xpath.
		//Parse from string to integer as done above. Note:- Whenever we parse, need to store in variable with changed return type.
		String extrasStringValue = driver.findElement(By.xpath("//div[@id='innings_1']//div[text()='Extras']/following-sibling::div[1]")).getText();
		int extrasIntegerValue = Integer.parseInt(extrasStringValue);
		int totalScoreWithExtras = sum+extrasIntegerValue;
		System.out.println(totalScoreWithExtras);
		
		//6- Compare actual value. As of now we use if loop later we use assertions in framework.
		
		String totalScoreInString = driver.findElement(By.xpath("//div[@id='innings_1']//div[text()='Total']/following-sibling::div[1]")).getText();
		int actualTotalScore = Integer.parseInt(totalScoreInString);
		if(actualTotalScore==totalScoreWithExtras)
		{
			System.out.println("Total score matches...");
		}
		else
		{
			System.out.println("Total score does not matches...");
		}
		
	}

}
