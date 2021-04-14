package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewProjectPage extends BasePage {

    @FindBy(name = "crm_project[name]")
    private WebElement projectNameInput;

    @FindBy(xpath = "//*[@class='select2-chosen' and text()='Укажите организацию']")
    private WebElement clickDropDownMenu_organization;

    @FindBy(xpath = "//div[@class='select2-result-label' and text()='1234']")
    private WebElement choiceDropDownMenu_organization;

    @FindBy(xpath = "//*[@class='select2-container select2']")
    private WebElement clickDropDownMenu_ContactPerson;

    @FindBy(css = ".select2-focused")
    private WebElement sendDropDownMenu_ContactPerson;

    @FindBy(css = ".select2-result-label")
    private WebElement choiceDropDownMenu_ContactPerson;

    @FindBy(name = "crm_project[businessUnit]")
    private WebElement businessUnitDropDownSelect;

    @FindBy(name = "crm_project[businessUnit]")
    private WebElement businessUnitNameInput;

    @FindBy(name = "crm_project[curator]")
    private WebElement curatorNameInput;

    @FindBy(name = "crm_project[rp]")
    private WebElement rpNameInput;

    @FindBy(name = "crm_project[manager]")
    private WebElement managerNameInput;

    @FindBy(css = "button[class='btn btn-success action-button']")
    private WebElement submitButtonP;

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    public NewProjectPage enterProjectName(String description) {
        projectNameInput.sendKeys(description);
        return this;
    }

    public NewProjectPage clickDropDownOrganization() {
        clickDropDownMenu_organization.click();
        return this;
    }

    public NewProjectPage choiceDropDownOrganization() {
        choiceDropDownMenu_organization.click();
        return this;
    }

    public NewProjectPage clickDropDownContactPerson() {
        clickDropDownMenu_ContactPerson.click();
        return this;
    }

    public NewProjectPage sendDropDownContactPerson() {
        sendDropDownMenu_ContactPerson.sendKeys("Petrova Kate");
        return this;
    }

    public NewProjectPage choiceDropDownContactPerson() {
        choiceDropDownMenu_ContactPerson.click();
        return this;
    }

    public NewProjectPage selectBusinessUnit(String description){
        Select businessUnitDropDown = new Select(businessUnitDropDownSelect);
        businessUnitDropDown.selectByVisibleText(description);
        return this;
    }

    public NewProjectPage enterCuratorName(String description) {
        curatorNameInput.sendKeys(description);
        return this;
    }

    public NewProjectPage enterRpName(String description) {
        rpNameInput.sendKeys(description);
        return this;
    }

    public NewProjectPage enterManagerName(String description) {
        managerNameInput.sendKeys(description);
        return this;
    }

    public AllProjectsPage clickSubmit() {
        submitButtonP.click();
        return new AllProjectsPage(driver);
    }
}
