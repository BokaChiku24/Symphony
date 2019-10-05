package com.filta.qa.home_page_franchisee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.filta.qa.helper.HomePage_Interface;
import com.filta.qa.util.Global;
import com.filta.qa.util.Login;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HomePage implements HomePage_Interface
{

	private WebDriver driver;
	private Global global_Obj;
	private Properties prop;
	private Login login;
	private StringBuffer bottomTextReplace;
	private String userNameOnUserPage;
	private ArrayList<String> array;
	private List<WebElement> list;
	private List<WebElement> list2;
	
	@FindBy(how = How.XPATH, using = ".//select[@name='login_language']")
	private WebElement language;

	@FindBy(how = How.LINK_TEXT, using = "Symphony Training on FiltaNet")
	private WebElement link;

	@FindBy(how = How.XPATH, using = ".//div[@class='main-wrapper clearfix']//div[@class='left-panel'][2]//div[@class='left-panel-national'][3]//ul//li")
	private WebElement tech;

	@FindBy(how = How.XPATH, using = ".//div[@class='main-wrapper clearfix']//div[@class='left-panel'][3]//div[@class='left-panel-national'][2]//ul//li")
	private WebElement filtaGold;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_marketing_summery']//h1")
	private WebElement email_Summary;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_marketing_summery']//div[@style='font-style: italic;']")
	private WebElement email_Summary2;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_marketing_summery']//span[@id='last-updated']")
	private WebElement email_Summary3;

	@FindBy(how = How.XPATH, using = ".//a[@href='https://sites.google.com/a/filta.com/opsmanual/filta-symphony']")
	private WebElement homeText;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DNotes%26action%3DEditView%26return_module%3DNotes%26return_action%3DDetailView']")
	private WebElement noteToolTip;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DLeads%26action%3DEditView%26return_module%3DLeads%26return_action%3DDetailView']")
	private WebElement leadToolTip1;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DTasks%26action%3DEditView%26return_module%3DTasks%26return_action%3DDetailView']")
	private WebElement leadToolTip2;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DCalls%26action%3DEditView%26return_module%3DCalls%26return_action%3DDetailView']")
	private WebElement leadToolTip3;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DNotes%26action%3DEditView%26return_module%3DNotes%26return_action%3DDetailView']")
	private WebElement leadToolTip4;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DFL_New_Oil_Inventory%26action%3DEditView%26return_module%3DFL_New_Oil_Inventory%26return_action%3DDetailView']")
	private WebElement filtaGoldToolTip;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DAccounts%26action%3Dfrindex%26parentTab%3DCustomers']")
	private WebElement customerLabel;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DIM_NCA%26action%3Dindex%26parentTab%3DNCA']")
	private WebElement NCALabel;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DLeads%26action%3Ddashletlist%26parentTab%3DLeads']")
	private WebElement leadLabel;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DFL_Filtabio%26action%3Dindex%26parentTab%3DFiltaBio']")
	private WebElement filtaBioLabel;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DTR_Leads%26action%3Dindex%26parentTab%3DTRS']")
	private WebElement techHiringLabel;

	@FindBy(how = How.XPATH, using = ".//a[@href='#']")
	private WebElement filtaGoldLabel;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?module=IM_NCA&action=frindex']")
	private WebElement myFranchiseeLabel;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?module=Home&action=index&type=widget']")
	private WebElement homeDashletLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='main']//div[@id='content']//tr/td//div[@id='pageNum_0_div'][1]/table/tbody/tr[1]/td[3]/span[5]/a[2]")
	private WebElement homeDashletLabel2;

	@FindBy(how = How.XPATH, using = ".//div[@id='main']//div[@id='content']//tr/td//div[@id='pageNum_0_div'][1]/table/tbody/tr[1]/td[3]/span[1]")
	private WebElement homeDashletLabel3;

	@FindBy(how = How.XPATH, using = ".//div[@id='dashletsDialog']")
	private WebElement dashletDialog;

	@FindBy(how = How.XPATH, using = ".//input[@id='search_string']")
	private WebElement searchWidet;

	@FindBy(how = How.XPATH, using = ".//input[@value='Search']")
	private WebElement searchButton;

	@FindBy(how = How.XPATH, using = ".//input[@value='Clear']")
	private WebElement clearButton;

	@FindBy(how = How.XPATH, using = ".//a[@id='moduleCategoryAnchor']")
	private WebElement tapNameWidget1;

	@FindBy(how = How.XPATH, using = ".//a[@id='chartCategoryAnchor']")
	private WebElement tapNameWidget2;

	@FindBy(how = How.XPATH, using = ".//div[@id='searchResults']//h4")
	private WebElement searchResult;

	@FindBy(how = How.XPATH, using = ".//div[@id='searchResults']//h4//i")
	private WebElement searchResultTwo;

	@FindBy(how = How.XPATH, using = ".//a[@class='mbLBLL' and text()='1k Reported Volumes']")
	private WebElement searchResult2;

	@FindBy(how = How.XPATH, using = ".//div[@id='dashletsDialogHeader']")
	private WebElement addLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='moduleDashlets']//h3")
	private WebElement moduleLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='chartDashlets']//h3")
	private WebElement basicChartlabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='searchResults']//h4")
	private WebElement basicChartSearchResult;

	@FindBy(how = How.XPATH, using = ".//div[@id='searchResults']//h4//i")
	private WebElement basicChartSearchResult2;

	@FindBy(how = How.XPATH, using = ".//div[@class='container-close']")
	private WebElement closeWidget;

	@FindBy(how = How.XPATH, using = ".//p[@class='error']")
	private WebElement redColor;

	@FindBy(how = How.XPATH, using = ".//div[@id='bottomLinks']//a[1 and text()=' Print']")
	private WebElement bottomText1;

	@FindBy(how = How.XPATH, using = ".//div[@id='bottomLinks']//a[2 and text()=' Back to top']")
	private WebElement bottomText2;

	@FindBy(how = How.XPATH, using = ".//a[@href='LICENSE.txt' and text()='AGPLv3']")
	private WebElement link1;

	@FindBy(how = How.XPATH, using = ".//a[@href='LICENSE.txt' and text()=' GNU Affero General Public License version 3']")
	private WebElement link2;

	@FindBy(how = How.XPATH, using = ".//a[@id='user_link_link']")
	private WebElement topText1;

	@FindBy(how = How.XPATH, using = ".//a[@id='filtastore_link']")
	private WebElement topText2;

	@FindBy(how = How.XPATH, using = ".//a[@id='admin_link']")
	private WebElement topText3;

	@FindBy(how = How.XPATH, using = ".//div[@id='ajaxHeader']//div[@id='lastView']//b")
	private WebElement lastViewText;

	@FindBy(how = How.XPATH, using = ".//div[@class='moduleTitle']//h2")
	private WebElement getUserName;

	@FindBy(how = How.XPATH, using = ".//div[@class='user']")
	private WebElement getHomeUserName;


	public HomePage(WebDriver driver)
	{
		global_Obj = new Global();
		prop = global_Obj.readProperties();
		this.driver = driver;
		login = new Login(driver);
		PageFactory.initElements(driver, this);
	}


	public void login()
	{
		login.credentials();
	}


	public void menuBar()
	{
		List<WebElement> list = driver.findElements(By.xpath(
				".//div[@id='ajaxHeader']//div[@class='menubar']//div[@id='moduleList']//ul[@class='last']/li//span/a"));

		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }

		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), prop.getProperty("FranchiseeMenu" + i));
		}
	}


	public void urlCheck()
	{
		driver.get(
				"https://dev.filtasymphony.com/index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DHome%26action%3Dindex%26type%3Dmenu");
		waitLoader();
		link.click();
		array = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(array.get(1));
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("HomeURL"));
		driver.close();
		driver.switchTo().window(array.get(0));
	}


	public void customers()
	{
		driver.get(
				"https://dev.filtasymphony.com/index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DHome%26action%3Dindex%26type%3Dmenu");
		waitLoader();
		list = driver.findElements(By.xpath(
				".//div[@class='left-panel'][1]//div[@class='left-panel-national'][1]//div[@class='left-panel-national-block-link clearfix']//ul//li"));

		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }

		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), prop.getProperty("FranchiseeCustomerMenuScreen" + i));
		}
	}


	public void leads()
	{
		list = driver.findElements(By.xpath(
				".//div[@class='left-panel'][1]//div[@class='left-panel-national'][2]//div[@class='left-panel-national-block-link clearfix']//ul//li"));

		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }

		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), prop.getProperty("FranchiseeLeadsMenuScreen" + i));
		}
	}


	public void nca()
	{
		list = driver.findElements(By.xpath(
				".//div[@class='main-wrapper clearfix']//div[@class='left-panel'][2]//div[@class='left-panel-national'][1]//ul//li"));

		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }

		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), prop.getProperty("FranchiseeNCAMenuScreen" + i));
		}
	}


	public void filtaBio()
	{
		list = driver.findElements(By.xpath(
				".//div[@class='main-wrapper clearfix']//div[@class='left-panel'][2]//div[@class='left-panel-national'][2]//ul//li"));

		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }

		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), prop.getProperty("FranchiseeFiltaBioMenuScreen" + i));
		}
	}


	public void techHiring()
	{
		Assert.assertEquals(tech.getText(), prop.getProperty("FranchiseeTechMenuScreen0"));

	}


	public void myFranchisee()
	{
		list = driver.findElements(By.xpath(
				".//div[@class='main-wrapper clearfix']//div[@class='left-panel'][3]//div[@class='left-panel-national'][1]//ul//li"));
		//
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }

		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), prop.getProperty("MyFranchiseeMenuScreen" + i));
		}
	}


	public void filtaGold()
	{
		Assert.assertEquals(filtaGold.getText(), prop.getProperty("FiltaGoldMenuScreen"));

	}


	public void checkText()
	{
		Assert.assertEquals(email_Summary.getText(), prop.getProperty("HomeText1"));
		Assert.assertEquals(email_Summary2.getText(), prop.getProperty("HomeText2"));
		Assert.assertEquals(email_Summary3.getText(), prop.getProperty("HomeText3"));
		Assert.assertEquals(homeText.getText(), prop.getProperty("HomeText4"));
		Assert.assertEquals(customerLabel.getText(), prop.getProperty("HomeCustomerLabel"));
		Assert.assertEquals(NCALabel.getText(), prop.getProperty("HomeNCALabel"));
		Assert.assertEquals(leadLabel.getText(), prop.getProperty("HomeLeadLabel"));
		Assert.assertEquals(filtaBioLabel.getText(), prop.getProperty("HomeFiltaBioLabel"));
		Assert.assertEquals(techHiringLabel.getText(), prop.getProperty("HomeTechLabel"));
		Assert.assertEquals(filtaGoldLabel.getText(), prop.getProperty("HomeFiltaGoldlabel"));
		Assert.assertEquals(myFranchiseeLabel.getText(), prop.getProperty("HomeMyFranchiseelabel"));
		Assert.assertEquals(homeDashletLabel.getText(), prop.getProperty("HomeDashletlabel"));
		Assert.assertEquals(bottomText1.getText().replace(" ", ""), prop.getProperty("BttomText"));
		bottomTextReplace = new StringBuffer(bottomText2.getText());
		Assert.assertEquals(bottomTextReplace.replace(0, 0, "").toString(), prop.getProperty("BttomText2"));
		Assert.assertEquals(topText1.getText(), prop.getProperty("topText1"));
		Assert.assertEquals(topText2.getText(), prop.getProperty("topText2"));
		Assert.assertEquals(topText3.getText(), prop.getProperty("topText3"));
		Assert.assertEquals(lastViewText.getText(), prop.getProperty("lastViewText") + "  ");
	}


	public void tableTest()
	{
		list = driver.findElements(By.xpath(".//table[@id='campaignerData']//tbody//tr"));
		list2 = driver.findElements(By.xpath(".//table[@id='campaignerData']//tbody//tr[1]//th"));
		global_Obj.wait(driver).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//table[@id='campaignerData']//tbody//tr")));
		Assert.assertEquals(list.size(), Integer.parseInt(prop.getProperty("HomeTable1Rows")));
		Assert.assertEquals(list2.size(), Integer.parseInt(prop.getProperty("HomeTable1Column")));

		// for (int i = 0; i < list2.size(); i++) {
		// if (i != 0)
		// System.out.println(list2.get(i).getText());
		// }

		// Checks the Column Names
		for (int i = 0; i < list2.size(); i++)
		{
			if (i != 0)
			{
				Assert.assertEquals(list2.get(i).getText(), prop.getProperty("Hometable1ColumnHeading" + i));
			}
		}

		// Checks the Row Names
		for (int i = 2; i < list.size(); i++)
		{
			Assert.assertEquals(
					driver.findElement(By.xpath(".//table[@id='campaignerData']//tbody//tr[" + i + "]//td[1]"))
							.getText(),
					prop.getProperty("HomeTabale1RowName" + i));
		}

		// Checks Table Column Data
		for (int i = 2; i < list.size(); i++)
		{
			Assert.assertEquals(
					driver.findElement(By.xpath(".//table[@id='campaignerData']//tbody//tr[" + i + "]//td[2]"))
							.getText(),
					prop.getProperty("HomeTableRow1Data"));
			Assert.assertEquals(
					driver.findElement(By.xpath(".//table[@id='campaignerData']//tbody//tr[" + i + "]//td[3]"))
							.getText(),
					prop.getProperty("HomeTableRow1Data"));
			Assert.assertEquals(
					driver.findElement(By.xpath(".//table[@id='campaignerData']//tbody//tr[" + i + "]//td[4]"))
							.getText(),
					prop.getProperty("HomeTableRow1Data"));
		}
	}


	public void toolTipCheck()
	{
		Assert.assertEquals(noteToolTip.getAttribute("title"), prop.getProperty("HomeCustomerTooltip"));
		Assert.assertEquals(leadToolTip1.getAttribute("title"), prop.getProperty("HomeLeadTooltip1"));
		Assert.assertEquals(leadToolTip2.getAttribute("title"), prop.getProperty("HomeLeadTooltip2"));
		Assert.assertEquals(leadToolTip3.getAttribute("title"), prop.getProperty("HomeLeadTooltip3"));
		Assert.assertEquals(leadToolTip4.getAttribute("title"), prop.getProperty("HomeLeadTooltip4"));
		Assert.assertEquals(filtaGoldToolTip.getAttribute("title"), prop.getProperty("HomeFiltaGoldToolTip1"));
	}


	public void widgetTesting()
	{
		driver.get("https://dev.filtasymphony.com/index.php?module=Home&action=index&type=widget");
		Assert.assertEquals(homeDashletLabel2.getText(), prop.getProperty("HomeDashletlabel2"));
		Assert.assertEquals(homeDashletLabel2.isDisplayed(), true);
		Assert.assertEquals(homeDashletLabel3.getText(), prop.getProperty("HomeDashletlabel3"));
		Assert.assertEquals(homeDashletLabel3.isDisplayed(), true);
		homeDashletLabel2.click();
		global_Obj.wait(driver).until(ExpectedConditions.visibilityOf(dashletDialog));
		Assert.assertEquals(searchWidet.isEnabled(), true);
		Assert.assertEquals(searchButton.getAttribute("value"), prop.getProperty("HomeDashletSearchButtonLabel"));
		Assert.assertEquals(clearButton.getAttribute("value"), prop.getProperty("HomeDashletClearButtonLabel"));
		Assert.assertEquals(searchButton.isDisplayed(), true);
		Assert.assertEquals(clearButton.isDisplayed(), true);
		Assert.assertEquals(tapNameWidget1.getText(), prop.getProperty("tapNameWidget1"));
		Assert.assertEquals(tapNameWidget2.getText(), prop.getProperty("tapNameWidget2"));
		list = driver.findElements(By.xpath(
				".//div[@class='yui-panel-container yui-dialog shadow']//div[@id='moduleDashletsList']//tbody//tr//td"));
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }

		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), " " + prop.getProperty("Module" + i));
		}
		Assert.assertEquals(list.size(), Integer.parseInt(prop.getProperty("Modules")));
		searchButton.click();
		global_Obj.wait(driver).until(ExpectedConditions.visibilityOf(searchResult));

		// To scroll till any element
		global_Obj.jsReturn(driver).executeScript("arguments[0].scrollIntoView();", searchResult);
		Assert.assertEquals(searchResult.getText(), prop.getProperty("SearchResult"));
		global_Obj.jsReturn(driver).executeScript("arguments[0].scrollIntoView();", searchWidet);
		searchWidet.sendKeys(prop.getProperty("SearchModule"));
		searchButton.click();
		global_Obj.wait(driver).until(ExpectedConditions.visibilityOf(searchResult));
		global_Obj.jsReturn(driver).executeScript("arguments[0].scrollIntoView();", searchResult);
		global_Obj.wait(driver).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='searchResults']//h4//i")));
		Assert.assertEquals(searchResult.getText(), prop.getProperty("SearchResult2"));
		Assert.assertEquals(searchResult2.getText(), prop.getProperty("SearchModule"));
		Assert.assertEquals(searchResult2.isDisplayed(), true);
		Assert.assertEquals(addLabel.getText().replace(" ", ""), prop.getProperty("AddLabel"));
		Assert.assertEquals(moduleLabel.getText(), prop.getProperty("ModuleLabel"));
		if (searchWidet.getAttribute("value").isEmpty() == false)
		{
			searchWidet.clear();
			Assert.assertEquals(searchWidet.getText().isEmpty(), true);
		}

		tapNameWidget2.click();
		global_Obj.wait(driver).until(ExpectedConditions.visibilityOf(basicChartlabel));
		Assert.assertEquals(basicChartlabel.getText().replaceFirst(" ", ""), prop.getProperty("BasicChartlabel"));
		list = driver.findElements(By.xpath(".//div[@id='basicChartDashletsList']//tr//td//a[2]"));
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }
		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), prop.getProperty("BasicChart" + i));
		}
		Assert.assertEquals(list.size(), Integer.parseInt(prop.getProperty("BasicChartSize")));
		searchButton.click();
		global_Obj.wait(driver).until(ExpectedConditions.visibilityOf(basicChartSearchResult));
		Assert.assertEquals(basicChartSearchResult.getText(), prop.getProperty("SearchResultChart"));
		tapNameWidget2.click();
		searchWidet.sendKeys(prop.getProperty("SearchBasicChart"));
		searchButton.click();
		global_Obj.wait(driver).until(ExpectedConditions.visibilityOf(basicChartSearchResult2));
		Assert.assertEquals(basicChartSearchResult.getText(), prop.getProperty("SearchBasicChartResult"));
		if (searchWidet.getAttribute("value").isEmpty() == false)
		{
			searchWidet.clear();
			Assert.assertEquals(searchWidet.getText().isEmpty(), true);
		}
		closeWidget.click();
	}


	public void colorCheck()
	{
		Assert.assertEquals(redColor.getCssValue("color"), prop.getProperty("TextColor"));
		Assert.assertEquals(bottomText1.getCssValue("color"), prop.getProperty("BottomTextColor"));
		Assert.assertEquals(bottomText2.getCssValue("color"), prop.getProperty("BottomTextColor"));
		Assert.assertEquals(link1.getCssValue("color"), prop.getProperty("LinkColor"));
		Assert.assertEquals(topText1.getCssValue("color"), prop.getProperty("LinkColor"));
		Assert.assertEquals(topText2.getCssValue("color"), prop.getProperty("LinkColor"));
		Assert.assertEquals(topText3.getCssValue("color"), prop.getProperty("LinkColor"));
		Assert.assertEquals(lastViewText.getCssValue("color"), prop.getProperty("LastViewColor"));
	}


	public void checkUserNameOnHomePage()
	{
		topText1.click();
		global_Obj.wait(driver).until(ExpectedConditions.visibilityOf(getUserName));
		userNameOnUserPage = getUserName.getText();
		driver.navigate().back();
		global_Obj.wait(driver).until(ExpectedConditions.visibilityOf(getHomeUserName));
		// System.out.println(getHomeUserName.getText());
		// System.out.println(Prop.getProperty("Welcome") + " " + UserNameOnUserPage + "
		// ! " + Prop.getProperty("Logout"));
		Assert.assertEquals(getHomeUserName.getText(),
				prop.getProperty("Welcome") + " " + userNameOnUserPage + " !  " + prop.getProperty("Logout"));
	}


	public void waitLoader()
	{
		global_Obj.wait(driver)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[@id='ajaxloading_mask']")));
	}


	public void closeBrowser()
	{
		driver.close();
	}
}
