package com.filta.qa.login_page;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.filta.qa.helper.ForgotPassword_Interface;
import com.filta.qa.util.Global;

public class ForgetPassword implements ForgotPassword_Interface
{
	private WebDriver driver;
	private Global global_Obj;
	private Properties prop;
	private boolean uName;
	private boolean email;

	@FindBy(how = How.LINK_TEXT, using = "Forgot Password?")
	private WebElement forgot_Password;

	@FindBy(how = How.XPATH, using = ".//div[@id='forgot_password_dialog']//input[@id='fp_user_name']")
	private WebElement forgot_Password_Username;

	@FindBy(how = How.XPATH, using = ".//div[@id='forgot_password_dialog']//input[@id='fp_user_mail']")
	private WebElement forgot_Password_Email;

	@FindBy(how = How.XPATH, using = ".//div[@id='forgot_password_dialog']//input[@id='generate_pwd_button']")
	private WebElement forgot_Password_Submit;

	@FindBy(how = How.XPATH, using = ".//div[@id='generate_success']")
	private WebElement success_Message;

	@FindBy(how = How.XPATH, using = ".//label[@for='fp_user_name']")
	private WebElement uName_Label;

	@FindBy(how = How.XPATH, using = ".//label[@for='fp_user_mail']")
	private WebElement email_Label;

	@FindBy(how = How.XPATH, using = ".//input[@id='generate_pwd_button']")
	private WebElement button;


	public ForgetPassword(WebDriver driver)
	{
		global_Obj = new Global();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop = global_Obj.readProperties();
	}


	public void getURL()
	{
		List<WebElement> list = driver.findElements(By.tagName("a"));
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println("URL => " + list.get(i).getText());
		}
	}


	public void clickForgotPassword()
	{
		forgot_Password.click();
	}


	public void forgotPassword()
	{
		forgot_Password_Username.sendKeys(prop.getProperty("uname"));
		forgot_Password_Email.sendKeys(prop.getProperty("Email"));
		forgot_Password_Submit.click();
	}


	public void forgotPasswordInvalid()
	{
		forgot_Password_Username.clear();
		forgot_Password_Email.clear();
		forgot_Password_Username.sendKeys(prop.getProperty("uname"));
		forgot_Password_Email.sendKeys(prop.getProperty("Email2"));
		forgot_Password_Submit.click();
	}


	public void forgotPasswordInvalid2()
	{
		forgot_Password_Username.clear();
		forgot_Password_Email.clear();
		forgot_Password_Username.sendKeys("");
		forgot_Password_Email.sendKeys("");
		forgot_Password_Submit.click();
	}


	public void forgotPasswordInvalid3()
	{
		forgot_Password_Username.clear();
		forgot_Password_Email.clear();
		forgot_Password_Username.sendKeys("");
		forgot_Password_Email.sendKeys(prop.getProperty("Email"));
		forgot_Password_Submit.click();

	}


	public void forgotPasswordInvalid4()
	{
		forgot_Password_Username.clear();
		forgot_Password_Email.clear();
		forgot_Password_Username.sendKeys(prop.getProperty("uname"));
		forgot_Password_Email.sendKeys("");
		forgot_Password_Submit.click();
	}


	public void assertCheckValid()
	{
		global_Obj.wait(driver).until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//div[@id='generate_success']"), "Your request has been submitted."));
		Assert.assertEquals(success_Message.getText(), prop.getProperty("Message"));
	}


	public void assertCheckValid2()
	{
		global_Obj.wait(driver)
				.until(ExpectedConditions.textToBePresentInElementLocated(
						By.xpath(".//div[@id='generate_success']"),
						"You must specify a valid User Name and Email Address."));
		Assert.assertEquals(success_Message.getText(), prop.getProperty("Message2"));
	}


	public void assertCheckValid3()
	{
		global_Obj.wait(driver).until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//div[@id='generate_success']"), "Provide both a User Name and an Email Address."));
		Assert.assertEquals(success_Message.getText(), prop.getProperty("Message3"));
	}


	public void assertCheckValid4()
	{
		global_Obj.wait(driver).until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//div[@id='generate_success']"), "Provide both a User Name and an Email Address."));
		Assert.assertEquals(success_Message.getText(), prop.getProperty("Message3"));
	}


	public void assertCheckValid5()
	{
		global_Obj.wait(driver).until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//div[@id='generate_success']"), "Provide both a User Name and an Email Address."));
		Assert.assertEquals(success_Message.getText(), prop.getProperty("Message3"));
	}


	public void assertCheckboxCheck()
	{
		uName = forgot_Password_Username.isEnabled();
		email = forgot_Password_Email.isEnabled();
		Assert.assertEquals(uName, true);
		Assert.assertEquals(email, true);

	}


	public void labelCheck()
	{
		Assert.assertEquals(uName_Label.getText(), prop.getProperty("Label1"));
		Assert.assertEquals(email_Label.getText(), prop.getProperty("Label2"));
		global_Obj.wait(driver).until(ExpectedConditions.textToBePresentInElementValue(button, "Submit"));
		Assert.assertEquals(button.getAttribute("value"), prop.getProperty("Label4"));
		forgot_Password_Submit.click();
		Assert.assertEquals(button.getAttribute("value"), prop.getProperty("Label3"));
	}


	public void closeBrowser()
	{
		driver.close();
	}
}
