package Destiny.testCases;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Destiny.pageObjects.LandingPagePO;

import utils.BaseWebPage;

public class HomePage extends BaseWebPage {
	private static final Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		BasicConfigurator.configure();
		 driver =initialWebDriver();
		 driver.get(prop.getProperty("url"));
		 log.info("Navigated to Home page");

	}
	
	@Test
	public void ValidationHomePage()
	{
		LandingPagePO lp = new LandingPagePO(driver);
		//System.out.println("HEllo");
		//lp.login().click();
		String text =lp.featuredText().getText();
		//System.out.println(text);
		lp.featuredText().isDisplayed();
		System.out.println(text);
		Assert.assertFalse(lp.featuredText().isDisplayed());
		log.info(text);;
		log.info(lp.menuBar().getText());
		Assert.assertTrue(lp.menuBar().isDisplayed());
		//lp.menuBar().isDisplayed();
		
		
	}
	
	
	@AfterTest
	
	 public void tearDown() {
	    	
	    	driver.close();
	    	driver = null;
	    	
	    	
	    }
	

}

