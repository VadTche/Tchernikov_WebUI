package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewProjectPage extends BasePage {

    @FindBy(xpath = ".//textarea")
    private WebElement descriptionTextInput;

    @FindBy(name = "crm_expense_request[businessUnit]")
    private WebElement businessUnitDropDownSelect;

    @FindBy(name = "crm_expense_request[expenditure]")
    private WebElement expenditureDropDownSelect;

    @FindBy(name = "crm_expense_request[sumPlan]")
    private WebElement expenseRequestSumTextInput;

    @FindBy(name = "crm_expense_request[dateChangeNotify]")
    private WebElement notifyDateHasChanged;

    @FindBy(xpath = ".//div[preceding-sibling::div[child::label[@class='required']]]//input[@class='datepicker-input  hasDatepicker']")
    private WebElement calendarView;

    @FindBy(css = "button[class='btn btn-success action-button']")
    private WebElement submitButton;

    public NewProjectPage(WebDriver driver) {

        super(driver);
    }

    public NewProjectPage enterDescription(String description) {
        descriptionTextInput.sendKeys(description);
        return this;
    }
    // TODO: improve input with ENUM
    public NewProjectPage selectBusinessUnit(int value) {
        Select businessUnitDropDown = new Select(businessUnitDropDownSelect);
        businessUnitDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    // TODO: improve input with ENUM
    public NewProjectPage selectExpenditure(int value) {
        Select expenditureDropDown = new Select(expenditureDropDownSelect);
        expenditureDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    public NewProjectPage setExpenseSum(int sum) {
        expenseRequestSumTextInput.clear();
        expenseRequestSumTextInput.sendKeys(String.valueOf(sum));
        return this;
    }

    public NewProjectPage clickNotifyDateChangedCheckBox() {
        notifyDateHasChanged.click();
        return this;
    }

    public NewProjectPage selectDateInDatePicker(int day) {
        calendarView.click();
        String xpath = String.format(".//a[text()='%d']", day);
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    public AllProjectsPage clickSubmit() {
        submitButton.click();
        return new AllProjectsPage(driver);
    }
}
