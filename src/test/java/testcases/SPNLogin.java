package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class SPNLogin extends BaseTest {

	@Test(dataProviderClass=ReadXLSdata.class,dataProvider="LoginTest")
	public static void LoginTest(String username, String password) throws InterruptedException {
		System.out.println("Clicked Successfully");
		driver.findElement(By.xpath(loc.getProperty("App_Loging_username"))).sendKeys(username);
		driver.findElement(By.xpath(loc.getProperty("App_Loging_password"))).sendKeys(password);
		driver.findElement(By.className(loc.getProperty("App_Loging_Signin_Button"))).click();
		System.out.println("Login Successfully");
		String ActualTitle = driver.findElement(By.className(loc.getProperty("SPN_Dashboard_Title"))).getText();
		System.out.println(ActualTitle);
		//String ExpectedTitle = "My Jobs";
		//Assert.assertEquals(ExpectedTitle, ActualTitle);
	}

}
