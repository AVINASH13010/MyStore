/**
 * 
 */
package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author avina
 *
 */
public class OrderPageTest extends AddToCartPageTest {
	IndexPage indexPage;
	LoginPage loginPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;

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
    public void verifyTotalPrice() throws Throwable {
	    	indexPage = new IndexPage();
	   	 searchResultPage  = indexPage.searchProduct("t-shirt");
	   	 addToCartPage  = searchResultPage.clickOnProduct();
	   	 addToCartPage.selectSize("2", 2);
	   	 addToCartPage.addQuantity("2"); 
	   	 addToCartPage.clickOnAddToCart();
    	orderPage = addToCartPage.clickingOnCheckOut();
    	Double unitPrice =orderPage.getUnitPrice();
    	Double totalPrice = orderPage.getTotalPrice();
    	Double totalExpectedPriceDouble = (unitPrice *2)+2;
    	Assert.assertEquals(totalPrice, totalExpectedPriceDouble);
    }
}
