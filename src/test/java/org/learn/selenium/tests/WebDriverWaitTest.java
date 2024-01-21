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

public class WebDriverWaitTest {

    WebDriver driver;
    Duration duration;
    WebDriverWait webDriverWait;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        duration = Duration.ofSeconds(10);

        webDriverWait = new WebDriverWait(driver, duration);
    }

    @Test(priority = 0, description = "Test implicit wait in selenium")
    public void implicitWait(){


        //Implicit Wait is set globally for the entire duration of the WebDriver instance,
        // it means that the wait time specified will be applicable to all subsequent WebDriver commands throughout the life of that WebDriver instance.
        driver.manage().timeouts().implicitlyWait(duration);

        driver.get("https://www.saucedemo.com/");

        // Wait for the username field to be visible and interactable
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        // Find the password field and enter the password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        // Find and click the login button
        WebElement login = driver.findElement(By.name("login-button"));
        login.click();

        // Add assertions to verify successful login and title
        WebElement productsHeader = driver.findElement(By.className("title"));
        assert productsHeader.getText().equals("Products");
    }


    @Test(priority = 1, description = "Test explicit wait in selenium")
    public void explicitWait(){

        driver.get("https://www.saucedemo.com/");

        // Wait for the username field to be visible and interactable
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        // Find the password field and enter the password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        // Find and click the login button
        WebElement login = driver.findElement(By.name("login-button"));
        login.click();

        //explicit wait condition
        WebElement productsHeader = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        assert productsHeader.getText().equals("Products");

        // Add assertions to verify successful login and title
        //WebElement productsHeader = driver.findElement(By.className("title"));
    }
}
