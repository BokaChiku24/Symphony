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
import com.filta.qa.customer_page.Create_CustomerFB;
import com.filta.qa.util.Global;

/**
 * @author kun24
 * @implNote Customer Create Test Case With FB
 */

public class Create_CustomerFB_TestCase
{
	private WebDriver Driver;
	private Create_CustomerFB create_customer_filtabio;
	private Global Global_Obj;
	private ExtentReports Extent;
	private ExtentHtmlReporter HtmlReporter;
	private ExtentTest ExtentLogger;
	private String ScreenshotPath;;
	private String DateName;
	private File ScrFile;

	public static Logger Log = Logger.getLogger("Create Customer FiltaBio Scenarios");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}

	@BeforeClass
	public void property()
	{
		Global_Obj = new Global();
		Driver = Global_Obj.driver();
		// Prop = Global_Obj.readProperties();
		create_customer_filtabio = new Create_CustomerFB(Driver);
		create_customer_filtabio.login();
		HtmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/UserPage/Create_Customer_FB_TestCase.html");
		Extent = new ExtentReports();
		Extent.attachReporter(HtmlReporter);
		Extent.setSystemInfo("OS", "Windows 7 64 Bit");
		Extent.setSystemInfo("Browser", "Google Chrome");
		Extent.setSystemInfo("H", "Kunal Chavan");
		Extent.setSystemInfo("Testing:", "Functional Testing");
		HtmlReporter.config().setReportName("Per Fryer Page Functionality Test Case");
		HtmlReporter.config().setTheme(Theme.STANDARD);
		HtmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		HtmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test(priority = 0)
	public void test()
	{
		Log.info("Create Customer With Default Pricing No And Check FiltaBio Is Checked Or Not!!");
		ExtentLogger = Extent.createTest(
				"Test Case 1: Create Customer With Default Pricing No And Check FiltaBio Is Checked Or Not");
		create_customer_filtabio.createCustomerDefaultPricingNo();
	}


	@Test(priority = 1)
	public void testDefaultPricingYes()
	{
		Log.info("Create Customer With Default Pricing Yes And Check FiltaBio Is Checked Or Not!!");
		ExtentLogger = Extent.createTest(
				"Test Case 1: Create Customer With Default Pricing Yes And Check FiltaBio Is Checked Or Not");
		create_customer_filtabio.createCustomerDefaultPricingYesFBPriceSet();
	}


	@Test(priority = 2)
	public void testDefaultPricingYesPriceNotSet()
	{
		Log.info("Create Customer With Default Pricing Yes But Fb Price Not Set And Check FiltaBio Is Checked Or Not!!");
		ExtentLogger = Extent.createTest(
				"Test Case 1: Create Customer With Default Pricing Yes But Fb Price Not Set And Check FiltaBio Is Checked Or Not!!");
		create_customer_filtabio.createCustomerDefaultPricingYesFBPriceNotSet();
	}


	@Test(priority = 3)
	public void testLeadToCustomer()
	{
		Log.info("Create Customer With Converting Lead!!");
		ExtentLogger = Extent.createTest(
				"Test Case 1: Create Customer With Converting Lead!!");
		create_customer_filtabio.leadToCustomer();
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
			ScreenshotPath = System.getProperty("user.dir") + "/Create_Customer_FB_TestCase/" + TestResult.getName()
					+ DateName + "_" + Arrays.toString(TestResult.getParameters()) + ".png";
			FileUtils.copyFile(ScrFile, new File(ScreenshotPath));
			ExtentLogger.fail(
					"Test Case Failed Snapshot is below " + ExtentLogger.addScreenCaptureFromPath(ScreenshotPath));

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
		Log.info("Create Customer FiltaBio Test Case Ends Here");
		Extent.flush();
	//	create_customer_filtabio.closeBrowser();
	}
}
