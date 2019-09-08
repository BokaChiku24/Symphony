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
	private WebDriver driver;
	private Login login;
	private Global global_Obj;
	private Properties prop;
	private ExtentHtmlReporter htmlReporter;
	private ExtentReports extent;
	private ExtentTest extentLogger;
	private String screenshotPath;
	private String dateName;
	private File scrFile;

	public static Logger log = Logger.getLogger("Sign in with invalid credentials test case");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}


	@BeforeClass
	public void property()
	{
		global_Obj = new Global();
		driver = global_Obj.driver();
		prop = global_Obj.readProperties();
		login = new Login(driver);
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/HomePage/LoginInvalid_TestCase.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 7 64 Bit");
		extent.setSystemInfo("Browser", "Google Chrome");
		extent.setSystemInfo("Author:", "Kunal Chavan");
		extent.setSystemInfo("Testing:", "Functional Testing");
		htmlReporter.config().setReportName("Login invalid functionality test case");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		htmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test(priority = 0)
	public void signInWithInvalidCredentails()
	{
		log.info("Test Case 1: Check Login functionality with invalid credentials");
		extentLogger = extent.createTest("Test Case 1: Check Login functionality with invalid credentials");
		login.enterUserName(prop.getProperty("InvalidUname1"));
		login.enterPassword(prop.getProperty("InvalidPassword1"));
		login.clickSubmit();
		login.assertCheck2();
	}


	@Test(priority = 1)
	public void signInWithInvalidCredentails2()
	{
		log.info("Test case 2: Check login functionality without credentials");
		extentLogger = extent.createTest("Test case 2: Check login functionality without credentials");
		login.clearText();
		login.enterUserName("");
		login.enterPassword("");
		login.clickSubmit();
		login.assertCheck2();
	}


	@Test(priority = 2)
	public void signInWithInvalidCredentails3()
	{
		log.info("Test case 3: Check login functionality withInvalid credentials");
		extentLogger = extent.createTest("Test case 3: Check login functionality withInvalid credentials");
		login.clearText();
		login.enterUserName(prop.getProperty("InvalidUname1"));
		login.enterPassword("");
		login.clickSubmit();
		login.assertCheck2();
	}


	@Test(priority = 2)
	public void signInWithInvalidCredentails4()
	{
		log.info("Test case 4: Check login functionality withInvalid credentials");
		extentLogger = extent.createTest("Test case 4: Check login functionality withInvalid credentials");
		login.clearText();
		login.enterUserName("");
		login.enterPassword(prop.getProperty("InvalidPassword1"));
		login.clickSubmit();
		login.assertCheck2();
	}


	@Test(priority = 3)
	public void availableLinks()
	{
		log.info("Test case 7: Get all login URL");
		extentLogger = extent.createTest("Test case 7: Get all login URL");
		login.availableLinks();
	}


	@Test(priority = 4)
	public void getBrokenLink()
	{
		log.info("Test case 8: Get all broken URL");
		extentLogger = extent.createTest("Test case 8: Get all broken URL");
		login.brokenLink();
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException
	{
		if (testResult.getStatus() == ITestResult.FAILURE)
		{
			extentLogger.log(Status.FAIL,
					MarkupHelper.createLabel(testResult.getName() + " - Test case failed", ExtentColor.RED));
			extentLogger.log(Status.FAIL,
					MarkupHelper.createLabel(testResult.getThrowable() + " - Test case failed", ExtentColor.RED));
			dateName = new SimpleDateFormat("dd MMMM yyyy zzzz").format(new Date());
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			screenshotPath = System.getProperty("user.dir") + "/LoginInValid_errorScreenshots/"
					+ testResult.getName() + dateName + "_" + Arrays.toString(testResult.getParameters()) + ".png";
			FileUtils.copyFile(scrFile, new File(screenshotPath));
			extentLogger.fail("Test case failed snapshot is below " + extentLogger.addScreenCaptureFromPath(screenshotPath));

		}
		else if (testResult.getStatus() == ITestResult.SKIP)
		{
			extentLogger.log(Status.SKIP,
					MarkupHelper.createLabel(testResult.getName() + " - Test case skipped", ExtentColor.ORANGE));
		}
		else if (testResult.getStatus() == ITestResult.SUCCESS)
		{
			extentLogger.log(Status.PASS,
					MarkupHelper.createLabel(testResult.getName() + " Test case passed", ExtentColor.GREEN));
		}
	}


	@AfterClass
	public void afterClass()
	{
		log.info("Sign in test case ends here");
		extent.flush();
		login.driverClose();
	}
}
