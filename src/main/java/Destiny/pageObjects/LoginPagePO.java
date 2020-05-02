package Destiny.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePO {

	WebDriver driver;

	/**
	 * Constructor Defination
	 * 
	 * @param driver
	 */
	public LoginPagePO(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "user_email")
	WebElement email;

	@FindBy(css = "input#user_password.form-control.input-hg")
	WebElement pwd;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement Login;

	@FindBy(css = "div.alert.alert-danger")
	WebElement errorMessage;

	
	
	public WebElement getEmail() {

		return email;
	}

	public WebElement getPwd() {

		return pwd;

	}

	public WebElement getLogin() {

		return Login;
	}

	public WebElement getErrorDetails() {

		return email;
	}

}
