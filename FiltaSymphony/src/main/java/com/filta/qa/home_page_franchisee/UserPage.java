package com.filta.qa.home_page_franchisee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.filta.qa.helper.UserPage_Interface;
import com.filta.qa.util.Global;
import com.filta.qa.util.Login;
import com.filta.qa.util.Logout;
import com.filta.qa.util.ReadExcelData;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserPage implements UserPage_Interface
{
	private WebDriver Driver;
	private Global Global_Obj;
	private Properties Prop;
	private Login Login;
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
	private ReadExcelData CalendarOptionData;
	private ReadExcelData AccessData;
	private List<WebElement> List;
	private List<String> List2; 
	
	private String Alert1;
	private String Alert2;
	private String Number = null;
	private int CountZero;
	private int CountDollar;
	private int CountComma;
	private int CountDecimal;
	private int CountNumber;

	private String ExportDelimiter;
	private String ImportExportCharSet;
	private boolean ShowFullNameValue;
	private boolean NotifyOnAssignmentvalue;
	private String DateFormat;
	private String TimeFormat;
	private String TimeZone;
	private String Currency;
	private int CurrencySignificantDigit;
	private String ThousandsSeparator;
	private String DecimalSymbol;
	private String Name;
	private String PublishAtMyLocationValue;
	private String SearchLocation;
	private String ICalValue;
	private String FirstDayOfWeek;
	private boolean RemainEmailTextbox;
	private boolean RemainderPopupTextbox;
	private boolean MailMergetextBox;
	private String PopupEditPage;
	private String EmailEditPage;
	private Logout Logout;
	private SoftAssert Sa;

	@FindBy(how = How.XPATH, using = ".//a[@class='container-close']")
	private WebElement ContainerClose;

	@FindBy(how = How.XPATH, using = ".//a[@id='user_link_link']")
	private WebElement TopText1;

	@FindBy(how = How.XPATH, using = ".//div[@class='moduleTitle']//h2")
	private WebElement GetUserName;

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
	private WebElement EditUname;

	@FindBy(how = How.XPATH, using = ".//input[@id='first_name']")
	private WebElement EditFirstName;

	@FindBy(how = How.XPATH, using = ".//input[@id='last_name']")
	private WebElement EditLastName;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][3]//td[@class='edit-table-row1'][4]")
	private WebElement EditFiltaUserType;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][2]//td[@class='edit-table-row1'][2]")
	private WebElement EditStatus;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][3]//td[@class='edit-table-row1'][2]")
	private WebElement EditUserType;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][5]//td[@class='edit-table-row1'][2]")
	private WebElement EditSendRemainder;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][1]//td[@class='edit-table-row1'][2]")
	private WebElement EditEmployeeStatus;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][2]//td[@class='edit-table-row1'][2]")
	private WebElement EditTitle;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][3]//td[@class='edit-table-row1'][2]")
	private WebElement EditDepartment;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][7]//td[@class='edit-table-row1'][2]//input")
	private WebElement EditAddressStreet;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][8]//td[@class='edit-table-row1'][2]//input")
	private WebElement EditAddressState;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][9]//td[@class='edit-table-row1'][2]//input")
	private WebElement EditAddressCountry;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][10]//td[@class='edit-table-row1'][2]//input")
	private WebElement EditStandardRate;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][11]//td[@class='edit-table-row1'][2]//textarea")
	private WebElement EditDescription;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][1]//td[@class='edit-table-row1'][4]")
	private WebElement EditDisplayEmployeeRecord;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][2]//td[@class='edit-table-row1'][4]//input")
	private WebElement EditWorkPhone;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][3]//td[@class='edit-table-row1'][4]//input")
	private WebElement EditMobile;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][4]//td[@class='edit-table-row1'][4]//input")
	private WebElement EditOtherPhone;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][5]//td[@class='edit-table-row1'][4]//input")
	private WebElement EditFax;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][6]//td[@class='edit-table-row1'][4]//input")
	private WebElement EditIMName;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][7]//td[@class='edit-table-row1'][4]//input")
	private WebElement EditAddressCity;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][8]//td[@class='edit-table-row1'][4]//input")
	private WebElement EditAddressPostalZipCode;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][9]//td[@class='edit-table-row1'][4]//input")
	private WebElement EditWeeklyStandardHours;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][10]//td[@class='edit-table-row1'][4]//input")
	private WebElement EditOverTimeRate;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//table[@class='emailaddresses_span']//tr[@id='Users0emailAddressRow0']//input[@id='Users0emailAddress0']")
	private WebElement EditEmailAddress1;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//table[@class='emailaddresses_span']//input[@type='radio' and @id='Users0emailAddressPrimaryFlag0']")
	private WebElement EditPrimaryRadio;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//table[@class='emailaddresses_span']//input[@type='radio' and @id='Users0emailAddressReplyToFlag0']")
	private WebElement EditPrimaryReplyToRadio;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][9]//td[@class='edit-table-row1'][4]//select")
	private WebElement EditDefaultMin;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//select[@id='email_link_type']")
	private WebElement EditDefaultEmailClient;

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
	private WebElement EditDefaultIMType;

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

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[2]//td[1]//slot")
	private WebElement DataFormatLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[2]//td[3]//slot")
	private WebElement CurrencyLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[3]//td[1]//slot")
	private WebElement TimeFormatLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[3]//td[3]//slot")
	private WebElement CurrencySignificantDigitsLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[2]//td[2]//select")
	private WebElement DefaultDateFormat;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[2]//td[4]//select")
	private WebElement DefaultCurrency;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[3]//td[2]//select")
	private WebElement DefaultTimeFormat;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[3]//td[4]//select")
	private WebElement DefaultCurrencySignificantDigits;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[4]//td[1]//slot")
	private WebElement TimeZoneLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[4]//td[3]//slot")
	private WebElement ExampleLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[4]//td[4]//slot//input")
	private WebElement ExampleTextbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[5]//td[3]//slot")
	private WebElement SeparatorLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[5]//td[4]//slot//input")
	private WebElement SepratorTextbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[6]//td[1]")
	private WebElement NameDisplayFormatLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[6]//td[3]//slot")
	private WebElement DecimalSymbolLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[6]//td[4]//slot//input")
	private WebElement DecimalSymbolTextbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//h4")
	private WebElement CalendarOptionLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[2]//td[1]//slot")
	private WebElement PublishKeyLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[2]//td[2]//slot//input")
	private WebElement PublishKeyTextbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[3]//td[1]//slot")
	private WebElement PublishAtMyLocation;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[3]//td[2]//slot")
	private WebElement PublishAtMyLocationText;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[4]//td[1]//slot")
	private WebElement SearchLocationLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[4]//td[2]//slot")
	private WebElement SearchLocationText;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[5]//td[1]//slot")
	private WebElement ICalintegrationURLLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[5]//td[2]//slot")
	private WebElement ICalintegrationText;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[6]//td[1]//slot")
	private WebElement FirstDayOfWeekLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[6]//td[2]//slot//select")
	private WebElement DefaultFirstdayOfWeek;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[4]//td[2]//select")
	private WebElement DefaultTimeZone;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[6]//td[2]//select")
	private WebElement DefaultName;

	@FindBy(how = How.XPATH, using = ".//div[@id='user_detailview_tabs']//ul[1]//li[2]")
	private WebElement AdvancedTab;

	@FindBy(how = How.XPATH, using = ".//div[@id='user_detailview_tabs']//ul[1]//li[2]//em")
	private WebElement AdvancedTabLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//h4//slot")
	private WebElement UserSettingUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[2]//td[1]//slot")
	private WebElement NotifyOnAssignmentUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[2]//td[2]//slot")
	private WebElement NotifyOnAssignmentValueUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[2]//td[3]//slot")
	private WebElement NotifyOnAssignmentTextUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[1]//slot")
	private WebElement RemainderUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[2]//slot//div[1]//input")
	private WebElement PopupCheckBoxUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[2]//slot//div[2]//input")
	private WebElement EmailCheckBoxUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[2]//slot//div[1]")
	private WebElement PopupUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[2]//slot//div[2]")
	private WebElement EmailUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[3]//slot")
	private WebElement RemainderText;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[4]//td[1]//slot")
	private WebElement MailMergeuserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[4]//td[2]//slot//input")
	private WebElement MailMergeUserPageCheckBox;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[4]//td[3]//slot")
	private WebElement MailMergeTextUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[5]//td[1]//slot")
	private WebElement URLUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[5]//td[2]//slot")
	private WebElement URLUserPage2;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[5]//td[3]//slot")
	private WebElement URLUserPage3;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[6]//td[1]//slot")
	private WebElement ExportDelimiterUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[6]//td[2]//slot")
	private WebElement ExportDelimiterTextboxUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[6]//td[3]//slot")
	private WebElement ExportDelimiterText;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[7]//td[1]//slot")
	private WebElement ImportExportUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[7]//td[2]//slot")
	private WebElement ImportExportText;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[7]//td[3]//slot")
	private WebElement ImportExportTextUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[8]//td[1]//slot")
	private WebElement ShowFullNamesTextUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[8]//td[2]//slot//input")
	private WebElement ShowFullNameTextBox;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[8]//td[3]//slot")
	private WebElement ShowFullNameUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//h4//slot")
	private WebElement LocaleUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[2]//td[1]//slot")
	private WebElement DataFormatUserPageLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[2]//td[2]//slot")
	private WebElement DataFormatText;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[2]//td[3]//slot")
	private WebElement DataFormatTextUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[3]//td[1]//slot")
	private WebElement TimeFormatUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[3]//td[2]//slot")
	private WebElement TimeFormatValueUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[3]//td[3]//slot")
	private WebElement TimeFormatText;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[4]//td[1]//slot")
	private WebElement TimeZoneUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[4]//td[2]//slot")
	private WebElement TimeZoneValueUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[5]//td[1]//slot")
	private WebElement CurrencyUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[5]//td[2]//slot")
	private WebElement CurrencyValueUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[5]//td[3]//slot")
	private WebElement CurrencyText;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[6]//td[1]//slot")
	private WebElement CurrencyDigitUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[6]//td[2]//slot")
	private WebElement CurrencyDigitValueUserpage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[6]//td[3]//slot")
	private WebElement CurrencyDigitTextUserpage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[7]//td[1]//slot")
	private WebElement ThousandsUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[7]//td[2]//slot")
	private WebElement ThousandsValueUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[7]//td[3]//slot")
	private WebElement ThousandsTextValueUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[8]//td[1]//slot")
	private WebElement DecimalUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[8]//td[2]//slot")
	private WebElement DecilamlValueUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[8]//td[3]")
	private WebElement DeciamlTextUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[1]//slot")
	private WebElement NameDisplayUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[2]//slot//i[1]")
	private WebElement NameDisplayValueOneUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[2]//slot//i[2]")
	private WebElement NameDisplayValueSecondUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[2]//slot//i[3]")
	private WebElement NameDisplayValueThirdUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[2]//slot//i[4]")
	private WebElement NameDisplayValueForthUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[2]//slot//i[5]")
	private WebElement NameDisplayValueFifthUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[2]//slot//i[6]")
	private WebElement NameDisplayValueSixthUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[3]")
	private WebElement NameDisplayTextUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//h4//slot")
	private WebElement CalendarOption;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[2]//td[1]//slot")
	private WebElement Publish_Key;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[2]//td[2]//slot")
	private WebElement Publish_Key_Text;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[3]//td[1]//slot")
	private WebElement Publish_at_my_location;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[3]//td[2]//slot")
	private WebElement Publish_at_my_location_text;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[4]//td[1]//slot")
	private WebElement Search_Location;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[4]//td[2]//slot")
	private WebElement Search_Location_Text;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[5]//td[1]//slot")
	private WebElement ICal;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[5]//td[2]//slot")
	private WebElement ICal_Text;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[6]//td[1]//slot")
	private WebElement First_Day_Of_Week;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[6]//td[2]//slot")
	private WebElement First_Day_Of_Week_Text;

	@FindBy(how = How.XPATH, using = ".//div[@id='edit_tabs']//h4//slot")
	private WebElement Layout_Option;

	@FindBy(how = How.XPATH, using = ".//div[@id='edit_tabs']//tr[2]//td[1]//slot")
	private WebElement Module_Menu_Filter;

	@FindBy(how = How.XPATH, using = ".//div[@id='edit_tabs']//tr[2]//td[2]//slot")
	private WebElement Module_Menu_Filter_Checkbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='edit_tabs']//tr[2]//td[3]//slot")
	private WebElement Module_Menu_Filter_text;

	@FindBy(how = How.XPATH, using = ".//div[@id='edit_tabs']//tr[3]//td[1]//slot")
	private WebElement SubPanel_Tab;

	@FindBy(how = How.XPATH, using = ".//div[@id='edit_tabs']//tr[3]//td[2]//slot")
	private WebElement SubPanel_Tab_Checkbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='edit_tabs']//tr[3]//td[3]//slot")
	private WebElement SubPanel_Tab_Text;

	@FindBy(how = How.XPATH, using = ".//li[@id='All_sp_tab']//a")
	private WebElement All;

	@FindBy(how = How.XPATH, using = ".//div[@id='user_detailview_tabs']//ul[@class='yui-nav']//li[3]//a")
	private WebElement Access;

	@FindBy(how = How.XPATH, using = ".//div[@class='table-responsive-edit']//table//tbody//tr[2]//td[2]")
	private WebElement EnabledColor;

	@FindBy(how = How.XPATH, using = ".//div[@class='table-responsive-edit']//table//tbody//tr[2]//td[3]")
	private WebElement NoneColor;

	@FindBy(how = How.XPATH, using = ".//div[@class='table-responsive-edit']//table//tbody//tr[3]//td[3]")
	private WebElement AllColor;

	@FindBy(how = How.XPATH, using = ".//div[@class='table-responsive-edit']//table//tbody//tr[6]//td[3]")
	private WebElement OwnerColor;

	@FindBy(how = How.XPATH, using = ".//div[@id='subpanel_title_aclroles']//table//tbody//h3/span[1]")
	private WebElement Roles;

	@FindBy(how = How.XPATH, using = ".//div[@class='detail-table-overflow']//table//tr[2]//th[1]//a")
	private WebElement Roles_Name;

	@FindBy(how = How.XPATH, using = ".//div[@class='detail-table-overflow']//table//tr[2]//th[2]//span")
	private WebElement Roles_Description;

	@FindBy(how = How.XPATH, using = ".//div[@class='detail-table-overflow']//table//tr[3]//td[1]//span")
	private WebElement Roles_Franchisee;

	@FindBy(how = How.XPATH, using = ".//div[@class='detail-table-overflow']//table//tr[3]//td[2]//span")
	private WebElement Roles_Not_Delete;

	@FindBy(how = How.XPATH, using = ".//ul[@id='groupTabs']//li//a")
	private WebElement Roles_ALL;


	public UserPage(WebDriver Driver)
	{
		Global_Obj = new Global();
		Prop = Global_Obj.readProperties();
		this.Driver = Driver;
		Login = new Login(Driver);
		Logout = new Logout(Driver);
		Sa = new SoftAssert();
		PageFactory.initElements(Driver, this);
		UserData = new ReadExcelData(Prop.getProperty("Path1"), "UserProfile");
		PasswordData = new ReadExcelData(Prop.getProperty("Path1"), "Password");
		ThemeData = new ReadExcelData(Prop.getProperty("Path1"), "Theme");
		AdvancedData = new ReadExcelData(Prop.getProperty("Path1"), "Advanced");
		LayoutData = new ReadExcelData(Prop.getProperty("Path1"), "Layout");
		LocalSettingData = new ReadExcelData(Prop.getProperty("Path1"), "Locale Settings");
		CalendarOptionData = new ReadExcelData(Prop.getProperty("Path1"), "Calrendar");
		AccessData = new ReadExcelData(Prop.getProperty("Path1"), "Access");
	}


	public void login()
	{
		Login.credentials();
	}


	public void urlCheck()
	{
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(ContainerClose));
		ContainerClose.click();
		TopText1.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(GetUserName));
		Assert.assertEquals(Driver.getCurrentUrl(), Prop.getProperty("UserPageURL"));
//		Sa.assertAll();
	}


	public void buttonCheck()
	{
		Assert.assertEquals(SaveButtonHeader.getAttribute("value"), Prop.getProperty("UserPageSaveButtonNameHeader"));
		Assert.assertEquals(CancelButtonHeader.getAttribute("value"), Prop.getProperty("UserPageCancelButtonNameHeader"));
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getAttribute("value"),
				Prop.getProperty("UserPageResetUserPreferencesButtonHeader"));
		Assert.assertEquals(ResetHomePageButtonHeader.getAttribute("value"),
				Prop.getProperty("UserPageResetHomepageButtonHeader"));
		Assert.assertEquals(SaveButtonFooter.getAttribute("value"), Prop.getProperty("UserPageSaveButtonNameFooter"));
		Assert.assertEquals(CancelButtonFooter.getAttribute("value"), Prop.getProperty("UserPageCancelButtonNameFooter"));
		Assert.assertEquals(ResetUserPreferencesButtonFooter.getAttribute("value"),
				Prop.getProperty("UserPageResetUserPreferencesButtonFooter"));
		Assert.assertEquals(ResetHomePageButtonFooter.getAttribute("value"),
				Prop.getProperty("UserPageResetHomepageButtonFooter"));
		CancelButtonHeader.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(EditButton));
		Assert.assertEquals(EditButton.getAttribute("value"), Prop.getProperty("UserPageEditButton"));
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getAttribute("value"),
				Prop.getProperty("UserPageResetUserPreferencesButtonHeader"));
		Assert.assertEquals(ResetHomePageButtonHeader.getAttribute("value"),
				Prop.getProperty("UserPageResetHomepageButtonHeader"));
//		sa.assertAll();
	}


	public void buttonBackGroundWithoutMouseOverview()
	{
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
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(GetUserName));
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
		Assert.assertEquals(SaveButtonHeader.getCssValue("color"), Prop.getProperty("UserPageSaveButtonHeaderTextWhite"));
		Assert.assertEquals(CancelButtonHeader.getCssValue("color"),
				Prop.getProperty("UserPageCancelButtonHeaderTextWhite"));
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getCssValue("color"),
				Prop.getProperty("UserPageResetUserPreferencesButtonHeaderTextWhite"));
		Assert.assertEquals(ResetHomePageButtonHeader.getCssValue("color"),
				Prop.getProperty("UserPageResetHomePageButtonHeaderTextWhite"));
		Assert.assertEquals(SaveButtonFooter.getCssValue("color"), Prop.getProperty("UserPageSaveButtonFooterTextWhite"));
		Assert.assertEquals(CancelButtonFooter.getCssValue("color"),
				Prop.getProperty("UserPageCancelButtonFooterTextWhite"));
		Assert.assertEquals(ResetUserPreferencesButtonFooter.getCssValue("color"),
				Prop.getProperty("UserPageResetUserPreferencesButtonFooterTextWhite"));
		Assert.assertEquals(ResetHomePageButtonFooter.getCssValue("color"),
				Prop.getProperty("UserPageResetHomePageButtonFooterTextWhite"));
//		Sa.assertAll();
	}


	public void buttonBackGroundWithMouseOverview()
	{
		Global_Obj.action(Driver).moveToElement(SaveButtonHeader).build().perform();
		Assert.assertEquals(SaveButtonHeader.getCssValue("border-color"),
				Prop.getProperty("UserPageSaveButtonHeaderBackGroundColorGreen"));
		Global_Obj.action(Driver).moveToElement(CancelButtonHeader).build().perform();
		Assert.assertEquals(CancelButtonHeader.getCssValue("border-color"),
				Prop.getProperty("UserPageCancelButtonHeaderBackGroundColorGreen"));
		Global_Obj.action(Driver).moveToElement(ResetUserPreferencesButtonHeader).build().perform();
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getCssValue("border-color"),
				Prop.getProperty("UserPageResetUserPreferencesButtonHeaderBackGroundColorGreen"));
		Global_Obj.action(Driver).moveToElement(ResetHomePageButtonHeader).build().perform();
		Assert.assertEquals(ResetHomePageButtonHeader.getCssValue("border-color"),
				Prop.getProperty("UserPageResetHomePageButtonHeaderBackGroundColorGreen"));
		Global_Obj.action(Driver).moveToElement(SaveButtonFooter).build().perform();
		Assert.assertEquals(SaveButtonFooter.getCssValue("border-color"),
				Prop.getProperty("UserPageSaveButtonFooterBackGroundColorGreen"));
		Global_Obj.action(Driver).moveToElement(CancelButtonFooter).build().perform();
		Assert.assertEquals(CancelButtonFooter.getCssValue("border-color"),
				Prop.getProperty("UserPageCancelButtonFooterBackGroundColorGreen"));
		Global_Obj.action(Driver).moveToElement(ResetUserPreferencesButtonFooter).build().perform();
		Assert.assertEquals(ResetUserPreferencesButtonFooter.getCssValue("border-color"),
				Prop.getProperty("UserPageResetUserPreferencesButtonFooterBackGroundColorGreen"));
		Global_Obj.action(Driver).moveToElement(ResetHomePageButtonFooter).build().perform();
		Assert.assertEquals(ResetHomePageButtonFooter.getCssValue("border-color"),
				Prop.getProperty("UserPageResetHomePageButtonFooterBackGroundColorGreen"));
		CancelButtonFooter.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(EditButton));
		Global_Obj.action(Driver).moveToElement(EditButton).build().perform();
		Assert.assertEquals(EditButton.getCssValue("border-color"),
				Prop.getProperty("UserPageEditButtonBackGroundColorGreen"));
		Global_Obj.action(Driver).moveToElement(ResetUserPreferencesButtonHeader).build().perform();
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getCssValue("border-color"),
				Prop.getProperty("UserPageResetUserPreferencesButtonBackGroundColorGreen"));
		Global_Obj.action(Driver).moveToElement(ResetHomePageButtonHeader).build().perform();
		Assert.assertEquals(ResetHomePageButtonHeader.getCssValue("border-color"),
				Prop.getProperty("UserPageResetHomePageButtonBackGroundColorGreen"));
//		Sa.assertAll();
	}


	public void buttonToolTipCheck()
	{
		Assert.assertEquals(EditButton.getAttribute("title"), Prop.getProperty("UserPageEditButtonToolTip"));
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getAttribute("title"),
				Prop.getProperty("UserPageResetUserPreferencesButtonToolTip"));
		Assert.assertEquals(ResetHomePageButtonHeader.getAttribute("title"),
				Prop.getProperty("UserPageResetHomePageButtonToolTip"));
		EditButton.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(GetUserName));
		Assert.assertEquals(SaveButtonHeader.getAttribute("title"), Prop.getProperty("UserPageSaveButtonHeaderToolTip"));
		Assert.assertEquals(CancelButtonHeader.getAttribute("title"),
				Prop.getProperty("UserPageCancelButtonHeaderToolTip"));
		Assert.assertEquals(ResetUserPreferencesButtonHeader.getAttribute("title"),
				Prop.getProperty("UserPageResetUserPreferencesButtonHeaderToolTip"));
		Assert.assertEquals(ResetHomePageButtonHeader.getAttribute("title"),
				Prop.getProperty("UserPageResetHomePageButtonHeaderToolTip"));
		Assert.assertEquals(SaveButtonFooter.getAttribute("title"), Prop.getProperty("UserPageSaveButtonFooterToolTip"));
		Assert.assertEquals(CancelButtonFooter.getAttribute("title"),
				Prop.getProperty("UserPageCancelButtonFooterToolTip"));
		Assert.assertEquals(ResetUserPreferencesButtonFooter.getAttribute("title"),
				Prop.getProperty("UserPageResetUserPreferencesButtonFooterToolTip"));
		Assert.assertEquals(ResetHomePageButtonFooter.getAttribute("title"),
				Prop.getProperty("UserPageResetHomePageButtonFooterToolTip"));
//		Sa.assertAll();
	}


	public void tabnamesCheck()
	{
		List = Driver.findElements(By.xpath(".//ul[@class='yui-nav']//li//a//em"));
		for (int i = 0; i < List.size(); i++)
		{
			if (i == 2)
			{
				break;
			}
//			System.out.println(list.get(i).getText());
		}
		for (int i = 0; i < List.size(); i++)
		{
			if (i == 2)
			{
				break;
			}
			else
			{
//				System.out.println(list.get(i).getText());
//				System.out.println(Prop.getProperty("TabOnEditPage" + i));
				Assert.assertEquals(List.get(i).getText(), Prop.getProperty("TabOnEditPage" + i));
			}
		}
		// Count of tabs Assertion
		CancelButtonHeader.click();
		Global_Obj.wait(Driver).until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath(".//ul[@class='yui-nav']//li[1]//em")));
		List = Driver.findElements(By.xpath(".//ul[@class='yui-nav']//li//em"));
		for (int i = 0; i < List.size(); i++)
		{
			if (i == 1)
			{
				break;
			}
			else
			{
				Assert.assertEquals(List.get(i).getText(), Prop.getProperty("TabOnUserPage" + i));

			}
		}
	}
	
	public void getDataFromEditPageUserProfile()
	{
		EditButton.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(GetUserName));
		// To Check Label on User Profile Page
		Assert.assertEquals(UserProfile_UserLabel.getText(), Prop.getProperty("UserProfileLabel1"));
		Assert.assertEquals(UserProfile_UserLabel.getCssValue("color"), Prop.getProperty("UserProfileLabelColor"));
		Assert.assertEquals(UserProfile_EmployeeLabel.getText(), Prop.getProperty("UserProfileLabel2"));
		Assert.assertEquals(UserProfile_EmployeeLabel.getCssValue("color"), Prop.getProperty("UserProfileLabelColor"));
		Assert.assertEquals(UserProfile_EmailLabel.getText(), Prop.getProperty("UserProfileLabel3"));
		Assert.assertEquals(UserProfile_EmailLabel.getCssValue("color"), Prop.getProperty("UserProfileLabelColor"));
		// To Get Data From Edit User Page
		User_Name = EditUname.getAttribute("value");
		First_Name = EditFirstName.getAttribute("value");
		Last_Name = EditLastName.getAttribute("value");
		Filta_User_Type = EditFiltaUserType.getText();
		Status = EditStatus.getText();
		User_Type = EditUserType.getText();
		Send_Remainder = EditSendRemainder.isSelected();
		Employee_Status = EditEmployeeStatus.getText();
		Title = EditTitle.getText();
		Department = EditDepartment.getText();
		List = Driver.findElements(By.xpath(
				".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][6]//td[@class='edit-table-row1'][2]//select//option"));
		IM_Type = new String[List.size()];
		for (int i = 0; i < List.size(); i++)
		{
			IM_Type[i] = List.get(i).getText();
		}
		Default_IM_Type = Global_Obj.select(EditDefaultIMType).getFirstSelectedOption().getText();
		Address_Street = EditAddressStreet.getAttribute("value");
		Address_State = EditAddressState.getAttribute("value");
		Address_Country = EditAddressCountry.getAttribute("value");
		StandardRate = EditStandardRate.getAttribute("value");
		Description = EditDescription.getAttribute("value");
		Display_Employee_Record = EditDisplayEmployeeRecord.isSelected();
		Work_Phone = EditWorkPhone.getAttribute("value");
		Mobile = EditMobile.getAttribute("value");
		Other_Phone = EditOtherPhone.getAttribute("value");
		Fax = EditFax.getAttribute("value");
		IM_Name = EditIMName.getAttribute("value");
		Address_City = EditAddressCity.getAttribute("value");
		AddressPostalZipCodel = EditAddressPostalZipCode.getAttribute("value");
		WeeklyStandardHours = EditWeeklyStandardHours.getAttribute("value");
		List = Driver.findElements(By.xpath(
				".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][9]//td[@class='edit-table-row1'][4]//select//option"));
		WeeklyStandardHoursMin = new String[List.size()];
		for (int i = 0; i < List.size(); i++)
		{
			WeeklyStandardHoursMin[i] = List.get(i).getText();
		}
		DefaultWeeklyStandardHoursMin = Global_Obj.select(EditDefaultMin).getFirstSelectedOption().getText();
		OverTimeRate = EditOverTimeRate.getAttribute("value");
		EmailAddress1 = EditEmailAddress1.getAttribute("value");
		PrimaryRadio1 = EditPrimaryRadio.isSelected();
		PrimaryReplyTo = EditPrimaryReplyToRadio.isSelected();
		List = Driver
				.findElements(By.xpath(".//div[@id='email_options']//select[@id='email_link_type']//option"));
		EmailClient = new String[List.size()];
		for (int i = 0; i < List.size(); i++)
		{
			EmailClient[i] = List.get(i).getText();
		}
		DefaultEmailClient = Global_Obj.select(EditDefaultEmailClient).getFirstSelectedOption().getText();
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
		Assert.assertTrue(PrimaryRadio1);
		Assert.assertEquals(PrimaryReplyTo, false);

	}


	public void verifyDataOfUserProfile()
	{
		CancelButtonHeader.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(EditButton));
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
		Assert.assertEquals(UserProfile_StoreAccess.isSelected(), Boolean.parseBoolean(Prop.getProperty("StoreAccess")));
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
	}


	public void checkPasswordPage()
	{
		EditButton.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(GetUserName));
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
		Alert1 = Global_Obj.alert(Driver);
		Assert.assertEquals(Alert1, PasswordData.getCellData(1, 5));
		NewPasswordInput.sendKeys(PasswordData.getCellData(0, 2));
		SaveButtonHeader.click();
		// Handling Alert2
		Alert2 = Global_Obj.alert(Driver);
		Assert.assertEquals(Alert2, PasswordData.getCellData(1, 6));
		SaveButtonHeader.click();
		Global_Obj.alertAccept(Driver);
		// Check Validation Message At Confirmation Message
		ConfirmPasswordInput.sendKeys("KC");
		Global_Obj.wait(Driver).until(
				ExpectedConditions.textToBePresentInElement(PasswordValidation, "The passwords do not match."));
		Assert.assertEquals(PasswordValidation.getText(), PasswordData.getCellData(2, 2));
		// Clear Text For NewPasswordInput And ConfirmPasswordInput And Pass Valid
		// Password
		NewPasswordInput.clear();
		NewPasswordInput.sendKeys(PasswordData.getCellData(1, 1));
		ConfirmPasswordInput.clear();
		ConfirmPasswordInput.sendKeys(PasswordData.getCellData(1, 2));
		SaveButtonHeader.click();
		Tab2OnEditPage.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(PasswordErrorMessage));
		Assert.assertEquals(PasswordErrorMessage.getText(),
				PasswordData.getCellData(1, 9) + " " + User_Name + PasswordData.getCellData(1, 10));
		// Check Sugar Dashlet Message
		CurrentpasswordInput.sendKeys(PasswordData.getCellData(1, 0));
		NewPasswordInput.sendKeys(PasswordData.getCellData(1, 1));
		ConfirmPasswordInput.sendKeys(PasswordData.getCellData(1, 2));
		SaveButtonHeader.click();
		Global_Obj.wait(Driver)
				.until(ExpectedConditions.textToBePresentInElement(PasswordUpdatedLabel, "Password Updated"));
		Assert.assertEquals(PasswordUpdatedLabel.getText(), PasswordData.getCellData(1, 7));
		Assert.assertEquals(PasswordUpdatedLabel2.getText(), PasswordData.getCellData(1, 8));
//		Sa.assertAll();
		SugarDashletClose.click();
	}


	public void checkThemesPage()
	{
		EditButton.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(GetUserName));
		Tab3OnEditPage.click();
		Assert.assertEquals(Tab3OnEditPage.getCssValue("color"), Prop.getProperty("EditPageThemeColor"));
		Assert.assertEquals(ThemeLabel.getText(), Prop.getProperty("ThemeLabel"));
		// Check List Of Themes And Count Of Themes
		List = Driver.findElements(By.xpath(".//select[@name='user_theme']//option"));
		for (int i = 0; i < List.size(); i++)
		{
			Assert.assertEquals(List.get(i).getText(), ThemeData.getCellData(1, i));
		}
		Assert.assertEquals(List.size(), (int) (ThemeData.getCellDataInt(1, 2)));
		Assert.assertEquals(Global_Obj.select(DefaultTheme).getFirstSelectedOption().getText(), ThemeData.getCellData(1, 1));
//		Sa.assertAll();
	}


	public void checkDataFromEditPageAdvanced()
	{
		Tab4OnEditPage.click();
		Assert.assertEquals(Tab4OnEditPage.getCssValue("color"), Prop.getProperty("EditPageThemeColor"));
		Assert.assertEquals(Tab4OnEditPage.getText(), Prop.getProperty("AdvancedLabel"));
		Assert.assertEquals(UserSettingLabel.getText(), Prop.getProperty("Advanced1"));
		Assert.assertEquals(UserSettingLabel.getCssValue("color"), Prop.getProperty("EdiPageAdvancedColor"));
		Assert.assertEquals(ExportDelimiterLabel.getText().startsWith(AdvancedData.getCellData(0, 0)), true);
		ExportDelimiter = ExportDelimiterlabelTextbox.getAttribute("value");
		Assert.assertEquals(ExportDelimiter, AdvancedData.getCellData(2, 0));
		Assert.assertEquals(NotifyOnAssignment.getText().startsWith(AdvancedData.getCellData(0, 3)), true);
		NotifyOnAssignmentvalue = NotifyOnAssignmentCheckBox.isSelected();
		Assert.assertTrue(NotifyOnAssignmentvalue);
		Assert.assertTrue(ImportExportLabel.getText().startsWith(AdvancedData.getCellData(0, 1)));
		ImportExportCharSet = Global_Obj.select(DefaultSelectedImportExport).getFirstSelectedOption().getText();
		Assert.assertEquals(ImportExportCharSet, AdvancedData.getCellData(2, 1));
		List = Driver.findElements(By.xpath(".//div[@id='settings']//tr[3]//td[2]//select//option"));
		for (int i = 0; i < List.size(); i++)
		{
			// System.out.println(list.get(i).getText());
			Assert.assertEquals(List.get(i).getText(), AdvancedData.getCellData(i, 6));
		}
		Assert.assertEquals(List.size(), Integer.parseInt(Prop.getProperty("CharachterSetCount")));
		Assert.assertEquals(RemainderLabel.getText().startsWith(AdvancedData.getCellData(0, 4)), true);
		PopupEditPage = Popup.getText();
		Assert.assertEquals(PopupEditPage, AdvancedData.getCellData(1, 4));
		RemainEmailTextbox = DefaultEmailCheckBox.isSelected();
		RemainderPopupTextbox = DefaultPopupCheckbox.isSelected();
		Assert.assertEquals(RemainderPopupTextbox, false);
		Assert.assertEquals(RemainEmailTextbox, false);
		EmailEditPage = Email.getText();
		Assert.assertEquals(EmailEditPage, AdvancedData.getCellData(2, 4));
		Assert.assertEquals(ShowFullName.getText().startsWith(AdvancedData.getCellData(0, 2)), true);
		ShowFullNameValue = DefaultShowFullameCheckbox.isSelected();
		Assert.assertTrue(ShowFullNameValue);
		MailMergetextBox = DefaultMailMergeCheckBox.isSelected();
		Assert.assertEquals(MailMergetextBox, false);
		Assert.assertEquals(LayoutOption.getText(), LayoutData.getCellData(0, 0));
		Assert.assertEquals(LayoutOption.getText(), LayoutData.getCellData(0, 0));
		Assert.assertEquals(LayoutOption.getCssValue("color"), Prop.getProperty("EdiPageAdvancedColor"));
		Assert.assertEquals(ModuleMenuLabel.getText(), LayoutData.getCellData(0, 1));
		Assert.assertTrue(ModuleMenuLabelCheckbox.isSelected());
		Assert.assertEquals(SelectModule.getText(), LayoutData.getCellData(0, 6));
		Assert.assertEquals(DisplayModule.getText(), LayoutData.getCellData(0, 3));
		Assert.assertEquals(HideModule.getText(), LayoutData.getCellData(0, 4));
		List = Driver
				.findElements(By.xpath(".//div[@id='layout']//table//tbody//tr[3]//tr[2]//td[2]//select//option"));
		List<String> list3 = new ArrayList<String>();
		for (int i = 0; i < List.size(); i++)
		{
			if (List.get(i).getText().length() != 0)
			{
				// System.out.println(List.get(i).getText());
				list3.add(List.get(i).getText());
			}
		}
//		for (int i = 0; i < List.size(); i++) {
//			System.out.println(List.get(i));
//		}
		List2 = new ArrayList<String>();
		List2.add("Home");
		List2.add("Customers");
		List2.add("Contacts");
		List2.add("Leads");
		List2.add("Calendar");
		List2.add("Documents");
		List2.add("Emails");
		List2.add("Calls");
		List2.add("Tech App");
		List2.add("Accounts");
		List2.add("Site-Evaluations");
		List2.add("Tasks");
		List2.add("Notes");
		List2.add("FIM Accounts");
		List2.add("Targets");
		List2.add("Collections");
		List2.add("Collectors");
		List2.add("Franchisee");
		List2.add("Jacobsen");
		List2.add("FiltaBio Reported Volumes");
		List2.add("Routes");
		List2.add("Invoices");
		List2.add("Reports");
		List2.add("Timesheets");
		List2.add("Worksheets");
		List2.add("Oil Transfers");
		List2.add("Routes");
		List2.add("Coolers");
		List2.add("Vans");
		List2.add("Tanks");
		List2.add("Invoice Settings");
		List2.add("Jobs");
		List2.add("Fryers");
		List2.add("Schedule Infos");
		List2.add("Postal/Zip Code");
		List2.add("Territory");
		List2.add("FiltaFry Invoices");
		List2.add("Machines");
		List2.add("FiltaCool Panels");
		List2.add("Archive Reports");
		List2.add("NCA Outgoing Payments");
		List2.add("Discount & Rebate");
		List2.add("QB Invoices");
		List2.add("Allocate Unapplied Payments");
		List2.add("Invoices");
		List2.add("NCA Payments");
		List2.add("Franchisee Credit-Debit");
		List2.add("Franchisee Payments");
		List2.add("QB Invoice Line Items");
		List2.add("NCA Group");
		List2.add("Rebate Payments");
		List2.add("NCA Chain");
		List2.add("Unapplied Payments");
		List2.add("WO Storage Location");
		List2.add("Advertisement Spends");
		List2.add("Knowledge Base");
		List2.add("Buyers");
		Assert.assertTrue((list3.containsAll(List2)));
		Assert.assertEquals(SubPanelTab.getText(), LayoutData.getCellData(0, 5));
		Assert.assertEquals(SubPanelCheckbox.isSelected(), true);
		Assert.assertEquals(LocalSetting.getText(), LocalSettingData.getCellData(0, 0));
		Assert.assertEquals(DataFormatLabel.getText(), LocalSettingData.getCellData(0, 1));
		List = Driver
				.findElements(By.xpath(".//div[@id='locale']//tbody//tr[2]//td[2]//select//option"));
		DateFormat = Global_Obj.select(DefaultDateFormat).getFirstSelectedOption().getText();
		Assert.assertEquals("\"" + DateFormat + "\"", LocalSettingData.getCellData(5, 1));
		for (int i = 0; i < List.size(); i++)
		{
//			System.out.println(List.get(i).getText());
			Assert.assertEquals("\"" + List.get(i).getText() + "\"", LocalSettingData.getCellData(i + 1, 1));
		}
		Assert.assertEquals(CurrencyLabel.getText(), LocalSettingData.getCellData(0, 2));
		List = Driver
				.findElements(By.xpath(".//div[@id='locale']//tbody//tr[2]//td[4]//select//option"));
		Currency = Global_Obj.select(DefaultCurrency).getFirstSelectedOption().getText();
		Assert.assertEquals(Currency, LocalSettingData.getCellData(1, 2));
		for (int i = 0; i < List.size(); i++)
		{
//			System.out.println(list6.get(i).getText());
			Assert.assertEquals(List.get(i).getText(), LocalSettingData.getCellData(i + 1, 2));

		}
		Assert.assertEquals(TimeFormatLabel.getText(), LocalSettingData.getCellData(0, 3));
		List = Driver
				.findElements(By.xpath(".//div[@id='locale']//tbody//tr[3]//td[2]//select//option"));

		List2 = new ArrayList<String>();
		for (int i = 0; i < List.size(); i++)
		{
			if (List.get(i).getText().length() != 0)
			{
//				System.out.println(List.get(i).getText());
				List2.add(List.get(i).getText());
			}

		}
		List2 = new ArrayList<String>();
		List2.add("23:00");
		List2.add("11:00pm");
		List2.add("11:00PM");
		List2.add("11:00 pm");
		List2.add("11:00 PM");
		List2.add("23.00");
		List2.add("11.00pm");
		List2.add("11.00PM");
		List2.add("11.00 pm");
		List2.add("11.00 PM");
		TimeFormat = Global_Obj.select(DefaultTimeFormat).getFirstSelectedOption().getText();
		Assert.assertEquals(TimeFormat, List2.get(0));
		Assert.assertTrue(List2.containsAll(List2));
		Assert.assertEquals(CurrencySignificantDigitsLabel.getText(), LocalSettingData.getCellData(0, 4));

		List = Driver
				.findElements(By.xpath(".//div[@id='locale']//tbody//tr[3]//td[4]//select//option"));
		for (int i = 0; i < List.size(); i++)
		{
			Assert.assertEquals(Integer.parseInt(List.get(i).getText()),
					(int) LocalSettingData.getCellDataInt(i + 1, 4));
		}
		CurrencySignificantDigit = Integer
				.parseInt(Global_Obj.select(DefaultCurrencySignificantDigits).getFirstSelectedOption().getText());
		Assert.assertEquals(CurrencySignificantDigit, (int) LocalSettingData.getCellDataInt(3, 4));

		Assert.assertEquals(TimeZoneLabel.getText(), LocalSettingData.getCellData(0, 5));
//		List = driver
//				.findElements(By.xpath(".//div[@id='locale']//tbody//tr[4]//td[2]//select//option"));
		TimeZone = Global_Obj.select(DefaultTimeZone).getFirstSelectedOption().getText();
		Assert.assertEquals(TimeZone, LocalSettingData.getCellData(327 + 1, 5));
//		for (int i = 0; i < List.size(); i++)
//		{
//		System.out.println(List.get(i).getText());
//			Assert.assertEquals(List.get(i).getText(), LocalSettingData.getCellData(i + 1, 5));
//		}
		Assert.assertEquals(ExampleLabel.getText(), LocalSettingData.getCellData(0, 6));
		Assert.assertEquals(ExampleTextbox.isEnabled(), false);
		if (Integer.parseInt(Global_Obj.select(DefaultCurrencySignificantDigits).getFirstSelectedOption().getText()) == 2)
		{
//			System.out.println(ExampleTextbox.getAttribute("value"));
			Number = ExampleTextbox.getAttribute("value");
			CountZero = 0;
			CountDollar = 0;
			CountComma = 0;
			CountDecimal = 0;
			CountNumber = 0;
			for (int i = 0; i < Number.length(); i++)
			{
				if (Number.charAt(i) == '0')
				{
					CountZero++;
				}
				if (Number.charAt(i) == '$')
				{
					CountDollar++;
				}
				if (Number.charAt(i) == ',')
				{
					CountComma++;
				}
				if (Number.charAt(i) == '.')
				{
					CountDecimal++;
				}
				if (Number.charAt(i) == '1' || Number.charAt(i) == '2' || Number.charAt(i) == '3'
						|| Number.charAt(i) == '4' || Number.charAt(i) == '5' || Number.charAt(i) == '6'
						|| Number.charAt(i) == '7' || Number.charAt(i) == '8' || Number.charAt(i) == '9')
				{
					CountNumber++;
				}
			}
			Assert.assertEquals(CountZero, Integer
					.parseInt(Global_Obj.select(DefaultCurrencySignificantDigits).getFirstSelectedOption().getText()));
			Assert.assertEquals(CountDollar, (int) LocalSettingData.getCellDataInt(1, 7));
			Assert.assertEquals(CountComma, (int) LocalSettingData.getCellDataInt(1, 8));
			Assert.assertEquals(CountDecimal, (int) LocalSettingData.getCellDataInt(2, 9));
			Assert.assertEquals(CountNumber, (int) LocalSettingData.getCellDataInt(1, 10));
		}
		Global_Obj.select(DefaultCurrencySignificantDigits).selectByVisibleText("0");
		if (Integer.parseInt(Global_Obj.select(DefaultCurrencySignificantDigits).getFirstSelectedOption().getText()) == 0)
		{
			Number = ExampleTextbox.getAttribute("value");
			CountZero = 0;
			CountDollar = 0;
			CountComma = 0;
			CountDecimal = 0;
			CountNumber = 0;
			for (int i = 0; i < Number.length(); i++)
			{
				if (Number.charAt(i) == '0')
				{
					CountZero++;
				}
				if (Number.charAt(i) == '$')
				{
					CountDollar++;
				}
				if (Number.charAt(i) == ',')
				{
					CountComma++;
				}
				if (Number.charAt(i) == '.')
				{
					CountDecimal++;
				}
				if (Number.charAt(i) == '1' || Number.charAt(i) == '2' || Number.charAt(i) == '3'
						|| Number.charAt(i) == '4' || Number.charAt(i) == '5' || Number.charAt(i) == '6'
						|| Number.charAt(i) == '7' || Number.charAt(i) == '8' || Number.charAt(i) == '9')
				{
					CountNumber++;
				}
			}
			Assert.assertEquals(CountZero, Integer
					.parseInt(Global_Obj.select(DefaultCurrencySignificantDigits).getFirstSelectedOption().getText()));
			Assert.assertEquals(CountDollar, (int) LocalSettingData.getCellDataInt(1, 7));
			Assert.assertEquals(CountComma, (int) LocalSettingData.getCellDataInt(1, 8));
			Assert.assertEquals(CountDecimal, (int) LocalSettingData.getCellDataInt(1, 9));
			Assert.assertEquals(CountNumber, (int) LocalSettingData.getCellDataInt(1, 10));

		}
		Global_Obj.select(DefaultCurrencySignificantDigits).selectByVisibleText("1");
		if (Integer.parseInt(Global_Obj.select(DefaultCurrencySignificantDigits).getFirstSelectedOption().getText()) == 1)
		{
			Number = ExampleTextbox.getAttribute("value");
			CountZero = 0;
			CountDollar = 0;
			CountComma = 0;
			CountDecimal = 0;
			CountNumber = 0;
			for (int i = 0; i < Number.length(); i++)
			{
				if (Number.charAt(i) == '0')
				{
					CountZero++;
				}
				if (Number.charAt(i) == '$')
				{
					CountDollar++;
				}
				if (Number.charAt(i) == ',')
				{
					CountComma++;
				}
				if (Number.charAt(i) == '.')
				{
					CountDecimal++;
				}
				if (Number.charAt(i) == '1' || Number.charAt(i) == '2' || Number.charAt(i) == '3'
						|| Number.charAt(i) == '4' || Number.charAt(i) == '5' || Number.charAt(i) == '6'
						|| Number.charAt(i) == '7' || Number.charAt(i) == '8' || Number.charAt(i) == '9')
				{
					CountNumber++;
				}
			}
			Assert.assertEquals(CountZero, Integer
					.parseInt(Global_Obj.select(DefaultCurrencySignificantDigits).getFirstSelectedOption().getText()));
			Assert.assertEquals(CountDollar, (int) LocalSettingData.getCellDataInt(1, 7));
			Assert.assertEquals(CountComma, (int) LocalSettingData.getCellDataInt(1, 8));
			Assert.assertEquals(CountDecimal, (int) LocalSettingData.getCellDataInt(2, 9));
			Assert.assertEquals(CountNumber, (int) LocalSettingData.getCellDataInt(1, 10));
		}
		Global_Obj.select(DefaultCurrencySignificantDigits).selectByVisibleText("3");
		if (Integer.parseInt(Global_Obj.select(DefaultCurrencySignificantDigits).getFirstSelectedOption().getText()) == 3)
		{
			Number = ExampleTextbox.getAttribute("value");
			CountZero = 0;
			CountDollar = 0;
			CountComma = 0;
			CountDecimal = 0;
			CountNumber = 0;
			for (int i = 0; i < Number.length(); i++)
			{
				if (Number.charAt(i) == '0')
				{
					CountZero++;
				}
				if (Number.charAt(i) == '$')
				{
					CountDollar++;
				}
				if (Number.charAt(i) == ',')
				{
					CountComma++;
				}
				if (Number.charAt(i) == '.')
				{
					CountDecimal++;
				}
				if (Number.charAt(i) == '1' || Number.charAt(i) == '2' || Number.charAt(i) == '3'
						|| Number.charAt(i) == '4' || Number.charAt(i) == '5' || Number.charAt(i) == '6'
						|| Number.charAt(i) == '7' || Number.charAt(i) == '8' || Number.charAt(i) == '9')
				{
					CountNumber++;
				}
			}
			Assert.assertEquals(CountZero, Integer
					.parseInt(Global_Obj.select(DefaultCurrencySignificantDigits).getFirstSelectedOption().getText()));
			Assert.assertEquals(CountDollar, (int) LocalSettingData.getCellDataInt(1, 7));
			Assert.assertEquals(CountComma, (int) LocalSettingData.getCellDataInt(1, 8));
			Assert.assertEquals(CountDecimal, (int) LocalSettingData.getCellDataInt(2, 9));
			Assert.assertEquals(CountNumber, (int) LocalSettingData.getCellDataInt(1, 10));
		}
		Global_Obj.select(DefaultCurrencySignificantDigits).selectByVisibleText("4");
		if (Integer.parseInt(Global_Obj.select(DefaultCurrencySignificantDigits).getFirstSelectedOption().getText()) == 4)
		{
			Number = ExampleTextbox.getAttribute("value");
			CountZero = 0;
			CountDollar = 0;
			CountComma = 0;
			CountDecimal = 0;
			CountNumber = 0;
			for (int i = 0; i < Number.length(); i++)
			{
				if (Number.charAt(i) == '0')
				{
					CountZero++;
				}
				if (Number.charAt(i) == '$')
				{
					CountDollar++;
				}
				if (Number.charAt(i) == ',')
				{
					CountComma++;
				}
				if (Number.charAt(i) == '.')
				{
					CountDecimal++;
				}
				if (Number.charAt(i) == '1' || Number.charAt(i) == '2' || Number.charAt(i) == '3'
						|| Number.charAt(i) == '4' || Number.charAt(i) == '5' || Number.charAt(i) == '6'
						|| Number.charAt(i) == '7' || Number.charAt(i) == '8' || Number.charAt(i) == '9')
				{
					CountNumber++;
				}
			}
			Assert.assertEquals(CountZero, Integer
					.parseInt(Global_Obj.select(DefaultCurrencySignificantDigits).getFirstSelectedOption().getText()));
			Assert.assertEquals(CountDollar, (int) LocalSettingData.getCellDataInt(1, 7));
			Assert.assertEquals(CountComma, (int) LocalSettingData.getCellDataInt(1, 8));
			Assert.assertEquals(CountDecimal, (int) LocalSettingData.getCellDataInt(2, 9));
			Assert.assertEquals(CountNumber, (int) LocalSettingData.getCellDataInt(1, 10));
		}
		Global_Obj.select(DefaultCurrencySignificantDigits).selectByVisibleText("5");
		if (Integer.parseInt(Global_Obj.select(DefaultCurrencySignificantDigits).getFirstSelectedOption().getText()) == 5)
		{
			Number = ExampleTextbox.getAttribute("value");
			CountZero = 0;
			CountDollar = 0;
			CountComma = 0;
			CountDecimal = 0;
			CountNumber = 0;
			for (int i = 0; i < Number.length(); i++)
			{
				if (Number.charAt(i) == '0')
				{
					CountZero++;
				}
				if (Number.charAt(i) == '$')
				{
					CountDollar++;
				}
				if (Number.charAt(i) == ',')
				{
					CountComma++;
				}
				if (Number.charAt(i) == '.')
				{
					CountDecimal++;
				}
				if (Number.charAt(i) == '1' || Number.charAt(i) == '2' || Number.charAt(i) == '3'
						|| Number.charAt(i) == '4' || Number.charAt(i) == '5' || Number.charAt(i) == '6'
						|| Number.charAt(i) == '7' || Number.charAt(i) == '8' || Number.charAt(i) == '9')
				{
					CountNumber++;
				}
			}
			Assert.assertEquals(CountZero, Integer
					.parseInt(Global_Obj.select(DefaultCurrencySignificantDigits).getFirstSelectedOption().getText()));
			Assert.assertEquals(CountDollar, (int) LocalSettingData.getCellDataInt(1, 7));
			Assert.assertEquals(CountComma, (int) LocalSettingData.getCellDataInt(1, 8));
			Assert.assertEquals(CountDecimal, (int) LocalSettingData.getCellDataInt(2, 9));
			Assert.assertEquals(CountNumber, (int) LocalSettingData.getCellDataInt(1, 10));
		}
		Global_Obj.select(DefaultCurrencySignificantDigits).selectByVisibleText("6");
		if (Integer.parseInt(Global_Obj.select(DefaultCurrencySignificantDigits).getFirstSelectedOption().getText()) == 6)
		{
			Number = ExampleTextbox.getAttribute("value");
			CountZero = 0;
			CountDollar = 0;
			CountComma = 0;
			CountDecimal = 0;
			CountNumber = 0;
			for (int i = 0; i < Number.length(); i++)
			{
				if (Number.charAt(i) == '0')
				{
					CountZero++;
				}
				if (Number.charAt(i) == '$')
				{
					CountDollar++;
				}
				if (Number.charAt(i) == ',')
				{
					CountComma++;
				}
				if (Number.charAt(i) == '.')
				{
					CountDecimal++;
				}
				if (Number.charAt(i) == '1' || Number.charAt(i) == '2' || Number.charAt(i) == '3'
						|| Number.charAt(i) == '4' || Number.charAt(i) == '5' || Number.charAt(i) == '6'
						|| Number.charAt(i) == '7' || Number.charAt(i) == '8' || Number.charAt(i) == '9')
				{
					CountNumber++;
				}
			}
			Assert.assertEquals(CountZero, Integer
					.parseInt(Global_Obj.select(DefaultCurrencySignificantDigits).getFirstSelectedOption().getText()));
			Assert.assertEquals(CountDollar, (int) LocalSettingData.getCellDataInt(1, 7));
			Assert.assertEquals(CountComma, (int) LocalSettingData.getCellDataInt(1, 8));
			Assert.assertEquals(CountDecimal, (int) LocalSettingData.getCellDataInt(2, 9));
			Assert.assertEquals(CountNumber, (int) LocalSettingData.getCellDataInt(1, 10));
		}
		Assert.assertEquals(SeparatorLabel.getText(), LocalSettingData.getCellData(0, 11));
		ThousandsSeparator = SepratorTextbox.getAttribute("value");
		Assert.assertEquals(ThousandsSeparator, LocalSettingData.getCellData(1, 11));
		Assert.assertEquals(NameDisplayFormatLabel.getText(), LocalSettingData.getCellData(0, 12) + " ");
		List = Driver
				.findElements(By.xpath(".//div[@id='locale']//tbody//tr[6]//td[2]//select//option"));
		Name = Global_Obj.select(DefaultName).getFirstSelectedOption().getText();
		Assert.assertEquals(Name, LocalSettingData.getCellData(1, 13));
		for (int i = 0; i < List.size(); i++)
		{
//			System.out.println(List.get(i).getText());
			Assert.assertEquals(List.get(i).getText(), LocalSettingData.getCellData(i + 1, 13));
		}
		Assert.assertEquals(DecimalSymbolLabel.getText(), LocalSettingData.getCellData(0, 14));
		DecimalSymbol = DecimalSymbolTextbox.getAttribute("value");
		Assert.assertEquals(DecimalSymbol, LocalSettingData.getCellData(1, 14));
		Assert.assertEquals(CalendarOptionLabel.getText(), CalendarOptionData.getCellData(0, 0));
		Assert.assertEquals(CalendarOptionLabel.getCssValue("color"), CalendarOptionData.getCellData(1, 0));
		Assert.assertEquals(PublishKeyLabel.getText(), CalendarOptionData.getCellData(0, 1));
		Assert.assertEquals(PublishKeyTextbox.getText().isEmpty(), true);
		PublishAtMyLocationValue = PublishAtMyLocation.getText();
		Assert.assertEquals(PublishAtMyLocationValue, CalendarOptionData.getCellData(0, 2));
		if (!PublishAtMyLocationText.getText().contains("&email="))
		{
			Assert.assertEquals(PublishAtMyLocationText.getText(), CalendarOptionData.getCellData(1, 2) + EmailAddress1);
		}
		else if (PublishAtMyLocationText.getText().contains("&email="))
		{
			Assert.assertEquals(PublishAtMyLocationText.getText(), CalendarOptionData.getCellData(2, 2) + EmailAddress1);
		}
		Assert.assertEquals(SearchLocationLabel.getText(), CalendarOptionData.getCellData(0, 3));
		SearchLocation = SearchLocationText.getText();
		Assert.assertEquals(SearchLocation, CalendarOptionData.getCellData(1, 3));
		Assert.assertEquals(ICalintegrationURLLabel.getText(), CalendarOptionData.getCellData(0, 4));
		ICalValue = ICalintegrationText.getText();
		Assert.assertEquals(ICalValue, CalendarOptionData.getCellData(1, 4));
		Assert.assertEquals(FirstDayOfWeekLabel.getText(), CalendarOptionData.getCellData(0, 5));
		List = Driver
				.findElements(By.xpath(".//div[@id='calendar_options']//tr[6]//td[2]//slot//select//option"));
		for (int i = 0; i < List.size(); i++)
		{
//			System.out.println(list13.get(i).getText());
			Assert.assertEquals(List.get(i).getText(), CalendarOptionData.getCellData(i + 1, 5));
		}
		FirstDayOfWeek = Global_Obj.select(DefaultFirstdayOfWeek).getFirstSelectedOption().getText();
		Assert.assertEquals(FirstDayOfWeek, CalendarOptionData.getCellData(1, 5));
		Global_Obj.jsReturn(Driver).executeScript("arguments[0].scrollIntoView();", CancelButtonFooter);
		CancelButtonFooter.click();
//		Sa.assertAll();
	}


	public void verifyDataOfAdvanced()
	{
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(EditButton));
		AdvancedTab.click();
		Assert.assertEquals(AdvancedTabLabel.getText(), AdvancedData.getCellData(0, 7));
		Assert.assertEquals(AdvancedTabLabel.getCssValue("color"), AdvancedData.getCellData(1, 7));
		Assert.assertEquals(UserSettingUserPage.getText(), AdvancedData.getCellData(0, 8));
		Assert.assertEquals(UserSettingUserPage.getCssValue("color"), AdvancedData.getCellData(1, 8));
		Assert.assertEquals(NotifyOnAssignmentUserPage.getText(), AdvancedData.getCellData(0, 9));
//		Assert.assertEquals(NotifyOnAssignmentValueUserPage.isSelected(), NotifyOnAssignmentvalue);
		Assert.assertEquals(NotifyOnAssignmentTextUserPage.getText(), AdvancedData.getCellData(1, 9) + " ");
		Assert.assertEquals(RemainderUserPage.getText(), AdvancedData.getCellData(0, 10));
		Assert.assertEquals(PopupCheckBoxUserPage.isSelected(), RemainderPopupTextbox);
		Assert.assertEquals(PopupCheckBoxUserPage.isEnabled(), false);
		Assert.assertEquals(EmailCheckBoxUserPage.isSelected(), RemainEmailTextbox);
		Assert.assertEquals(EmailCheckBoxUserPage.isEnabled(), false);
		Assert.assertEquals(PopupUserPage.getText(), PopupEditPage);
		Assert.assertEquals(EmailUserPage.getText(), EmailEditPage);
		Assert.assertEquals(RemainderText.getText(), AdvancedData.getCellData(3, 4) + " ");
		Assert.assertEquals(MailMergeuserPage.getText(), AdvancedData.getCellData(0, 5));
		Assert.assertEquals(MailMergeUserPageCheckBox.isSelected(), MailMergetextBox);
		Assert.assertEquals(MailMergeUserPageCheckBox.isEnabled(), false);
		Assert.assertEquals(MailMergeTextUserPage.getText(), AdvancedData.getCellData(1, 5) + " ");
		Assert.assertEquals(URLUserPage.getText(), AdvancedData.getCellData(0, 11));
		Assert.assertEquals(URLUserPage2.getText(), AdvancedData.getCellData(1, 11));
		Assert.assertEquals(URLUserPage3.getText(), AdvancedData.getCellData(2, 11) + " ");
		Assert.assertEquals(ExportDelimiterUserPage.getText(), AdvancedData.getCellData(0, 0));
		Assert.assertEquals(ExportDelimiterTextboxUserPage.getText(), ExportDelimiter);
		Assert.assertEquals(ExportDelimiterText.getText(), AdvancedData.getCellData(1, 0));
		Assert.assertEquals(ImportExportUserPage.getText(), AdvancedData.getCellData(0, 1));
		Assert.assertEquals(ImportExportText.getText(), AdvancedData.getCellData(2, 1));
		Assert.assertEquals(ImportExportTextUserPage.getText(), AdvancedData.getCellData(1, 1));
		Assert.assertEquals(ShowFullNamesTextUserPage.getText(), AdvancedData.getCellData(0, 2));
		Assert.assertEquals(ShowFullNameTextBox.isEnabled(), false);
		Assert.assertEquals(ShowFullNameUserPage.getText(), AdvancedData.getCellData(1, 2));

		Assert.assertEquals(LocaleUserPage.getText(), LocalSettingData.getCellData(0, 0));
		Assert.assertEquals(LocaleUserPage.getCssValue("color"), LocalSettingData.getCellData(1, 0));
		Assert.assertEquals(DataFormatUserPageLabel.getText(), LocalSettingData.getCellData(0, 1));
		Assert.assertEquals(DataFormatTextUserPage.getText(), LocalSettingData.getCellData(10, 1) + " ");
		Assert.assertEquals(TimeFormatUserPage.getText(), LocalSettingData.getCellData(0, 3));
		Assert.assertEquals(TimeFormatValueUserPage.getText(), TimeFormat + " ");
		Assert.assertEquals(TimeFormatText.getText(), LocalSettingData.getCellData(11, 3) + " ");
		Assert.assertEquals(TimeZoneUserPage.getText(), LocalSettingData.getCellData(0, 5));
		Assert.assertEquals(TimeZoneValueUserPage.getText(), LocalSettingData.getCellData(327 + 1, 5) + " ");
		Assert.assertEquals(CurrencyUserPage.getText(), LocalSettingData.getCellData(0, 2));
		Assert.assertEquals(CurrencyValueUserPage.getText().contains("USD"), true);
		Assert.assertEquals(CurrencyText.getText(), LocalSettingData.getCellData(5, 2) + " ");
		Assert.assertEquals(CurrencyDigitUserPage.getText(), LocalSettingData.getCellData(0, 4));
		Assert.assertEquals(Integer.parseInt(CurrencyDigitValueUserpage.getText().replace(" ", "")),
				CurrencySignificantDigit);
		Assert.assertEquals(CurrencyDigitTextUserpage.getText(), LocalSettingData.getCellData(8, 4) + " ");
		Assert.assertEquals(ThousandsUserPage.getText(), LocalSettingData.getCellData(0, 11));
		Assert.assertEquals(ThousandsValueUserPage.getText().replace(" ", ""), LocalSettingData.getCellData(1, 11));
		Assert.assertEquals(ThousandsTextValueUserPage.getText().contains(LocalSettingData.getCellData(2, 11)), true);
		Assert.assertEquals(DecimalUserPage.getText(), LocalSettingData.getCellData(0, 14));
		Assert.assertEquals(DecilamlValueUserPage.getText().replace(" ", ""), LocalSettingData.getCellData(1, 14));
		Assert.assertEquals(DeciamlTextUserPage.getText(), LocalSettingData.getCellData(2, 14) + " ");
		Assert.assertEquals(NameDisplayUserPage.getText(), LocalSettingData.getCellData(0, 12));
		Assert.assertEquals(NameDisplayValueOneUserPage.getText(), LocalSettingData.getCellData(1, 12));
		Assert.assertEquals(NameDisplayValueSecondUserPage.getText(), LocalSettingData.getCellData(2, 12));
		Assert.assertEquals(NameDisplayValueThirdUserPage.getText(), LocalSettingData.getCellData(3, 12));
		Assert.assertEquals(NameDisplayValueForthUserPage.getText(), LocalSettingData.getCellData(4, 12));
		Assert.assertEquals(NameDisplayValueFifthUserPage.getText(), LocalSettingData.getCellData(5, 12));
		Assert.assertEquals(NameDisplayValueSixthUserPage.getText(), LocalSettingData.getCellData(6, 12));
		Assert.assertEquals(NameDisplayTextUserPage.getText(), LocalSettingData.getCellData(7, 12) + " ");
		Assert.assertEquals(CalendarOption.getText(), CalendarOptionData.getCellData(0, 0));
		Assert.assertEquals(CalendarOption.getCssValue("color"), CalendarOptionData.getCellData(1, 0));
		Assert.assertEquals(Publish_Key.getText(), CalendarOptionData.getCellData(0, 1));
		Assert.assertEquals(Publish_Key_Text.getText(), CalendarOptionData.getCellData(1, 1) + " ");
		Assert.assertEquals(Publish_at_my_location.getText(), CalendarOptionData.getCellData(0, 2));
		if (Publish_at_my_location_text.getText().contains("&email="))
		{
			Assert.assertEquals(Publish_at_my_location_text.getText(),
					CalendarOptionData.getCellData(2, 2) + EmailAddress1);
		}
		else
		{
			Assert.assertEquals(Publish_at_my_location_text.getText(), CalendarOptionData.getCellData(1, 2));
		}
		Assert.assertEquals(Search_Location.getText(), CalendarOptionData.getCellData(0, 3));
		Assert.assertEquals(Search_Location_Text.getText(), CalendarOptionData.getCellData(1, 3));
		Assert.assertEquals(ICal.getText(), CalendarOptionData.getCellData(0, 4));
		Assert.assertEquals(ICal_Text.getText(), CalendarOptionData.getCellData(1, 4));
		Assert.assertEquals(First_Day_Of_Week.getText(), CalendarOptionData.getCellData(0, 5));
		Assert.assertTrue(First_Day_Of_Week_Text.getText().contains(FirstDayOfWeek));
		Assert.assertTrue(First_Day_Of_Week_Text.getText().contains(CalendarOptionData.getCellData(8, 5)));
		Assert.assertEquals(Layout_Option.getText(), LayoutData.getCellData(0, 0));
		Assert.assertEquals(Layout_Option.getCssValue("color"), LayoutData.getCellData(1, 0));
		Assert.assertEquals(Module_Menu_Filter.getText(), LayoutData.getCellData(0, 1));
		Assert.assertEquals(Module_Menu_Filter_text.getText(), LayoutData.getCellData(1, 1) + " ");
		Assert.assertEquals(SubPanel_Tab.getText(), LayoutData.getCellData(0, 5));
		Assert.assertEquals(SubPanel_Tab_Text.getText(), LayoutData.getCellData(1, 5) + " ");
		Assert.assertEquals(All.getText(), LayoutData.getCellData(0, 8));
		Assert.assertEquals(All.getCssValue("color"), LayoutData.getCellData(1, 8));
//		Sa.assertAll();
	}


	public void accessCheck()
	{
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(Access));
		Access.click();
		List = Driver
				.findElements(By.xpath(".//div[@class='table-responsive-edit']//table//tbody//tr"));
//		System.out.println(List.size());
//		for (int i = 0; i < List.size(); i++)
//		{
//			System.out.println(List.get(i).getText());
//		}
		for (int i = 0; i < List.size(); i++)
		{
			if (Driver.findElement(
					By.xpath(".//div[@class='table-responsive-edit']//table//tbody/tr[" + (i + 1) + "]//td[1]"))
					.getText().equals(AccessData.getCellData(i, 0)) == true)
			{
				Assert.assertEquals(Driver.findElement(By
						.xpath(".//div[@class='table-responsive-edit']//table//tbody/tr[" + (i + 1) + "]//td[1]"))
						.getText(), AccessData.getCellData(i, 0));
			}
		}
//		List = driver
//				.findElements(By.xpath(".//div[@class='table-responsive-edit']//table//tbody//tr[1]//td"));
//		for (int i = 0; i < List.size(); i++)
//		{
//			System.out.println(Driver.findElement(
//					By.xpath(".//div[@class='table-responsive-edit']//table//tbody/tr[1]//td[" + (i + 1) + "]"))
//					.getText());
//			if (Driver.findElement(
//					By.xpath(".//div[@class='table-responsive-edit']//table//tbody/tr[1]//td[" + (i + 1) + "]"))
//					.getText().equals(" ") == true)
//			{
//				System.out.println("Blank Value");
//			}
//			else {
//				Assert.assertEquals(Driver.findElement(By
//						.xpath(".//div[@class='table-responsive-edit']//table//tbody/tr[1]//td[" + (i + 1) + "]"))
//						.getText(), AccessData.getCellData(i, 0));
//			}
//		}

//		List = Driver.findElements(By.xpath(".//div[@class='table-responsive-edit']//table//tbody//tr[2]//td[3]"));
		for (int i = 1; i < List.size(); i++)
		{
			Assert.assertEquals(Driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[3]"))
					.getText(), AccessData.getCellData(i, 2));
			Assert.assertEquals(Driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[4]"))
					.getText(), AccessData.getCellData(i, 3));
			Assert.assertEquals(Driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[5]"))
					.getText(), AccessData.getCellData(i, 4));
			Assert.assertEquals(Driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[6]"))
					.getText(), AccessData.getCellData(i, 5));
			Assert.assertEquals(Driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[7]"))
					.getText(), AccessData.getCellData(i, 6));
			Assert.assertEquals(Driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[8]"))
					.getText(), AccessData.getCellData(i, 7));
			Assert.assertEquals(Driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[9]"))
					.getText(), AccessData.getCellData(i, 8));
			if (Driver.findElement(
					By.xpath(".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[2]"))
					.getText().equals(AccessData.getCellData(0, 9)))
			{
				Assert.assertEquals(Driver.findElement(By.xpath(
						".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[2]"))
						.getCssValue("color"), AccessData.getCellData(1, 9));
			}
			if (Driver.findElement(
					By.xpath(".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[3]"))
					.getText().equals(AccessData.getCellData(0, 10)))
			{
				Assert.assertEquals(Driver.findElement(By.xpath(
						".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[3]"))
						.getCssValue("color"), AccessData.getCellData(1, 10));
			}
			else if (Driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[3]"))
					.getText().equals(AccessData.getCellData(0, 11)))
			{
				Assert.assertEquals(Driver.findElement(By.xpath(
						".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[3]"))
						.getCssValue("color"), AccessData.getCellData(1, 11));
			}
			else if (Driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[3]"))
					.getText().equals(AccessData.getCellData(0, 12)))
			{
				Assert.assertEquals(Driver.findElement(By.xpath(
						".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[3]"))
						.getCssValue("color"), AccessData.getCellData(1, 12));
			}
		}
//		System.out.println(NoneColor.getCssValue("color"));
//		System.out.println(AllColor.getCssValue("color"));
//		System.out.println(OwnerColor.getCssValue("color"));
//		System.out.println(
//				driver.findElement(By.xpath(".//div[@id='subpanel_title_aclroles']//table//tbody//h3/span[1]"))
//						.getText());
		Assert.assertEquals(Roles.getText(), AccessData.getCellData(0, 13));
		Assert.assertEquals(Roles_Name.getText(), AccessData.getCellData(0, 14));
		Assert.assertEquals(Roles_Description.getText(), AccessData.getCellData(0, 15));
		Assert.assertEquals(Roles_Franchisee.getText(), AccessData.getCellData(0, 16));
		Assert.assertEquals(Roles_Not_Delete.getText(), AccessData.getCellData(0, 17));
		Assert.assertEquals(Roles_ALL.getText(), AccessData.getCellData(0, 18));
//		Sa.assertAll();
	}


	public void closeBrowser()
	{
		Logout.logout();
		Driver.close();
	}
}
