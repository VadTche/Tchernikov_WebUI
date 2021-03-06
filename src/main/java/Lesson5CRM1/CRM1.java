package Lesson5CRM1;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CRM1 {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";
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
    static JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    public static void main(String[] args) {
        
        login();

        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@id='main-menu']")));

        builder.moveToElement(driver.findElement(By.xpath(".//li[@class='dropdown']/a[@class='unclickable']" +
                        "/span[text()='Проекты']")))
                .moveToElement(driver.findElement(By.xpath(".//*[@class='title' and text()='Мои проекты']")))
                .click()
                .build()
                .perform();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Создать проект")));
        driver.findElement(By.linkText("Создать проект")).click();

        Faker faker = new Faker();
        String firstName = faker.name().firstName();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@class='controls']/input[@type='text']")));
        driver.findElement(By.xpath(".//div[@class='controls']" +
                "/input[@type='text']")).sendKeys(firstName);

        driver.findElement(By.xpath(".//*[@class='select2-chosen' and text()='Укажите организацию']")).click();

        driver.findElement(By.xpath(".//div[@class='select2-search']" +
                "/input[@class='select2-input select2-focused']")).sendKeys("Tesla.com");

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[@class='select2-match' and text()='Tesla.Com']")));
        driver.findElement(By.xpath(".//span[@class='select2-match' and text()='Tesla.Com']")).click();

        driver.findElement(By.xpath(".//select[@name='crm_project[businessUnit]']" +
                "/option[text()='Research & Development']")).click();

        driver.findElement(By.xpath(".//select[@name='crm_project[curator]']" +
                "/option[text()='Амелин Владимир']")).click();

        driver.findElement(By.xpath(".//select[@name='crm_project[rp]']" +
                "/option[text()='Воденеев Денис']")).click();

        driver.findElement(By.xpath(".//select[@name='crm_project[manager]']" +
                "/option[text()='Исаева Анастасия']")).click();

        driver.findElement(By.xpath(".//div[@class='btn-group']" +
                "/button[@class='btn btn-success action-button']")).click();

        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.textToBePresentInElementLocated
                        (By.xpath(".//div[@class='flash-messages-holder']"), ("Проект сохранен")));
        driver.findElement(By.xpath(".//div[@class='flash-messages-holder']"));

        driver.close();
        driver.quit();
    }

    private static void login() {

        driver.get(LOGIN_PAGE_URL);

        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id='prependedInput']")));
        driver.findElement(By.cssSelector("input[id='prependedInput']")).sendKeys(STUDENT_LOGIN);

        ArrayList<WebElement> elements = (ArrayList<WebElement>) jsExecutor
                .executeScript("return document.getElementsByName('_password')");
        WebElement passwordTextInput = elements.get(0);
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();
    }
}