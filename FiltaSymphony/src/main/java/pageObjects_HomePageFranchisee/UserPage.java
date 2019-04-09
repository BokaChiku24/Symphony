package pageObjects_HomePageFranchisee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import helper.UserPage_Interface;
import util.Login;
import util.ReadExcelData;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import util.Global;

public class UserPage implements UserPage_Interface {
	private Global global;
	private WebDriver driver;
	private Properties Prop;
	private Login login;
	private String User_Name;
	private String First_Name;
	private String Last_Name;
	private String Filta_User_Type;
	private String Status;
	private String User_Type;
	private boolean Send_Remainder;
	private String Employee_Status;
	private String Title;
	private String Department;
	private String[] IM_Type;
	private String Default_IM_Type;
	private String Address_Street;
	private String Address_State;
	private String Address_Country;
	private String StandardRate;
	private String Description;
	private boolean Display_Employee_Record;
	private String Work_Phone;
	private String Mobile;
	private String Other_Phone;
	private String Fax;
	private String IM_Name;
	private String Address_City;
	private String AddressPostalZipCodel;
	private String WeeklyStandardHours;
	private String[] WeeklyStandardHoursMin;
	private String DefaultWeeklyStandardHoursMin;
	private String OverTimeRate;
	private String EmailAddress1;
	private boolean PrimaryRadio1;
	private boolean PrimaryReplyTo;
	private String[] EmailClient;
	private String DefaultEmailClient;
	private ReadExcelData UserData;
	private ReadExcelData PasswordData;
	private ReadExcelData ThemeData;
	private ReadExcelData AdvancedData;
	private ReadExcelData LayoutData;
	private ReadExcelData LocalSettingData;
	private String Alert1;
	private String Alert2;

	@FindBy(how = How.XPATH, using = ".//a[@id='user_link_link']")
	private WebElement topText1;

	@FindBy(how = How.XPATH, using = ".//div[@class='moduleTitle']//h2")
	private WebElement getUserName;

	@FindBy(how = How.XPATH, using = ".//input[@id='SAVE_HEADER']")
	private WebElement SaveButtonHeader;

	@FindBy(how = How.XPATH, using = ".//input[@id='CANCEL_HEADER']")
	private WebElement CancelButtonHeader;

	@FindBy(how = How.XPATH, using = ".//input[@id='reset_user_preferences_header']")
	private WebElement ResetUserPreferencesButtonHeader;

	@FindBy(how = How.XPATH, using = ".//input[@id='reset_homepage_header']")
	private WebElement ResetHomePageButtonHeader;

	@FindBy(how = How.XPATH, using = ".//input[@id='SAVE_FOOTER']")
	private WebElement SaveButtonFooter;

	@FindBy(how = How.XPATH, using = ".//input[@id='CANCEL_FOOTER']")
	private WebElement CancelButtonFooter;

	@FindBy(how = How.XPATH, using = ".//input[@id='reset_user_preferences_footer']")
	private WebElement ResetUserPreferencesButtonFooter;

	@FindBy(how = How.XPATH, using = ".//input[@id='reset_homepage_footer']")
	private WebElement ResetHomePageButtonFooter;

	@FindBy(how = How.XPATH, using = ".//input[@id='edit_button']")
	private WebElement EditButton;

	@FindBy(how = How.XPATH, using = ".//a[@id='tab1']//em")
	private WebElement Tab1OnEditPage;

	@FindBy(how = How.XPATH, using = ".//input[@id='user_name']")
	private WebElement editUname;

	@FindBy(how = How.XPATH, using = ".//input[@id='first_name']")
	private WebElement editFirstName;

	@FindBy(how = How.XPATH, using = ".//input[@id='last_name']")
	private WebElement editLastName;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][3]//td[@class='edit-table-row1'][4]")
	private WebElement editFiltaUserType;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][2]//td[@class='edit-table-row1'][2]")
	private WebElement editStatus;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][3]//td[@class='edit-table-row1'][2]")
	private WebElement editUserType;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][5]//td[@class='edit-table-row1'][2]")
	private WebElement editSendRemainder;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][1]//td[@class='edit-table-row1'][2]")
	private WebElement editEmployeeStatus;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][2]//td[@class='edit-table-row1'][2]")
	private WebElement editTitle;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][3]//td[@class='edit-table-row1'][2]")
	private WebElement editDepartment;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][7]//td[@class='edit-table-row1'][2]//input")
	private WebElement editAddressStreet;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][8]//td[@class='edit-table-row1'][2]//input")
	private WebElement editAddressState;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][9]//td[@class='edit-table-row1'][2]//input")
	private WebElement editAddressCountry;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][10]//td[@class='edit-table-row1'][2]//input")
	private WebElement editStandardRate;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][11]//td[@class='edit-table-row1'][2]//textarea")
	private WebElement editDescription;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][1]//td[@class='edit-table-row1'][4]")
	private WebElement editDisplayEmployeeRecord;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][2]//td[@class='edit-table-row1'][4]//input")
	private WebElement editWorkPhone;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][3]//td[@class='edit-table-row1'][4]//input")
	private WebElement editMobile;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][4]//td[@class='edit-table-row1'][4]//input")
	private WebElement editOtherPhone;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][5]//td[@class='edit-table-row1'][4]//input")
	private WebElement editFax;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][6]//td[@class='edit-table-row1'][4]//input")
	private WebElement editIMName;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][7]//td[@class='edit-table-row1'][4]//input")
	private WebElement editAddressCity;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][8]//td[@class='edit-table-row1'][4]//input")
	private WebElement editAddressPostalZipCode;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][9]//td[@class='edit-table-row1'][4]//input")
	private WebElement editWeeklyStandardHours;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][10]//td[@class='edit-table-row1'][4]//input")
	private WebElement editOverTimeRate;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//table[@class='emailaddresses_span']//tr[@id='Users0emailAddressRow0']//input[@id='Users0emailAddress0']")
	private WebElement editEmailAddress1;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//table[@class='emailaddresses_span']//input[@type='radio' and @id='Users0emailAddressPrimaryFlag0']")
	private WebElement editPrimaryRadio;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//table[@class='emailaddresses_span']//input[@type='radio' and @id='Users0emailAddressReplyToFlag0']")
	private WebElement editPrimaryReplyToRadio;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][9]//td[@class='edit-table-row1'][4]//select")
	private WebElement editDefaultMin;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//select[@id='email_link_type']")
	private WebElement editDefaultEmailClient;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//tr[1]//td[2]//span")
	private WebElement UserProfile_Fullname;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//tr[1]//td[4]//span")
	private WebElement UserProfile_Username;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//tr[2]//td[2]")
	private WebElement UserProfile_Status;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//tr[2]//td[4]//span")
	private WebElement UserProfile_UserType;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//tr[3]//td[2]")
	private WebElement UserProfile_FiltaUserType;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//tr[4]//td[2]")
	private WebElement UserProfile_StoreAccess;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//tr[5]//td[2]//input")
	private WebElement UserProfile_SendRemainder;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[1]//td[2]//span")
	private WebElement UserProfile_EmployeeStatus;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[1]//td[4]")
	private WebElement UserProfile_DisplayEmployeeRecord;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[2]//td[2]//span")
	private WebElement UserProfile_Title;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[2]//td[4]")
	private WebElement UserProfile_WorkPhone;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[3]//td[2]")
	private WebElement UserProfile_Department;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[3]//td[4]")
	private WebElement UserProfile_Mobile;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[4]//td[2]//span")
	private WebElement UserProfile_ReportsTo;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[4]//td[4]")
	private WebElement UserProfile_OtherPhone;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[5]//td[4]")
	private WebElement UserProfile_Fax;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[6]//td[2]")
	private WebElement UserProfile_IMType;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][6]//td[@class='edit-table-row1'][2]//select")
	private WebElement editDefaultIMType;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[6]//td[4]//span")
	private WebElement UserProfile_IMName;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[7]//td[2]//span")
	private WebElement UserPRofile_AddressStreet;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[7]//td[4]//span")
	private WebElement UserProfile_AddressCity;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[8]//td[2]//span")
	private WebElement UserProfile_AddressState;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[9]//td[2]//span")
	private WebElement UserProfile_AddressCounty;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[9]//td[4]//span")
	private WebElement UserProfile_WeeklyStandardHours;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[8]//td[4]//span")
	private WebElement UserProfile_AddressPostalZipCode;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[10]//td[2]//span")
	private WebElement UserProfile_StandardRate;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[10]//td[4]//span")
	private WebElement UserProfile_OverTimeRate;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[11]//td[2]//span")
	private WebElement UserPRofile_Description;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//tbody//tr[2]//a")
	private WebElement UserProfile_PrimaryEmail;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//tbody//tr[3]//td[2]")
	private WebElement UserProfile_SugarClient;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//h4")
	private WebElement UserProfile_UserLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//h4")
	private WebElement UserProfile_EmployeeLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//h4")
	private WebElement UserProfile_EmailLabel;

	@FindBy(how = How.XPATH, using = ".//ul[@id='groupTabs']//a")
	private WebElement UserProfile_AllLabel;

	@FindBy(how = How.XPATH, using = ".//a[@id='tab2']//em")
	private WebElement Tab2OnEditPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='generate_password']//h4")
	private WebElement PasswordPage_PasswordLabel;

	@FindBy(how = How.CSS, using = "#generate_password_old_password > table > tbody > tr > td:nth-child(1)")
	private WebElement PasswordPage_CurrentPasswordLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='generate_password']//table[2]//tbody//tr[1]//td[1]")
	private WebElement PasswordPage_NewPasswordLabel;

	@FindBy(how = How.CSS, using = "#generate_password > table > tbody > tr > td > table:nth-child(3) > tbody > tr:nth-child(2) > td:nth-child(1)")
	private WebElement PasswordPage_ConfirmPassword;

	@FindBy(how = How.CSS, using = "#generate_password > table > tbody > tr > td > table:nth-child(3) > tbody > tr:nth-child(3) > td")
	private WebElement PasswordPage_Note;

	@FindBy(how = How.XPATH, using = ".//input[@id='old_password']")
	private WebElement CurrentpasswordInput;

	@FindBy(how = How.XPATH, using = ".//input[@id='new_password']")
	private WebElement NewPasswordInput;

	@FindBy(how = How.XPATH, using = ".//input[@id='confirm_pwd']")
	private WebElement ConfirmPasswordInput;

	@FindBy(how = How.XPATH, using = ".//div[@id='comfirm_pwd_match']")
	private WebElement PasswordValidation;

	@FindBy(how = How.XPATH, using = ".//div[@id='sugarMsgWindow']//div[@id='sugarMsgWindow_h']")
	private WebElement PasswordUpdatedLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='sugarMsgWindow']//div[@class='bd']")
	private WebElement PasswordUpdatedLabel2;

	@FindBy(how = How.XPATH, using = ".//span[@id='error_pwd']")
	private WebElement PasswordErrorMessage;

	@FindBy(how = How.XPATH, using = ".//div[@id='sugarMsgWindow']//a[@class='container-close']")
	private WebElement SugarDashletClose;

	@FindBy(how = How.XPATH, using = ".//a[@id='tab3']")
	private WebElement Tab3OnEditPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='themepicker']//h4")
	private WebElement ThemeLabel;

	@FindBy(how = How.XPATH, using = ".//select[@name='user_theme']")
	private WebElement DefaultTheme;

	@FindBy(how = How.XPATH, using = ".//a[@id='tab4']")
	private WebElement Tab4OnEditPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//h4")
	private WebElement UserSettingLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[2]//td[1]")
	private WebElement ExportDelimiterLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[2]//td[2]//input")
	private WebElement ExportDelimiterlabelTextbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[2]//td[3]")
	private WebElement NotifyOnAssignment;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[2]//td[4]//input")
	private WebElement NotifyOnAssignmentCheckBox;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[1]")
	private WebElement ImportExportLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[2]//select")
	private WebElement DefaultSelectedImportExport;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[3]")
	private WebElement RemainderLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[4]//div[1]//div[1]")
	private WebElement Popup;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[4]//div[1]//input[2]")
	private WebElement DefaultPopupCheckbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[4]//div[2]//input[2]")
	private WebElement DefaultEmailCheckBox;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[4]//div[2]/div[1]")
	private WebElement Email;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[4]//td[1]")
	private WebElement ShowFullName;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[4]//td[2]//input")
	private WebElement DefaultShowFullameCheckbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[4]//td[4]//input")
	private WebElement DefaultMailMergeCheckBox;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//tbody[1]//tr//th//h4")
	private WebElement LayoutOption;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//tbody[1]//tr[@id='use_group_tabs_row']//span")
	private WebElement ModuleMenuLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//tbody[1]//tr[@id='use_group_tabs_row']//input[2]")
	private WebElement ModuleMenuLabelCheckbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//table//tbody//tr[3]//h4")
	private WebElement SelectModule;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//table//tbody//tr[3]//tr[1]//td[2][@id='chooser_display_tabs_text']//nobr")
	private WebElement DisplayModule;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//table//tbody//tr[3]//tr[1]//td[4][@id='chooser_hide_tabs']//nobr")
	private WebElement HideModule;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//table//tbody//tr[4]//td//span")
	private WebElement SubPanelTab;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//table//tbody//tr[4]//td[2]//input")
	private WebElement SubPanelCheckbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[1]//h4//slot")
	private WebElement LocalSetting;

	public UserPage(WebDriver driver) {
		global = new Global();
		Prop = global.readProperties();
		this.driver = driver;
		login = new Login(driver);
		PageFactory.initElements(driver, this);
		UserData = new ReadExcelData(Prop.getProperty("Path1"), "UserProfile");
		PasswordData = new ReadExcelData(Prop.getProperty("Path1"), "Password");
		ThemeData = new ReadExcelData(Prop.getProperty("Path1"), "Theme");
		AdvancedData = new ReadExcelData(Prop.getProperty("Path1"), "Advanced");
		LayoutData = new ReadExcelData(Prop.getProperty("Path1"), "Layout");
		LocalSettingData = new ReadExcelData(Prop.getProperty("Path1"), "Locale Settings");
	}

	public void login() {
		login.credentials();
	}

	public void urlCheck() {
		topText1.click();
		global.wait(driver).until(ExpectedConditions.visibilityOf(getUserName));
		Assert.assertEquals(driver.getCurrentUrl(), Prop.getProperty("UserPageURL"));
	}

	public void buttonCheck() {
		Assert.assertEquals(SaveButtonHeader.getAttribute("value"), Prop.getProperty("UserPageSaveButtonNameHeader"));
		Assert.assertEquals(CancelButtonHeader.getAttribute("value"),
				Prop.getProperty("UserPageCancelButtonNameHeader"));
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getAttribute("value"),
				Prop.getProperty("UserPageResetUserPreferencesButtonHeader"));
		Assert.assertEquals(ResetHomePageButtonHeader.getAttribute("value"),
				Prop.getProperty("UserPageResetHomepageButtonHeader"));
		Assert.assertEquals(SaveButtonFooter.getAttribute("value"), Prop.getProperty("UserPageSaveButtonNameFooter"));
		Assert.assertEquals(CancelButtonFooter.getAttribute("value"),
				Prop.getProperty("UserPageCancelButtonNameFooter"));
		Assert.assertEquals(ResetUserPreferencesButtonFooter.getAttribute("value"),
				Prop.getProperty("UserPageResetUserPreferencesButtonFooter"));
		Assert.assertEquals(ResetHomePageButtonFooter.getAttribute("value"),
				Prop.getProperty("UserPageResetHomepageButtonFooter"));

		CancelButtonHeader.click();
		global.wait(driver).until(ExpectedConditions.visibilityOf(EditButton));
		Assert.assertEquals(EditButton.getAttribute("value"), Prop.getProperty("UserPageEditButton"));
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getAttribute("value"),
				Prop.getProperty("UserPageResetUserPreferencesButtonHeader"));
		Assert.assertEquals(ResetHomePageButtonHeader.getAttribute("value"),
				Prop.getProperty("UserPageResetHomepageButtonHeader"));
	}

	public void buttonBackGroundWithoutMouseOverview() {
		Assert.assertEquals(EditButton.getCssValue("background"),
				Prop.getProperty("UserPageEditButtonBackGroundColorBlue"));
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getCssValue("background"),
				Prop.getProperty("UserPageResetUserPreferencesButtonBackGroundColorBlue"));
		Assert.assertEquals(ResetHomePageButtonHeader.getCssValue("background"),
				Prop.getProperty("UserPageResetHomePageButtonBackGroundColorBlue"));

		// Text Color Assertion
		Assert.assertEquals(EditButton.getCssValue("color"), Prop.getProperty("UserPageEditButtonTextWhite"));
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getCssValue("color"),
				Prop.getProperty("UserPageResetUserPreferencesButtonTextWhite"));
		Assert.assertEquals(ResetHomePageButtonHeader.getCssValue("color"),
				Prop.getProperty("UserPageResetHomePageButtonTextWhite"));

		EditButton.click();
		global.wait(driver).until(ExpectedConditions.visibilityOf(getUserName));
		Assert.assertEquals(SaveButtonHeader.getCssValue("background"),
				Prop.getProperty("UserPageSaveButtonHeaderBackGroundColorBlue"));
		Assert.assertEquals(CancelButtonHeader.getCssValue("background"),
				Prop.getProperty("UserPageCancelButtonHeaderBackGroundColorBlue"));
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getCssValue("background"),
				Prop.getProperty("UserPageResetUserPreferencesButtonHeaderBackGroundColorBlue"));
		Assert.assertEquals(ResetHomePageButtonHeader.getCssValue("background"),
				Prop.getProperty("UserPageResetHomePageButtonHeaderBackGroundColorBlue"));
		Assert.assertEquals(SaveButtonFooter.getCssValue("background"),
				Prop.getProperty("UserPageSaveButtonFooterBackGroundColorBlue"));
		Assert.assertEquals(CancelButtonFooter.getCssValue("background"),
				Prop.getProperty("UserPageCancelButtonFooterBackGroundColorBlue"));
		Assert.assertEquals(ResetUserPreferencesButtonFooter.getCssValue("background"),
				Prop.getProperty("UserPageResetUserPreferencesButtonFooterBackGroundColorBlue"));
		Assert.assertEquals(ResetHomePageButtonFooter.getCssValue("background"),
				Prop.getProperty("UserPageResetHomePageButtonFooterBackGroundColorBlue"));

		// Text Color Assertion
		Assert.assertEquals(SaveButtonHeader.getCssValue("color"),
				Prop.getProperty("UserPageSaveButtonHeaderTextWhite"));
		Assert.assertEquals(CancelButtonHeader.getCssValue("color"),
				Prop.getProperty("UserPageCancelButtonHeaderTextWhite"));
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getCssValue("color"),
				Prop.getProperty("UserPageResetUserPreferencesButtonHeaderTextWhite"));
		Assert.assertEquals(ResetHomePageButtonHeader.getCssValue("color"),
				Prop.getProperty("UserPageResetHomePageButtonHeaderTextWhite"));
		Assert.assertEquals(SaveButtonFooter.getCssValue("color"),
				Prop.getProperty("UserPageSaveButtonFooterTextWhite"));
		Assert.assertEquals(CancelButtonFooter.getCssValue("color"),
				Prop.getProperty("UserPageCancelButtonFooterTextWhite"));
		Assert.assertEquals(ResetUserPreferencesButtonFooter.getCssValue("color"),
				Prop.getProperty("UserPageResetUserPreferencesButtonFooterTextWhite"));
		Assert.assertEquals(ResetHomePageButtonFooter.getCssValue("color"),
				Prop.getProperty("UserPageResetHomePageButtonFooterTextWhite"));
	}

	public void buttonBackGroundWithMouseOverview() {
		global.action(driver).moveToElement(SaveButtonHeader).build().perform();
		Assert.assertEquals(SaveButtonHeader.getCssValue("border-color"),
				Prop.getProperty("UserPageSaveButtonHeaderBackGroundColorGreen"));
		global.action(driver).moveToElement(CancelButtonHeader).build().perform();
		Assert.assertEquals(CancelButtonHeader.getCssValue("border-color"),
				Prop.getProperty("UserPageCancelButtonHeaderBackGroundColorGreen"));
		global.action(driver).moveToElement(ResetUserPreferencesButtonHeader).build().perform();
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getCssValue("border-color"),
				Prop.getProperty("UserPageResetUserPreferencesButtonHeaderBackGroundColorGreen"));
		global.action(driver).moveToElement(ResetHomePageButtonHeader).build().perform();
		Assert.assertEquals(ResetHomePageButtonHeader.getCssValue("border-color"),
				Prop.getProperty("UserPageResetHomePageButtonHeaderBackGroundColorGreen"));
		global.action(driver).moveToElement(SaveButtonFooter).build().perform();
		Assert.assertEquals(SaveButtonFooter.getCssValue("border-color"),
				Prop.getProperty("UserPageSaveButtonFooterBackGroundColorGreen"));
		global.action(driver).moveToElement(CancelButtonFooter).build().perform();
		Assert.assertEquals(CancelButtonFooter.getCssValue("border-color"),
				Prop.getProperty("UserPageCancelButtonFooterBackGroundColorGreen"));
		global.action(driver).moveToElement(ResetUserPreferencesButtonFooter).build().perform();
		Assert.assertEquals(ResetUserPreferencesButtonFooter.getCssValue("border-color"),
				Prop.getProperty("UserPageResetUserPreferencesButtonFooterBackGroundColorGreen"));
		global.action(driver).moveToElement(ResetHomePageButtonFooter).build().perform();
		Assert.assertEquals(ResetHomePageButtonFooter.getCssValue("border-color"),
				Prop.getProperty("UserPageResetHomePageButtonFooterBackGroundColorGreen"));
		CancelButtonFooter.click();
		global.wait(driver).until(ExpectedConditions.visibilityOf(EditButton));
		global.action(driver).moveToElement(EditButton).build().perform();
		Assert.assertEquals(EditButton.getCssValue("border-color"),
				Prop.getProperty("UserPageEditButtonBackGroundColorGreen"));
		global.action(driver).moveToElement(ResetUserPreferencesButtonHeader).build().perform();
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getCssValue("border-color"),
				Prop.getProperty("UserPageResetUserPreferencesButtonBackGroundColorGreen"));
		global.action(driver).moveToElement(ResetHomePageButtonHeader).build().perform();
		Assert.assertEquals(ResetHomePageButtonHeader.getCssValue("border-color"),
				Prop.getProperty("UserPageResetHomePageButtonBackGroundColorGreen"));

	}

	public void buttonToolTipCheck() {
		Assert.assertEquals(EditButton.getAttribute("title"), Prop.getProperty("UserPageEditButtonToolTip"));
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getAttribute("title"),
				Prop.getProperty("UserPageResetUserPreferencesButtonToolTip"));
		Assert.assertEquals(ResetHomePageButtonHeader.getAttribute("title"),
				Prop.getProperty("UserPageResetHomePageButtonToolTip"));
		EditButton.click();
		global.wait(driver).until(ExpectedConditions.visibilityOf(getUserName));
		Assert.assertEquals(SaveButtonHeader.getAttribute("title"),
				Prop.getProperty("UserPageSaveButtonHeaderToolTip"));
		Assert.assertEquals(CancelButtonHeader.getAttribute("title"),
				Prop.getProperty("UserPageCancelButtonHeaderToolTip"));
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getAttribute("title"),
				Prop.getProperty("UserPageResetUserPreferencesButtonHeaderToolTip"));
		Assert.assertEquals(ResetHomePageButtonHeader.getAttribute("title"),
				Prop.getProperty("UserPageResetHomePageButtonHeaderToolTip"));
		Assert.assertEquals(SaveButtonFooter.getAttribute("title"),
				Prop.getProperty("UserPageSaveButtonFooterToolTip"));
		Assert.assertEquals(CancelButtonFooter.getAttribute("title"),
				Prop.getProperty("UserPageCancelButtonFooterToolTip"));
		Assert.assertEquals(ResetUserPreferencesButtonFooter.getAttribute("title"),
				Prop.getProperty("UserPageResetUserPreferencesButtonFooterToolTip"));
		Assert.assertEquals(ResetHomePageButtonFooter.getAttribute("title"),
				Prop.getProperty("UserPageResetHomePageButtonFooterToolTip"));
	}

	public void tabnamesCheck() {
		List<WebElement> list = driver.findElements(By.xpath(".//ul[@class='yui-nav']//li//a//em"));
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }
		for (int i = 0; i < list.size(); i++) {
			Assert.assertEquals(list.get(i).getText(), Prop.getProperty("TabOnEditPage" + i));
			if (list.get(i).getAttribute("class").equals(Prop.getProperty("userPageClass"))) {
				Assert.assertEquals(list.get(i).getCssValue("color"), Prop.getProperty("TabOnUserPageColorBlue"));
			} else if (list.get(i).getAttribute("class").equals("")
					&& list.get(i).getCssValue("color").equals(Prop.getProperty("TabOnUserPageColorGrey2"))) {
				Assert.assertEquals(list.get(i).getCssValue("color"), Prop.getProperty("TabOnUserPageColorGrey2"));
			} else if (list.get(i).getAttribute("class").equals("")
					&& list.get(i).getCssValue("color").equals(Prop.getProperty("TabOnUserPageColorGrey"))) {
				Assert.assertEquals(list.get(i).getCssValue("color"), Prop.getProperty("TabOnUserPageColorGrey"));
			}
			// System.out.println(i + " => " + list.get(i).getCssValue("color"));
		}

		// Count of tabs Assertion
		Assert.assertEquals(list.size(), Integer.parseInt(Prop.getProperty("TabOnEditPageCount")));
		CancelButtonHeader.click();
		global.wait(driver)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//ul[@class='yui-nav']//li")));
		List<WebElement> list2 = driver.findElements(By.xpath(".//ul[@class='yui-nav']//li"));

		for (int i = 0; i < list2.size(); i++) {
			Assert.assertEquals(list2.get(i).getText(), Prop.getProperty("TabOnUserPage" + i));
			if (list2.get(i).getAttribute("class").equals(Prop.getProperty("userPageClass"))) {
				Assert.assertEquals(list2.get(i).getCssValue("color"), Prop.getProperty("TabOnUserPageColorBlue"));
			} else if (list2.get(i).getAttribute("class").equals("")) {
				Assert.assertEquals(list2.get(i).getCssValue("color"), Prop.getProperty("TabOnUserPageColorGrey"));
			}
		}
		Assert.assertEquals(list2.size(), Integer.parseInt(Prop.getProperty("TabOnUserPageCount")));

	}

	public void getDataFromEditPageUserProfile() {
		EditButton.click();
		global.wait(driver).until(ExpectedConditions.visibilityOf(getUserName));

		// To Check Label on User Profile Page
		Assert.assertEquals(UserProfile_UserLabel.getText(), Prop.getProperty("UserProfileLabel1"));
		Assert.assertEquals(UserProfile_UserLabel.getCssValue("color"), Prop.getProperty("UserProfileLabelColor"));
		Assert.assertEquals(UserProfile_EmployeeLabel.getText(), Prop.getProperty("UserProfileLabel2"));
		Assert.assertEquals(UserProfile_EmployeeLabel.getCssValue("color"), Prop.getProperty("UserProfileLabelColor"));
		Assert.assertEquals(UserProfile_EmailLabel.getText(), Prop.getProperty("UserProfileLabel3"));
		Assert.assertEquals(UserProfile_EmailLabel.getCssValue("color"), Prop.getProperty("UserProfileLabelColor"));

		// To Get Data From Edit User Page
		User_Name = editUname.getAttribute("value");
		First_Name = editFirstName.getAttribute("value");
		Last_Name = editLastName.getAttribute("value");
		Filta_User_Type = editFiltaUserType.getText();
		Status = editStatus.getText();
		User_Type = editUserType.getText();
		Send_Remainder = editSendRemainder.isSelected();
		Employee_Status = editEmployeeStatus.getText();
		Title = editTitle.getText();
		Department = editDepartment.getText();
		List<WebElement> list = driver.findElements(By.xpath(
				".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][6]//td[@class='edit-table-row1'][2]//select//option"));
		IM_Type = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			IM_Type[i] = list.get(i).getText();
		}
		Default_IM_Type = global.select(editDefaultIMType).getFirstSelectedOption().getText();
		Address_Street = editAddressStreet.getAttribute("value");
		Address_State = editAddressState.getAttribute("value");
		Address_Country = editAddressCountry.getAttribute("value");
		StandardRate = editStandardRate.getAttribute("value");
		Description = editDescription.getAttribute("value");
		Display_Employee_Record = editDisplayEmployeeRecord.isSelected();
		Work_Phone = editWorkPhone.getAttribute("value");
		Mobile = editMobile.getAttribute("value");
		Other_Phone = editOtherPhone.getAttribute("value");
		Fax = editFax.getAttribute("value");
		IM_Name = editIMName.getAttribute("value");
		Address_City = editAddressCity.getAttribute("value");
		AddressPostalZipCodel = editAddressPostalZipCode.getAttribute("value");
		WeeklyStandardHours = editWeeklyStandardHours.getAttribute("value");
		List<WebElement> list2 = driver.findElements(By.xpath(
				".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][9]//td[@class='edit-table-row1'][4]//select//option"));
		WeeklyStandardHoursMin = new String[list2.size()];
		for (int i = 0; i < list2.size(); i++) {
			WeeklyStandardHoursMin[i] = list2.get(i).getText();
		}
		DefaultWeeklyStandardHoursMin = global.select(editDefaultMin).getFirstSelectedOption().getText();
		OverTimeRate = editOverTimeRate.getAttribute("value");
		EmailAddress1 = editEmailAddress1.getAttribute("value");
		PrimaryRadio1 = editPrimaryRadio.isSelected();
		PrimaryReplyTo = editPrimaryReplyToRadio.isSelected();
		List<WebElement> list3 = driver
				.findElements(By.xpath(".//div[@id='email_options']//select[@id='email_link_type']//option"));
		EmailClient = new String[list3.size()];
		for (int i = 0; i < list3.size(); i++) {
			EmailClient[i] = list3.get(i).getText();
		}
		DefaultEmailClient = global.select(editDefaultEmailClient).getFirstSelectedOption().getText();

		// To Verify Edit Page Data From "UserPage.xlsx" sheet
		Assert.assertEquals(First_Name + " " + Last_Name, UserData.getCellData(1, 0));
		Assert.assertEquals(User_Name, UserData.getCellData(1, 1));
		Assert.assertEquals(Status, UserData.getCellData(1, 2));
		Assert.assertEquals(User_Type.substring(0, 12), UserData.getCellData(1, 3));
		Assert.assertEquals(Filta_User_Type, UserData.getCellData(1, 4));
		Assert.assertEquals(Send_Remainder, false);
		Assert.assertEquals(Employee_Status, UserData.getCellData(1, 5));
		Assert.assertEquals(Display_Employee_Record, false);
		Assert.assertEquals(Title, UserData.getCellData(1, 6));
		Assert.assertEquals(Work_Phone, UserData.getCellData(1, 7));
		Assert.assertEquals(Mobile, UserData.getCellData(1, 8));
		Assert.assertEquals(UserData.getCellData(1, 9), Prop.getProperty("Reports_To"));
		Assert.assertEquals(Other_Phone, UserData.getCellData(1, 10));
		Assert.assertEquals(Fax, UserData.getCellData(1, 11));
		Assert.assertEquals(Default_IM_Type, UserData.getCellData(1, 12));
		Assert.assertEquals(IM_Name, UserData.getCellData(1, 13));
		Assert.assertEquals(Address_Street, UserData.getCellData(1, 14));
		Assert.assertEquals(Address_City, UserData.getCellData(1, 15));
		Assert.assertEquals(Address_State, UserData.getCellData(1, 16));
		Assert.assertEquals(AddressPostalZipCodel, UserData.getCellData(1, 17));
		Assert.assertEquals(Address_Country, UserData.getCellData(1, 18));
		Assert.assertEquals(StandardRate, String.valueOf(UserData.getCellDataInt(1, 19)));
		Assert.assertEquals(OverTimeRate, String.valueOf(UserData.getCellDataInt(1, 20)));
		Assert.assertEquals(Description, UserData.getCellData(1, 21));
		Assert.assertEquals(EmailAddress1, UserData.getCellData(1, 22));
		assertTrue(PrimaryRadio1);
		Assert.assertEquals(PrimaryReplyTo, false);
		Assert.assertEquals(DefaultEmailClient, UserData.getCellData(1, 23));
	}

	public void verifyDataOfUserProfile() {
		CancelButtonHeader.click();
		global.wait(driver).until(ExpectedConditions.visibilityOf(EditButton));

		// To Check Label on User Profile Page
		Assert.assertEquals(UserProfile_UserLabel.getText(), Prop.getProperty("UserProfileLabel1"));
		Assert.assertEquals(UserProfile_UserLabel.getCssValue("color"), Prop.getProperty("UserProfileLabelColor"));
		Assert.assertEquals(UserProfile_EmployeeLabel.getText(), Prop.getProperty("UserProfileLabel2"));
		Assert.assertEquals(UserProfile_EmployeeLabel.getCssValue("color"), Prop.getProperty("UserProfileLabelColor"));
		Assert.assertEquals(UserProfile_EmailLabel.getText(), Prop.getProperty("UserProfileLabel3"));
		Assert.assertEquals(UserProfile_EmailLabel.getCssValue("color"), Prop.getProperty("UserProfileLabelColor"));
		Assert.assertEquals(UserProfile_AllLabel.getText(), Prop.getProperty("UserProfileLabel4"));
		Assert.assertEquals(UserProfile_AllLabel.getCssValue("color"), Prop.getProperty("UserProfileLabelColor"));

		// Verify Data On User profile Page
		Assert.assertEquals(UserProfile_Fullname.getText(), First_Name + " " + Last_Name);
		Assert.assertEquals(UserProfile_Username.getText(), User_Name);
		Assert.assertEquals(UserProfile_Status.getText(), Status);
		Assert.assertTrue(UserProfile_UserType.getText().startsWith(User_Type.substring(0, 12)));
		Assert.assertEquals(UserProfile_FiltaUserType.getText(), Filta_User_Type);
		Assert.assertEquals(UserProfile_StoreAccess.isSelected(),
				Boolean.parseBoolean(Prop.getProperty("StoreAccess")));
		Assert.assertTrue(UserProfile_SendRemainder.isSelected());
		Assert.assertEquals(UserProfile_EmployeeStatus.getText(), Employee_Status);
		Assert.assertEquals(UserProfile_DisplayEmployeeRecord.isSelected(),
				Boolean.parseBoolean("DisplayEmployeeRecords"));
		Assert.assertEquals(UserProfile_Title.getText(), Title);
		Assert.assertEquals(UserProfile_WorkPhone.getText().replace("  ", ""), Work_Phone);
		Assert.assertEquals(UserProfile_Department.getText(), Department);
		Assert.assertEquals(UserProfile_Mobile.getText().replace("  ", ""), Mobile);
		Assert.assertEquals(UserProfile_ReportsTo.getText().replace(" ", ""), Prop.getProperty("Reports_To"));
		Assert.assertEquals(UserProfile_OtherPhone.getText().replace("  ", ""), Other_Phone);
		Assert.assertEquals(UserProfile_Fax.getText().replace("  ", ""), Fax);
		Assert.assertEquals(UserProfile_IMType.getText(), Default_IM_Type);
		Assert.assertEquals(UserProfile_IMName.getText(), IM_Name);
		Assert.assertEquals(UserPRofile_AddressStreet.getText(), Address_Street);
		Assert.assertEquals(UserProfile_AddressCity.getText(), Address_City);
		Assert.assertEquals(UserProfile_AddressState.getText(), Address_State);
		Assert.assertEquals(UserProfile_AddressCounty.getText(), Address_Country);
		Assert.assertEquals(UserProfile_WeeklyStandardHours.getText(),
				WeeklyStandardHours + " : " + DefaultWeeklyStandardHoursMin);
		Assert.assertEquals(UserProfile_AddressPostalZipCode.getText(), AddressPostalZipCodel);
		Assert.assertEquals(UserProfile_StandardRate.getText(), StandardRate);
		Assert.assertEquals(UserProfile_OverTimeRate.getText(), OverTimeRate);
		Assert.assertEquals(UserPRofile_Description.getText(), Description);
		Assert.assertEquals(UserProfile_PrimaryEmail.getText(), EmailAddress1);
		Assert.assertEquals(UserProfile_SugarClient.getText(), DefaultEmailClient);
	}

	public void checkPasswordPage() {
		EditButton.click();
		global.wait(driver).until(ExpectedConditions.visibilityOf(getUserName));

		// Click On Password Tab
		Tab2OnEditPage.click();
		Assert.assertEquals(Tab2OnEditPage.getCssValue("color"), Prop.getProperty("EditPagePasswordColor"));

		// Verify Password Data With The Help Of "UserPage.xlsx" sheet
		Assert.assertEquals(PasswordPage_PasswordLabel.getText(), PasswordData.getCellData(0, 4));
		Assert.assertEquals(PasswordPage_PasswordLabel.getCssValue("color"), PasswordData.getCellData(1, 4));
		Assert.assertEquals(PasswordPage_CurrentPasswordLabel.getText(), PasswordData.getCellData(0, 0));
		Assert.assertEquals(PasswordPage_NewPasswordLabel.getText(), PasswordData.getCellData(0, 1));
		Assert.assertEquals(PasswordPage_ConfirmPassword.getText(), PasswordData.getCellData(0, 2));
		Assert.assertEquals(PasswordPage_Note.getText(),
				PasswordData.getCellData(0, 3) + " " + PasswordData.getCellData(1, 3));

		// verify Alert and Validation Message On Alert
		CurrentpasswordInput.sendKeys(PasswordData.getCellData(0, 1));
		SaveButtonHeader.click();

		// Handling Alert1
		Alert1 = global.alert(driver);
		Assert.assertEquals(Alert1, PasswordData.getCellData(1, 5));
		NewPasswordInput.sendKeys(PasswordData.getCellData(0, 2));
		SaveButtonHeader.click();

		// Handling Alert2
		Alert2 = global.alert(driver);
		Assert.assertEquals(Alert2, PasswordData.getCellData(1, 6));
		SaveButtonHeader.click();
		global.alertAccept(driver);

		// Check Validation Message At Confirmation Message
		ConfirmPasswordInput.sendKeys("KC");
		global.wait(driver)
				.until(ExpectedConditions.textToBePresentInElement(PasswordValidation, "The passwords do not match."));
		Assert.assertEquals(PasswordValidation.getText(), PasswordData.getCellData(2, 2));

		// Clear Text For NewPasswordInput And ConfirmPasswordInput And Pass Valid
		// Password
		NewPasswordInput.clear();
		NewPasswordInput.sendKeys(PasswordData.getCellData(1, 1));
		ConfirmPasswordInput.clear();
		ConfirmPasswordInput.sendKeys(PasswordData.getCellData(1, 2));
		SaveButtonHeader.click();

		Tab2OnEditPage.click();
		global.wait(driver).until(ExpectedConditions.visibilityOf(PasswordErrorMessage));
		Assert.assertEquals(PasswordErrorMessage.getText(),
				PasswordData.getCellData(1, 9) + " " + User_Name + PasswordData.getCellData(1, 10));

		// Check Sugar Dashlet Message

		CurrentpasswordInput.sendKeys(PasswordData.getCellData(1, 0));
		NewPasswordInput.sendKeys(PasswordData.getCellData(1, 1));
		ConfirmPasswordInput.sendKeys(PasswordData.getCellData(1, 2));
		SaveButtonHeader.click();
		global.wait(driver)
				.until(ExpectedConditions.textToBePresentInElement(PasswordUpdatedLabel, "Password Updated"));
		Assert.assertEquals(PasswordUpdatedLabel.getText(), PasswordData.getCellData(1, 7));
		Assert.assertEquals(PasswordUpdatedLabel2.getText(), PasswordData.getCellData(1, 8));
		SugarDashletClose.click();
	}

	public void checkThemesPage() {
		EditButton.click();
		global.wait(driver).until(ExpectedConditions.visibilityOf(getUserName));
		Tab3OnEditPage.click();
		Assert.assertEquals(Tab3OnEditPage.getCssValue("color"), Prop.getProperty("EditPageThemeColor"));
		Assert.assertEquals(ThemeLabel.getText(), Prop.getProperty("ThemeLabel"));

		// Check List Of Themes And Count Of Themes
		List<WebElement> list = driver.findElements(By.xpath(".//select[@name='user_theme']//option"));
		for (int i = 0; i < list.size(); i++) {
			Assert.assertEquals(list.get(i).getText(), ThemeData.getCellData(1, i));
		}
		Assert.assertEquals(list.size(), (int) (ThemeData.getCellDataInt(1, 2)));
		Assert.assertEquals(global.select(DefaultTheme).getFirstSelectedOption().getText(),
				ThemeData.getCellData(1, 1));
	}

	public void checkDataFromEditPageAdvanced() {
		Tab4OnEditPage.click();
		Assert.assertEquals(Tab4OnEditPage.getCssValue("color"), Prop.getProperty("EditPageThemeColor"));
		Assert.assertEquals(Tab4OnEditPage.getText(), Prop.getProperty("AdvancedLabel"));
		Assert.assertEquals(UserSettingLabel.getText(), Prop.getProperty("Advanced1"));
		Assert.assertEquals(UserSettingLabel.getCssValue("color"), Prop.getProperty("EdiPageAdvancedColor"));
		Assert.assertEquals(ExportDelimiterLabel.getText().startsWith(AdvancedData.getCellData(0, 0)), true);
		Assert.assertEquals(ExportDelimiterlabelTextbox.getAttribute("value"), AdvancedData.getCellData(2, 0));
		Assert.assertEquals(NotifyOnAssignment.getText().startsWith(AdvancedData.getCellData(0, 3)), true);
		Assert.assertTrue(NotifyOnAssignmentCheckBox.isSelected());
		Assert.assertTrue(ImportExportLabel.getText().startsWith(AdvancedData.getCellData(0, 1)));
		Assert.assertEquals(global.select(DefaultSelectedImportExport).getFirstSelectedOption().getText(),
				AdvancedData.getCellData(2, 1));
		List<WebElement> list = driver.findElements(By.xpath(".//div[@id='settings']//tr[3]//td[2]//select//option"));
		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i).getText());
			Assert.assertEquals(list.get(i).getText(), AdvancedData.getCellData(i, 6));
		}
		Assert.assertEquals(list.size(), Integer.parseInt(Prop.getProperty("CharachterSetCount")));
		Assert.assertEquals(RemainderLabel.getText().startsWith(AdvancedData.getCellData(0, 4)), true);
		Assert.assertEquals(Popup.getText(), AdvancedData.getCellData(1, 4));
		Assert.assertEquals(DefaultPopupCheckbox.isSelected(), false);
		Assert.assertEquals(DefaultEmailCheckBox.isSelected(), false);
		Assert.assertEquals(Email.getText(), AdvancedData.getCellData(2, 4));
		Assert.assertEquals(ShowFullName.getText().startsWith(AdvancedData.getCellData(0, 2)), true);
		assertTrue(DefaultShowFullameCheckbox.isSelected());
		Assert.assertEquals(DefaultMailMergeCheckBox.isSelected(), false);
		Assert.assertEquals(LayoutOption.getText(), LayoutData.getCellData(0, 0));
		Assert.assertEquals(LayoutOption.getText(), LayoutData.getCellData(0, 0));
		Assert.assertEquals(LayoutOption.getCssValue("color"), Prop.getProperty("EdiPageAdvancedColor"));
		Assert.assertEquals(ModuleMenuLabel.getText(), LayoutData.getCellData(0, 1));
		assertTrue(ModuleMenuLabelCheckbox.isSelected());
		Assert.assertEquals(SelectModule.getText(), LayoutData.getCellData(0, 6));
		Assert.assertEquals(DisplayModule.getText(), LayoutData.getCellData(0, 3));
		Assert.assertEquals(HideModule.getText(), LayoutData.getCellData(0, 4));

		List<WebElement> list2 = driver
				.findElements(By.xpath(".//div[@id='layout']//table//tbody//tr[3]//tr[2]//td[2]//select//option"));
		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i).getText().length() != 0) {
				System.out.println(list2.get(i).getText());
			}
		}
		Assert.assertEquals(SubPanelTab.getText(), LayoutData.getCellData(0, 5));
		Assert.assertEquals(SubPanelCheckbox.isSelected(), true);
		Assert.assertEquals(LocalSetting.getText(), LocalSettingData.getCellData(0, 0));
	}

	public void closeBrowser() {
		driver.close();
	}
}
