
package com.petclinic.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author WA
 * 
 *         Here we are defining object/locators of Owner page
 * 
 */
public class OwnersPageLocators { 

	@FindBy(xpath = "//span[normalize-space()='Find owners']")
	public WebElement menuLinkFindOwners;

	// @FindBy(xpath = "//a[normalize-space()='Add Owner']")
	@FindBy(xpath = "//a[contains(text(), 'Add Owner')]")
	public WebElement btnAddOwner;

	// Add new owner locators/objects
	@FindBy(css = "#firstName")
	public WebElement txtOwnerFirstName;

	@FindBy(name = "lastName")
	public WebElement txtOwnerLastName;

	@FindBy(xpath = "//input[@id='address' and @name='address']")
	public WebElement txtOwnerAddress;

	@FindBy(id = "city")
	public WebElement txtOwnerCity;

	@FindBy(id = "telephone")
	public WebElement txtOwnerTelephone;

	@FindBy(xpath = "//button[contains(text(),'Add Owner')]")
	public WebElement btnAddNewOwner;

	// Edit existing owner locators
	//@FindBy(xpath = "//a[contains(text(),'Edit')]")
    @FindBy(xpath = "//a[normalize-space()='Edit Owner']")
	public WebElement btnEditExistingOwner;

	@FindBy(xpath = "//button[normalize-space()='Update Owner']")
	public WebElement btnUpdateExistingOwnerDetails;
	
	

	// Find owners locators
	@FindBy(xpath = "//input[@id='lastName']") 
	public WebElement txtFindOwnerByLastName;
	
	@FindBy(xpath = "//button[contains(text(),'Find')]")
	public WebElement btnFindOwnerByLastName;


}

