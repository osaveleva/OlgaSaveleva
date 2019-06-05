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
import static base.HomePageValues.*;
import static org.testng.Assert.assertEquals;


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

    @FindBy(css = ".panel-body-list > li")
    private ElementsCollection logCollection;

    public void login(String name, String password) {
        profileButton.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

//    public void clickSubMenuItem() {
//        subCollection.findBy(text(SubMenuItems.DATES.getRecord())).click();
//    }

    public void checkUserNameTitle() {
        userName.shouldHave(text(USER_NAME));
    }

    // TODO
    public void clickLeftMenuBaseItem(LeftMenuItems item) {
        menuCollection.findBy(text(item.getRecord())).click();
    }

    public void checkServiceMenu() {
        for (SubMenuItems sm : SubMenuItems.values()) {
            subCollection.findBy(text(sm.getRecord())).should(exist);
        }
    }

    public void clickMenu(LeftMenuItems... v) {
        if (v.length == 1) {
            menuCollection.findBy(text(v[0].getRecord())).click();
        } else {
            if (subCollection.findBy(text(v[1].getRecord())).isDisplayed()) {
                subCollection.findBy(text(v[1].getRecord())).click();
            } else {
                menuCollection.findBy(text(v[0].getRecord())).click();
                subCollection.findBy(text(v[1].getRecord())).click();
            }
        }
    }

    public void moveSlider(int fromExpected, int toExpected) {
        String offsetWidth = slider.getAttribute("offsetWidth");
        double step = Double.valueOf(offsetWidth) / 100.0;
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
    }

    public void checkSliderPosition(int fromExpected, int toExpected) {
        // TODO
        from.shouldHave(exactText(String.valueOf(fromExpected)));
        to.shouldHave(exactText(String.valueOf(toExpected)));
    }

    // TODO Parameters should be 'int'
    public void checkLogs(String fromValue, String toValue) {
        logCollection.findBy(text(LogRecordsFromTo.TEMPLATE.getRecord("From", fromValue))).shouldBe(visible);
        logCollection.findBy(text(LogRecordsFromTo.getRecord1("To", toValue))).shouldBe(visible);
    }

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), MAIN_DRIVER_TITLE);
    }

    public void clickLeftMenuServiceItem(SubMenuItems item) {
        subCollection.findBy(text(item.getRecord())).click();
    }
}


