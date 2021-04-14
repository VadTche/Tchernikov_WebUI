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

//    @Test
//    @DisplayName("Создание проекта")
//    public void createProjectTest() {
//        Logger logger = Logger.getLogger(AppTest.class);
//        crmLogin();
//        logger.info("Вход выполнен успешно");
//        new CRMHomePage(driver)
//                .getNavigation()
//                .moveCursorTooNavigationTab(NavigationBarTabs.PROJECTS)
//                .clickSubMenuButton(ProjectSubMenuButtons.MY_PROJECTS);
//        new AllProjectsPage(driver)
//                .clickNewProject()
//                .enterProjectName("Kill_star")
//                .clickCompanyList()
//                .clickSeceltedCompany()
//                .selectBusinessUnit(1)
//                .selectCurator(33)
//                .selectRP(83)
//                .selectManager(6)
//                .selectContsctMain(189)
//                .clickSubmit()
//                .checkNewProject();
//        logger.info("Проект сохранен успешно");
//        crmLogout();
//        logger.info("Вход выполнен успешно");
//        driver.close();
//    }

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


