package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestJavaScriptExecutor
{
	public static WebDriver driver;
	
	public static void captureScreenshoot() throws IOException
	{
		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		File screenshoot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshoot, new File(".//screenshot//" + filename));
		
	}
	public static void main(String[] args) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.switchTo().frame("iframeResult");
		((JavascriptExecutor) driver).executeScript("myFunction()");
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.id("mySubmit")));
		
		captureScreenshoot();
		
		
		 
		
		
		
	}

}
