package com.filta.qa.operations;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.filta.qa.util.Global;
import com.filta.qa.util.Login;

public class OPSCycle
{
	private WebDriver driver;
	private Global globalObj;
	private Properties prop;
	private Login login;
	private ArrayList<String> array;

	public static Logger Log = Logger.getLogger("Operation Cycle Test Scenario");
	static
	{
		PropertyConfigurator.configure(".//Log4j.properties");
	}

	@FindBy(how = How.XPATH, using = ".//a[@class='container-close']")
	private WebElement containerClose;

	@FindBy(how = How.XPATH, using = ".//div[@id='ajaxHeader']//a[@id='grouptab_3']")
	private WebElement operationTab;

	@FindBy(how = How.XPATH, using = ".//a[@id='moduleTab_-1_Scheduled Jobs Calendar']")
	private WebElement scheduledJobCalendar;

	@FindBy(how = How.XPATH, using = ".//div[@time='00:00']")
	private WebElement calendarClick;

	@FindBy(how = How.XPATH, using = ".//input[@id='fr_customer_name']")
	private WebElement customerSelect;

	@FindBy(how = How.XPATH, using = ".//button[@id='btn-save']")
	private WebElement calendarSave;

	@FindBy(how = How.XPATH, using = ".//button[@id='btn_fr_customer_name']")
	private WebElement customerlookUp;

	@FindBy(how = How.XPATH, using = ".//button[@id='btn_fr_van_name']")
	private WebElement routeVan;

	@FindBy(how = How.XPATH, using = ".//a[@id='moduleTab_-1_Scheduled Jobs']")
	private WebElement scheduledJob;

	@FindBy(how = How.XPATH, using = ".//table[@id='ListTable']//tbody//tr[@class='oddListRowS1'][1]//td//img[@alt='Add Worksheet Details']")
	private WebElement addWorkSheet;


	public OPSCycle(WebDriver driver)
	{
		globalObj = new Global();
		prop = globalObj.readProperties();
		this.driver = driver;
		login = new Login(driver);
		PageFactory.initElements(driver, this);
	}


	public void login()
	{
		login.credentials();
		containerClose.click();
	}


	public void scheduledJobCalendar()
	{
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(operationTab));
		globalObj.action(driver).moveToElement(operationTab).build().perform();
		scheduledJobCalendar.click();
		calendarClick.click();
		//waitLoader();
		customerlookUp.click();
		array = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(array.get(1));
		driver.findElement(By.linkText(prop.getProperty("Customername"))).click();
		driver.switchTo().window(array.get(0));
		routeVan.click();
		array = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(array.get(1));
		driver.findElement(By.linkText(prop.getProperty("VanName"))).click();
		driver.switchTo().window(array.get(0));
		calendarSave.click();
		globalObj.sleepMethod();
	}


	public void scheduledJobs()
	{
		driver.get(
				"https://dev.filtasymphony.com/index.php?module=Fr_Service_Visits&action=schedulelistview&parentTab=Operations");
		addWorkSheet.click();
	}


	public void waitLoader()
	{
		globalObj.wait(driver)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[@id='ajaxloading_mask']")));
	}


	public void closeBrowser()
	{
		driver.close();
	}
}
