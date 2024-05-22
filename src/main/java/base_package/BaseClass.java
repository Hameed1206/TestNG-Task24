package base_package;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import helper_package.UtilityClass;

public class BaseClass extends UtilityClass {

	//I have created reusable user defined methods in utility class and calling the launch method to perform browser launch and close method to close browser
	@BeforeMethod
	public void startUp() {
		browserLaunch();
	}
	@AfterMethod
	public void tearDown() {
	closeBrowser();
	}
}
