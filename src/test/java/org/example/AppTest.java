package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        System.setProperty("webdriver.chrome.driver", "/home/adarshs/selenium_jars_drivers/drivers/cromedriver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();



        // Maximize the browser window
        driver.manage().window().maximize();

        System.out.println("in");
        // Navigate to the Investing.com login page
        driver.get("https://www.investing.com");

        // Click on the "Sign In" link
        System.out.println("in");
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        System.out.println("out");
        signInLink.click();

        // Enter username and password
        WebElement usernameField = driver.findElement(By.id("loginFormUser_email"));
        WebElement passwordField = driver.findElement(By.id("loginForm_password"));

        usernameField.sendKeys("sadarshgowda@gmail.com");
        passwordField.sendKeys("Pragmatic@123");

        // Click on the login button
        WebElement loginButton = driver.findElement(By.id("signinBtn"));
        loginButton.click();

        // You may need to add some wait time or conditions here
        // to handle page load delays or other factors after clicking the login button

        // Close the browser
        driver.quit();
    }
    }

