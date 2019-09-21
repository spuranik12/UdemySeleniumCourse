package testDemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 {
	
	@Test(groups={"SMOKE"})
	public void mobileLoginHomeLoan(){
		System.out.println("Mobile Login Home Loan");
	}
	
	@BeforeMethod
	public void beforeEveryMethod(){
		System.out.println("**********START OF METHOD******");
	}
	
	@AfterMethod
	public void afterEveryMethod(){
		System.out.println("**********END OF METHOD******");
	}
	
	@Parameters({"URL"})
	@Test
	public void webLoginHomeLoan(String url){
		System.out.println("Web Login Home Loan");
		System.out.println(url);
	}
}
