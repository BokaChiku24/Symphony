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
	private WebDriver Driver;
	private ForgetPassword ForgotPassword;
	private Global Global_Obj;
	private ExtentReports Extent;
	private ExtentHtmlReporter HtmlReporter;
	private ExtentTest ExtentLogger;
	private String ScreenshotPath;
	private String DateName;
	private File ScrFile;

	public static Logger Log = Logger.getLogger("Forget Password Test Case");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}


	@BeforeClass
	public void property()
	{
		Global_Obj = new Global();
		Driver = Global_Obj.driver();
		ForgotPassword = new ForgetPassword(Driver);
		HtmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/HomePage/ForgetPassword_TestCase.html");
		Extent = new ExtentReports();
		Extent.attachReporter(HtmlReporter);
		Extent.setSystemInfo("OS", "Windows 7 64 Bit");
		Extent.setSystemInfo("Browser", "Google Chrome");
		Extent.setSystemInfo("Author:", "Kunal Chavan");
		Extent.setSystemInfo("Testing:", "Functional Testing");
		HtmlReporter.config().setReportName("Forgot Password Functionality Test Case");
		HtmlReporter.config().setTheme(Theme.STANDARD);
		HtmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		HtmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test
	public void forgotpassword()
	{
		Log.info("Test Case 1: Forgot Password Check With Valid UserName and Email");
		ExtentLogger = Extent.createTest("Test Case 1: Forgot Password Check With Valid UserName and Email");
		ForgotPassword.clickForgotPassword();
		ForgotPassword.forgotPassword();
		ForgotPassword.assertCheckValid();
	}


	@Test(priority = 1)
	public void forgotpasswordInvalid()
	{
		Log.info("Test Case 2: Forgot Password Check With InValid UserName and Email");
		ExtentLogger = Extent.createTest("Test Case 2: Forgot Password Check With InValid UserName and Email");
		ForgotPassword.forgotPasswordInvalid();
		ForgotPassword.assertCheckValid2();
	}


	@Test(priority = 2)
	public void forgotpasswordInvalid2()
	{
		Log.info("Test Case 3: Forgot Password Check WithOut UserName and Email");
		ExtentLogger = Extent.createTest("Test Case 3: Forgot Password Check WithOut UserName and Email");
		ForgotPassword.forgotPasswordInvalid2();
		ForgotPassword.assertCheckValid3();
	}


	@Test(priority = 3)
	public void forgotpasswordInvalid3()
	{
		Log.info("Test Case 4: Forgot Password Check WithOut UserName and With Email");
		ExtentLogger = Extent.createTest("Test Case 4: Forgot Password Check WithOut UserName and With Email");
		ForgotPassword.forgotPasswordInvalid3();
		ForgotPassword.assertCheckValid4();
	}


	@Test(priority = 4)
	public void forgotpasswordInvalid4()
	{
		Log.info("Test Case 5: Forgot Password Check With UserName and WithOut Email");
		ExtentLogger = Extent.createTest("Test Case 5: Forgot Password Check WithOut UserName and With Email");
		ForgotPassword.forgotPasswordInvalid4();
		ForgotPassword.assertCheckValid5();
	}


	@Test(priority = 5)
	public void textboxCheck()
	{
		Log.info("Test Case 6: Forgot Password Textbox Check");
		ExtentLogger = Extent.createTest("Test Case 6: Forgot Password Textbox Check");
		ForgotPassword.assertCheckboxCheck();
	}


	@Test(priority = 6)
	public void labelCheck()
	{
		Log.info("Test Case 7: Forgot Password Label Check");
		ExtentLogger = Extent.createTest("Test Case 7: Forgot Password Label Check");
		ForgotPassword.labelCheck();
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
			ScreenshotPath = System.getProperty("user.dir") + "/ForgotPassword_errorScreenshots/"
					+ TestResult.getName() + DateName + "_" + Arrays.toString(TestResult.getParameters()) + ".png";
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


	@AfterClass
	public void afterMethod()
	{
		Log.info("Forgot Password Test Case Ends Here");
		Extent.flush();
		ForgotPassword.closeBrowser();
	}
}
