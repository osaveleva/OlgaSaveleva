package pageObjects;

import com.codeborne.selenide.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.*;
import io.cucumber.datatable.DataTable;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import utilities.Configuration;


import javax.xml.bind.Element;
import java.util.List;
import java.util.Map;

import static base.HomePageValues.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;


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

    @FindBy(css = "#user-table tbody tr")
    private ElementsCollection tableRow;


    //@And("I select 'vip' checkbox for 'Sergey Ivan'")
    //public void checkIvanCheckbox() {
    //    ivanCheckBox.click();
    //    ivanCheckBox.shouldBe(checked);
    //}

    @Then("1 log row has 'Vip: condition changed to (.+) text in log section'")
    public void checkVipCheckboxLogs(String value) {
        logCollection.findBy(text(LogRecordsVipCheckBox.getRecord(value))).shouldBe(visible);
    }

    @And("(\\d+) checkboxes are displayed on Users Table on User Table Page")
    public void getCheckBoxNumber(int size) {
        subText.shouldHaveSize(size);
    }

    @And("User table contains following values:")
    public void checkTable(DataTable dt) {

        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        SelenideElement td;
        for (int i = 0; i < list.size(); i++) {
            td = table.find(byText(list.get(i).get("Number"))).shouldBe(visible).closest("tr");
            for (String word : list.get(i).get("Description").split("\\s+")) {
                td.shouldHave(text(word));
            }
            td.shouldHave(text(list.get(i).get("User")));
        }
    }

    @When("I click on dropdown in column Type for user (.+)")
    public void clickRomanDropDown(String name) {
        table
                .find(byText(name)).should(visible)
                .closest("tr")
                .findElement(By.tagName("select")).click();
    }

    @When("I select (.*) checkbox for (.*)")
    public void checkIvanCheckbox(String vip, String name) {
        SelenideElement td1 = table
                .find(byText(name)).should(visible)
                .closest("tr");
        td1.find(byText(vip)).click();
        td1.find(By.tagName("input")).shouldBe(checked);
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

}

