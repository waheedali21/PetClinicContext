
package com.petclinic.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.petclinic.actions.OwnersPageActions;
import com.petclinic.base.BaseClass;
import com.petclinic.locators.OwnersPageLocators;

/**
 * @author WA Test cases for Adding new owners page
 */

public class OwnersPageTestCases extends BaseClass {

	Logger log = Logger.getLogger(OwnersPageTestCases.class); 

	OwnersPageLocators ownersPageLocatorsObj;
	OwnersPageActions OwnersPageActionsObj; 
	 

	// class constructor
	public OwnersPageTestCases() throws Exception {  
		super();
	}

	
	 @BeforeTest
	public void setUp() throws Exception { 
		initializeBrowser();
		//log.info("Launching the browser");
		ownersPageLocatorsObj = new OwnersPageLocators();
		OwnersPageActionsObj = new OwnersPageActions();
		
	}
	
	
	//Add new owner 'DataProvider'
	@DataProvider(name ="do_OwnerData")
	public Object[][] do_EnterOnwerData(){

		int rowCount = excelDataConfigObj.getRowCount(0); // Here 0 is sheet# for getting all Rows
		int columnCount = excelDataConfigObj.getRowColumnCount(0); // Here 0 is sheet# for getting all Columns

		String[][] data = new String[rowCount][columnCount];
		System.out.println("Rows=>" + rowCount + ", Columns=>" + columnCount); 

		// without sheet Heading columns
		for (int x = 0; x < rowCount; x++) {
			for (int y = 0; y < columnCount; y++) {
				data[x][y] = excelDataConfigObj.getData(0, x, y);
			}
		}
		return data;		
	}
	
	
	
	@Test(priority = 1, dataProvider = "do_OwnerData")
	public void do_AddNewOwnerTest(String fName, String lName, String Address, String City, String Contact) {

		OwnersPageActionsObj.do_AddNewOwner(fName, lName, Address, City, Contact);
		
	}
	
	@Test(priority = 2)
	public void do_UpdateExistingOwnerDetailsTest() throws Exception {
		
		OwnersPageActionsObj.do_UpdateExistingOwnerDetails("Arhaan" , "Mehdi", "Dubai UAE" , "Dubai", "0544055667");
	}
	
	@Test(priority = 3)
	public void do_FindOwnerByLastNameTest() {
		
		SoftAssert softAssert = new SoftAssert();
		String ownerPageURL = OwnersPageActionsObj.do_FindOwnerByLastName("Mehdi");
		softAssert.assertEquals(ownerPageURL, "http://localhost:8080/owners?lastName=Mehdi", "Wrong url is found"); //Get the url of owner which found by last Name
		softAssert.assertAll();
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
