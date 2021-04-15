package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewContactPage extends BasePage {

    @FindBy(name = "crm_contact[lastName]")
    private WebElement contactLastName;

    @FindBy(name = "crm_contact[firstName]")
    private WebElement contactFirstName;

    @FindBy(xpath = "//*[@class='select2-chosen' and text()='Укажите организацию']")
    private WebElement clickDropDownMenu_organization;

    @FindBy(xpath = "//div[@class='select2-result-label' and text()='1234']")
    private WebElement choiceDropDownMenu_organization;

    @FindBy(name = "crm_contact[jobTitle]")
    private WebElement jobTitleDropInput;

    @FindBy(css = "button[class='btn btn-success action-button']")
    private WebElement submitButton;

    public NewContactPage(WebDriver driver) {
        super(driver);
    }

    public  NewContactPage enterLastName(String description){
        contactLastName.sendKeys(description);
        return this;
    }
    public  NewContactPage enterFirstName(String description){
        contactFirstName.sendKeys(description);
        return this;
    }

    public NewContactPage clickDropDownOrganization() {
        clickDropDownMenu_organization.click();
        return this;
    }

    public NewContactPage choiceDropDownOrganization() {
        choiceDropDownMenu_organization.click();
        return this;
    }

    public NewContactPage enterJobTitle(String description) {
        jobTitleDropInput.sendKeys(description);
        return this;
    }

    public AllContactsPage clickSubmit() {
        submitButton.click();
        return new AllContactsPage(driver);
    }
}
