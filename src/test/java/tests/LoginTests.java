package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginNegativeTests {
    private WebDriver driver;

    @Before
    public void setUp() {


        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app/search");
    }

    @Test
    public void testInvalidLogin() {
        WebElement loginField = driver.findElement(By.id("login"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));


        loginField.sendKeys("wrongUser");
        passwordField.sendKeys("wrongPassword");
        loginButton.click();


        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testEmptyLogin() {
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));


        passwordField.sendKeys("somePassword");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testEmptyPassword() {
        WebElement loginField = driver.findElement(By.id("login"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));


        loginField.sendKeys("someUser");
        loginButton.click();


        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testSpacesInFields() {
        WebElement loginField = driver.findElement(By.id("login"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));


        loginField.sendKeys("   ");
        passwordField.sendKeys("   ");
        loginButton.click();


        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

