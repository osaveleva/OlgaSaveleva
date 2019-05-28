package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.WebElementsCollection;
import enums.SubMenuItems;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;


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
    private SelenideElement userName;

    @FindBy(css = ".sidebar-menu > li")
    public List<SelenideElement> menuCollection;

    @FindBy(css = ".colors > select > option")
    public List<SelenideElement> dropdonwItemCollection;

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

    @FindBy(css = ".label-radio input[type ='radio']")
    public List<SelenideElement> radioButtonValueCollection;

    @FindBy(css = "div[name='log-sidebar']]")
    private SelenideElement rightSection;

    @FindBy(css = "div[name='navigation-sidebar']")
    private SelenideElement leftSection;






    public void login(String name, String password) {
        profileButton.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void clickDiffElementMenuItem(String str) {
        for (SelenideElement ele : subCollection) {
            if (ele.getText().equals(str)) {
                ele.click();
                return;
            }
        }

    }

    private void clickServicetMenuItem(String str) {
        for (SelenideElement ele : menuCollection) {
            if (ele.getText().equals(str)) {
                ele.click();
                return;
            }
        }

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

    public void checkUserNameTitle(String configValue) {
        userName.shouldHave(text(configValue));
    }

    public void checkServiceMenu(String configValue) {
        clickServicetMenuItem(configValue);
        for (SubMenuItems sm : SubMenuItems.values()) {
            subCollection.findBy(text(sm.getRecord())).should(exist);
        }
    }

    public void clickDropDown() {
        dropdown.click();
    }

    public void checkCheckBoxCollectionSize(int configValue) {
        checkboxCollection.shouldHaveSize(configValue);
    }

    public void checkRadioButtonCollectionSize(String configValue) {
        radioButtonCollection.shouldHaveSize(Integer.valueOf(configValue));
    }

    public void checkDropDownCollectionSize(String configValue) {
        dropdownCollection.shouldHaveSize(Integer.valueOf(configValue));
    }

    public void checkButtonCollectionSize(String configValue) {
        buttonCollection.shouldHaveSize(Integer.valueOf(configValue));
    }

    public void checkRightSectionVisibility(){
        rightSection.shouldBe(visible);
    }

    public void checkLeftSectionVisibility(){
        leftSection.shouldBe(visible);
    }
}
