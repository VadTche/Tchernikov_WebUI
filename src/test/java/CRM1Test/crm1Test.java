package CRM1Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class crm1Test {
    private static final Logger logger = LoggerFactory.getLogger(crm1Test.class);
    private static WebDriver driver;

    @BeforeAll
    static void beforeAllTests() {
        logger.info("Before all tests");
    }

    @Test
    public void commonWaiterResult () {

        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.textToBePresentInElementLocated
                        (By.xpath(".//div[@class='flash-messages-holder']"), ("Проект сохранен")));
        WebElement flash = driver.findElement(By.xpath(".//div[@class='flash-messages-holder']"));
        Assertions.assertTrue(flash.isDisplayed());
    }
}