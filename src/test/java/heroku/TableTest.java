package heroku;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TableTest {

    /**
     * 1. Open browser
     * 2. Navigate to https://the-internet.herokuapp.com/tables
     * 3. Focus on table 1
     * 4. The person who has largest due is "Doe Jacson"
     */

    @Test
    void tc05() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Double> duelist = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .map(cell -> Double.valueOf(cell.getText().replace("$", "")))
                .toList();

        double maxDue = Collections.max(duelist);
        int rowIndex = duelist.indexOf(maxDue) + 1; // +1 because xpath is 1-based index

        String lastName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[1]", rowIndex))).getText();
        String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[2]", rowIndex))).getText();

        driver.quit();
    }

    @Test
    void tc06() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Person> personList = new ArrayList<>();

        driver.findElements(By.xpath(String.format("//table[@id='table1']/tbody/tr")))
                .forEach(row -> {
                    String lastName = row.findElement(By.xpath("./td[1]")).getText();
                    String firstName = row.findElement(By.xpath("./td[2]")).getText();
                    double due = Double.parseDouble(row.findElement(By.xpath("./td[4]")).getText().replace("$", ""));
                    personList.add(new Person(firstName, lastName, due));
                });
        //String maxDuePersonFullName = personList.stream().max(Comparator.comparing(Person::getDue)).get().getFullname();
        double maxDue = personList.stream().max(Comparator.comparing(Person::getDue)).get().getDue();
        List<String> listPersonHaveMaxDue = personList.stream().filter(person -> person.getDue() == maxDue)
                .map(person -> person.getFullname())
                .toList();
        Assert.assertEquals(listPersonHaveMaxDue, List.of("Jason Doe"));
        driver.quit();
    }

    @Test
    void tc07() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Person> personList = new ArrayList<>();

        driver.findElements(By.xpath(String.format("//table[@id='table1']/tbody/tr")))
                .forEach(row -> {
                    String lastName = row.findElement(By.xpath("./td[1]")).getText();
                    String firstName = row.findElement(By.xpath("./td[2]")).getText();
                    double due = Double.parseDouble(row.findElement(By.xpath("./td[4]")).getText().replace("$", ""));
                    personList.add(new Person(firstName, lastName, due));
                });
        //String maxDuePersonFullName = personList.stream().max(Comparator.comparing(Person::getDue)).get().getFullname();
        double minDue = personList.stream().min(Comparator.comparing(Person::getDue)).get().getDue();
        List<String> listPersonHaveMinDue = personList.stream().filter(person -> person.getDue() == minDue)
                .map(person -> person.getFullname())
                .toList();
        Assert.assertEquals(listPersonHaveMinDue, List.of("John Smith"), "Tim Conway");
        driver.quit();
    }

    @AfterMethod
    void captureScreenshot(ITestResult testResult) {
        WebDriver driver = new ChromeDriver();
        if (!testResult.isSuccess()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(String.format("target/screenshot-%s-%s.png", testResult.getName(), System.currentTimeMillis()));
            try {
                FileUtils.copyFile(srcFile, destFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @BeforeMethod (alwaysRun = true)
    void tearDown() {
        // Close the browser
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }

}