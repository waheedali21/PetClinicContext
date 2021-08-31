
package com.petclinic.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.petclinic.base.BaseClass;
import com.petclinic.locators.HomePageLocators;

/**
 * @author WA
 *
 *         Here we are defining the actions/methods
 */

public class HomePageActions extends BaseClass {
	
	
	HomePageLocators homePageLocatorsObj;

	// class constructor
	public HomePageActions() throws Exception {

		this.homePageLocatorsObj = new HomePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.homePageLocatorsObj);
		
	}

	public String do_HomePageURLVerification() {
		return driver.getCurrentUrl();
		
	}
	
	
	
	public String do_HomePageTitleVerification() {
		return driver.getTitle();
	}

	
	
	public boolean do_ApplicationLogoVerification() {

		return homePageLocatorsObj.imgApplicationLogo.isDisplayed();
		
		
	}

}
