package pageObjects_LoginPage;

import org.testng.Assert;

import helper.LoginPage_Interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import util.Global;

public class LoginPage implements LoginPage_Interface
{
	private WebDriver driver;
	private Properties Prop;
	private Global global;

	@FindBy(how = How.XPATH, using = ".//select[@name='login_language']")
	private WebElement Language;

	@FindBy(how = How.XPATH, using = ".//div[@id='footer']")
	private WebElement Footer;

	@FindBy(how = How.XPATH, using = ".//div[@class='login']//tbody//tr[3]//td")
	private WebElement Textmessage;

	@FindBy(how = How.XPATH, using = ".//a[@href='LICENSE.txt' and text()='AGPLv3']")
	private WebElement link1;

	@FindBy(how = How.XPATH, using = ".//a[@href='LICENSE.txt' and text()=' GNU Affero General Public License version 3']")
	private WebElement link2;

	@FindBy(how = How.XPATH, using = ".//input[@id='user_name']")
	private WebElement Uname;

	@FindBy(how = How.XPATH, using = ".//input[@id='user_password']")
	private WebElement Pword;

	@FindBy(how = How.XPATH, using = ".//label[@for='user_name']")
	private WebElement Uname_Label;

	@FindBy(how = How.XPATH, using = ".//label[@for='user_password']")
	private WebElement Pword_Label;

	@FindBy(how = How.XPATH, using = ".//tbody//tr[7]//td[@scope='row']")
	private WebElement Language_Label;

	@FindBy(how = How.XPATH, using = ".//input[@title='Log In']")
	private WebElement Login_Label;


	public LoginPage(WebDriver driver)
	{
		global = new Global();
		this.driver = driver;
		Prop = global.readProperties();
		PageFactory.initElements(driver, this);
	}


	public void dropDown()
	{
		List<WebElement> list = driver.findElements(By.xpath(".//select[@name='login_language']//option"));
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i).getText());
		}
		Assert.assertEquals(list.get(0).getText(), Prop.getProperty("english"));
		Assert.assertEquals(list.get(1).getText(), Prop.getProperty("german"));
		Assert.assertEquals(list.size(), Integer.parseInt(Prop.getProperty("LanguageSize")));
		Assert.assertEquals(global.select(Language).getFirstSelectedOption().getText(), Prop.getProperty("english"));
	}


	public void checkText()
	{
		if (Footer.getText().startsWith("Server response time") && Footer.getText().endsWith(
				"All other company and product names may be trademarks of the respective companies with which they are associated."))
		{
			System.out.println("Footer Test Pass ");
		}
	}


	public void checkText2()
	{

		Assert.assertEquals(Textmessage.getText(), Prop.getProperty("TextLoginPage"));
	}


	public void checkURL()
	{
		link1.click();
		ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handles.get(1));
		Assert.assertEquals(driver.getCurrentUrl(), Prop.getProperty("CheckURL1"));
		closebrowser();
		driver.switchTo().window(handles.get(0));
		link2.click();
		ArrayList<String> handles2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handles2.get(1));
		Assert.assertEquals(driver.getCurrentUrl(), Prop.getProperty("CheckURL2"));
		closebrowser();
		driver.switchTo().window(handles2.get(0));

	}


	public void checkTextBoxAssert()
	{
		Assert.assertEquals(Uname.isEnabled(), true);
		Assert.assertEquals(Pword.isEnabled(), true);
	}


	public void checktextBoxLabel()
	{
		Assert.assertEquals(Uname_Label.getText(), Prop.getProperty("LoginUnameLabel"));
		Assert.assertEquals(Pword_Label.getText(), Prop.getProperty("LoginPwordLabel"));
		Assert.assertEquals(Language_Label.getText(), Prop.getProperty("LoginLanguageLabel"));
		Assert.assertEquals(Login_Label.getAttribute("value"), Prop.getProperty("LoginLabel"));
	}


	public void closebrowser()
	{
		driver.close();
	}

}
