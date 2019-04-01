package testCases_HomePageFranchisee;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

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

import pageObjects_HomePageFranchisee.UserPage;
import util.Global;

public class UserPage_TestCase {
	private UserPage UserPageObject;
	private Global global;
	private WebDriver driver;

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
	}

	@Test(priority = 0)
	public void checkURL() {
		log.info("Check URL Of User Page");
		UserPageObject.urlCheck();
	}

	@Test(priority = 1)
	public void checkButtonName() {
		log.info("Check Button Name On User Page");
		UserPageObject.buttonCheck();
	}

	@Test(priority = 1, dependsOnMethods = "checkButtonName")
	public void buttonBackGroundWithoutMouseOverview() {
		log.info("Check Button Color Without Mouse Overview On User Page");
		UserPageObject.buttonBackGroundWithoutMouseOverview();
	}

	@Test(priority = 1, dependsOnMethods = "buttonBackGroundWithoutMouseOverview")
	public void buttonBackGroundWithMouseOverview() {
		log.info("Check Button Color With Mouse Overview On User Page");
		UserPageObject.buttonBackGroundWithMouseOverview();
	}

	@Test(priority = 1, dependsOnMethods = "buttonBackGroundWithMouseOverview")
	public void buttonToolTipCheck() {
		log.info("Check Button ToolTip On User Page");
		UserPageObject.buttonToolTipCheck();
	}

	@Test(priority = 2)
	public void tabnamesCheck() {
		log.info("Check Tab Name On User Page");
		UserPageObject.tabnamesCheck();
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("UserPage_errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".jpg"));
		}
	}

	@AfterClass
	public void afterMethod() {
		log.info("User Page Test Case Ends Here");
		// UserPageObject.closeBrowser();
	}
}
