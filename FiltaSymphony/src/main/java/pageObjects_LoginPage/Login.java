package pageObjects_LoginPage;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import util.Global;

public class Login {
	WebDriver driver;
	Global global;
	private Properties Prop;

	public Login() {
		global = new Global();
		driver = global.driver();
		PageFactory.initElements(driver, this);
		Prop = global.readProperties();
	}

	@FindBy(how = How.XPATH, using = ".//input[@id='user_name']")
	private WebElement UserName;

	@FindBy(how = How.XPATH, using = ".//input[@id='user_password']")
	private WebElement Password;

	@FindBy(how = How.XPATH, using = ".//input[@id='login_button']")
	private WebElement Log_In;

	@FindBy(how = How.XPATH, using = ".//div[@class='login']//tbody//tr[2]")
	private WebElement ErrorMessage;

	public void enterUserName(String Username) {
		UserName.sendKeys(Username);
	}

	public void enterPassword(String password) {
		Password.sendKeys(password);
	}

	public void clickSubmit() {
		Log_In.click();
	}

	public void assertCheck() {
		String actualMsg = driver.getCurrentUrl();
		Assert.assertEquals(actualMsg, Prop.getProperty("URLAssert"));
	}

	public void assertCheck2() {
		global.wait(driver)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='login']//tbody//tr[2]")));
		String actualMsg = ErrorMessage.getText();
		Assert.assertEquals(actualMsg, Prop.getProperty("Validation1"));
	}

	public void clearText() {
		UserName.clear();
		Password.clear();
	}
	public void driverClose() {
		driver.close();
	}
}
