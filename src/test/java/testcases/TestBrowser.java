package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowser
{
	public static String browser = "chrome";

	public static WebDriver driver;

	public static void main(String[] args)
	{
		if (browser.equals("chrome"))
		{

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (browser.equals("firefox"))
		{

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		driver.get("http://gmail.com");
		driver.manage().window().maximize();

		String title = driver.getTitle();
		int length = title.length();
		System.out.println(length);
		System.out.println(title);

		try
		{
			Thread.sleep(5000);
		} catch (InterruptedException e)
		{
			
			e.printStackTrace();
		}

		driver.close();

	}

}
