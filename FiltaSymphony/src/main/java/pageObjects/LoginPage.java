package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Properties;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import util.Global;
//import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	private WebDriver driver;
	private Properties Prop;
	private Global global;

	public LoginPage() {
		global = new Global();
		driver = global.driver();
		Prop = global.readProperties();
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ".//select[@name='login_language']")
	private WebElement Language;

	@FindBy(how = How.XPATH, using = ".//div[@id='footer']")
	private WebElement Footer;

	@FindBy(how = How.XPATH, using = ".//div[@class='login']//tbody//tr[3]//td")
	private WebElement Textmessage;

	public void dropDown() {
		List<WebElement> list = driver.findElements(By.xpath(".//select[@name='login_language']//option"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}

		assertEquals(list.get(0).getText(), Prop.getProperty("english"));
		assertEquals(list.get(1).getText(), Prop.getProperty("german"));

	}
	
	public void checkText() {
		System.out.println("Footer => " + Footer.getText());
	}

	public void checkText2() {

		assertEquals(Textmessage.getText(), Prop.getProperty("TextLoginPage"));
	}

	public void checkURL() {

	}

	public void closebrowser() {
		driver.close();
	}
	/*
	 * private Select select(WebElement element) { Select select = new
	 * Select(element); return select; }
	 */
}
