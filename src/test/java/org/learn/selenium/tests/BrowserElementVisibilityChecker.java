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

public class BrowserElementVisibilityChecker {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(10);

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
    public void isElementDisplayedAndEnabled(){

        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        //Find the search web element
        WebElement searchElement = driver.findElement(By.id("small-searchterms"));

        //check if element is visible
        if (isElementVisible(searchElement)) {
            System.out.println("Element is visible on the web page.");
        } else {
            System.out.println("Element is not visible on the web page.");
        }
        //alternative is searchElement.isVisible()


        //check if element is enable
        if (isElementEnable(searchElement)) {
            searchElement.click(); // Perform click action if the element is enabled
        } else {
            System.out.println("Element is not in an enabled state.");
        }
        //alternative is searchElement.isEnable()

        // Close the browser
        driver.quit();


    }

    private boolean isElementVisible(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver, timeout);

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    private boolean isElementEnable(WebElement element){
       return  element.isEnabled();
    }
}
