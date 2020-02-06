package com.filta.qa.operations;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
//import java.util.Iterator;
import java.util.List;
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

public class OperationsSubModule
{
	private WebDriver driver;
	private Global globalObj;
	private Properties prop;
	private Login login;
	private String fBStatus;
	private boolean oPSAccess;
	private ReadExcelData operations;
	private ArrayList<String> array;

	@FindBy(how = How.XPATH, using = ".//a[@class='container-close']")
	private WebElement containerClose;

	@FindBy(how = How.XPATH, using = ".//div[@id='ajaxHeader']//a[@id='grouptab_1']")
	private WebElement franchisee;

	@FindBy(how = How.XPATH, using = ".//div[@id='ajaxHeader']//a[@id='moduleTab_-1_Franchisees']")
	private WebElement franchiseeClick;

	@FindBy(how = How.XPATH, using = ".//input[@id='search_name_basic']")
	private WebElement nameFranchiseeSearch;

	@FindBy(how = How.XPATH, using = ".//input[@id='first_name_advanced']")
	private WebElement advancedNameFranchiseeSearch;

	@FindBy(how = How.XPATH, using = ".//input[@type='submit']")
	private WebElement nameFranchiseeSearchClick;

	@FindBy(how = How.XPATH, using = ".//a[@id='basic_search_link']")
	private WebElement basicSearch;

	@FindBy(how = How.XPATH, using = ".//table[@id='ListTable']//tbody//tr[3]//td[3]//a")
	private WebElement franchiseeIDClick;

	@FindBy(how = How.XPATH, using = ".//a[@id='tab1']")
	private WebElement filtaBioTab;

	@FindBy(how = How.XPATH, using = ".//input[@id='fb_status']")
	private WebElement filtaBioStatus;

	@FindBy(how = How.XPATH, using = ".//input[@id='ops_access']")
	private WebElement oPSCheckbox;

	@FindBy(how = How.XPATH, using = ".//a[@id='logout_link']")
	private WebElement logout;

	@FindBy(how = How.XPATH, using = ".//div[@id='ajaxHeader']//a[@id='grouptab_3']")
	private WebElement operationTab;

	@FindBy(how = How.XPATH, using = ".//div[@id='ajaxHeader']//div[@class='menubar']//div[@id='moduleList']//ul//li[@class='last-li'][3]//li")
	private WebElement operationList;

	@FindBy(how = How.XPATH, using = ".//input[@id='edit_button']")
	private WebElement editFranchisee;

	@FindBy(how = How.XPATH, using = ".//div[@id='EditView_tabs']//li[2]//a[@id='tab1']")
	private WebElement editFB;

	@FindBy(how = How.XPATH, using = ".//select[@id='fb_status']")
	private WebElement currentStatus;

	@FindBy(how = How.XPATH, using = ".//table[@class='dcQuickEdit']//div[@class='action_buttons action-rows']//input[@id='SAVE_HEADER']")
	private WebElement saveFranchisee;

	@FindBy(how = How.XPATH, using = ".//select[@id='jac_region']")
	private WebElement jacobsen;

	@FindBy(how = How.XPATH, using = ".//input[@id='thousand']")
	private WebElement thousand;

	@FindBy(how = How.XPATH, using = ".//input[@id='fifteen_hundred']")
	private WebElement fifteenHundred;

	@FindBy(how = How.XPATH, using = ".//input[@id='two_thousand']")
	private WebElement twoThousand;

	@FindBy(how = How.XPATH, using = ".//input[@id='twenty_five_hundred']")
	private WebElement twentyFiveHundred;

	@FindBy(how = How.XPATH, using = ".//input[@id='no_limit']")
	private WebElement noLimit;

	@FindBy(how = How.XPATH, using = ".//button[@id='btn_franchisee_6k_name']")
	private WebElement sixKFR;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/table/tbody/tr[3]/td[1]/a")
	private WebElement first6K;

	@FindBy(how = How.XPATH, using = ".//button[@id='btn_fl_routes_fl_franchisee_name']")
	private WebElement route;

	@FindBy(how = How.XPATH, using = ".//input[@id='rate_paid']")
	private WebElement ratePaid;

	@FindBy(how = How.XPATH, using = ".//input[@id='filta_perc']")
	private WebElement filtapercentage;

	public OperationsSubModule(WebDriver driver)
	{
		globalObj = new Global();
		prop = globalObj.readProperties();
		this.driver = driver;
		login = new Login(driver);
		operations = new ReadExcelData(prop.getProperty("Path2"), "Operations");
		PageFactory.initElements(driver, this);
	}


	public void opsActivePercent()
	{

		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchisee));
		globalObj.action(driver).moveToElement(franchisee).build().perform();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeClick));
		franchiseeClick.click();
		try
		{
			// globalObj.wait(driver).until(ExpectedConditions.visibilityOf(basicSearch));
			basicSearch.click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e);
		}
		try
		{
			nameFranchiseeSearch.clear();
			nameFranchiseeSearch.sendKeys(prop.getProperty("Franchisee_Name"));
			nameFranchiseeSearchClick.click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e);
		}

		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeIDClick));
		franchiseeIDClick.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(oPSCheckbox));
		oPSAccess = oPSCheckbox.isSelected();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(filtaBioTab));
		if (oPSAccess)
		{
			filtaBioTab.click();
			fBStatus = filtaBioStatus.getAttribute("value");
			System.out.println(fBStatus);
		}
		logout.click();
		loginOwner();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(operationTab));
		globalObj.action(driver).moveToElement(operationTab).build().perform();
		List<WebElement> list = driver.findElements(By.xpath(
				".//div[@id='ajaxHeader']//div[@class='menubar']//div[@id='moduleList']//ul//li[@class='last-li'][3]//li//a"));
		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext())
		{
			System.out.println(itr.next().getText());
		}

		for (int i = 0; i < list.size(); i++)
		{
			assertEquals(list.get(i).getText(), operations.getCellData(i + 1, 0));
		}
		logout.click();
	}


	public void opsOnly()
	{
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchisee));
		globalObj.action(driver).moveToElement(franchisee).build().perform();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeClick));
		franchiseeClick.click();
		try
		{
			// globalObj.wait(driver).until(ExpectedConditions.visibilityOf(basicSearch));
			basicSearch.click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e);
		}
		try
		{
			nameFranchiseeSearch.clear();
			nameFranchiseeSearch.sendKeys(prop.getProperty("Franchisee_Name"));
			nameFranchiseeSearchClick.click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e);
		}
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeIDClick));
		franchiseeIDClick.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(oPSCheckbox));
		oPSAccess = oPSCheckbox.isSelected();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(filtaBioTab));
		if (oPSAccess)
		{
			filtaBioTab.click();
			if (filtaBioStatus.getAttribute("value").equals("Active Percent"))
			{
				editFranchisee.click();
				globalObj.wait(driver).until(ExpectedConditions.visibilityOf(editFB));
				filtaBioTab.click();
				globalObj.select(currentStatus).selectByVisibleText("Inactive");
				saveFranchisee.click();
				globalObj.wait(driver).until(ExpectedConditions.visibilityOf(filtaBioTab));
				fBStatus = filtaBioStatus.getAttribute("value");
				System.out.println(fBStatus);
			}
		}
		logout.click();
		loginOwner();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(operationTab));
		globalObj.action(driver).moveToElement(operationTab).build().perform();
		List<WebElement> list = driver.findElements(By.xpath(
				".//div[@id='ajaxHeader']//div[@class='menubar']//div[@id='moduleList']//ul//li[@class='last-li'][3]//li//a"));
		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext())
		{
			System.out.println(itr.next().getText());
		}
		
		for (int i = 0; i < list.size(); i++)
		{
			assertEquals(list.get(i).getText(), operations.getCellData(i + 1, 1));
		}
		logout.click();
	}


	public void opsActive1KProgram()
	{
		globalObj.action(driver).moveToElement(franchisee).build().perform();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeClick));
		franchiseeClick.click();
		try
		{
			// globalObj.wait(driver).until(ExpectedConditions.visibilityOf(basicSearch));
			basicSearch.click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e);
		}
		try
		{
			nameFranchiseeSearch.clear();
			nameFranchiseeSearch.sendKeys(prop.getProperty("Franchisee_Name"));
			nameFranchiseeSearchClick.click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e);
		}
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeIDClick));
		franchiseeIDClick.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(oPSCheckbox));
		oPSAccess = oPSCheckbox.isSelected();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(filtaBioTab));
		if (oPSAccess)
		{
			filtaBioTab.click();
			if (filtaBioStatus.getAttribute("value").equals("Inactive"))
			{
				editFranchisee.click();
				globalObj.wait(driver).until(ExpectedConditions.visibilityOf(editFB));
				filtaBioTab.click();
				globalObj.select(currentStatus).selectByVisibleText("Active 1k Program");
				globalObj.select(jacobsen).selectByVisibleText("New York");
				thousand.sendKeys("2");
				fifteenHundred.sendKeys("3.2");
				twoThousand.sendKeys("4.0");
				twentyFiveHundred.sendKeys("5.1");
				noLimit.sendKeys("6");
				sixKFR.click();
				array = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(array.get(1));
				first6K.click();
				driver.switchTo().window(array.get(0));
				saveFranchisee.click();
				globalObj.wait(driver).until(ExpectedConditions.visibilityOf(filtaBioTab));
				fBStatus = filtaBioStatus.getAttribute("value");
				System.out.println(fBStatus);
			}
		}

		logout.click();
		loginOwner();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(operationTab));
		globalObj.action(driver).moveToElement(operationTab).build().perform();
		List<WebElement> list = driver.findElements(By.xpath(
				".//div[@id='ajaxHeader']//div[@class='menubar']//div[@id='moduleList']//ul//li[@class='last-li'][3]//li//a"));
		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext())
		{
			System.out.println(itr.next().getText());
		}

		for (int i = 0; i < list.size(); i++)
		{
			assertEquals(list.get(i).getText(), operations.getCellData(i + 1, 2));
		}
		logout.click();

	}


	public void opsActive6KProgram()
	{
		globalObj.action(driver).moveToElement(franchisee).build().perform();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeClick));
		franchiseeClick.click();
		try
		{
			// globalObj.wait(driver).until(ExpectedConditions.visibilityOf(basicSearch));
			basicSearch.click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e);
		}
		try
		{
			nameFranchiseeSearch.clear();
			nameFranchiseeSearch.sendKeys(prop.getProperty("Franchisee_Name"));
			nameFranchiseeSearchClick.click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e);
		}
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeIDClick));
		franchiseeIDClick.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(oPSCheckbox));
		oPSAccess = oPSCheckbox.isSelected();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(filtaBioTab));
		if (oPSAccess)
		{
			filtaBioTab.click();
			if (filtaBioStatus.getAttribute("value").equals("Active 1k Program"))
			{
				editFranchisee.click();
				globalObj.wait(driver).until(ExpectedConditions.visibilityOf(editFB));
				filtaBioTab.click();
				globalObj.select(currentStatus).selectByVisibleText("Active 6k Program");
				route.click();
				array = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(array.get(1));
				first6K.click();
				driver.switchTo().window(array.get(0));
				ratePaid.sendKeys("2.3");
				filtapercentage.sendKeys("1.6");
				saveFranchisee.click();
				globalObj.wait(driver).until(ExpectedConditions.visibilityOf(filtaBioTab));
				fBStatus = filtaBioStatus.getAttribute("value");
				System.out.println(fBStatus);
			}
		}
		logout.click();
		loginOwner();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(operationTab));
		globalObj.action(driver).moveToElement(operationTab).build().perform();
		List<WebElement> list = driver.findElements(By.xpath(
				".//div[@id='ajaxHeader']//div[@class='menubar']//div[@id='moduleList']//ul//li[@class='last-li'][3]//li//a"));
		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext())
		{
			System.out.println(itr.next().getText());
		}

		for (int i = 0; i < list.size(); i++)
		{
			assertEquals(list.get(i).getText(), operations.getCellData(i + 1, 3));
		}
		logout.click();
	}


	public void opsActiveCollector()
	{
		globalObj.action(driver).moveToElement(franchisee).build().perform();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeClick));
		franchiseeClick.click();
		try
		{
			// globalObj.wait(driver).until(ExpectedConditions.visibilityOf(basicSearch));
			basicSearch.click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e);
		}
		try
		{
			nameFranchiseeSearch.clear();
			nameFranchiseeSearch.sendKeys(prop.getProperty("Franchisee_Name"));
			nameFranchiseeSearchClick.click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e);
		}
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeIDClick));
		franchiseeIDClick.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(oPSCheckbox));
		oPSAccess = oPSCheckbox.isSelected();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(filtaBioTab));
		if (oPSAccess)
		{
			filtaBioTab.click();
			if (filtaBioStatus.getAttribute("value").equals("Active 6k Program"))
			{
				editFranchisee.click();
				globalObj.wait(driver).until(ExpectedConditions.visibilityOf(editFB));
				filtaBioTab.click();
				globalObj.select(currentStatus).selectByVisibleText("Active Collector");
				globalObj.select(jacobsen).selectByVisibleText("New York");
				thousand.sendKeys("2");
				fifteenHundred.sendKeys("3.2");
				twoThousand.sendKeys("4.0");
				twentyFiveHundred.sendKeys("5.1");
				noLimit.sendKeys("6");
				route.click();
				array = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(array.get(1));
				first6K.click();
				driver.switchTo().window(array.get(0));
				saveFranchisee.click();
				globalObj.wait(driver).until(ExpectedConditions.visibilityOf(filtaBioTab));
				fBStatus = filtaBioStatus.getAttribute("value");
				System.out.println(fBStatus);
			}
		}
		logout.click();
		loginOwner();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(operationTab));
		globalObj.action(driver).moveToElement(operationTab).build().perform();
		List<WebElement> list = driver.findElements(By.xpath(
				".//div[@id='ajaxHeader']//div[@class='menubar']//div[@id='moduleList']//ul//li[@class='last-li'][3]//li//a"));
		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext())
		{
			System.out.println(itr.next().getText());
		}
		for (int i = 0; i < list.size(); i++)
		{
			assertEquals(list.get(i).getText(), operations.getCellData(i + 1, 4));
		}
		logout.click();
	}


	public void opsSignedWaiting()
	{
		globalObj.action(driver).moveToElement(franchisee).build().perform();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeClick));
		franchiseeClick.click();
		try
		{
			// globalObj.wait(driver).until(ExpectedConditions.visibilityOf(basicSearch));
			basicSearch.click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e);
		}
		try
		{
			nameFranchiseeSearch.clear();
			nameFranchiseeSearch.sendKeys(prop.getProperty("Franchisee_Name"));
			nameFranchiseeSearchClick.click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e);
		}
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeIDClick));
		franchiseeIDClick.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(oPSCheckbox));
		oPSAccess = oPSCheckbox.isSelected();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(filtaBioTab));
		if (oPSAccess)
		{
			filtaBioTab.click();
			if (filtaBioStatus.getAttribute("value").equals("Active Collector"))
			{
				editFranchisee.click();
				globalObj.wait(driver).until(ExpectedConditions.visibilityOf(editFB));
				filtaBioTab.click();
				globalObj.select(currentStatus).selectByVisibleText("Signed Waiting");
				globalObj.select(jacobsen).selectByVisibleText("New York");
				saveFranchisee.click();
				globalObj.wait(driver).until(ExpectedConditions.visibilityOf(filtaBioTab));
				fBStatus = filtaBioStatus.getAttribute("value");
				System.out.println(fBStatus);
			}
		}
		logout.click();
		loginOwner();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(operationTab));
		globalObj.action(driver).moveToElement(operationTab).build().perform();
		List<WebElement> list = driver.findElements(By.xpath(
				".//div[@id='ajaxHeader']//div[@class='menubar']//div[@id='moduleList']//ul//li[@class='last-li'][3]//li//a"));
		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext())
		{
			System.out.println(itr.next().getText());
		}
		for (int i = 0; i < list.size(); i++)
		{
			assertEquals(list.get(i).getText(), operations.getCellData(i + 1, 5));
		}
		logout.click();
	}


	public void opsWCIssues()
	{
		globalObj.action(driver).moveToElement(franchisee).build().perform();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeClick));
		franchiseeClick.click();
		try
		{
			// globalObj.wait(driver).until(ExpectedConditions.visibilityOf(basicSearch));
			basicSearch.click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e);
		}
		try
		{
			nameFranchiseeSearch.clear();
			nameFranchiseeSearch.sendKeys(prop.getProperty("Franchisee_Name"));
			nameFranchiseeSearchClick.click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e);
		}
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeIDClick));
		franchiseeIDClick.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(oPSCheckbox));
		oPSAccess = oPSCheckbox.isSelected();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(filtaBioTab));
		if (oPSAccess)
		{
			filtaBioTab.click();
			if (filtaBioStatus.getAttribute("value").equals("Signed Waiting"))
			{
				editFranchisee.click();
				globalObj.wait(driver).until(ExpectedConditions.visibilityOf(editFB));
				filtaBioTab.click();
				globalObj.select(currentStatus).selectByVisibleText("WC Issues");
				saveFranchisee.click();
				globalObj.wait(driver).until(ExpectedConditions.visibilityOf(filtaBioTab));
				fBStatus = filtaBioStatus.getAttribute("value");
				System.out.println(fBStatus);
			}
		}
		logout.click();
		loginOwner();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(operationTab));
		globalObj.action(driver).moveToElement(operationTab).build().perform();
		List<WebElement> list = driver.findElements(By.xpath(
				".//div[@id='ajaxHeader']//div[@class='menubar']//div[@id='moduleList']//ul//li[@class='last-li'][3]//li//a"));
		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext())
		{
			System.out.println(itr.next().getText());
		}
		for (int i = 0; i < list.size(); i++)
		{
			assertEquals(list.get(i).getText(), operations.getCellData(i + 1, 6));
		}
		logout.click();
		loginAdmin();
		globalObj.action(driver).moveToElement(franchisee).build().perform();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeClick));
		franchiseeClick.click();
		nameFranchiseeSearch.clear();
		nameFranchiseeSearch.sendKeys(prop.getProperty("Franchisee_Name"));
		nameFranchiseeSearchClick.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(franchiseeIDClick));
		franchiseeIDClick.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(oPSCheckbox));
		oPSAccess = oPSCheckbox.isSelected();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(filtaBioTab));
		if (oPSAccess)
		{
			filtaBioTab.click();
			if (filtaBioStatus.getAttribute("value").equals("WC Issues"))
			{
				editFranchisee.click();
				globalObj.wait(driver).until(ExpectedConditions.visibilityOf(editFB));
				filtaBioTab.click();
				globalObj.select(currentStatus).selectByVisibleText("Active Percent");
				ratePaid.sendKeys("2.6");
				saveFranchisee.click();
				globalObj.wait(driver).until(ExpectedConditions.visibilityOf(filtaBioTab));
				fBStatus = filtaBioStatus.getAttribute("value");
				System.out.println(fBStatus);
			}
		}
		logout.click();
	}


	public void loginOwner()
	{
		login.credentials();
		containerClose.click();
	}


	public void loginAdmin()
	{
		login.adminCredentials();
	}


	public void closeBrowser()
	{
		driver.close();
	}
}
