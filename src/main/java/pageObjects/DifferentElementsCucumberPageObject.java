package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.*;
import io.cucumber.datatable.DataTable;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import utilities.Configuration;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static org.testng.Assert.assertEquals;


public class DifferentElementsCucumberPageObject {
    private Configuration cfg = ConfigFactory.create(Configuration.class);

    public DifferentElementsCucumberPageObject() {
        page(this);
    }

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


    @When("I (select)(unclick) nature elements below:")
    public void clickNatureElements(List<NatureElementsCheckBox> natureElements) {
        int a = 0;
        int b = 10;
        int c = 9;
       /* List<String> list = dt.asList(String.class);
        for (String aList : list) {
            if (!checkboxRow.findBy(text(aList)).lastChild().is(checked)) {
                checkboxRow.findBy(text(aList)).shouldBe(enabled).click();
                checkboxRow.findBy(text(aList)).lastChild().shouldBe(checked);
            } else {
                checkboxRow.findBy(text(aList)).shouldBe(enabled).click();
                checkboxRow.findBy(text(aList)).lastChild().shouldNotBe(checked);
            }
        }*/


    }

    @When("I click radiobutton (.+)")
    public void checkRadioButton(String itemValue) {
        radioButtonRow.findBy(text(itemValue)).shouldBe(enabled).click();
        radioButtonRow.findBy(text(itemValue)).lastChild().shouldBe(checked);
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
    public void checkNatureCheckBox() {
        checkboxCollection.shouldHaveSize(NatureElementsCheckBox.values().length);
    }

    @Then("Four radiobuttons are displayed")
    public void checkMetalsRadioButton() {
        radioButtonCollection.shouldHaveSize(MetalsRadioButton.values().length);
    }

    @Then("One dropdown list is displayed")
    public void checkDropDown() {
        dropdownCollection.shouldHaveSize(Integer.valueOf(ElementsNumber.DROPDOWN_NUMBER.getRecord()));
    }

    @Then("Two buttons are displayed")
    public void checkButtons() {
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

    @Then("Log for (.+) element with (.+) status is displayed in log section")
    public void checkNatureCheckBoxLogRecords(String element, String status) {
        checkboxLogRecords.findBy(text(LogRecordsElementsCheckBox.getRecord(element, status))).shouldBe(visible);
    }

    @Then("Log for (.+) radiobutton is displayed in log section")
    public void checkRadioButtonLogRecords(String metail) {
        checkboxLogRecords.findBy(text(LogRecordsMetalsRadioButton.getRecord(metail))).shouldBe(visible);
    }

    @Then("Log for (.+) color in dropdown list is displayed in log section")
    public void checkDropDownLogRecords(String color) {
        checkboxLogRecords.findBy(text(LogRecordsDropDown.getRecord(color))).shouldBe(visible);
    }

}

