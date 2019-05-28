package hw3;

import base.TestBase;
import enums.LeftMenuItems;
import enums.SubTextValues;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import utilities.PropertyManager;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage extends TestBase {

    private WebDriver driver;
    private HomePageObject homePageObject;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePageObject = PageFactory.initElements(driver, HomePageObject.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void checkHomePage() {

        //1. Open test site by URL
        driver.navigate().to(PropertyManager.getInstance().getURL());

        //2. Assert browser title
        assertEquals(driver.getTitle(), PropertyManager.getInstance().getMainDriverTitle());

        //3. Perform login
        homePageObject.login(PropertyManager.getInstance().getLogin(), PropertyManager.getInstance().getPassword());

        //4. Assert User name in the left-top side of screen that user is loggined;
        assertEquals(homePageObject.geTitle(), PropertyManager.getInstance().getPageTitle());

        //5. Assert browser title
        assertEquals(driver.getTitle(), PropertyManager.getInstance().getMainDriverTitle());

        // TODO Why don't you create one single method for each steps 6,7,8 ?
        // TODO Basically, it is not really great idea to work with PO elements directly.
        //      This is possible is some cases, but in general we should create a methods, that allow us
        //      to make low-level selenium calls, just keep it in your mind.

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertTrue(homePageObject.checkLeftMenuProperty(LeftMenuItems.values().length));

        //7. Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(homePageObject.checkIconProperty(PropertyManager.getInstance().getIconSize()));

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertTrue(homePageObject.checkSubTextProperty(SubTextValues.values().length));

        //9. Assert a text of the main headers
        assertTrue(homePageObject.checkTextHeaderTitleVisiblity());
        assertTrue(homePageObject.checkMainHeaderTitleVisibility());

        //10. Assert that there is the iframe in the center of page
        assertTrue(homePageObject.checkIframeVisibility());

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().frame(homePageObject.iframe);
        assertTrue(homePageObject.checkLogoValue(PropertyManager.getInstance().getLogo()));

        //12. Switch to original window back
        driver.switchTo().window(mainWindowHandle);

        //13. Assert a text of the sub header
        assertTrue(homePageObject.checkSubHeaderText(PropertyManager.getInstance().getSubHeader()));

        //14. Assert that JDI GITHUB is a link and has a proper URL
        assertTrue(homePageObject.checkSubHeaderLink(PropertyManager.getInstance().getHref()));

        //15. Assert that there is Left Section
        assertTrue(homePageObject.checkLeftSectionVisibility());

        //16. Assert that there is Footer
        assertTrue(homePageObject.checkFooterVisibility());

    }
}
