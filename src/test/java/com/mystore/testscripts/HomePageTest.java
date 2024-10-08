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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author avina
 *
 */
public class HomePageTest extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
		@BeforeMethod
	    public void setup() {
	        launchApp();
	        // Initialize the IndexPage instance here after WebDriver is launched
	       
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	    
	    @Test
	    public void verifyWhishListTest() throws Throwable {
			 indexPage =  new IndexPage();
			 loginPage = indexPage.clickOnSignIn();
			 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			 boolean result = homePage.validateMyWishList();
			 Assert.assertTrue(result);
	    }
	    
	    
	    @Test
	    public void orderHistorydetailsTest() throws Throwable {
			 indexPage =  new IndexPage();
			 loginPage = indexPage.clickOnSignIn();
			 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			 boolean result = homePage.validateOrderHistory();
			 Assert.assertTrue(result);
	    }
}
