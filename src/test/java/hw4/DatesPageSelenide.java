package hw4;

import base.TestBaseSelenide;
import com.codeborne.selenide.SelenideElement;
import enums.SubMenuItems;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DatesSelenidePageObject;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;


public class DatesPageSelenide extends TestBaseSelenide {

    private DatesSelenidePageObject datePage;


    @BeforeClass
    public void beforeClass() {

        datePage = open("https://epam.github.io/JDI/", DatesSelenidePageObject.class);
    }

    @Test
    public void checkServicePage() {

        //1. Assert Browser title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //2. Perform login
        datePage.login("epam", "1234");

        //3. Assert User name in the left-top side of screen that user is loggined
        datePage.userName.shouldHave(text("PITER CHAILOVSKII"));

        // 4. Click on "Service" subcategory in the header and check that drop down contains options
        datePage.clickMenuItem(datePage.menuCollection, "Service");

        //5. Open through the header menu Service -> Different Elements Page
        datePage.clickMenuItem(datePage.subCollection, "Dates");

        Actions act=new Actions(getWebDriver());

        act.click(datePage.From).build().perform();
        //Thread.sleep(1000);
        //for (int i = 0; i < 10; i++) {
          //  act.sendKeys(Keys.ARROW_RIGHT).build().perform();
            //Thread.sleep(200);
        //}
       // act.dragAndDropBy(datePage.From, 60, 0).build().perform();
       // act.dragAndDrop(From, To).build().perform();

     //   $(".ui-slider-handle:nth-child(1)").dragAndDropTo("50");


    }
}
