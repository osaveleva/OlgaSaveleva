package hw4;

import base.TestBaseSelenide;
import com.codeborne.selenide.SelenideElement;
import enums.LogRecordsFromTo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DatesSelenidePageObject;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
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
       List<String> logList;

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

        //6. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        logList = datePage.makeListLog();
        datePage.moveFromSlider(0);
        datePage.moveToSlider(90);
        datePage.From.shouldHave(exactText("0"));
        datePage.To.shouldHave(exactText("90"));

        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        for (String e: logList){
            $$(".panel-body-list > li").findBy(text(e)).should(exist);
        }

      //8. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        logList.clear();
        logList = datePage.makeListLog();
        datePage.moveFromSlider(0);
        datePage.moveToSlider(0);
        datePage.From.shouldHave(exactText("0"));
        datePage.To.shouldHave(exactText("0"));

       //7.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        for (String e: logList){
            $$(".panel-body-list > li").findBy(text(e)).should(exist);
        }
        logList.clear();
    }
}
