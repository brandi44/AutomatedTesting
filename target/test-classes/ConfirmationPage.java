package test.resources;
import org.openqa.selenium.*;
import static org.junit.Assert.*;

//This class inherits from the class PageObjects
public class ConfirmationPage extends PageObjects {
	
	// Get the title of the page
	public String getTitle() {
		return driver.getTitle();
	}
	
	// Get the source of the page to check for containing text
	public String getPageSource() {
		return driver.getPageSource();
	}
	
	// Constructor that calls the parent constructor	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		
		// Verifies that the page is ready and makes sure the webpage title is correct
		assertTrue(getTitle().equals("Flight Confirmation: Mercury Tours"));
	}
}
