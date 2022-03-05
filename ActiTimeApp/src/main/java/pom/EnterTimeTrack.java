package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrack {
	@FindBy (xpath="//span[text()='New']")
	private WebElement newTask;
	
	@FindBy (xpath="//span[@id='ext-gen10']")
	private WebElement customersProjects;
	
	@FindBy (xpath="//input[@id='tasksFilterSubmitButton']")
	private WebElement filter;
	
	public EnterTimeTrack(WebDriver driver2)
	{
		PageFactory.initElements(driver2, this);	
	}
	
	public void createNewTasks() {
		newTask.click();
	}
	
	public void selectCustomersProjects() {
		customersProjects.click();
	}
	
	public void applyFilters() {
		filter.click();
		
	}

}
