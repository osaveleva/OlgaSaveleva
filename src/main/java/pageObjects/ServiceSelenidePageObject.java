package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


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
    public SelenideElement userName;

    @FindBy(css = ".sidebar-menu > li")
    public List<SelenideElement> menuCollection;

    @FindBy(css = ".colors > select > option")
    public List<SelenideElement> dropdonwCollection;

    @FindBy(css = ".colors")
    public SelenideElement dropdown;

    @FindBy(css = ".sub > li")
    public List<SelenideElement> subCollection;

    @FindBy(css = ".label-checkbox input[type ='checkbox']")
    public List<SelenideElement> checkboxValueCollection;

    @FindBy(css = ".label-radio input[type ='radio']")
    public List<SelenideElement> radioButtonValueCollection;


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

    public List<String> getSubMenuItems(List<SelenideElement> collectionList) {
        List<String> subText = new ArrayList<String>();
        for (SelenideElement a : collectionList) {
            subText.add(a.getText());
        }
        return subText;
    }

    public SelenideElement checkCheckBox(List<SelenideElement> checkCollection, String checkboxValue) {
        for (SelenideElement check : checkCollection) {
            if (check.parent().getText().equals(checkboxValue)) {
                check.parent().click();
                return check;
            }
        }
        return null;
    }


    public void clickDropDown() {
        dropdown.click();
    }
}
