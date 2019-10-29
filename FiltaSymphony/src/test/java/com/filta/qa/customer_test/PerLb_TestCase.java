package com.filta.qa.customer_test;

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
import com.filta.qa.customer_page.PerLbCustomerPage;
import com.filta.qa.util.Global;

public class PerLb_TestCase
{
	private WebDriver driver;
	private PerLbCustomerPage perLbCustomer;
	private Global globalObj;
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest extentLogger;
	private String screenshotPath;
	private String checkCustomerName;
	private String customerName;
	private Properties prop;
	private String dateName;
	private File scrFile;
	
	public static Logger log = Logger.getLogger("Per Lb Test Case");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}


	@BeforeClass
	public void property()
	{
		globalObj = new Global();
		driver = globalObj.driver();
		prop = globalObj.readProperties();
		perLbCustomer = new PerLbCustomerPage(driver);
		perLbCustomer.login();
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/UserPage/PerLb_TestCase.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 7 64 Bit");
		extent.setSystemInfo("Browser", "Google Chrome");
		extent.setSystemInfo("Author:", "Kunal Chavan");
		extent.setSystemInfo("Testing:", "Functional Testing");
		htmlReporter.config().setReportName("Per Lb Page Functionality Test Case");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		htmlReporter.loadXMLConfig("./extent-config.xml");
		checkCustomerName = checkDefaultPricingOfFranchisee();
		if (checkCustomerName.equals(prop.getProperty("Customer1")))
		{
			perLbCustomer.clickingWebElement();
			perLbCustomer.location();
			perLbCustomer.fryer();
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
		log.info("Per Lb Customer Test!!");
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
		log.info("Test Case1: Check Franchisee Default Pricing");
		extentLogger = extent.createTest("Test Case 1: Check Franchisee Default Pricing");
		customerName = perLbCustomer.defaultPricingFranchiseeLevel();
		return customerName;
	}


	public void checkCustomerBasicInfo()
	{
		log.info("Create Customer Basic info");
		extentLogger = extent.createTest("Test Case 2:Create Customer Basic info");
		perLbCustomer.createCustomer();
		perLbCustomer.basicInfo();
	}


	public void pricing_EstimatingInfo()
	{
		log.info("Check Customer Pricing and Estimating Checkboxes And Default Dropdown Values");
		extentLogger = extent.createTest(
				"Test Case 3: Check Customer Pricing and Estimating Checkboxes And Default Dropdown Values");
		perLbCustomer.pricing();
	}


	public void marketingInfo()
	{
		log.info("Create Customer Marketing Info");
		perLbCustomer.marketing();
	}


	public void unitInfo()
	{
		log.info("Create Customer Unit Info");
		perLbCustomer.unit_Data();
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
			screenshotPath = System.getProperty("user.dir") + "/PerLb_TestCase/" + testResult.getName() + dateName
					+ "_" + Arrays.toString(testResult.getParameters()) + ".png";
			FileUtils.copyFile(scrFile, new File(screenshotPath));
			extentLogger.fail("Test Case Failed Snapshot Is Below " + extentLogger.addScreenCaptureFromPath(screenshotPath));

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


	public void afterMethod()
	{
		log.info("Per Fryer Page Test Case Ends Here");
		extent.flush();
		perLbCustomer.closeBrowser();
	}
}
