package pageObjects;

import enums.ElementsNumber;
import enums.LeftMenuItems;
import enums.SubTextValues;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static base.HomePageValues.*;

import java.util.List;

import static java.util.stream.Collectors.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
    private List<WebElement> sidebarItems;

    @FindBy(css = ".icons-benefit")
    public List<WebElement> icons;

    @FindBy(css = ".benefit-txt")
    public List<WebElement> textItems;

    @FindBy(css = "div.row > div .benefit-txt")
    private List<WebElement> textCollection;

    @FindBy(css = "h3.main-title.text-center")
    private WebElement mainHeader;

    @FindBy(css = "p.main-txt")
    private WebElement textHeader;

    @FindBy(css = "iframe#iframe")
    public WebElement iframe;

    @FindBy(css = "#epam_logo")
    public WebElement logo;

    @FindBy(css = "h3:nth-child(3)>a")
    private WebElement subheader;

    @FindBy(css = "#mCSB_1")
    private WebElement leftSection;

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

    // TODO
    private List<String> makeListCollection(List<WebElement> collection) {
        return collection.stream()
                .map(WebElement::getText)
                .collect(toList());
    }

    public void checkLeftMenu() {
        assertEquals(sidebarItems.size(), LeftMenuItems.values().length);
        for (LeftMenuItems st : LeftMenuItems.values()) {
            assertTrue(makeListCollection(sidebarItems).contains(st.getRecord()));
        }
        for (WebElement ele : sidebarItems) {
            assertTrue(ele.isDisplayed());
        }
    }

    public void checkSubText() {
        assertEquals(textCollection.size(), SubTextValues.values().length);
        for (SubTextValues st : SubTextValues.values()) {
            assertTrue(makeListCollection(textCollection).contains(st.getRecord()));
        }
        for (WebElement ele : textCollection) {
            assertTrue(ele.isDisplayed());
        }
    }

    public void checkBenefits() {
        int size = Integer.valueOf(ElementsNumber.ICONS_NUMBER.getRecord());
        assertEquals(icons.size(), size);
        for (WebElement ele : icons) {
            assertTrue(ele.isDisplayed());
        }
    }

    public void checkTextHeaderTitle() {
        assertTrue(textHeader.isDisplayed());
    }

    public void checkMainHeaderTitle() {
        assertTrue(mainHeader.isDisplayed());
    }

    public void checkIframe() {
        assertTrue(iframe.isDisplayed());
    }

    public void checkLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }

    public void checkLogo() {
        assertEquals(logo.getAttribute("src"), LOGO);
    }

    public void checkSubHeader() {
        assertEquals(subheader.getText(), SUBHEADER);
    }

    public void checkSubHeaderLink() {
        assertEquals(subheader.getAttribute("href"), HREF);
    }


}

