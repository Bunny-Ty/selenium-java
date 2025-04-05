package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxesTest {

    @Test
    void tc02() {
        /**
         * TC02: Checkboxes : Check to a box

         * Open browser

         * Navigate to https://the-internet.herokuapp.com/checkboxes

         * Check on checkbox1

         * Verify checkbox1 is checked

         * Check on checkbox2

         * Verify checkbox2 is checked
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        if (!driver.findElement(By.cssSelector("form#checkboxes input:nth-child(1)")).isSelected()) {
            driver.findElement(By.cssSelector("form#checkboxes input:nth-child(1)")).click();
        }
        Assert.assertTrue(driver.findElement(By.cssSelector("form#checkboxes input:nth-child(1)")).isSelected());

        if (!driver.findElement(By.cssSelector("form#checkboxes input:nth-child(3)")).isSelected()) {
            driver.findElement(By.cssSelector("form#checkboxes input:nth-child(3)")).click();
        }
        Assert.assertTrue(driver.findElement(By.cssSelector("form#checkboxes input:nth-child(3)")).isSelected());

        driver.quit();
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
