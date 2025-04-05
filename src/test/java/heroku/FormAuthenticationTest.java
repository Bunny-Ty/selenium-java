package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthenticationTest {

    /**
     - TC01: Form Authentication : Login successful with valid credentials
     - Open browser
     - Navigate to https://the-internet.herokuapp.com/login

     - Fill in username with tomsmith

     - Fill in the password with SuperSecretPassword!

     - Click on Login button

     - And the home page is appear

     */
    @Test
    void tc01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        /**
         * <label for="username">Username</label>
         //label[.='Username']
         //input[@id='username']/preceding-sibling::label/../input
         //label[.='username']/following-sibling::input
         //label[.='Username']/../input
         */

//        By usernameInput = RelativeLocator
//                .with(By.tagName("input"))
//                .below(By.xpath("//label[.='Username']"));
        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        driver.findElement(By.name("username")).sendKeys("tomsmith");
//        driver.findElement(By.tagName("input")).sendKeys("tomsmith");
//        // Sử dụng xpath va CSS với ID
//        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("[type=text]")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input#username")).sendKeys("tomsmith");
//        // sử dụng với name
//        driver.findElement(By.cssSelector("[name=username]")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input[type=text]")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");

        /**
         * Password:
         - tagname?
         - Atributes:
         - text
         - list out possible locators
         */
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.tagName("input")).sendKeys("SuperSecretPassword!");
//        //Use cssSelector
//        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.cssSelector("input#password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.cssSelector("[name=password]")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.cssSelector("[type=password]")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.cssSelector("input[type=password]")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("SuperSecretPassword!");
//        //Use xpath
//        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSecretPassword!");

        /**
         * Login button:
            - tagname?
            - Atributes:
            - text
         */
//        driver.findElement(By.tagName("button")).click();
//        driver.findElement(By.className("radius")).click();
//        driver.findElement(By.cssSelector(".radius")).click();
        driver.findElement(By.cssSelector("[type=submit]")).click();

        Thread.sleep(5000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");

        Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().contains("Welcome to the Secure Area"));

        driver.quit();
    }
}
