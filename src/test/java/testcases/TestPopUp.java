package testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPopUp
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://way2automation.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		 Set<String> winids = driver.getWindowHandles();
		Iterator<String> iterator = winids.iterator();

		String first_window = iterator.next();
		System.out.println(first_window);

		driver.findElement(By.xpath("//*[@id='wrapper']/header/div[2]/div/div[2]/div/a[1]")).click();

		winids = driver.getWindowHandles();
		iterator = winids.iterator();

		System.out.println(iterator.next());
		String second_window = iterator.next();
		System.out.println(second_window);

		driver.switchTo().window(second_window);

		driver.findElement(By.id("user_email")).sendKeys("ajinkyadc@gmail.com");

		try
		{
			Thread.sleep(3000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();

		driver.switchTo().window(first_window);
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();

	}

}
