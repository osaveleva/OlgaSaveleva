package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import enums.Credentials;
import enums.LeftMenuItems;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Configuration;

import static base.HomePageValues.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePageCucumberPageObject {
    private Configuration cfg = ConfigFactory.create(Configuration.class);

    public HomePageCucumberPageObject() {
        //open(cfg.url());
        page(this);
    }

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

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

    @And("Login as {peter}")
    public void i_supply_enum_value(Credentials credentials) {
        profileButton.click();
        nameField.sendKeys(credentials.getLogin());
        passwordField.sendKeys(credentials.getPassword());
        loginButton.click();
        userName.shouldHave(text(USER_NAME));
    }

    @When("I click on {menu} button in submenu")
    public void clickServicetMenuItem(LeftMenuItems value) {
        subCollection.findBy(text(value.getRecord())).click();
    }

    @When("I click on {menu} button in Header")
    public void clickMenu(LeftMenuItems v) {
        System.out.println(v.getRecord());
        menuCollection.findBy(text(v.getRecord())).click();
    }


    @Given("I'm on the Home Page")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), MAIN_DRIVER_TITLE);
    }

}