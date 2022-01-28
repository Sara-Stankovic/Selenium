package Selenium1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DemoQA {
    //Ulogovati se na sajt https://demoqa.com/ preko kolacica, izlogovati se i asertovati da je korisnik izlogovan

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);


        Cookie userid = new Cookie("userid", "463f47f6-38ed-45e2-b021-66151235294f");
        driver.manage().addCookie(userid);

        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InNhcmEiLCJwYXNzd29yZCI6IlF3ZXJ0eTEyMyFAIyIsImlhdCI6MTY0MjI0ODQyMn0.JbAzf0ya1zfsTo-X4TFQZrwLD9JnGMzP9UfuwHZBRIA");
        driver.manage().addCookie(token);

        Cookie expires = new Cookie("expires","2022-01-22T12%3A36%3A03.231Z");
        driver.manage().addCookie(expires);
        driver.navigate().refresh();


        Thread.sleep(2000);


        //testovi za login
        String expectedURL = "https://demoqa.com/login";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

        WebElement logoutButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        Assert.assertTrue(logoutButton.isDisplayed());

        //logout
        logoutButton.click();
        Thread.sleep(2000);

        //testovi za logout
        String expURL = "https://demoqa.com/login";
        String actURL = driver.getCurrentUrl();
        Assert.assertEquals(expURL, actURL);

        String expextedHeader = "Login";
        String actualHeader = driver.findElement(By.className("main-header")).getText();
        Assert.assertEquals(expextedHeader, actualHeader);

        WebElement loginButton = driver.findElement(By.id("login"));
        Assert.assertTrue(loginButton.isDisplayed());
    }
}
