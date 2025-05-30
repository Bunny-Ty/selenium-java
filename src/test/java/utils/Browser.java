package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

//Selenium owner methods
public class Browser {
    /*
        open browser: chrome, firefox, edge, safari
        return WebDriver
        static method
     */
    private static WebDriver driver;
    public static WebDriverWait wait;

    public static void openBrowser(String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.password_leak_detection", false);
                chromeOptions.setExperimentalOption("prefs", prefs);
                chromeOptions.addArguments("--disable-password-manager-leak-detection");
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void visit(String url){
        driver.get(url);
    }
    public static void quit(){
        driver.quit();
    }
    public static void click(By by){
        wait
        .until(ExpectedConditions.elementToBeClickable(by))
        .click();
    }

    public static void fill(By by, String withText){
        driver.findElement(by).sendKeys(withText);
    }
    public static boolean isSelected(By by){
        return driver.findElement(by).isSelected();
    }
    public static void check(By by){
        if (!isSelected(by)){
            driver.findElement(by).click();
        }
    }
    public static String getText(By by){
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(by))
                .getText();
    }

    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public static void captureScreenshot(String fileName){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshots-%s-%s.png", fileName, System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void hover(By by){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).perform();
    }

}
