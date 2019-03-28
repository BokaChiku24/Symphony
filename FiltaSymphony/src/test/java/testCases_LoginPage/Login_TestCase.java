package testCases_LoginPage;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Login;
import util.Global;
import util.ReadExcelData;

public class Login_TestCase {

	private Login login;
	private Global global;
	private Properties Prop;

	public static Logger log = Logger.getLogger("Sign In Test Case");
	static {
		PropertyConfigurator.configure(".//Log4j.properties");
	}

	@BeforeClass
	public void property() {
		global = new Global();
		Prop = global.readProperties();
		login = new Login();
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
	public void afterMethod() {
		log.info("Sign In Test Case Ends Here");
		login.driverClose();
	}
}
