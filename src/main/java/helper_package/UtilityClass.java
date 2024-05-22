package helper_package;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import demo_blaze_website.Homepage;

public class UtilityClass {
   //Here I am creating user defined methods with pre defined selenium methods for code reusable purpose
	public static WebDriver driver;
	public static void browserLaunch() {
		
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public static void handleAlert() {
		driver.switchTo().alert().accept();
	}
	public static void elementWait(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void checkIfAlert() {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.alertIsPresent());
	}
	public static String pageTitle() {
		String title = driver.getTitle();
		System.out.println("Title of page is "+title);
		return title;
	}
	public static String screenShot() throws IOException {
	    TakesScreenshot tk = (TakesScreenshot)driver;
	    File file = tk.getScreenshotAs(OutputType.FILE);
	    String path = "C:\\Users\\91936\\eclipse-workspace\\TestNG\\target\\"+pageTitle()+".jpg";
	    File f = new File(path);
	    Files.copy(file, f);
	    return path;
	    
	}
	public static ExtentReports Report() {
		ExtentSparkReporter crtreport = new ExtentSparkReporter("C:\\Users\\91936\\eclipse-workspace\\TestNG\\target\\Final_Report.html");
		crtreport.config().setReportName("Web Automation Results");
		crtreport.config().setDocumentTitle("Web Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(crtreport);
		return extent;
	}
	public static void closeBrowser() {

		driver.close();
	}
}
