package tests;



import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestKeywords {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suit");
	}
	@BeforeTest
	@Parameters("testData")
	public void beforeTest(String data) {
	
		System.out.println("before Test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	@Test(invocationCount=2)
	public void testA() {
		System.out.println("testA");
	}
	
	@Test(dependsOnMethods= {"testC"})
	public void testB() {
		System.out.println("testB");
	}
	
	@Test(priority= -10)
	public void testC() {
		System.out.println("testC");
	}
	
	@Test(enabled=false)
	public void testD() {
		System.out.println("testD");
	}
	@Test(timeOut= 3000)
	public void testX() {
		System.out.println("testX");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}
	@AfterTest
	public void afterTest1() {
	System.out.println("after Test");
		}
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}
}
	
	
	
	


