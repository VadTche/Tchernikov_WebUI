package Lesson6Test;

import Lesson6.LoginPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static Lesson6Test.Configuration.STUDENT_LOGIN;
import static Lesson6Test.Configuration.STUDENT_PASSWORD;

public class CRMTest extends BaseTest {

    @Test
    public void newProjectTest() throws InterruptedException {

        Faker faker = new Faker();
        String firstName = faker.name().firstName();

        new LoginPage(driver)
                .loginProject(STUDENT_LOGIN, STUDENT_PASSWORD)
                .redirectToAllProjectsPage()
                .clickOnCreateNewProjectButton()
                .enterProjectName(firstName)
                .clickDropDownOrganization()
                .choiceDropDownOrganization()
                .selectBusinessUnit("Research & Development")
                .clickDropDownContactPerson()
                .sendDropDownContactPerson()
                .choiceDropDownContactPerson()
                .enterCuratorName("Амелин Владимир")
                .enterRpName("Воденеев Денис")
                .enterManagerName("Исаева Анастасия")
                .clickSubmit()
                .checkNewProjectPopUp();
    }

    @Test
    public void newContactTest() {
        new LoginPage(driver)
                .loginContact(STUDENT_LOGIN, STUDENT_PASSWORD)
                .redirectToNewContactPage()
                .clickSubmit()
                .clickOnCreateNewContactButton()
                .enterDescription("test 1234")
                .selectBusinessUnit(1)
                .selectExpenditure(87)
                .setExpenseSum(10000)
                .clickNotifyDateChangedCheckBox()
                .selectDateInDatePicker(20)
                .clickSubmit()
                .checkNewContactPopUp();
    }
}


