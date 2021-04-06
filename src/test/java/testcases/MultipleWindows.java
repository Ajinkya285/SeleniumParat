package testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows
{

	public static WebDriver driver;
	
	public static void switchToWindowIndex(int index) {
	    Set<String> windowHandles = driver.getWindowHandles();
	    List<String> windowStrings = new ArrayList<String>(windowHandles);
	    String reqWindow = windowStrings.get(index);
	    driver.switchTo().window(reqWindow);
	}
	
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String parentwin = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//button[text()='New Tab']")).click();
		driver.findElement(By.xpath("//button[text()='New Window']")).click();
		driver.findElement(By.xpath("//button[text()='New Window Message']")).click();
		
		
		
		switchToWindowIndex(1);
		
		driver.get("https://www.google.co.in/");
	
	}

}
