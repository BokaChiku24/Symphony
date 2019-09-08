package com.filta.qa.home_franchisee_test;

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

import com.filta.qa.home_page_franchisee.UserPage;
import com.filta.qa.util.Global;

public class UserPage_TestCase
{
	private UserPage userPageObject;
	private Global global;
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest logger;
	private String screenshotPath;
	public static Logger log = Logger.getLogger("User page test case");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}


	@BeforeClass
	public void property()
	{
		global = new Global();
		driver = global.driver();
		userPageObject = new UserPage(driver);
		userPageObject.login();
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/UserPage/UserPage_TestCase.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 7 64 Bit");
		extent.setSystemInfo("Browser", "Google Chrome");
		extent.setSystemInfo("Author:", "Kunal Chavan");
		extent.setSystemInfo("Testing:", "Functional Testing");
		htmlReporter.config().setReportName("User page functionality test case");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		htmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test(priority = 0)
	public void checkURL()
	{
		log.info("Check URL of user page");
		logger = extent.createTest("Test case 0: Check URL of user page");
		userPageObject.urlCheck();
	}


	@Test(priority = 1)
	public void checkButtonName()
	{
		log.info("Test case 1: Check button name on user page");
		logger = extent.createTest("Test case 1: Check button name on user page");
		userPageObject.buttonCheck();
	}


	@Test(priority = 1, dependsOnMethods = "checkButtonName")
	public void buttonBackGroundWithoutMouseOverview()
	{
		log.info("Test case 2: Check button color without mouse overview on user page");
		logger = extent.createTest("Test Case 2: Check button color without mouse overview on user page");
		userPageObject.buttonBackGroundWithoutMouseOverview();
	}


	@Test(priority = 1, dependsOnMethods = "buttonBackGroundWithoutMouseOverview")
	public void buttonBackGroundWithMouseOverview()
	{
		log.info("Test case 3: Check button color with mouse overview on user page");
		logger = extent.createTest("Test case 3: Check button color with mouse overview on user page");
		userPageObject.buttonBackGroundWithMouseOverview();
	}


	@Test(priority = 1, dependsOnMethods = "buttonBackGroundWithMouseOverview")
	public void buttonToolTipCheck()
	{
		log.info("Test case 4: Check button toolTip on user page");
		logger = extent.createTest("Test case 4: Check button toolTip on user page");
		userPageObject.buttonToolTipCheck();
	}


	@Test(priority = 2)
	public void tabnamesCheck()
	{
		log.info("Test case 5: Check tab name on user page");
		logger = extent.createTest("Test case 5: Check tab name on user page");
		userPageObject.tabnamesCheck();
	}


	@Test(priority = 3)
	public void checkDataOfUserProfile()
	{
		log.info("Test case 6: Check data on user page");
		logger = extent.createTest("Test case 6: Check data on user page");
		userPageObject.getDataFromEditPageUserProfile();
		userPageObject.verifyDataOfUserProfile();
	}


	@Test(priority = 4)
	public void checkPasswordPageOnEdit()
	{
		log.info("Test Case 7: Check password field on edit page");
		logger = extent.createTest("Test Case 7: Check password field on edit page");
		userPageObject.checkPasswordPage();
	}


//	@Test(priority = 5)
//	public void checkThemesPageOnEdit()
//	{
//		log.info("Test Case 8: Check Themes Page On Edit");
//		logger = extent.createTest("Test Case 8: Check Themes Page On Edit");
//		UserPageObject.checkThemesPage();
//	}
//
//
//	@Test(priority = 6)
//	public void checkAdvancedOfUserProfile()
//	{
//		log.info("Test Case 9: Check Advanced On User Page");
//		logger = extent.createTest("Test Case 9: Check Advanced On User Page");
//		UserPageObject.checkDataFromEditPageAdvanced();
//		UserPageObject.verifyDataOfAdvanced();
//	}
//
//
//	@Test(priority = 7)
//	public void checkAccessOfUser()
//	{
//		log.info("Test Case 10: Check The User Access");
//		logger = extent.createTest("Test Case 10: Check The User Access");
//		UserPageObject.accessCheck();
//	}


	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException
	{
		if (testResult.getStatus() == ITestResult.FAILURE)
		{
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(testResult.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(testResult.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			String dateName = new SimpleDateFormat("dd MMMM yyyy zzzz").format(new Date());
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			screenshotPath = System.getProperty("user.dir") + "/UserPage_errorScreenshots/" + testResult.getName()
					+ dateName + "_" + Arrays.toString(testResult.getParameters()) + ".png";
			FileUtils.copyFile(scrFile, new File(screenshotPath));
			logger.fail("Test case failed snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
		}
		else if (testResult.getStatus() == ITestResult.SKIP)
		{
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(testResult.getName() + " - Test case skipped", ExtentColor.ORANGE));
		}
		else if (testResult.getStatus() == ITestResult.SUCCESS)
		{
			logger.log(Status.PASS,
					MarkupHelper.createLabel(testResult.getName() + " Test case passed", ExtentColor.GREEN));
		}
	}


	@AfterClass
	public void afterClass()
	{
		log.info("User page test case ends here");
		extent.flush();
		userPageObject.closeBrowser();
	}
}
