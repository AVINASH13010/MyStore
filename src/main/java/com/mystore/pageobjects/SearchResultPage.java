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
public class SearchResultPage extends BaseClass{
	Action action = new Action();
	@FindBy(xpath = "//*[@id=\"best-sellers_block_right\"]/div/ul/li[6]/a/img")
	WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() {
		action.mouseover(getDriver(), productResult);
		boolean dis= action.isDisplayed(getDriver(), productResult);
		return dis;
	}
	
	public AddToCartPage clickOnProduct() {
		action.scrollByVisibilityOfElement(getDriver(), productResult);
		action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
}
