package Selenium2;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNGVezba {

    WebDriver driver;
    WebDriverWait wdwait;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @BeforeMethod
    public void pagesetup(){
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
    }

    @Test (priority = 10)
    public void positiveLoginTest() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutButton.isDisplayed());

        String expectedText = "Logged In Successfully";
        String actualText = driver.findElement(By.className("post-title")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test (priority = 20)
    public void negativeLoginTest() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("Student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

        WebElement error = driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());
    }

    @AfterClass
    public void endTest(){
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

}
