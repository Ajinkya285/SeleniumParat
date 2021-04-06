package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties
{
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(TestProperties.class.getName());
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	
	public static void click(String key) {

		if (key.endsWith("_XPATH")) 
		{

			driver.findElement(By.xpath(OR.getProperty(key))).click();
		}
		else if (key.endsWith("_ID")) 
		{

			driver.findElement(By.id(OR.getProperty(key))).click();
		}
		else if (key.endsWith("_CSS")) 
		{

			driver.findElement(By.cssSelector(OR.getProperty(key))).click();
		}

		log.info("Clicking on an Element: " + key);

	}

	public static void type(String key, String value) 
	{

		if (key.endsWith("_XPATH")) 
		{

			driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
		}
		else if (key.endsWith("_ID")) 
		{

			driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
		}
		else if (key.endsWith("_CSS")) 
		{

			driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
		}

		log.info("Typing in an Element: " + key+" entered the value as : "+value);

	}
	
	public static void main(String[] args) throws IOException
	{
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\log4j.properties");
		
//		Properties OR = new Properties();
//		Properties Config = new Properties();
		
		FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis1);
		log.info("OR Properties loaded");
		
		FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		Config.load(fis2);
		log.info("Config Properties loaded");
		
		System.out.println(OR.getProperty("username_ID"));
		System.out.println(Config.getProperty("testsiteurl"));
		
		if (Config.getProperty("browser").equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("chrome driver launched !!!");
		}
		else if (Config.getProperty("browser").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("firefox driver launched !!!");
		} 
		
		driver.get(Config.getProperty("testsiteurl"));
		log.info("navigated to the Site :" + Config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(OR.getProperty("implicit.wait")), TimeUnit.SECONDS);
		
		driver.findElement(By.id(OR.getProperty("username_ID"))).sendKeys("trainer@way2automation.com");
		log.info("Entering username : trainer@way2automation.com" );
		driver.findElement(By.xpath(OR.getProperty("nextbtn_XPATH"))).click();
		log.info("Clicking on next button" );
		
		try
		{
			Thread.sleep(3500);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		log.info("Test execution completed !!!" );
	}

}
