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
public class PaymentPage extends BaseClass {
	Action action = new Action();
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')] ")
	WebElement payByBankWire;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')] ")
	WebElement payByCheck;
	
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummaryPage clickOnPaymentMethod() {
		action.click(getDriver(), payByBankWire);
		return new OrderSummaryPage();
	}
}
