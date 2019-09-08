package com.filta.qa.login_test;

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
import com.filta.qa.login_page.LoginPage;
import com.filta.qa.util.Global;

public class LogInPage_TestCase
{
	private WebDriver driver;
	private LoginPage loginPageObj;
	private Global global_Obj;
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest extentLogger;
	private String screenshotPath;

	public static Logger log = Logger.getLogger("LogInPage test case");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}


	@BeforeClass
	public void property()
	{
		global_Obj = new Global();
		driver = global_Obj.driver();
		loginPageObj = new LoginPage(driver);
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/HomePage/LoginPage_TestCase.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 7 64 Bit");
		extent.setSystemInfo("Browser", "Google Chrome");
		extent.setSystemInfo("Author:", "Kunal Chavan");
		extent.setSystemInfo("Testing:", "Functional Testing");
		htmlReporter.config().setReportName("Login page functionality test case");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		htmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test
	public void checktext()
	{
		log.info("Test case 1: Text check on login page");
		extentLogger = extent.createTest("Test case 1: Text check on login page");
		loginPageObj.checkText2();
	}


	@Test(priority = 1)
	public void checkDropDown()
	{
		log.info("Test case 2: Drop down check on login page");
		extentLogger = extent.createTest("Test case 2: Drop down check on login page");
		loginPageObj.dropDown();
	}


	@Test(priority = 2)
	public void footerCheck()
	{
		log.info("Test case 3: Footer check on login page");
		extentLogger = extent.createTest("Test case 3: Footer check on login page");
		loginPageObj.checkText();
	}


	@Test(priority = 3)
	public void checkURL()
	{
		log.info("Test case 4: URL check on login page");
		extentLogger = extent.createTest("Test case 4: URL check on login page");
		loginPageObj.checkURL();
	}


	@Test(priority = 4)
	public void checkTextBox()
	{
		log.info("Test case 5: Check login page textBox enabled or not");
		extentLogger = extent.createTest("Test case 5: Check login page textBox enabled or not");
		loginPageObj.checkTextBoxAssert();
	}


	@Test(priority = 5)
	public void checkLabel()
	{
		log.info("Test case 6: Check login page textBox label");
		extentLogger = extent.createTest("Test case 6: Check login page textBox label");
		loginPageObj.checkTextBoxLabel();
	}


	@Test(priority = 6)
	public void availableLinks()
	{
		log.info("Test case 7: Get all login URL");
		extentLogger = extent.createTest("Test case 7: Get all login URL");
		loginPageObj.availableLinks();
	}


	@Test(priority = 7)
	public void getBrokenLink()
	{
		log.info("Test case 8: Get all broken URL");
		extentLogger = extent.createTest("Test case 8: Get all broken URL");
		loginPageObj.brokenLink();
	}


	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult TestResult) throws IOException
	{
		if (TestResult.getStatus() == ITestResult.FAILURE)
		{
			extentLogger.log(Status.FAIL,
					MarkupHelper.createLabel(TestResult.getName() + " - Test case failed", ExtentColor.RED));
			extentLogger.log(Status.FAIL,
					MarkupHelper.createLabel(TestResult.getThrowable() + " - Test case failed", ExtentColor.RED));
			String dateName = new SimpleDateFormat("dd MMMM yyyy zzzz").format(new Date());
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			screenshotPath = System.getProperty("user.dir") + "/LoginPage_errorScreenshots/" + TestResult.getName()
					+ dateName + "_" + Arrays.toString(TestResult.getParameters()) + ".png";
			FileUtils.copyFile(scrFile, new File(screenshotPath));
			extentLogger.fail(
					"Test case failed snapshot is below " + extentLogger.addScreenCaptureFromPath(screenshotPath));
		}
		else if (TestResult.getStatus() == ITestResult.SKIP)
		{
			extentLogger.log(Status.SKIP,
					MarkupHelper.createLabel(TestResult.getName() + " - Test case skipped", ExtentColor.ORANGE));
		}
		else if (TestResult.getStatus() == ITestResult.SUCCESS)
		{
			extentLogger.log(Status.PASS,
					MarkupHelper.createLabel(TestResult.getName() + " Test case passed", ExtentColor.GREEN));
		}

	}


	@AfterClass
	public void closeBrowser()
	{
		log.info("Login Page test case Ends Here");
		extent.flush();
		loginPageObj.closeBrowser();
	}
}
