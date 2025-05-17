package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.heroku.CheckboxPage;

import static utils.Browser.openBrowser;
import static utils.Browser.quit;

public class CheckBoxesTest {

    @Test
    void tc02() {
        openBrowser("chrome");
        CheckboxPage checkboxPage = new CheckboxPage();
        checkboxPage.open();

        checkboxPage.check("1");
        Assert.assertTrue(checkboxPage.isChecked("1"));

        checkboxPage.check("3");
        Assert.assertTrue(checkboxPage.isChecked("3"));

        quit();
    }

    @Test
    void ableToUncheckAllCheckboxes(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
        driver.findElement(By.cssSelector("button[data-test=check-all-button]")).click();
        driver.findElement(By.cssSelector("button[data-test=uncheck-all-button]")).click();

        Assert.assertFalse(driver.findElement(By.cssSelector("input[data-test=checkbox-label-checkbox1]")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[data-test=checkbox-label-checkbox2]")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[data-test=checkbox-label-checkbox3]")).isSelected());

        driver.quit();

    }

}
