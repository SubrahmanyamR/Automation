package com.tbb.testscripts.connect;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.connect.ChatRoomsPage;
import com.tbb.pages.connect.ConnectPage;
import com.tbb.pages.connect.PublicChatPage;
import com.tbb.pages.connect.VIPChatPage;

/**
 * 
 * This test script contains test method(s) for Chat Rooms page under Connect module
 * @author Gaurav
 */
public class TestChatRooms extends BaseTest {

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
	 * This test verifies accessibility of all chat room pages viz. VIP Chat page and Public Chat page.
	 */
	@Test
	public void testChatRoomsPage() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Connect' tab");
		selenium.logComment("Clicking on 'Connect' tab");
		selenium.logComment("Clicking 'Chat Rooms' link");
		selenium.logComment("Verifying UI of Page");
		selenium.logComment("Navigating to VIP Chat Page");
		selenium.logComment("Navigating to Connect page");
		selenium.logComment("Clicking 'Chat Rooms' link");
		selenium.logComment("Navigating to Public Chat Page");
		selenium.logComment("Navigating to Connect page");
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
		
		selenium.logComment("Clicking on 'Connect' tab");
		ConnectPage connectPage = dashboardPage.clickConnectLink();
		
		selenium.logComment("Clicking 'Chat Rooms' link");
		ChatRoomsPage chatRoomsPage = connectPage.clickChatRoomsLearnMore();
		
		selenium.logComment("Verifying UI of Page");
		chatRoomsPage.verifyUI();
		
		selenium.logComment("Navigating to VIP Chat Page");
		VIPChatPage vipChatPage = chatRoomsPage.goToVIPChatPage();
		
		selenium.logComment("Navigating to Connect page");
		connectPage = vipChatPage.clickConnectLink();
	
		selenium.logComment("Clicking 'Chat Rooms' link");
		chatRoomsPage = connectPage.clickChatRoomsLearnMore();
		
		selenium.logComment("Navigating to Public Chat Page");
		PublicChatPage publicChatPage = chatRoomsPage.goToPublicChatPage();
		
		selenium.logComment("Navigating to Connect page");
		connectPage = publicChatPage.clickConnectLink();
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}
