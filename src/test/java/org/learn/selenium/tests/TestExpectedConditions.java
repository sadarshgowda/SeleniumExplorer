package org.learn.selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestExpectedConditions {

    WebDriverWait webDriverWait;
    WebDriver driver;
    Duration duration;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        duration = Duration.ofSeconds(10);

        webDriverWait = new WebDriverWait(driver, duration);
    }


    @Test
    public void testElementToBeClickable(){
        driver.get("https://www.saucedemo.com/");

        // Wait for the username field to be visible and interactable
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        // Find the password field and enter the password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        //checking whether page loaded completely
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));


    }

    @Test
    public void testVisibilityOfElement(){
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

        //checking whether page loaded completely
        WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));


    }

    @Test
    public void testPresenceOfText(){
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

        //checking whether page loaded completely
        WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name")));
        assert element.getText().equals("Sauce Labs Backpack");


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();;
    }
}
