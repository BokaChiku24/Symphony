/**
 * 
 */
package com.filta.qa.customer_page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
	private WebDriver driver;
	// private WebElement webEelement;
	private Global global_Obj;
	private Properties prop;
	private Login login;
	String default_pricing_current;

	@FindBy(how = How.XPATH, using = ".//a[@class='container-close']")
	private WebElement containerClose;

	@FindBy(how = How.XPATH, using = ".//div[@id='ajaxHeader']//div[@class='menubar']//div[@id='moduleList']//ul[@class='last']//li[@class='last-li'][2]")
	private WebElement customer_module;

	@FindBy(how = How.XPATH, using = ".//a[@id='moduleTab_-1_Customers']")
	private WebElement customer;

	@FindBy(how = How.XPATH, using = ".//a[@id='create_image']")
	private WebElement customer_create;

	@FindBy(how = How.XPATH, using = ".//a[@id='tab1']")
	private WebElement pricing_estimating_info;

	@FindBy(how = How.XPATH, using = ".//select[@id='default_pricing']")
	private WebElement default_pricing;

	@FindBy(how = How.XPATH, using = ".//input[@id='filtabio']")
	private WebElement filtabio_check;

	@FindBy(how = How.XPATH, using = ".//input[@id='pay_customer']")
	private WebElement filtabio_price;

	@FindBy(how = How.XPATH, using = ".//input[@id='CANCEL_HEADER']")
	private WebElement cancel;

	public Create_CustomerFB(WebDriver Driver)
	{
		global_Obj = new Global();
		prop = global_Obj.readProperties();
		this.driver = Driver;
		login = new Login(Driver);
		PageFactory.initElements(Driver, this);
	}


	public void login()
	{
		login.credentials();
		containerClose.click();
	}


	public void createCustomerDefaultPricingNo()
	{
		global_Obj.action(driver).moveToElement(customer_module).build().perform();
		customer.click();
		customer_create.click();
		pricing_estimating_info.click();
		default_pricing_current = global_Obj.select(default_pricing).getFirstSelectedOption().getText();
		assertEquals(default_pricing_current, prop.getProperty("DefaultNo"));
		assertTrue(filtabio_check.isSelected());
		assertEquals(filtabio_price.getAttribute("value"), prop.getProperty("FB_PayPrice"));
		cancel.click();
	}


	public void createCustomerDefaultPricingYes()
	{

	}


	public void closeBrowser()
	{
		driver.close();
	}
}
