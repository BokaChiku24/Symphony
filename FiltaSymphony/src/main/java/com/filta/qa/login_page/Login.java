package com.filta.qa.login_page;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.filta.qa.helper.Login_Interface;
import com.filta.qa.util.Global;

public class Login implements Login_Interface
{
	private WebDriver Driver;
	private Global Global_Obj;
	private Properties Prop;
	private String ActualMsg;

	@FindBy(how = How.XPATH, using = ".//input[@id='user_name']")
	private WebElement UserName;

	@FindBy(how = How.XPATH, using = ".//input[@id='user_password']")
	private WebElement Password;

	@FindBy(how = How.XPATH, using = ".//input[@id='login_button']")
	private WebElement Log_In;

	@FindBy(how = How.XPATH, using = ".//div[@class='login']//tbody//tr[2]")
	private WebElement ErrorMessage;


	public Login(WebDriver Driver)
	{
		Global_Obj = new Global();
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
		Prop = Global_Obj.readProperties();
	}


	public void enterUserName(String Username)
	{
		UserName.sendKeys(Username);
	}


	public void enterPassword(String Password_String)
	{
		Password.sendKeys(Password_String);
	}


	public void clickSubmit()
	{
		Log_In.click();
	}


	public void assertCheck()
	{
		ActualMsg = Driver.getCurrentUrl();
		Assert.assertEquals(ActualMsg, Prop.getProperty("URLAssert"));
	}


	public void assertCheck2()
	{
		Global_Obj.wait(Driver).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='login']//tbody//tr[2]")));
	     ActualMsg = ErrorMessage.getText();
		Assert.assertEquals(ActualMsg, Prop.getProperty("Validation1"));
	}


	public void clearText()
	{
		UserName.clear();
		Password.clear();
	}


	public void driverClose()
	{
		Driver.close();
	}
}
