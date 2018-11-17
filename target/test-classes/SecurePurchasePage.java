package test.resources;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import static org.junit.Assert.*;

//This class inherits from the class PageObjects
public class SecurePurchasePage extends PageObjects {
	
	// Search for web elements by locator (tagName, xpath, etc) and declaring them
	@FindBy(name="passFirst0")
	private WebElement firstName;
	
	@FindBy(name="passLast0")
	private WebElement lastName;
	
	@FindBy(name="creditnumber")
	private WebElement creditCardNumber;
	
	@FindBy(name="ticketLess")
	private WebElement ticketlessCb;
	
	@FindBy(name="buyFlights")
	private WebElement securePurchase;
	
	@FindBy(name = "fromPort")
	private WebElement fromPort;
	
	@FindBy(name="toPort")
	private WebElement toPort;
	
	@FindBy(name="servClass")
	private WebElement servClass;
	
	
	// Get the value of fromPort
	public String getFromPort() {
		return fromPort.getAttribute("value");
	}
	
	// Get the value of toPort
	public String getToPort() {
		return toPort.getAttribute("value");
	}
	
	// Get the value of servClass
	public String getServClass() {
		return servClass.getAttribute("value");
	}

	// Get the title of the page
	public String getTitle() {
		return driver.getTitle();
	}

	// Constructor that calls the parent constructor
	public SecurePurchasePage(WebDriver driver) {
		super(driver);
		
		// Verifies that the page is ready and makes sure the webpage title is correct
		assertTrue(getTitle().equals("Book a Flight: Mercury Tours"));
	}
	
	// Enter the firstname, last name, credit card number and clicks on the ticketless checkbox
	public void fillOutDetails(String fName, String lName, String creditNumber) {
		this.firstName.sendKeys(fName);
		this.lastName.sendKeys(lName);
		this.creditCardNumber.sendKeys(creditNumber);
		this.ticketlessCb.click();
	}
	
	// Click on the confirm button and opens the confirmation page
	public ConfirmationPage submit() {
		securePurchase.click();
		return new ConfirmationPage(driver);
	}
}
