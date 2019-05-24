package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class DatesSelenidePageObject {
    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "#name")
    private SelenideElement nameField;

    @FindBy(css = "#password")
    private SelenideElement passwordField;

    @FindBy(css = "#login-button")
    private SelenideElement loginButton;

    @FindBy(css = "#user-name")
    public SelenideElement userName;

    @FindBy(css = ".sidebar-menu > li")
    public List<SelenideElement> menuCollection;

    @FindBy(css = ".sub > li")
    public List<SelenideElement> subCollection;

    @FindBy(css = ".ui-slider-handle:nth-child(1)")
    public SelenideElement From;

    public void login(String name, String password) {
        profileButton.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public SelenideElement clickMenuItem(List<SelenideElement> collection, String str) {
        for (SelenideElement ele : collection) {
            if (ele.getText().equals(str)) {
                ele.click();
                return ele;
            }
        }
        return null;
    }


}

