package pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.LogRecordsFromTo;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class DatesSelenidePageObject {
    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "#name")
    private SelenideElement nameField;

    @FindBy(css = "#password")
    private SelenideElement passwordField;

    @FindBy(css = "#login-button")
    private SelenideElement loginButton;

    @FindBy(css = "#user-name")
    public SelenideElement userName;

    @FindBy(css = ".sidebar-menu > li")
    public List<SelenideElement> menuCollection;

    @FindBy(css = ".sub > li")
    public List<SelenideElement> subCollection;

    @FindBy(css = ".ui-slider-handle:nth-child(1)")
    public SelenideElement From;

    @FindBy(css = ".ui-slider-handle:nth-child(3)")
    public SelenideElement To;

    @FindBy(css = ".panel-body-list > li")
    public List<SelenideElement> logCollection;

    public void login(String name, String password) {
        profileButton.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public SelenideElement clickMenuItem(List<SelenideElement> collection, String str) {
        for (SelenideElement ele : collection) {
            if (ele.getText().equals(str)) {
                ele.click();
                return ele;
            }
        }
        return null;
    }

    public void moveFromSlider(int expect) {

        int original = Integer.valueOf(From.getText());
        Actions act = new Actions(getWebDriver());
        act.click(From).build().perform();

        if (expect - original > 0) {
            for (int i = 0; i < (expect - original); i++) {
                act.sendKeys(Keys.ARROW_RIGHT).build().perform();
            }
        }
        if (expect - original < 0) {
            for (int i = 0; i < (original - expect); i++) {
                act.sendKeys(Keys.ARROW_LEFT).build().perform();
            }
        }
    }

    public void moveToSlider(int expect) {
        int original = Integer.valueOf(To.getText());

        Actions act = new Actions(getWebDriver());
        act.click(To).build().perform();

        if (original - expect > 0) {
            for (int i = 0; i < (original - expect); i++) {
                act.sendKeys(Keys.ARROW_LEFT).build().perform();
            }
        }
        if (original - expect < 0) {
            for (int i = 0; i < (expect - original); i++) {
                act.sendKeys(Keys.ARROW_RIGHT).build().perform();
            }
        }
    }


    public List<String> makeListLog() {
        List<String> logList = new ArrayList<String>();
        logList.add(LogRecordsFromTo.FROM.getRecord() + From.getText() + LogRecordsFromTo.LINK.getRecord());
        logList.add(LogRecordsFromTo.TO.getRecord() + To.getText() + LogRecordsFromTo.LINK.getRecord());
        return logList;
    }
}

