
package com.petclinic.testcases;

import org.testng.annotations.*;

import com.petclinic.actions.VeterinariansPageActions;
import com.petclinic.base.BaseClass;
import com.petclinic.locators.VeterinariansPageLocators;

/**
 * @author WA
 * 
 *         Here were writing test cases of Veterinarians page
 *
 */
public class VeterinariansPageTestCases extends BaseClass {

	VeterinariansPageLocators veterinariansPageLocatorsObj;
	VeterinariansPageActions veterinariansPageActionsObj;

	// class constructor
	public VeterinariansPageTestCases() throws Exception {
		super();

	}

	@BeforeMethod
	// @BeforeSuite
	public void setUp() throws Exception {
		initializeBrowser();
		// log.info("Launching the browser");
		veterinariansPageLocatorsObj = new VeterinariansPageLocators();
		veterinariansPageActionsObj = new VeterinariansPageActions();
	}

	@Test(priority = 1)
	public void do_ViewListOfVeterinariansTest() {
		String veterinariansPageListing = veterinariansPageActionsObj.do_ViewListOfVeterinarians();
		System.out.println(veterinariansPageListing);

		if (veterinariansPageListing.contains("Henry Stevens")) {
			System.out.println("veterinarians Page Listing is verified");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
