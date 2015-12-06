package com.tbb.testscripts.general;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;

/**
 * 
 * This test script contains test method(s) for verifying functionality related to Dashboard page.
 * @author Gaurav
 */

public class TestDashboardPage extends BaseTest {

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
	
	/**
	 * This test verifies Dashboard page of user after user successfully logs in.
	 * It verifies following:
	 * Display of Calender
	 * Highlighted date should be today's date
	 * Verifies scheduled workouts
	 * Verfies 'Schedule a workout' portlet is displayed
	 * Verfies default values of Programs when user selects a particular routine
	 * Verifies 'My Personalized Meal Plan' portlet is displayed
	 * "Verifying existence of 'Upgrade' link for 'Free'
	 * Verifies presence of 'Buddies' section
	 * Verifies presence of 'Most Recent Topics' section
	 * Verifies presence of 'Go to the Message Boards' link
	 * Verifies number of Right-rail modules
	 * 
	 */
	@Test
	public void testDashboardPage() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Verifying 'My Calendar' portlet is displayed");
		selenium.logComment("Getting highlighted date from 'My Calendar' and verifying against current date");
		selenium.logComment("Verifying 'Schedule a Workout' portlet is displayed");
		selenium.logComment("Verifying default values of 'Programs' when user selects a particular 'Workout'");
		selenium.logComment("Verifying 'Work out Now' button is displayed");
		selenium.logComment("Verifying 'My Personalized Meal Plan' portlet is displayed");
		selenium.logComment("Verifying existence of 'Upgrade' link for 'Free' User & exitence of 'Go to My Meal Planner' button for 'Club' User");
		selenium.logComment("Verifying presence of 'Buddies' section under 'Community' section");
		selenium.logComment("Getting number of buddies");
		selenium.logComment("Verifying presence of 'Most Recent Topics' section under 'Message Boards' section");
		selenium.logComment("Getting number of 'Most Recent Topics'");
		selenium.logComment("Verifying presence of 'Go to the Message Boards' link");
		selenium.logComment("Getting number of Right-rail modules");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
	
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		}
	
		
		selenium.logComment("Verifying 'My Calendar' portlet is displayed");
		assertTrue("'My Calendar' portlet is not displayed" , selenium.isTextPresent("My Calendar"), selenium);
		
		selenium.logComment("Getting highlighted date from 'My Calendar' and verifying against current date");
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEE");
		SimpleDateFormat DATE_FORMAT1 = new SimpleDateFormat("M/d");
		Date currentDateTime = new Date(System.currentTimeMillis());
		String newDate = DATE_FORMAT.format(currentDateTime) + "\n" + DATE_FORMAT1.format(currentDateTime);
		assertTrue("Highlighted date from 'My Calendar' is not current date", dashboardPage.getHighlightedDate().equals(newDate) , selenium);
		
		selenium.logComment("Verifying 'Schedule a Workout' portlet is displayed");
		assertTrue("'Schedule a Workout' portlet is not displayed" , selenium.isTextPresent("Schedule a Workout"), selenium);
		
		selenium.logComment("Verifying default values of 'Programs' when user selects a particular 'Workout'");
		String[] programs = dashboardPage.getPrograms();
		selenium.logComment("Available Programs :: " + Arrays.toString(programs));
			
		for(int i=0; i<programs.length; i++) {
			dashboardPage.setProgram(programs[i]);
			String[] routines = dashboardPage.getRoutines();
			// assert programs for a given workout
			selenium.logComment("Available Routines for " + programs[i] + " :: " + Arrays.toString(routines));
		}		
			
		selenium.logComment("Verifying 'Work out Now' button is displayed");
		assertTrue("'Work out Now' button is not displayed", selenium.isElementPresent(Dashboard.WORKOUT_BUTTON) , selenium);
		
		selenium.logComment("Verifying 'My Personalized Meal Plan' portlet is displayed");
		assertTrue("'My Personalized Meal Plan' portlet is not displayed", selenium.isTextPresent("My Personalized Meal Plan") , selenium);
		
		
		selenium.logComment("Verifying existence of 'Upgrade' link for 'Free' User & exitence of 'Go to My Meal Planner' button for 'Club' User");
		if(ConfigFileReader.getConfigItemValue("tbb.user.type").equals("free")) {
			assertTrue("'Upgrade to Club membership' text is not displayed", selenium.isTextPresent("Upgrade to Club membership") , selenium);
			assertTrue("'Become a Club Member' link is not displayed", selenium.isElementPresent(Dashboard.BECOME_A_CLUB_MEMBER_LINK) , selenium);
		} else if (ConfigFileReader.getConfigItemValue("tbb.user.type").equals("club")) {
			assertTrue("'Go to My Meal Planner' link is not displayed", selenium.isElementPresent(Dashboard.GO_TO_MY_MEAL_PLANNER) , selenium);
			assertTrue("'Change my meal plan' link is not displayed", selenium.isElementPresent(Dashboard.CHANGE_MY_MEAL_PLAN_LINK) , selenium);
		}
		
		selenium.logComment("Verifying presence of 'Buddies' section under 'Community' section");
		assertTrue("'Community' section is not displayed", selenium.isTextPresent("Community") , selenium);
		assertTrue("'Buddies' section is not displayed", selenium.isTextPresent("Buddies") , selenium);
					
		selenium.logComment("Getting number of buddies");
		int buddiesCount = dashboardPage.getBuddiesCount();
		assertTrue("Number of buddies do not match expected value", buddiesCount > 0, selenium);
		
		selenium.logComment("Verifying presence of 'Most Recent Topics' section under 'Message Boards' section");
		assertTrue("'Message Boards' section is not displayed", selenium.isTextPresent("Message Boards") , selenium);
		assertTrue("'Most Recent Topics' section is not displayed", selenium.isTextPresent("Most Recent Topics") , selenium);
		
		selenium.logComment("Getting number of 'Most Recent Topics'");
		int recentMessagesCount = dashboardPage.getRecentMessagesCount();
		assertTrue("Number of Recent Mesages do not match expected value", recentMessagesCount == 4, selenium);
		
		selenium.logComment("Verifying presence of 'Go to the Message Boards' link");
		assertTrue("'Go to the Message Boards' link is not displayed", selenium.isElementPresent(Dashboard.GO_TO_MESSAGE_BOARD_LINK) , selenium);
	
		selenium.logComment("Getting number of Right-rail modules");
		int rightRailModulesCount = dashboardPage.getRightRailModulesCount();
		assertTrue("Number of Right-rail modules do not match expected value", rightRailModulesCount == 3, selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();	
	}
}
