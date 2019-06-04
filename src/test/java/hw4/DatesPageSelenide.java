package hw4;

import base.TestBaseSelenide;
import enums.SubMenuItems;
import org.aeonbits.owner.ConfigFactory;
import utilities.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DatesSelenidePageObject;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.*;
import static enums.LeftMenuItems.SERVICE;
import static org.testng.Assert.assertEquals;


public class DatesPageSelenide extends TestBaseSelenide {

    private DatesSelenidePageObject datePage;
    private Configuration cfg;


    @BeforeClass
    public void beforeClass() {
        cfg = ConfigFactory.create(Configuration.class);
        datePage = open(cfg.url(), DatesSelenidePageObject.class);
    }

    @Test
    public void checkServicePage() {
        //1. Assert Browser title
        datePage.checkTitle();

        //2. Perform login
        datePage.login(cfg.login(), cfg.password());

        //3. Assert User name in the left-top side of screen that user is loggined
        datePage.checkUserNameTitle();

        // 4. Click on "Service" subcategory in the header and check that drop down contains options
        datePage.clickLeftMenuBaseItem(SERVICE);
        datePage.checkServiceMenu();

        //5. Open through the header menu Service -> Different Elements Page
        datePage.clickLeftMenuServiceItem(SubMenuItems.DATES);
//        datePage.clickSubMenuItem();

        //6. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position 0 100
        datePage.moveSlider(0, 100);
        datePage.checkSliderPosition(0, 100);

        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datePage.checkLogs("0", "100");

        //8. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datePage.moveSlider(0, 0);

        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datePage.checkLogs("0", "0");

        //10. Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datePage.moveSlider(100, 100);

        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datePage.checkLogs("100", "100");

        //12. Using drag-and-drop set Range sliders.
        datePage.moveSlider(30, 70);
        datePage.from.click(); //It's a workaround. May be a bug in application.

        //13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datePage.checkLogs("30", "70");
    }
}