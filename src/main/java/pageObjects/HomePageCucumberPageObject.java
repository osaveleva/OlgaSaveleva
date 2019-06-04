package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.LeftMenuItems;
import enums.SubMenuItems;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import utilities.Configuration;

import static base.HomePageValues.MAIN_DRIVER_TITLE;
import static base.HomePageValues.USER_NAME;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePageCucumberPageObject {
    private Configuration cfg = ConfigFactory.create(Configuration.class);

    public HomePageCucumberPageObject() {
        open(cfg.url());
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

    @When("I login as user (.+) with password (.+)")
    public void login(String name, String password) {
        profileButton.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @And("I login as user 'Piter Chailovskii'")
    public void checkUserNameTitle() {
        userName.shouldHave(text(USER_NAME));
    }

    @When("I click on 'Service' button in Header")
    public void clickServicetMenuItem() {
        menuCollection.findBy(text(LeftMenuItems.SERVICE.getRecord())).click();
    }

    @Given("I'm on the Home Page")
    public void checkTitle() {
        login(cfg.login(), cfg.password());
        assertEquals(getWebDriver().getTitle(), MAIN_DRIVER_TITLE);
    }

    @When("I close browser")
    public void workaroun() {
        closeWebDriver();
    }

}