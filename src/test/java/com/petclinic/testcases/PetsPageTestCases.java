/**
 * 
 */
package com.petclinic.testcases;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.petclinic.actions.PetsPageActions;
import com.petclinic.base.BaseClass;
import com.petclinic.locators.OwnersPageLocators;
import com.petclinic.locators.PetsPageLocators;

/**
 * @author WA
 * 
 *         Here we are adding test cases for Pets and its Visit related
 *
 */
public class PetsPageTestCases extends BaseClass {

	PetsPageLocators petsPageLocatorsObj;
	PetsPageActions petsPageActionsObj;
	OwnersPageLocators ownersPageLocatorsObj;

	// class constructor
	public PetsPageTestCases() throws Exception {
		super();
	}

	@BeforeMethod
	// @BeforeSuite
	public void setUp() throws Exception {
		initializeBrowser();
		// log.info("Launching the browser");

		petsPageLocatorsObj = new PetsPageLocators();
		ownersPageLocatorsObj = new OwnersPageLocators();
		petsPageActionsObj = new PetsPageActions();

	}

	@Test(priority = 1)
	public void do_RedirectToNewPetPageTest() {
		petsPageActionsObj.do_RedirectToNewPetPage("Mehdi");
	}

	// Same-way here also data can be export from excel file instead of passing
	// values directly
	@Test(priority = 2)
	public void do_AddNewPetForExistingOwnerTest() {

		SoftAssert softAssert = new SoftAssert();
		String existingOwnerNameVerification = petsPageActionsObj.do_AddNewPetForExistingOwner("Zoro", "2021-01-01",
				"dog");

		softAssert.assertEquals(existingOwnerNameVerification, "Arhaan Mehdi", "Wrong owner name is provided");

		softAssert.assertAll();

	}

	@Test(priority = 3)
	public void do_RedirectToNewVisitPageTest() {
		petsPageActionsObj.do_RedirectToNewVisitPage("Mehdi");

	}

	@Test(priority = 4)
	public void do_CreateNewVistForExistingOwnerTest() {

		petsPageActionsObj.do_CreateNewVistForExistingOwner("2021-08-25", "Pet Got Sick");
	}

	@Test(priority = 5)
	public void do_PetsandVisitDetailsTest() {

		SoftAssert softAssert = new SoftAssert();
		String viewPetName = petsPageActionsObj.do_PetsandVisitDetails("Mehdi");

		softAssert.assertEquals(viewPetName, "Zoro", "Invalid pet name on visit details page");
		softAssert.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
