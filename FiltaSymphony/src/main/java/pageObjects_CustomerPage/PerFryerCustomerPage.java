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
	public WebElement Create_Customer;

	@FindBy(how = How.CSS, using = "#name")
	public WebElement KeyContact;

	@FindBy(how = How.CSS, using = "#title")
	public WebElement Title;

	@FindBy(how = How.CSS, using = "#company_name")
	public WebElement CompanyName;

	@FindBy(how = How.CSS, using = "#nca_chain")
	public WebElement NCAChain;

	@FindBy(how = How.CSS, using = "#nca_unit_code")
	public WebElement ncaUnitCode;

	@FindBy(how = How.CSS, using = "#account_number")
	public WebElement Account;

	@FindBy(how = How.CSS, using = "#Accounts0emailAddress0")
	public WebElement primaryEmail;

	@FindBy(how = How.CSS, using = "#billing_address_street")
	public WebElement Site_Street;

	@FindBy(how = How.CSS, using = "#billing_address_city")
	public WebElement Site_City;

	@FindBy(how = How.CSS, using = "#billing_address_state")
	public WebElement Site_State;

	@FindBy(how = How.CSS, using = "#billing_address_postalcode")
	public WebElement SIte_PostalCode;

	@FindBy(how = How.CSS, using = "#billing_address_country")
	public WebElement Site_Country;

	@FindBy(how = How.XPATH, using = ".//input[@name='phone_office']")
	public WebElement Office_Phone;

	@FindBy(how = How.CSS, using = "#ext_no")
	public WebElement Ext;

	@FindBy(how = How.CSS, using = "#operations_notes")
	public WebElement ArrivalNotes;

	@FindBy(how = How.CSS, using = "#description")
	public WebElement departure;

	@FindBy(how = How.XPATH, using = ".//input[@name='phone_mobile']")
	public WebElement mobile;

	@FindBy(how = How.CSS, using = "#nca_supplier_number")
	public WebElement nca_supplier;

	@FindBy(how = How.CSS, using = "#shipping_address_street")
	public WebElement invoiceStreet;

	@FindBy(how = How.CSS, using = "#shipping_address_city")
	public WebElement invoicecity;

	@FindBy(how = How.CSS, using = "#shipping_address_state")
	public WebElement invoiceState;

	@FindBy(how = How.CSS, using = "#shipping_address_postalcode")
	public WebElement invoicePostal;

	@FindBy(how = How.CSS, using = "#shipping_address_country")
	public WebElement invoiceCountry;

	@FindBy(how = How.CSS, using = "#survey_frequency")
	public WebElement service_frequency;

	@FindBy(how = How.LINK_TEXT, using = "Pricing & Estimating Info")
	public WebElement Pricing;

	@FindBy(how = How.CSS, using = "#default_pricing")
	public WebElement defaultPricing;

	@FindBy(how = How.CSS, using = "#service_filtafry")
	public WebElement FiltaFry;

	@FindBy(how = How.CSS, using = "#ajaxloading_mask")
	public WebElement lodar;

	@FindBy(how = How.CSS, using = "#charge_type")
	public WebElement pricing_model;

	@FindBy(how = How.CSS, using = "#filtacool")
	public WebElement FiltaCool;

	@FindBy(how = How.CSS, using = "#filtacool_frequency")
	public WebElement FiltaCool_Frequency;

	@FindBy(how = How.CSS, using = "#rental_rate")
	public WebElement RentalRate;

	@FindBy(how = How.CSS, using = "#filtabio")
	public WebElement FiltaBio;

	@FindBy(how = How.CSS, using = "#pay_customer")
	public WebElement PayCustomer;

	@FindBy(how = How.CSS, using = "#service_filtanewoil")
	public WebElement FiltaGold;

	@FindBy(how = How.CSS, using = "#number_of_tanks")
	public WebElement NoOfTank;

	@FindBy(how = How.CSS, using = "#tank_rental")
	public WebElement tankRent;

	@FindBy(how = How.CSS, using = "#oil_charge")
	public WebElement oil_Charge;

	@FindBy(how = How.CSS, using = "#price_per_box")
	public WebElement PriceperBox;

	@FindBy(how = How.CSS, using = "#service_drainfoam")
	public WebElement DrainFoam;

	@FindBy(how = How.CSS, using = "#set_drainfoam")
	public WebElement Charge;

	@FindBy(how = How.CSS, using = "#inv_period")
	public WebElement Inv_Period;

	@FindBy(how = How.XPATH, using = ".//td[@class='edit-table-row1']//label[1]//input[@type='radio' and @id='review_before_sending_inv']")
	public WebElement PerJob_Yes;

	@FindBy(how = How.XPATH, using = ".//td[@class='edit-table-row1']//label[2]//input[@type='radio' and @id='review_before_sending_inv']")
	public WebElement PerJob_No;

	@FindBy(how = How.CSS, using = "#payment_term")
	public WebElement Payement;

	@FindBy(how = How.LINK_TEXT, using = "Marketing & Categories")
	public WebElement Marketing_Categories;

	@FindBy(how = How.XPATH, using = ".//input[@id='type-input']")
	public WebElement TypeMarketing;

	@FindBy(how = How.XPATH, using = ".//li[@data-text='Amusement Park']")
	public WebElement AmusementPark;

	@FindBy(how = How.XPATH, using = ".//li[@data-text='Casinos']")
	public WebElement Casinos;

	@FindBy(how = How.XPATH, using = ".//li[@data-text='A&W Restaurants']")
	public WebElement A_W;

	@FindBy(how = How.CSS, using = "#sub_type")
	public WebElement Sub_Type;

	@FindBy(how = How.CSS, using = "#contract_caterers")
	public WebElement Contract;

	@FindBy(how = How.CSS, using = "#btn_assigned_user_name")
	public WebElement salespersonselect;

	@FindBy(how = How.CSS, using = "#affiliation")
	public WebElement affiliation;

	@FindBy(how = How.XPATH, using = ".//input[@name='chain-input']")
	public WebElement chaininput;

	@FindBy(how = How.CSS, using = "#nca")
	public WebElement NCASelection;

	@FindBy(how = How.CSS, using = "#region_name")
	public WebElement Region;

	@FindBy(how = How.CSS, using = "#btn_territory")
	public WebElement Territory;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Automation_Sales")
	public WebElement Automation_Sales;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Automation")
	public WebElement Automation;

	@FindBy(how = How.LINK_TEXT, using = "Unit Data")
	public WebElement UnitData;

	@FindBy(how = How.CSS, using = "#type_of_oil")
	public WebElement TypeOfOil;

	@FindBy(how = How.CSS, using = "#dump_fre")
	public WebElement QTY;

	@FindBy(how = How.CSS, using = "#waste_oil")
	public WebElement WasteOil;

	@FindBy(how = How.CSS, using = "#rti")
	public WebElement RTI;

	@FindBy(how = How.CSS, using = "#available_service_times")
	public WebElement AvailableServiceTime;

	@FindBy(how = How.CSS, using = "#dump_fre_description")
	public WebElement dump_fre_description;

	@FindBy(how = How.CSS, using = "#waste_oil_renewal_date_trigger")
	public WebElement WasteOilRenewal;

	@FindBy(how = How.LINK_TEXT, using = "Today")
	public WebElement today;

	@FindBy(how = How.CSS, using = "#waste_oil_renewal_date")
	public WebElement Renewaldate;

	@FindBy(how = How.CSS, using = "#rti_renewal_date_trigger")
	public WebElement RTIRenewalDate;

	@FindBy(how = How.CSS, using = "#rti_renewal_date")
	public WebElement RTIDate;

	@FindBy(how = How.XPATH, using = ".//div[@class='buttons']//input[@id='SAVE_HEADER']")
	public WebElement Save;

	@FindBy(how = How.CSS, using = "#customers_fryer_locations_create_button")
	public WebElement locationCreate;

	@FindBy(how = How.XPATH, using = ".//input[@type='text']")
	public WebElement LocationName;

	@FindBy(how = How.XPATH, using = ".//textarea[@name='description']")
	public WebElement LocationDescription;

	@FindBy(how = How.XPATH, using = ".//div[@id='subpanel_customers_fryer_locations_newDiv']//table[@class='dcQuickEdit']//div[@class='action_buttons action-rows']//input[@type='submit' and @id='FR_FryerLocation_subpanel_save_button']")
	public WebElement locationSave;

	@FindBy(how = How.XPATH, using = ".//ul[@id='groupTabs']//li[4]")
	public WebElement Fryers;

	@FindBy(how = How.CSS, using = "#customers_fr_fryers_create_button")
	public WebElement CreateFryer;

	@FindBy(how = How.XPATH, using = ".//input[@name='name']")
	public WebElement Fryer;

	@FindBy(how = How.XPATH, using = ".//input[@name='size']")
	public WebElement FryerSize;

	@FindBy(how = How.XPATH, using = ".//input[@name='sort_order']")
	public WebElement FryerSort;

	@FindBy(how = How.XPATH, using = ".//input[@name='charge']")
	public WebElement FryerCharge;

	@FindBy(how = How.XPATH, using = ".//input[@name='dump_clean_charges']")
	public WebElement FryerCleanOnly;

	@FindBy(how = How.XPATH, using = ".//input[@name='location_name']")
	public WebElement Fryer_Location;

	@FindBy(how = How.XPATH, using = ".//li[text()='Location1']")
	public WebElement LocationNameSelect;

	@FindBy(how = How.XPATH, using = ".//textarea[@id='description']")
	public WebElement FryerDescription;

	@FindBy(how = How.XPATH, using = ".//div[@id='subpanel_customers_fr_fryers_newDiv']//table[@class='dcQuickEdit']//div[@class='action_buttons action-rows']//input[@type='submit' and @id='Fr_Fryers_subpanel_save_button']")
	public WebElement FryerSave;

	@FindBy(how = How.CSS, using = "#btn_location_name")
	public WebElement LocationSelect;

	@FindBy(how = How.LINK_TEXT, using = "Location1")
	public WebElement Locationname;


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


	public void closeBrowser()
	{
		driver.close();
	}
}
