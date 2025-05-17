package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;

import static utils.Browser.captureScreenshot;


public class TestBase {
    @AfterMethod (alwaysRun = true)
    protected void takeScreenShotName(ITestResult testResult) {
      if (!testResult.isSuccess()){
          captureScreenshot(testResult.getName());
      }

    }

}
