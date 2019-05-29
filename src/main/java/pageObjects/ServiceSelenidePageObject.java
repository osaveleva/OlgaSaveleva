package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.LogRecordsCheckBox;
import enums.LogRecordsDropDown;
import enums.LogRecordsRadioButton;
import enums.SubMenuItems;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;


public class ServiceSelenidePageObject {
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
    public List<SelenideElement> menuCollection;

    @FindBy(css = ".colors > select > option")
    private ElementsCollection dropdonwItemCollection;

    @FindBy(css = ".colors")
    public SelenideElement dropdown;

    @FindBy(css = ".sub > li")
    private ElementsCollection subCollection;

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxCollection;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioButtonCollection;

    @FindBy(css = ".colors")
    private ElementsCollection dropdownCollection;

    @FindBy(css = ".main-content .uui-button")
    private ElementsCollection buttonCollection;

    @FindBy(css = ".label-checkbox input[type ='checkbox']")
    public List<SelenideElement> checkboxValueCollection;

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxRow;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioButtonRow;

    @FindBy(css = ".label-radio input[type ='radio']")
    private List<SelenideElement> radioButtonValueCollection;

    @FindBy(css = "div[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "div[name='navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection checkboxLogRecords;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection radioLogRecords;


    public void login(String name, String password) {
        profileButton.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void clickDiffElementMenuItem(String str) {
        for (SelenideElement ele : subCollection) {
            if (ele.getText().equals(str)) {
                ele.click();
                return;
            }
        }

    }

    private void clickServicetMenuItem(String str) {
        for (SelenideElement ele : menuCollection) {
            if (ele.getText().equals(str)) {
                ele.click();
                return;
            }
        }

    }

    private SelenideElement checkItem(List<SelenideElement> checkCollection, String checkboxValue) {
        for (SelenideElement check : checkCollection) {
            if (check.parent().getText().equals(checkboxValue)) {
                check.parent().click();
                check.shouldBe(checked);
                return check;
            }
        }
        return null;
    }


    public void checkCheckBoxStatus(String itemValue) {
        checkboxRow.findBy(text(itemValue)).shouldBe(enabled).click();
        checkboxRow.findBy(text(itemValue)).lastChild().shouldBe(checked);
    }

    public void checkRadioButtonStatus(String itemValue) {
        radioButtonRow.findBy(text(itemValue)).shouldBe(enabled).click();
        radioButtonRow.findBy(text(itemValue)).lastChild().shouldBe(checked);
    }

    public void checkUserNameTitle(String configValue) {
        userName.shouldHave(text(configValue));
    }

    public void checkServiceMenu(String configValue) {
        clickServicetMenuItem(configValue);
        for (SubMenuItems sm : SubMenuItems.values()) {
            subCollection.findBy(text(sm.getRecord())).should(exist);
        }
    }

    public void clickDropDown(String itemValue) {
        dropdown.click();
        dropdonwItemCollection.findBy(text(itemValue)).shouldBe(enabled).click();
    }

    public void checkDropDownValue(String itemValue) {
        dropdonwItemCollection.findBy(text(itemValue)).shouldBe(selected);
    }


    public void checkCheckBoxCollectionSize(int configValue) {
        checkboxCollection.shouldHaveSize(configValue);
    }

    public void checkRadioButtonCollectionSize(int configValue) {
        radioButtonCollection.shouldHaveSize(configValue);
    }

    public void checkDropDownCollectionSize(String configValue) {
        dropdownCollection.shouldHaveSize(Integer.valueOf(configValue));
    }

    public void checkButtonCollectionSize(int configValue) {
        buttonCollection.shouldHaveSize(configValue);
    }

    public void checkRightSectionVisibility() {
        rightSection.shouldBe(visible);
    }

    public void checkLeftSectionVisibility() {
        leftSection.shouldBe(visible);
    }



    public void checkCheckBoxLogRecords() {
        checkboxLogRecords.findBy(text(LogRecordsCheckBox.WINDSELECTED.getRecord())).shouldBe(visible);
        checkboxLogRecords.findBy(text(LogRecordsCheckBox.WATERSELECTED.getRecord())).shouldBe(visible);
    }

    public void checkRadioButtonLogRecords() {
        checkboxLogRecords.findBy(text(LogRecordsRadioButton.SELEN.getRecord())).shouldBe(visible);
    }

    public void checkDropDownLogRecords() {
        checkboxLogRecords.findBy(text(LogRecordsDropDown.YELLOW.getRecord())).shouldBe(visible);
    }
}

