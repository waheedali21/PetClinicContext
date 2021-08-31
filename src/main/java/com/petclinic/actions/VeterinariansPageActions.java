
package com.petclinic.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.petclinic.base.BaseClass;
import com.petclinic.locators.VeterinariansPageLocators;

/**
 * @author WA
 * 
 *         Here we are defining all the Actions of VeterinariansPage class
 *
 */
public class VeterinariansPageActions extends BaseClass {

	VeterinariansPageLocators veterinariansPageLocatorsObj;
	

	// class constructor
	public VeterinariansPageActions() throws Exception {
		this.veterinariansPageLocatorsObj = new VeterinariansPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this.veterinariansPageLocatorsObj);

	}

	
	public String do_ViewListOfVeterinarians() {
		veterinariansPageLocatorsObj.menuLinkVeterinarians.click(); // click veterinarians link from top main menu
		String veterinariansListing = veterinariansPageLocatorsObj.txtViewListOfVeterinarians.getText(); //getting/view all the list of veterinarians  

		return veterinariansListing;

	}

}
