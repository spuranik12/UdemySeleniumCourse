package testDemo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test1 extends BaseTest{
	
	@AfterTest
	public void afterBeforeTest(){
		System.out.println("After Test..");
	}
	
	@Test(dependsOnMethods={"ipadLoginCarLoan"})
	public void mobileLoginCarLoan()
	{
		System.out.println("Mobile Login Car Loan");
	}
	
	@Test
	public void webLoginCarLoan() throws IOException
	{
		openBrowserWithoutHardcoding();
		System.out.println("Web Login Car Loan");
		//Assert.assertTrue(false);
	}
	
	@BeforeSuite
	public void beforeSuiteMethod()
	{
		System.out.println("I am first before test");
	}
	
	@AfterSuite
	public void afterSuiteMethod()
	{
		System.out.println("I am last after entire tests");
	}
	
	@Test(dataProvider="getData")
	public void ipadLoginCarLoan(String uname, String pwd)
	{
		System.out.println("ipad Login Car Loan");
		System.out.println(uname);
		System.out.println(pwd);
	}
	
	@BeforeTest
	public void runBeforeTest(){
		System.out.println("Before Test..");
	}
	
	@DataProvider
	public Object[][] getData(){
		
		/*** Data provider is used to paramterize particular test case with multiple datasets for multiple combinations.
		Ex: 1st set- usename, password with good credit history
		    2nd set- username, password without credit history
		    3rd set- username, password for fraudlent customer. ***/
		//Here we use multidimensional array with 1st parameter as no. of combinations(as a row) which we are performing & second as columns
		//where we pass no. of arguments in each scenario.
		Object[][] data = new Object[3][2];
		//1st set
		data[0][0]="uname1";
		data[0][1]="pwd1";
		
		//2nd set
		data[1][0]="uname2";
		data[1][1]="pwd2";
		
		//3rd set
		data[2][0]="uname3";
		data[2][1]="pwd3";
		return data;
	}
}
