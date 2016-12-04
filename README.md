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
