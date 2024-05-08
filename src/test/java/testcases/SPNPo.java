package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class SPNPo extends BaseTest {

	@Test(dataProviderClass = ReadXLSdata.class, dataProvider = "POTest")
	public static void POPositiveTest(String SrNo, String TestCondition, String Purchase_OrderNo, String PO_Date,
			String Supplier_Name, String Delivery_Date, String MOD, String P_Name, String P_PhoneNo, String P_Unit,
			String P_StreetNo, String P_StreetName, String P_StreetType, String P_Suburb, String P_postcode,
			String P_State, String W_WHType, String W_WHName, String State, String Installer, String Remarks,
			String MailSubject, String CustomerRemarks, String CustomerName, String InvoiceDate, String PartType,
			String Brand, String PartName, String PartNumber, String Quantity) throws Exception {
		// ExcelDataProvider Excel=new ExcelDataProvider();

		driver.findElement(By.xpath(loc.getProperty("App_Loging_username"))).sendKeys("spnadministrator");
		driver.findElement(By.xpath(loc.getProperty("App_Loging_password"))).sendKeys("password");
		driver.findElement(By.className(loc.getProperty("App_Loging_Signin_Button"))).click();

		driver.findElement(By.xpath(loc.getProperty("Stockregistermenu"))).click();

		driver.findElement(By.xpath(loc.getProperty("Purchaseordermenu"))).click();

		// Click on Add purchase order button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("Add_PO_Button")))).click();

		driver.findElement(By.id(loc.getProperty("Supplier_Name"))).sendKeys(Keys.chord(Supplier_Name));
		driver.findElement(By.id(loc.getProperty("Delivery_Date"))).click();
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-default')]")).click();
		driver.findElement(By.id(loc.getProperty("State"))).sendKeys(Keys.chord(Keys.ARROW_DOWN, State));
		driver.findElement(By.id(loc.getProperty("MOD"))).sendKeys(Keys.chord(Keys.ARROW_DOWN, MOD));
		driver.findElement(By.id(loc.getProperty("P_Name"))).sendKeys(P_Name);
		driver.findElement(By.id(loc.getProperty("P_PhoneNo"))).sendKeys(P_PhoneNo);
		driver.findElement(By.id(loc.getProperty("P_Unit"))).sendKeys(P_Unit);
		driver.findElement(By.id(loc.getProperty("P_StreetNo"))).sendKeys(P_StreetNo);
		driver.findElement(By.id(loc.getProperty("P_StreetName"))).sendKeys(P_StreetName);
		driver.findElement(By.id(loc.getProperty("P_StreetType"))).sendKeys(Keys.chord(Keys.ARROW_DOWN, P_StreetType));
		driver.findElement(By.id(loc.getProperty("P_Suburb"))).sendKeys(P_Suburb);
		driver.findElement(By.id(loc.getProperty("P_postcode"))).sendKeys(P_postcode);
		driver.findElement(By.id(loc.getProperty("P_State"))).sendKeys(Keys.ARROW_DOWN, P_State);

		driver.findElement(By.id(loc.getProperty("PartType"))).sendKeys(Keys.chord(Keys.DOWN, PartType));
		driver.findElement(By.id(loc.getProperty("Brand"))).sendKeys(Keys.chord(Keys.DOWN, Brand));
		driver.findElement(By.id(loc.getProperty("PartName"))).sendKeys(Keys.chord(Keys.DOWN, PartName));
		driver.findElement(By.id(loc.getProperty("Quantity"))).sendKeys("10");
		driver.findElement(By.xpath(loc.getProperty("AddButton"))).click();

		// Thread.sleep(5000);
		
		
		
		
		// Alert -Are you sure you want to save without remark?
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		// Alert - Are you sure you want to save without customer remark?
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		// Alert -Select Supplier
		driver.switchTo().alert().accept();
			
		String supname = driver.findElement(By.id(loc.getProperty("Supplier_Name"))).getAccessibleName();
		if(supname == " " ) {
			System.out.println(supname);
			
		} else
		{
			System.out.println("Select Supplier");
		}
		 //Assert.assertNotNull(driver.findElement(By.id(loc.getProperty("Supplier_Name"))).getAttribute("value"));

		// WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		// wait1.until(ExpectedConditions.elementToBeSelected(By.id(loc.getProperty("Purchase_OrderNo"))));

		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[@id='viewPanelDetails']")));
		 Thread.sleep(5000);

		 System.out.println(driver.findElement(By.xpath(loc.getProperty("Purchase_OrderNo"))).getAttribute("value"));
		 Assert.assertNotNull(driver.findElement(By.xpath(loc.getProperty("Purchase_OrderNo"))).getAttribute("value"));

	}

}
