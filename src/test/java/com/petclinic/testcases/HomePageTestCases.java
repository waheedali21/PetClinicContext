/**
 * 
 */
package com.petclinic.testcases;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.petclinic.actions.HomePageActions;
import com.petclinic.base.BaseClass;
import com.petclinic.locators.HomePageLocators;

/**
 * @author WA
 * 
 *
 */
public class HomePageTestCases extends BaseClass {

	HomePageLocators homePageLocatorsObj;
	HomePageActions homePageActionsObj;

	// class PetsPageLocators
	public HomePageTestCases() throws Exception {
		super();

	}

	//@BeforeTest
	@BeforeMethod
	public void setUp() throws Exception {
		initializeBrowser();
		homePageLocatorsObj = new HomePageLocators();
		homePageActionsObj = new HomePageActions();
	}

	@Test(priority = 1)
	public void applicationLogoVerificationTest() {
		SoftAssert softAssert = new SoftAssert();
		Boolean appLogo = homePageActionsObj.do_ApplicationLogoVerification();
		softAssert.equals(appLogo);
		softAssert.assertAll();

	}

	@Test(priority = 2)
	public void do_HomePageURLVerificationTest() {
		SoftAssert softAssert = new SoftAssert();
		String homePageURL = homePageActionsObj.do_HomePageURLVerification();
		softAssert.assertEquals(homePageURL, "http://localhost:8080/", "Wrong url found");
		softAssert.assertAll();

	}

	@Test(priority = 3)
	public void do_HomePageTitleVerificationTest() {
		SoftAssert softAssert = new SoftAssert();
		String homePageTitle = homePageActionsObj.do_HomePageTitleVerification();
		softAssert.assertEquals(homePageTitle, "PetClinic :: a Spring Framework demonstration", "Wrong title is found");
		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
