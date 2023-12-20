package org.learn.selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class BrowserNavigation {
    private WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        // Setup WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        driver = new ChromeDriver();
        // Optional: Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void browserNavigationToUrl(){
        // Navigate to a webpage
        driver.get("https://www.google.com");

        driver.navigate().to("https://www.facebook.com");

        // Close the browser
        driver.quit();
    }

    @Test(priority = 1)
    public void browserNavigationForwardAndBackward() throws Exception {

        Duration timeout = Duration.ofSeconds(10);

        WebDriverWait wait = new WebDriverWait(driver, timeout);

        // Navigate to a webpage
        driver.get("https://www.google.com");

        // Wait for the page title to contain "Google"
        wait.until(ExpectedConditions.titleContains("Google"));

        //navigate to a different web page
        driver.navigate().to("https://www.facebook.com");

        // Wait for the page title to contain "Facebook"
        wait.until(ExpectedConditions.titleContains("Facebook"));

        // Navigate back to the first URL
        driver.navigate().back();

        // Wait for the page title to contain "Google" after navigating back
        wait.until(ExpectedConditions.titleContains("Google"));

        //refresh the current page
        driver.navigate().refresh();

        // Navigate forward to the second URL
        driver.navigate().forward();

        // Wait for the page title to contain "Facebook" after navigating forward
        wait.until(ExpectedConditions.titleContains("Facebook"));

        // Close the browser
        driver.quit();
    }
}
