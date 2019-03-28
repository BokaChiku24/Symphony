package testCases_LoginPage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LoginPage_TestCase {
	private LoginPage loginpage;

	public static Logger log = Logger.getLogger("Sign In Test Case");
	static {
		PropertyConfigurator.configure(".//Log4j.properties");
	}

	@BeforeClass
	public void property() {
		loginpage = new LoginPage();
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

	@AfterClass
	public void closeBrowser() {
		log.info("Login Page test case Ends Here");
		loginpage.closebrowser();
	}
}
