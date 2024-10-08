/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author avina
 *
 */
public class ShippingPage extends BaseClass {
	Action action = new Action(); 
	
	@FindBy(xpath = "//*[@id=\"uniform-cgv\"]")
	WebElement termsCheckBox;
	
	
	@FindBy(xpath = "//*[@id=\"form\"]/p/button/span/text()")
	WebElement proceedToCheckOutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public void checkTheTerms() {
		action.click(getDriver(), termsCheckBox);		
	}
	
	public PaymentPage clickOnProceedToCheckOut() {
		action.moveToElement(getDriver(), proceedToCheckOutBtn);
		action.click(getDriver(), proceedToCheckOutBtn);
		return new PaymentPage();
	} 
}
