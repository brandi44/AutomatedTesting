package test.resources;
import org.openqa.selenium.*;

// A superclass for all the pages

import org.openqa.selenium.support.*;
public class PageObjects {
	// Declare webdriver as an attribute for this class
	protected WebDriver driver;
	
	// Initialise all of the elements on the page
	public PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
