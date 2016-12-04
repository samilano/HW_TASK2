package hwfrontend01;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class implements string constants and helper methods
 * @author Sasa Milanovic
 *
 */
public class Util {
	
	static WebDriver driver;
	
	public static final String PATH_TO_GECKODRIVER = "C://Selenium//geckodriver.exe";
	public static final String HOME_PAGE_URL = "http://www.hostelworld.com/";
	public static final String SEARCH_STRING = "Dublin, Ireland";
	
	
	/**
	 * This method clears the text from a given web element and enters a given string into it
	 * @param webElement a web element
	 * @param sendKeysText string to enter
	 */
	public static void enterField(WebElement webElement, String sendKeysText) {
		webElement.clear();
		webElement.sendKeys(sendKeysText);
	}
	
	/**
	 * This method clicks on a given web element
	 * @param webElement a web element
	 */
	public static void elementClick(WebElement webElement) {
		webElement.click();
	} 
	
	/**
	 * This method checks page title, comparing it with an expected title
	 * @param driver driver
	 * @param expectedTitle String with the expected title
	 */
	public static void checkPageTitle(WebDriver driver, String expectedTitle) {
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
	
	/**
	 * This method checks if the given string array is sorted alphabetically
	 * @param stringArray string array to check
	 * @return true -> if sorted; false -> if not sorted
	 */
	public static boolean isStringArraySorted(String stringArray[]) {
		boolean sorted = true;
	    for (int j = 1; j < stringArray.length; j++) {
	        if (stringArray[j-1].compareTo(stringArray[j]) > 0) {
				sorted = false;
				break;
	        }
	    }	
	    return sorted;
	}
	
	/**
	 * This method checks if given double array is sorted
	 * @param doubleArray double array to check
	 * @return true -> if sorted; false -> if not sorted
	 */
	public static boolean isDoubleArraySorted(double doubleArray[]) {
		boolean sorted = true;
	    for (int i = 1; i < doubleArray.length; i++) {
	        if (doubleArray[i] < doubleArray[i-1]) {
				sorted = false;
				break;
	        }
	    }
	    return sorted;
	}
	
	/**
	 * This method converts a string array into doubles array
	 * @param stringArray string array to convert
	 * @return converted double array
	 */
	public static double[] convertStringArrayToDouble(String stringArray[]) {
		double[] doubleArray = new double[stringArray.length];
		for (int i = 0; i<stringArray.length; i++) {
			doubleArray[i] = Double.valueOf(stringArray[i]);
		}
		return doubleArray;
	}	
}
