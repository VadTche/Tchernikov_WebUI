package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllContactsPage extends BasePage {

    @FindBy(linkText = "Создать контактное лицо")
    private WebElement createNewContactButton;

    public AllContactsPage(WebDriver driver) {
        super(driver);
    }

    @Step("click 'new contact'")
    public NewContactPage clickOnCreateNewContactButton() {
        createNewContactButton.click();
        return new NewContactPage(driver);
    }

    @Step("Check 'new contact' popup visibility")
    public void checkNewContactPopUp() {
        String message = wait10second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        assertTrue(message.contains("Контактное лицо сохранено"));
    }
}
