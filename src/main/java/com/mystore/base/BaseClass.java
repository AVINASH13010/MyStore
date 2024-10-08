package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.w3c.dom.DOMConfiguration;

import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	//public static WebDriver driver;
	
	//loadConfig method is to load the configuration
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>(); 
	
	public static WebDriver getDriver() {
	
		return driver.get();
	}
	
	@BeforeSuite
	public void beforeSuite() {
		DOMConfigurator.configure("log4j.xml");
	}
	
	@BeforeTest
	public void loadConfig() 
	{

		try {
			prop = new Properties();
			System.out.println("super contructor invoked  ");
			FileInputStream propFile = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configuration\\Config.properties");
			prop.load(propFile);
			// System.out.println("driver : " + driver);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException el) {
			// TODO Auto-generated catch block
			el.printStackTrace();
		}
	}
	
	
	public static void launchApp()
	{
		
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{  
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		}else if (browserName.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();
			driver.set(new EdgeDriver());
		}
		getDriver().manage().window().maximize();
		Action action = new Action();
		action.implicitWait(getDriver(), 10);
		action.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));

	}
}
