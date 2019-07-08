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

	private WebDriver Driver;
	private Global Global_Obj;
	private Properties Prop;
	private Login Login;
	private StringBuffer BottomTextReplace;
	private String UserNameOnUserPage;

	@FindBy(how = How.XPATH, using = ".//select[@name='login_language']")
	private WebElement Language;

	@FindBy(how = How.LINK_TEXT, using = "Symphony Training on FiltaNet")
	private WebElement Link;

	@FindBy(how = How.XPATH, using = ".//div[@class='main-wrapper clearfix']//div[@class='left-panel'][2]//div[@class='left-panel-national'][3]//ul//li")
	private WebElement Tech;

	@FindBy(how = How.XPATH, using = ".//div[@class='main-wrapper clearfix']//div[@class='left-panel'][3]//div[@class='left-panel-national'][2]//ul//li")
	private WebElement Filtagold;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_marketing_summery']//h1")
	private WebElement Email_summary;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_marketing_summery']//div[@style='font-style: italic;']")
	private WebElement Email_summary2;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_marketing_summery']//span[@id='last-updated']")
	private WebElement Email_summary3;

	@FindBy(how = How.XPATH, using = ".//a[@href='https://sites.google.com/a/filta.com/opsmanual/filta-symphony']")
	private WebElement HomeText;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DNotes%26action%3DEditView%26return_module%3DNotes%26return_action%3DDetailView']")
	private WebElement NoteToolTip;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DLeads%26action%3DEditView%26return_module%3DLeads%26return_action%3DDetailView']")
	private WebElement LeadToolTip1;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DTasks%26action%3DEditView%26return_module%3DTasks%26return_action%3DDetailView']")
	private WebElement LeadToolTip2;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DCalls%26action%3DEditView%26return_module%3DCalls%26return_action%3DDetailView']")
	private WebElement LeadToolTip3;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DNotes%26action%3DEditView%26return_module%3DNotes%26return_action%3DDetailView']")
	private WebElement LeadToolTip4;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DFL_New_Oil_Inventory%26action%3DEditView%26return_module%3DFL_New_Oil_Inventory%26return_action%3DDetailView']")
	private WebElement FiltagoldToolTip;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DAccounts%26action%3Dfrindex%26parentTab%3DCustomers']")
	private WebElement Customerlabel;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DIM_NCA%26action%3Dindex%26parentTab%3DNCA']")
	private WebElement NCALabel;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DLeads%26action%3Ddashletlist%26parentTab%3DLeads']")
	private WebElement Leadlabel;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DFL_Filtabio%26action%3Dindex%26parentTab%3DFiltaBio']")
	private WebElement FiltaBiolabel;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DTR_Leads%26action%3Dindex%26parentTab%3DTRS']")
	private WebElement Techhiringlabel;

	@FindBy(how = How.XPATH, using = ".//a[@href='#']")
	private WebElement FiltaGoldlabel;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?module=IM_NCA&action=frindex']")
	private WebElement MyFranchiseelabel;

	@FindBy(how = How.XPATH, using = ".//a[@href='index.php?module=Home&action=index&type=widget']")
	private WebElement HomeDashletlabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='main']//div[@id='content']//tr/td//div[@id='pageNum_0_div'][1]/table/tbody/tr[1]/td[3]/span[5]/a[2]")
	private WebElement HomeDashletlabel2;

	@FindBy(how = How.XPATH, using = ".//div[@id='main']//div[@id='content']//tr/td//div[@id='pageNum_0_div'][1]/table/tbody/tr[1]/td[3]/span[1]")
	private WebElement HomeDashletlabel3;

	@FindBy(how = How.XPATH, using = ".//div[@id='dashletsDialog']")
	private WebElement DashletDialog;

	@FindBy(how = How.XPATH, using = ".//input[@id='search_string']")
	private WebElement SearchWidet;

	@FindBy(how = How.XPATH, using = ".//input[@value='Search']")
	private WebElement SearchButton;

	@FindBy(how = How.XPATH, using = ".//input[@value='Clear']")
	private WebElement ClearButton;

	@FindBy(how = How.XPATH, using = ".//a[@id='moduleCategoryAnchor']")
	private WebElement TapNameWidget1;

	@FindBy(how = How.XPATH, using = ".//a[@id='chartCategoryAnchor']")
	private WebElement TapNameWidget2;

	@FindBy(how = How.XPATH, using = ".//div[@id='searchResults']//h4")
	private WebElement SearchResult;

	@FindBy(how = How.XPATH, using = ".//div[@id='searchResults']//h4//i")
	private WebElement SearchResultTwo;

	@FindBy(how = How.XPATH, using = ".//a[@class='mbLBLL' and text()='1k Reported Volumes']")
	private WebElement SearchResult2;

	@FindBy(how = How.XPATH, using = ".//div[@id='dashletsDialogHeader']")
	private WebElement AddLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='moduleDashlets']//h3")
	private WebElement ModuleLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='chartDashlets']//h3")
	private WebElement BasicChartlabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='searchResults']//h4")
	private WebElement BasicChartSearchResult;

	@FindBy(how = How.XPATH, using = ".//div[@id='searchResults']//h4//i")
	private WebElement BasicChartSearchResult2;

	@FindBy(how = How.XPATH, using = ".//div[@class='container-close']")
	private WebElement CloseWidget;

	@FindBy(how = How.XPATH, using = ".//p[@class='error']")
	private WebElement RedColor;

	@FindBy(how = How.XPATH, using = ".//div[@id='bottomLinks']//a[1 and text()=' Print']")
	private WebElement BottomText1;

	@FindBy(how = How.XPATH, using = ".//div[@id='bottomLinks']//a[2 and text()=' Back to top']")
	private WebElement BottomText2;

	@FindBy(how = How.XPATH, using = ".//a[@href='LICENSE.txt' and text()='AGPLv3']")
	private WebElement Link1;

	@FindBy(how = How.XPATH, using = ".//a[@href='LICENSE.txt' and text()=' GNU Affero General Public License version 3']")
	private WebElement Link2;

	@FindBy(how = How.XPATH, using = ".//a[@id='user_link_link']")
	private WebElement TopText1;

	@FindBy(how = How.XPATH, using = ".//a[@id='filtastore_link']")
	private WebElement TopText2;

	@FindBy(how = How.XPATH, using = ".//a[@id='admin_link']")
	private WebElement TopText3;

	@FindBy(how = How.XPATH, using = ".//div[@id='ajaxHeader']//div[@id='lastView']//b")
	private WebElement LastViewText;

	@FindBy(how = How.XPATH, using = ".//div[@class='moduleTitle']//h2")
	private WebElement GetUserName;

	@FindBy(how = How.XPATH, using = ".//div[@class='user']")
	private WebElement GetHomeUserName;


	public HomePage(WebDriver Driver)
	{
		Global_Obj = new Global();
		Prop = Global_Obj.readProperties();
		this.Driver = Driver;
		Login = new Login(Driver);
		PageFactory.initElements(Driver, this);
	}


	public void login()
	{
		Login.credentials();
	}


	public void menuBar()
	{
		List<WebElement> list = Driver.findElements(By.xpath(
				".//div[@id='ajaxHeader']//div[@class='menubar']//div[@id='moduleList']//ul[@class='last']/li//span/a"));

		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }

		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), Prop.getProperty("FranchiseeMenu" + i));
		}
	}


	public void urlCheck()
	{
		Driver.get(
				"https://dev.filtasymphony.com/index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DHome%26action%3Dindex%26type%3Dmenu");
		waitLoader();
		Link.click();
		ArrayList<String> Array = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(Array.get(1));
		Assert.assertEquals(Driver.getCurrentUrl(), Prop.getProperty("HomeURL"));
		Driver.close();
		Driver.switchTo().window(Array.get(0));
	}


	public void customers()
	{
		Driver.get(
				"https://dev.filtasymphony.com/index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DHome%26action%3Dindex%26type%3Dmenu");
		waitLoader();
		List<WebElement> list = Driver.findElements(By.xpath(
				".//div[@class='left-panel'][1]//div[@class='left-panel-national'][1]//div[@class='left-panel-national-block-link clearfix']//ul//li"));

		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }

		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), Prop.getProperty("FranchiseeCustomerMenuScreen" + i));
		}
	}


	public void leads()
	{
		List<WebElement> list = Driver.findElements(By.xpath(
				".//div[@class='left-panel'][1]//div[@class='left-panel-national'][2]//div[@class='left-panel-national-block-link clearfix']//ul//li"));

		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }

		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), Prop.getProperty("FranchiseeLeadsMenuScreen" + i));
		}
	}


	public void nca()
	{
		List<WebElement> list = Driver.findElements(By.xpath(
				".//div[@class='main-wrapper clearfix']//div[@class='left-panel'][2]//div[@class='left-panel-national'][1]//ul//li"));

		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }

		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), Prop.getProperty("FranchiseeNCAMenuScreen" + i));
		}
	}


	public void filtaBio()
	{
		List<WebElement> list = Driver.findElements(By.xpath(
				".//div[@class='main-wrapper clearfix']//div[@class='left-panel'][2]//div[@class='left-panel-national'][2]//ul//li"));

		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }

		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), Prop.getProperty("FranchiseeFiltaBioMenuScreen" + i));
		}
	}


	public void techHiring()
	{
		Assert.assertEquals(Tech.getText(), Prop.getProperty("FranchiseeTechMenuScreen0"));

	}


	public void myFranchisee()
	{
		List<WebElement> list = Driver.findElements(By.xpath(
				".//div[@class='main-wrapper clearfix']//div[@class='left-panel'][3]//div[@class='left-panel-national'][1]//ul//li"));
		//
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }

		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), Prop.getProperty("MyFranchiseeMenuScreen" + i));
		}
	}


	public void filtaGold()
	{
		Assert.assertEquals(Filtagold.getText(), Prop.getProperty("FiltaGoldMenuScreen"));

	}


	public void checkText()
	{
		Assert.assertEquals(Email_summary.getText(), Prop.getProperty("HomeText1"));
		Assert.assertEquals(Email_summary2.getText(), Prop.getProperty("HomeText2"));
		Assert.assertEquals(Email_summary3.getText(), Prop.getProperty("HomeText3"));
		Assert.assertEquals(HomeText.getText(), Prop.getProperty("HomeText4"));
		Assert.assertEquals(Customerlabel.getText(), Prop.getProperty("HomeCustomerLabel"));
		Assert.assertEquals(NCALabel.getText(), Prop.getProperty("HomeNCALabel"));
		Assert.assertEquals(Leadlabel.getText(), Prop.getProperty("HomeLeadLabel"));
		Assert.assertEquals(FiltaBiolabel.getText(), Prop.getProperty("HomeFiltaBioLabel"));
		Assert.assertEquals(Techhiringlabel.getText(), Prop.getProperty("HomeTechLabel"));
		Assert.assertEquals(FiltaGoldlabel.getText(), Prop.getProperty("HomeFiltaGoldlabel"));
		Assert.assertEquals(MyFranchiseelabel.getText(), Prop.getProperty("HomeMyFranchiseelabel"));
		Assert.assertEquals(HomeDashletlabel.getText(), Prop.getProperty("HomeDashletlabel"));
		Assert.assertEquals(BottomText1.getText().replace(" ", ""), Prop.getProperty("BttomText"));
		BottomTextReplace = new StringBuffer(BottomText2.getText());
		Assert.assertEquals(BottomTextReplace.replace(0, 0, "").toString(), Prop.getProperty("BttomText2"));
		Assert.assertEquals(TopText1.getText(), Prop.getProperty("topText1"));
		Assert.assertEquals(TopText2.getText(), Prop.getProperty("topText2"));
		Assert.assertEquals(TopText3.getText(), Prop.getProperty("topText3"));
		Assert.assertEquals(LastViewText.getText(), Prop.getProperty("lastViewText") + "  ");
	}


	public void tableTest()
	{
		List<WebElement> list = Driver.findElements(By.xpath(".//table[@id='campaignerData']//tbody//tr"));
		List<WebElement> list2 = Driver.findElements(By.xpath(".//table[@id='campaignerData']//tbody//tr[1]//th"));
		Global_Obj.wait(Driver).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//table[@id='campaignerData']//tbody//tr")));
		Assert.assertEquals(list.size(), Integer.parseInt(Prop.getProperty("HomeTable1Rows")));
		Assert.assertEquals(list2.size(), Integer.parseInt(Prop.getProperty("HomeTable1Column")));

		// for (int i = 0; i < list2.size(); i++) {
		// if (i != 0)
		// System.out.println(list2.get(i).getText());
		// }

		// Checks the Column Names
		for (int i = 0; i < list2.size(); i++)
		{
			if (i != 0)
			{
				Assert.assertEquals(list2.get(i).getText(), Prop.getProperty("Hometable1ColumnHeading" + i));
			}
		}

		// Checks the Row Names
		for (int i = 2; i < list.size(); i++)
		{
			Assert.assertEquals(
					Driver.findElement(By.xpath(".//table[@id='campaignerData']//tbody//tr[" + i + "]//td[1]"))
							.getText(),
					Prop.getProperty("HomeTabale1RowName" + i));
		}

		// Checks Table Column Data
		for (int i = 2; i < list.size(); i++)
		{
			Assert.assertEquals(
					Driver.findElement(By.xpath(".//table[@id='campaignerData']//tbody//tr[" + i + "]//td[2]"))
							.getText(),
					Prop.getProperty("HomeTableRow1Data"));
			Assert.assertEquals(
					Driver.findElement(By.xpath(".//table[@id='campaignerData']//tbody//tr[" + i + "]//td[3]"))
							.getText(),
					Prop.getProperty("HomeTableRow1Data"));
			Assert.assertEquals(
					Driver.findElement(By.xpath(".//table[@id='campaignerData']//tbody//tr[" + i + "]//td[4]"))
							.getText(),
					Prop.getProperty("HomeTableRow1Data"));
		}
	}


	public void toolTipCheck()
	{
		Assert.assertEquals(NoteToolTip.getAttribute("title"), Prop.getProperty("HomeCustomerTooltip"));
		Assert.assertEquals(LeadToolTip1.getAttribute("title"), Prop.getProperty("HomeLeadTooltip1"));
		Assert.assertEquals(LeadToolTip2.getAttribute("title"), Prop.getProperty("HomeLeadTooltip2"));
		Assert.assertEquals(LeadToolTip3.getAttribute("title"), Prop.getProperty("HomeLeadTooltip3"));
		Assert.assertEquals(LeadToolTip4.getAttribute("title"), Prop.getProperty("HomeLeadTooltip4"));
		Assert.assertEquals(FiltagoldToolTip.getAttribute("title"), Prop.getProperty("HomeFiltaGoldToolTip1"));
	}


	public void widgetTesting()
	{
		Driver.get("https://dev.filtasymphony.com/index.php?module=Home&action=index&type=widget");
		Assert.assertEquals(HomeDashletlabel2.getText(), Prop.getProperty("HomeDashletlabel2"));
		Assert.assertEquals(HomeDashletlabel2.isDisplayed(), true);
		Assert.assertEquals(HomeDashletlabel3.getText(), Prop.getProperty("HomeDashletlabel3"));
		Assert.assertEquals(HomeDashletlabel3.isDisplayed(), true);
		HomeDashletlabel2.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(DashletDialog));
		Assert.assertEquals(SearchWidet.isEnabled(), true);
		Assert.assertEquals(SearchButton.getAttribute("value"), Prop.getProperty("HomeDashletSearchButtonLabel"));
		Assert.assertEquals(ClearButton.getAttribute("value"), Prop.getProperty("HomeDashletClearButtonLabel"));
		Assert.assertEquals(SearchButton.isDisplayed(), true);
		Assert.assertEquals(ClearButton.isDisplayed(), true);
		Assert.assertEquals(TapNameWidget1.getText(), Prop.getProperty("tapNameWidget1"));
		Assert.assertEquals(TapNameWidget2.getText(), Prop.getProperty("tapNameWidget2"));
		List<WebElement> list = Driver.findElements(By.xpath(
				".//div[@class='yui-panel-container yui-dialog shadow']//div[@id='moduleDashletsList']//tbody//tr//td"));
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }

		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), " " + Prop.getProperty("Module" + i));
		}
		Assert.assertEquals(list.size(), Integer.parseInt(Prop.getProperty("Modules")));
		SearchButton.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(SearchResult));

		// To scroll till any element
		Global_Obj.jsReturn(Driver).executeScript("arguments[0].scrollIntoView();", SearchResult);
		Assert.assertEquals(SearchResult.getText(), Prop.getProperty("SearchResult"));
		Global_Obj.jsReturn(Driver).executeScript("arguments[0].scrollIntoView();", SearchWidet);
		SearchWidet.sendKeys(Prop.getProperty("SearchModule"));
		SearchButton.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(SearchResult));
		Global_Obj.jsReturn(Driver).executeScript("arguments[0].scrollIntoView();", SearchResult);
		Global_Obj.wait(Driver).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='searchResults']//h4//i")));
		Assert.assertEquals(SearchResult.getText(), Prop.getProperty("SearchResult2"));
		Assert.assertEquals(SearchResult2.getText(), Prop.getProperty("SearchModule"));
		Assert.assertEquals(SearchResult2.isDisplayed(), true);
		Assert.assertEquals(AddLabel.getText().replace(" ", ""), Prop.getProperty("AddLabel"));
		Assert.assertEquals(ModuleLabel.getText(), Prop.getProperty("ModuleLabel"));
		if (SearchWidet.getAttribute("value").isEmpty() == false)
		{
			SearchWidet.clear();
			Assert.assertEquals(SearchWidet.getText().isEmpty(), true);
		}

		TapNameWidget2.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(BasicChartlabel));
		Assert.assertEquals(BasicChartlabel.getText().replaceFirst(" ", ""), Prop.getProperty("BasicChartlabel"));
		list = Driver.findElements(By.xpath(".//div[@id='basicChartDashletsList']//tr//td//a[2]"));
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getText());
		// }
		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), Prop.getProperty("BasicChart" + i));
		}
		Assert.assertEquals(list.size(), Integer.parseInt(Prop.getProperty("BasicChartSize")));
		SearchButton.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(BasicChartSearchResult));
		Assert.assertEquals(BasicChartSearchResult.getText(), Prop.getProperty("SearchResultChart"));
		TapNameWidget2.click();
		SearchWidet.sendKeys(Prop.getProperty("SearchBasicChart"));
		SearchButton.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(BasicChartSearchResult2));
		Assert.assertEquals(BasicChartSearchResult.getText(), Prop.getProperty("SearchBasicChartResult"));
		if (SearchWidet.getAttribute("value").isEmpty() == false)
		{
			SearchWidet.clear();
			Assert.assertEquals(SearchWidet.getText().isEmpty(), true);
		}
		CloseWidget.click();
	}


	public void colorCheck()
	{
		Assert.assertEquals(RedColor.getCssValue("color"), Prop.getProperty("TextColor"));
		Assert.assertEquals(BottomText1.getCssValue("color"), Prop.getProperty("BottomTextColor"));
		Assert.assertEquals(BottomText2.getCssValue("color"), Prop.getProperty("BottomTextColor"));
		Assert.assertEquals(Link1.getCssValue("color"), Prop.getProperty("LinkColor"));
		Assert.assertEquals(TopText1.getCssValue("color"), Prop.getProperty("LinkColor"));
		Assert.assertEquals(TopText2.getCssValue("color"), Prop.getProperty("LinkColor"));
		Assert.assertEquals(TopText3.getCssValue("color"), Prop.getProperty("LinkColor"));
		Assert.assertEquals(LastViewText.getCssValue("color"), Prop.getProperty("LastViewColor"));
	}


	public void checkUserNameOnHomePage()
	{
		TopText1.click();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(GetUserName));
		UserNameOnUserPage = GetUserName.getText();
		Driver.navigate().back();
		Global_Obj.wait(Driver).until(ExpectedConditions.visibilityOf(GetHomeUserName));
		// System.out.println(getHomeUserName.getText());
		// System.out.println(Prop.getProperty("Welcome") + " " + UserNameOnUserPage + "
		// ! " + Prop.getProperty("Logout"));
		Assert.assertEquals(GetHomeUserName.getText(),
				Prop.getProperty("Welcome") + " " + UserNameOnUserPage + " !  " + Prop.getProperty("Logout"));
	}


	public void waitLoader()
	{
		Global_Obj.wait(Driver)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[@id='ajaxloading_mask']")));
	}


	public void closeBrowser()
	{
		Driver.close();
	}
}
