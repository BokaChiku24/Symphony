/**
 * 
 */
package com.filta.qa.customer_test;

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
import com.filta.qa.customer_page.CreateCustomerFB;
import com.filta.qa.util.Global;

/**
 * @author kun24
 * @implNote Customer Create Test Case With FB
 */

public class CreateCustomerFB_TestCase
{
	private WebDriver driver;
	private CreateCustomerFB createCustomerFiltabio;
	private Global globalObj;
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest extentLogger;
	private String screenshotPath;;
	private String dateName;
	private File scrFile;

	public static Logger Log = Logger.getLogger("Create Customer FiltaBio Scenarios");
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
		createCustomerFiltabio = new CreateCustomerFB(driver);
		createCustomerFiltabio.login();
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/UserPage/Create_Customer_FB_TestCase.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 7 64 Bit");
		extent.setSystemInfo("Browser", "Google Chrome");
		extent.setSystemInfo("H", "Kunal Chavan");
		extent.setSystemInfo("Testing:", "Functional Testing");
		htmlReporter.config().setReportName("FiltaBio Checked While Creating Customer Test Case");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		htmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test(priority = 0)
	public void test()
	{
		Log.info("Create Customer With Default Pricing No And Check FiltaBio Is Checked Or Not!!");
		extentLogger = extent.createTest(
				"Test Case 1: Create Customer With Default Pricing No And Check FiltaBio Is Checked Or Not");
		createCustomerFiltabio.createCustomerDefaultPricingNo();
	}


	@Test(priority = 1)
	public void testDefaultPricingYes()
	{
		Log.info("Create Customer With Default Pricing Yes And Check FiltaBio Is Checked Or Not!!");
		extentLogger = extent.createTest(
				"Test Case 2: Create Customer With Default Pricing Yes And Check FiltaBio Is Checked Or Not");
		createCustomerFiltabio.createCustomerDefaultPricingYesFBPriceSet();
	}


	@Test(priority = 2)
	public void testDefaultPricingYesPriceNotSet()
	{
		Log.info("Create Customer With Default Pricing Yes But Fb Price Not Set And Check FiltaBio Is Checked Or Not!!");
		extentLogger = extent.createTest(
				"Test Case 3: Create Customer With Default Pricing Yes But Fb Price Not Set And Check FiltaBio Is Checked Or Not!!");
		createCustomerFiltabio.createCustomerDefaultPricingYesFBPriceNotSet();
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
			screenshotPath = System.getProperty("user.dir") + "/Create_Customer_FB_TestCase/" + testResult.getName()
					+ dateName + "_" + Arrays.toString(testResult.getParameters()) + ".png";
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
		Log.info("Create Customer FiltaBio Test Case Ends Here");
		extent.flush();
		createCustomerFiltabio.closeBrowser();
	}
}
