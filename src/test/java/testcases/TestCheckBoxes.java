package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckBoxes
{

	public static WebDriver driver;

	public static boolean isElementPresent(By by)
	{

		try
		{
			driver.findElement(by);
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

		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/*
		 * this for normal
		 * 
		 * for (int i = 1; i <= 4; i++) {
		 * driver.findElement(By.xpath("//div[4]/input[" + i + "]")).click(); }
		 * 
		 * 
		 */

		/*
		 * for dynamic checkbox to click
		 * 
		 * int i = 1; int count = 0;
		 * 
		 * while (isElementPresent(By.xpath("//div[4]/input[" + i + "]"))) {
		 * 
		 * driver.findElement(By.xpath("//div[4]/input[" + i + "]")).click();
		 * i++; count++; }
		 * 
		 * System.out.println("total no of checkbox are :" + count);
		 */

		WebElement section = driver.findElement(By.xpath("//table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));

		List<WebElement> checkboxes = section.findElements(By.name("sports"));
		System.out.println("Total no of checkboxes are :" + checkboxes.size());

		for (WebElement checkbox : checkboxes)
		{
			checkbox.click();

		}

		driver.quit();
	}

}
