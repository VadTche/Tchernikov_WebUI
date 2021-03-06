package Lesson6;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "prependedInput")
    private WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    private WebElement inputPassword;

    @FindBy(id = "_submit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("authorise project")
    public ProjectPage loginProject(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        submitButton.click();
        return new ProjectPage(driver);
    }

    @Step("authorise contact")
    public ContactPage loginContact(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        submitButton.click();
        return new ContactPage(driver);
    }
}