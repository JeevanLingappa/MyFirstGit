package Destiny.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPagePO {
	WebDriver driver;
	
	
	/**
	 * Constructor Defination
	 * @param driver  
	 */
	public LandingPagePO(WebDriver driver)
	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	/////***********attributes*****************///
	
	
	@FindBy(linkText="Login")
	WebElement login;
	
	@FindBy(xpath="//div[@id='radio-btn-example']/fieldset/legend")
	WebElement radioHeader;
	
	@FindBy(xpath="//*[@id='content']/div/div/h2")
	WebElement featuredCourse;
	
	@FindBy(css="div.navbar.navbar-default.navbar-static-top")
	WebElement menuBar;
	
	
	
	
	
	
	
	
	
	// **************Methods//
	
	/**
	 * @return WebElement
	 */
	public WebElement  login() {
		
		return login;
	}


  public WebElement featuredText() {
	  
	  return featuredCourse;
  }

  public WebElement menuBar() {
	  
	  return menuBar;
  }
  
}