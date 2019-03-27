package testCases_LoginPage;

//import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.ForgetPassword;
//import util.Global;

public class ForgetPassword_TestCase {
	// private Global global;
	// private Properties Prop;
	private ForgetPassword forgotpassword;

	public static Logger log = Logger.getLogger("Forget Password Test Case");
	static {
		PropertyConfigurator.configure("C:\\Users\\Kunal\\git\\repository\\FiltaSymphony\\configs\\Log4j.properties");
	}

	@BeforeClass
	public void property() {
		// global = new Global();
		// Prop = global.readProperties();
		forgotpassword = new ForgetPassword();
	}

	@Test
	public void forgotpassword() {
		log.info("Forgot Password Check With Valid UserName and Email");
		forgotpassword.clickForgotPassword();
		forgotpassword.forgotPassword();
		forgotpassword.assertCheckValid();
	}

	@Test(priority = 1)
	public void forgotpasswordInvalid() {
		log.info("Forgot Password Check With InValid UserName and Email");
		forgotpassword.forgotPasswordInvalid();
		forgotpassword.assertCheckValid2();
	}

	@Test(priority = 2)
	public void forgotpasswordInvalid2() {
		log.info("Forgot Password Check WithOut UserName and Email");
		forgotpassword.forgotPasswordInvalid2();
		forgotpassword.assertCheckValid3();
	}

	@Test(priority = 3)
	public void forgotpasswordInvalid3() {
		log.info("Forgot Password Check WithOut UserName and With Email");
		forgotpassword.forgotPasswordInvalid3();
		forgotpassword.assertCheckValid4();
	}

	@Test(priority = 4)
	public void forgotpasswordInvalid4() {
		log.info("Forgot Password Check With UserName and WithOut Email");
		forgotpassword.forgotPasswordInvalid4();
		forgotpassword.assertCheckValid5();
	}

	@Test(priority = 5)
	public void textboxCheck() {
		log.info("Forgot Password Textbox Check");
		forgotpassword.assertCheckboxCheck();
	}

	@Test(priority = 6)
	public void labelCheck() {
		log.info("Forgot Password Label Check");
		forgotpassword.labelCheck();
	}

	@AfterClass
	public void afterMethod() {
		log.info("Forgot Password Test Case Ends Here");
		forgotpassword.closeBrowser();
	}
}
