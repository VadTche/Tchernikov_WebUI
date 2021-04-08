package Lesson5Collectomania;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Collectomania {

    private static final String MAIN_PAGE_URL = "https://collectomania.ru";
    private static final String USER_LOGIN = "pismonos@mail.ru";
    private static final String USER_PASSWORD = "big7fox";
    private static final WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    static Actions builder = new Actions(driver);

    public static void main(String[] args) throws InterruptedException {
        login();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("search-block")));
        driver.findElement(By.id("search-block")).click();

        driver.findElement(By.name("q")).sendKeys("kiss");
        driver.findElement(By.xpath(".//input[@type='submit']")).click();

        driver.close();
        driver.quit();
    }
    private static void login() throws InterruptedException {
        driver.get(MAIN_PAGE_URL);

        driver.findElement(By.xpath(
                ".//a[@href='#fancybox-login' and text()='Личный кабинет']")).click();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath(".//div[@class='cnv-widget_popup-box']" +
                                "/div[@class='cnv-widget_popup-content']")));

        driver.findElement(By.xpath(".//div[@class='cnv-widget_popup-box']" +
                "/div[@class='cnv-widget_popup-content']" +
                "/div[@class='cnv-widget_popup-close']")).click();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//form[@id='login_form']" +
                        "/input[@class='input-email required']")));

        driver.findElement(By.xpath(".//form[@id='login_form']" +
                "/input[@class='input-email required']")).sendKeys(USER_LOGIN);

        driver.findElement(By.xpath(".//form[@id='login_form']" +
                "/input[@class='input-password required']")).sendKeys(USER_PASSWORD);

        driver.findElement(By.xpath(".//form[@id='login_form']" +
                "/input[@name='commit']")).click();
    }
}
