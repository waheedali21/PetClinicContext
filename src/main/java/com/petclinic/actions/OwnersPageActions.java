
package com.petclinic.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.petclinic.base.BaseClass;

import com.petclinic.locators.OwnersPageLocators;

/**
 * @author WA
 *
 *         Here we are defining the action/methods of OwnersPage
 */

public class OwnersPageActions extends BaseClass {

	OwnersPageLocators ownersPageLocatorsObj;

	// class constructor
	public OwnersPageActions() throws Exception {
		this.ownersPageLocatorsObj = new OwnersPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this.ownersPageLocatorsObj);

	}

	public void do_AddNewOwner(String fName, String lName, String Address, String City, String Contact) {

		ownersPageLocatorsObj.menuLinkFindOwners.click(); // click 'find-owner' from top main menu
		ownersPageLocatorsObj.btnAddOwner.click(); // click 'add-owner-button'

		// fill/add owner details
		ownersPageLocatorsObj.txtOwnerFirstName.clear();
		ownersPageLocatorsObj.txtOwnerFirstName.sendKeys(fName);

		ownersPageLocatorsObj.txtOwnerLastName.clear();
		ownersPageLocatorsObj.txtOwnerLastName.sendKeys(lName);

		ownersPageLocatorsObj.txtOwnerAddress.clear();
		ownersPageLocatorsObj.txtOwnerAddress.sendKeys(Address);

		ownersPageLocatorsObj.txtOwnerCity.clear();
		ownersPageLocatorsObj.txtOwnerCity.sendKeys(City);

		ownersPageLocatorsObj.txtOwnerTelephone.clear();
		ownersPageLocatorsObj.txtOwnerTelephone.sendKeys(Contact);

		ownersPageLocatorsObj.btnAddNewOwner.click();
	}

	// Update/modifying the existing owner details
	public void do_UpdateExistingOwnerDetails(String fName, String lName, String Address, String City, String Contact) {

		ownersPageLocatorsObj.btnEditExistingOwner.click(); // click EditOwner button

		ownersPageLocatorsObj.txtOwnerFirstName.clear();
		ownersPageLocatorsObj.txtOwnerFirstName.sendKeys(fName);

		ownersPageLocatorsObj.txtOwnerLastName.clear();
		ownersPageLocatorsObj.txtOwnerLastName.sendKeys(lName);

		ownersPageLocatorsObj.txtOwnerAddress.clear();
		ownersPageLocatorsObj.txtOwnerAddress.sendKeys(Address);

		ownersPageLocatorsObj.txtOwnerCity.clear();
		ownersPageLocatorsObj.txtOwnerCity.sendKeys(City);

		ownersPageLocatorsObj.txtOwnerTelephone.clear();
		ownersPageLocatorsObj.txtOwnerTelephone.sendKeys(Contact);

		ownersPageLocatorsObj.btnUpdateExistingOwnerDetails.click(); // click UpdateOwner button

		ownersPageLocatorsObj.menuLinkFindOwners.click();
	}

	public String do_FindOwnerByLastName(String lName) {

		ownersPageLocatorsObj.menuLinkFindOwners.click(); // click "find-owners" from top main menu

		ownersPageLocatorsObj.txtFindOwnerByLastName.clear();
		ownersPageLocatorsObj.txtFindOwnerByLastName.sendKeys(lName);

		ownersPageLocatorsObj.btnFindOwnerByLastName.click();

		return driver.getCurrentUrl();

	}

}
