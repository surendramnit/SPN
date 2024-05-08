package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class youtubepromo {


    public static void main(String[] args) {
        int numberOfTimes = 100;

        for (int i = 0; i < numberOfTimes; i++) {
        	youtube();
        	System.out.println(i);
        }
    }
	
	//Empowering wellness: https://youtu.be/Cmk6hV5gd-M
    //Wearable Tech  Beyond Fitness Tracking: https://youtu.be/-9h4yGE2Z_8
    //The Future of Wearable Devices: https://youtu.be/ZGt93NXBKfU
	public static void youtube() {
		// TODO Auto-generated method stub
		System.setProperty("WebDriver.chrome.Driver",
				"D:\\Work\\Selenium\\chrome-headless-shell-win64\\chrome-headless-shell.exe");
      
		// Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Open YouTube
        driver.get("https://www.youtube.com");
		//driver.get("https://youtu.be/3NJur6LceJk");-- airpod

		try {
            // Locate the search input field and enter the video URL
            WebElement searchBox = driver.findElement(By.name("search_query"));
            searchBox.sendKeys("https://youtu.be/ZGt93NXBKfU");

            // Submit the search form
            searchBox.submit();

            // Wait for search results to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement videoLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#video-title")));

            // Click on the video link to start playing
            videoLink.click();

            // Wait for the video to finish (you can adjust the wait time based on video length)
            Thread.sleep(20000); // Wait for 30 seconds assuming a typical video length

            // Alternatively, you can use more sophisticated logic to detect when the video has finished
            // For example, check if the video player's state indicates it has ended

            // Close the browser
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }
    }
}