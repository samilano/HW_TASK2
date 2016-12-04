# HW_TASK2
Hotelworld - Task 2


****************************************************************************
                              PREREQUISITES
****************************************************************************
For this tests I was using Selenium 3.0 beta2. 

This version of Selenium requires a path to geckodriver.exe to be set in order to use Firefox browser.
For this I'm using:
System.setProperty("webdriver.firefox.marionette", Util.PATH_TO_GECKODRIVER);

So, for you, to run this you need to update Util class (in hwfrontend01 package) and set string PATH_TO_GECKODRIVER to geckodriver.exe path on your computer.
I.e. -> public static final String PATH_TO_GECKODRIVER = "C://Selenium//geckodriver.exe";



****************************************************************************
                              TASK
****************************************************************************
Use case 1: User Searches for Available properties in ‘Dublin, Ireland’ on the Hostelworld
Site and sorts the results by Name
User Journey: The user goes to www.hostelworld.com and from here (the home page)
searches for “Dublin, Ireland” using the predictive text search1 box and clicks the search
button.
Once their search is submitted they will be brought to the Property results page where
they sort the properties displayed by Name.
Requirement: Using Webdriver implement the user journey and ensure that once sorted,
the properties are displayed in alphabetical order. 

Use case 2: User Searches for Available properties in ‘Dublin, Ireland’ by Price
User Journey: The user goes to www.hostelworld.com and from here (the home page)
searches for “Dublin, Ireland” using the predictive text search1 box and clicks the search
button.
Once their search is submitted they will be brought to the Property results page where
they sort the properties displayed by Price.
Requirement: Using Webdriver implement the user journey and ensure that once sorted,
the properties are displayed by Price.
