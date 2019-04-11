package testCases_LoginPage;

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

import pageObjects_LoginPage.Login;
import util.Global;

public class LogInInvalid_TestCase
{
	private Login login;
	private Global global;
	private Properties Prop;
	private WebDriver driver;
	private ExtentHtmlReporter htmlReporter;
	private ExtentReports extent;
	private ExtentTest logger;
	private String screenshotPath;

	public static Logger log = Logger.getLogger("Sign In With Invalid Credentials Test Case");
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
		login = new Login(driver);
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Symphony_Reports/HomePage/LoginInvalid_TestCase.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 7 64 Bit");
		extent.setSystemInfo("Browser", "Google Chrome");
		extent.setSystemInfo("Author:", "Kunal Chavan");
		extent.setSystemInfo("Testing:", "Functional Testing");
		htmlReporter.config().setReportName("Login Invalid Functionality Test Case");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		htmlReporter.loadXMLConfig("./extent-config.xml");
	}


	@Test(priority = 0)
	public void signInWithInvalidCredentails()
	{
		log.info("Test Case 1: Check Login functionality with invalid credentials");
		logger = extent.createTest("Test Case 1: Check Login functionality with invalid credentials");
		login.enterUserName(Prop.getProperty("InvalidUname1"));
		login.enterPassword(Prop.getProperty("InvalidPassword1"));
		login.clickSubmit();
		login.assertCheck2();
	}


	@Test(priority = 1)
	public void signInWithInvalidCredentails2()
	{
		log.info("Test Case 2: Check Login functionality without credentials");
		logger = extent.createTest("Test Case 2: Check Login functionality without credentials");
		login.clearText();
		login.enterUserName("");
		login.enterPassword("");
		login.clickSubmit();
		login.assertCheck2();
	}


	@Test(priority = 2)
	public void signInWithInvalidCredentails3()
	{
		log.info("Test Case 3: Check Login functionality withInvalid credentials");
		logger = extent.createTest("Test Case 3: Check Login functionality withInvalid credentials");
		login.clearText();
		login.enterUserName(Prop.getProperty("InvalidUname1"));
		login.enterPassword("");
		login.clickSubmit();
		login.assertCheck2();
	}


	@Test(priority = 2)
	public void signInWithInvalidCredentails4()
	{
		log.info("Test Case 4: Check Login functionality withInvalid credentials");
		logger = extent.createTest("Test Case 4: Check Login functionality withInvalid credentials");
		login.clearText();
		login.enterUserName("");
		login.enterPassword(Prop.getProperty("InvalidPassword1"));
		login.clickSubmit();
		login.assertCheck2();
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
			screenshotPath = System.getProperty("user.dir") + "/LoginInValid_errorScreenshots/"
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
		log.info("Sign In Test Case Ends Here");
		extent.flush();
		login.driverClose();
	}
}
