/**
 * 
 */
package com.mystore.testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

/**
 * @author avina
 *
 */
public class EndToEndTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
	
	
	@BeforeTest
    public void setup() {
        launchApp();
        // Initialize the IndexPage instance here after WebDriver is launched
       
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Test
    public void endToEndTest() throws Throwable {
    	 indexPage = new IndexPage();
	   	 searchResultPage  = indexPage.searchProduct("t-shirt");
	   	 addToCartPage  = searchResultPage.clickOnProduct();
	   	 addToCartPage.selectSize("2", 2);
	   	 addToCartPage.addQuantity("2"); 
	   	 addToCartPage.clickOnAddToCart();
	   	 orderPage = addToCartPage.clickingOnCheckOut();
	   	 loginPage = orderPage.clickOnCheckOut();
	   	 addressPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), addressPage);
	   	 shippingPage = addressPage.clickOnCheckOut();
	   	 shippingPage.checkTheTerms();
	   	 paymentPage = shippingPage.clickOnProceedToCheckOut();
	   	 orderSummaryPage = paymentPage.clickOnPaymentMethod();
	   	 orderConfirmationPage = orderSummaryPage.clickOnConfirmMyOrder();
	   	 String actualMsg = orderConfirmationPage.validateConfirmMessage();
	   	 String expectedMsg = "Your order on My Store is completed."; 
	   	 Assert.assertEquals(actualMsg, expectedMsg);
	   	 
	   	 
    }

}
