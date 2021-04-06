package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHandlingMultipleElement
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://way2automation.com/way2auto_jquery/index.php");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement dropdown = driver.findElement(By.xpath("//*[@id='load_form']/fieldset[4]/select"));
		Select select = new Select(dropdown);
		select.selectByValue("Belize");

		List<WebElement> values = driver.findElements(By.tagName("option"));
		System.out.println("Total no of countrys are : " + values.size());

		// for (int i = 0; i < values.size(); i++)
		// {
		// System.out.println(values.get(i).getAttribute("value"));
		// }

		for (WebElement webElement : values)
		{
			System.out.println(webElement.getText());
		}

		driver.quit();

	}

}
