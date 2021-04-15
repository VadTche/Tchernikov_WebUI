package Lesson6;


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

    public ProjectPage loginProject(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        submitButton.click();
        return new ProjectPage(driver);
    }

    public ContactPage loginContact(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        submitButton.click();
        return new ContactPage(driver);
    }
}