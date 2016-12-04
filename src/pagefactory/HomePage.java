package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hwfrontend01.Util;


/**
 * This class handles home page web elements and actions on them
 * @author Sasa Milanovic
 *
 */
public class HomePage {

	WebDriver driver;
	String expectedTitle = "Hostels Worldwide - Online Hostel Bookings, Ratings and Reviews";
	
	//Identify all needed elements by @FindBy annotation
	@FindBy(id="home-search-keywords")
	WebElement textSearhcBox;
	@FindBy(linkText="Dublin, Ireland")
	WebElement dublinSelection;
	@FindBy(css="button.radius.orange_button")
	WebElement searchButton;
	
	/**
	 * Initializes the driver and the web elements
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method calls checkPageTitle method from Util class in order to check home page title 
	 */
	public void checkHomePageTitle() {
		Util.checkPageTitle(driver, expectedTitle);
	} 
	
	/**
	 * This method calls enterField method from Util class in order to enter a search string into web element 
	 * @param searchString search string
	 */
	public void enterSearchString(String searchString) {
		Util.enterField(textSearhcBox, searchString);
	}
	
	/**
	 * This method calls elementClick method from Util class in order to click on Search button
	 */
	public void clickSearchButton() {
		Util.elementClick(searchButton);
	}

	/**
	 * This method calls elementClick method from Util class in order to click on "Dublin, Ireland" from a drop down
	 */
	public void selectDublinIreland() {
		Util.elementClick(dublinSelection);
	}
}
