package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hwfrontend01.Util;


/**
 * This class handles search results page web elements and actions on them
 * @author Sasa Milanovic
 *
 */
public class DublinResultsPage {
	
	WebDriver driver;
	String expectedTitle = "Hostels in Dublin | Book Dublin Hostel Online at Hostelworld.com";
	
	//Identify all needed elements by @FindBy annotation
	@FindBy(css="dd.topfilter.rounded.sort-button")
	WebElement sortButton;
	@FindBy(id="sortByName")
	WebElement sortByName;
	@FindBy(id="sortByPrice")
	WebElement sortByPrice;
	
	/**
	 * Initializes the driver and the web elements
	 * @param driver
	 */
	public DublinResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method calls checkPageTitle method from Util class in order to check search results page title 
	 */
	public void checkDublinResultsPageePageTitle() {
		Util.checkPageTitle(driver, expectedTitle);
	}
	
	/**
	 * This method calls elementClick method from Util class in order to click on a sort button
	 */
	public void clickSortButton() {
		Util.elementClick(sortButton);
	}
	
	/**
	 * This method calls elementClick method from Util class in order to click on sort by name
	 */
	public void clickSortByName() {	
		Util.elementClick(sortByName);
	}
	
	/**
	 * This method calls elementClick method from Util class in order to click on sort by price
	 */
	public void clickSortByPrice() {	
		Util.elementClick(sortByPrice);
	}
	
	/**
	 * This method gets all web elements representing property into a list of web elements,
	 * then stores names of all of them into a string array.
	 * Method isStringArraySorted from Util class is then called to check if that string array is sorted
	 * @return true -> if sorted by name; false -> if not sorted by name
	 */
	public boolean isItSortedByName() {
		List<WebElement> propertyElements = driver.findElements(By.xpath("/html/body/div[1]/div/div/div[15]/div[7]/div[1]/div[3]/div[*]/div[1]/h2/a"));
		String[] propertyNames = new String[propertyElements.size()];
		
		int i = 0;
	    for (WebElement e : propertyElements) {
	    	propertyNames[i] = e.getText();
	        i++;
	    }
	    
	    return Util.isStringArraySorted(propertyNames);
	}
	
	/**
	 * This method gets all web elements representing property into a list of web elements,
	 * then stores their prices into a string array, at the same time removing alphabetical characters representing currency (leaving just the numbers and decimal ".").
	 * Method convertStringArrayToDouble from Util class is then called to convert string array into double array, so we can check if those double numbers are sorted.
	 * Method isDoubleArraySorted from Util class is then called to check if that double array is sorted.
	 * @return true -> if sorted by price; false -> if not sorted by price
	 */
	public boolean isItSortedByPrice() {
		List<WebElement> propertyElementsPrice = driver.findElements(By.xpath("/html/body/div[1]/div/div/div[15]/div[7]/div[1]/div[3]/div[*]/div[4]/ul[2]/li[1]/span/a"));																  
		String[] propertyPrice = new String[propertyElementsPrice.size()];
			
		int i = 0;
	    for (WebElement e : propertyElementsPrice) {
	    	propertyPrice[i] = e.getText();
	    	//remove characters representing currency - only thing left should be numerics and a dot
	    	propertyPrice[i] = propertyPrice[i].replaceAll("[^\\d.]", "");
	        i++;
	    }
	    
	    double[] priceDouble = Util.convertStringArrayToDouble(propertyPrice);   
	    return Util.isDoubleArraySorted(priceDouble);	    
	}
	
	
}
