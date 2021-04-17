package Lesson6Test;

import Lesson6.LoginPage;
import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import static Lesson6Test.Configuration.STUDENT_LOGIN;
import static Lesson6Test.Configuration.STUDENT_PASSWORD;

public class CRMTest extends BaseTest {

    @Test
    @Feature("Project")
    public void newProjectTest() {

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
    @Feature("Contacts")
    public void newContactTest() {
        new LoginPage(driver)
                .loginContact(STUDENT_LOGIN, STUDENT_PASSWORD)
                .redirectToAllContactsPage()
                .clickOnCreateNewContactButton()
                .enterLastName("Роботов")
                .enterFirstName("Робот")
                .clickDropDownOrganization()
                .choiceDropDownOrganization()
                .enterJobTitle("Менеджер")
                .clickSubmit()
                .checkNewContactPopUp();
    }
}


