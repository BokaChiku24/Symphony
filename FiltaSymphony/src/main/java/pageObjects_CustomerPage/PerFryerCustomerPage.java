package pageObjects_CustomerPage;

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

public class PerFryerCustomerPage
{
	private Global global;
	private Properties Prop;
	private WebDriver driver;
	private Login login;
	private SoftAssert sa;
	private String Customer_URL;
	private ReadExcelData PerFryerData;

	@FindBy(how = How.XPATH, using = ".//a[@class='container-close']")
	private WebElement containerClose;

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

	@FindBy(how = How.CSS, using = "#ajaxloading_mask")
	private WebElement Lodar;

	@FindBy(how = How.CSS, using = "#charge_type")
	private WebElement Pricing_model;

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
	private WebElement Dump_fre_description;

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
	
	public PerFryerCustomerPage(WebDriver driver)
	{
		global = new Global();
		Prop = global.readProperties();
		this.driver = driver;
		login = new Login(driver);
		sa = new SoftAssert();
		PerFryerData = new ReadExcelData(Prop.getProperty("Path2"), "PerFryer");
		PageFactory.initElements(driver, this);
	}


	public void login()
	{
		login.credentials();
		containerClose.click();
	}


	public void goToCustomer()
	{
		global.action(driver).moveToElement(customer).build().perform();
		global.action(driver).moveToElement(Customer).click().build().perform();
		global.wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@id='create_link']")));
	}


	public void checkCustomerURL()
	{
		Customer_URL = driver.getCurrentUrl();
		sa.assertEquals(Customer_URL, PerFryerData.getCellData(1, 0));
		sa.assertAll();
	}


	public void createCustomer()
	{
		Create_Customer.click();
	}


	public void basicInfo()
	{
		KeyContact.sendKeys(PerFryerData.getCellData(1, 1) + " " + PerFryerData.getCellData(1, 2));
		Title.sendKeys(PerFryerData.getCellData(1, 3));
		CompanyName.sendKeys(PerFryerData.getCellData(1, 4));
		NCAChain.sendKeys(PerFryerData.getCellData(1, 5));
		NcaUnitCode.sendKeys((int) PerFryerData.getCellDataInt(1, 6) + "");
		Account.sendKeys((int) PerFryerData.getCellDataInt(1, 7) + "");
		SendServiceSurvey.click();
		SendEIR.click();
		PrimaryEmail.sendKeys(PerFryerData.getCellData(1, 8));
		Site_Street.sendKeys(PerFryerData.getCellData(1, 9));
		Site_City.sendKeys(PerFryerData.getCellData(1, 10));
		Site_State.sendKeys(PerFryerData.getCellData(1, 11));
		Site_PostalCode.sendKeys((int) PerFryerData.getCellDataInt(1, 12) + "");
		Site_Country.sendKeys(PerFryerData.getCellData(1, 13));
		Office_Phone.sendKeys((int) PerFryerData.getCellDataInt(1, 14) + "");
		Ext.sendKeys((int) PerFryerData.getCellDataInt(1, 15) + "");
		ArrivalNotes.sendKeys(PerFryerData.getCellData(1, 16));
		DepartureNotes.sendKeys(PerFryerData.getCellData(1, 17));
		Mobile.sendKeys((int) PerFryerData.getCellDataInt(1, 18) + "");
		Nca_Supplier.sendKeys((int) PerFryerData.getCellDataInt(1, 19) + "");
		InvoiceStreet.sendKeys(PerFryerData.getCellData(1, 20));
		InvoiceCity.sendKeys(PerFryerData.getCellData(1, 21));
		InvoiceState.sendKeys(PerFryerData.getCellData(1, 22));
		InvoicePostal.sendKeys((int)PerFryerData.getCellDataInt(1, 23) + "");
		InvoiceCountry.sendKeys(PerFryerData.getCellData(1, 24));
		global.select(Service_Frequency).selectByVisibleText(PerFryerData.getCellData(1, 25));
	}


	public void closeBrowser()
	{
		driver.close();
	}
}
