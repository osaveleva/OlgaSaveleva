package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


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

    @FindBy(css = ".sub > li")
    public List<SelenideElement> subCollection;

    @FindBy(css = ".panel-body-list.logs > li")
    private List<SelenideElement> logCollection;

    //@FindBy(css = ".label-checkbox")
    //private List<SelenideElement> checkboxCollection;

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

    public void clickMenuItem(List<SelenideElement> collection, String str) {
        for (SelenideElement ele : collection) {
            if (ele.getText().equals(str)) {
                ele.click();
                return;
            }
        }
    }

    public List<String> getSubMenuItems(List<SelenideElement> collectionList) {
        List<String> subText = new ArrayList<String>();
        for (SelenideElement a : collectionList) {
            subText.add(a.getText());
        }
        return subText;
    }

    public SelenideElement checkCheckBox(List <SelenideElement> checkCollection, String checkboxValue){
        for (SelenideElement check: checkCollection){
            if(check.parent().getText().equals(checkboxValue)) {
                check.parent().click();
                return check;
            }
        }
        return null;
    }

    public boolean checkLog(String record){
        for (SelenideElement log: logCollection) {
            if (log.getText().contains(record)){
                return true;
            }
        }
        return false;
    }

}
