package Selenium1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Youtube {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.navigate().to("https://www.youtube.com/");
        driver.manage().window().maximize();
        wdwait.until(ExpectedConditions.urlToBe("https://www.youtube.com/"));

        WebElement searchBox = driver.findElement(By.name("search_query")); 
        searchBox.sendKeys("Rick Astley - Never Gonna Give You Up");


        WebElement search = driver.findElement(By.id("search-icon-legacy"));
        search.click();

        wdwait.until(ExpectedConditions.elementToBeClickable(By.linkText("Rick Astley - Never Gonna Give You Up (Official Music Video)")));
        WebElement song = driver.findElement(By.linkText("Rick Astley - Never Gonna Give You Up (Official Music Video)"));
        song.click();

    }
}
