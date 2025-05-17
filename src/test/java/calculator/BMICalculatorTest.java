package calculator;

import common.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.calculator.BMICalculatorPage;

import static utils.Browser.*;

public class BMICalculatorTest extends TestBase {
    BMICalculatorPage bmiPage;

    @BeforeClass
    void setup(){
        openBrowser("chrome");
        bmiPage = new BMICalculatorPage();
        bmiPage.open();
        bmiPage.selectUnitMetric();
        bmiPage.clearForm();

    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"25", "male", "175", "70", "BMI = 22.9 kg/m2   (Normal)"},
                {"25", "male", "175", "90", "BMI = 29.4 kg/m2   (Overweight)"}
        };
    }

    @Test(dataProvider = "testData")
    void verifyNormalClassification(String age, String gender, String height, String weight, String expectedResult) {
        bmiPage.fillForm(age, gender, height, weight);
        Assert.assertEquals(bmiPage.getResultText(), expectedResult);
    }

    @AfterClass
    void tearDown() {
        quit();
    }
}