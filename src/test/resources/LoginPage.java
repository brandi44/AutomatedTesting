package test.resources;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

//This class inherits from the class PageObjects
public class LoginPage extends PageObjects {
	
	// Search for web elements by locator (tagName, xpath, etc) and declaring them
	@FindBy(name="userName")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginButton;
	
	
	// Get the title of the page
	public String getTitle() {
		return driver.getTitle();
	}
	
	// Constructor that calls the parent constructor
	public LoginPage(WebDriver driver) {
		super(driver);
		
		// Verifies that the page is ready and makes sure the webpage title is correct
		assertTrue(getTitle().equals("Welcome: Mercury Tours"));
		
	}
	
	// Enter the username and password for the login
	public void enterLogin(String userName, String password) {
		this.userName.clear();
		this.userName.sendKeys(userName);
		
		this.password.clear();
		this.password.sendKeys(password);
		
	}
	
	// Click on the login button and open the flight finder page
	public FlightFinderPage submit() {
		loginButton.click();
		return new FlightFinderPage(driver);
	}
}
