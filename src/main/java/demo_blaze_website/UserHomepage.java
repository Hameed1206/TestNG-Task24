package demo_blaze_website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.BaseClass;

public class UserHomepage extends BaseClass {
	//getting the logged in username
	public UserHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text() , 'Welcome')]")
	WebElement userName;

	public String getUserName() throws InterruptedException {
		elementWait(userName);
		String text = userName.getText();
		System.out.println(text);
		return text;
	}
	
	
}
