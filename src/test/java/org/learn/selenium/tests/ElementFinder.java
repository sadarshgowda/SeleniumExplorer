package org.learn.selenium.tests;

import graphql.Assert;
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
import java.util.List;

public class ElementFinder {

    private WebDriver driver;
    Duration duration;
    WebDriverWait webDriverWait;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 0, description = "test to find element by id")
    public void findByIdNameAndClassName(){

        try {

            driver.get("https://www.saucedemo.com/");

            // Wait for the username field to be visible and interactable
            WebElement userName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
            userName.sendKeys("standard_user");

            // Find the password field and enter the password
            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("secret_sauce");

            // Find and click the login button
            WebElement login = driver.findElement(By.className("submit-button btn_action"));
            login.click();

            // Add assertions to verify successful login and title
            WebElement productsHeader = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
            assert productsHeader.getText().equals("Products");

        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 1, description = "test to find elements")
    public void findElements(){

        try {

            driver.get("https://www.saucedemo.com/");

            // Wait for the username field to be visible and interactable
            WebElement userName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
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


            // Find multiple elements by a specific locator
            List<WebElement> elementsByClassName = driver.findElements(By.className("inventory_item"));

            // Get the count of found elements
            int countOfElements = elementsByClassName.size();
            System.out.println("Number of elements found: " + countOfElements);

            // Loop through found elements and perform actions
            for (WebElement element : elementsByClassName) {
                // Perform actions with each element
                System.out.println("Text of element: " + element.getText());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDownMethod() {
        // Close the browser after each test method
        driver.quit();
    }
}
