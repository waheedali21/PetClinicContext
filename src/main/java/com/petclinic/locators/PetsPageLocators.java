/**
 * 
 */
package com.petclinic.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author WA
 * 
 * Here we are defining all the Objects/Locators for Pets and its visit related
 *
 */


public class PetsPageLocators {
		
	//Add pet related objects/locators
	@FindBy(xpath = "//table[@id='owners']//tbody//tr[1]//td[1]//a")
	public WebElement linkExistingOwnerName;
	
	@FindBy(xpath = "//span[normalize-space()='Arhaan Mehdi']")
	public WebElement txtExisitngOwnerName; //need to verify first for existing Owner name
	
	@FindBy(xpath = "//a[@class='btn btn-default'][contains(text(),'Add')]")
	public WebElement btnAddNewPet;
	
	//New pet add related Objects/Locators
	@FindBy(id = "name")
	public WebElement txtPetName;
		
	@FindBy(css = "#birthDate")
	public WebElement txtPetBirthDate;
	
	@FindBy(css = "#type")
	public WebElement ddPetType;
	
	@FindBy(xpath = "//button[normalize-space()='Add Pet']")
	public WebElement btnAddPet;
	
	
	
	//Visit related objects
	@FindBy(xpath = "//a[contains(text(),'Visit')]")
	public WebElement linkAddVisit; //click "add-visit" link
	
	@FindBy(css ="#date")
	public WebElement txtVisitDate;
	
	@FindBy(css ="#description")
	public WebElement txtVisitDescription;
	
	@FindBy(xpath = "//button[normalize-space()='Add Visit']")
	public WebElement btnAddVisit;
	
	
	@FindBy(xpath = "//dd[normalize-space()='Zoro']")
	public WebElement viewPetName;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
