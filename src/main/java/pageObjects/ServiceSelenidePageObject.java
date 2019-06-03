package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static base.HomePageValues.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

// TODO PO name.
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

    public void clickDiffElementMenuItem() {
        subCollection.findBy(text(SubMenuItems.DIFFERENT_ELEMENTS.getRecord())).click();
    }

    private void clickServicetMenuItem(String str) {
        menuCollection.findBy(text(str)).click();
    }

    public void checkCheckBox(String itemValue) {
        checkboxRow.findBy(text(itemValue)).shouldBe(enabled).click();
        checkboxRow.findBy(text(itemValue)).lastChild().shouldBe(checked);
    }

    public void checkUnCheckBox(String itemValue) {
        checkboxRow.findBy(text(itemValue)).shouldBe(enabled).click();
        checkboxRow.findBy(text(itemValue)).lastChild().shouldNotBe(checked);
    }

    public void checkRadioButton(String itemValue) {
        radioButtonRow.findBy(text(itemValue)).shouldBe(enabled).click();
        radioButtonRow.findBy(text(itemValue)).lastChild().shouldBe(checked);
    }

    public void checkUserNameTitle() {
        userName.shouldHave(text(PAGE_TITLE));
    }

    public void checkServiceMenu() {
        clickServicetMenuItem(LeftMenuItems.SERVICE.getRecord());
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

    public void checkNatureElements() {
        checkboxCollection.shouldHaveSize(ElementsCheckBox.values().length);
    }

    public void checkRadioButtonCollection() {
        radioButtonCollection.shouldHaveSize(MetalsRadioButton.values().length);
    }

    public void checkDropDownCollection() {
        dropdownCollection.shouldHaveSize(Integer.valueOf(ElementsNumber.DROPDOWN_NUMBER.getRecord()));
    }

    public void checkButtonCollection() {
        buttonCollection.shouldHaveSize(DiffElementButtons.values().length);
    }

    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    public void checkTrueCheckBoxLogRecords() {
        checkboxLogRecords.findBy(text(LogRecordsCheckBox.TEMPLATE.getRecord("Water", "true"))).shouldBe(visible);
        checkboxLogRecords.findBy(text(LogRecordsCheckBox.TEMPLATE.getRecord("Wind", "true"))).shouldBe(visible);
    }

    public void checkRadioButtonLogRecords() {
        checkboxLogRecords.findBy(text(LogRecordsRadioButton.TEMPALTE.getRecord("Selen"))).shouldBe(visible);
    }

    public void checkDropDownLogRecords() {
        checkboxLogRecords.findBy(text(LogRecordsDropDown.TEMPLATE.getRecord("Yellow"))).shouldBe(visible);
    }

    public void checkFalseCheckBoxLogRecords() {
        checkboxLogRecords.findBy(text(LogRecordsCheckBox.TEMPLATE.getRecord("Water", "false"))).shouldBe(visible);
        checkboxLogRecords.findBy(text(LogRecordsCheckBox.TEMPLATE.getRecord("Wind", "false"))).shouldBe(visible);
    }

    public void checkTitle(){
        assertEquals(getWebDriver().getTitle(), MAIN_DRIVER_TITLE);
    }

}

