package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlighthubOneWayTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("WebDriver.chrome.Driver",
				"D:\\Work\\Selenium\\chrome-headless-shell-win64\\chrome-headless-shell.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().refresh();
				driver.get("https://www.flighthub.com/");
		//Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[contains(@class,'one-way')]")).click();
		driver.findElement(By.xpath("(//input[@name='seg0_from'])[1]")).click();
		driver.findElement(By.xpath("(//span[contains(@class,'fa fa-close')])[1]")).click();
		driver.findElement(By.xpath("(//input[@name='seg0_from'])[1]")).sendKeys(Keys.chord("Jai",Keys.ENTER));
		

		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//input[@name='seg0_from'])[1]")).sendKeys(Keys.chord(Keys.CLEAR,"Jaipur",Keys.ENTER));	
		driver.findElement(By.xpath("(//input[@name='seg0_to'])[1]")).sendKeys(Keys.chord("Mumbai",Keys.TAB));
		
		driver.findElement(By.xpath("(//input[@name='seg0_date'])[1]")).click();
		driver.findElement(By.xpath("(//td[@data-handler='selectDay'])[15]")).click();
		driver.findElement(By.id("hotel-checkbox")).click();
		driver.findElement(By.id("btn-search-flight")).click();
		//driver.findElement(By.xpath("(//input[@name='seg0_date'])[1]")).click();
		//driver.findElement(By.xpath("//td[@class=' price_none ' and @data-month='5' ]//a[@class='ui-state-default'][normalize-space()='10']")).click();
	}

}
