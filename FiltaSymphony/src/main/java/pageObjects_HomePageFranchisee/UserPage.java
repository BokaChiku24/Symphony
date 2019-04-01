package pageObjects_HomePageFranchisee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import helper.HomePage_Interface;
import helper.UserPage_Interface;
import util.Login;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import util.Global;
import org.openqa.selenium.WebDriver;

import util.Global;
import util.Login;

public class UserPage implements UserPage_Interface {
	private Global global;
	private WebDriver driver;
	private Properties Prop;
	private Login login;

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

	public UserPage(WebDriver driver) {
		global = new Global();
		Prop = global.readProperties();
		this.driver = driver;
		login = new Login(driver);
		PageFactory.initElements(driver, this);
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
		Assert.assertEquals(Tab1OnEditPage.getText(), Prop.getProperty("TabOnEditPage"));
		System.out.println(Tab1OnEditPage.getCssValue("color"));
	}

	public void closeBrowser() {
		driver.close();
	}
}
