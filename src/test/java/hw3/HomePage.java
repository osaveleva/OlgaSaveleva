package hw3;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;

import java.util.List;

import static java.lang.System.setProperty;
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
        assertEquals(homePageObject.getSideBarSize(),5);

        assertTrue(homePageObject.getItemService().isDisplayed());
        assertTrue(homePageObject.getItemHome().isDisplayed());
        assertTrue(homePageObject.getItemContactForm().isDisplayed());
        assertTrue(homePageObject.getItemMetalsColors().isDisplayed());
        assertTrue(homePageObject.getItemElementsPacks().isDisplayed());

        //7. Assert that there are 4 images on the Index Page and they are displayed
        List <WebElement> iconsItems = driver.findElements(By.cssSelector(".icons-benefit"));
        assertEquals(iconsItems.size(), 4);

        WebElement iconPractise = driver.findElement(By.cssSelector(".icons-benefit.icon-practise"));
        assertTrue(iconPractise.isDisplayed());

        WebElement iconCustom = driver.findElement(By.cssSelector(".icons-benefit.icon-custom"));
        assertTrue(iconCustom.isDisplayed());

        WebElement iconMulti = driver.findElement(By.cssSelector(".icons-benefit.icon-multi"));
        assertTrue(iconMulti.isDisplayed());

        WebElement iconBase = driver.findElement(By.cssSelector(".icons-benefit.icon-base"));
        assertTrue(iconBase.isDisplayed());

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List <WebElement> textItems = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(textItems.size(), 4);

        WebElement iconPractiseText = driver.findElement(By.cssSelector("div.row > div:nth-child(1) .benefit-txt"));
        assertTrue(iconPractiseText.isDisplayed());
        assertEquals(iconPractiseText.getText(), "To include good practices\nand ideas from successful\nEPAM project");

        WebElement iconCustomText = driver.findElement(By.cssSelector("div.row > div:nth-child(2) .benefit-txt"));
        assertTrue(iconCustomText.isDisplayed());
        assertEquals(iconCustomText.getText(), "To be flexible and\ncustomizable");

        WebElement iconMultiText = driver.findElement(By.cssSelector("div.row > div:nth-child(3) .benefit-txt"));
        assertTrue(iconMultiText.isDisplayed());
        assertEquals(iconMultiText.getText(), "To be multiplatform");

        WebElement iconBaseText = driver.findElement(By.cssSelector("div.row > div:nth-child(4) .benefit-txt"));
        assertTrue(iconBaseText.isDisplayed());
        assertEquals(iconBaseText.getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //9. Assert a text of the main headers
        WebElement mainHeader = driver.findElement(By.cssSelector("h3.main-title.text-center"));
        assertTrue(mainHeader.isDisplayed());
        assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement textHeader = driver.findElement(By.cssSelector("p.main-txt"));
        assertTrue(textHeader.isDisplayed());
        assertEquals(textHeader.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10. Assert that there is the iframe in the center of page
        WebElement iframe = driver.findElement(By.cssSelector("iframe#iframe"));
        assertTrue(iframe.isDisplayed());

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String mainWindowHandle=driver.getWindowHandle();
        driver.switchTo().frame(iframe);
        WebElement logo = driver.findElement(By.cssSelector("#epam_logo"));
        assertEquals(logo.getAttribute("src"), "https://epam.github.io/JDI/images/Logo_Epam_Color.svg");

        //12. Switch to original window back
        driver.switchTo().window(mainWindowHandle);

        //13. Assert a text of the sub header
        WebElement subheader = driver.findElement(By.cssSelector("h3:nth-child(3)>a"));
        assertEquals(subheader.getText(), "JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subheader.getAttribute("href"), "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //16. Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector(".footer-content")).isDisplayed());

    }
}
