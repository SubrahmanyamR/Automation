package com.tbb.testscripts.watchvideos;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.WatchVideos;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.watchvideos.CelebrityTrainersPage;
import com.tbb.pages.watchvideos.CoachesPage;
import com.tbb.pages.watchvideos.ContestsPage;
import com.tbb.pages.watchvideos.EatingHealthyPage;
import com.tbb.pages.watchvideos.HealthNewsPage;
import com.tbb.pages.watchvideos.ProductsPage;
import com.tbb.pages.watchvideos.SuccessStoriesPage;
import com.tbb.pages.watchvideos.TeamBeachbodyPage;
import com.tbb.pages.watchvideos.VIPFitnessTipsPage;
import com.tbb.pages.watchvideos.VIPRecipesPage;
import com.tbb.pages.watchvideos.VIPStyleTipsPage;
import com.tbb.pages.watchvideos.VIPWorkoutsPage;
import com.tbb.pages.watchvideos.WatchVideosPage;
import com.tbb.pages.watchvideos.WorkoutTipsPage;
/**
 * 
 * This test script contains test method(s) for main 'Watch Videos' module.
 * @author Jaya
 */
public class TestWatchVideos extends BaseTest {

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
	 * Positive Test script for verifying viewing of left menu of Watch Videos Page.
	 * It verifies if all the required elements are present on the left hand side Watch Videos menu and are working correctly. 
	 */ 
	@Test
	public void testWatchVideosPageLeftMenuLinks(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Watch Videos' link");
		selenium.logComment("Verifying number of links in left side Menu");
		selenium.logComment("Verifying Links' title shown in left side Menu");
		selenium.logComment("Clicking on 'Success Stories' Link from left side menu");
		selenium.logComment("Clicking on 'Products' Link from left side menu");
		selenium.logComment("Clicking on 'Eating Healthy' Link from left side menu");
		selenium.logComment("Clicking on 'Workout Tips' Link from left side menu");
		selenium.logComment("Clicking on 'Contests' Link from left side menu");
		selenium.logComment("Clicking on 'Celebrity Trainers' Link from left side menu");
		selenium.logComment("Clicking on 'Coaches' Link from left side menu");
		selenium.logComment("Clicking on 'Health News' Link from left side menu");
		selenium.logComment("Clicking on 'Team Beachbody' Link from left side menu");
		selenium.logComment("Clicking on 'VIP Workouts' Link from left side menu");
		selenium.logComment("Clicking on 'VIP Fitness Tips' Link from left side menu");
		selenium.logComment("Clicking on 'VIP Recipes' Link from left side menu");
		selenium.logComment("Clicking on 'VIP Style Tips' Link from left side menu");
		selenium.logComment("Executing assertEmpty method");
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
		
		selenium.logComment("Clicking on 'Watch Videos' link");
		WatchVideosPage watchVideosPage = dashboardPage.clickWatchVideosLink();
		
		selenium.logComment("Verifying number of links in left side Menu");
		assertTrue("All links are not displayed", watchVideosPage.getMenuLinksCount()==13, selenium );
		
		selenium.logComment("Verifying Links' title shown in left side Menu");
		assertTrue("Expected Links are not displayed", Arrays.equals(watchVideosPage.getMenuLinksText(), new String[]{"Success Stories", "Products", "Eating Healthy", "Workout Tips", "Contests", "Celebrity Trainers", "Coaches", "Health News", "Team Beachbody", "VIP Workouts", "VIP Fitness Tips", "VIP Recipes", "VIP Style Tips"}), selenium);
		
		selenium.logComment("Clicking on 'Success Stories' Link from left side menu");
		SuccessStoriesPage successStoriesPage = watchVideosPage.goToSuccessStoriesPage();
		watchVideosPage = successStoriesPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Products' Link from left side menu");
		ProductsPage productsPage = watchVideosPage.goToProductsPage();
		watchVideosPage = productsPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Eating Healthy' Link from left side menu");
		EatingHealthyPage eatingHealthyPage = watchVideosPage.goToEatingHealthyPage();
		watchVideosPage = eatingHealthyPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Workout Tips' Link from left side menu");
		WorkoutTipsPage workoutTipsPage = watchVideosPage.goToWorkoutTipsPage();
		watchVideosPage = workoutTipsPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Contests' Link from left side menu");
		ContestsPage contestsPage = watchVideosPage.goToContestsPage();
		watchVideosPage = contestsPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Celebrity Trainers' Link from left side menu");
		CelebrityTrainersPage celebrityTrainersPage = watchVideosPage.goToCelebrityTrainersPage();
		watchVideosPage = celebrityTrainersPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Coaches' Link from left side menu");
		CoachesPage coachesPage = watchVideosPage.goToCoachesPage();
		watchVideosPage = coachesPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Health News' Link from left side menu");
		HealthNewsPage healthNewsPage = watchVideosPage.goToHealthNewsPage();
		watchVideosPage = healthNewsPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Team Beachbody' Link from left side menu");
		TeamBeachbodyPage teamBeachbodyPage = watchVideosPage.goToTeamBeachbodyPage();
		watchVideosPage = teamBeachbodyPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'VIP Workouts' Link from left side menu");
		VIPWorkoutsPage vipWorkoutsPage = watchVideosPage.goToVIPWorkoutsPage();
		watchVideosPage = vipWorkoutsPage.clickWatchVideosLink();

		selenium.logComment("Clicking on 'VIP Fitness Tips' Link from left side menu");
		VIPFitnessTipsPage vipFitnessTipsPage = watchVideosPage.goToVIPFitnessTipsPage();
		watchVideosPage = vipFitnessTipsPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'VIP Recipes' Link from left side menu");
		VIPRecipesPage vipRecipesPage = watchVideosPage.goToVIPRecipesPage();
		watchVideosPage = vipRecipesPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'VIP Style Tips' Link from left side menu");
		VIPStyleTipsPage vipStyleTipsPage = watchVideosPage.goToVIPStyleTipsPage();
		watchVideosPage = vipStyleTipsPage.clickWatchVideosLink();
				
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
		
	}
	
	/**
	 * Positive Test script for verifying viewing of Watch Videos Page.
	 * It verifies if all the required elements are present on the page. 
	 */ 
	@Test 
	public void testWatchVideosPageContent() {		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Watch Videos Page.");
		selenium.logComment("Verifying that all the required fields are present on the Watch Videos Page.");
		selenium.logComment("Verifying 'Watch Now' links in center content area");
		selenium.logComment("Clicking on 'Watch Now' link under 'Success Stories' in central content area");
		selenium.logComment("Clicking on 'Watch Now' link under 'Products' in central content area");
		selenium.logComment("Clicking on 'Watch Now' link under 'Eating Healthy' in central content area");
		selenium.logComment("Clicking on 'Watch Now' link under 'Workout Tips' in central content area");
		selenium.logComment("Clicking on 'Watch Now' link under 'Contests' in central content area");
		selenium.logComment("Clicking on 'Watch Now' link under 'Celebrity Trainers' in central content area");
		selenium.logComment("Clicking on 'Watch Now' link under 'Coaches' in central content area");
		selenium.logComment("Clicking on 'Watch Now' link under 'Celebrity Trainers' in central content area");
		selenium.logComment("Clicking on 'Watch Now' link under 'Coaches' in central content area");
		selenium.logComment("Clicking on 'Watch Now' link under 'Health News' in central content area");
		selenium.logComment("Clicking on 'Watch Now' link under 'Team Beachbody' in central content area");
		selenium.logComment("Clicking on 'Watch Now' link under 'VIP Workouts' in central content area");
		selenium.logComment("Clicking on 'Watch Now' link under 'VIP Fitness Tips' in central content area");
		selenium.logComment("Clicking on 'Watch Now' link under 'VIP Recipes' in central content area");
		selenium.logComment("Clicking on 'Watch Now' link under 'VIP Style Tips' in central content area");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		selenium.logComment("Verifying whether user is on Home page");
		HomePage homePage = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		}
		
		selenium.logComment("Navigating to Watch Videos Page.");
		WatchVideosPage watchVideosPage = dashboardPage.clickWatchVideosLink();		
		
		selenium.logComment("Verifying that all the required fields are present on the Watch Videos Page.");
		assertTrue("Expected Page header is not available", selenium.isElementPresent(WatchVideos.WATCH_VIDEOS_HEADER), selenium);
		assertTrue("Expected text header quote is not available", selenium.isElementPresent(WatchVideos.WATCH_VIDEOS_INTRO_TEXT), selenium);
		assertTrue("Expected Page header is not available", selenium.isElementPresent(WatchVideos.WATCH_VIDEOS_VIDEO), selenium);
		assertTrue("All links are not displayed", watchVideosPage.getContentBoxesCount()==13, selenium );
		assertTrue("All images are not displayed", watchVideosPage.getImageLinksCount()==13, selenium );
		assertTrue("Expected headings are not displayed", Arrays.equals(watchVideosPage.getContentLinksText(), new String[]{"Success Stories", "Products", "Eating Healthy", "Workout Tips", "Contests", "Celebrity Trainers", "Coaches", "Health News", "Team Beachbody", "VIP Workouts", "VIP Fitness Tips", "VIP Recipes", "VIP Style Tips"}), selenium);
		assertTrue("All images are not displayed", watchVideosPage.getAllTextCount()==13, selenium );
		
		selenium.logComment("Verifying 'Watch Now' links in center content area");
		assertTrue("All 'Watch Now' links are not displayed", watchVideosPage.getWatchNowLinksCount()==13, selenium );
		
		selenium.logComment("Clicking on 'Watch Now' link under 'Success Stories' in central content area");
		SuccessStoriesPage successStoriesPage = watchVideosPage.clickSuccessStoriesWatchNow();
		watchVideosPage = successStoriesPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Watch Now' link under 'Products' in central content area");
		ProductsPage productsPage = watchVideosPage.clickProductsWatchNow();
		watchVideosPage = productsPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Watch Now' link under 'Eating Healthy' in central content area");
		EatingHealthyPage eatingHealthyPage = watchVideosPage.clickEatingHealthyWatchNow();
		watchVideosPage = eatingHealthyPage.clickWatchVideosLink();
				
		selenium.logComment("Clicking on 'Watch Now' link under 'Workout Tips' in central content area");
		WorkoutTipsPage workoutTipsPage = watchVideosPage.clickWorkoutTipsWatchNow();
		watchVideosPage = workoutTipsPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Watch Now' link under 'Contests' in central content area");
		ContestsPage contestsPage = watchVideosPage.clickContestsWatchNow();
		watchVideosPage = contestsPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Watch Now' link under 'Celebrity Trainers' in central content area");
		CelebrityTrainersPage celebrityTrainersPage = watchVideosPage.clickCelebrityTrainersWatchNow();
		watchVideosPage = celebrityTrainersPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Watch Now' link under 'Coaches' in central content area");
		CoachesPage coachesPage = watchVideosPage.clickCoachesWatchNow();
		watchVideosPage = coachesPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Watch Now' link under 'Health News' in central content area");
		HealthNewsPage healthNewsPage = watchVideosPage.clickHealthNewsWatchNow();
		watchVideosPage = healthNewsPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Watch Now' link under 'Team Beachbody' in central content area");
		TeamBeachbodyPage teamBeachbodyPage = watchVideosPage.clickTeamBeachbodyWatchNow();
		watchVideosPage = teamBeachbodyPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Watch Now' link under 'VIP Workouts' in central content area");
		VIPWorkoutsPage vipWorkoutsPage = watchVideosPage.clickVIPWorkoutsWatchNow();
		watchVideosPage = vipWorkoutsPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Watch Now' link under 'VIP Fitness Tips' in central content area");
		VIPFitnessTipsPage vipFitnessTipsPage = watchVideosPage.clickVIPFitnessTipsWatchNow();
		watchVideosPage = vipFitnessTipsPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Watch Now' link under 'VIP Recipes' in central content area");
		VIPRecipesPage vipRecipesPage = watchVideosPage.clickVIPRecipesWatchNow();
		watchVideosPage = vipRecipesPage.clickWatchVideosLink();
		
		selenium.logComment("Clicking on 'Watch Now' link under 'VIP Style Tips' in central content area");
		VIPStyleTipsPage vipStyleTipsPage = watchVideosPage.clickVIPStyleTipsWatchNow();
		watchVideosPage = vipStyleTipsPage.clickWatchVideosLink();		
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}  
}
