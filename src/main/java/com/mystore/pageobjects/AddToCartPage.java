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
public class AddToCartPage extends BaseClass {
	Action action = new Action();
	
	
	@FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
	WebElement quantity;
	
	@FindBy(id = "group_1")
	WebElement size;
	
	@FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
	WebElement addToCart;
	
	@FindBy(xpath = "//i[@class = 'icon-check']//parent::h2[contains(text(),'')]")
	WebElement addToCartMessage;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement proccedToCheckOutBtn;
	
	public AddToCartPage() {
		// TODO Auto-generated constructor stub
	PageFactory.initElements(getDriver(), this);
	}
	
	public void selectSize(String size1, int size2) {
		action.selectByValue(size, size1);
		action.selectByIndex(addToCart, size2);
		//action.type(size, size1);
		
	}
	
	public void addQuantity(String qnty) {
		action.type(quantity, qnty);
		
	}
	
	public void clickOnAddToCart() { 
		action.click(getDriver(), addToCart);
	}
	 public boolean validateAddToCart() {
		action.fluentWait(getDriver(), addToCartMessage, 20);
		return action.isDisplayed(getDriver(), addToCartMessage);
	}
	 
	public OrderPage clickingOnCheckOut()
	{
		action.fluentWait(getDriver(), proccedToCheckOutBtn, 20);
		action.JSClick(getDriver(), proccedToCheckOutBtn);
		return new OrderPage();
	}
	
}
