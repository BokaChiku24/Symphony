package testCases_LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

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

import pageObjects_LoginPage.LoginPage;
import util.Global;

public class LoginPage_TestCase {
	private LoginPage loginpage;
	private WebDriver driver;
	private Global global;

	public static Logger log = Logger.getLogger("Sign In Test Case");
	static {
		PropertyConfigurator.configure(".//Log4j.properties");
	}

	@BeforeClass
	public void property() {
		global = new Global();
		driver = global.driver();
		loginpage = new LoginPage(driver);
	}

	@Test
	public void checktext() {
		log.info("Text Check on Login Page");
		loginpage.checkText2();
	}

	@Test(priority = 1)
	public void checkDropDown() {
		log.info("Drop Down Check on Login Page");
		loginpage.dropDown();
	}

	@Test(priority = 2)
	public void footerCheck() {
		log.info("Footer Check on Login Page");
		loginpage.checkText();
	}

	@Test(priority = 3)
	public void checkURL() {
		log.info("URL Check on Login Page");
		loginpage.checkURL();
	}

	@Test(priority = 4)
	public void checkTextBox() {
		log.info("Check Login Page TextBox Enabled Or Not");
		loginpage.checkTextBoxAssert();
	}

	@Test(priority = 5)
	public void checkLabel() {
		log.info("Check Login Page TextBox Label");
		loginpage.checktextBoxLabel();
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("LoginPage_errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".jpg"));
		}
	}

	@AfterClass
	public void closeBrowser() {
		log.info("Login Page test case Ends Here");
		loginpage.closebrowser();
	}
}
