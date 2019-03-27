package testCases_LoginPage;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.Login;
import util.Global;

public class LoginInvalid_TestCase {
	private Login login;
	private Global global;
	private Properties Prop;

	public static Logger log = Logger.getLogger("Sign In With Invalid Credentials Test Case");
	static {
		PropertyConfigurator.configure("C:\\Users\\Kunal\\git\\repository\\FiltaSymphony\\configs\\Log4j.properties");
	}

	@BeforeClass
	public void property() {
		global = new Global();
		Prop = global.readProperties();
		login = new Login();
	}

	@Test(priority = 0)
	public void signInWithInvalidCredentails() {
		log.info("Test Case :check Login functionality with invalid credentials");
		login.enterUserName(Prop.getProperty("InvalidUname1"));
		login.enterPassword(Prop.getProperty("InvalidPassword1"));
		login.clickSubmit();
		login.assertCheck2();
	}

	@Test(priority = 1)
	public void signInWithInvalidCredentails2() {
		log.info("Test Case :check Login functionality without credentials");
		login.clearText();
		login.enterUserName("");
		login.enterPassword("");
		login.clickSubmit();
		login.assertCheck2();
	}

	@Test(priority = 2)
	public void signInWithInvalidCredentails3() {
		log.info("Test Case :check Login functionality withInvalid credentials");
		login.clearText();
		login.enterUserName(Prop.getProperty("InvalidUname1"));
		login.enterPassword("");
		login.clickSubmit();
		login.assertCheck2();
	}

	@Test(priority = 2)
	public void signInWithInvalidCredentails4() {
		log.info("Test Case :check Login functionality withInvalid credentials");
		login.clearText();
		login.enterUserName("");
		login.enterPassword(Prop.getProperty("InvalidPassword1"));
		login.clickSubmit();
		login.assertCheck2();
	}

	@AfterClass
	public void afterMethod() {
		log.info("Sign In Test Case Ends Here");
		 login.driverClose();
	}
}
