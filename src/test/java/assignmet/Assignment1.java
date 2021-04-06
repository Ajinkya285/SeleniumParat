package assignmet;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1
{

	public static void main(String[] args)
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("name")).sendKeys("Dilip");
		driver.findElement(By.name("phone")).sendKeys("9833928594");
		driver.findElement(By.name("email")).sendKeys("ajinkyadc@gmail.com");

		WebElement dropdown = driver.findElement(By.xpath("//*[@id='load_form']/fieldset[4]/select"));
		Select select = new Select(dropdown);
		select.selectByValue("Belize");
		
		List<WebElement> values = driver.findElements(By.tagName("option"));
		System.out.println("Total no of countrys are : " + values.size());
		
		for (int i = 0; i < values.size(); i++)
		{
			System.out.println(values.get(i).getAttribute("value"));
		}
		
		driver.findElement(By.name("city")).sendKeys("Dombivli");
		driver.findElement(By.xpath("//*[@id='load_form']/fieldset[6]/input")).sendKeys("ajnkyaD");
		driver.findElement(By.xpath("//*[@id='load_form']/fieldset[7]/input")).sendKeys("qwertyuiop");
		driver.findElement(By.xpath("//form[@class='ajaxsubmit']/div/div[2]/input")).click();
		
		driver.quit();

	}

}
