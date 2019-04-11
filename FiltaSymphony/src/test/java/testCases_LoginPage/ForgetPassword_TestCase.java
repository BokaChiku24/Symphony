package testCases_LoginPage;

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

import pageObjects_LoginPage.ForgetPassword;
import util.Global;

public class ForgetPassword_TestCase
{
	private ForgetPassword forgotpassword;
	private Global global;
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest logger;
	private String screenshotPath;

	public static Logger log = Logger.getLogger("Forget Password Test Case");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}


	@BeforeClass
	public void property()
	{
		global = new Global();
		driver = global.driver();
		forgotpassword = new ForgetPassword(driver);
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/HomePage/ForgetPassword_TestCase.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 7 64 Bit");
		extent.setSystemInfo("Browser", "Google Chrome");
		extent.setSystemInfo("Author:", "Kunal Chavan");
		extent.setSystemInfo("Testing:", "Functional Testing");
		htmlReporter.config().setReportName("Forgot Password Functionality Test Case");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		htmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test
	public void forgotpassword()
	{
		log.info("Test Case 1: Forgot Password Check With Valid UserName and Email");
		logger = extent.createTest("Test Case 1: Forgot Password Check With Valid UserName and Email");
		forgotpassword.clickForgotPassword();
		forgotpassword.forgotPassword();
		forgotpassword.assertCheckValid();
	}


	@Test(priority = 1)
	public void forgotpasswordInvalid()
	{
		log.info("Test Case 2: Forgot Password Check With InValid UserName and Email");
		logger = extent.createTest("Test Case 2: Forgot Password Check With InValid UserName and Email");
		forgotpassword.forgotPasswordInvalid();
		forgotpassword.assertCheckValid2();
	}


	@Test(priority = 2)
	public void forgotpasswordInvalid2()
	{
		log.info("Test Case 3: Forgot Password Check WithOut UserName and Email");
		logger = extent.createTest("Test Case 3: Forgot Password Check WithOut UserName and Email");
		forgotpassword.forgotPasswordInvalid2();
		forgotpassword.assertCheckValid3();
	}


	@Test(priority = 3)
	public void forgotpasswordInvalid3()
	{
		log.info("Test Case 4: Forgot Password Check WithOut UserName and With Email");
		logger = extent.createTest("Test Case 4: Forgot Password Check WithOut UserName and With Email");
		forgotpassword.forgotPasswordInvalid3();
		forgotpassword.assertCheckValid4();
	}


	@Test(priority = 4)
	public void forgotpasswordInvalid4()
	{
		log.info("Test Case 5: Forgot Password Check With UserName and WithOut Email");
		logger = extent.createTest("Test Case 5: Forgot Password Check WithOut UserName and With Email");
		forgotpassword.forgotPasswordInvalid4();
		forgotpassword.assertCheckValid5();
	}


	@Test(priority = 5)
	public void textboxCheck()
	{
		log.info("Test Case 6: Forgot Password Textbox Check");
		logger = extent.createTest("Test Case 6: Forgot Password Textbox Check");
		forgotpassword.assertCheckboxCheck();
	}


	@Test(priority = 6)
	public void labelCheck()
	{
		log.info("Test Case 7: Forgot Password Label Check");
		logger = extent.createTest("Test Case 7: Forgot Password Label Check");
		forgotpassword.labelCheck();
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
			screenshotPath = System.getProperty("user.dir") + "/ForgotPassword_errorScreenshots/"
					+ testResult.getName() + dateName + "_" + Arrays.toString(testResult.getParameters()) + ".png";
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
		log.info("Forgot Password Test Case Ends Here");
		extent.flush();
		forgotpassword.closeBrowser();
	}
}
