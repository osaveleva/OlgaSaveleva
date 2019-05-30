package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.LeftMenuItems;
import enums.LogRecordsFromTo;
import enums.SubMenuItems;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static utilities.HomePageValues.*;



public class DatesSelenidePageObjectAllure {
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

    @FindBy(css = ".panel-body-list > li")
    private ElementsCollection logCollection;

    public void login(String name, String password) {
        profileButton.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void clickDiffElementMenuItem() {
        subCollection.findBy(text(SubMenuItems.DATES.getRecord())).click();
    }

    public void checkUserNameTitle() {
        userName.shouldHave(text(PAGETITLE));
    }

    private void clickServicetMenuItem(String str) {
        menuCollection.findBy(text(str)).click();
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
            act.dragAndDropBy(to, (int) Math.round((toExpected - originalTo) * px), 0).build().perform();
        }
        from.shouldHave(exactText(String.valueOf(fromExpected)));
        to.shouldHave(exactText(String.valueOf(toExpected)));
    }

    public void checkLogs(String fromValue, String toValue) {
        logCollection.findBy(text(LogRecordsFromTo.TEMPLATE.getRecord("From", fromValue))).shouldBe(visible);
        logCollection.findBy(text(LogRecordsFromTo.TEMPLATE.getRecord("To", toValue))).shouldBe(visible);
    }


}


