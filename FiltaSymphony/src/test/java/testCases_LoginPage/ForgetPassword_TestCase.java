package testCases_LoginPage;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.ForgetPassword;
import util.Global;

public class ForgetPassword_TestCase {
	private Global global;
	private Properties Prop;
	private ForgetPassword forgotpassword;

	public static Logger log = Logger.getLogger("Forget Password Test Case");
	static {
		PropertyConfigurator.configure("C:\\Users\\Kunal\\git\\repository\\FiltaSymphony\\configs\\Log4j.properties");
	}

	@BeforeClass
	public void property() {
		global = new Global();
		Prop = global.readProperties();
		forgotpassword = new ForgetPassword();
	}

	@Test
	public void forgotpassword() {
		log.info("Forgot Password Check With Valid UserName and Email");
		forgotpassword.clickForgotPassword();
		forgotpassword.forgotPassword();
	}

	@AfterMethod
	public void afterMethod() {
		log.info("Forgot Password Test Case Ends Here");
		//forgotpassword.closeBrowser();
	}
}
