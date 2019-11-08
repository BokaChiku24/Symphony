/**
 * 
 */
package com.filta.qa.customer_page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.filta.qa.util.Global;
import com.filta.qa.util.Login;
import com.filta.qa.util.ReadExcelData;

/**
 * @author kun24
 * @implNote Create Customer FiltaBio Check Testing
 */
public class CreateCustomerFB
{
	private WebDriver driver;
	private Global globalObj;
	private Properties prop;
	private Login login;
	private String defaultPricingCurrent;
	private String defaultFiltaBioDefault;
	private ReadExcelData defaultPricingData;
	private ReadExcelData pricingData;
	private String defaultFBValue;
	private double fb;

	@FindBy(how = How.XPATH, using = ".//a[@class='container-close']")
	private WebElement containerClose;

	@FindBy(how = How.XPATH, using = ".//div[@id='ajaxHeader']//div[@class='menubar']//div[@id='moduleList']//ul[@class='last']//li[@class='last-li'][2]")
	private WebElement customerModule;

	@FindBy(how = How.XPATH, using = ".//a[@id='moduleTab_-1_Customers']")
	private WebElement customer;

	@FindBy(how = How.XPATH, using = ".//a[@id='create_image']")
	private WebElement customerCreate;

	@FindBy(how = How.XPATH, using = ".//a[@id='tab1']")
	private WebElement pricingEstimatingInfo;

	@FindBy(how = How.XPATH, using = ".//select[@id='default_pricing']")
	private WebElement defaultPricing;

	@FindBy(how = How.XPATH, using = ".//select[@id='default_pricing']//option")
	private WebElement defaultPricingOptions;

	@FindBy(how = How.XPATH, using = ".//input[@id='filtabio']")
	private WebElement filtabioCheck;

	@FindBy(how = How.XPATH, using = ".//input[@id='pay_customer']")
	private WebElement filtabioPrice;

	@FindBy(how = How.XPATH, using = ".//input[@id='CANCEL_HEADER']")
	private WebElement cancel;

	@FindBy(how = How.XPATH, using = ".//input[@id='pay_customer']")
	private WebElement filtaBioDefault;

	@FindBy(how = How.XPATH, using = ".//a[@id='admin_link']")
	private WebElement admin;

	@FindBy(how = How.XPATH, using = ".//a[@id='invoice_setting']")
	private WebElement manageInvoice;

	@FindBy(how = How.XPATH, using = ".//a[@id='tab2']")
	private WebElement defaultPricingTab;

	@FindBy(how = How.XPATH, using = ".//input[@id='SAVE_HEADER']")
	private WebElement adminSave;

	@FindBy(how = How.XPATH, using = ".//div[@id='ajaxHeader']//div[@class='menubar']//div[@id='moduleList']//ul[@class='last']//li[@class='last-li']//a[@id='grouptab_1']")
	private WebElement leadModule;

	@FindBy(how = How.XPATH, using = ".//a[@id='moduleTab_-1_Leads']")
	private WebElement lead;

	@FindBy(how = How.XPATH, using = ".//a[@id='create_image']")
	private WebElement leadCreate;

	@FindBy(how = How.XPATH, using = ".//input[@id='last_name']")
	private WebElement leadLastName;

	@FindBy(how = How.XPATH, using = ".//select[@id='salutation']")
	private WebElement salutation;

	@FindBy(how = How.XPATH, using = ".//input[@id='first_name']")
	private WebElement leadFirstName;

	@FindBy(how = How.XPATH, using = ".//input[@id='title']")
	private WebElement leadTitle;

	@FindBy(how = How.XPATH, using = ".//input[@id='company_name']")
	private WebElement leadCompanyName;

	@FindBy(how = How.XPATH, using = ".//table[@id='ListTable']//tr[3]//td[3]//a")
	private WebElement existingLeadCompanyName;

	@FindBy(how = How.XPATH, using = ".//input[@id='number_of_fryers']")
	private WebElement leadFryers;

	@FindBy(how = How.XPATH, using = ".//input[@id='SAVE_HEADER']")
	private WebElement leadSave;

	@FindBy(how = How.XPATH, using = ".//input[@id='convert_lead_button']")
	private WebElement leadToCustomerConvert;

	@FindBy(how = How.XPATH, using = ".//input[@id='SAVE_HEADER']")
	private WebElement leadToCustomerConvertSave;

	@FindBy(how = How.XPATH, using = ".//input[@id='Accountstype-input']")
	private WebElement leadType;

	@FindBy(how = How.XPATH, using = ".//p[@class='msg']")
	private WebElement leadMsg;

	@FindBy(how = How.XPATH, using = ".//div[@class='moduleTitle']//h2")
	private WebElement check;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/table/tbody/tr/td/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[1]/td/table/tbody/tr/td/input[1]")
	private WebElement checkSave;

	@FindBy(how = How.XPATH, using = "/html/body/div/div[4]/div[1]/table/tbody/tr/td/table/tbody/tr[1]/td")
	private WebElement createContactMessage;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/table/tbody/tr/td/form/table/tbody/tr[1]/td/table/tbody/tr/td/input")
	private WebElement createContact;

	@FindBy(how = How.XPATH, using = "//*[@id=\"MassUpdate\"]/div[1]/p[1]")
	private WebElement message;

	public CreateCustomerFB(WebDriver driver)
	{
		globalObj = new Global();
		prop = globalObj.readProperties();
		this.driver = driver;
		login = new Login(driver);
		defaultPricingData = new ReadExcelData(prop.getProperty("Path2"), "DefaultPricing");
		pricingData = new ReadExcelData(prop.getProperty("Path2"), "Pricing");
		fb = new ReadExcelData(prop.getProperty("Path2"), "Pricing").getCellDataInt(1, 2);
		PageFactory.initElements(driver, this);
	}


	public void login()
	{
		login.credentials();
		containerClose.click();
	}


	public void createCustomerDefaultPricingNo()
	{
		globalObj.action(driver).moveToElement(customerModule).build().perform();
		customer.click();
		customerCreate.click();
		pricingEstimatingInfo.click();
		defaultPricingCurrent = globalObj.select(defaultPricing).getFirstSelectedOption().getText();
		assertEquals(defaultPricingCurrent, prop.getProperty("DefaultNo"));
		assertTrue(filtabioCheck.isSelected());
		assertEquals(filtabioPrice.getAttribute("value"), prop.getProperty("FB_PayPrice"));
		cancel.click();
	}


	public String defaultPricingFranchiseeLevel()
	{
		admin.click();
		manageInvoice.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(defaultPricingTab));
		defaultPricingTab.click();
		// FiltaBio

		if (filtaBioDefault.getAttribute("value").equals(""))
		{
			filtaBioDefault.sendKeys(defaultPricingData.getCellDataInt(1, 4) + "");
		}
		defaultFiltaBioDefault = filtaBioDefault.getAttribute("value");
		adminSave.click();
		return defaultFiltaBioDefault;
	}


	public void createCustomerDefaultPricingYesFBPriceSet()
	{
		defaultFBValue = defaultPricingFranchiseeLevel();
		globalObj.action(driver).moveToElement(customerModule).build().perform();
		customer.click();
		customerCreate.click();
		globalObj.jsReturn(driver).executeScript("arguments[0].click();", pricingEstimatingInfo);
		globalObj.jsReturn(driver).executeScript("arguments[0].click();", defaultPricing);
		globalObj.select(defaultPricing).selectByVisibleText(pricingData.getCellData(2, 4));
		globalObj.alertAccept(driver);
		lodar();
		assertTrue(filtabioCheck.isSelected());
		if (filtabioPrice.getAttribute("value").equals("0.00"))
		{
			assertEquals(filtabioPrice.getAttribute("value").replace("0.00", fb + ""), defaultFBValue);
		}
		else
		{
			assertEquals(filtabioPrice.getAttribute("value"), defaultFBValue);
		}
		globalObj.jsReturn(driver).executeScript("arguments[0].click();", cancel);
		// global_Obj.alertAccept(driver);
	}


	public void createCustomerDefaultPricingYesFBPriceNotSet()
	{
		admin.click();
		manageInvoice.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(defaultPricingTab));
		defaultPricingTab.click();
		// FiltaBio

		if (filtaBioDefault.getAttribute("value").equals(""))
		{
			filtaBioDefault.sendKeys(defaultPricingData.getCellDataInt(1, 4) + "");
		}
		else if (filtaBioDefault.getAttribute("value").equals(fb + ""))
		{
			filtaBioDefault.clear();
		}
		adminSave.click();
		globalObj.action(driver).moveToElement(customerModule).build().perform();
		customer.click();
		customerCreate.click();
		lodar();
		globalObj.jsReturn(driver).executeScript("arguments[0].click();", pricingEstimatingInfo);
		defaultPricing.click();
		globalObj.select(defaultPricing).selectByVisibleText(pricingData.getCellData(2, 4));
		globalObj.alertAccept(driver);
		lodar();
		if (filtabioCheck.isSelected() && filtabioPrice.isDisplayed())
		{
			assertTrue(filtabioCheck.isSelected());
			assertEquals(filtabioPrice.getAttribute("value"), prop.getProperty("FB_PayPrice"));
		}
		assertEquals(filtabioCheck.isSelected(), false);
		assertEquals(filtabioPrice.isDisplayed(), false);
		globalObj.jsReturn(driver).executeScript("arguments[0].click();", cancel);
		globalObj.alertAccept(driver);
	}


	private void lodar()
	{
		globalObj.wait(driver)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ajaxloading_mask")));
	}


	public void loadar2()
	{
		globalObj.wait(driver)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ajaxStatusDiv")));
	}


	public void closeBrowser()
	{
		driver.close();
	}
}
