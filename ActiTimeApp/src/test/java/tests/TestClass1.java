package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import pom.ApplicationHeader;
import pom.LoginPage;

public class TestClass1 {
	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "E:\\Software Testing data\\Java\\SeleniumSW\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/login.do");
		
		
		LoginPage loginPage =new LoginPage(driver);
		loginPage.sendUserName("admin");
		loginPage.sendPassword("manager");
		loginPage.selectKeepMeLogin();
		loginPage.clickOnlogin();
		
		ApplicationHeader applicationHeader= new ApplicationHeader(driver);
		applicationHeader.openTaskPage();
	}

	private static void launchBrowser() {
		// TODO Auto-generated method stub
		
	}
	
}
