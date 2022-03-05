package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenTasks {
	@FindBy (xpath="(//span[text()='Create Tasks'])[2]")
	private WebElement newTask;
	
	@FindBy (xpath="//span[@id='ext-gen10']")
	private WebElement dateButton;
	
	@FindBy (xpath="//input[@id='SubmitTTButton']")
	private WebElement saveChanges;
	
	public OpenTasks(WebDriver driver123)
	{
		PageFactory.initElements(driver123, this);	
	}
	
	public void createNewTasks() {
		newTask.click();
	}
	
	public void setDate() {
		dateButton.click();
	}
	
	public void makeSaveChanges() {
		saveChanges.click();
	}

}
