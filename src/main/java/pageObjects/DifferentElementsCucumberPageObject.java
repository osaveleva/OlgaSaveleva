package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static base.HomePageValues.PAGE_TITLE;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;


public class ServiceCucumberPageObject {

    public ServiceCucumberPageObject() {
        open("https://epam.github.io/JDI/");
        page(this);
    }

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


    @When("I login as user (.+) with password (.+)")
    public void login(String name, String password) {
        profileButton.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @When("I click Different Elements menu item")
    public void clickDiffElementMenuItem() {
        subCollection.findBy(text(SubMenuItems.DIFFERENT_ELEMENTS.getRecord())).click();
    }

    private void clickServicetMenuItem(String str) {
        menuCollection.findBy(text(str)).click();
    }

    @When("I click (.+) checkbox")
    public void checkCheckBox(String itemValue) {
        checkboxRow.findBy(text(itemValue)).shouldBe(enabled).click();
        checkboxRow.findBy(text(itemValue)).lastChild().shouldBe(checked);
    }

    @When("I unclick (.+) checkbox")
    public void checkUnCheckBox(String itemValue) {
        checkboxRow.findBy(text(itemValue)).shouldBe(enabled).click();
        checkboxRow.findBy(text(itemValue)).lastChild().shouldNotBe(checked);
    }

    @When("I click radiobutton (.+)")
    public void checkRadioButton(String itemValue) {
        radioButtonRow.findBy(text(itemValue)).shouldBe(enabled).click();
        radioButtonRow.findBy(text(itemValue)).lastChild().shouldBe(checked);
    }

    @Then("Name for loggined user is displayed")
    public void checkUserNameTitle() {
        userName.shouldHave(text(PAGE_TITLE));
    }

    @When("I click Service menu item")
    public void checkServiceMenu() {
        clickServicetMenuItem(LeftMenuItems.SERVICE.getRecord());
        for (SubMenuItems sm : SubMenuItems.values()) {
            subCollection.findBy(text(sm.getRecord())).should(exist);
        }
    }

    @When("I click (.+) color from dropdown menu")
    public void clickDropDown(String itemValue) {
        dropdown.click();
        dropdonwItemCollection.findBy(text(itemValue)).shouldBe(enabled).click();
    }

    @When("(.+) color is selected in dropdown list")
    public void checkDropDown(String itemValue) {
        dropdonwItemCollection.findBy(text(itemValue)).shouldBe(selected);
    }

    @Then("Four checkboxes are displayed")
    public void checkCheckBoxCollection() {
        checkboxCollection.shouldHaveSize(ElementsCheckBox.values().length);
    }

    @Then("Four radiobuttons are displayed")
    public void checkRadioButtonCollection() {
        radioButtonCollection.shouldHaveSize(MetalsRadioButton.values().length);
    }

    @Then("One dropdown list is displayed")
    public void checkDropDownCollection() {
        dropdownCollection.shouldHaveSize(Integer.valueOf(ElementsNumber.DROPDOWN_NUMBER.getRecord()));
    }

    @Then("Two buttons are displayed")
    public void checkButtonCollection() {
        buttonCollection.shouldHaveSize(DiffElementButtons.values().length);
    }

    @Then("Right section is displayed")
    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    @Then("Left section is displayed")
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Then("Logs for checked checkboxes are displayed in log section")
    public void checkTrueCheckBoxLogRecords() {
        checkboxLogRecords.findBy(text(LogRecordsCheckBox.TEMPLATE.getRecord("Water", "true"))).shouldBe(visible);
        checkboxLogRecords.findBy(text(LogRecordsCheckBox.TEMPLATE.getRecord("Wind", "true"))).shouldBe(visible);
    }

    @Then("Log for select radiobutton is displayed in log section")
    public void checkRadioButtonLogRecords() {
        checkboxLogRecords.findBy(text(LogRecordsRadioButton.TEMPALTE.getRecord("Selen"))).shouldBe(visible);
    }

    @Then("Log for dropdown list is displayed in log section")
    public void checkDropDownLogRecords() {
        checkboxLogRecords.findBy(text(LogRecordsDropDown.TEMPLATE.getRecord("Yellow"))).shouldBe(visible);
    }

    @Then("Logs for unclicked checkboxes are displayed")
    public void checkFalseCheckBoxLogRecords() {
        checkboxLogRecords.findBy(text(LogRecordsCheckBox.TEMPLATE.getRecord("Water", "false"))).shouldBe(visible);
        checkboxLogRecords.findBy(text(LogRecordsCheckBox.TEMPLATE.getRecord("Wind", "false"))).shouldBe(visible);
    }

    @Given("I'm on the Home Page")
    public void checkTitle() {
//        assertEquals(getWebDriver().getTitle(), MAIN_DRIVER_TITLE);
    }

}

