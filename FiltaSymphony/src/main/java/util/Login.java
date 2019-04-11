package util;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login
{
	public WebDriver driver;
	private Global global;
	private Properties prop;

	@FindBy(how = How.XPATH, using = ".//input[@id='user_name']")
	private WebElement UserName;

	@FindBy(how = How.XPATH, using = ".//input[@id='user_password']")
	private WebElement Password;

	@FindBy(how = How.XPATH, using = ".//input[@id='login_button']")
	private WebElement Log_In;


	public Login(WebDriver driver)
	{
		this.driver = driver;
		global = new Global();
		prop = global.readProperties();
		PageFactory.initElements(driver, this);

	}


	public void credentials()
	{
		// prop = global.readProperties();
		UserName.sendKeys(prop.getProperty("uname"));
		Password.sendKeys(prop.getProperty("password"));
		Log_In.click();
	}
}
