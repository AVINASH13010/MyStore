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
public class OrderSummaryPage extends BaseClass {
	Action action = new Action();
	
	@FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
	WebElement confirmOrderBtn;
	
	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickOnConfirmMyOrder() {
		action.click(getDriver(), confirmOrderBtn);
		return new OrderConfirmationPage();
	}

}
