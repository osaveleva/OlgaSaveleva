package pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.LogRecordsFromTo;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.List;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.forward;
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

    @FindBy(css = ".ui-slider")
    public SelenideElement slider;

    @FindBy(css = ".ui-slider-handle:nth-child(1)")
    public SelenideElement from;

    @FindBy(css = ".ui-slider-handle:nth-child(3)")
    public SelenideElement to;

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

    public void moveSlider(int fromExpected, int toExpected, double px) {
        Actions act = new Actions(getWebDriver());
        int originalFrom = Integer.valueOf(from.getText());
        int originalTo = Integer.valueOf(to.getText());
        if (fromExpected > originalTo) {
            act.dragAndDropBy(to, (int) Math.round((toExpected - originalTo) * px), 0).build().perform();
            act.dragAndDropBy(from, (int) Math.round((fromExpected - originalFrom) * px), 0).build().perform();
        } else {
            act.dragAndDropBy(from, (int) Math.round((fromExpected - originalFrom) * px), 0).build().perform();
            act.dragAndDropBy(to, (int) Math.round ((toExpected - originalTo) * px), 0).build().perform();
        }
    }

    public List<String> makeListLog(int fromExpected, int toExpected) {
        List<String> logList = new ArrayList<String>();
        logList.clear();
        logList.add(LogRecordsFromTo.FROM.getRecord() + fromExpected + LogRecordsFromTo.LINK.getRecord());
        logList.add(LogRecordsFromTo.TO.getRecord() + toExpected + LogRecordsFromTo.LINK.getRecord());
        return logList;
    }

}


