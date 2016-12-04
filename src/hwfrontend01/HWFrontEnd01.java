package hwfrontend01;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import hwfrontend01.Util;
import pagefactory.HomePage;
import pagefactory.DublinResultsPage;


/**
 * This class implements 2 TestNG tests:
 * 1. hostelWorldTestNameSort - checking if the results are really sorted alphabetically after sort by name is clicked
 * 
 * 2. hostelWorldTestPriceSort - checking if the results are really sorted by price after sort by price is clicked
 * 
 * @author Sasa Milanovic
 *
 */
public class HWFrontEnd01 {
	
	WebDriver driver;
	
	HomePage objHomePage;
	DublinResultsPage objDublinResultsPage;
	
	
	/**
	 * This method provides the test for case when www.hostelworld.com is opened.
	 * First page title is checked, then a search string (defined in Util class, in SEARCH_STRING string)
	 * is entered in predictive search box, "Dublin, Ireland" is clicked from a given drop down 
	 * and Search button is clicked. After that it checks for the search results page title, then 
	 * button sort is clicked and name is selected to sort by name, after that it asserts that it's sorted alphabetically
	 */
	@Test
	public void hostelWorldTestNameSort() {
			
		objHomePage = new HomePage(driver);
		objHomePage.checkHomePageTitle();
		objHomePage.enterSearchString(Util.SEARCH_STRING);
		objHomePage.selectDublinIreland();
		objHomePage.clickSearchButton();
		
		objDublinResultsPage = new DublinResultsPage(driver);
		objDublinResultsPage.checkDublinResultsPageePageTitle();
		objDublinResultsPage.clickSortButton();
		objDublinResultsPage.clickSortByName();
		
		Assert.assertEquals(true, objDublinResultsPage.isItSortedByName());		
	}
	
	
	/**
	 * This method provides the test for case when www.hostelworld.com is opened,
	 * first page title is checked, then a search string (defined in Util class, in SEARCH_STRING string)
	 * is entered in predictive search box, "Dublin, Ireland" is clicked from a given drop down 
	 * and Search button is clicked. After that it checks for the search results page title, then 
	 * button sort is clicked and price is selected, after that it asserts that it's sorted by price
	 */
	@Test
	public void hostelWorldTestPriceSort() {
			
		objHomePage = new HomePage(driver);
		objHomePage.checkHomePageTitle();
		objHomePage.enterSearchString(Util.SEARCH_STRING);
		objHomePage.selectDublinIreland();
		objHomePage.clickSearchButton();
		
		objDublinResultsPage = new DublinResultsPage(driver);
		objDublinResultsPage.checkDublinResultsPageePageTitle();
		objDublinResultsPage.clickSortButton();
		objDublinResultsPage.clickSortByPrice();
		
		Assert.assertEquals(true, objDublinResultsPage.isItSortedByPrice());		
	}
	
	 
	/**
	 * This is a TestNG Before Method. 
	 * It sets a path to geckodriver.exe (defined in Util class in PATH_TO_GECKODRIVER string), 
	 * initializes a FireFox driver, sets a timeout and 
	 * makes a browser open a page defined in Util class in HOME_PAGE_URL string
	 */
	@BeforeMethod
	public void beforeMethod() {
		//System.setProperty("webdriver.chrome.driver", "C://Selenium//Chrome//chromedriver.exe");
		//driver = new ChromeDriver();
		System.setProperty("webdriver.firefox.marionette", Util.PATH_TO_GECKODRIVER);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Util.HOME_PAGE_URL);
  }
    
	/**
	 * This is a TestNG After Method. It closes a browser session and quits the driver
	 */
	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
  }

}
