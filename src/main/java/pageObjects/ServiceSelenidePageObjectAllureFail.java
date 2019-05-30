package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static base.HomePageValues.*;


public class ServiceSelenidePageObjectAllureFail {
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

    @Step
    public void login(String name, String password) {
        profileButton.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @Step
    public void checkUserNameTitle() {
        userName.shouldHave(text(INVALIDUSERNAME));
    }
}

