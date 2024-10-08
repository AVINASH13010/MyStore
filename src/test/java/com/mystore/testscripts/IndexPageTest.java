/**
 * 
 */
package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

/**
 * @author avina
 *
 */
/*public class IndexPageTest extends BaseClass{
	IndexPage indexPage = new IndexPage();
	@BeforeTest
	public void setup() {
		launchApp();
	}
	
	

	@Test
	public void verifyLogo() throws Throwable {
		
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test
	 public void verifyTitle() {
		 String actTitle = indexPage.getMyStoreTitle();
		 Assert.assertEquals(actTitle, "My Shop");
	 }
	 
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
*/


public class IndexPageTest extends BaseClass {
    private IndexPage indexPage;

    @BeforeTest
    public void setup() {
        launchApp();
        // Initialize the IndexPage instance here after WebDriver is launched
        indexPage = new IndexPage();
    }

    @Test
    public void verifyLogo() throws Throwable {
        boolean result = indexPage.validateLogo();
        Assert.assertTrue(result, "Logo validation failed");
    }

    @Test
    public void verifyTitle() {
        String actTitle = indexPage.getMyStoreTitle();
        Assert.assertEquals(actTitle, "My Shop", "Page title does not match expected value");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
