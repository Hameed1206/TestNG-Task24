package demo_blaze_website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.BaseClass;

public class LoginPage extends BaseClass {

	//Getting the locators of username, password ,Login button and performing actions
	@FindBy(id = "loginusername")
	WebElement userName;
	
	@FindBy(id = "loginpassword")
	WebElement passWord;
	
	@FindBy(css = "button[onclick = 'logIn()']")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public UserHomepage getLoginButton() {
		loginButton.click();
		return new UserHomepage(driver);
	}
	public LoginPage loginCred(String user, String pass) {
		userName.sendKeys(user);
		passWord.sendKeys(pass);
		return this;
	}

}
