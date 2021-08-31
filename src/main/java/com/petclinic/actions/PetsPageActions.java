
package com.petclinic.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.petclinic.base.BaseClass;
import com.petclinic.locators.OwnersPageLocators;
import com.petclinic.locators.PetsPageLocators;

/**
 * @author WA
 * 
 *         Here we will define all the actions for Pets adding and pet's visit
 *         related
 */

public class PetsPageActions extends BaseClass {

	PetsPageLocators petsPageLocatorsObj;
	OwnersPageLocators ownersPageLocatorsObj;

	// class constructor
	public PetsPageActions() throws Exception {
		this.petsPageLocatorsObj = new PetsPageLocators();
		this.ownersPageLocatorsObj = new OwnersPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this.petsPageLocatorsObj);
		PageFactory.initElements(factory, this.ownersPageLocatorsObj);
	}

	public void do_RedirectToNewPetPage(String ownerLastName) {

		ownersPageLocatorsObj.menuLinkFindOwners.click(); // click 'Find Owners' from top main menu
		ownersPageLocatorsObj.txtFindOwnerByLastName.sendKeys(ownerLastName); // enter last name for exist owner
		ownersPageLocatorsObj.btnFindOwnerByLastName.click();
		petsPageLocatorsObj.linkExistingOwnerName.click(); // click existing owner name after search
		petsPageLocatorsObj.btnAddNewPet.click(); // click 'add new pet' button for existing owner

		// String existingOwnerName =
		// petsPageLocatorsObj.txtExisitngOwnerName.getText();

	}

	// Adding new pet for existing owner
	public String do_AddNewPetForExistingOwner(String petName, String petDOB, String petType) {

		String existingOwnerName = petsPageLocatorsObj.txtExisitngOwnerName.getText();
		// petsPageLocatorsObj.txtPetName.sendKeys(petName);

		enterValue(petsPageLocatorsObj.txtPetName, petName);

		// petsPageLocatorsObj.txtPetBirthDate.sendKeys(petDOB);
		enterValue(petsPageLocatorsObj.txtPetBirthDate, petDOB);

		// petsPageLocatorsObj.ddPetType.sendKeys(petType);
		selectElement(petsPageLocatorsObj.ddPetType, petType);

		clickElement(petsPageLocatorsObj.btnAddPet);

		return existingOwnerName;
	}

	public void do_RedirectToNewVisitPage(String ownerLastName) {

		clickElement(ownersPageLocatorsObj.menuLinkFindOwners); // click 'Find Owners' from top main menu
		enterValue(ownersPageLocatorsObj.txtFindOwnerByLastName, ownerLastName);// enter last name for exist owner
		clickElement(ownersPageLocatorsObj.btnFindOwnerByLastName); // ownersPageLocatorsObj.btnFindOwnerByLastName.click();
		clickElement(petsPageLocatorsObj.linkExistingOwnerName); // click existing owner name after search
		clickElement(petsPageLocatorsObj.linkAddVisit);// Click "add visit" link

	}

	// Adding New visit of pet
	public void do_CreateNewVistForExistingOwner(String petDOB, String petDescription) {
		petsPageLocatorsObj.txtVisitDate.clear();
		enterValue(petsPageLocatorsObj.txtVisitDate, petDOB);
		enterValue(petsPageLocatorsObj.txtVisitDescription, petDescription);
		clickElement(petsPageLocatorsObj.btnAddVisit);

	}

	// Pets & Visit Details
	public String do_PetsandVisitDetails(String ownerLastName) {
		clickElement(ownersPageLocatorsObj.menuLinkFindOwners);
		enterValue(ownersPageLocatorsObj.txtFindOwnerByLastName, ownerLastName);
		clickElement(ownersPageLocatorsObj.btnFindOwnerByLastName);
		clickElement(petsPageLocatorsObj.linkExistingOwnerName);

		return petsPageLocatorsObj.viewPetName.getText();

	}

}
