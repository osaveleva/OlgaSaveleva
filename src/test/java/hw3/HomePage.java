package hw3;

import base.TestBase;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import utilities.Configuration;

import static utilities.HomePageValues.*;

import static org.testng.Assert.assertEquals;


public class HomePage extends TestBase {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private Configuration cfg;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePageObject = PageFactory.initElements(driver, HomePageObject.class);
        cfg = ConfigFactory.create(Configuration.class);

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
        driver.navigate().to(cfg.url());

        //2. Assert browser title
        assertEquals(driver.getTitle(), MAINDRIVERTITLE);

        //3. Perform login
        homePageObject.login(cfg.login(), cfg.password());

        //4. Assert User name in the left-top side of screen that user is loggined;
        assertEquals(homePageObject.geTitle(), PAGETITLE);

        //5. Assert browser title
        assertEquals(driver.getTitle(), MAINDRIVERTITLE);

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        // TODO
        homePageObject.checkLeftMenu();

        //7. Assert that there are 4 images on the Index Page and they are displayed
        homePageObject.checkBenefits();

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageObject.checkSubText();

        //9. Assert a text of the main headers
        homePageObject.checkTextHeaderTitle();
        homePageObject.checkMainHeaderTitle();

        //10. Assert that there is the iframe in the center of page
        homePageObject.checkIframe();

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().frame(homePageObject.iframe);
        homePageObject.checkLogo();

        //12. Switch to original window back
        driver.switchTo().window(mainWindowHandle);

        //13. Assert a text of the sub header
        homePageObject.checkSubHeader();

        //14. Assert that JDI GITHUB is a link and has a proper URL
        homePageObject.checkSubHeaderLink();

        //15. Assert that there is Left Section
        homePageObject.checkLeftSection();

        //16. Assert that there is Footer
        homePageObject.checkFooter();
    }
}
