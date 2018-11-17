package test.resources;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

//This class inherits from the class PageObjects
public class FlightResultsPage extends PageObjects {
	
	// Search for web elements by locator (tagName, xpath, etc) and declaring them
	@FindBy(name="reserveFlights")
	private WebElement reserveFlightBtn;
	
	@FindBy(name="results")
	private WebElement results;
	
	// Gets the dimensions of the form
	public Dimension getResultsDimensions(){
		return results.getSize();
	}
	
	// Gets the title of the page
	public String getTitle() {
		return driver.getTitle();
	}
	
	// Constructor that calls the parent constructor
	FlightResultsPage(WebDriver driver){
		super(driver);
		
		// Verifies that the page is ready and makes sure the webpage title is correct
		assertTrue(getTitle().equals("Select a Flight: Mercury Tours"));
	}
	
	// Click on the secure purchase button and open the secure purchase page
	public SecurePurchasePage submit() {
		reserveFlightBtn.click();
		return new SecurePurchasePage(driver);
	}
}
