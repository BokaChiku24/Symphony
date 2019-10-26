package com.filta.qa.customer_page;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import com.filta.qa.util.Global;
import com.filta.qa.util.Login;
import com.filta.qa.util.ReadExcelData;

public class FixedCostCustomerPage
{
	private WebDriver driver;
	private WebElement webEelement;
	private Global global_Obj;
	private Properties prop;
	private Login login;
	private SoftAssert sa;
	private String customer_URL;
	private ReadExcelData fixedCostData;
	private ReadExcelData pricingData;
	private ReadExcelData unitDataExcel;
	private ReadExcelData marketingData;
	private ReadExcelData defaultPricingData;
	private String default_Level1Charge;
	private String default_AdditionalRate;
	private String default_First;
	private String default_FryerSize1;
	private String default_FryerChargeDefault;
	private String default_FryerCleanOnlyCharge;
	private String default_FryerSize2;
	private String default_FryerChargeDefault2;
	private String default_FryerCleanOnlyCharge0;
	private String default_FixedCostCharge;
	private String default_FCMonthly;
	private String default_FCWeekly;
	private String default_FiltaBioDefault;
	private String default_FGOilCharge;
	private String default_FGPerBox;
	private String default_FGTankRental;
	private String default_DrainFoamDefault;
	private String default_FCValue;
	private String default_EstPeriodValue;
	private String default_PaymentDefault;
	private String actualPayment;
	private String actualCustomer;
	private ArrayList<String> tabs;

	@FindBy(how = How.XPATH, using = ".//a[@class='container-close']")
	private WebElement containerClose;

	@FindBy(how = How.XPATH, using = ".//a[@id='admin_link']")
	private WebElement admin;

	@FindBy(how = How.XPATH, using = ".//a[@id='invoice_setting']")
	private WebElement manageInvoice;

	@FindBy(how = How.XPATH, using = ".//a[@id='tab2']")
	private WebElement defaultPricingTab;

	@FindBy(how = How.LINK_TEXT, using = "Customers")
	public WebElement customers;

	@FindBy(how = How.CSS, using = "#moduleTab_-1_Customers")
	public WebElement customer;

	@FindBy(how = How.LINK_TEXT, using = "Create")
	private WebElement create_Customer;

	@FindBy(how = How.CSS, using = "#name")
	private WebElement keyContact;

	@FindBy(how = How.CSS, using = "#title")
	private WebElement title;

	@FindBy(how = How.CSS, using = "#company_name")
	private WebElement companyName;

	@FindBy(how = How.CSS, using = "#nca_chain")
	private WebElement nCAChain;

	@FindBy(how = How.CSS, using = "#nca_unit_code")
	private WebElement ncaUnitCode;

	@FindBy(how = How.CSS, using = "#account_number")
	private WebElement account;

	@FindBy(how = How.CSS, using = "#Accounts0emailAddress0")
	private WebElement primaryEmail;

	@FindBy(how = How.CSS, using = "#billing_address_street")
	private WebElement site_Street;

	@FindBy(how = How.CSS, using = "#billing_address_city")
	private WebElement site_City;

	@FindBy(how = How.CSS, using = "#billing_address_state")
	private WebElement site_State;

	@FindBy(how = How.CSS, using = "#billing_address_postalcode")
	private WebElement site_PostalCode;

	@FindBy(how = How.CSS, using = "#billing_address_country")
	private WebElement site_Country;

	@FindBy(how = How.XPATH, using = ".//input[@name='phone_office']")
	private WebElement office_Phone;

	@FindBy(how = How.CSS, using = "#ext_no")
	private WebElement ext;

	@FindBy(how = How.CSS, using = "#operations_notes")
	private WebElement arrivalNotes;

	@FindBy(how = How.CSS, using = "#description")
	private WebElement departureNotes;

	@FindBy(how = How.XPATH, using = ".//input[@name='phone_mobile']")
	private WebElement mobile;

	@FindBy(how = How.CSS, using = "#nca_supplier_number")
	private WebElement nca_Supplier;

	@FindBy(how = How.CSS, using = "#shipping_address_street")
	private WebElement invoiceStreet;

	@FindBy(how = How.CSS, using = "#shipping_address_city")
	private WebElement invoiceCity;

	@FindBy(how = How.CSS, using = "#shipping_address_state")
	private WebElement invoiceState;

	@FindBy(how = How.CSS, using = "#shipping_address_postalcode")
	private WebElement invoicePostal;

	@FindBy(how = How.CSS, using = "#shipping_address_country")
	private WebElement invoiceCountry;

	@FindBy(how = How.CSS, using = "#survey_frequency")
	private WebElement service_Frequency;

	@FindBy(how = How.LINK_TEXT, using = "Pricing & Estimating Info")
	private WebElement pricing;

	@FindBy(how = How.CSS, using = "#default_pricing")
	private WebElement defaultPricing;

	@FindBy(how = How.CSS, using = "#service_filtafry")
	private WebElement filtaFry;

	@FindBy(how = How.CSS, using = "#charge_type")
	private WebElement pricing_Model;

	@FindBy(how = How.CSS, using = "#ajaxloading_mask")
	private WebElement lodar;

	@FindBy(how = How.CSS, using = "#filtacool")
	private WebElement filtaCool;

	@FindBy(how = How.CSS, using = "#filtacool_frequency")
	private WebElement filtaCool_Frequency;

	@FindBy(how = How.CSS, using = "#rental_rate")
	private WebElement rentalRate;

	@FindBy(how = How.CSS, using = "#filtabio")
	private WebElement filtaBio;

	@FindBy(how = How.CSS, using = "#pay_customer")
	private WebElement payCustomer;

	@FindBy(how = How.CSS, using = "#service_filtanewoil")
	private WebElement filtaGold;

	@FindBy(how = How.CSS, using = "#number_of_tanks")
	private WebElement noOfTank;

	@FindBy(how = How.CSS, using = "#tank_rental")
	private WebElement tankRent;

	@FindBy(how = How.CSS, using = "#oil_charge")
	private WebElement oil_Charge;

	@FindBy(how = How.CSS, using = "#price_per_box")
	private WebElement priceperBox;

	@FindBy(how = How.CSS, using = "#service_drainfoam")
	private WebElement drainFoam;

	@FindBy(how = How.CSS, using = "#set_drainfoam")
	private WebElement charge;

	@FindBy(how = How.CSS, using = "#inv_period")
	private WebElement inv_Period;

	@FindBy(how = How.XPATH, using = ".//td[@class='edit-table-row1']//label[1]//input[@type='radio' and @id='review_before_sending_inv']")
	private WebElement perJob_Yes;

	@FindBy(how = How.XPATH, using = ".//td[@class='edit-table-row1']//label[2]//input[@type='radio' and @id='review_before_sending_inv']")
	private WebElement perJob_No;

	@FindBy(how = How.CSS, using = "#payment_term")
	private WebElement payement;

	@FindBy(how = How.LINK_TEXT, using = "Marketing & Categories")
	private WebElement marketing_Categories;

	@FindBy(how = How.XPATH, using = ".//input[@id='type-input']")
	private WebElement typeMarketing;

	@FindBy(how = How.XPATH, using = ".//li[@data-text='Amusement Park']")
	private WebElement amusementPark;

	@FindBy(how = How.XPATH, using = ".//li[@data-text='Casinos']")
	private WebElement casinos;

	@FindBy(how = How.XPATH, using = ".//li[@data-text='A&W Restaurants']")
	private WebElement a_W;

	@FindBy(how = How.CSS, using = "#sub_type")
	private WebElement sub_Type;

	@FindBy(how = How.CSS, using = "#contract_caterers")
	private WebElement contract;

	@FindBy(how = How.CSS, using = "#btn_assigned_user_name")
	private WebElement salespersonselect;

	@FindBy(how = How.CSS, using = "#affiliation")
	private WebElement affiliation;

	@FindBy(how = How.XPATH, using = ".//input[@name='chain-input']")
	private WebElement chaininput;

	@FindBy(how = How.CSS, using = "#nca")
	private WebElement nCASelection;

	@FindBy(how = How.CSS, using = "#region_name")
	private WebElement region;

//	@FindBy(how = How.CSS, using = "#btn_territory")
//	private WebElement territory;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Automation_Sales")
	private WebElement automation_Sales;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Automation")
	private WebElement automation;

	@FindBy(how = How.LINK_TEXT, using = "Unit Data")
	private WebElement unitData;

	@FindBy(how = How.CSS, using = "#type_of_oil")
	private WebElement typeOfOil;

	@FindBy(how = How.CSS, using = "#dump_fre")
	private WebElement qTY;

	@FindBy(how = How.CSS, using = "#waste_oil")
	private WebElement wasteOil;

	@FindBy(how = How.CSS, using = "#rti")
	private WebElement rTI;

	@FindBy(how = How.CSS, using = "#available_service_times")
	private WebElement availableServiceTime;

	@FindBy(how = How.CSS, using = "#dump_fre_description")
	private WebElement dump_Fre_Description;

	@FindBy(how = How.CSS, using = "#waste_oil_renewal_date_trigger")
	private WebElement wasteOilRenewal;

	@FindBy(how = How.LINK_TEXT, using = "Today")
	private WebElement today;

	@FindBy(how = How.CSS, using = "#waste_oil_renewal_date")
	private WebElement renewaldate;

	@FindBy(how = How.CSS, using = "#rti_renewal_date_trigger")
	private WebElement rTIRenewalDate;

	@FindBy(how = How.CSS, using = "#rti_renewal_date")
	private WebElement rTIDate;

	@FindBy(how = How.XPATH, using = ".//div[@class='buttons']//input[@id='SAVE_HEADER']")
	private WebElement save;

	@FindBy(how = How.CSS, using = "#customers_fryer_locations_create_button")
	private WebElement locationCreate1;

	@FindBy(how = How.XPATH, using = ".//input[@type='text']")
	private WebElement locationName;
	
	@FindBy(how = How.XPATH, using = ".//div[@class='popup-table-overflow']//tbody[1]//tr[3]//td[1]//a")
	private WebElement locationSelect2;
	
	@FindBy(how = How.XPATH, using = ".//textarea[@name='description']")
	private WebElement locationDescription;

	@FindBy(how = How.XPATH, using = ".//div[@id='subpanel_customers_fryer_locations_newDiv']//table[@class='dcQuickEdit']//div[@class='action_buttons action-rows']//input[@type='submit' and @id='FR_FryerLocation_subpanel_save_button']")
	private WebElement locationSave1;

	@FindBy(how = How.XPATH, using = ".//ul[@id='groupTabs']//li[4]")
	private WebElement fryers;

	@FindBy(how = How.CSS, using = "#customers_fr_fryers_create_button")
	private WebElement createFryer;

	@FindBy(how = How.XPATH, using = ".//input[@name='name']")
	private WebElement fryer;

	@FindBy(how = How.XPATH, using = ".//input[@name='size']")
	private WebElement fryerSize;

	@FindBy(how = How.XPATH, using = ".//input[@name='sort_order']")
	private WebElement fryerSort;

	@FindBy(how = How.XPATH, using = ".//input[@name='charge']")
	private WebElement fryerCharge;

	@FindBy(how = How.XPATH, using = ".//input[@name='dump_clean_charges']")
	private WebElement fryerCleanOnly;

	@FindBy(how = How.XPATH, using = ".//input[@name='location_name']")
	private WebElement fryer_Location;

	@FindBy(how = How.XPATH, using = ".//li[text()='Location1']")
	private WebElement locationNameSelect;

	@FindBy(how = How.XPATH, using = ".//textarea[@id='description']")
	private WebElement fryerDescription;

	@FindBy(how = How.XPATH, using = ".//div[@id='subpanel_customers_fr_fryers_newDiv']//table[@class='dcQuickEdit']//div[@class='action_buttons action-rows']//input[@type='submit' and @id='Fr_Fryers_subpanel_save_button']")
	private WebElement fryerSave;

	@FindBy(how = How.CSS, using = "#btn_location_name")
	private WebElement locationSelect;

	@FindBy(how = How.LINK_TEXT, using = "Location1")
	private WebElement locationname;

	@FindBy(how = How.XPATH, using = ".//input[@id='send_service_survey']")
	private WebElement sendServiceSurvey;

	@FindBy(how = How.XPATH, using = ".//input[@id='eir']")
	private WebElement sendEIR;

	@FindBy(how = How.XPATH, using = ".//input[@id='lavel1_charge']")
	private WebElement level1Charge;

	@FindBy(how = How.XPATH, using = ".//input[@id='additional_charge']")
	private WebElement additionalRate;

	@FindBy(how = How.XPATH, using = ".//input[@id='lavel1']")
	private WebElement first;

	@FindBy(how = How.XPATH, using = ".//input[@id='fryer_custom']")
	private WebElement fryerSize1;

	@FindBy(how = How.XPATH, using = ".//table[@class='tbl_fryer']//tr[3]//td[1]//input[2]")
	private WebElement fryerSize2;

	@FindBy(how = How.XPATH, using = ".//input[@id='fryer_price_custom']")
	private WebElement fryerChargeDefault;

	@FindBy(how = How.XPATH, using = ".//input[@id='fryer_price_custom1']")
	private WebElement fryerChargeDefault2;

	@FindBy(how = How.XPATH, using = ".//input[@id='fryer_dump_custom']")
	private WebElement fryerCleanOnlyCharge;

	@FindBy(how = How.XPATH, using = ".//input[@id='fryer_dump_custom0']")
	private WebElement fryerCleanOnlyCharge0;

	@FindBy(how = How.XPATH, using = ".//input[@id='addmore']")
	private WebElement addMore;

	@FindBy(how = How.XPATH, using = ".//input[@id='SAVE_HEADER']")
	private WebElement saveHeader;

	@FindBy(how = How.XPATH, using = ".//div[@class='required validation-message']")
	private WebElement chargeValidation;

	@FindBy(how = How.XPATH, using = ".//input[@id='set_charge']")
	private WebElement fixedCostCharge;

	@FindBy(how = How.XPATH, using = ".//input[@id='rental_rate']")
	private WebElement fCMonthly;

	@FindBy(how = How.XPATH, using = ".//input[@id='rental_rate_weekly']")
	private WebElement fCWeekly;

	@FindBy(how = How.XPATH, using = ".//select[@id='filtacool_frequency']")
	private WebElement defaultBillingPeriod;

	@FindBy(how = How.XPATH, using = ".//input[@id='pay_customer']")
	private WebElement filtaBioDefault;

	@FindBy(how = How.XPATH, using = ".//input[@id='oil_charge']")
	private WebElement fGOilCharge;

	@FindBy(how = How.XPATH, using = ".//input[@id='price_per_box']")
	private WebElement fGPerBox;

	@FindBy(how = How.XPATH, using = ".//input[@id='tank_rental']")
	private WebElement fGTankRental;

	@FindBy(how = How.XPATH, using = ".//input[@id='set_drainfoam']")
	private WebElement drainFoamDefault;

	@FindBy(how = How.XPATH, using = ".//select[@id='inv_period']")
	private WebElement defaultEstPeriod;

	@FindBy(how = How.XPATH, using = ".//input[@id='review_before_sending_inv' and @value='Yes']")
	private WebElement reviewDefaultYes;

	@FindBy(how = How.XPATH, using = ".//input[@id='review_before_sending_inv' and @value='No']")
	private WebElement reviewDefaultNo;

	@FindBy(how = How.XPATH, using = ".//input[@id='edit_button']")
	private WebElement editButton;

	@FindBy(how = How.XPATH, using = ".//div[@id='ajaxHeader']//div[@id='moduleList']//a[@id='grouptab_2']")
	private WebElement customerTab;

	@FindBy(how = How.XPATH, using = ".//select[@id='payment_term']")
	private WebElement defaultPayment;

	@FindBy(how = How.XPATH, using = ".//input[@id='SAVE_HEADER']")
	private WebElement save_Header;

	@FindBy(how = How.XPATH, using = ".//table[@id='ListTable']//tr[3]//td[3]")
	private WebElement customername;

	@FindBy(how = How.XPATH, using = ".//input[@id='lavel1_charge']")
	private WebElement actualLevel1Charge;

	@FindBy(how = How.XPATH, using = ".//input[@id='lavel1']")
	private WebElement actualFirst;

	@FindBy(how = How.XPATH, using = ".//input[@id='additional_charge']")
	private WebElement actualAdditionalRate;

	@FindBy(how = How.XPATH, using = ".//input[@title='Select all' and @id='massall_top']")
	private WebElement selectAll;

	@FindBy(how = How.XPATH, using = ".//input[@id='set_charge']")
	private WebElement actualFixedCharge;

	@FindBy(how = How.CSS, using = "#customers_fryer_locations_create_button")
	public WebElement locationCreate;

	@FindBy(how = How.XPATH, using = ".//div[@id='subpanel_customers_fryer_locations_newDiv']//table[@class='dcQuickEdit']//div[@class='action_buttons action-rows']//input[@type='submit' and @id='FR_FryerLocation_subpanel_save_button']")
	public WebElement locationSave;

	@FindBy(how = How.XPATH, using = ".//div[@id='list_subpanel_customers_fryer_locations']//table[@class='list view']//tbody//tr//tbody//tr//td[2]//span")
	public WebElement locationCheck;

	@FindBy(how = How.XPATH, using = ".//ul[@class='subpanelTablist']//li[4]")
	public WebElement other;

	@FindBy(how = How.XPATH, using = ".//div[@id='list_subpanel_customers_fr_fryers']//table//table//tbody//tr//td[2]//span")
	public WebElement fryersCheck;

	public FixedCostCustomerPage(WebDriver Driver)
	{
		global_Obj = new Global();
		prop = global_Obj.readProperties();
		this.driver = Driver;
		login = new Login(Driver);
		sa = new SoftAssert();
		fixedCostData = new ReadExcelData(prop.getProperty("Path2"), "FixedCost");
		pricingData = new ReadExcelData(prop.getProperty("Path2"), "Pricing");
		unitDataExcel = new ReadExcelData(prop.getProperty("Path2"), "UnitData");
		marketingData = new ReadExcelData(prop.getProperty("Path2"), "Marketing");
		defaultPricingData = new ReadExcelData(prop.getProperty("Path2"), "DefaultPricing");
		PageFactory.initElements(Driver, this);
	}


	public void login()
	{
		login.credentials();
		containerClose.click();
	}


	public String defaultPricingFranchiseeLevel()
	{
		admin.click();
		manageInvoice.click();
		global_Obj.wait(driver).until(ExpectedConditions.visibilityOf(defaultPricingTab));
		defaultPricingTab.click();
		// FiltaFry Per Lb
		if (level1Charge.getAttribute("value").equals(""))
		{
			level1Charge.sendKeys(defaultPricingData.getCellDataInt(1, 0) + "");
		}
		default_Level1Charge = level1Charge.getAttribute("value");
		if (additionalRate.getAttribute("value").equals(""))
		{
			additionalRate.sendKeys(defaultPricingData.getCellDataInt(2, 0) + "");
		}
		default_AdditionalRate = additionalRate.getAttribute("value");
		if (first.getAttribute("value").equals("") || first.getText().equals("0"))
		{
			first.sendKeys((int) defaultPricingData.getCellDataInt(2, 0) + "");
		}
		default_First = first.getAttribute("value");

		// FiltaFry Per Fryer
		if (fryerSize1.getAttribute("value").equals(""))
		{
			fryerSize1.sendKeys((int) defaultPricingData.getCellDataInt(1, 1) + "");
		}
		default_FryerSize1 = fryerSize1.getAttribute("value");
		if (fryerChargeDefault.getAttribute("value").equals(""))
		{
			fryerChargeDefault.sendKeys(defaultPricingData.getCellDataInt(2, 1) + "");
		}
		default_FryerChargeDefault = fryerChargeDefault.getAttribute("value");
		if (fryerCleanOnlyCharge.getAttribute("value").equals(""))
		{
			fryerCleanOnlyCharge.sendKeys(defaultPricingData.getCellDataInt(3, 1) + "");
		}
		default_FryerCleanOnlyCharge = fryerCleanOnlyCharge.getAttribute("value");

		// Set/Fixed Charge
		if (fixedCostCharge.getAttribute("value").equals(""))
		{
			fixedCostCharge.sendKeys(defaultPricingData.getCellDataInt(1, 2) + "");
		}
		default_FixedCostCharge = fixedCostCharge.getAttribute("value");

		// FiltaCool
		if (fCMonthly.getAttribute("value").equals(""))
		{
			fCMonthly.sendKeys(defaultPricingData.getCellDataInt(1, 3) + "");
		}
		default_FCMonthly = fCMonthly.getAttribute("value");
		if (fCWeekly.getAttribute("value").equals(""))
		{
			fCWeekly.sendKeys(defaultPricingData.getCellDataInt(2, 3) + "");
		}
		default_FCWeekly = fCWeekly.getAttribute("value");

		default_FCValue = global_Obj.select(defaultBillingPeriod).getFirstSelectedOption().getText();

		// FiltaBio

		if (filtaBioDefault.getAttribute("value").equals(""))
		{
			filtaBioDefault.sendKeys(defaultPricingData.getCellDataInt(1, 4) + "");
		}
		default_FiltaBioDefault = filtaBioDefault.getAttribute("value");

		// FiltaGold
		if (fGOilCharge.getAttribute("value").equals(""))
		{
			fGOilCharge.sendKeys(defaultPricingData.getCellDataInt(1, 5) + "");
		}
		default_FGOilCharge = fGOilCharge.getAttribute("value");
		if (fGPerBox.getAttribute("value").equals(""))
		{
			fGPerBox.sendKeys(defaultPricingData.getCellDataInt(2, 5) + "");
		}
		default_FGPerBox = fGPerBox.getAttribute("value");
		if (fGTankRental.getAttribute("value").equals(""))
		{
			fGTankRental.sendKeys(defaultPricingData.getCellDataInt(3, 5) + "");
		}
		default_FGTankRental = fGTankRental.getAttribute("value");

		// DrainFoam
		if (drainFoamDefault.getAttribute("value").equals(""))
		{
			drainFoamDefault.sendKeys(defaultPricingData.getCellDataInt(1, 6) + "");
		}
		default_DrainFoamDefault = drainFoamDefault.getAttribute("value");

		// EstPeriod
		default_EstPeriodValue = global_Obj.select(defaultEstPeriod).getFirstSelectedOption().getText();
		default_PaymentDefault = global_Obj.select(defaultPayment).getFirstSelectedOption().getText();
		global_Obj.jsReturn(driver).executeScript("arguments[0].scrollIntoView();", saveHeader);
		saveHeader.click();
		String CustomerName = goToCustomer();
		return CustomerName;
	}


	public String goToCustomer()
	{
		global_Obj.action(driver).moveToElement(customerTab).build().perform();
		global_Obj.action(driver).moveToElement(customer).click().build().perform();
		global_Obj.wait(driver)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@id='create_link']")));
		customer_URL = driver.getCurrentUrl();
		sa.assertEquals(customer_URL, fixedCostData.getCellData(1, 0));
		selectAll.click();
		global_Obj.wait(driver).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
				".//table[@class='paginationTable']//td[@class='paginationActionButtons']//span[@id='selectedRecordsTop' and @class='show']")));
		int count = Integer.parseInt(driver.findElement(By.xpath(
				".//table[@class='paginationTable']//td[@class='paginationActionButtons']//span[@id='selectedRecordsTop' and @class='show']//input"))
				.getAttribute("value"));
		System.out.println(count);
		String Array[] = new String[count];

		for (int i = 0, j = 3; i < count; i++, j++)
		{
			Array[i] = driver.findElement(By.xpath(".//table[@id='ListTable']//tr[" + j + "]//td[3]")).getText();
			if (driver.findElement(By.xpath(".//table[@id='ListTable']//tr[" + j + "]//td[3]")).getText()
					.equals(prop.getProperty("Customer0")))
			{
				webEelement = driver.findElement(By.xpath(".//table[@id='ListTable']//tr[" + j + "]//td[3]"));
			}
		}
		{
			for (int i = 0, j = 3; i < count; i++, j++)
			{
				Array[i] = driver.findElement(By.xpath(".//table[@id='ListTable']//tr[" + j + "]//td[3]"))
						.getText();
			}
		}

		for (int i = 0; i < Array.length; i++)
		{
//			System.out.println(Array[i]);
			if (Array[i].equals(prop.getProperty("Customer0")))
			{
				actualCustomer = Array[i];
				break;
			}
			else
			{
				actualCustomer = Array[i];
			}
		}
		// System.out.println(ActualCustomer);
		return actualCustomer;
	}


	public void createCustomer()
	{
		create_Customer.click();
	}


	public void basicInfo()
	{
		keyContact.sendKeys(fixedCostData.getCellData(1, 1) + " " + fixedCostData.getCellData(1, 2));
		title.sendKeys(fixedCostData.getCellData(1, 3));
		companyName.sendKeys(fixedCostData.getCellData(1, 4));
		nCAChain.sendKeys(fixedCostData.getCellData(1, 5));
		ncaUnitCode.sendKeys((int) fixedCostData.getCellDataInt(1, 6) + "");
		account.sendKeys((int) fixedCostData.getCellDataInt(1, 7) + "");
		sendServiceSurvey.click();
		sendEIR.click();
		primaryEmail.sendKeys(fixedCostData.getCellData(1, 8));
		site_Street.sendKeys(fixedCostData.getCellData(1, 9));
		site_City.sendKeys(fixedCostData.getCellData(1, 10));
		site_State.sendKeys(fixedCostData.getCellData(1, 11));
		site_PostalCode.sendKeys((int) fixedCostData.getCellDataInt(1, 12) + "");
		site_Country.sendKeys(fixedCostData.getCellData(1, 13));
//		Office_Phone.sendKeys(PerFryerData.getCellData(1, 14));
		ext.sendKeys((int) fixedCostData.getCellDataInt(1, 15) + "");
		arrivalNotes.sendKeys(fixedCostData.getCellData(1, 16));
		departureNotes.sendKeys(fixedCostData.getCellData(1, 17));
//		Mobile.sendKeys((int) PerFryerData.getCellDataInt(1, 18) + "");
		nca_Supplier.sendKeys((int) fixedCostData.getCellDataInt(1, 19) + "");
		invoiceStreet.sendKeys(fixedCostData.getCellData(1, 20));
		invoiceCity.sendKeys(fixedCostData.getCellData(1, 21));
		invoiceState.sendKeys(fixedCostData.getCellData(1, 22));
		invoicePostal.sendKeys((int) fixedCostData.getCellDataInt(1, 23) + "");
		invoiceCountry.sendKeys(fixedCostData.getCellData(1, 24));
		global_Obj.select(service_Frequency).selectByVisibleText(fixedCostData.getCellData(1, 25));
	}


	public void pricing()
	{
		pricing.click();
		global_Obj.select(defaultPricing).selectByVisibleText(pricingData.getCellData(1, 4));

		sa.assertEquals(prop.getProperty("FiltaFryCheckBox"), filtaFry.isSelected());
		if (filtaFry.isSelected() == false)
		{
			filtaFry.click();
			lodar();
			global_Obj.select(pricing_Model).selectByVisibleText("Set/Fixed Cost");
			lodar();
			sa.assertEquals(actualFixedCharge.getAttribute("value"), default_FixedCostCharge);
		}
		else
		{
			System.out.println("FiltaFry Already Checked");
		}

		sa.assertEquals(prop.getProperty("FiltaCoolCheckBox"), filtaCool.isSelected());
		if (filtaCool.isSelected() == false)
		{
			filtaCool.click();
			global_Obj.wait(driver)
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#rental_rate")));
			lodar();
			global_Obj.select(filtaCool_Frequency).selectByVisibleText(pricingData.getCellData(1, 1));
			if (rentalRate.getAttribute("value").equals(""))
			{
				rentalRate.sendKeys((int) pricingData.getCellDataInt(2, 1) + "");
			}
			sa.assertEquals(rentalRate, default_FCWeekly);
		}

		sa.assertEquals(prop.getProperty("FiltaBioCheckBox"), filtaBio.isSelected());
		if (filtaBio.isSelected() == false)
		{
			filtaBio.click();
			lodar();
			if (payCustomer.getAttribute("value").equals(""))
			{
				payCustomer.sendKeys((int) pricingData.getCellDataInt(1, 2) + "");
			}
		}
		sa.assertEquals(payCustomer, default_FiltaBioDefault);

		sa.assertEquals(prop.getProperty("FiltaGoldCheckBox"), filtaGold.isSelected());
		if (filtaGold.isSelected() == false)
		{
			filtaGold.click();
			lodar();
			if (noOfTank.getAttribute("value").equals(""))
			{
				noOfTank.sendKeys((int) pricingData.getCellDataInt(1, 3) + "");
			}
			if (tankRent.getAttribute("value").equals(""))
			{
				tankRent.sendKeys((int) pricingData.getCellDataInt(2, 3) + "");
			}
			sa.assertEquals(tankRent, default_FGTankRental);
			if (oil_Charge.getAttribute("value").equals(""))
			{
				oil_Charge.sendKeys((int) pricingData.getCellDataInt(3, 3) + "");
			}

			sa.assertEquals(oil_Charge, default_FGOilCharge);
			if (priceperBox.getAttribute("value").equals(""))
			{
				priceperBox.sendKeys((int) pricingData.getCellDataInt(4, 3) + "");
			}
			sa.assertEquals(priceperBox, default_FGPerBox);
		}

		sa.assertEquals(prop.getProperty("DrainFoamCheckBox"), drainFoam.isSelected());
		if (drainFoam.isSelected() == false)
		{
			drainFoam.click();
			lodar();
			if (charge.getAttribute("value").equals(""))
			{
				charge.sendKeys((int) pricingData.getCellDataInt(1, 5) + "");
			}
		}
		sa.assertEquals(charge, default_DrainFoamDefault);
		global_Obj.select(inv_Period).selectByVisibleText(pricingData.getCellData(1, 6));
		if (global_Obj.select(inv_Period).getFirstSelectedOption().getText().equals(pricingData.getCellData(1, 6)))
		{
			sa.assertEquals(true, perJob_Yes.isEnabled());
			sa.assertEquals(true, perJob_No.isEnabled());
			sa.assertEquals(true, perJob_Yes.isSelected());
		}
		else
		{
			System.out.println("It's not Per Job");
		}
		global_Obj.select(payement).selectByVisibleText(pricingData.getCellData(1, 7));
		actualPayment = driver.findElement(By.xpath(".//select[@id='payment_term']//option[1]")).getText();
		sa.assertEquals(actualPayment, default_PaymentDefault);
	}


	public void marketing()
	{
		marketing_Categories.click();
		typeMarketing.click();
		global_Obj.action(driver).moveToElement(amusementPark).click().build().perform();
		global_Obj.action(driver).moveToElement(casinos).click().build().perform();
		typeMarketing.click();
		sub_Type.sendKeys(marketingData.getCellData(1, 0));
		global_Obj.select(contract).selectByVisibleText("American Food and Vending");
		salespersonselect.click();
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		automation_Sales.click();
		driver.switchTo().window(tabs.get(0));
		affiliation.sendKeys(marketingData.getCellData(1, 1));
		chaininput.sendKeys(marketingData.getCellData(1, 2));
		global_Obj.wait(driver).until(ExpectedConditions.visibilityOf(a_W));
		global_Obj.action(driver).moveToElement(a_W).click().build().perform();
		global_Obj.select(nCASelection).selectByVisibleText(marketingData.getCellData(1, 3));
		region.sendKeys(marketingData.getCellData(1, 4));
		// Territory.click();
		tabs = new ArrayList<String>(driver.getWindowHandles());
		// Driver.switchTo().window(Tabs.get(1));
		// Automation.click();
		driver.switchTo().window(tabs.get(0));
	}


	public void unit_Data()
	{
		unitData.click();
		typeOfOil.sendKeys(unitDataExcel.getCellData(1, 0));
		qTY.sendKeys((int) unitDataExcel.getCellDataInt(1, 1) + "");
		wasteOil.sendKeys(unitDataExcel.getCellData(1, 2));
		rTI.sendKeys(unitDataExcel.getCellData(1, 3));
		availableServiceTime.sendKeys(unitDataExcel.getCellData(1, 4));
		dump_Fre_Description.sendKeys(unitDataExcel.getCellData(1, 5));
		wasteOilRenewal.click();
		today.click();
		renewaldate.click();
		rTIRenewalDate.click();
		today.click();
		rTIDate.click();
		save_Header.click();
	}


	public void location()
	{
		global_Obj.wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Other")));
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		other.click();
		loadar2();
		System.out.println(locationCheck.getText());

		if (locationCheck.getText().contains("(0 - 0 of 0)"))
		{
			locationCreate1.click();
			loadar2();
			locationName.sendKeys("Location1");
			locationDescription.sendKeys("Location Added for the Customer..");
			locationSave1.click();
		}
		else
		{
			System.out.println("Location Already Added !!");
		}

	}


	public void fryer()
	{
		global_Obj.wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Fryers")));
		// Fryers.click();
		global_Obj.action(driver).moveToElement(fryers).click().build().perform();
		global_Obj.jsReturn(driver).executeScript("arguments[0].scrollIntoView();", createFryer);
		if (fryersCheck.getText().contains("(0 - 0 of 0)"))
		{
			createFryer.click();
			loadar2();
			lodar();
			fryer.sendKeys("F1");
			fryerSize.sendKeys("50");
			fryerSort.click();
			lodar();
			fryerSort.sendKeys("1");
			locationSelect.click();
			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			locationSelect2.click();
			driver.switchTo().window(tabs.get(0));
			fryerDescription.sendKeys("Fryer One");
			fryerSave.click();
		}
		else if (fryersCheck.getText().contains("(1 - 1 of 1)"))
		{
			createFryer.click();
			loadar2();
			lodar();
			fryer.sendKeys("F2");
			fryerSize.sendKeys("100");
			fryerSort.click();
			lodar();
			fryerSort.sendKeys("2");
			locationSelect.click();
			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			locationSelect2.click();
			driver.switchTo().window(tabs.get(0));
			fryerDescription.sendKeys("Fryer Two ");
			fryerSave.click();
		}
		else if (fryersCheck.getText().contains("(1 - 2 of 2)"))
		{
			createFryer.click();
			loadar2();
			lodar();
			fryer.sendKeys("F3");
			fryerSize.sendKeys("100");
			fryerSort.click();
			lodar();
			fryerSort.sendKeys("3");
			locationSelect.click();
			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			locationSelect2.click();
			driver.switchTo().window(tabs.get(0));
			fryerDescription.sendKeys("Fryer Three");
			fryerSave.click();
		}
		else if (fryersCheck.getText().contains("(1 - 3 of 3)"))
		{
			createFryer.click();
			loadar2();
			lodar();
			fryer.sendKeys("F4");
			fryerSize.sendKeys("150");
			fryerSort.click();
			lodar();
			fryerSort.sendKeys("4");
			locationSelect.click();
			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			locationSelect2.click();
			driver.switchTo().window(tabs.get(0));
			fryerDescription.sendKeys("Fryer Four");
			fryerSave.click();
		}
		else
		{
			System.out.println("Fryers Are Already Added..");
		}

	}


	public void save()
	{
		save.click();
		lodar();
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


	public void clickingWebElement()
	{
		webEelement.click();
	}


	public void closeBrowser()
	{
		driver.close();
	}

}
