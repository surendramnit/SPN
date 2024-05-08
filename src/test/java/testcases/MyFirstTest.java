package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://phpstack-440501-1567461.cloudwaysapps.com/index.php/staff/login/do");
		//driver.findElement(By.name("username")).sendKeys("spnadministrator");
		//driver.findElement(By.name("password")).sendKeys("password");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("spnadministrator");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
		
		
		driver.findElement(By.className("bigger-110")).click();
		System.out.println("Login Successfully");
		String Messaage = driver.findElement(By.className("pageTitle")).getText();
		System.out.println(Messaage);
	}

}
