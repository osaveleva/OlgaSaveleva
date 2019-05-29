package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.LeftMenuItems;
import enums.LogRecordsFromTo;
import enums.SubMenuItems;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.List;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
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
    private SelenideElement userName;

    @FindBy(css = ".sidebar-menu > li")
    public ElementsCollection menuCollection;

    @FindBy(css = ".sub > li")
    private ElementsCollection subCollection;

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

    public void clickDiffElementMenuItem() {
        subCollection.findBy(text(SubMenuItems.DATES.getRecord())).click();
    }

    public void checkUserNameTitle(String configValue) {
        userName.shouldHave(text(configValue));
    }

    private void clickServicetMenuItem(String str) {
        menuCollection.findBy(text(str)).click();
    }

    public void clickDMenuItem(String str) {
        for (SelenideElement ele : subCollection) {
            if (ele.getText().equals(str)) {
                ele.click();
                return;
            }
        }

    }

    public void checkServiceMenu() {
        clickServicetMenuItem(LeftMenuItems.SERVICE.getRecord());
        for (SubMenuItems sm : SubMenuItems.values()) {
            subCollection.findBy(text(sm.getRecord())).should(exist);
        }
    }

    public void moveSlider(int fromExpected, int toExpected) {
        String offsetWidth = slider.getAttribute("offsetWidth");
        double step = Double.valueOf(offsetWidth) / 100;
        double px = Math.round(step * 10.0) / 10.0;
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
        from.shouldHave(exactText(String.valueOf(fromExpected)));
        to.shouldHave(exactText(String.valueOf(toExpected)));
    }

    public List<String> makeListLog(int fromExpected, int toExpected) {
        List<String> logList = new ArrayList<>();
        logList.clear();
        logList.add(LogRecordsFromTo.FROM.getRecord() + fromExpected + LogRecordsFromTo.LINK.getRecord());
        logList.add(LogRecordsFromTo.TO.getRecord() + toExpected + LogRecordsFromTo.LINK.getRecord());
        return logList;
    }

}


