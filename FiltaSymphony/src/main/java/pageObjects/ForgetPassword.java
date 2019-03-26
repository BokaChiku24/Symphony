package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import util.Global;

public class ForgetPassword {
	WebDriver driver;
	Global global;
	private Properties Prop;

	public ForgetPassword() {
		global = new Global();
		driver = global.driver();
		PageFactory.initElements(driver, this);
		Prop = global.readProperties();
	}

	@FindBy(how = How.LINK_TEXT, using = "Forgot Password?")
	private WebElement Forgot_Password;

	@FindBy(how = How.XPATH, using = ".//div[@id='forgot_password_dialog']//input[@id='fp_user_name']")
	private WebElement Forgot_Password_Username;

	@FindBy(how = How.XPATH, using = ".//div[@id='forgot_password_dialog']//input[@id='fp_user_mail']")
	private WebElement Forgot_Password_Email;

	@FindBy(how = How.XPATH, using = ".//div[@id='forgot_password_dialog']//input[@id='generate_pwd_button']")
	private WebElement Forgot_Password_Submit;

	@FindBy(how = How.XPATH, using = ".//div[@id='generate_success']")
	private WebElement success_Message;

	public void clickForgotPassword() {
		Forgot_Password.click();
	}

	public void forgotPassword() {
		Forgot_Password_Username.sendKeys(Prop.getProperty("uname"));
		Forgot_Password_Email.sendKeys(Prop.getProperty("Email"));
		Forgot_Password_Submit.click();
	}

	public void assertCheckValid() {
		global.wait(driver).until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//div[@id='generate_success']"), "Your request has been submitted."));
		assertEquals(success_Message.getText(), Prop.getProperty("Message"));
	}

	public void closeBrowser() {
		driver.close();
	}
}
