package com.tbb.testscripts.gsw;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.StartUpWizard;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.GettingStartedWizardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;

/**
 * 
 * This test script contains test method for verifying that user can cancel and resume startup wizard from same location.
 * @author Gaurav
 */
public class TestCancellingAndResumingStartUpWizardFromSameLocation extends BaseTest {
	
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
	 * This test method verifies that user can launch Start Up Wizard from different locations
	 * 
	 */
	@Test
	public void testCancellingAndResumingStartUpWizard() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Start Up Wizard' Link");
		selenium.logComment("Clicking on 'Finish later' link");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");	
		
				
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
	
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.clubuser"), ConfigFileReader.getConfigItemValue("tbb.clubpassword"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.clubuser"), ConfigFileReader.getConfigItemValue("tbb.clubpassword"));
		}
	
		
		selenium.logComment("Clicking on 'Start Up Wizard' Link");
		GettingStartedWizardPage gettingStartedWizardPage = dashboardPage.clickStartUpWizard();
		if(selenium.isTextPresent("Welcome back.")) {
			gettingStartedWizardPage.completePreviousStartedWizard();
		}
		assertTrue("Wizard not displayed", selenium.waitForTextPresent("Let's begin with your profile. Just click \"next\" to get started."), selenium);
		selenium.logComment("Clicking on 'Finish later' link");	
		selenium.click(StartUpWizard.FINISH_LATER_BUTTON);
		assertTrue("Before you go� text not displayed", selenium.waitForTextPresent("Before you go�"), selenium);
		selenium.click(StartUpWizard.CLOSE_BUTTON);
		
	
		gettingStartedWizardPage = dashboardPage.clickStartUpWizard(false);
		assertTrue("Wizard not displayed", selenium.waitForTextPresent("Let's begin with your profile. Just click \"next\" to get started."), selenium);
		selenium.logComment("Clicking on 'Finish later' link");	
		selenium.click(StartUpWizard.FINISH_LATER_BUTTON);
		assertTrue("Before you go� text not displayed", selenium.waitForTextPresent("Before you go�"), selenium);
		selenium.click(StartUpWizard.CLOSE_BUTTON);

	

		gettingStartedWizardPage = dashboardPage.clickStartUpWizard(false);
		assertTrue("Wizard not displayed", selenium.waitForTextPresent("Let's begin with your profile. Just click \"next\" to get started."), selenium);
		selenium.logComment("Clicking on 'Finish later' link");	
		selenium.click(StartUpWizard.FINISH_LATER_BUTTON);
		assertTrue("Before you go� text not displayed", selenium.waitForTextPresent("Before you go�"), selenium);
		selenium.click(StartUpWizard.CLOSE_BUTTON);
		
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}
