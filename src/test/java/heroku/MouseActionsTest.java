package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseActionsTest {

    @Test
    void hoveTest(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions action = new Actions(driver);
        WebElement avatar = driver.findElements(By.className("figure")).get(2);

        action.moveToElement(avatar).perform();
        Assert.assertTrue(avatar.findElement(By.xpath("//h5")).isDisplayed());

    }

    @Test
    void dragAndDropTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        Actions action = new Actions(driver);
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        //action.clickAndHold(source).moveToElement(target).release().build().perform();
        action.dragAndDrop(source, target).perform();

        Assert.assertTrue(driver.findElement(By.id("column-a")).getText().contains("B"));
        Assert.assertTrue(driver.findElement(By.id("column-b")).getText().contains("A"));

    }

    @Test
    void horizontalSliderTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        Actions action = new Actions(driver);
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        action.clickAndHold(slider).moveByOffset(100, 0).release().build().perform();

        String value = driver.findElement(By.id("range")).getText();
        Assert.assertTrue(value.contains("4"));

    }

    @Test
    void infinityScrollTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        Actions action = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            action.scrollByAmount(0, 1000).perform();
            Thread.sleep(1000);
        }
        driver.quit();

    }

    @Test
    void contextMenuTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions action = new Actions(driver);
        WebElement box = driver.findElement(By.id("hot-spot"));
        action.contextClick(box).perform();

        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        driver.switchTo().alert().accept();

    }

    @Test
    void keyPressTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses");

        Actions action = new Actions(driver);
        //action.sendKeys(Keys.ESCAPE).perform();
        action.keyDown(Keys.ESCAPE).perform();

        String resultText = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(resultText.contains("A"));

    }
}
