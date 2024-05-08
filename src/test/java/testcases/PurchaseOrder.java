package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class PurchaseOrder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// invoking Browser
		System.setProperty("WebDriver.chrome.Driver",
				"D:\\Work\\Selenium\\chrome-headless-shell-win64\\chrome-headless-shell.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// provide url
		driver.get("https://phpstack-440501-1567461.cloudwaysapps.com/index.php/staff/login/do");
		// System.out.println(driver.findElement(By.name("header blue
		// lighter")).getText());
		System.out.println(driver.findElement(By.tagName("h4")));

		// Login in application
		driver.findElement(By.name("username")).sendKeys("spnadministrator");
		// driver.findElement(By.name("username")).sendKeys(Keys.TAB);
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[contains(@class,'width')]")).click();
		// Thread.sleep(5000);

		// Purchase order navigation--> click on stock register and Purchase order menu

		driver.findElement(By.xpath("//a[text()='Stock Register']")).click();
		driver.findElement(By.xpath("//a[text()='Purchase Order']")).click();

		// Click on Add purchase order button
		driver.findElement(By.xpath("//a[contains(text(),'Add Purchase Order')]")).click();
		System.out.println(driver.findElement(By.xpath("//form/div[text()='Purchase Order Details']")).getText());

		driver.findElement(By.id("supplier_id")).click();
		driver.findElement(By.xpath("//option[contains(text(),'ASP Solar Pty Ltd')]")).click();

		driver.findElement(By.id("delivery_date")).click();
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-hover')]")).click();
		driver.findElement(By.id("state")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		driver.findElement(By.id("mode_of_delivery")).sendKeys(Keys.chord(Keys.ARROW_DOWN, "Pickup"));
		driver.findElement(By.id("name")).sendKeys("Surendra Babu Kumawat");
		driver.findElement(By.id("phone_no")).sendKeys("9799497218");
		driver.findElement(By.id("unit_no")).sendKeys("2");
		driver.findElement(By.id("street_no")).sendKeys("12");
		driver.findElement(By.id("street")).sendKeys("Jain Mandir ki gali");
		driver.findElement(By.id("street_type")).sendKeys(Keys.chord(Keys.ARROW_DOWN, "CPSE(COPSE)"));
		driver.findElement(By.id("suburb")).sendKeys("suburb");
		driver.findElement(By.id("postal_code")).sendKeys("1254");
		driver.findElement(By.id("address_state")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		
		driver.findElement(By.id("installer_id")).sendKeys(Keys.DOWN, "Aman Dhakla");
		driver.findElement(By.id("remark")).sendKeys("This is first remark");
		driver.findElement(By.id("customer_remark")).sendKeys("This is customer remark");
		driver.findElement(By.id("myInput")).sendKeys("Surendra Chand");
		
		
		driver.findElement(By.id("part_type_id")).sendKeys(Keys.chord(Keys.DOWN, "Inverter"));
		driver.findElement(By.id("brand_id")).sendKeys(Keys.chord(Keys.DOWN, "Jiangsu"));
		driver.findElement(By.id("part_id")).sendKeys(Keys.chord(Keys.DOWN, "6kW"));
		driver.findElement(By.id("quantity")).sendKeys("10");

		driver.findElement(By.xpath("//input[@name='button'][@onclick='AddDetails()']")).click();

		// Alert -Are you sure you want to save without remark?
		//System.out.println(driver.switchTo().alert().getText());
		//driver.switchTo().alert().accept();
		// Alert - Are you sure you want to save without customer remark?
		//System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		//driver.switchTo().alert().accept();
		 

		// String s =
		// driver.findElement(By.xpath("//input[contains(@name,'purchase_order')]")).getAttribute("value");
		// System.out.println(s);
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[@id='viewPanelDetails']")));
		 Thread.sleep(5000);

		 System.out.println(driver.findElement(By.xpath("//input[@id='purchase_order']")).getAttribute("value"));
		 System.out.println("surendra");
		// Assert.assertNotNull(driver.findElement(By.xpath("(//input[@id='purchase_order'])[1]")).getText());
		// Assert.assertNotNull(PONo);
		// Alert -Select Part Type
		// System.out.println(driver.switchTo().alert().getText());
		// driver.switchTo().alert().accept();

	}

}
