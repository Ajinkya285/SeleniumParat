package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIsElementPresent
{
	public static WebDriver driver;

	public static boolean isElementPresent(String xpath)
	{
		try
		{
			driver.findElement(By.xpath(xpath));
			return true;

		} catch (Exception e)
		{
			return false;
		}

	}

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println(isElementPresent("//*[@id='identifierId12']"));

	}

}
