package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationHeader {
	@FindBy (xpath="//a[@class='content tt_selected selected']")
	private WebElement timeTrack;
	
	@FindBy (xpath="//a[@class='content tasks']")
	private WebElement tasks;
	
	@FindBy (xpath="//a[@class='content reports']")
	private WebElement reports;
	
	@FindBy (xpath="//a[@class='content users']")
	private WebElement users;
	
	@FindBy (xpath="//a[@id='logoutLink']")
	private WebElement logout;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ApplicationHeader(WebDriver driver2)
	{
		PageFactory.initElements(driver2, this);	
		driver= driver2;
		wait= new WebDriverWait(driver, 20);
	}
	

	public void openTimeTrackPage() {
		wait.until(ExpectedConditions.visibilityOf(timeTrack));
		timeTrack.click();
	}
	
	public void openTaskPage() {
		wait.until(ExpectedConditions.visibilityOf(tasks));
		tasks.click();
	}
	
	public void openReportsPage() {
		reports.click();
	}
	
	public void openUsersPage() {
		users.click();
	}
	
	public void logoutFromApplication() {
		logout.click();
	}

}
