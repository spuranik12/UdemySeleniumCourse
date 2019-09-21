package testDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test3 {
	@BeforeClass
	public void beforeClass(){
		System.out.println("Executed before all methods of entire class");
	}
	@AfterClass
	public void afterClass(){
		System.out.println("Executed after all methods of entire class");
	}
	@Test(groups={"SMOKE"})
	public void carInsurance(){
		System.out.println("Car Insurance");
	}
	
	@Parameters({"URL"})
	@Test
	public void bikeInsuranceForSingleYear(String url)
	{
		System.out.println("Bike Insurance for single year");
		System.out.println(url);
	}
	
	@Test
	public void bikeInsuranceForMultipleYears()
	{
		System.out.println("Bike Insurance for multiple years");
	}
	
	@Test
	public void InsuranceLogin() throws IOException{
		
		//Properties class is used to interpret how we need to fetch global variables defined in any third
		//party doc.
		Properties prop = new Properties();
		
		//Once we know how to fetch data, we have to get location of properties file which has ext as .properties
		//TO fetch data java provides FileInputStream class and pass argument as path of file.
		FileInputStream fis = new FileInputStream("D:\\spuranik\\Selenium\\Udemy\\TestNGCourse_Udemy\\src\\testDemo\\dataDrivenTest.properties");
		
		//After fetching data, next we have to load that file to get data from it using properties class object.
		prop.load(fis);
		
		//To get value of the key username, use properties methods as getProperty.
		System.out.println(prop.getProperty("username"));
	}
}
