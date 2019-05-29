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
    public ElementsCollection menuCollection;

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
        subCollection.findBy(text(str)).click();
    }

    private void clickServicetMenuItem(String str) {
        menuCollection.findBy(text(str)).click();
    }

    public void checkCheckBox(String itemValue) {
        checkboxRow.findBy(text(itemValue)).shouldBe(enabled).click();
        checkboxRow.findBy(text(itemValue)).lastChild().shouldBe(checked);
    }

    public void checkRadioButton(String itemValue) {
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

    public void checkDropDown(String itemValue) {
        dropdonwItemCollection.findBy(text(itemValue)).shouldBe(selected);
    }


    public void checkCheckBoxCollection(int configValue) {
        checkboxCollection.shouldHaveSize(configValue);
    }

    public void checkRadioButtonCollection(int configValue) {
        radioButtonCollection.shouldHaveSize(configValue);
    }

    public void checkDropDownCollection(String configValue) {
        dropdownCollection.shouldHaveSize(Integer.valueOf(configValue));
    }

    public void checkButtonCollection(int configValue) {
        buttonCollection.shouldHaveSize(configValue);
    }

    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }



    public void checkCheckBoxLogRecords() {
        checkboxLogRecords.findBy(text(LogRecordsCheckBox.TEMPALTE.getRecord("Water", "true"))).shouldBe(visible);
        checkboxLogRecords.findBy(text(LogRecordsCheckBox.TEMPALTE.getRecord("Wind", "true"))).shouldBe(visible);
    }

    public void checkRadioButtonLogRecords() {
        checkboxLogRecords.findBy(text(LogRecordsRadioButton.TEMPALTE.getRecord("Selen"))).shouldBe(visible);
    }

    public void checkDropDownLogRecords() {
        checkboxLogRecords.findBy(text(LogRecordsDropDown.TEMPALTE.getRecord("Yellow"))).shouldBe(visible);
    }
}

