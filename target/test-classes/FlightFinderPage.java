package test.resources;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import static org.junit.Assert.assertTrue;


// This class inherits from the class PageObjects
public class FlightFinderPage extends PageObjects {

	// Search for web elements by locator (tagName, xpath, etc) and declaring them
	@FindBy(xpath = ("//input[@name='tripType' and @value='oneway']"))
	private WebElement tripTypeOneWay;
	
	@FindBy(xpath = ("//select[@name='fromPort']/option[@value='Sydney']"))
	private WebElement departLocationSydney;
	
	@FindBy(xpath = ("//select[@name='toPort']/option[@value='London']"))
	private WebElement arriveLocationLondon;
	
	@FindBy(xpath = ("//input[@name='servClass' and @value='First']"))
	private WebElement classTypeFirst;
	
	@FindBy(name="findFlights")
	private WebElement continueBtn;
	
	@FindBy(name="findFlight")
	private WebElement findFlightForm;
	
	@FindBy(xpath = ("//img[contains(@src, '/images/masts/mast_flightfinder.gif')]"))
	private WebElement imgTitle;
	
	// Constructor that calls the parent constructor
	FlightFinderPage(WebDriver driver){
		super(driver);
		
		// Verifies that the page is ready and makes sure the webpage title is correct
		assertTrue(getTitle().equals("Find a Flight: Mercury Tours:"));
	}

	
	// Get the dimensions of the form on this page
	public Dimension formSize() {
		return findFlightForm.getSize();
	}
	
	// Get the title of the page
	public String getTitle() {
		return driver.getTitle();
	}
	
	// Get the title image
	public WebElement getImgTitle() {
		return imgTitle;
	}
	
	// Select the trip options
	public void selectTripType() {
		this.tripTypeOneWay.click();
		this.departLocationSydney.click();
		this.arriveLocationLondon.click();
		this.classTypeFirst.click();

	}
	
	
	// Click on the continue button in the current page and open the flight results page
	public FlightResultsPage submit() {
		continueBtn.click();
		return new FlightResultsPage(driver);
	}
	
	
	
	
	
}
