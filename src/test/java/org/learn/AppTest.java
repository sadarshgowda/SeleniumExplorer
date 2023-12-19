package org.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

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


        // Navigate to the Investing.com login page
        // Navigate to investing.com
        driver.get("https://demoqa.com/");
        System.out.println("in");
        // Find and click on the 'Login' link (or button) to open the login form
        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();

        // Find the username and password fields and input credentials
        WebElement usernameField = driver.findElement(By.id("loginFormUser_email"));
        usernameField.sendKeys("your_username");

        WebElement passwordField = driver.findElement(By.id("loginForm_password"));
        passwordField.sendKeys("your_password");

        // Find and click the 'Login' button to submit the credentials
        WebElement submitButton = driver.findElement(By.id("loginForm_btn"));
        submitButton.click();


        driver.quit();
    }
    }

