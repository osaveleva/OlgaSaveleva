package hw5;

import base.TestBaseSelenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DatesSelenidePageObject;
import pageObjects.DatesSelenidePageObjectAllure;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;


public class DatesPageSelenide extends TestBaseSelenide {

    private DatesSelenidePageObjectAllure datePage;


    @BeforeClass
    public void beforeClass() {

        datePage = open("https://epam.github.io/JDI/", DatesSelenidePageObjectAllure.class);
    }

    @AfterClass
    public void afterClass() {
        WebDriverRunner.getWebDriver().close();
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
        String offsetWidth = datePage.slider.getAttribute("offsetWidth");
        double step = Double.valueOf(offsetWidth) / 100;
        double px = Math.round(step * 10.0) / 10.0;
        datePage.moveSlider(0, 100, px);
        datePage.from.shouldHave(exactText("0"));
        datePage.to.shouldHave(exactText("100"));
        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        for (String e : datePage.makeListLog(0, 100)) {
            $$(".panel-body-list > li").findBy(text(e)).should(exist);
        }
        //8. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datePage.moveSlider(0, 0, px);
        datePage.from.shouldHave(exactText("0"));
        datePage.to.shouldHave(exactText("0"));
        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        for (String e : datePage.makeListLog(0, 0)) {
            $$(".panel-body-list > li").findBy(text(e)).should(exist);
        }
        //10. Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datePage.moveSlider(100, 100, px);
        datePage.from.shouldHave(exactText("100"));
        datePage.to.shouldHave(exactText("100"));
        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        for (String e : datePage.makeListLog(100, 100)) {
            $$(".panel-body-list > li").findBy(text(e)).should(exist);
        }
        //12. Using drag-and-drop set Range sliders.
        datePage.moveSlider(30, 70, px);
        datePage.from.shouldHave(exactText("30"));
        datePage.to.shouldHave(exactText("70"));
        datePage.makeListLog(30, 70);
        datePage.from.click();
        //13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        for (String e : datePage.makeListLog(30, 70)) {
            $$(".panel-body-list > li").findBy(text(e)).should(exist);
        }
    }
}
