package Destiny.testCases;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Destiny.pageObjects.LandingPagePO;
import Destiny.pageObjects.LoginPagePO;
import junit.framework.Assert;
import utils.BaseWebPage;

public class LoginPage extends BaseWebPage {
	private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		BasicConfigurator.configure();
		 driver =initialWebDriver();
		 driver.get(prop.getProperty("url"));
		 log.info("Navigated to Home page");

	}
	
	@Test
	public void Login() throws InterruptedException {
		LandingPagePO lp = new LandingPagePO(driver);
		lp.login().click();
		LoginPagePO lpo = new LoginPagePO(driver);
		lpo.getEmail().sendKeys("abc@xyz.com");
		lpo.getPwd().sendKeys("Password");
		lpo.getLogin().click();
		Thread.sleep(2000);
		lpo.getErrorDetails().isDisplayed();
		String str = lpo.getErrorDetails().getText();
		System.out.println(str);
		//Assert.assertEquals(lpo.getErrorDetails().getText(), "Invalid email or password.");
			
		
	}
	
	
	@AfterTest
	 public void tearDown() {
	    	
	    	driver.close();
	    	driver =null;
	    	
	    }
	

}
