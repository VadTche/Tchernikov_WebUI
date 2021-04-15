package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {

    public static void moveCursorToNavigationTab(WebElement tab, WebDriver driver) {
        Actions actions = new Actions(driver);
        actions
                .moveToElement(tab)
                .build()
                .perform();
    }
}
