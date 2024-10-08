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
public class OrderPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath = "//ul[@id = 'product_price_5_27_0'  ]//child::li[@class = 'price special-price']")
	WebElement unitPrice;
	
	@FindBy(id = "total_price")
	WebElement totalPrice;
	
	@FindBy(xpath = "//i[@class = 'icon-chevron-right right'  ]//parent::span[text() ='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	
	}
	
	public double getUnitPrice() {
		String unitPrice1= unitPrice.getText();
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice/100;	
	}
	
	public double getTotalPrice() {
		String totalPrice1= totalPrice.getText();
		String total = totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice = Double.parseDouble(total);
		return finalTotalPrice/100;	
	}
	
	public LoginPage clickOnCheckOut() {
		action.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
	}
	
	

}
