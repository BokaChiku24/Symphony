/**
 * 
 */
package com.filta.qa.customer_page;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.filta.qa.util.Global;
import com.filta.qa.util.Login;
import com.filta.qa.util.ReadExcelData;

/**
 * @author kun24
 *
 */
public class Create_CustomerFB
{
	private WebDriver Driver;
	private WebElement WebEelement;
	private Global Global_Obj;
	private Properties Prop;
	private Login Login;

	@FindBy(how = How.XPATH, using = ".//a[@class='container-close']")
	private WebElement ContainerClose;

	public Create_CustomerFB(WebDriver Driver)
	{
		Global_Obj = new Global();
		Prop = Global_Obj.readProperties();
		this.Driver = Driver;
		Login = new Login(Driver);
		PageFactory.initElements(Driver, this);
	}


	public void login()
	{
		Login.credentials();
		ContainerClose.click();
	}


	public void closeBrowser()
	{
		Driver.close();
	}
}
