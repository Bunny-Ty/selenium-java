package pages.heroku;

import org.openqa.selenium.By;

import java.io.IOException;
import java.nio.file.FileStore;

import static utils.Browser.visit;

public class DropDownPage {

    public void open() {
        visit("https://the-internet.herokuapp.com/dropdown");
    }

    public void selectOption(String option) {
        select(By.id("dropdown"), option);
    }

    private void select(By dropdown, String option) {
    }

    public String getSelectedOption() throws IOException {
        return getSelectedValue(By.id("dropdown"));
    }

    private String getSelectedValue(By dropdown) throws IOException {
        return (String) findElement(dropdown).getAttribute("value");
    }

    private FileStore findElement(By dropdown) {
        return null;
    }
}
