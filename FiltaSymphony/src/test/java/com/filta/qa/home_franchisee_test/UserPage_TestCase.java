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
	private Global globalObj;
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest logger;
	private String screenshotPath;
	public static Logger log = Logger.getLogger("User Page Test Case");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}


	@BeforeClass
	public void property()
	{
		globalObj = new Global();
		driver = globalObj.driver();
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
		htmlReporter.config().setReportName("User Page Functionality Test Case");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		htmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test(priority = 0)
	public void checkURL()
	{
		log.info("Check URL Of User Page");
		logger = extent.createTest("Test Case 0: Check URL Of User Page");
		userPageObject.urlCheck();
	}


	@Test(priority = 1)
	public void checkButtonName()
	{
		log.info("Test Case 1: Check Button Name On User Page");
		logger = extent.createTest("Test Case 1: Check Button Name On User Page");
		userPageObject.buttonCheck();
	}


	@Test(priority = 1, dependsOnMethods = "checkButtonName")
	public void buttonBackGroundWithoutMouseOverview()
	{
		log.info("Test Case 2: Check Button Color Without Mouse Overview On User Page");
		logger = extent.createTest("Test Case 2: Check Button Color Without Mouse Overview On User Page");
		userPageObject.buttonBackGroundWithoutMouseOverview();
	}


	@Test(priority = 1, dependsOnMethods = "buttonBackGroundWithoutMouseOverview")
	public void buttonBackGroundWithMouseOverview()
	{
		log.info("Test Case 3: Check Button Coluor With Mouse Overview On User Page");
		logger = extent.createTest("Test Case 3: Check Button Coluor With Mouse Overview On User Page");
		userPageObject.buttonBackGroundWithMouseOverview();
	}


	@Test(priority = 1, dependsOnMethods = "buttonBackGroundWithMouseOverview")
	public void buttonToolTipCheck()
	{
		log.info("Test Case 4: Check Button ToolTip On User Page");
		logger = extent.createTest("Test Case 4: Check Button ToolTip On User Page");
		userPageObject.buttonToolTipCheck();
	}


	@Test(priority = 2)
	public void tabnamesCheck()
	{
		log.info("Test Case 5: Check Tab Name On User Page");
		logger = extent.createTest("Test Case 5: Check Tab Name On User Page");
		userPageObject.tabnamesCheck();
	}


	@Test(priority = 3)
	public void checkDataOfUserProfile()
	{
		log.info("Test Case 6: Check Data On User Page");
		logger = extent.createTest("Test Case 6: Check Data On User Page");
		userPageObject.getDataFromEditPageUserProfile();
		userPageObject.verifyDataOfUserProfile();
	}


	@Test(priority = 4)
	public void checkPasswordPageOnEdit()
	{
		log.info("Test Case 7: Check Password Field On Edit Page");
		logger = extent.createTest("Test Case 7: Check Password Field On Edit Page");
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
					MarkupHelper.createLabel(testResult.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
		else if (testResult.getStatus() == ITestResult.SUCCESS)
		{
			logger.log(Status.PASS,
					MarkupHelper.createLabel(testResult.getName() + " Test Case Passed", ExtentColor.GREEN));
		}
	}


	@AfterClass
	public void afterClass()
	{
		log.info("User Page Test Case Ends Here");
		extent.flush();
		userPageObject.closeBrowser();
	}
}
