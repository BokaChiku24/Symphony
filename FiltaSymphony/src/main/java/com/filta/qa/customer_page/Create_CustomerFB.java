/**
 * 
 */
package com.filta.qa.customer_page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
 *
 */
public class Create_CustomerFB
{
	private WebDriver driver;
	// private WebElement webEelement;
	private Global global_Obj;
	private Properties prop;
	private Login login;
	private String default_pricing_current;
	private String default_FiltaBioDefault;
	private ReadExcelData defaultPricingData;
	private ReadExcelData pricingData;
	private String defaultFBValue;
	private double fb;
	private ReadExcelData leadData;
	private static int countCompany = 1;
	private static int countFirstName = 1;
	private static int countLastName = 1;
	private static int countTitle = 1;

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

	@FindBy(how = How.XPATH, using = ".//select[@id='default_pricing']//option")
	private WebElement default_pricing_options;

	@FindBy(how = How.XPATH, using = ".//input[@id='filtabio']")
	private WebElement filtabio_check;

	@FindBy(how = How.XPATH, using = ".//input[@id='pay_customer']")
	private WebElement filtabio_price;

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
	private WebElement lead_module;

	@FindBy(how = How.XPATH, using = ".//a[@id='moduleTab_-1_Leads']")
	private WebElement lead;

	@FindBy(how = How.XPATH, using = ".//a[@id='create_image']")
	private WebElement lead_create;

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

	public Create_CustomerFB(WebDriver driver)
	{
		global_Obj = new Global();
		prop = global_Obj.readProperties();
		this.driver = driver;
		login = new Login(driver);
		defaultPricingData = new ReadExcelData(prop.getProperty("Path2"), "DefaultPricing");
		pricingData = new ReadExcelData(prop.getProperty("Path2"), "Pricing");
		leadData = new ReadExcelData(prop.getProperty("Path2"), "Lead");
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


	public String defaultPricingFranchiseeLevel()
	{
		admin.click();
		manageInvoice.click();
		global_Obj.wait(driver).until(ExpectedConditions.visibilityOf(defaultPricingTab));
		defaultPricingTab.click();
		// FiltaBio

		if (filtaBioDefault.getAttribute("value").equals(""))
		{
			filtaBioDefault.sendKeys(defaultPricingData.getCellDataInt(1, 4) + "");
		}
		default_FiltaBioDefault = filtaBioDefault.getAttribute("value");
		adminSave.click();
		return default_FiltaBioDefault;
	}


	public void createCustomerDefaultPricingYesFBPriceSet()
	{
		defaultFBValue = defaultPricingFranchiseeLevel();
		global_Obj.action(driver).moveToElement(customer_module).build().perform();
		customer.click();
		customer_create.click();
		global_Obj.jsReturn(driver).executeScript("arguments[0].click();", pricing_estimating_info);
		global_Obj.jsReturn(driver).executeScript("arguments[0].click();", default_pricing);
		global_Obj.select(default_pricing).selectByVisibleText(pricingData.getCellData(2, 4));
		global_Obj.alertAccept(driver);
		lodar();
		assertTrue(filtabio_check.isSelected());
		if (filtabio_price.getAttribute("value").equals("0.00"))
		{
			assertEquals(filtabio_price.getAttribute("value").replace("0.00", fb + ""), defaultFBValue);
		}
		else
		{
			assertEquals(filtabio_price.getAttribute("value"), defaultFBValue);
		}
		global_Obj.jsReturn(driver).executeScript("arguments[0].click();", cancel);
		// global_Obj.alertAccept(driver);
	}


	public void createCustomerDefaultPricingYesFBPriceNotSet()
	{
		admin.click();
		manageInvoice.click();
		global_Obj.wait(driver).until(ExpectedConditions.visibilityOf(defaultPricingTab));
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
		global_Obj.action(driver).moveToElement(customer_module).build().perform();
		customer.click();
		customer_create.click();
		lodar();
		global_Obj.jsReturn(driver).executeScript("arguments[0].click();", pricing_estimating_info);
		default_pricing.click();
		global_Obj.select(default_pricing).selectByVisibleText(pricingData.getCellData(2, 4));
		global_Obj.alertAccept(driver);
		lodar();
		if (filtabio_check.isSelected() && filtabio_price.isDisplayed())
		{
			assertTrue(filtabio_check.isSelected());
			assertEquals(filtabio_price.getAttribute("value"), prop.getProperty("FB_PayPrice"));
		}
		assertEquals(filtabio_check.isSelected(), false);
		assertEquals(filtabio_price.isDisplayed(), false);
		global_Obj.jsReturn(driver).executeScript("arguments[0].click();", cancel);
		global_Obj.alertAccept(driver);
	}


	public void leadToCustomer()
	{
		global_Obj.action(driver).moveToElement(lead_module).build().perform();
		lead.click();
		global_Obj.sleepMethod();
		try
		{
			if (message.getText().equals("You currently have no records saved. Create or Import one now."))
			{
				System.out.println("No Lead Right Now !!");
			}
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Element Not Found !!");
		}
		try
		{
			if (existingLeadCompanyName.getText().equals(leadData.getCellData(1, 3)))
			{
				if (driver.findElement(
						By.xpath(".//table[@id='ListTable']//tbody//tr[@class='oddListRowS1']//td[10]")).getText()
						.equals("Lead")
						|| driver.findElement(
								By.xpath(".//table[@id='ListTable']//tbody//tr[@class='oddListRowS1']//td[10]"))
								.getText().equals("Wish List")
						|| driver.findElement(
								By.xpath(".//table[@id='ListTable']//tbody//tr[@class='oddListRowS1']//td[10]"))
								.getText().equals("Wish List Target-Active")
						|| driver.findElement(
								By.xpath(".//table[@id='ListTable']//tbody//tr[@class='oddListRowS1']//td[10]"))
								.getText().equals("Wish List Target-Inactive")
						|| driver.findElement(
								By.xpath(".//table[@id='ListTable']//tbody//tr[@class='oddListRowS1']//td[10]"))
								.getText().equals("Qualified Lead")
						|| driver.findElement(
								By.xpath(".//table[@id='ListTable']//tbody//tr[@class='oddListRowS1']//td[10]"))
								.getText().equals("Hot Lead")
						|| driver.findElement(
								By.xpath(".//table[@id='ListTable']//tbody//tr[@class='oddListRowS1']//td[10]"))
								.getText().equals("Scheduled Site-Evaluation")
						|| driver.findElement(
								By.xpath(".//table[@id='ListTable']//tbody//tr[@class='oddListRowS1']//td[10]"))
								.getText().equals("Completed Site-Evaluation")
						|| driver.findElement(
								By.xpath(".//table[@id='ListTable']//tbody//tr[@class='oddListRowS1']//td[10]"))
								.getText().equals("Won")
						|| driver.findElement(
								By.xpath(".//table[@id='ListTable']//tbody//tr[@class='oddListRowS1']//td[10]"))
								.getText().equals("Lost")
						|| driver.findElement(
								By.xpath(".//table[@id='ListTable']//tbody//tr[@class='oddListRowS1']//td[10]"))
								.getText().equals("Non-Qualified")
						|| driver.findElement(
								By.xpath(".//table[@id='ListTable']//tbody//tr[@class='oddListRowS1']//td[10]"))
								.getText().equals("Chain Decision")
						|| driver.findElement(
								By.xpath(".//table[@id='ListTable']//tbody//tr[@class='oddListRowS1']//td[10]"))
								.getText().equals("Multi-Unit Site")
						|| driver.findElement(
								By.xpath(".//table[@id='ListTable']//tbody//tr[@class='oddListRowS1']//td[10]"))
								.getText().equals("Qualified-Not Interested"))
				{
					existingLeadCompanyName.click();
					leadToCustomerConvert.click();
					leadToCustomerConvertSave.click();
					global_Obj.alertAccept(driver);
					driver.findElement(By.xpath(".//tr[@class='oddListRowS1']//td[2]")).click();
				}
			}

		}
		catch (NoSuchElementException e)
		{
			System.out.println("Element Not Found !!");
		}

	}


	private void lodar()
	{
		global_Obj.wait(driver)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ajaxloading_mask")));
	}


	public void loadar2()
	{
		global_Obj.wait(driver)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ajaxStatusDiv")));
	}


	public void closeBrowser()
	{
		driver.close();
	}
}
