package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Browser.*;

public class NestedFramePage {
    public void open() {

        visit("https://the-internet.herokuapp.com/nested_frames");
    }

    public void switchToFrame(String frameName) {

        switchToFrame(By.name(frameName));
    }

    public void switchToFrame(By by) {

        WebDriver driver = null;
        driver.switchTo().frame(driver.findElement(by));
    }

    public void switchToParentFrame() {

        getDriver().switchTo().parentFrame();
    }

    public void switchToDefaultContent() {

        WebDriver driver = null;
        driver.switchTo().defaultContent();
    }
}
