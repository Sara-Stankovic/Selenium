package Selenium1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AmazonKorpa {

    public static void main(String[] args) throws InterruptedException {
        //Napisati test koji ce vrsiti proveru dodavanja knjige u korpu i da ce brisanjem cookie-a knjiga biti oduzeta iz korpe

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();
        Thread.sleep(2000);


        String cartAdded = driver.findElement(By.id("nav-cart-count")).getText();
        String cartEmpty = "0";
        Assert.assertNotEquals(cartAdded, cartEmpty);


        //brisanje
        driver.manage().deleteCookieNamed("session-id");
        driver.navigate().refresh();

        String cartNew = driver.findElement(By.id("nav-cart-count")).getText();
        Assert.assertEquals(cartEmpty, cartNew);
    }

}
