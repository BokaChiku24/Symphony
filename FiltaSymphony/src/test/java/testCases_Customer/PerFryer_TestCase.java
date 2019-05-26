package testCases_Customer;

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

import org.testng.ITestResult;
import util.Global;

import pageObjects_CustomerPage.PerFryerCustomerPage;

public class PerFryer_TestCase
{
	private PerFryerCustomerPage PerFryer_Customer;
	private Global global;
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest logger;
	private String screenshotPath;
	private Properties Prop;
	private String ActualCustomer;
	
	public static Logger log = Logger.getLogger("Per Fryer Test Case");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}


	@BeforeClass
	public void property()
	{
		global = new Global();
		driver = global.driver();
		Prop = global.readProperties();
		PerFryer_Customer = new PerFryerCustomerPage(driver);
		PerFryer_Customer.login();
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
		ActualCustomer = checkDefaultPricingOfFranchisee();
		if (ActualCustomer.equals(Prop.getProperty("Customer2")))
		{
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
		System.out.println("Per Fryer Customer Test!!");
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
		logger = extent.createTest("Test Case 2: Check Customer Page URL");
		ActualCustomer = PerFryer_Customer.defaultPricingFranchiseeLevel();
		return ActualCustomer;
	}


	public void checkCustomerBasicInfo()
	{
		log.info("Create Customer Basic info");
		logger = extent.createTest("Test Case 3:Create Customer Basic info");
		PerFryer_Customer.createCustomer();
		PerFryer_Customer.basicInfo();
	}


	public void pricing_EstimatingInfo()
	{
		log.info("Create Customer Pricing and Estimating Info");
		logger = extent.createTest(
				"Test Case 4: Check Customer Pricing and Estimating Checkboxes And Default Dropdown Values");
		PerFryer_Customer.pricing();
	}


	public void marketingInfo()
	{
		log.info("Create Customer Marketing Info");
		PerFryer_Customer.marketing();
	}


	public void unitInfo()
	{
		log.info("Create Customer Unit Info");
		PerFryer_Customer.unit_Data();
	}


	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException
	{
		if (testResult.getStatus() == ITestResult.FAILURE)
		{
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(testResult.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(testResult.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			String dateName = new SimpleDateFormat("dd MMMM yyyy zzzz").format(new Date());
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			screenshotPath = System.getProperty("user.dir") + "/PerFryer_TestCase/" + testResult.getName() + dateName
					+ "_" + Arrays.toString(testResult.getParameters()) + ".png";
			FileUtils.copyFile(scrFile, new File(screenshotPath));
			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));

		}
		else if (testResult.getStatus() == ITestResult.SKIP)
		{
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(testResult.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
		else if (testResult.getStatus() == ITestResult.SUCCESS)
		{
			logger.log(Status.PASS,
					MarkupHelper.createLabel(testResult.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
	}


	public void afterMethod()
	{
		log.info("Per Fryer Page Test Case Ends Here");
		extent.flush();
		PerFryer_Customer.closeBrowser();
	}
}
