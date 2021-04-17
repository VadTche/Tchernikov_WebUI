package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage{
    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    WebElement projects = driver.findElement(By.xpath(".//span[@class='title' and text()='Проекты']"));
    WebElement newProject = driver.findElement(By.xpath(".//span[@class='title' and text()='Мои проекты']"));

    @Step("redirect to all project page")
    public AllProjectsPage redirectToAllProjectsPage() {
        Action.moveCursorToNavigationTab(projects, driver);
        newProject.click();
        return new AllProjectsPage (driver);
    }
}

