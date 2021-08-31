
package com.petclinic.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author WA
 * 
 * Home page element/objects/locators
 * 
 */


public class HomePageLocators {
	
	@FindBy(xpath = "//img[@class='img-responsive']")
	public WebElement imgApplicationLogo;

}
