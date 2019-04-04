package testCases_HomePageFranchisee;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageObjects_HomePageFranchisee.UserPage;
import util.Global;

public class UserPage_TestCase {
	private UserPage UserPageObject;
	private Global global;
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest logger;
	private String screenshotPath;

	public static Logger log = Logger.getLogger("User Page Test Case");
	static {
		PropertyConfigurator.configure(".//Log4j.properties");
	}

	@BeforeClass
	public void property() {
		global = new Global();
		driver = global.driver();
		UserPageObject = new UserPage(driver);
		UserPageObject.login();
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/UserPage/UserPage_TestCase.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 7 64 Bit");
		extent.setSystemInfo("Browser", "Google Chrome");
		extent.setSystemInfo("Author:", "Kunal Chavan");
		extent.setSystemInfo("Testing:", "Functional Testing");
		htmlReporter.config().setReportName("User Page Functionality Test Case");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		htmlReporter.loadXMLConfig("./extent-config.xml");
	}

	@Test(priority = 0)
	public void checkURL() {
		log.info("Check URL Of User Page");
		logger = extent.createTest("Test Case 0: Check URL Of User Page");
		UserPageObject.urlCheck();
	}

	@Test(priority = 1)
	public void checkButtonName() {
		log.info("Test Case 1: Check Button Name On User Page");
		logger = extent.createTest("Test Case 1: Check Button Name On User Page");
		UserPageObject.buttonCheck();
	}

	@Test(priority = 1, dependsOnMethods = "checkButtonName")
	public void buttonBackGroundWithoutMouseOverview() {
		log.info("Test Case 2: Check Button Color Without Mouse Overview On User Page");
		logger = extent.createTest("Test Case 2: Check Button Color Without Mouse Overview On User Page");
		UserPageObject.buttonBackGroundWithoutMouseOverview();
	}

	@Test(priority = 1, dependsOnMethods = "buttonBackGroundWithoutMouseOverview")
	public void buttonBackGroundWithMouseOverview() {
		log.info("Test Case 3: Check Button Color With Mouse Overview On User Page");
		logger = extent.createTest("Test Case 3: Check Button Color With Mouse Overview On User Page");
		UserPageObject.buttonBackGroundWithMouseOverview();
	}

	@Test(priority = 1, dependsOnMethods = "buttonBackGroundWithMouseOverview")
	public void buttonToolTipCheck() {
		log.info("Test Case 4: Check Button ToolTip On User Page");
		logger = extent.createTest("Test Case 4: Check Button ToolTip On User Page");
		UserPageObject.buttonToolTipCheck();
	}

	@Test(priority = 2)
	public void tabnamesCheck() {
		log.info("Test Case 5: Check Tab Name On User Page");
		logger = extent.createTest("Test Case 5: Check Tab Name On User Page");
		UserPageObject.tabnamesCheck();
	}

	@Test(priority = 3)
	public void checkDataOfUserProfile() {
		log.info("Test Case 6: Check Data Name On User Page");
		logger = extent.createTest("Test Case 6: Check Data On User Page");
		UserPageObject.getDataFromEditPageUserProfile();
		UserPageObject.verifyDataOfUserProfile();
	}

	@Test(priority = 4)
	public void checkPasswordPageOnEdit() {
		log.info("Test Case 7: Check Password Field On Edit Page");
		logger = extent.createTest("Test Case 7: Check Password Field On Edit Page");
		UserPageObject.checkPasswordPage();
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(testResult.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(testResult.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			String dateName = new SimpleDateFormat("dd MMMM yyyy zzzz").format(new Date());
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			screenshotPath = System.getProperty("user.dir") + "/UserPage_errorScreenshots/" + testResult.getName()
					+ dateName + "_" + Arrays.toString(testResult.getParameters()) + ".png";
			FileUtils.copyFile(scrFile, new File(screenshotPath));
			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));

		} else if (testResult.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(testResult.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (testResult.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(testResult.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
	}

	@AfterClass
	public void afterMethod() {
		log.info("User Page Test Case Ends Here");
		extent.flush();
		// UserPageObject.closeBrowser();
	}
}
