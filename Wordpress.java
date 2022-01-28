package Selenium1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Wordpress {
    // Napraviti program koji ce se ulogovati na wordpress i proveriti da li se korisnik ulogovao

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement emailBox = driver.findElement(By.xpath("//*[@id=\"usernameOrEmail\"]"));
        emailBox.click();
        emailBox.sendKeys("sarastankovic023@gmail.com");
        Thread.sleep(2000);

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div/div/form/div[1]/div[2]/button"));
        continueButton.click();
        Thread.sleep(2000);

        WebElement passwordBox = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordBox.click();
        passwordBox.sendKeys("Qwerty123");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div/div/form/div[1]/div[2]/button"));
        loginButton.click();
        Thread.sleep(2000);

        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        String excpetedURL = "https://wordpress.com/read";

        Assert.assertEquals(actualURL, excpetedURL);

        WebElement profile = driver.findElement(By.xpath("//*[@id=\"header\"]/a[3]/span/img"));
        profile.click();
        Thread.sleep(2000);

         String actualUsername = driver.findElement(By.xpath("//*[@id=\"secondary\"]/ul/li/div[1]/h2")).getText();
         String expectedUsername = "sarastankovic22";

         Assert.assertEquals(actualUsername, expectedUsername);
         
    }
}
