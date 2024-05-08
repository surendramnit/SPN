package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MMTLogin {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("WebDriver.chrome.Driver",
				"D:\\Work\\Selenium\\chrome-headless-shell-win64\\chrome-headless-shell.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.get("https://www.Makemytrip.com");
		// Thread.sleep(5000);
		WebElement iframeElement = driver
				.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-frame']"));

		// So we handle the iframe then

		driver.switchTo().frame(iframeElement);

		WebElement popupwindow = driver.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-close-div']"));

		List<WebElement> popupSize = driver.findElements(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-close-div']"));

		/*if (popupSize > 0)

		{

			popupwindow.click();

		}*/
	}

}
