package util;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class logIn {
	public WebDriver driver;
	private Global global;
	private Properties prop;

	public WebDriver url() {
		global = new Global();
		driver = global.driver();
		return driver;
	}

	public WebDriver credentials() {
		url();
		prop = global.readProperties();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//input[@placeholder='User Name' and @ng-model='username']")));
		element.sendKeys(prop.getProperty("UserName"));
		WebElement element2 = driver
				.findElement(By.xpath(".//input[@placeholder='Password' and @ng-model='password']"));
		element2.sendKeys(prop.getProperty("Password"));
		WebElement element3 = driver.findElement(By.xpath(".//button[@ng-href='#/dashboard' and @href='#/dashboard']"));
		element3.click();
		return driver;

	}
}
