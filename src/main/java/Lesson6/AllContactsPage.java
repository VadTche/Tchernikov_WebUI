package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllContactsPage extends BasePage {

    @FindBy(css = "div[class='pull-left btn-group icons-holder']")
    private WebElement createNewContactButton;

    public AllContactsPage(WebDriver driver) {
        super(driver);
    }

    public NewContactPage clickOnCreateNewContactButton() {
        createNewContactButton.click();
        return new NewContactPage(driver);
    }

    public AllContactsPage checkNewContactPopUp() {
        String message = wait10second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        assertTrue(message.contains("Заявка на расход сохранена"));
        return this;
    }
}
