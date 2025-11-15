package com.example;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleTest {

	@Test
    public void openGoogleTest() {
        // WebDriverManager will download proper chromedriver at runtime
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.google.com");
            String title = driver.getTitle();
            Assert.assertTrue(title.toLowerCase().contains("google"));
        } finally {
            driver.quit();
            System.out.print("Quit");
        }
    }
	
}
