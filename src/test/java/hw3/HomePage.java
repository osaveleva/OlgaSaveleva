package hw3;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;


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
    public void afterMethod(){
       driver.close();
    }

    @Test
    public void checkHomePage(){
        //1. Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2. Assert browser title
        assertEquals(driver.getTitle(),"Home Page");

        //3. Perform login
        homePageObject.login("epam", "1234");

        //4. Assert User name in the left-top side of screen that user is loggined;
        assertEquals(homePageObject.geTitle(), "PITER CHAILOVSKII");

        //5. Assert browser title
        assertEquals(driver.getTitle(),"Home Page");

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertEquals(homePageObject.getListSize(homePageObject.sidebarItems),5);

        assertTrue(homePageObject.itemService.isDisplayed());
        assertTrue(homePageObject.itemHome.isDisplayed());
        assertTrue(homePageObject.itemContactForm.isDisplayed());
        assertTrue(homePageObject.itemMetalsColors.isDisplayed());
        assertTrue(homePageObject.itemElementsPacks.isDisplayed());

        //7. Assert that there are 4 images on the Index Page and they are displayed
        assertEquals(homePageObject.getListSize(homePageObject.icons),4);

        assertTrue(homePageObject.iconPractise.isDisplayed());
        assertTrue(homePageObject.iconMulti.isDisplayed());
        assertTrue(homePageObject.iconCustom.isDisplayed());
        assertTrue(homePageObject.iconBase.isDisplayed());

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(homePageObject.getListSize(homePageObject.textItems),4);

        assertTrue(homePageObject.iconPractiseText.isDisplayed());
        assertEquals(homePageObject.iconPractiseText.getText(), "To include good practices\nand ideas from successful\nEPAM project");

        assertTrue(homePageObject.iconCustomText.isDisplayed());
        assertEquals(homePageObject.iconCustomText.getText(), "To be flexible and\ncustomizable");

        assertTrue(homePageObject.iconMultiText.isDisplayed());
        assertEquals(homePageObject.iconMultiText.getText(), "To be multiplatform");

        assertTrue(homePageObject.iconBaseText.isDisplayed());
        assertEquals(homePageObject.iconBaseText.getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //9. Assert a text of the main headers
        assertTrue(homePageObject.mainHeader.isDisplayed());
        assertEquals(homePageObject.mainHeader.getText(), "EPAM FRAMEWORK WISHES…");

        assertTrue(homePageObject.textHeader.isDisplayed());
        assertEquals(homePageObject.textHeader.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10. Assert that there is the iframe in the center of page
        assertTrue(homePageObject.iframe.isDisplayed());

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String mainWindowHandle=driver.getWindowHandle();
        driver.switchTo().frame(homePageObject.iframe);
        assertEquals(homePageObject.logo.getAttribute("src"), "https://epam.github.io/JDI/images/Logo_Epam_Color.svg");

        //12. Switch to original window back
        driver.switchTo().window(mainWindowHandle);

        //13. Assert a text of the sub header
        assertEquals(homePageObject.subheader.getText(), "JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(homePageObject.subheader.getAttribute("href"), "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        assertTrue(homePageObject.leftSection.isDisplayed());

        //16. Assert that there is Footer
        assertTrue(homePageObject.footer.isDisplayed());

    }
}
