/**
 * 
 */
package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
/**
 * @author avina
 *
 */
public class AccountCreationPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
	
	@BeforeMethod
    public void setup() {
        launchApp();
        // Initialize the IndexPage instance here after WebDriver is launched
       
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
        	getDriver().quit();
        }
    }
    
    @Test
    public void verifyCreateAcoountPageTest() throws Throwable {
    	indexPage = new IndexPage();
    	loginPage = indexPage.clickOnSignIn();
    	accountCreationPage=loginPage.createNewAccount("absbamdbsabdka@gmail.com");
    	boolean result= accountCreationPage.validateAccountCraetionPage();
    	Assert.assertTrue(result);
    }

}
