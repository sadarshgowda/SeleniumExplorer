package org.learn.selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebElementAttributeFetcher {

    private WebDriver driver;
    Duration duration;
    WebDriverWait webDriverWait;

    @BeforeMethod
    public void setUpMethod() {

        // Setup WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Optional: Maximize the browser window
        driver.manage().window().maximize();

        duration = Duration.ofSeconds(10);

        webDriverWait = new WebDriverWait(driver, duration);
    }

    @Test(priority = 0, description = "test to get the attribute of element")
    public void elementAttributeFetcher(){

        try {

            driver.get("https://www.saucedemo.com/");

            // Wait for the username field to be visible and interactable
            WebElement userName = driver.findElement(By.id("user-name"));
            userName.sendKeys("standard_user");

            // Find the password field and enter the password
            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("secret_sauce");

            // Find and click the login button
            WebElement login = driver.findElement(By.id("login-button"));
            login.click();

            // Add assertions to verify successful login and title
            WebElement productsHeader = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
            assert productsHeader.getText().equals("Products");

            // get the attribute form web element of add to cart
            WebElement cartElement = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
            System.out.println("getting class name " + cartElement.getAttribute("class"));
            System.out.println("getting text of cart element " + cartElement.getText());
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
}
