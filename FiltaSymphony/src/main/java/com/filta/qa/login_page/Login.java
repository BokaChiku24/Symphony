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
	private WebDriver driver;
	private Global global_Obj;
	private Properties prop;
	private String actualMsg;

	@FindBy(how = How.XPATH, using = ".//input[@id='user_name']")
	private WebElement userName;

	@FindBy(how = How.XPATH, using = ".//input[@id='user_password']")
	private WebElement passWord;

	@FindBy(how = How.XPATH, using = ".//input[@id='login_button']")
	private WebElement log_In;

	@FindBy(how = How.XPATH, using = ".//div[@class='login']//tbody//tr[2]")
	private WebElement errorMessage;


	public Login(WebDriver driver)
	{
		global_Obj = new Global();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop = global_Obj.readProperties();
	}


	public void enterUserName(String Username)
	{
		userName.sendKeys(Username);
	}


	public void enterPassword(String Password_String)
	{
		passWord.sendKeys(Password_String);
	}


	public void clickSubmit()
	{
		log_In.click();
	}


	public void assertCheck()
	{
		actualMsg = driver.getCurrentUrl();
		Assert.assertEquals(actualMsg, prop.getProperty("URLAssert"));
	}


	public void assertCheck2()
	{
		global_Obj.wait(driver).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='login']//tbody//tr[2]")));
		actualMsg = errorMessage.getText();
		Assert.assertEquals(actualMsg, prop.getProperty("Validation1"));
	}


	public void clearText()
	{
		userName.clear();
		passWord.clear();
	}


	public void driverClose()
	{
		driver.close();
	}
}
