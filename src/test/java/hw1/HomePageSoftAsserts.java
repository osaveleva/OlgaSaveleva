package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertTrue;


public class HomePageSoftAsserts {

    private List<String> makeListCollection(List<WebElement> collection) {
        List<String> menuList = new ArrayList<>();
        menuList.clear();
        for (WebElement ele : collection) {
            menuList.add(ele.getText());
        }
        return menuList;
    }

    @Test
    public void checkHomePage() {
        List<String> listText = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project", "To be flexible and\ncustomizable", "To be multiplatform", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        List<String> listMenu = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

        SoftAssert softAssert = new SoftAssert();
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1. Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //3. Assert browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //4. Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#password")).sendKeys("1234");
        driver.findElement(By.cssSelector("#login-button")).click();

        //5. Assert User name in the left-top side of screen that user is loggined
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        softAssert.assertEquals(username.getText(), "PITER CHAILOVSKII");

        //6. Assert browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //7. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> sidebarItems = driver.findElements(By.cssSelector(".sidebar-menu > li"));
        softAssert.assertEquals(sidebarItems.size(), 5);

        List<String> menuCollection = makeListCollection(sidebarItems);
        for (String elementMenu : listMenu) {
            assertTrue(menuCollection.contains(elementMenu));
        }

        //8. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> iconsItems = driver.findElements(By.cssSelector(".icons-benefit"));
        softAssert.assertEquals(iconsItems.size(), 4);

        WebElement iconPractise = driver.findElement(By.cssSelector(".icons-benefit.icon-practise"));
        softAssert.assertTrue(iconPractise.isDisplayed());

        WebElement iconCustom = driver.findElement(By.cssSelector(".icons-benefit.icon-custom"));
        softAssert.assertTrue(iconCustom.isDisplayed());

        WebElement iconMulti = driver.findElement(By.cssSelector(".icons-benefit.icon-multi"));
        softAssert.assertTrue(iconMulti.isDisplayed());

        WebElement iconBase = driver.findElement(By.cssSelector(".icons-benefit.icon-base"));
        softAssert.assertTrue(iconBase.isDisplayed());

        //9. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textItems = driver.findElements(By.cssSelector(".benefit-txt"));
        softAssert.assertEquals(textItems.size(), 4);

        List<String> textCollection = makeListCollection(driver.findElements(By.cssSelector("div.row > div .benefit-txt")));
        for (String elementText : listText) {
            assertTrue(textCollection.contains(elementText));
        }

        //10. Assert a text of the main headers
        WebElement mainHeader = driver.findElement(By.cssSelector("h3.main-title.text-center"));
        softAssert.assertTrue(mainHeader.isDisplayed());
        softAssert.assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement textHeader = driver.findElement(By.cssSelector("p.main-txt"));
        softAssert.assertTrue(textHeader.isDisplayed());
        softAssert.assertEquals(textHeader.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //11. Assert that there is the iframe in the center of page
        WebElement iframe = driver.findElement(By.cssSelector("iframe#iframe"));
        softAssert.assertTrue(iframe.isDisplayed());

        //12. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().frame(iframe);
        WebElement logo = driver.findElement(By.cssSelector("#epam_logo"));
        softAssert.assertEquals(logo.getAttribute("src"), "https://epam.github.io/JDI/images/Logo_Epam_Color.svg");

        //13. Switch to original window back
        driver.switchTo().window(mainWindowHandle);

        //14. Assert a text of the sub header
        WebElement subheader = driver.findElement(By.cssSelector("h3:nth-child(3)>a"));
        softAssert.assertEquals(subheader.getText(), "JDI GITHUB");

        //15. Assert that JDI GITHUB is a link and has a proper URL
        softAssert.assertEquals(subheader.getAttribute("href"), "https://github.com/epam/JDI");

        //16. Assert that there is Left Section
        softAssert.assertTrue(driver.findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //17. Assert that there is Footer
        softAssert.assertTrue(driver.findElement(By.cssSelector(".footer-content")).isDisplayed());

        softAssert.assertAll();

        //18. Close Browser
        driver.close();

    }
}
