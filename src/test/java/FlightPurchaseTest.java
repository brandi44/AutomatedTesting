package test.java;
//import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.resources.*;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.*;


public class FlightPurchaseTest {
	protected static WebDriver driver;
	
	@Test
	public void login() {
		// Navigate the driver to the website
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		
		// Open the login page
		LoginPage loginPage = new LoginPage(driver);
		// Enter the username and password for login
		loginPage.enterLogin("mercury", "mercury");
		// Click on the continue button, opening the flight finder page.
		FlightFinderPage flightFinderPage = loginPage.submit();
		
		
		// Check if the image title is displayed
		assertTrue(flightFinderPage.getImgTitle().isDisplayed());
		// Select the trip options
		flightFinderPage.selectTripType();
		// Click on the continue button, opening the flight results page
		FlightResultsPage flightResultsPage = flightFinderPage.submit();
		
		
		// Declare the dimensions for the form on the page
//		Dimension dimension = new Dimension(492, 496);
		// Check if the dimensions are correct
//		assertTrue(flightResultsPage.getResultsDimensions().equals(dimension));
		// Click on the continue button, opening the secure purchase page
		SecurePurchasePage securePurchasePage = flightResultsPage.submit();
		
		
		// Check if the data displayed is correct
		assertTrue(securePurchasePage.getFromPort().equals("Sydney"));
		assertTrue(securePurchasePage.getToPort().equals("London"));
		assertTrue(securePurchasePage.getServClass().equals("First"));
		// Enter first name, last name and credit card number
		securePurchasePage.fillOutDetails("John", "Smith", "0000000000000000");	
		// Click on the confirm button, opening the confirmation page
		ConfirmationPage confirmationPage = securePurchasePage.submit();
		
		
		// Check if the page source contains the text
		assertTrue(confirmationPage.getPageSource().contains("itinerary has been booked!"));
	}
	
	
	// Below this comment are the methods that handles the setup and teardown of the WebDriver
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Brandi\\Desktop\\Project\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@After
	public void cleanUp() {
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();
	}
	

}
