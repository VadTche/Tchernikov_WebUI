package CRM2Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class crm2Test {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static final Logger logger = LoggerFactory.getLogger(crm2Test.class);
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

    @BeforeAll
    static void beforeAllTests() {
        logger.info("Before all tests");
    }

    @Test
    public void commonWaiterResult () {
        login();

        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@id='main-menu']")));

        builder.moveToElement(driver.findElement((By.xpath(".//li[@class='dropdown first']/a[@class='unclickable']" +
                "/span[text()='Контрагенты']"))))
                .moveToElement(driver.findElement(By.xpath(".//*[@class='title' and text()='Контактные лица']")))
                .click()
                .build()
                .perform();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Создать контактное лицо")));
        driver.findElement(By.linkText("Создать контактное лицо")).click();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@class='controls']" +
                        "/input[@type='text']")));
        driver.findElement(By.xpath(".//div[@class='controls']" +
                "/input[@type='text']")).sendKeys("Роботов");

        driver.findElement(By.xpath(".//div[@class='controls']" +
                "/input[@name='crm_contact[firstName]']")).sendKeys("Робот");

        driver.findElement(By.xpath(".//*[@class='select2-chosen' and text()='Укажите организацию']")).click();

        driver.findElement(By.xpath(".//div[@class='select2-search']" +
                "/input[@class='select2-input select2-focused']")).sendKeys("Tesla.com");

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[@class='select2-match' and text()='Tesla.Com']")));
        driver.findElement(By.xpath(".//span[@class='select2-match' and text()='Tesla.Com']")).click();

        driver.findElement(By.xpath(".//div[@class='controls']" +
                "/input[@name='crm_contact[jobTitle]']")).sendKeys("Менеджер");

        driver.findElement(By.xpath(".//div[@class='btn-group']" +
                "/button[@class='btn btn-success action-button']")).click();

        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.textToBePresentInElementLocated
                        (By.xpath(".//div[@class='flash-messages-holder']"), ("Контактное лицо сохранено")));
        WebElement flash = driver.findElement(By.xpath(".//div[@class='flash-messages-holder']"));
        Assertions.assertTrue(flash.isDisplayed());

        driver.close();
        driver.quit();
    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);

        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id='prependedInput']")));
        driver.findElement(By.cssSelector("input[id='prependedInput']")).sendKeys(STUDENT_LOGIN);

        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();
    }
}
