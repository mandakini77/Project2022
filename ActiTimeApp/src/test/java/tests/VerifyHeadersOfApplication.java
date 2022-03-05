package tests;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom.ApplicationHeader;
import pom.LoginPage;
import utils.Utility;

public class VerifyHeadersOfApplication extends Browser {
	
	private WebDriver driver; 
	private ApplicationHeader applicationHeader;
	private LoginPage loginPage;
	int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		System.out.println("launch browser");
		System.out.println(browser);
		if(browser.equalsIgnoreCase("Chrome")) {
			driver=launchChromeBrowser();
		}
		if(browser.equalsIgnoreCase("Firefox")) {
			driver=launchFirefoxBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	@BeforeClass
	public void createPOMObject() {
		loginPage= new LoginPage(driver);
		applicationHeader= new ApplicationHeader(driver);
	}
	@BeforeMethod
	public void loginToApplication() throws EncryptedDocumentException, IOException {
		System.out.println("login to application");
		driver.get("http://localhost:8080/login.do");
		String userName= Utility.getDataFromExcel("sheet", 1, 0);
		loginPage.sendUserName(userName);
		String password= Utility.getDataFromExcel("sheet", 1, 1);
		loginPage.sendPassword(password);
		
		loginPage.selectKeepMeLogin();
		loginPage.clickOnlogin();
		applicationHeader= new ApplicationHeader(driver);
		}
	
	@Test
	public void toVerifyTaskButton() {
	
		testID= 101;
		System.out.println("To verify task tab");
		applicationHeader.openTaskPage();
		String url= driver.getCurrentUrl();
		String title= driver.getTitle();
		
		//Assert.assertEquals(url,"http://localhost:8080/tasks/otasklist.do","url of task is not found" );
		//Assert.assertEquals(title, "actiTIME - Open Tasks");
		//expected=actual then testcase= pass
		
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(url,"http://localhost:8080/tasks/otasklist.do","pass" );
		//boolean result=url.equals("http://localhost:8080/tasks/otasklist.do");
		//softAssert.assertTrue(result);
		softAssert.assertEquals(title, "actiTIME - Open Tasks","task title not match");
        softAssert.assertAll();
		
		 /* if(url.equals("http://localhost:8080/tasks/otasklist.do")) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		if(title.equals("actiTIME - Open Tasks")){
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		} */     
		
		/*Assert.assertEquals(url, "http://localhost:8080/tasks/otasklist.do", "url not found");
		
		Assert.assertEquals(url, title);  */
	}
	
	@AfterMethod
	public void logoutFromApplication(ITestResult result) throws IOException {
		if(ITestResult.SUCCESS==result.getStatus())
		{
			Utility.getScreenShot(driver, testID);
		}
		System.out.println("logout");
		applicationHeader.logoutFromApplication();
	}
	@AfterClass()
	public void clearPOMObject() {
		loginPage= null;
		applicationHeader= null;
		
	}	
	@AfterTest()
	public void closedBrowser() {
		driver.quit();
		driver= null;
		System.gc();
	}	

}
