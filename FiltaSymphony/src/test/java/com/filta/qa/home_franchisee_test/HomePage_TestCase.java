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

	private WebDriver driver;
	private HomePage homepage;
	private Global global_Obj;
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest extentLogger;
	private String screenshotPath;
	private String dateName;
	private File scrFile;
	
	public static Logger log = Logger.getLogger("Home page test case");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}


	@BeforeClass
	public void property()
	{
		global_Obj = new Global();
		driver = global_Obj.driver();
		homepage = new HomePage(driver);
		homepage.login();
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/UserPage/HomePage_TestCase.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 7 64 Bit");
		extent.setSystemInfo("Browser", "Google Chrome");
		extent.setSystemInfo("Author:", "Kunal Chavan");
		extent.setSystemInfo("Testing:", "Functional Testing");
		htmlReporter.config().setReportName("Home page functionality test case");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		htmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test(priority = 0)
	public void checkMenubar()
	{
		log.info("Check menubar of home page");
		extentLogger = extent.createTest("Test case 1: Check menubar of home page");
		homepage.menuBar();
	}


	@Test(priority = 1)
	public void menuScreenCheck()
	{
		log.info("Check menu screen on home page");
		extentLogger = extent.createTest("Test case 2: Check menu screen on home page");
		homepage.customers();
		homepage.leads();
		homepage.nca();
		homepage.filtaBio();
		homepage.techHiring();
		homepage.myFranchisee();
		homepage.filtaGold();
	}


	@Test(priority = 2)
	public void checkText()
	{
		log.info("Check text on home page");
		extentLogger = extent.createTest("Test case 3: Check text on home page");
		//homepage.checkText();
	}


	@Test(priority = 3)
	public void checkTable()
	{
		log.info("Check table on home page");
		extentLogger = extent.createTest("Test case 4: Check table on home page");
		//homepage.tableTest();
	}


	@Test(priority = 4)
	public void checkToolTip()
	{
		log.info("Check tooltip on home page");
		extentLogger = extent.createTest("Test case 5: Check tooltip on home page");
		homepage.toolTipCheck();
	}


	@Test(priority = 5)
	public void checkWidget()
	{
		log.info("Check widget on home page");
		extentLogger = extent.createTest("Test case 6: Check widget on home page");
		homepage.widgetTesting();
	}


	@Test(priority = 6)
	public void checkColor()
	{
		log.info("Check color on home page");
		extentLogger = extent.createTest("Test case 7: Check color on home page");
		homepage.colorCheck();
	}


	@Test(priority = 7)
	public void checkUserNameOnHomePage()
	{
		log.info("Check user name on home page");
		extentLogger = extent.createTest("Test case 8: Check user name on home page");
		homepage.checkUserNameOnHomePage();
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
			screenshotPath = System.getProperty("user.dir") + "/HomePage_errorScreenshots/" + testResult.getName()
					+ dateName + "_" + Arrays.toString(testResult.getParameters()) + ".png";
			FileUtils.copyFile(scrFile, new File(screenshotPath));
			extentLogger.fail("Test Case Failed Snapshot is below " + extentLogger.addScreenCaptureFromPath(screenshotPath));

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
	public void afterMethod()
	{
		log.info("Home page test case ends here");
		extent.flush();
		homepage.closeBrowser();
	}
}
