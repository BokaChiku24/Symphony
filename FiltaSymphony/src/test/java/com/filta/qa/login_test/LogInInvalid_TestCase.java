package com.filta.qa.login_test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

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
import com.filta.qa.login_page.Login;
import com.filta.qa.util.Global;

public class LogInInvalid_TestCase
{
	private WebDriver Driver;
	private Login Login;
	private Global Global_Obj;
	private Properties Prop;
	private ExtentHtmlReporter HtmlReporter;
	private ExtentReports Extent;
	private ExtentTest ExtentLogger;
	private String ScreenshotPath;
	private String DateName;
	private File ScrFile;

	public static Logger Log = Logger.getLogger("Sign In With Invalid Credentials Test Case");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}


	@BeforeClass
	public void property()
	{
		Global_Obj = new Global();
		Driver = Global_Obj.driver();
		Prop = Global_Obj.readProperties();
		Login = new Login(Driver);
		HtmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/HomePage/LoginInvalid_TestCase.html");
		Extent = new ExtentReports();
		Extent.attachReporter(HtmlReporter);
		Extent.setSystemInfo("OS", "Windows 7 64 Bit");
		Extent.setSystemInfo("Browser", "Google Chrome");
		Extent.setSystemInfo("Author:", "Kunal Chavan");
		Extent.setSystemInfo("Testing:", "Functional Testing");
		HtmlReporter.config().setReportName("Login Invalid Functionality Test Case");
		HtmlReporter.config().setTheme(Theme.STANDARD);
		HtmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		HtmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test(priority = 0)
	public void signInWithInvalidCredentails()
	{
		Log.info("Test Case 1: Check Login functionality with invalid credentials");
		ExtentLogger = Extent.createTest("Test Case 1: Check Login functionality with invalid credentials");
		Login.enterUserName(Prop.getProperty("InvalidUname1"));
		Login.enterPassword(Prop.getProperty("InvalidPassword1"));
		Login.clickSubmit();
		Login.assertCheck2();
	}


	@Test(priority = 1)
	public void signInWithInvalidCredentails2()
	{
		Log.info("Test Case 2: Check Login functionality without credentials");
		ExtentLogger = Extent.createTest("Test Case 2: Check Login functionality without credentials");
		Login.clearText();
		Login.enterUserName("");
		Login.enterPassword("");
		Login.clickSubmit();
		Login.assertCheck2();
	}


	@Test(priority = 2)
	public void signInWithInvalidCredentails3()
	{
		Log.info("Test Case 3: Check Login functionality withInvalid credentials");
		ExtentLogger = Extent.createTest("Test Case 3: Check Login functionality withInvalid credentials");
		Login.clearText();
		Login.enterUserName(Prop.getProperty("InvalidUname1"));
		Login.enterPassword("");
		Login.clickSubmit();
		Login.assertCheck2();
	}


	@Test(priority = 2)
	public void signInWithInvalidCredentails4()
	{
		Log.info("Test Case 4: Check Login functionality withInvalid credentials");
		ExtentLogger = Extent.createTest("Test Case 4: Check Login functionality withInvalid credentials");
		Login.clearText();
		Login.enterUserName("");
		Login.enterPassword(Prop.getProperty("InvalidPassword1"));
		Login.clickSubmit();
		Login.assertCheck2();
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
			DateName = new SimpleDateFormat("dd MMMM yyyy zzzz").format(new Date());
			ScrFile = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
			ScreenshotPath = System.getProperty("user.dir") + "/LoginInValid_errorScreenshots/"
					+ TestResult.getName() + DateName + "_" + Arrays.toString(TestResult.getParameters()) + ".png";
			FileUtils.copyFile(ScrFile, new File(ScreenshotPath));
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
	public void afterMethod()
	{
		Log.info("Sign In Test Case Ends Here");
		Extent.flush();
		Login.driverClose();
	}
}
