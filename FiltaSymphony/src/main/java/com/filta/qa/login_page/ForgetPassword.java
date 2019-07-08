package com.filta.qa.login_page;

import org.testng.Assert;

import com.filta.qa.helper.ForgotPassword_Interface;
import com.filta.qa.util.Global;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgetPassword implements ForgotPassword_Interface
{
	private WebDriver Driver;
	private Global Global_Obj;
	private Properties Prop;
	private boolean Uname;
	private boolean Email;

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
	private WebElement Button;


	public ForgetPassword(WebDriver Driver)
	{
		Global_Obj = new Global();
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
		Prop = Global_Obj.readProperties();
	}


	public void clickForgotPassword()
	{
		Forgot_Password.click();
	}


	public void forgotPassword()
	{
		Forgot_Password_Username.sendKeys(Prop.getProperty("uname"));
		Forgot_Password_Email.sendKeys(Prop.getProperty("Email"));
		Forgot_Password_Submit.click();
	}


	public void forgotPasswordInvalid()
	{
		Forgot_Password_Username.clear();
		Forgot_Password_Email.clear();
		Forgot_Password_Username.sendKeys(Prop.getProperty("uname"));
		Forgot_Password_Email.sendKeys(Prop.getProperty("Email2"));
		Forgot_Password_Submit.click();
	}


	public void forgotPasswordInvalid2()
	{
		Forgot_Password_Username.clear();
		Forgot_Password_Email.clear();
		Forgot_Password_Username.sendKeys("");
		Forgot_Password_Email.sendKeys("");
		Forgot_Password_Submit.click();
	}


	public void forgotPasswordInvalid3()
	{
		Forgot_Password_Username.clear();
		Forgot_Password_Email.clear();
		Forgot_Password_Username.sendKeys("");
		Forgot_Password_Email.sendKeys(Prop.getProperty("Email"));
		Forgot_Password_Submit.click();

	}


	public void forgotPasswordInvalid4()
	{
		Forgot_Password_Username.clear();
		Forgot_Password_Email.clear();
		Forgot_Password_Username.sendKeys(Prop.getProperty("uname"));
		Forgot_Password_Email.sendKeys("");
		Forgot_Password_Submit.click();
	}


	public void assertCheckValid()
	{
		Global_Obj.wait(Driver).until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//div[@id='generate_success']"), "Your request has been submitted."));
		Assert.assertEquals(success_Message.getText(), Prop.getProperty("Message"));
	}


	public void assertCheckValid2()
	{
		Global_Obj.wait(Driver)
				.until(ExpectedConditions.textToBePresentInElementLocated(
						By.xpath(".//div[@id='generate_success']"),
						"You must specify a valid User Name and Email Address."));
		Assert.assertEquals(success_Message.getText(), Prop.getProperty("Message2"));
	}


	public void assertCheckValid3()
	{
		Global_Obj.wait(Driver).until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//div[@id='generate_success']"), "Provide both a User Name and an Email Address."));
		Assert.assertEquals(success_Message.getText(), Prop.getProperty("Message3"));
	}


	public void assertCheckValid4()
	{
		Global_Obj.wait(Driver).until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//div[@id='generate_success']"), "Provide both a User Name and an Email Address."));
		Assert.assertEquals(success_Message.getText(), Prop.getProperty("Message3"));
	}


	public void assertCheckValid5()
	{
		Global_Obj.wait(Driver).until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//div[@id='generate_success']"), "Provide both a User Name and an Email Address."));
		Assert.assertEquals(success_Message.getText(), Prop.getProperty("Message3"));
	}


	public void assertCheckboxCheck()
	{
		Uname = Forgot_Password_Username.isEnabled();
		Email = Forgot_Password_Email.isEnabled();
		Assert.assertEquals(Uname, true);
		Assert.assertEquals(Email, true);

	}


	public void labelCheck()
	{
		Assert.assertEquals(Uname_Label.getText(), Prop.getProperty("Label1"));
		Assert.assertEquals(Email_Label.getText(), Prop.getProperty("Label2"));
		Global_Obj.wait(Driver).until(ExpectedConditions.textToBePresentInElementValue(Button, "Submit"));
		Assert.assertEquals(Button.getAttribute("value"), Prop.getProperty("Label4"));
		Forgot_Password_Submit.click();
		Assert.assertEquals(Button.getAttribute("value"), Prop.getProperty("Label3"));
	}


	public void closeBrowser()
	{
		Driver.close();
	}
}
