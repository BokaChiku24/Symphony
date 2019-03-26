package pageObjects;

import java.util.List;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;


public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ".//select[@name='login_language']")
	private WebElement Language;

	@FindBy(how = How.XPATH, using = ".//div[@id='footer']")
	private WebElement Footer;
	
	public void dropDown() {
		List<WebElement> list = driver.findElements(By.xpath(".//select[@name='login_language']//option"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
		
		//assertCheck(list.get(0).getText(), configFileReader.english());
		//assertCheck(list.get(1).getText(), configFileReader.german());

	}

	public void assertCheck(String ActualMessage, String ExpectedMessage) {
	//	Assert.assertEquals(ActualMessage, ExpectedMessage);
	}

	public void checkText() {
		System.out.println("Footer => " + Footer.getText());
	}
	public void checkURL() {
	
	}
	
	/*
	 * private Select select(WebElement element) { Select select = new
	 * Select(element); return select; }
	 */
}
