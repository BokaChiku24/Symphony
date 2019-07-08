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
	private WebDriver Driver;
	private LoginPage LoginPageObj;
	private Global Global_Obj;
	private ExtentReports Extent;
	private ExtentHtmlReporter HtmlReporter;
	private ExtentTest ExtentLogger;
	private String ScreenshotPath;

	public static Logger Log = Logger.getLogger("LogInPage Test Case");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}


	@BeforeClass
	public void property()
	{
		Global_Obj = new Global();
		Driver = Global_Obj.driver();
		LoginPageObj = new LoginPage(Driver);
		HtmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/HomePage/LoginPage_TestCase.html");
		Extent = new ExtentReports();
		Extent.attachReporter(HtmlReporter);
		Extent.setSystemInfo("OS", "Windows 7 64 Bit");
		Extent.setSystemInfo("Browser", "Google Chrome");
		Extent.setSystemInfo("Author:", "Kunal Chavan");
		Extent.setSystemInfo("Testing:", "Functional Testing");
		HtmlReporter.config().setReportName("Login Page Functionality Test Case");
		HtmlReporter.config().setTheme(Theme.STANDARD);
		HtmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		HtmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test
	public void checktext()
	{
		Log.info("Test Case 1: Text Check on Login Page");
		ExtentLogger = Extent.createTest("Test Case 1: Text Check on Login Page");
		LoginPageObj.checkText2();
	}


	@Test(priority = 1)
	public void checkDropDown()
	{
		Log.info("Test Case 2: Drop Down Check on Login Page");
		ExtentLogger = Extent.createTest("Test Case 2: Drop Down Check on Login Page");
		LoginPageObj.dropDown();
	}


	@Test(priority = 2)
	public void footerCheck()
	{
		Log.info("Test Case 3: Footer Check on Login Page");
		ExtentLogger = Extent.createTest("Test Case 3: Footer Check on Login Page");
		LoginPageObj.checkText();
	}


	@Test(priority = 3)
	public void checkURL()
	{
		Log.info("Test Case 4: URL Check on Login Page");
		ExtentLogger = Extent.createTest("Test Case 4: URL Check on Login Page");
		LoginPageObj.checkURL();
	}


	@Test(priority = 4)
	public void checkTextBox()
	{
		Log.info("Test Case 5: Check Login Page TextBox Enabled Or Not");
		ExtentLogger = Extent.createTest("Test Case 5: Check Login Page TextBox Enabled Or Not");
		LoginPageObj.checkTextBoxAssert();
	}


	@Test(priority = 5)
	public void checkLabel()
	{
		Log.info("Test Case 6: Check Login Page TextBox Label");
		ExtentLogger = Extent.createTest("Test Case 6: Check Login Page TextBox Label");
		LoginPageObj.checktextBoxLabel();
	}


	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult TestResult) throws IOException
	{
		if (TestResult.getStatus() == ITestResult.FAILURE)
		{
			ExtentLogger.log(Status.FAIL,
					MarkupHelper.createLabel(TestResult.getName() + " - Test Case Failed", ExtentColor.RED));
			ExtentLogger.log(Status.FAIL,
					MarkupHelper.createLabel(TestResult.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			String dateName = new SimpleDateFormat("dd MMMM yyyy zzzz").format(new Date());
			File scrFile = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
			ScreenshotPath = System.getProperty("user.dir") + "/LoginPage_errorScreenshots/" + TestResult.getName()
					+ dateName + "_" + Arrays.toString(TestResult.getParameters()) + ".png";
			FileUtils.copyFile(scrFile, new File(ScreenshotPath));
			ExtentLogger.fail("Test Case Failed Snapshot is below " + ExtentLogger.addScreenCaptureFromPath(ScreenshotPath));
		}
		else if (TestResult.getStatus() == ITestResult.SKIP)
		{
			ExtentLogger.log(Status.SKIP,
					MarkupHelper.createLabel(TestResult.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
		else if (TestResult.getStatus() == ITestResult.SUCCESS)
		{
			ExtentLogger.log(Status.PASS,
					MarkupHelper.createLabel(TestResult.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}

	}


	@AfterClass
	public void closeBrowser()
	{
		Log.info("Login Page test case Ends Here");
		Extent.flush();
		LoginPageObj.closebrowser();
	}
}
