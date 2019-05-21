package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageObject {

    @FindBy (css = ".profile-photo")
    private WebElement profileButton;

    @FindBy (css = "#name")
    private WebElement nameField;

    @FindBy (css = "#password")
    private WebElement passwordField;

    @FindBy (css = "#login-button")
    private WebElement loginButton;

    @FindBy (css = "#user-name")
    private WebElement userName;

    @FindBy (css = ".sidebar-menu > li")
    private List<WebElement> sidebarItems;

    @FindBy(xpath = "//*[@class = 'sidebar-menu']//span[text() = 'Service']")
    private WebElement itemService;

    @FindBy(xpath = "//*[@class = 'sidebar-menu']//span[text() = 'Contact form']")
    private WebElement itemContactForm;

    @FindBy(xpath = "//*[@class = 'sidebar-menu']//span[text() = 'Home']")
    private WebElement itemHome;

    @FindBy(xpath = "//*[@class = 'sidebar-menu']//span[text() = 'Metals & Colors']")
    private WebElement itemMetalsColors;

    @FindBy(xpath = "//*[@class = 'sidebar-menu']//span[text() = 'Elements packs']")
    private WebElement itemElementsPacks;

    public WebElement getItemService() {
        return itemService;
    }

    public WebElement getItemContactForm() {
        return itemContactForm;
    }

    public WebElement getItemHome() {
        return itemHome;
    }

    public WebElement getItemMetalsColors() {
        return itemMetalsColors;
    }

    public WebElement getItemElementsPacks() {
        return itemElementsPacks;
    }

    public void login(String name, String password){
        profileButton.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String geTitle() {
        return userName.getText();
    }

    public int getSideBarSize(){
        return sidebarItems.size();
    }
}
