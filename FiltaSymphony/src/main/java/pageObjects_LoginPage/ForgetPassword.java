package pageObjects_LoginPage;

import org.testng.Assert;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import helper.ForgotPassword_Interface;
import util.Global;

public class ForgetPassword implements ForgotPassword_Interface {
	private WebDriver driver;
	private Global global;
	private Properties Prop;
	private boolean uname;
	private boolean email;

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

	@FindBy(how = How.XPATH, using = ".//label[@for='fp_user_name']")
	private WebElement Uname_Label;

	@FindBy(how = How.XPATH, using = ".//label[@for='fp_user_mail']")
	private WebElement Email_Label;

	@FindBy(how = How.XPATH, using = ".//input[@id='generate_pwd_button']")
	private WebElement button;

	public ForgetPassword(WebDriver driver) {
		global = new Global();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Prop = global.readProperties();
	}

	public void clickForgotPassword() {
		Forgot_Password.click();
	}

	public void forgotPassword() {
		Forgot_Password_Username.sendKeys(Prop.getProperty("uname"));
		Forgot_Password_Email.sendKeys(Prop.getProperty("Email"));
		Forgot_Password_Submit.click();
	}

	public void forgotPasswordInvalid() {
		Forgot_Password_Username.clear();
		Forgot_Password_Email.clear();
		Forgot_Password_Username.sendKeys(Prop.getProperty("uname"));
		Forgot_Password_Email.sendKeys(Prop.getProperty("Email2"));
		Forgot_Password_Submit.click();
	}

	public void forgotPasswordInvalid2() {
		Forgot_Password_Username.clear();
		Forgot_Password_Email.clear();
		Forgot_Password_Username.sendKeys("");
		Forgot_Password_Email.sendKeys("");
		Forgot_Password_Submit.click();
	}

	public void forgotPasswordInvalid3() {
		Forgot_Password_Username.clear();
		Forgot_Password_Email.clear();
		Forgot_Password_Username.sendKeys("");
		Forgot_Password_Email.sendKeys(Prop.getProperty("Email"));
		Forgot_Password_Submit.click();

	}

	public void forgotPasswordInvalid4() {
		Forgot_Password_Username.clear();
		Forgot_Password_Email.clear();
		Forgot_Password_Username.sendKeys(Prop.getProperty("uname"));
		Forgot_Password_Email.sendKeys("");
		Forgot_Password_Submit.click();
	}

	public void assertCheckValid() {
		global.wait(driver).until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//div[@id='generate_success']"), "Your request has been submitted."));
		Assert.assertEquals(success_Message.getText(), Prop.getProperty("Message"));
	}

	public void assertCheckValid2() {
		global.wait(driver).until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//div[@id='generate_success']"), "You must specify a valid User Name and Email Address."));
		Assert.assertEquals(success_Message.getText(), Prop.getProperty("Message2"));
	}

	public void assertCheckValid3() {
		global.wait(driver).until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//div[@id='generate_success']"), "Provide both a User Name and an Email Address."));
		Assert.assertEquals(success_Message.getText(), Prop.getProperty("Message3"));
	}

	public void assertCheckValid4() {
		global.wait(driver).until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//div[@id='generate_success']"), "Provide both a User Name and an Email Address."));
		Assert.assertEquals(success_Message.getText(), Prop.getProperty("Message3"));
	}

	public void assertCheckValid5() {
		global.wait(driver).until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//div[@id='generate_success']"), "Provide both a User Name and an Email Address."));
		Assert.assertEquals(success_Message.getText(), Prop.getProperty("Message3"));
	}

	public void assertCheckboxCheck() {
		uname = Forgot_Password_Username.isEnabled();
		email = Forgot_Password_Email.isEnabled();
		Assert.assertEquals(uname, true);
		Assert.assertEquals(email, true);

	}

	public void labelCheck() {
		Assert.assertEquals(Uname_Label.getText(), Prop.getProperty("Label1"));
		Assert.assertEquals(Email_Label.getText(), Prop.getProperty("Label2"));
		global.wait(driver).until(ExpectedConditions.textToBePresentInElementValue(button, "Submit"));
		Assert.assertEquals(button.getAttribute("value"), Prop.getProperty("Label4"));
		Forgot_Password_Submit.click();
		Assert.assertEquals(button.getAttribute("value"), Prop.getProperty("Label3"));
	}

	public void closeBrowser() {
		driver.close();
	}
}
