package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    WebElement contacts = driver.findElement(By.xpath(".//span[@class='title' and text()='Контрагенты']"));
    WebElement newContact = driver.findElement(By.xpath(".//span[@class='title' and text()='Контактные лица']"));

    @Step("redirect to all contact page")
    public AllContactsPage redirectToAllContactsPage() {
        Action.moveCursorToNavigationTab(contacts, driver);
        newContact.click();
        return new AllContactsPage (driver);
    }
}
