/**
 * 
 */
package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author avina
 *
 */
public class LoginPageTest extends BaseClass {
	
	   private IndexPage indexPage;
	   LoginPage loginPage;
	   HomePage homePage;
	   
	    @BeforeTest
	    public void setup() {
	        launchApp();
	        // Initialize the IndexPage instance here after WebDriver is launched
	       
	    }

	    @AfterTest
	    public void tearDown() {
	        if (getDriver() != null) {
	        	getDriver().quit();
	        }
	    }
	        @Test(dataProvider = "credentials" , dataProviderClass = DataProviders.class)
	       public void loginTest(String uname, String pswd) throws Throwable {
	         Log.startTestCase("Login Test");
	    	 indexPage = new IndexPage(); 
	    	 Log.info("user is going to click on SignIn");
	    	 loginPage = indexPage.clickOnSignIn();
	    	 Log.info("Enter Username and Password");
	    	 //homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    	 homePage = loginPage.login(uname,pswd);
	    	 String actualURL = homePage.getCurrURL();
	    	 System.out.println(actualURL);
	    	 String expectedURL = "http://www.automationpractice.pl/index.php?controller=my-account";
	    	 Log.info("Verifying if user is able to login");
	    	 Assert.assertEquals(actualURL, expectedURL);
	    	 Log.info("Login is Success");
	    	 Log.endTestCase("LoginTest");
	    	 
	       }
}


