package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Global {
	private Properties prop;
	private FileInputStream input;
	private static int count = 1;
	private String Workspace = "Home";

	// Driver Initialization Method !!
	public WebDriver driver() {
		// ChromeOption will Disable Password Save Popup In Chrome
		prop = readProperties();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-web-security");
		options.addArguments("--no-proxy-server");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities capablities = new DesiredCapabilities();
		capablities.setCapability(ChromeOptions.CAPABILITY, options);
		capablities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		System.setProperty("webdriver.chrome.driver", prop.getProperty("driver"));
		WebDriver driver = new ChromeDriver(capablities);
		driver.get(prop.getProperty("URL2"));
		driver.manage().window().maximize();
		return driver;
	}

	public Properties readProperties() {
		Properties Prop = readProperties2();
		if (Workspace.equals(Prop.getProperty("Work"))) {
			File f = new File("C:\\Users\\Kunal\\git\\repository\\FiltaSymphony\\configs\\Configuration.properties");
			try {
				input = new FileInputStream(f);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			prop = new Properties();
			try {
				prop.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return prop;
		} else {
			File f = new File("C:\\Users\\Kunal\\git\\repository\\FiltaSymphony\\Configuration.properties");
			try {
				input = new FileInputStream(f);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			prop = new Properties();
			try {
				prop.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return prop;
		}
	}

	public Properties readProperties2() {
		File f = new File("C:\\Users\\Kunal\\git\\repository\\FiltaSymphony\\src\\main\\resources\\path.properties");
		try {
			input = new FileInputStream(f);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public void screenShot(WebDriver driver) {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File f = screen.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f, new File("E:\\Msite\\MobileApp\\ScreenShots\\Screen" + count + ".png"));
			count++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebElement driverWait(WebDriver driver, String Xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
		return element;
	}

	public WebDriverWait wait(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 2500);
		return wait;
	}

	public String getString(WebDriver driver, String Xpath) {
		String text = driver.findElement(By.xpath(Xpath)).getText();
		return text;
	}

	public String getStringElement(WebElement element) {
		String text = element.getText();
		return text;
	}

	public void click(WebDriver driver, String Xpath) {
		driver.findElement(By.xpath(Xpath)).click();
	}

	public void send(WebDriver driver, String Xpath, String Value) {
		driver.findElement(By.xpath(Xpath)).sendKeys(Value);
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public void sendElementKey(WebElement element, String Text) {
		element.sendKeys(Text);
	}

	public void sendElement(WebDriver driver, String Xpath, String Text) {
		driver.findElement(By.xpath(Xpath)).sendKeys(Text);
	}

	public void sleepMethod() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("We are in Catch Block !!");
			e.printStackTrace();
		}
	}

	public String url(WebDriver driver) {
		String URL = driver.getCurrentUrl();
		return URL;
	}

	public boolean enabled(WebElement element) {
		boolean result = element.isEnabled();
		return result;
	}

	public void linkText(WebDriver driver, String Text) {
		driver.findElement(By.linkText(Text)).click();
	}

	public WebElement webElementReturn(WebDriver driver, String Xpath) {
		WebElement element = driver.findElement(By.xpath(Xpath));
		return element;
	}

	public String getAttributes(WebElement element, String value) {
		String text = element.getAttribute(value);
		return text;
	}

	public void clearText(WebDriver driver, String Xpath) {
		driver.findElement(By.xpath(Xpath)).clear();
	}

	public String alert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String Message = alert.getText();
		alert.accept();
		return Message;
	}
}
