package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Browser;

import static utils.Browser.*;

public class MouseActionsPage {
    public void open() {
        visit("https://the-internet.herokuapp.com/hovers");
    }

    public void hoverOverUser(int userIndex) {
        hover(By.cssSelector(String.format(".figure:nth-child(%d)", userIndex)));
    }

    private void hover(By by) {
        WebDriver driver = null;
        Actions action = new Actions (driver);
        WebElement element = driver.findElement(by);
        action.moveToElement(element).perform();
    }

    public String getUserName(int userIndex) {
        // Get the username of the specified user
        return findElement(By.cssSelector(String.format(".figcaption:nth-child(%d) h5", userIndex))).getText(By.id(""));
    }

    private Browser findElement(By by) {
        return null;
    }

    public String getUserLink(int userIndex) {
        return findElement(By.cssSelector(String.format(".figcaption:nth-child(%d) a", userIndex))).getAttribute("href");
    }
}
