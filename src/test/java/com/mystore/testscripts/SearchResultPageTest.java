/**
 * 
 */
package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author avina
 *
 */
public class SearchResultPageTest extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	SearchResultPage searchResultPage;
	
	
	
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
    public void productAvailabilityTest() throws Throwable {
    	indexPage = new IndexPage();
    	searchResultPage= indexPage.searchProduct("t-shirt");
    	boolean result = searchResultPage.isProductAvailable();
    	Assert.assertTrue(result);
    }
    
    
}
