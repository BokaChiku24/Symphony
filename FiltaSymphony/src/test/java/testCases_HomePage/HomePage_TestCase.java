package testCases_HomePage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

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
import org.testng.ITestResult;

import util.Global;
import pageObjects_HomePage.HomePage;

public class HomePage_TestCase {

	private HomePage Homepage;
	private Global global;
	private WebDriver driver;

	public static Logger log = Logger.getLogger("Home Page Test Case");
	static {
		PropertyConfigurator.configure(".//Log4j.properties");
	}

	@BeforeClass
	public void property() {
		global = new Global();
		driver = global.driver();
		Homepage = new HomePage(driver);
		Homepage.login();
	}

	@Test(priority = 0)
	public void checkMenubar() {
		log.info("Check Menubar Of Home Page");
		Homepage.menuBar();
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("HomePage_errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".jpg"));
		}
	}

	@AfterClass
	public void afterMethod() {
		log.info("Home Page Test Case Ends Here");
		Homepage.closeBrowser();
	}
}
