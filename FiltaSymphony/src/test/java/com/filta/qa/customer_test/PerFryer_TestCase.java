package com.filta.qa.customer_test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

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
import com.filta.qa.customer_page.PerFryerCustomerPage;
import com.filta.qa.util.Global;

import org.testng.ITestResult;

public class PerFryer_TestCase
{
	private WebDriver Driver;
	private PerFryerCustomerPage PerFryer_Customer;
	private Global Global_Obj;
	private ExtentReports Extent;
	private ExtentHtmlReporter HtmlReporter;
	private ExtentTest ExtentLogger;
	private String ScreenshotPath;
	private Properties Prop;
	private String ActualCustomer;
	private String DateName;
	private File ScrFile;

	public static Logger Log = Logger.getLogger("Per Fryer Test Case");
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
		PerFryer_Customer = new PerFryerCustomerPage(Driver);
		PerFryer_Customer.login();
		HtmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/UserPage/PerFryer_TestCase.html");
		Extent = new ExtentReports();
		Extent.attachReporter(HtmlReporter);
		Extent.setSystemInfo("OS", "Windows 7 64 Bit");
		Extent.setSystemInfo("Browser", "Google Chrome");
		Extent.setSystemInfo("Author:", "Kunal Chavan");
		Extent.setSystemInfo("Testing:", "Functional Testing");
		HtmlReporter.config().setReportName("Per Fryer Page Functionality Test Case");
		HtmlReporter.config().setTheme(Theme.STANDARD);
		HtmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		HtmlReporter.loadXMLConfig("./extent-config.xml");
		ActualCustomer = checkDefaultPricingOfFranchisee();
		if (ActualCustomer.equals(Prop.getProperty("Customer2")))
		{
			PerFryer_Customer.clickingWebElement();
			PerFryer_Customer.location();
			PerFryer_Customer.fryer();
			afterMethod();
		}
		else
		{
			performTest();
			afterMethod();
		}

	}


	@Test
	public void test()
	{
		Log.info("Per Fryer Customer Test!!");
	}


	public void performTest()
	{
		checkCustomerBasicInfo();
		pricing_EstimatingInfo();
		marketingInfo();
		unitInfo();
	}


	public String checkDefaultPricingOfFranchisee()
	{
		Log.info("Check Franchisee Default Pricing");
		Log.info("Test Case1: Check Customer Page URL");
		ExtentLogger = Extent.createTest("Test Case 2: Check Customer Page URL");
		ActualCustomer = PerFryer_Customer.defaultPricingFranchiseeLevel();
		return ActualCustomer;
	}


	public void checkCustomerBasicInfo()
	{
		Log.info("Create Customer Basic info");
		ExtentLogger = Extent.createTest("Test Case 3:Create Customer Basic info");
		PerFryer_Customer.createCustomer();
		PerFryer_Customer.basicInfo();
	}


	public void pricing_EstimatingInfo()
	{
		Log.info("Create Customer Pricing and Estimating Info");
		ExtentLogger = Extent.createTest(
				"Test Case 4: Check Customer Pricing and Estimating Checkboxes And Default Dropdown Values");
		PerFryer_Customer.pricing();
	}


	public void marketingInfo()
	{
		Log.info("Create Customer Marketing Info");
		PerFryer_Customer.marketing();
	}


	public void unitInfo()
	{
		Log.info("Create Customer Unit Info");
		PerFryer_Customer.unit_Data();
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
			ScreenshotPath = System.getProperty("user.dir") + "/PerFryer_TestCase/" + TestResult.getName() + DateName
					+ "_" + Arrays.toString(TestResult.getParameters()) + ".png";
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


	public void afterMethod()
	{
		Log.info("Per Fryer Page Test Case Ends Here");
		Extent.flush();
		PerFryer_Customer.closeBrowser();
	}
}
