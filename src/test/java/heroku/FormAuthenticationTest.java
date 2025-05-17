package heroku;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.heroku.FormAuthenticationPage;

import static utils.Browser.*;

public class FormAuthenticationTest extends TestBase {
    FormAuthenticationPage formAuthenticationPage;
    @BeforeClass
    void setup() {
        openBrowser("chrome");
        formAuthenticationPage = new FormAuthenticationPage();
    }

    @Parameters({"browser"})
    @Test
    void tc01(String browser) {
        formAuthenticationPage
                .open()
                .login("tomsmith","SuperSecretPassword!");

        Assert.assertEquals(getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(formAuthenticationPage
                .getWelcomeMessage()
                .contains("You logged into a secure area!"));
        Assert.assertEquals(getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
    }

    @AfterClass
    void tearDown() {
        quit();
    }
}
