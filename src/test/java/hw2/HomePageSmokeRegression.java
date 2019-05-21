package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSmokeRegression {

    @Test (groups = {"Regression"})
    public void checkHomePageFirst(){
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1. Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //3. Assert browser title
        assertEquals(driver.getTitle(),"Home Page");

        //4. Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#password")).sendKeys("1234");
        driver.findElement(By.cssSelector("#login-button")).click();

        //5. Assert User name in the left-top side of screen that user is loggined
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        assertEquals(username.getText(), "PITER CHAILOVSKII");

        //6. Assert browser title
        assertEquals(driver.getTitle(),"Home Page");

        //7. Assert that there are 4 items on the header section are displayed and they have proper texts
        List <WebElement> sidebarItems = driver.findElements(By.cssSelector(".sidebar-menu > li"));
        assertEquals(sidebarItems.size(), 5);

        WebElement homeItem = driver.findElement(By.cssSelector(".sidebar-menu > li:nth-child(1)"));
        assertTrue(homeItem.isDisplayed());
        assertEquals(homeItem.getText(),"Home");

        WebElement contactFormItem = driver.findElement(By.cssSelector(".sidebar-menu > li:nth-child(2)"));
        assertTrue(contactFormItem.isDisplayed());
        assertEquals(contactFormItem.getText(),"Contact form");

        WebElement serviceItem = driver.findElement(By.cssSelector(".sidebar-menu > li:nth-child(3)"));
        assertTrue(serviceItem.isDisplayed());
        assertEquals(serviceItem.getText(),"Service");

        WebElement metalsColorsItem = driver.findElement(By.cssSelector(".sidebar-menu > li:nth-child(4)"));
        assertTrue(metalsColorsItem.isDisplayed());
        assertEquals(metalsColorsItem.getText(),"Metals & Colors");

        WebElement elementsPacksItem = driver.findElement(By.cssSelector(".sidebar-menu > li:nth-child(5)"));
        assertTrue(elementsPacksItem.isDisplayed());
        assertEquals(elementsPacksItem.getText(),"Elements packs");

        //8. Assert that there are 4 images on the Index Page and they are displayed
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

        //9. Assert that there are 4 texts on the Index Page under icons and they have proper text
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

        //10. Assert a text of the main headers
        WebElement mainHeader = driver.findElement(By.cssSelector("h3.main-title.text-center"));
        assertTrue(mainHeader.isDisplayed());
        assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement textHeader = driver.findElement(By.cssSelector("p.main-txt"));
        assertTrue(textHeader.isDisplayed());
        assertEquals(textHeader.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //11. Assert that there is the iframe in the center of page
        WebElement iframe = driver.findElement(By.cssSelector("iframe#iframe"));
        assertTrue(iframe.isDisplayed());

        //12. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String mainWindowHandle=driver.getWindowHandle();
        driver.switchTo().frame(iframe);
        String str1 = driver.getCurrentUrl();
        WebElement logo = driver.findElement(By.cssSelector("#epam_logo"));
        assertEquals(logo.getAttribute("src"), "https://epam.github.io/JDI/images/Logo_Epam_Color.svg");

        //13. Switch to original window back
        driver.switchTo().window(mainWindowHandle);
        String str2 = driver.getCurrentUrl();

        //14. Assert a text of the sub header
        WebElement subheader = driver.findElement(By.cssSelector("h3:nth-child(3)>a"));
        assertEquals(subheader.getText(), "JDI GITHUB");

        //15. Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subheader.getAttribute("href"), "https://github.com/epam/JDI");

        //16. Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //17. Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector(".footer-content")).isDisplayed());

        //18. Close Browser
        driver.close();

    }
    @Test (groups = {"Regression"})
    public void checkHomePageSecond(){
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1. Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //3. Assert browser title
        assertEquals(driver.getTitle(),"Home Page");

        //4. Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#password")).sendKeys("1234");
        driver.findElement(By.cssSelector("#login-button")).click();

        //5. Assert User name in the left-top side of screen that user is loggined
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        assertEquals(username.getText(), "PITER CHAILOVSKII");

        //6. Assert browser title
        assertEquals(driver.getTitle(),"Home Page");

        //7. Assert that there are 4 items on the header section are displayed and they have proper texts
        List <WebElement> sidebarItems = driver.findElements(By.cssSelector(".sidebar-menu > li"));
        assertEquals(sidebarItems.size(), 5);

        WebElement homeItem = driver.findElement(By.cssSelector(".sidebar-menu > li:nth-child(1)"));
        assertTrue(homeItem.isDisplayed());
        assertEquals(homeItem.getText(),"Home");

        WebElement contactFormItem = driver.findElement(By.cssSelector(".sidebar-menu > li:nth-child(2)"));
        assertTrue(contactFormItem.isDisplayed());
        assertEquals(contactFormItem.getText(),"Contact form");

        WebElement serviceItem = driver.findElement(By.cssSelector(".sidebar-menu > li:nth-child(3)"));
        assertTrue(serviceItem.isDisplayed());
        assertEquals(serviceItem.getText(),"Service");

        WebElement metalsColorsItem = driver.findElement(By.cssSelector(".sidebar-menu > li:nth-child(4)"));
        assertTrue(metalsColorsItem.isDisplayed());
        assertEquals(metalsColorsItem.getText(),"Metals & Colors");

        WebElement elementsPacksItem = driver.findElement(By.cssSelector(".sidebar-menu > li:nth-child(5)"));
        assertTrue(elementsPacksItem.isDisplayed());
        assertEquals(elementsPacksItem.getText(),"Elements packs");

        //8. Assert that there are 4 images on the Index Page and they are displayed
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

        //9. Assert that there are 4 texts on the Index Page under icons and they have proper text
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

        //10. Assert a text of the main headers
        WebElement mainHeader = driver.findElement(By.cssSelector("h3.main-title.text-center"));
        assertTrue(mainHeader.isDisplayed());
        assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement textHeader = driver.findElement(By.cssSelector("p.main-txt"));
        assertTrue(textHeader.isDisplayed());
        assertEquals(textHeader.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //11. Assert that there is the iframe in the center of page
        WebElement iframe = driver.findElement(By.cssSelector("iframe#iframe"));
        assertTrue(iframe.isDisplayed());

        //12. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String mainWindowHandle=driver.getWindowHandle();
        driver.switchTo().frame(iframe);
        String str1 = driver.getCurrentUrl();
        WebElement logo = driver.findElement(By.cssSelector("#epam_logo"));
        assertEquals(logo.getAttribute("src"), "https://epam.github.io/JDI/images/Logo_Epam_Color.svg");

        //13. Switch to original window back
        driver.switchTo().window(mainWindowHandle);
        String str2 = driver.getCurrentUrl();

        //14. Assert a text of the sub header
        WebElement subheader = driver.findElement(By.cssSelector("h3:nth-child(3)>a"));
        assertEquals(subheader.getText(), "JDI GITHUB");

        //15. Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subheader.getAttribute("href"), "https://github.com/epam/JDI");

        //16. Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //17. Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector(".footer-content")).isDisplayed());

        //18. Close Browser
        driver.close();

    }
    @Test (groups = {"Smoke"})
    public void checkHomePageThird(){
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1. Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //3. Assert browser title
        assertEquals(driver.getTitle(),"Home Page");

        //4. Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#password")).sendKeys("1234");
        driver.findElement(By.cssSelector("#login-button")).click();

        //5. Assert User name in the left-top side of screen that user is loggined
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        assertEquals(username.getText(), "PITER CHAILOVSKII");

        //6. Assert browser title
        assertEquals(driver.getTitle(),"Home Page");

        //7. Assert that there are 4 items on the header section are displayed and they have proper texts
        List <WebElement> sidebarItems = driver.findElements(By.cssSelector(".sidebar-menu > li"));
        assertEquals(sidebarItems.size(), 5);

        WebElement homeItem = driver.findElement(By.cssSelector(".sidebar-menu > li:nth-child(1)"));
        assertTrue(homeItem.isDisplayed());
        assertEquals(homeItem.getText(),"Home");

        WebElement contactFormItem = driver.findElement(By.cssSelector(".sidebar-menu > li:nth-child(2)"));
        assertTrue(contactFormItem.isDisplayed());
        assertEquals(contactFormItem.getText(),"Contact form");

        WebElement serviceItem = driver.findElement(By.cssSelector(".sidebar-menu > li:nth-child(3)"));
        assertTrue(serviceItem.isDisplayed());
        assertEquals(serviceItem.getText(),"Service");

        WebElement metalsColorsItem = driver.findElement(By.cssSelector(".sidebar-menu > li:nth-child(4)"));
        assertTrue(metalsColorsItem.isDisplayed());
        assertEquals(metalsColorsItem.getText(),"Metals & Colors");

        WebElement elementsPacksItem = driver.findElement(By.cssSelector(".sidebar-menu > li:nth-child(5)"));
        assertTrue(elementsPacksItem.isDisplayed());
        assertEquals(elementsPacksItem.getText(),"Elements packs");

        //8. Assert that there are 4 images on the Index Page and they are displayed
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

        //9. Assert that there are 4 texts on the Index Page under icons and they have proper text
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

        //10. Assert a text of the main headers
        WebElement mainHeader = driver.findElement(By.cssSelector("h3.main-title.text-center"));
        assertTrue(mainHeader.isDisplayed());
        assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement textHeader = driver.findElement(By.cssSelector("p.main-txt"));
        assertTrue(textHeader.isDisplayed());
        assertEquals(textHeader.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //11. Assert that there is the iframe in the center of page
        WebElement iframe = driver.findElement(By.cssSelector("iframe#iframe"));
        assertTrue(iframe.isDisplayed());

        //12. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String mainWindowHandle=driver.getWindowHandle();
        driver.switchTo().frame(iframe);
        String str1 = driver.getCurrentUrl();
        WebElement logo = driver.findElement(By.cssSelector("#epam_logo"));
        assertEquals(logo.getAttribute("src"), "https://epam.github.io/JDI/images/Logo_Epam_Color.svg");

        //13. Switch to original window back
        driver.switchTo().window(mainWindowHandle);
        String str2 = driver.getCurrentUrl();

        //14. Assert a text of the sub header
        WebElement subheader = driver.findElement(By.cssSelector("h3:nth-child(3)>a"));
        assertEquals(subheader.getText(), "JDI GITHUB");

        //15. Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subheader.getAttribute("href"), "https://github.com/epam/JDI");

        //16. Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //17. Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector(".footer-content")).isDisplayed());

        //18. Close Browser
        driver.close();

    }
}
