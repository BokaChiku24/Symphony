package pageObjects_HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import helper.HomePage_Interface;
import util.Login;
import java.util.List;
import java.util.Properties;
import util.Global;

public class HomePage implements HomePage_Interface {

	private Global global;
	private WebDriver driver;
	private Properties Prop;
	private Login login;

	public HomePage(WebDriver driver) {
		global = new Global();
		Prop = global.readProperties();
		this.driver = driver;
		login = new Login(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ".//select[@name='login_language']")
	private WebElement Language;

	public void login() {
		login.credentials();
	}

	public void menuBar() {
		List<WebElement> list = driver.findElements(By.xpath(
				".//div[@id='ajaxHeader']//div[@class='menubar']//div[@id='moduleList']//ul[@class='last']/li//span/a"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}

	}

	public void closeBrowser() {
		driver.close();
	}
}
