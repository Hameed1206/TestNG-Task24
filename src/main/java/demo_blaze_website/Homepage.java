package demo_blaze_website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.BaseClass;
import helper_package.UtilityClass;

public class Homepage extends BaseClass {

	//In homepage I am getting sign in and login button locators and clicking it
	@FindBy(id = "signin2")
	WebElement signIn;
	
	@FindBy(id = "login2")
	WebElement login;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SignUpPage getSignIn() {
		signIn.click();
		return new SignUpPage(driver);
	}

	public LoginPage getLogin() {
		login.click();
		return new LoginPage(driver);
	}

	
	
}
