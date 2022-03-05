package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	public static WebDriver launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Software Testing data\\Java\\SeleniumSW\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		return driver;
	}
	public static WebDriver launchFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "E:\\Software Testing data\\Java\\SeleniumSW\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		return driver;
	}
}