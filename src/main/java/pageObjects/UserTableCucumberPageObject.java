package pageObjects;

import com.codeborne.selenide.*;
import com.codeborne.selenide.impl.WebElementsCollection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.*;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import utilities.Configuration;


import static base.HomePageValues.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;


public class UserTableCucumberPageObject {
    private Configuration cfg = ConfigFactory.create(Configuration.class);

    public UserTableCucumberPageObject() {
        page(this);
    }

    @FindBy(css = "tr input[type ='checkbox']")
    private ElementsCollection checkBoxCollection;

    @FindBy(css = ".sub > li")
    private ElementsCollection subCollection;

    @FindBy(css = ".support-title")
    private SelenideElement userPageHeader;

    @FindBy(css = "tr select")
    private ElementsCollection dropdownList;

    @FindBy(css = "tr a")
    private ElementsCollection userNameList;

    @FindBy(css = "tr img")
    private ElementsCollection imgList;

    @FindBy(css = "#user-table")
    private SelenideElement table;

    @FindBy(css = "tr div span")
    private ElementsCollection subText;

    @FindBy(css = "#ivan")
    private SelenideElement ivanCheckBox;

    @FindBy(css = ".panel-body-list > li")
    private ElementsCollection logCollection;

    @FindBy(css = "select > option")
    private ElementsCollection dropdownValues;


    @And("I select 'vip' checkbox for 'Sergey Ivan'")
    public void checkIvanCheckbox() {
        ivanCheckBox.click();
        ivanCheckBox.shouldBe(checked);
    }

    @Then("1 log row has 'Vip: condition changed to (.+)' text in log section'")
    public void checkVipCheckboxLogs(String value) {
        logCollection.findBy(text(LogRecordsVipCheckBox.getRecord("true"))).shouldBe(visible);
    }

    @And("(\\d+) checkboxes are displayed on Users Table on User Table Page")
    public void getCheckBoxNumber(int size) {
        subText.shouldHaveSize(size);
    }

    @And("User table contains following values: (.+), (.*), (.*)")
    public void checkTable(String num, String name, String description) {
        table
                .find(byText(name)).should(visible)
                .closest("tr")
                .find(byText(description)).should(visible)
                .closest("tr")
                .find(byText(num)).should(visible);
    }

    @When("I click on dropdown in column Type for user (.+)")
    public void clickRomanDropDown(String name) {
        table
                .find(byText(name)).should(visible)
                .closest("tr")
                .findElement(By.tagName("select")).click();

    }

    @Then("droplist contains values (.+)")
    public void checkDropDownListValues(String value) {
        dropdownValues.findBy(text(value)).shouldBe(visible);
    }

    @And("(\\d+) Description texts under images are displayed on Users Table on User Table Page")
    public void getSubTextNumber(int size) {
        subText.shouldHaveSize(size);
    }

    @And("(\\d+) User names are displayed on Users Table on User Table Page")
    public void getUserNameNumber(int size) {
        userNameList.shouldHaveSize(size);
    }

    @And("(\\d+) Description images are displayed on Users Table on User Table Page")
    public void getImgNumber(int size) {
        imgList.shouldHaveSize(size);
    }

    @And("(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void getDropDownNumber(int size) {
        dropdownList.shouldHaveSize(size);
    }

    @Then("'User Table' page is opened")
    public void checkUserPAfeTitle() {
        userPageHeader.shouldHave(text(USER_PAGE_TITLE));

    }

    @And("I click on User Table button in Service dropdown")
    public void clickDiffElementMenuItem() {
        subCollection.findBy(text(SubMenuItems.USER_TABLE.getRecord())).click();
    }
}

