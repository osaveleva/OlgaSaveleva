package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageObject {

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "#name")
    private WebElement nameField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "#login-button")
    private WebElement loginButton;

    @FindBy(css = "#user-name")
    private WebElement userName;

    @FindBy(css = ".sidebar-menu > li")
    public List<WebElement> sidebarItems;

    @FindBy(css = ".icons-benefit")
    public List<WebElement> icons;

    @FindBy(css = ".benefit-txt")
    public List<WebElement> textItems;

    @FindBy(xpath = "//*[@class = 'sidebar-menu']//span[text() = 'Service']")
    public WebElement itemService;

    @FindBy(xpath = "//*[@class = 'sidebar-menu']//span[text() = 'Contact form']")
    public WebElement itemContactForm;

    @FindBy(xpath = "//*[@class = 'sidebar-menu']//span[text() = 'Home']")
    public WebElement itemHome;

    @FindBy(xpath = "//*[@class = 'sidebar-menu']//span[text() = 'Metals & Colors']")
    public WebElement itemMetalsColors;

    @FindBy(xpath = "//*[@class = 'sidebar-menu']//span[text() = 'Elements packs']")
    public WebElement itemElementsPacks;

    @FindBy(css = ".icons-benefit.icon-practise")
    public WebElement iconPractise;

    @FindBy(css = ".icons-benefit.icon-multi")
    public WebElement iconMulti;

    @FindBy(css = ".icons-benefit.icon-custom")
    public WebElement iconCustom;

    @FindBy(css = ".icons-benefit.icon-base")
    public WebElement iconBase;

    @FindBy(css = "div.row > div .benefit-txt")
    public List<WebElement> textCollection;

    @FindBy(css = "h3.main-title.text-center")
    public WebElement mainHeader;

    @FindBy(css = "p.main-txt")
    public WebElement textHeader;

    @FindBy(css = "iframe#iframe")
    public WebElement iframe;

    @FindBy(css = "#epam_logo")
    public WebElement logo;

    @FindBy(css = "h3:nth-child(3)>a")
    public WebElement subheader;

    @FindBy(css = "#mCSB_1")
    public WebElement leftSection;

    @FindBy(css = ".footer-content")
    public WebElement footer;

    public void login(String name, String password) {
        profileButton.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String geTitle() {
        return userName.getText();
    }

    public int getListSize(List<WebElement> list) {
        return list.size();
    }
}
