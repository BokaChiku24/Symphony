package testCases_HomePageFranchisee;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageObjects_HomePageFranchisee.HomePage;

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

import org.testng.ITestResult;
import util.Global;

public class HomePage_TestCase
{

	private HomePage Homepage;
	private Global global;
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest logger;
	private String screenshotPath;

	public static Logger log = Logger.getLogger("Home Page Test Case");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}


	@BeforeClass
	public void property()
	{
		global = new Global();
		driver = global.driver();
		Homepage = new HomePage(driver);
		Homepage.login();
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/UserPage/HomePage_TestCase.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 7 64 Bit");
		extent.setSystemInfo("Browser", "Google Chrome");
		extent.setSystemInfo("Author:", "Kunal Chavan");
		extent.setSystemInfo("Testing:", "Functional Testing");
		htmlReporter.config().setReportName("Home Page Functionality Test Case");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		htmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test(priority = 0)
	public void checkMenubar()
	{
		log.info("Check Menubar Of Home Page");
		logger = extent.createTest("Test Case 1: Check Menubar Of Home Page");
		Homepage.menuBar();
	}


	@Test(priority = 1)
	public void menuScreenCheck()
	{
		log.info("Check Menu Screen On Home Page");
		logger = extent.createTest("Test Case 2: Check Menu Screen On Home Page");
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
		log.info("Check Text On Home Page");
		logger = extent.createTest("Test Case 3: Check Text On Home Page");
		Homepage.checkText();
	}


	@Test(priority = 3)
	public void checkTable()
	{
		log.info("Check Table On Home Page");
		logger = extent.createTest("Test Case 4: Check Table On Home Page");
		Homepage.tableTest();
	}


	@Test(priority = 4)
	public void checkToolTip()
	{
		log.info("Check Tooltip on Home Page");
		logger = extent.createTest("Test Case 5: Check Tooltip on Home Page");
		Homepage.toolTipCheck();
	}


	@Test(priority = 5)
	public void checkWidget()
	{
		log.info("Check Widget On Home Page");
		logger = extent.createTest("Test Case 6: Check Widget On Home Page");
		Homepage.widgetTesting();
	}


	@Test(priority = 6)
	public void checkColor()
	{
		log.info("Check Color On Home Page");
		logger = extent.createTest("Test Case 7: Check Color On Home Page");
		Homepage.colorCheck();
	}


	@Test(priority = 7)
	public void checkUserNameOnHomePage()
	{
		log.info("Check User Name On Home Page");
		logger = extent.createTest("Test Case 8: Check User Name On Home Page");
		Homepage.checkUserNameOnHomePage();
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
			screenshotPath = System.getProperty("user.dir") + "/HomePage_errorScreenshots/" + testResult.getName()
					+ dateName + "_" + Arrays.toString(testResult.getParameters()) + ".png";
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


	@AfterClass
	public void afterMethod()
	{
		log.info("Home Page Test Case Ends Here");
		extent.flush();
		Homepage.closeBrowser();
	}
}
