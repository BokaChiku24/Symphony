package com.filta.qa.util;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login
{
	public WebDriver Driver;
	private Global Global_Obj;
	private Properties Prop;

	@FindBy(how = How.XPATH, using = ".//input[@id='user_name']")
	private WebElement UserName;

	@FindBy(how = How.XPATH, using = ".//input[@id='user_password']")
	private WebElement Password;

	@FindBy(how = How.XPATH, using = ".//input[@id='login_button']")
	private WebElement Log_In;


	public Login(WebDriver Driver)
	{
		this.Driver = Driver;
		Global_Obj = new Global();
		Prop = Global_Obj.readProperties();
		PageFactory.initElements(Driver, this);

	}


	public void credentials()
	{
		UserName.sendKeys(Prop.getProperty("uname"));
		Password.sendKeys(Prop.getProperty("password"));
		Log_In.click();
	}
}
