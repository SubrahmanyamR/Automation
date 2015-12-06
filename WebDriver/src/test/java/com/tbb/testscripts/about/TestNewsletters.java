package com.tbb.testscripts.about;

import java.lang.reflect.Method;
import java.util.Calendar;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.AboutNewsletters;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.about.AboutPage;
import com.tbb.pages.about.NewslettersPage;

/**
 * 
 * This test script contains test method(s) for News Letter page under About module
 * @author Jaya
 */
public class TestNewsletters extends BaseTest{

	@BeforeClass
	public void setUp() {
		startSeleniumServer();		
	}

	@BeforeMethod
	public void setUp(Method method) {
		createSeleniumInstance(method);		
	}

	@AfterMethod
	public void stopSelenium() {
		stopSeleniumInstance();
	}	

	@AfterClass
	public void tearDown() {		
		stopSeleniumServer();
	}

	/***
	 * This is data provider for testViewNewsletters Test Script.
	 */ 
	@DataProvider(name = "viewNewslettersDataProvider")
	public Object[][] createAboutNewslettersData() {
		return new Object[][] {
				{"January", "Team Beachbody Unsubscribe"},
		};
	}
	
	/**
	 * Positive Test script for verifying viewing of Newsletters Page.
	 * It verifies if all the required elements are present on the page.  
	 */ 
	@Test  (dataProvider = "viewNewslettersDataProvider")
	public void testViewNewsletters(String month, String unsubscriptionPageHeader){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifies whether are on Home page");
		selenium.logComment("Clicks on 'Sign In' Link.");
		selenium.logComment("Enters valid username and password");
		selenium.logComment("Clicks on 'About' link");
		selenium.logComment("Clicks on 'Newsletters' link");
		selenium.logComment("Verifies that all the required elements are available at the top of Newsletters Page.");
		selenium.logComment("Verifies that all the required elements of featured current issue are available on the Newsletters Page.");
		selenium.logComment("Verifies clicking and viewing the featured issue.");
		selenium.logComment("Navigates back to Newsletters page.");
		selenium.logComment("Verifies that all the years tabs are available on Newsletters page.");
		selenium.logComment("Gets the current year from the system and defining the number of year tabs.");
		selenium.logComment("Verifies that the current year tab is selected by default.");
		selenium.logComment("Selects a month from the drop down to filter the results displayed.");
		selenium.logComment("Verifies that selected month filtered results are displayed.");
		selenium.logComment("Verifies that all the required elements are available on different tabs for different years.");
		selenium.logComment("Verifies that 'Email Unsubscribe' link is available at the bottom of the page.");
		selenium.logComment("Executes assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		}

		selenium.logComment("Clicking on 'About' link");
		AboutPage aboutPage = dashboardPage.clickAboutLink();

		selenium.logComment("Clicking on 'Newsletters' link");
		NewslettersPage newslettersPage = aboutPage.goToNewslettersPage();

		selenium.logComment("Verifying that all the required elements are available at the top of Newsletters Page.");
		assertTrue("Expected Header is not available", selenium.isElementPresent(AboutNewsletters.NEWSLETTERS_HEADER), selenium);
		assertTrue("Expected introductory text is not available", selenium.isElementPresent(AboutNewsletters.NEWSLETTERS_INTRO_TEXT), selenium);
		assertTrue("Expected introductory image is not available", selenium.isElementPresent(AboutNewsletters.NEWSLETTERS_IMAGE), selenium);

		selenium.logComment("Verifying that all the required elements of featured current issue are available on the Newsletters Page.");
		assertTrue("Expected Featured Issue Title is not available", selenium.isElementPresent(AboutNewsletters.FEATURED_ISSUE_TITLE), selenium);
		assertTrue("Expected Featured Issue image is not available", selenium.isElementPresent(AboutNewsletters.FEATURED_ISSUE_IMAGE), selenium);
		assertTrue("Expected Featured issue tag is not available", selenium.isElementPresent(AboutNewsletters.FEATURED_ISSUE_TAG), selenium);
		assertTrue("Expected featured issue text rows are not available", selenium.isElementPresent(AboutNewsletters.ALL_FEATURED_ISSUE_TEXT_ROWS), selenium);
		
		selenium.logComment("Verifying clicking and viewing the featured issue.");
		if(selenium.isElementPresent(AboutNewsletters.FEATURED_ISSUE_TITLE)==true){
			String featuredIssueTitle = newslettersPage.getFeaturedIssueTitle(); 
			newslettersPage.viewFeaturedIssue();
			assertTrue("Expected featured issue text is not available", selenium.isElementPresent("css=div.title:contains("+featuredIssueTitle+")"), selenium);
		}
		
		selenium.logComment("Navigating back to Newsletters page.");
		aboutPage = newslettersPage.clickAboutLink();
		newslettersPage = aboutPage.goToNewslettersPage();
		
		selenium.logComment("Verifying that all the years tabs are available on Newsletters page.");
		assertTrue("Expected All years tabs are not available", selenium.isElementPresent(AboutNewsletters.ALL_YEAR_TABS), selenium);
		
		selenium.logComment("Getting the current year from the system and defining the number of year tabs.");
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int numberOfYearTabs=year-5;
		
		selenium.logComment("Verifying that the current year tab is selected by default.");
		assertTrue("Current year is not selected.", selenium.isElementPresent("css=['div.newsletter-year selected']:contains("+year+")"), selenium);
		
		selenium.logComment("Selecting a month from the drop down to filter the results displayed.");
		newslettersPage.filterByMonth(month);
		
		selenium.logComment("Verifying that selected month filtered results are displayed.");
		assertTrue("Selected month is not mentioned in filter results.", selenium.isElementPresent("css=div.content div[class='issue-tag']:contains("+month+")"), selenium);
		
		selenium.logComment("Verifying that all the required elements are available on different tabs for different years.");
		for(year--;year>numberOfYearTabs;year--){
			newslettersPage.selectYear(year);
			assertTrue("Expected drop down is not available", selenium.isElementPresent(AboutNewsletters.FILTER_BY_MONTH_DROPDOWN), selenium);
			assertTrue("Expected month name header rows are not available", selenium.isElementPresent(AboutNewsletters.ALL_NEWSLETTER_MONTH_HEADER_ROWS), selenium);		
			assertTrue("Expected content rows are not available", selenium.isElementPresent(AboutNewsletters.ALL_CONTENT_ROWS), selenium);
		}

		selenium.logComment("Verifying that 'Email Unsubscribe' link is available at the bottom of the page.");
		assertTrue("Expected unsubscribe email link is not available", selenium.isElementPresent(AboutNewsletters.EMAIL_UNSUBSCRIBE_LINK), selenium);
				
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}