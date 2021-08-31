package roughwork;


import org.testng.annotations.*;
import org.testng.annotations.Test;

public class SampleTestNGCase {

	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is Before Method");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is Before Test");
	}

	@Test(priority = 1)
	public void firstCase() {
	System.out.println("1st case");
		
	}
	
	@Test(priority = 3)
	public void secondCase() {
	System.out.println("2nd case");
		
	}
	
	@Test(priority = 3)
	public void thirdCase() {
	System.out.println("3rd case");
		
	}
}

