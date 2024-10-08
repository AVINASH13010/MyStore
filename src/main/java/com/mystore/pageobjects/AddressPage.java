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
public class AddressPage extends BaseClass {
	Action action = new Action();
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span/text()")
	WebElement proceedToCheckOut;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage clickOnCheckOut() {
		action.moveToElement(getDriver(), proceedToCheckOut);
		action.click(getDriver(), proceedToCheckOut);
		return new ShippingPage();
	}
}
