package com.filta.qa.login_test;

/**
 * @author Kunal
 *
 * Forgot Password Test Cases
 */

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
import com.filta.qa.login_page.ForgetPassword;
import com.filta.qa.util.Global;

public class ForgetPassword_TestCase
{
	private WebDriver driver;
	private ForgetPassword forgotPassword;
	private Global global_Obj;
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest extentLogger;
	private String screenshotPath;
	private String dateName;
	private File scrFile;

	public static Logger log = Logger.getLogger("Forget password test case");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}


	@BeforeClass
	public void beforeClass()
	{
		global_Obj = new Global();
		driver = global_Obj.driver();
		forgotPassword = new ForgetPassword(driver);
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/HomePage/ForgetPassword_TestCase.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 7 64 Bit");
		extent.setSystemInfo("Browser", "Google Chrome");
		extent.setSystemInfo("Author:", "Kunal Chavan");
		extent.setSystemInfo("Testing:", "Functional Testing");
		htmlReporter.config().setReportName("Forgot password functionality test case");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		htmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test(priority = 0)
	public void checkLink()
	{
		log.info("Test case 0: Get all URL names");
		extentLogger = extent.createTest("Test case 0: Get all URL names");
		forgotPassword.getURL();
	}


	@Test(priority = 0, dependsOnMethods = "checkLink")
	public void brokenLink()
	{
		log.info("Test case 0: Get all URL names");
		extentLogger = extent.createTest("Test case 0: Get all URL names");
		forgotPassword.brokenLink();
	}


	@Test(dependsOnMethods = "checkLink")
	public void forgotPassWord()
	{
		log.info("Test case 1: Forgot password check with valid username and email");
		extentLogger = extent.createTest("Test case 1: Forgot password check with valid username and email");
		forgotPassword.clickForgotPassword();
		forgotPassword.forgotPassword();
		forgotPassword.assertCheckValid();
	}


	@Test(priority = 1)
	public void forgotPassWordInvalid()
	{
		log.info("Test case 2: Forgot password check with invalid username and email");
		extentLogger = extent.createTest("Test case 2: Forgot password check with invalid username and email");
		forgotPassword.forgotPasswordInvalid();
		forgotPassword.assertCheckValid2();
	}


	@Test(priority = 2)
	public void forgotPassWordInvalid2()
	{
		log.info("Test case 3: Forgot password check without username and email");
		extentLogger = extent.createTest("Test case 3: Forgot password check without username and email");
		forgotPassword.forgotPasswordInvalid2();
		forgotPassword.assertCheckValid3();
	}


	@Test(priority = 3)
	public void forgotPassWordInvalid3()
	{
		log.info("Test case 4: Forgot password check without username and with email");
		extentLogger = extent.createTest("Test case 4: Forgot password check without username and with email");
		forgotPassword.forgotPasswordInvalid3();
		forgotPassword.assertCheckValid4();
	}


	@Test(priority = 4)
	public void forgotPassWordInvalid4()
	{
		log.info("Test case 5: Forgot password check with username and without email");
		extentLogger = extent.createTest("Test case 5: Forgot password check with username and without email");
		forgotPassword.forgotPasswordInvalid4();
		forgotPassword.assertCheckValid5();
	}


	@Test(priority = 5)
	public void textboxCheck()
	{
		log.info("Test case 6: Forgot password textbox check");
		extentLogger = extent.createTest("Test case 6: Forgot password textbox check");
		forgotPassword.assertCheckboxCheck();
	}


	@Test(priority = 6)
	public void labelCheck()
	{
		log.info("Test case 7: Forgot password label check");
		extentLogger = extent.createTest("Test case 7: Forgot password label check");
		forgotPassword.labelCheck();
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
			screenshotPath = System.getProperty("user.dir") + "/ForgotPassword_errorScreenshots/"
					+ testResult.getName() + dateName + "_" + Arrays.toString(testResult.getParameters()) + ".png";
			FileUtils.copyFile(scrFile, new File(screenshotPath));
			extentLogger.fail(
					"Test case failed snapshot is below " + extentLogger.addScreenCaptureFromPath(screenshotPath));

		}
		else if (testResult.getStatus() == ITestResult.SKIP)
		{
			extentLogger.log(Status.SKIP,
					MarkupHelper.createLabel(testResult.getName() + " - Test case skipped", ExtentColor.ORANGE));
		}
		else if (testResult.getStatus() == ITestResult.SUCCESS)
		{
			extentLogger.log(Status.PASS,
					MarkupHelper.createLabel(testResult.getName() + " - Test case passed", ExtentColor.GREEN));
		}
	}


	@AfterClass
	public void afterClass()
	{
		log.info("Forgot password test case ends here");
		extent.flush();
		forgotPassword.closeBrowser();
	}
}
