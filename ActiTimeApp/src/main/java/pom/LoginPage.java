package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath="//input[@id='username']")
	private WebElement userName;
	
	@FindBy (xpath="//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy (xpath="//input[@id='keepLoggedInCheckBox']")
	private WebElement keepMeLoginCheckbox;
	
	@FindBy (xpath="//a[@id='loginButton']")
	private WebElement login;
	
	public LoginPage(WebDriver driver1)
	{
		PageFactory.initElements(driver1, this);	
	}
	public void sendUserName(String userID) {
		userName.sendKeys(userID);
	}
	
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void selectKeepMeLogin() {
		keepMeLoginCheckbox.click();
	}
	
	public void clickOnlogin() {
		login.click();
	}
	
	/* public void loginToApplication(){
        userName.sendKeys("admin");	 
	    password.sendKeys("manager");
	    keepMeLoginCheckbox.click();
	    login.click(); 
	 }
	 */
	
	
	

}
