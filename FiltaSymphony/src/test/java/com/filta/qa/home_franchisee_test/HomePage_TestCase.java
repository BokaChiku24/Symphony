package com.filta.qa.home_franchisee_test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.filta.qa.home_page_franchisee.HomePage;
import com.filta.qa.util.Global;

import org.testng.ITestResult;

public class HomePage_TestCase
{

	private WebDriver Driver;
	private HomePage Homepage;
	private Global Global_Obj;
	private ExtentReports Extent;
	private ExtentHtmlReporter HtmlReporter;
	private ExtentTest ExtentLogger;
	private String ScreenshotPath;
	private String DateName;
	private File ScrFile;
	
	public static Logger Log = Logger.getLogger("Home Page Test Case");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}


	@BeforeClass
	public void property()
	{
		Global_Obj = new Global();
		Driver = Global_Obj.driver();
		Homepage = new HomePage(Driver);
		Homepage.login();
		HtmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/UserPage/HomePage_TestCase.html");
		Extent = new ExtentReports();
		Extent.attachReporter(HtmlReporter);
		Extent.setSystemInfo("OS", "Windows 7 64 Bit");
		Extent.setSystemInfo("Browser", "Google Chrome");
		Extent.setSystemInfo("Author:", "Kunal Chavan");
		Extent.setSystemInfo("Testing:", "Functional Testing");
		HtmlReporter.config().setReportName("Home Page Functionality Test Case");
		HtmlReporter.config().setTheme(Theme.STANDARD);
		HtmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		HtmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test(priority = 0)
	public void checkMenubar()
	{
		Log.info("Check Menubar Of Home Page");
		ExtentLogger = Extent.createTest("Test Case 1: Check Menubar Of Home Page");
		Homepage.menuBar();
	}


	@Test(priority = 1)
	public void menuScreenCheck()
	{
		Log.info("Check Menu Screen On Home Page");
		ExtentLogger = Extent.createTest("Test Case 2: Check Menu Screen On Home Page");
		Homepage.customers();
		Homepage.leads();
		Homepage.nca();
		Homepage.filtaBio();
		Homepage.techHiring();
		Homepage.myFranchisee();
		Homepage.filtaGold();
	}


	@Test(priority = 2)
	public void checkText()
	{
		Log.info("Check Text On Home Page");
		ExtentLogger = Extent.createTest("Test Case 3: Check Text On Home Page");
		Homepage.checkText();
	}


	@Test(priority = 3)
	public void checkTable()
	{
		Log.info("Check Table On Home Page");
		ExtentLogger = Extent.createTest("Test Case 4: Check Table On Home Page");
		Homepage.tableTest();
	}


	@Test(priority = 4)
	public void checkToolTip()
	{
		Log.info("Check Tooltip on Home Page");
		ExtentLogger = Extent.createTest("Test Case 5: Check Tooltip on Home Page");
		Homepage.toolTipCheck();
	}


	@Test(priority = 5)
	public void checkWidget()
	{
		Log.info("Check Widget On Home Page");
		ExtentLogger = Extent.createTest("Test Case 6: Check Widget On Home Page");
		Homepage.widgetTesting();
	}


	@Test(priority = 6)
	public void checkColor()
	{
		Log.info("Check Color On Home Page");
		ExtentLogger = Extent.createTest("Test Case 7: Check Color On Home Page");
		Homepage.colorCheck();
	}


	@Test(priority = 7)
	public void checkUserNameOnHomePage()
	{
		Log.info("Check User Name On Home Page");
		ExtentLogger = Extent.createTest("Test Case 8: Check User Name On Home Page");
		Homepage.checkUserNameOnHomePage();
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
			ScreenshotPath = System.getProperty("user.dir") + "/HomePage_errorScreenshots/" + TestResult.getName()
					+ DateName + "_" + Arrays.toString(TestResult.getParameters()) + ".png";
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
		Log.info("Home Page Test Case Ends Here");
		Extent.flush();
		Homepage.closeBrowser();
	}
}
