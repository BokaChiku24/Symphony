package com.filta.qa.operations_test;

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
import com.filta.qa.operations.OperationsSubModule;
import com.filta.qa.util.Global;

/**
 * @author kun24
 * @implNote Operations Sub Module Test Case
 */

public class OperationsSubModule_TestCase
{
	private WebDriver driver;
	private Global globalObj;
	private OperationsSubModule obj;
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest extentLogger;
	private String screenshotPath;;
	private String dateName;
	private File scrFile;

	public static Logger Log = Logger.getLogger("Operations Module Test Cases");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}


	@BeforeClass
	public void property()
	{
		globalObj = new Global();
		driver = globalObj.driver();
		// Prop = Global_Obj.readProperties();
		obj = new OperationsSubModule(driver);
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/UserPage/Operations Submodule.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 7 64 Bit");
		extent.setSystemInfo("Browser", "Google Chrome");
		extent.setSystemInfo("H", "Kunal Chavan");
		extent.setSystemInfo("Testing:", "Functional Testing");
		htmlReporter.config().setReportName("Operations Submodule Test Case");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		htmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test(priority = 0)
	public void test()
	{
		Log.info("Check Operations Sub Module With Active Percent FiltaBio");
		extentLogger = extent.createTest("Test Case 0: Check Operations Sub Module With Active Percent FiltaBio");
		obj.loginAdmin();
		obj.opsActivePercent();
	}


	@Test(priority = 1)
	public void test1()
	{
		Log.info("Check Operations Sub Module Without FiltaBio");
		extentLogger = extent.createTest("Test Case 1: Check Operations Sub Module Without FiltaBio");
		obj.loginAdmin();
		obj.opsOnly();
	}


	@Test(priority = 2)
	public void test2()
	{
		Log.info("Check Operations Sub Module With 1K FiltaBio");
		extentLogger = extent.createTest("Test Case 2: Check Operations Sub Module With 1K FiltaBio");
		obj.loginAdmin();
		obj.opsActive1KProgram();
	}


	@Test(priority = 3)
	public void test3()
	{
		Log.info("Check Operations Sub Module With 6K FiltaBio");
		extentLogger = extent.createTest("Test Case 3: Check Operations Sub Module With 6K FiltaBio");
		obj.loginAdmin();
		obj.opsActive6KProgram();
	}


	@Test(priority = 4)
	public void test4()
	{
		Log.info("Check Operations Sub Module With Active Collector FiltaBio");
		extentLogger = extent.createTest("Test Case 4: Check Operations Sub Module With Active Collector FiltaBio");
		obj.loginAdmin();
		obj.opsActiveCollector();
	}


	@Test(priority = 5)
	public void test5()
	{
		Log.info("Check Operations Sub Module With Signed Waiting FiltaBio");
		extentLogger = extent.createTest("Test Case 5: Check Operations Sub Module With Signed Waiting FiltaBio");
		obj.loginAdmin();
		obj.opsSignedWaiting();
	}


	@Test(priority = 6)
	public void test6()
	{
		Log.info("Check Operations Sub Module With WC Issues FiltaBio");
		extentLogger = extent.createTest("Test Case 5: Check Operations Sub Module With WC Issues FiltaBio");
		obj.loginAdmin();
		obj.opsWCIssues();

	}


	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException
	{
		if (testResult.getStatus() == ITestResult.FAILURE)
		{
			extentLogger.log(Status.FAIL,
					MarkupHelper.createLabel(testResult.getName() + " - Test Case Failed", ExtentColor.RED));
			extentLogger.log(Status.FAIL,
					MarkupHelper.createLabel(testResult.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			dateName = new SimpleDateFormat("dd MMMM yyyy zzzz").format(new Date());
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			screenshotPath = System.getProperty("user.dir") + "/Operations_SubModule_TestCase/"
					+ testResult.getName() + dateName + "_" + Arrays.toString(testResult.getParameters()) + ".png";
			FileUtils.copyFile(scrFile, new File(screenshotPath));
			extentLogger.fail(
					"Test Case Failed Snapshot is below " + extentLogger.addScreenCaptureFromPath(screenshotPath));

		}
		else if (testResult.getStatus() == ITestResult.SKIP)
		{
			extentLogger.log(Status.SKIP,
					MarkupHelper.createLabel(testResult.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
		else if (testResult.getStatus() == ITestResult.SUCCESS)
		{
			extentLogger.log(Status.PASS,
					MarkupHelper.createLabel(testResult.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
	}


	@AfterClass
	public void afterMethod()
	{
		Log.info("Operations Sub Module Test Case Ends Here");
		extent.flush();
		obj.closeBrowser();
	}
}
