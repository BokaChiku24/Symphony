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
	private WebDriver driver;
	private PerFryerCustomerPage perFryer_Customer;
	private Global global_Obj;
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest extentLogger;
	private String screenshotPath;
	private Properties prop;
	private String actualCustomer;
	private String dateName;
	private File scrFile;

	public static Logger log = Logger.getLogger("Per Fryer Test Case");
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
		perFryer_Customer = new PerFryerCustomerPage(driver);
		perFryer_Customer.login();
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/UserPage/PerFryer_TestCase.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 7 64 Bit");
		extent.setSystemInfo("Browser", "Google Chrome");
		extent.setSystemInfo("Author:", "Kunal Chavan");
		extent.setSystemInfo("Testing:", "Functional Testing");
		htmlReporter.config().setReportName("Per Fryer Page Functionality Test Case");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		htmlReporter.loadXMLConfig("./extent-config.xml");
		actualCustomer = checkDefaultPricingOfFranchisee();
		if (actualCustomer.equals(prop.getProperty("Customer2")))
		{
			perFryer_Customer.clickingWebElement();
			perFryer_Customer.location();
			perFryer_Customer.fryer();
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
		log.info("Per Fryer Customer Test!!");
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
		log.info("Check Franchisee Default Pricing");
		log.info("Test Case1: Check Customer Page URL");
		extentLogger = extent.createTest("Test Case 2: Check Customer Page URL");
		actualCustomer = perFryer_Customer.defaultPricingFranchiseeLevel();
		return actualCustomer;
	}


	public void checkCustomerBasicInfo()
	{
		log.info("Create Customer Basic info");
		extentLogger = extent.createTest("Test Case 3:Create Customer Basic info");
		perFryer_Customer.createCustomer();
		perFryer_Customer.basicInfo();
	}


	public void pricing_EstimatingInfo()
	{
		log.info("Create Customer Pricing and Estimating Info");
		extentLogger = extent.createTest(
				"Test Case 4: Check Customer Pricing and Estimating Checkboxes And Default Dropdown Values");
		perFryer_Customer.pricing();
	}


	public void marketingInfo()
	{
		log.info("Create Customer Marketing Info");
		perFryer_Customer.marketing();
	}


	public void unitInfo()
	{
		log.info("Create Customer Unit Info");
		perFryer_Customer.unit_Data();
	}


	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult TestResult) throws IOException
	{
		if (TestResult.getStatus() == ITestResult.FAILURE)
		{
			extentLogger.log(Status.FAIL,
					MarkupHelper.createLabel(TestResult.getName() + " - Test Case Failed", ExtentColor.RED));
			extentLogger.log(Status.FAIL,
					MarkupHelper.createLabel(TestResult.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			dateName = new SimpleDateFormat("dd MMMM yyyy zzzz").format(new Date());
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			screenshotPath = System.getProperty("user.dir") + "/PerFryer_TestCase/" + TestResult.getName() + dateName
					+ "_" + Arrays.toString(TestResult.getParameters()) + ".png";
			FileUtils.copyFile(scrFile, new File(screenshotPath));
			extentLogger.fail("Test Case Failed Snapshot is below " + extentLogger.addScreenCaptureFromPath(screenshotPath));

		}
		else if (TestResult.getStatus() == ITestResult.SKIP)
		{
			extentLogger.log(Status.SKIP,
					MarkupHelper.createLabel(TestResult.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
		else if (TestResult.getStatus() == ITestResult.SUCCESS)
		{
			extentLogger.log(Status.PASS,
					MarkupHelper.createLabel(TestResult.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
	}


	public void afterMethod()
	{
		log.info("Per Fryer Page Test Case Ends Here");
		extent.flush();
		perFryer_Customer.closeBrowser();
	}
}
