package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{
	Action action = new Action();
	@FindBy(xpath = "//*[@id=\"center_column\"]/p[1]/text()")
	WebElement confirmMessage;
	
	public OrderConfirmationPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateConfirmMessage() {
		
		String ActualconfirmMessage =  confirmMessage.getText();
		return ActualconfirmMessage;
	}
	
}
