
package com.petclinic.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author WA
 * 
 *         Here we are defining Veterinarians page locators/Objects only
 *
 */
public class VeterinariansPageLocators {

	@FindBy(xpath = "//span[normalize-space()='Veterinarians']")
	public WebElement menuLinkVeterinarians;
	
	

	@FindBy(xpath = "//div[@class='container-fluid']")
	public WebElement txtViewListOfVeterinarians;

}
