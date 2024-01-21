package org.learn.selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BrowserLaunchTest {

    private WebDriver driver;


    @BeforeClass
    public void setUpClass() {
        // Setup WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void setUpTest() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void setUpMethod() {
        // Optional: Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void launchBrowser(){
        // Navigate to a webpage
        driver.get("https://www.google.com");
    }

    @AfterMethod
    public void tearDownMethod() {
        // Close the browser after each test method
        driver.quit();
    }
}
