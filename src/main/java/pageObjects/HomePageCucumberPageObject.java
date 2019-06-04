package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static base.HomePageValues.PAGE_TITLE;
import static com.codeborne.selenide.Condition.*;

public class HomePageSelenidePageObject {

    @FindBy(css = ".profile-photo")
    public WebElement profileButton;

    @FindBy(css = "#name")
    public SelenideElement nameField;

    @FindBy(css = "#password")
    public SelenideElement passwordField;

    @FindBy(css = "#login-button")
    public SelenideElement loginButton;

    @FindBy(css = "#user-name")
    public SelenideElement userName;

    @FindBy(css = ".sidebar-menu > li")
    public ElementsCollection menuCollection;

    @When("I login as user (.+) with password (.+)")
    public void login(String name, String password) {
        profileButton.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @When ("I click Service menu item")
    public void clickServicetMenuItem(String str) {
        menuCollection.findBy(text(str)).click();
    }

    @Then("Name for loggined user is displayed")
    public void checkUserNameTitle() {
        userName.shouldHave(text(PAGE_TITLE));
    }
}