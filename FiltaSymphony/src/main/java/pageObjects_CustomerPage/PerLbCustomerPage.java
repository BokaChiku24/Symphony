package pageObjects_CustomerPage;

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

import util.Global;
import util.Login;
import util.ReadExcelData;

public class PerLbCustomerPage
{
	private Global global;
	private Properties Prop;
	private WebDriver driver;
	private Login login;
	private SoftAssert sa;
	private String Customer_URL;
	private ReadExcelData PerLbData;
	private ReadExcelData PricingData;
	private ReadExcelData UnitDataExcel;
	private ReadExcelData MarketingData;
	private ReadExcelData DefaultPricingData;
	private String Default_Level1Charge;
	private String Default_AdditionalRate;
	private String Default_First;
	private String Default_FryerSize1;
	private String Default_FryerChargeDefault;
	private String Default_FryerCleanOnlyCharge;
	private String Default_FryerSize2;
	private String Default_FryerChargeDefault2;
	private String Default_FryerCleanOnlyCharge0;
	private String Default_FixedCostCharge;
	private String Default_FCMonthly;
	private String Default_FCWeekly;
	private String Default_FiltaBioDefault;
	private String Default_FGOilCharge;
	private String Default_FGPerBox;
	private String Default_FGTankRental;
	private String Default_DrainFoamDefault;
	private String Default_FCValue;
	private String Default_EstPeriodValue;
	private String Default_PaymentDefault;
	private String ActualPayment;
	private String ActualCustomer;
	private WebElement webelement;
	
	@FindBy(how = How.XPATH, using = ".//a[@class='container-close']")
	private WebElement containerClose;

	@FindBy(how = How.XPATH, using = ".//a[@id='admin_link']")
	private WebElement Admin;

	@FindBy(how = How.XPATH, using = ".//a[@id='invoice_setting']")
	private WebElement ManageInvoice;

	@FindBy(how = How.XPATH, using = ".//a[@id='tab2']")
	private WebElement DefaultPricingTab;

	@FindBy(how = How.LINK_TEXT, using = "Customers")
	public WebElement customer;

	@FindBy(how = How.CSS, using = "#moduleTab_-1_Customers")
	public WebElement Customer;

	@FindBy(how = How.LINK_TEXT, using = "Create")
	private WebElement Create_Customer;

	@FindBy(how = How.CSS, using = "#name")
	private WebElement KeyContact;

	@FindBy(how = How.CSS, using = "#title")
	private WebElement Title;

	@FindBy(how = How.CSS, using = "#company_name")
	private WebElement CompanyName;

	@FindBy(how = How.CSS, using = "#nca_chain")
	private WebElement NCAChain;

	@FindBy(how = How.CSS, using = "#nca_unit_code")
	private WebElement NcaUnitCode;

	@FindBy(how = How.CSS, using = "#account_number")
	private WebElement Account;

	@FindBy(how = How.CSS, using = "#Accounts0emailAddress0")
	private WebElement PrimaryEmail;

	@FindBy(how = How.CSS, using = "#billing_address_street")
	private WebElement Site_Street;

	@FindBy(how = How.CSS, using = "#billing_address_city")
	private WebElement Site_City;

	@FindBy(how = How.CSS, using = "#billing_address_state")
	private WebElement Site_State;

	@FindBy(how = How.CSS, using = "#billing_address_postalcode")
	private WebElement Site_PostalCode;

	@FindBy(how = How.CSS, using = "#billing_address_country")
	private WebElement Site_Country;

	@FindBy(how = How.XPATH, using = ".//input[@name='phone_office']")
	private WebElement Office_Phone;

	@FindBy(how = How.CSS, using = "#ext_no")
	private WebElement Ext;

	@FindBy(how = How.CSS, using = "#operations_notes")
	private WebElement ArrivalNotes;

	@FindBy(how = How.CSS, using = "#description")
	private WebElement DepartureNotes;

	@FindBy(how = How.XPATH, using = ".//input[@name='phone_mobile']")
	private WebElement Mobile;

	@FindBy(how = How.CSS, using = "#nca_supplier_number")
	private WebElement Nca_Supplier;

	@FindBy(how = How.CSS, using = "#shipping_address_street")
	private WebElement InvoiceStreet;

	@FindBy(how = How.CSS, using = "#shipping_address_city")
	private WebElement InvoiceCity;

	@FindBy(how = How.CSS, using = "#shipping_address_state")
	private WebElement InvoiceState;

	@FindBy(how = How.CSS, using = "#shipping_address_postalcode")
	private WebElement InvoicePostal;

	@FindBy(how = How.CSS, using = "#shipping_address_country")
	private WebElement InvoiceCountry;

	@FindBy(how = How.CSS, using = "#survey_frequency")
	private WebElement Service_Frequency;

	@FindBy(how = How.LINK_TEXT, using = "Pricing & Estimating Info")
	private WebElement Pricing;

	@FindBy(how = How.CSS, using = "#default_pricing")
	private WebElement DefaultPricing;

	@FindBy(how = How.CSS, using = "#service_filtafry")
	private WebElement FiltaFry;

	@FindBy(how = How.CSS, using = "#charge_type")
	private WebElement Pricing_Model;

	@FindBy(how = How.CSS, using = "#ajaxloading_mask")
	private WebElement Lodar;

	@FindBy(how = How.CSS, using = "#filtacool")
	private WebElement FiltaCool;

	@FindBy(how = How.CSS, using = "#filtacool_frequency")
	private WebElement FiltaCool_Frequency;

	@FindBy(how = How.CSS, using = "#rental_rate")
	private WebElement RentalRate;

	@FindBy(how = How.CSS, using = "#filtabio")
	private WebElement FiltaBio;

	@FindBy(how = How.CSS, using = "#pay_customer")
	private WebElement PayCustomer;

	@FindBy(how = How.CSS, using = "#service_filtanewoil")
	private WebElement FiltaGold;

	@FindBy(how = How.CSS, using = "#number_of_tanks")
	private WebElement NoOfTank;

	@FindBy(how = How.CSS, using = "#tank_rental")
	private WebElement TankRent;

	@FindBy(how = How.CSS, using = "#oil_charge")
	private WebElement Oil_Charge;

	@FindBy(how = How.CSS, using = "#price_per_box")
	private WebElement PriceperBox;

	@FindBy(how = How.CSS, using = "#service_drainfoam")
	private WebElement DrainFoam;

	@FindBy(how = How.CSS, using = "#set_drainfoam")
	private WebElement Charge;

	@FindBy(how = How.CSS, using = "#inv_period")
	private WebElement Inv_Period;

	@FindBy(how = How.XPATH, using = ".//td[@class='edit-table-row1']//label[1]//input[@type='radio' and @id='review_before_sending_inv']")
	private WebElement PerJob_Yes;

	@FindBy(how = How.XPATH, using = ".//td[@class='edit-table-row1']//label[2]//input[@type='radio' and @id='review_before_sending_inv']")
	private WebElement PerJob_No;

	@FindBy(how = How.CSS, using = "#payment_term")
	private WebElement Payement;

	@FindBy(how = How.LINK_TEXT, using = "Marketing & Categories")
	private WebElement Marketing_Categories;

	@FindBy(how = How.XPATH, using = ".//input[@id='type-input']")
	private WebElement TypeMarketing;

	@FindBy(how = How.XPATH, using = ".//li[@data-text='Amusement Park']")
	private WebElement AmusementPark;

	@FindBy(how = How.XPATH, using = ".//li[@data-text='Casinos']")
	private WebElement Casinos;

	@FindBy(how = How.XPATH, using = ".//li[@data-text='A&W Restaurants']")
	private WebElement A_W;

	@FindBy(how = How.CSS, using = "#sub_type")
	private WebElement Sub_Type;

	@FindBy(how = How.CSS, using = "#contract_caterers")
	private WebElement Contract;

	@FindBy(how = How.CSS, using = "#btn_assigned_user_name")
	private WebElement Salespersonselect;

	@FindBy(how = How.CSS, using = "#affiliation")
	private WebElement Affiliation;

	@FindBy(how = How.XPATH, using = ".//input[@name='chain-input']")
	private WebElement Chaininput;

	@FindBy(how = How.CSS, using = "#nca")
	private WebElement NCASelection;

	@FindBy(how = How.CSS, using = "#region_name")
	private WebElement Region;

	@FindBy(how = How.CSS, using = "#btn_territory")
	private WebElement Territory;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Automation_Sales")
	private WebElement Automation_Sales;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Automation")
	private WebElement Automation;

	@FindBy(how = How.LINK_TEXT, using = "Unit Data")
	private WebElement UnitData;

	@FindBy(how = How.CSS, using = "#type_of_oil")
	private WebElement TypeOfOil;

	@FindBy(how = How.CSS, using = "#dump_fre")
	private WebElement QTY;

	@FindBy(how = How.CSS, using = "#waste_oil")
	private WebElement WasteOil;

	@FindBy(how = How.CSS, using = "#rti")
	private WebElement RTI;

	@FindBy(how = How.CSS, using = "#available_service_times")
	private WebElement AvailableServiceTime;

	@FindBy(how = How.CSS, using = "#dump_fre_description")
	private WebElement Dump_Fre_Description;

	@FindBy(how = How.CSS, using = "#waste_oil_renewal_date_trigger")
	private WebElement WasteOilRenewal;

	@FindBy(how = How.LINK_TEXT, using = "Today")
	private WebElement Today;

	@FindBy(how = How.CSS, using = "#waste_oil_renewal_date")
	private WebElement Renewaldate;

	@FindBy(how = How.CSS, using = "#rti_renewal_date_trigger")
	private WebElement RTIRenewalDate;

	@FindBy(how = How.CSS, using = "#rti_renewal_date")
	private WebElement RTIDate;

	@FindBy(how = How.XPATH, using = ".//div[@class='buttons']//input[@id='SAVE_HEADER']")
	private WebElement Save;

	@FindBy(how = How.CSS, using = "#customers_fryer_locations_create_button")
	private WebElement LocationCreate;

	@FindBy(how = How.XPATH, using = ".//input[@type='text']")
	private WebElement LocationName;

	@FindBy(how = How.XPATH, using = ".//textarea[@name='description']")
	private WebElement LocationDescription;

	@FindBy(how = How.XPATH, using = ".//div[@id='subpanel_customers_fryer_locations_newDiv']//table[@class='dcQuickEdit']//div[@class='action_buttons action-rows']//input[@type='submit' and @id='FR_FryerLocation_subpanel_save_button']")
	private WebElement LocationSave;

	@FindBy(how = How.XPATH, using = ".//ul[@id='groupTabs']//li[4]")
	private WebElement Fryers;

	@FindBy(how = How.CSS, using = "#customers_fr_fryers_create_button")
	private WebElement CreateFryer;

	@FindBy(how = How.XPATH, using = ".//input[@name='name']")
	private WebElement Fryer;

	@FindBy(how = How.XPATH, using = ".//input[@name='size']")
	private WebElement FryerSize;

	@FindBy(how = How.XPATH, using = ".//input[@name='sort_order']")
	private WebElement FryerSort;

	@FindBy(how = How.XPATH, using = ".//input[@name='charge']")
	private WebElement FryerCharge;

	@FindBy(how = How.XPATH, using = ".//input[@name='dump_clean_charges']")
	private WebElement FryerCleanOnly;

	@FindBy(how = How.XPATH, using = ".//input[@name='location_name']")
	private WebElement Fryer_Location;

	@FindBy(how = How.XPATH, using = ".//li[text()='Location1']")
	private WebElement LocationNameSelect;

	@FindBy(how = How.XPATH, using = ".//textarea[@id='description']")
	private WebElement FryerDescription;

	@FindBy(how = How.XPATH, using = ".//div[@id='subpanel_customers_fr_fryers_newDiv']//table[@class='dcQuickEdit']//div[@class='action_buttons action-rows']//input[@type='submit' and @id='Fr_Fryers_subpanel_save_button']")
	private WebElement FryerSave;

	@FindBy(how = How.CSS, using = "#btn_location_name")
	private WebElement LocationSelect;

	@FindBy(how = How.LINK_TEXT, using = "Location1")
	private WebElement Locationname;

	@FindBy(how = How.XPATH, using = ".//input[@id='send_service_survey']")
	private WebElement SendServiceSurvey;

	@FindBy(how = How.XPATH, using = ".//input[@id='eir']")
	private WebElement SendEIR;

	@FindBy(how = How.XPATH, using = ".//input[@id='lavel1_charge']")
	private WebElement Level1Charge;

	@FindBy(how = How.XPATH, using = ".//input[@id='additional_charge']")
	private WebElement AdditionalRate;

	@FindBy(how = How.XPATH, using = ".//input[@id='lavel1']")
	private WebElement First;

	@FindBy(how = How.XPATH, using = ".//input[@id='fryer_custom']")
	private WebElement FryerSize1;

	@FindBy(how = How.XPATH, using = ".//table[@class='tbl_fryer']//tr[3]//td[1]//input[2]")
	private WebElement FryerSize2;

	@FindBy(how = How.XPATH, using = ".//input[@id='fryer_price_custom']")
	private WebElement FryerChargeDefault;

	@FindBy(how = How.XPATH, using = ".//input[@id='fryer_price_custom1']")
	private WebElement FryerChargeDefault2;

	@FindBy(how = How.XPATH, using = ".//input[@id='fryer_dump_custom']")
	private WebElement FryerCleanOnlyCharge;

	@FindBy(how = How.XPATH, using = ".//input[@id='fryer_dump_custom0']")
	private WebElement FryerCleanOnlyCharge0;

	@FindBy(how = How.XPATH, using = ".//input[@id='addmore']")
	private WebElement AddMore;

	@FindBy(how = How.XPATH, using = ".//input[@id='SAVE_HEADER']")
	private WebElement SaveHeader;

	@FindBy(how = How.XPATH, using = ".//div[@class='required validation-message']")
	private WebElement ChargeValidation;

	@FindBy(how = How.XPATH, using = ".//input[@id='set_charge']")
	private WebElement FixedCostCharge;

	@FindBy(how = How.XPATH, using = ".//input[@id='rental_rate']")
	private WebElement FCMonthly;

	@FindBy(how = How.XPATH, using = ".//input[@id='rental_rate_weekly']")
	private WebElement FCWeekly;

	@FindBy(how = How.XPATH, using = ".//select[@id='filtacool_frequency']")
	private WebElement DefaultBillingPeriod;

	@FindBy(how = How.XPATH, using = ".//input[@id='pay_customer']")
	private WebElement FiltaBioDefault;

	@FindBy(how = How.XPATH, using = ".//input[@id='oil_charge']")
	private WebElement FGOilCharge;

	@FindBy(how = How.XPATH, using = ".//input[@id='price_per_box']")
	private WebElement FGPerBox;

	@FindBy(how = How.XPATH, using = ".//input[@id='tank_rental']")
	private WebElement FGTankRental;

	@FindBy(how = How.XPATH, using = ".//input[@id='set_drainfoam']")
	private WebElement DrainFoamDefault;

	@FindBy(how = How.XPATH, using = ".//select[@id='inv_period']")
	private WebElement DefaultEstPeriod;

	@FindBy(how = How.XPATH, using = ".//input[@id='review_before_sending_inv' and @value='Yes']")
	private WebElement ReviewDefaultYes;

	@FindBy(how = How.XPATH, using = ".//input[@id='review_before_sending_inv' and @value='No']")
	private WebElement ReviewDefaultNo;

	@FindBy(how = How.XPATH, using = ".//input[@id='edit_button']")
	private WebElement EditButton;

	@FindBy(how = How.XPATH, using = ".//div[@id='ajaxHeader']//div[@id='moduleList']//a[@id='grouptab_2']")
	private WebElement CustomerTab;

	@FindBy(how = How.XPATH, using = ".//select[@id='payment_term']")
	private WebElement DefaultPayment;

	@FindBy(how = How.XPATH, using = ".//input[@id='SAVE_HEADER']")
	private WebElement Save_Header;

	@FindBy(how = How.XPATH, using = ".//table[@id='ListTable']//tr[3]//td[3]")
	private WebElement Customername;

	@FindBy(how = How.XPATH, using = ".//input[@id='lavel1_charge']")
	private WebElement ActualLevel1Charge;

	@FindBy(how = How.XPATH, using = ".//input[@id='lavel1']")
	private WebElement ActualFirst;

	@FindBy(how = How.XPATH, using = ".//input[@id='additional_charge']")
	private WebElement ActualAdditionalRate;

	@FindBy(how = How.XPATH, using = ".//input[@title='Select all' and @id='massall_top']")
	private WebElement SelectAll;

	@FindBy(how = How.CSS, using = "#customers_fryer_locations_create_button")
	public WebElement locationCreate;

	@FindBy(how = How.XPATH, using = ".//div[@id='subpanel_customers_fryer_locations_newDiv']//table[@class='dcQuickEdit']//div[@class='action_buttons action-rows']//input[@type='submit' and @id='FR_FryerLocation_subpanel_save_button']")
	public WebElement locationSave;

	@FindBy(how = How.XPATH, using = ".//div[@id='list_subpanel_customers_fryer_locations']//table[@class='list view']//tbody//tr//tbody//tr//td[2]//span")
	public WebElement LocationCheck;

	@FindBy(how = How.XPATH, using = ".//ul[@class='subpanelTablist']//li[9]")
	public WebElement Other;

	@FindBy(how = How.XPATH, using = ".//div[@id='list_subpanel_customers_fr_fryers']//table//table//tbody//tr//td[2]//span")
	public WebElement FryersCheck;
	
	public PerLbCustomerPage(WebDriver driver)
	{
		global = new Global();
		Prop = global.readProperties();
		this.driver = driver;
		login = new Login(driver);
		sa = new SoftAssert();
		PerLbData = new ReadExcelData(Prop.getProperty("Path2"), "PerLb");
		PricingData = new ReadExcelData(Prop.getProperty("Path2"), "Pricing");
		UnitDataExcel = new ReadExcelData(Prop.getProperty("Path2"), "UnitData");
		MarketingData = new ReadExcelData(Prop.getProperty("Path2"), "Marketing");
		DefaultPricingData = new ReadExcelData(Prop.getProperty("Path2"), "DefaultPricing");
		PageFactory.initElements(driver, this);
	}


	public void login()
	{
		login.credentials();
		containerClose.click();
	}


	public String defaultPricingFranchiseeLevel()
	{
		Admin.click();
		ManageInvoice.click();
		global.wait(driver).until(ExpectedConditions.visibilityOf(DefaultPricingTab));
		DefaultPricingTab.click();
		// FiltaFry Per Lb
		if (Level1Charge.getAttribute("value").equals(""))
		{
			Level1Charge.sendKeys(DefaultPricingData.getCellDataInt(1, 0) + "");
		}
		Default_Level1Charge = Level1Charge.getAttribute("value");
		if (AdditionalRate.getAttribute("value").equals(""))
		{
			AdditionalRate.sendKeys(DefaultPricingData.getCellDataInt(2, 0) + "");
		}
		Default_AdditionalRate = AdditionalRate.getAttribute("value");
		if (First.getAttribute("value").equals("") || First.getText().equals("0"))
		{
			First.sendKeys((int) DefaultPricingData.getCellDataInt(2, 0) + "");
		}
		Default_First = First.getAttribute("value");

		// FiltaFry Per Fryer
		if (FryerSize1.getAttribute("value").equals(""))
		{
			FryerSize1.sendKeys((int) DefaultPricingData.getCellDataInt(1, 1) + "");
		}
		Default_FryerSize1 = FryerSize1.getAttribute("value");
		if (FryerChargeDefault.getAttribute("value").equals(""))
		{
			FryerChargeDefault.sendKeys(DefaultPricingData.getCellDataInt(2, 1) + "");
		}
		Default_FryerChargeDefault = FryerChargeDefault.getAttribute("value");
		if (FryerCleanOnlyCharge.getAttribute("value").equals(""))
		{
			FryerCleanOnlyCharge.sendKeys(DefaultPricingData.getCellDataInt(3, 1) + "");
		}
		Default_FryerCleanOnlyCharge = FryerCleanOnlyCharge.getAttribute("value");

		// Set/Fixed Charge
		if (FixedCostCharge.getAttribute("value").equals(""))
		{
			FixedCostCharge.sendKeys(DefaultPricingData.getCellDataInt(1, 2) + "");
		}
		Default_FixedCostCharge = FixedCostCharge.getAttribute("value");

		// FiltaCool
		if (FCMonthly.getAttribute("value").equals(""))
		{
			FCMonthly.sendKeys(DefaultPricingData.getCellDataInt(1, 3) + "");
		}
		Default_FCMonthly = FCMonthly.getAttribute("value");
		if (FCWeekly.getAttribute("value").equals(""))
		{
			FCWeekly.sendKeys(DefaultPricingData.getCellDataInt(2, 3) + "");
		}
		Default_FCWeekly = FCWeekly.getAttribute("value");

		Default_FCValue = global.select(DefaultBillingPeriod).getFirstSelectedOption().getText();

		// FiltaBio

		if (FiltaBioDefault.getAttribute("value").equals(""))
		{
			FiltaBioDefault.sendKeys(DefaultPricingData.getCellDataInt(1, 4) + "");
		}
		Default_FiltaBioDefault = FiltaBioDefault.getAttribute("value");

		// FiltaGold
		if (FGOilCharge.getAttribute("value").equals(""))
		{
			FGOilCharge.sendKeys(DefaultPricingData.getCellDataInt(1, 5) + "");
		}
		Default_FGOilCharge = FGOilCharge.getAttribute("value");
		if (FGPerBox.getAttribute("value").equals(""))
		{
			FGPerBox.sendKeys(DefaultPricingData.getCellDataInt(2, 5) + "");
		}
		Default_FGPerBox = FGPerBox.getAttribute("value");
		if (FGTankRental.getAttribute("value").equals(""))
		{
			FGTankRental.sendKeys(DefaultPricingData.getCellDataInt(3, 5) + "");
		}
		Default_FGTankRental = FGTankRental.getAttribute("value");

		// DrainFoam
		if (DrainFoamDefault.getAttribute("value").equals(""))
		{
			DrainFoamDefault.sendKeys(DefaultPricingData.getCellDataInt(1, 6) + "");
		}
		Default_DrainFoamDefault = DrainFoamDefault.getAttribute("value");

		// EstPeriod
		Default_EstPeriodValue = global.select(DefaultEstPeriod).getFirstSelectedOption().getText();
		Default_PaymentDefault = global.select(DefaultPayment).getFirstSelectedOption().getText();
		global.jsReturn(driver).executeScript("arguments[0].scrollIntoView();", SaveHeader);
		SaveHeader.click();
		String CustomerName = goToCustomer();
		return CustomerName;
	}


	public String goToCustomer()
	{
		global.action(driver).moveToElement(CustomerTab).build().perform();
		global.action(driver).moveToElement(Customer).click().build().perform();
		global.wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@id='create_link']")));
		Customer_URL = driver.getCurrentUrl();
		sa.assertEquals(Customer_URL, PerLbData.getCellData(1, 0));
		SelectAll.click();
		global.wait(driver).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
				".//table[@class='paginationTable']//td[@class='paginationActionButtons']//span[@id='selectedRecordsTop' and @class='show']")));
		int count = Integer.parseInt(driver.findElement(By.xpath(
				".//table[@class='paginationTable']//td[@class='paginationActionButtons']//span[@id='selectedRecordsTop' and @class='show']//input"))
				.getAttribute("value"));
		String Array[] = new String[count];
		for (int i = 0, j = 3; i < count; i++, j++)
		{
			Array[i] = driver.findElement(By.xpath(".//table[@id='ListTable']//tr[" + j + "]//td[3]")).getText();
			if (driver.findElement(By.xpath(".//table[@id='ListTable']//tr[" + j + "]//td[3]")).getText()
					.equals(Prop.getProperty("Customer1")))
			{
				webelement = driver.findElement(By.xpath(".//table[@id='ListTable']//tr[" + j + "]//td[3]"));
			}
		}
		for (int i = 0; i < Array.length; i++)
		{
			if (Array[i].equals(Prop.getProperty("Customer1")))
			{
				ActualCustomer = Array[i];
				break;
			}
			else
			{
				ActualCustomer = Array[i];
			}
		}
		System.out.println(ActualCustomer);
		return ActualCustomer;
	}


	public void createCustomer()
	{
		Create_Customer.click();
	}


	public void basicInfo()
	{
		KeyContact.sendKeys(PerLbData.getCellData(1, 1) + " " + PerLbData.getCellData(1, 2));
		Title.sendKeys(PerLbData.getCellData(1, 3));
		CompanyName.sendKeys(PerLbData.getCellData(1, 4));
		NCAChain.sendKeys(PerLbData.getCellData(1, 5));
		NcaUnitCode.sendKeys((int) PerLbData.getCellDataInt(1, 6) + "");
		Account.sendKeys((int) PerLbData.getCellDataInt(1, 7) + "");
		SendServiceSurvey.click();
		SendEIR.click();
		PrimaryEmail.sendKeys(PerLbData.getCellData(1, 8));
		Site_Street.sendKeys(PerLbData.getCellData(1, 9));
		Site_City.sendKeys(PerLbData.getCellData(1, 10));
		Site_State.sendKeys(PerLbData.getCellData(1, 11));
		Site_PostalCode.sendKeys((int) PerLbData.getCellDataInt(1, 12) + "");
		Site_Country.sendKeys(PerLbData.getCellData(1, 13));
//		Office_Phone.sendKeys(PerFryerData.getCellData(1, 14));
		Ext.sendKeys((int) PerLbData.getCellDataInt(1, 15) + "");
		ArrivalNotes.sendKeys(PerLbData.getCellData(1, 16));
		DepartureNotes.sendKeys(PerLbData.getCellData(1, 17));
//		Mobile.sendKeys((int) PerFryerData.getCellDataInt(1, 18) + "");
		Nca_Supplier.sendKeys((int) PerLbData.getCellDataInt(1, 19) + "");
		InvoiceStreet.sendKeys(PerLbData.getCellData(1, 20));
		InvoiceCity.sendKeys(PerLbData.getCellData(1, 21));
		InvoiceState.sendKeys(PerLbData.getCellData(1, 22));
		InvoicePostal.sendKeys((int) PerLbData.getCellDataInt(1, 23) + "");
		InvoiceCountry.sendKeys(PerLbData.getCellData(1, 24));
		global.select(Service_Frequency).selectByVisibleText(PerLbData.getCellData(1, 25));
	}


	public void pricing()
	{
		Pricing.click();
		global.select(DefaultPricing).selectByVisibleText(PricingData.getCellData(1, 4));

		sa.assertEquals(Prop.getProperty("FiltaFryCheckBox"), FiltaFry.isSelected());
		if (FiltaFry.isSelected() == false)
		{
			FiltaFry.click();
			lodar();
			global.select(Pricing_Model).selectByVisibleText("Per lb");
			lodar();
			sa.assertEquals(ActualLevel1Charge.getAttribute("value"), Default_Level1Charge);
			sa.assertEquals(ActualFirst.getAttribute("value"), Default_First);
			sa.assertEquals(ActualAdditionalRate.getAttribute("value"), Default_AdditionalRate);
		}
		else
		{
			System.out.println("FiltaFry Already Checked");
		}

		sa.assertEquals(Prop.getProperty("FiltaCoolCheckBox"), FiltaCool.isSelected());
		if (FiltaCool.isSelected() == false)
		{
			FiltaCool.click();
			global.wait(driver)
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#rental_rate")));
			lodar();
			global.select(FiltaCool_Frequency).selectByVisibleText(PricingData.getCellData(1, 1));
			if (RentalRate.getAttribute("value").equals(""))
			{
				RentalRate.sendKeys((int) PricingData.getCellDataInt(2, 1) + "");
			}
			sa.assertEquals(RentalRate, Default_FCWeekly);
		}

		sa.assertEquals(Prop.getProperty("FiltaBioCheckBox"), FiltaBio.isSelected());
		if (FiltaBio.isSelected() == false)
		{
			FiltaBio.click();
			lodar();
			if (PayCustomer.getAttribute("value").equals(""))
			{
				PayCustomer.sendKeys((int) PricingData.getCellDataInt(1, 2) + "");
			}
		}
		sa.assertEquals(PayCustomer, Default_FiltaBioDefault);

		sa.assertEquals(Prop.getProperty("FiltaGoldCheckBox"), FiltaGold.isSelected());
		if (FiltaGold.isSelected() == false)
		{
			FiltaGold.click();
			lodar();
			if (NoOfTank.getAttribute("value").equals(""))
			{
				NoOfTank.sendKeys((int) PricingData.getCellDataInt(1, 3) + "");
			}
			if (TankRent.getAttribute("value").equals(""))
			{
				TankRent.sendKeys((int) PricingData.getCellDataInt(2, 3) + "");
			}
			sa.assertEquals(TankRent, Default_FGTankRental);
			if (Oil_Charge.getAttribute("value").equals(""))
			{
				Oil_Charge.sendKeys((int) PricingData.getCellDataInt(3, 3) + "");
			}

			sa.assertEquals(Oil_Charge, Default_FGOilCharge);
			if (PriceperBox.getAttribute("value").equals(""))
			{
				PriceperBox.sendKeys((int) PricingData.getCellDataInt(4, 3) + "");
			}
			sa.assertEquals(PriceperBox, Default_FGPerBox);
		}

		sa.assertEquals(Prop.getProperty("DrainFoamCheckBox"), DrainFoam.isSelected());
		if (DrainFoam.isSelected() == false)
		{
			DrainFoam.click();
			lodar();
			if (Charge.getAttribute("value").equals(""))
			{
				Charge.sendKeys((int) PricingData.getCellDataInt(1, 5) + "");
			}
		}
		sa.assertEquals(Charge, Default_DrainFoamDefault);
		global.select(Inv_Period).selectByVisibleText(PricingData.getCellData(1, 6));
		if (global.select(Inv_Period).getFirstSelectedOption().getText().equals(PricingData.getCellData(1, 6)))
		{
			sa.assertEquals(true, PerJob_Yes.isEnabled());
			sa.assertEquals(true, PerJob_No.isEnabled());
			sa.assertEquals(true, PerJob_Yes.isSelected());
		}
		else
		{
			System.out.println("It's not Per Job");
		}
		global.select(Payement).selectByVisibleText(PricingData.getCellData(1, 7));
		ActualPayment = driver.findElement(By.xpath(".//select[@id='payment_term']//option[1]")).getText();
		sa.assertEquals(ActualPayment, Default_PaymentDefault);
	}


	public void marketing()
	{
		Marketing_Categories.click();
		TypeMarketing.click();
		global.action(driver).moveToElement(AmusementPark).click().build().perform();
		global.action(driver).moveToElement(Casinos).click().build().perform();
		TypeMarketing.click();
		Sub_Type.sendKeys(MarketingData.getCellData(1, 0));
		global.select(Contract).selectByVisibleText("American Food and Vending");
		Salespersonselect.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Automation_Sales.click();
		driver.switchTo().window(tabs.get(0));
		Affiliation.sendKeys(MarketingData.getCellData(1, 1));
		Chaininput.sendKeys(MarketingData.getCellData(1, 2));
		global.wait(driver).until(ExpectedConditions.visibilityOf(A_W));
		global.action(driver).moveToElement(A_W).click().build().perform();
		global.select(NCASelection).selectByVisibleText(MarketingData.getCellData(1, 3));
		Region.sendKeys(MarketingData.getCellData(1, 4));
		Territory.click();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Automation.click();
		driver.switchTo().window(tabs2.get(0));
	}


	public void unit_Data()
	{
		UnitData.click();
		TypeOfOil.sendKeys(UnitDataExcel.getCellData(1, 0));
		QTY.sendKeys((int) UnitDataExcel.getCellDataInt(1, 1) + "");
		WasteOil.sendKeys(UnitDataExcel.getCellData(1, 2));
		RTI.sendKeys(UnitDataExcel.getCellData(1, 3));
		AvailableServiceTime.sendKeys(UnitDataExcel.getCellData(1, 4));
		Dump_Fre_Description.sendKeys(UnitDataExcel.getCellData(1, 5));
		WasteOilRenewal.click();
		Today.click();
		Renewaldate.click();
		RTIRenewalDate.click();
		Today.click();
		RTIDate.click();
		Save_Header.click();
	}


	public void location()
	{
		global.wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Other")));
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Other.click();
		loadar2();
		System.out.println(LocationCheck.getText());

		if (LocationCheck.getText().contains("(0 - 0 of 0)"))
		{
			locationCreate.click();
			loadar2();
			LocationName.sendKeys("Location1");
			LocationDescription.sendKeys("Location Added for the Customer..");
			locationSave.click();
		}
		else
		{
			System.out.println("Location Already Added !!");
		}

	}

	public void fryer()
	{
		global.wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Fryers")));
		// Fryers.click();
		global.action(driver).moveToElement(Fryers).click().build().perform();
		global.jsReturn(driver).executeScript("arguments[0].scrollIntoView();", CreateFryer);
		if (FryersCheck.getText().contains("(0 - 0 of 0)"))
		{
			CreateFryer.click();
			loadar2();
			lodar();
			global.wait(driver).until(ExpectedConditions.visibilityOf(Fryer));
			Fryer.sendKeys("F1");
			FryerSize.sendKeys("50");
			FryerSort.click();
			lodar();
			FryerSort.sendKeys("1");
			LocationSelect.click();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			Locationname.click();
			driver.switchTo().window(tabs.get(0));
			FryerDescription.sendKeys("Fryer One");
			FryerSave.click();
		}
		else if (FryersCheck.getText().contains("(1 - 1 of 1)"))
		{
			CreateFryer.click();
			loadar2();
			lodar();
			Fryer.sendKeys("F2");
			FryerSize.sendKeys("100");
			FryerSort.click();
			lodar();
			FryerSort.sendKeys("2");
			LocationSelect.click();
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			Locationname.click();
			driver.switchTo().window(tabs2.get(0));
			FryerDescription.sendKeys("Fryer Two ");
			FryerSave.click();
		}
		else if (FryersCheck.getText().contains("(1 - 2 of 2)"))
		{
			CreateFryer.click();
			loadar2();
			lodar();
			Fryer.sendKeys("F3");
			FryerSize.sendKeys("100");
			FryerSort.click();
			lodar();
			FryerSort.sendKeys("3");
			LocationSelect.click();
			ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs3.get(1));
			Locationname.click();
			driver.switchTo().window(tabs3.get(0));
			FryerDescription.sendKeys("Fryer Three");
			FryerSave.click();
		}
		else if (FryersCheck.getText().contains("(1 - 3 of 3)"))
		{
			CreateFryer.click();
			loadar2();
			lodar();
			Fryer.sendKeys("F4");
			FryerSize.sendKeys("150");
			FryerSort.click();
			lodar();
			FryerSort.sendKeys("4");
			LocationSelect.click();
			ArrayList<String> tabs4 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs4.get(1));
			Locationname.click();
			driver.switchTo().window(tabs4.get(0));
			FryerDescription.sendKeys("Fryer Four");
			FryerSave.click();
		}
		else
		{
			System.out.println("Fryers Are Already Added..");
		}

	}

	public void save()
	{
		Save.click();
		lodar();
	}


	private void lodar()
	{
		global.wait(driver)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ajaxloading_mask")));
	}


	public void loadar2()
	{
		global.wait(driver).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ajaxStatusDiv")));
	}


	public void clickingWebElement()
	{
		webelement.click();
	}


	public void closeBrowser()
	{
		driver.close();
	}

}
