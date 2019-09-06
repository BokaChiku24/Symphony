package com.filta.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Global
{
	private WebDriver Driver;
	private TakesScreenshot Screen;
	private WebElement Element;
	private JavascriptExecutor Js;
	private Alert Alert_Obj;
	private Select Select_Obj;
	private Actions Action;
	private WebDriverWait Wait;
	private File F;
	private File File_Obj;
	private File File_;
	private ChromeOptions Options;
	private Properties Prop;
	private FileInputStream Input;
	private String Text;
	private String Message;
	private String URL;
	private boolean Result;
	private static int count = 1;


	// Driver Initialization Method !!
	public WebDriver driver()
	{
		// ChromeOption will Disable Password Save Popup In Chrome
		Prop = readProperties();
		Options = new ChromeOptions();
		Options.addArguments("--start-maximized");
		Options.addArguments("--disable-web-security");
		Options.addArguments("--no-proxy-server");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		Options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities capablities = new DesiredCapabilities();
		capablities.setCapability(ChromeOptions.CAPABILITY, Options);
		capablities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		System.setProperty("webdriver.chrome.driver", Prop.getProperty("driver"));
		Driver = new ChromeDriver(capablities);
		Driver.get(Prop.getProperty("URL2"));
		Driver.manage().window().maximize();
		return Driver;
	}


	public Properties readProperties()
	{
		F = new File("E:\\Work\\Symphony\\FiltaSymphony\\configs\\Configuration.properties");
		File_Obj = new File(
				"C:\\Users\\kunal\\git\\Repository\\FiltaSymphony\\configs\\OfficeConfiguration.properties");
		File_ = new File(
				"C:\\Users\\Boka_Chiku\\git\\Symphony\\FiltaSymphony\\configs\\HomePC_Configuration.properties");
		if (F.exists() == true)
		{
			try
			{
				Input = new FileInputStream(F);

			}
			catch (FileNotFoundException E)
			{
				// TODO Auto-generated catch block
				E.printStackTrace();
			}
			Prop = new Properties();
			try
			{
				Prop.load(Input);
			}
			catch (IOException E)
			{
				E.printStackTrace();
			}
			return Prop;
		}
		else if (File_Obj.exists() == true)
		{

			try
			{
				Input = new FileInputStream(File_Obj);

			}
			catch (FileNotFoundException E)
			{
				// TODO Auto-generated catch block
				E.printStackTrace();
			}
			Prop = new Properties();
			try
			{
				Prop.load(Input);
			}
			catch (IOException E)
			{
				E.printStackTrace();
			}
			return Prop;
		}
		else if (File_.exists() == true)
		{
			try
			{
				Input = new FileInputStream(File_);

			}
			catch (FileNotFoundException E)
			{
				// TODO Auto-generated catch block
				E.printStackTrace();
			}
			Prop = new Properties();
			try
			{
				Prop.load(Input);
			}
			catch (IOException E)
			{
				E.printStackTrace();
			}
		}
		return Prop;

	}


	public void screenShot(WebDriver Driver)
	{
		Screen = (TakesScreenshot) Driver;
		F = Screen.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(F, new File("E:\\Msite\\MobileApp\\ScreenShots\\Screen" + count + ".png"));
			count++;
		}
		catch (IOException E)
		{
			// TODO Auto-generated catch block
			E.printStackTrace();
		}
	}


	public WebElement driverWait(WebDriver Driver, String Xpath)
	{
		Wait = new WebDriverWait(Driver, 30);
		Element = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
		return Element;
	}


	public Select select(WebElement Element)
	{
		Select_Obj = new Select(Element);
		return Select_Obj;
	}


	public WebDriverWait wait(WebDriver Driver)
	{
	     Wait = new WebDriverWait(Driver, 2500);
		return Wait;
	}


	public String getString(WebDriver Driver, String Xpath)
	{
		Text = Driver.findElement(By.xpath(Xpath)).getText();
		return Text;
	}


	public String getStringElement(WebElement Element)
	{
		Text = Element.getText();
		return Text;
	}


	public void click(WebDriver Driver, String Xpath)
	{
		Driver.findElement(By.xpath(Xpath)).click();
	}


	public void send(WebDriver Driver, String Xpath, String Value)
	{
		Driver.findElement(By.xpath(Xpath)).sendKeys(Value);
	}


	public void clickElement(WebElement Element)
	{
		Element.click();
	}


	public void sendElementKey(WebElement Element, String Text)
	{
		Element.sendKeys(Text);
	}


	public void sendElement(WebDriver Driver, String Xpath, String Text)
	{
		Driver.findElement(By.xpath(Xpath)).sendKeys(Text);
	}


	public void sleepMethod()
	{
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			System.out.println("We are in Catch Block !!");
			e.printStackTrace();
		}
	}


	public void implicityWait(WebDriver Driver)
	{
		Driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}


	public String url(WebDriver Driver)
	{
		URL = Driver.getCurrentUrl();
		return URL;
	}


	public boolean enabled(WebElement Element)
	{
		Result = Element.isEnabled();
		return Result;
	}


	public void linkText(WebDriver Driver, String Text)
	{
		Driver.findElement(By.linkText(Text)).click();
	}


	public WebElement webElementReturn(WebDriver Driver, String Xpath)
	{
		Element = Driver.findElement(By.xpath(Xpath));
		return Element;
	}


	public String getAttributes(WebElement Element, String Value)
	{
		Text = Element.getAttribute(Value);
		return Text;
	}


	public void clearText(WebDriver Driver, String Xpath)
	{
		Driver.findElement(By.xpath(Xpath)).clear();
	}


	public String alert(WebDriver Driver)
	{
		Alert_Obj = Driver.switchTo().alert();
		Message = Alert_Obj.getText();
		Alert_Obj.accept();
		return Message;
	}


	public void alertAccept(WebDriver Driver)
	{
		Alert_Obj = Driver.switchTo().alert();
		Alert_Obj.accept();

	}


	public Actions action(WebDriver Driver)
	{
		Action = new Actions(Driver);
		return Action;
	}


	public String alert(String Input, WebDriver Driver)
	{
		Alert_Obj = Driver.switchTo().alert();
		Message = Alert_Obj.getText();
		if (Input.equalsIgnoreCase("accept"))
			Alert_Obj.accept();
		else if (Input.equalsIgnoreCase("dismiss"))
			Alert_Obj.dismiss();
		return Message;
	}


	public JavascriptExecutor jsReturn(WebDriver Driver)
	{
		Js = (JavascriptExecutor) Driver;
		return Js;
	}


	
}
