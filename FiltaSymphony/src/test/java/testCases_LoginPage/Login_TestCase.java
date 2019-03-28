package testCases_LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects_LoginPage.Login;
import util.Global;
import util.ReadExcelData;

public class Login_TestCase {

	private Login login;
	private Global global;
	private Properties Prop;
	private WebDriver driver;

	public static Logger log = Logger.getLogger("Sign In Test Case");
	static {
		PropertyConfigurator.configure(".//Log4j.properties");
	}

	@BeforeClass
	public void property() {
		global = new Global();
		driver = global.driver();
		Prop = global.readProperties();
		login = new Login(driver);
	}

	@DataProvider(name = "getData")
	public String[][] getDataFromExcel() {
		ReadExcelData data = new ReadExcelData(Prop.getProperty("Path"), "Valid");
		int totalRows = data.getTotalRows();
		int totalColumn = data.getTotalColumns();
		String[][] array = new String[totalRows][totalColumn];
		array[0][0] = data.getCellData(0, 0);
		array[0][1] = data.getCellData(0, 1);
		return array;
	}

	@Test(dataProvider = "getData")
	public void SignInTesting(String Uname, String Password) {
		log.info("Test Case :check Login functionality with valid credentials");
		login.enterUserName(Uname);
		login.enterPassword(Password);
		login.clickSubmit();
		login.assertCheck();
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("Login_errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".jpg"));
		}
	}

	@AfterClass
	public void afterMethod() {
		log.info("Sign In Test Case Ends Here");
		login.driverClose();
	}
}
