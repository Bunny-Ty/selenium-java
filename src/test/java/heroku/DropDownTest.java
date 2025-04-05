package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDownTest {

    /**
     *
     Open browser

     Navigate to https://the-internet.herokuapp.com/dropdown

     Select "option 1"

     Validate "option 1" is selected
     */

    @Test
    void tc03(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));

        select.selectByContainsVisibleText("Option 1");
        // xpath = //E[.='text'] => //option[.='Option 1']
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Option 1']")).isSelected());

        select.selectByValue("1");
        Assert.assertTrue(driver.findElement(By.cssSelector("option[value=1]")).isSelected());

        select.deselectByIndex(1);
        Assert.assertTrue(driver.findElement(By.xpath("//select/option[1]")).isSelected());

        driver.quit();

    }

    @Test
    void ableSelectMultipleOptions(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2/");

        Select select = new Select(driver.findElement(By.id("fruits")));
        Assert.assertTrue(select.isMultiple());

        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");
        select.selectByVisibleText("Grape");

        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Grape']")).isSelected());

    }

    @Test
    void verifyTextFiledDisable() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertFalse(driver.findElement(By.cssSelector("form#input-example input")).isEnabled());

        driver.findElement(By.cssSelector("form#input-example button")).click();

        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form#input-example input"))).isEnabled());

        driver.quit();

    }

}
