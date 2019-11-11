package com.filta.qa.operations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
	private String mins;
	private String hr;
	private String jobStatus;
	private String dumpSize;
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

	@FindBy(how = How.XPATH, using = ".//select[@id='duration_minutes']")
	private WebElement jobMins;

	@FindBy(how = How.XPATH, using = ".//input[@id='duration_hours']")
	private WebElement hours;

	@FindBy(how = How.XPATH, using = ".//select[@id='status']")
	private WebElement status;

	@FindBy(how = How.XPATH, using = ".//select[@id='location_select_id_0']")
	private WebElement location;

	@FindBy(how = How.XPATH, using = ".//div[@id='main_fryer_div_id_0']//table[@id='fryers_table_id_0']//tbody//tr[3]//td[2]//select[@id='service_type_id_0']")
	private WebElement fryerOne;

	@FindBy(how = How.XPATH, using = ".//div[@id='main_fryer_div_id_0']//table[@id='fryers_table_id_0']//tbody//tr[4]//select[@id='oil_quantity_before_id_0']")
	private WebElement oilQualityBefore;

	@FindBy(how = How.XPATH, using = ".//div[@id='main_fryer_div_id_0']//table[@id='fryers_table_id_0']//tbody//tr[5]//select[@id='oil_quantity_after_id_0']")
	private WebElement oilQualityAfter;

	@FindBy(how = How.XPATH, using = ".//input[@title='Add Location']")
	private WebElement addLocation;

	@FindBy(how = How.XPATH, using = ".//select[@id='location_select_id_1']")
	private WebElement location2;

	@FindBy(how = How.XPATH, using = ".//label[@id='cascade_from_fryer_label_0']")
	private WebElement fryerOneLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='main_fryer_div_id_1']//table[@id='fryers_table_id_1']//tbody//tr[3]//td[2]//select[@id='service_type_id_1']")
	private WebElement secondFryer;

	@FindBy(how = How.XPATH, using = ".//div[@id='main_fryer_div_id_1']//table[@id='fryers_table_id_2']//tbody//tr[3]//td[2]//select[@id='service_type_id_2']")
	private WebElement thirdFryer;

	@FindBy(how = How.XPATH, using = ".//div[@id='main_fryer_div_id_1']//table[@id='fryers_table_id_3']//tbody//tr[3]//td[2]//select[@id='service_type_id_3']")
	private WebElement forthFryer;

	@FindBy(how = How.XPATH, using = ".//label[@id='cascade_from_fryer_label_3']")
	private WebElement forthFryerLabel;

	@FindBy(how = How.XPATH, using = ".//select[@id='oil_quantity_before_id_3']")
	private WebElement forthFryerOilQualityBefore;

	@FindBy(how = How.XPATH, using = ".//select[@id='oil_quantity_after_id_3']")
	private WebElement forthFryerOilQualityAfter;

	@FindBy(how = How.XPATH, using = ".//input[@id='remove_btn_id_0']")
	private WebElement removeLocation1;

	@FindBy(how = How.XPATH, using = ".//input[@id='remove_btn_id_1']")
	private WebElement removeLocation2;

	@FindBy(how = How.XPATH, using = ".//div[@id='main_div_id_2']//table[@id='main_table_id_2']//tbody//tr//td[2]//select[@id='location_select_id_2']")
	private WebElement lastLocation;

	@FindBy(how = How.XPATH, using = ".//input[@id='remove_btn_id_2']")
	private WebElement removeLastLocation;

	@FindBy(how = How.XPATH, using = ".//select[@id='cascade_from_fryer_3']")
	private WebElement noCascade;

	@FindBy(how = How.XPATH, using = ".//select[@id='service_custom']")
	private WebElement additionalService;

	@FindBy(how = How.XPATH, using = ".//input[@id='quantity_custom']")
	private WebElement additionalServiceQuantity;

	@FindBy(how = How.XPATH, using = ".//input[@title='Add More']")
	private WebElement addMore;

	@FindBy(how = How.XPATH, using = ".//select[@id='service_custom0']")
	private WebElement additionalService2;

	@FindBy(how = How.XPATH, using = ".//input[@id='price_custom0']")
	private WebElement additionalService2CheckBox1;

	@FindBy(how = How.XPATH, using = ".//input[@id='quantity_custom0']")
	private WebElement additionalService2CheckBox2;

	@FindBy(how = How.XPATH, using = ".//table[@class='tbl_service setting-detail-table']//tr[@name='service_0'][2]//img[@id='removeDocButton']")
	private WebElement removeAdditionalService;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_ADDITIONAL_SERVICES_PANEL']//table//tbody//tr[1]//th//h4")
	private WebElement additionalServicelabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_ADD_WORKSHEET_DETAILS_PANEL']//table//tbody//tr[1]//th//h4")
	private WebElement addWorkSheetLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EDITVIEW_PANEL1']//table//tbody//tr[1]//th//h4")
	private WebElement moreInformation;

	@FindBy(how = How.XPATH, using = ".//span[@id='fryer_size_id_3']")
	private WebElement dumpFryerSize;

	@FindBy(how = How.XPATH, using = ".//input[@id='total_waste_oil_collected']")
	private WebElement totalWasteOilCollected;

	@FindBy(how = How.XPATH, using = ".//input[@id='drainfoam_quantity']")
	private WebElement drainFoamQty;

	@FindBy(how = How.XPATH, using = ".//input[@id='total_new_oil_sold_to_customer']")
	private WebElement gals;

	@FindBy(how = How.XPATH, using = ".//input[@id='oil_used_by_customer']")
	private WebElement boxes;

	@FindBy(how = How.XPATH, using = ".//textarea[@id='description']")
	private WebElement note;

	@FindBy(how = How.XPATH, using = ".//input[@id='next_service_flag']")
	private WebElement serviceFlag;

	@FindBy(how = How.XPATH, using = "//div[@class='buttons']//div[@class='action_buttons action-rows']//input[@id='Save_button']")
	private WebElement saveFooter;

	@FindBy(how = How.XPATH, using = "//div[@class='buttons']//div[@class='action_buttons action-rows']//input[@id='CANCEL_FOOTER']")
	private WebElement cancelFooter;

	@FindBy(how = How.XPATH, using = "//table[@id='detailpanel_2']//tr[3]//td[4]")
	private WebElement statusAfterJobSave;


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
		// waitLoader();
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
		driver.get(prop.getProperty("ScheduledJobURL"));
		addWorkSheet.click();
	}


	public void jobOverview()
	{
		mins = globalObj.select(jobMins).getFirstSelectedOption().getText();
		assertEquals(mins, "30");
		hr = hours.getAttribute("value");
		assertEquals(hr, "0");
		jobStatus = globalObj.select(status).getFirstSelectedOption().getText();
		assertEquals(jobStatus, "Job Performed");
		globalObj.jsReturn(driver).executeScript("window.scrollBy(0, 600)", "");
	}


	public void addWorksheet()
	{
		assertEquals(addWorkSheetLabel.getText(), "Add Worksheet Details");
		globalObj.select(location).selectByVisibleText("Default");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		globalObj.select(fryerOne).selectByVisibleText("Filter");
		assertEquals(fryerOneLabel.getText(), "Cascade To Fryer");
		globalObj.jsReturn(driver).executeScript("window.scrollBy(0, 200)", "");
		globalObj.select(oilQualityBefore).selectByVisibleText("1.5");
		globalObj.select(oilQualityAfter).selectByVisibleText("3.5");
		assertTrue(removeLocation1.isDisplayed());
		addLocation.click();
		globalObj.jsReturn(driver).executeScript("window.scrollBy(0, 3)", "");
		globalObj.select(location2).selectByVisibleText("Location1");
		globalObj.jsReturn(driver).executeScript("window.scrollBy(0, 400)", "");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		globalObj.select(secondFryer).selectByVisibleText("No Service");
		globalObj.select(thirdFryer).selectByVisibleText("Clean Only");
		globalObj.select(forthFryer).selectByVisibleText("Dump");
		if (globalObj.select(forthFryer).getFirstSelectedOption().getText().equals("Dump"))
		{
			dumpSize = dumpFryerSize.getText();
		}
		assertEquals(forthFryerLabel.getText(), "Cascade from Fryer");
		if (noCascade.isDisplayed())
		{
			assertEquals(globalObj.select(noCascade).getFirstSelectedOption().getText(), "No Cascade");

		}
		globalObj.select(forthFryerOilQualityBefore).selectByVisibleText("2.0");
		globalObj.select(forthFryerOilQualityAfter).selectByVisibleText("5.0");
		assertTrue(removeLocation2.isDisplayed());
		addLocation.click();
		assertEquals(globalObj.select(lastLocation).getFirstSelectedOption().getText(), "Select");
		removeLastLocation.click();
		globalObj.jsReturn(driver).executeScript("window.scrollBy(0, 600)", "");

	}


	public void additionalService()
	{
		assertEquals(additionalServicelabel.getText(), "Additional Services");
		assertEquals(globalObj.select(additionalService).getFirstSelectedOption().getText(), "Select Service");
		globalObj.select(additionalService).selectByVisibleText("Extra Work 1");
		waitLoader();
		assertEquals(additionalServiceQuantity.getAttribute("value"), "1");
		addMore.click();
		assertEquals(globalObj.select(additionalService2).getFirstSelectedOption().getText(), "Select Service");
		assertEquals(additionalService2CheckBox1.getAttribute("value"), "");
		assertEquals(additionalService2CheckBox2.getAttribute("value"), "");
		globalObj.select(additionalService2).selectByVisibleText("Extra Work 2");
		waitLoader();
		assertEquals(additionalService2CheckBox2.getAttribute("value"), "1");
		assertTrue(removeAdditionalService.isDisplayed());
	}


	public void moreInformation()
	{
		assertEquals(moreInformation.getText(), "More Information");
		assertEquals(totalWasteOilCollected.getAttribute("value"), dumpSize);
		assertEquals(drainFoamQty.getAttribute("value"), "");
		drainFoamQty.sendKeys("2");
		assertEquals(gals.getAttribute("value"), "");
		gals.sendKeys("2");
		assertEquals(boxes.getAttribute("value"), "");
		boxes.sendKeys("2");
		assertEquals(note.getAttribute("value"), "");
		note.sendKeys("Note Added !!");
		assertEquals(serviceFlag.isSelected(), false);
		serviceFlag.click();
		assertTrue(serviceFlag.isSelected());
	}


	public void saveCancel()
	{
		assertEquals(saveFooter.isDisplayed(), true);
		assertEquals(cancelFooter.isDisplayed(), true);
		cancelFooter.click();
//		globalObj.sleepMethod();
//		System.out.println(globalObj.alertFunction(driver).getText());
//		assertEquals(globalObj.alertFunction(driver).getText(), "Changes you made may not be saved.");
		globalObj.alertFunction(driver).dismiss();
		saveFooter.click();
	}


	public void crossCheckJobOverview()
	{
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(statusAfterJobSave));
		System.out.println(statusAfterJobSave.getText());
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
