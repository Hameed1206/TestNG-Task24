package test_execute;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base_package.BaseClass;
import demo_blaze_website.Homepage;
import demo_blaze_website.UserHomepage;

//here I am calling all the methods with one object, since all classes are already linked through constructor chaining
public class SignUpandLogin extends BaseClass{
//Task 24--------	
	//Creating a extent report
	ExtentSparkReporter crtreport;
	ExtentReports extent;
	ExtentTest snap;
	public SignUpandLogin() {
		crtreport = new ExtentSparkReporter("C:\\Users\\91936\\eclipse-workspace\\TestNG\\target\\Final_Report.html");
		crtreport.config().setReportName("Web Automation Results");
		crtreport.config().setDocumentTitle("Web Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(crtreport);
	}
	//Test annotation , here only executions happens
	@Parameters({"username","password"})
	@Test
	public void ValidateSignUpandLogin(String user, String pass) throws InterruptedException, IOException {
		SignUpandLogin s = new SignUpandLogin();
		Homepage h = new Homepage(driver);
		//report monitor starts here
		snap = extent.createTest("ValidateSignUpandLogin");
		//calling all the methods
		h.getSignIn().signUpCred(user, pass).getSignUpButton();
		checkIfAlert();
		handleAlert();
		h.getLogin().loginCred(user, pass).getLoginButton();
		
		//Validating the expected and actual using Assert function.
		UserHomepage u = new UserHomepage(driver);
		Assert.assertEquals(u.getUserName(), "Welcome "+user);
		System.out.println("User logged In succesfully");
		//Add screenshot and logs to report
		snap.addScreenCaptureFromPath(screenShot(), "UserHomepage");
		snap.log(Status.PASS, "Login succesful");
		extent.flush();
	}

}
