package hw5;

import base.TestBaseSelenide;
import com.codeborne.selenide.WebDriverRunner;
import enums.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static base.HomePageValues.*;

import pageObjects.DifferentElementsSelenidePageObjectAllure;
import utilities.Configuration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

@Feature("Smoke test")
@Story("ServicePage testing")
public class ServicePageSelenideAllure extends TestBaseSelenide {

    private DifferentElementsSelenidePageObjectAllure servicePage;
    private Configuration cfg;

    @BeforeClass
    public void beforeClass() {

        cfg = ConfigFactory.create(Configuration.class);
        servicePage = open(cfg.url(), DifferentElementsSelenidePageObjectAllure.class);
    }

    @AfterClass
    public void afterClass() {
        WebDriverRunner.getWebDriver().close();
    }

    @Test
    public void checkServicePage() {

        //1. Assert Browser title
        assertEquals(getWebDriver().getTitle(), MAIN_DRIVER_TITLE);

        //2. Perform login
        servicePage.login(cfg.login(), cfg.password());

        //3. Assert User name in the left-top side of screen that user is loggined
        servicePage.checkUserNameTitle();

        // 4. Click on "Service" subcategory in the header and check that drop down contains options
        servicePage.checkServiceMenu();

        //5. Open through the header menu Service -> Different Elements Page
        servicePage.clickDiffElementMenuItem();

        //6. Check interface on Different elements page, it contains all needed elements
        //6.1 Assert that there are 4 checkboxes
        servicePage.checkCheckBoxCollection();

        //6.2. Assert that there are 4 radioButtons
        servicePage.checkRadioButtonCollection();

        //6.3. Assert that there is 1 dropdown list
        servicePage.checkDropDownCollection();

        //6.4. Assert that there are 2 butttons
        servicePage.checkButtonCollection();

        //7. Assert that there is Right Section

        servicePage.checkRightSection();

        //8. Assert that there is Left Section
        servicePage.checkLeftSection();

        //9. Select checkboxes
        servicePage.checkCheckBox(NatureElementsCheckBox.WIND.getRecord());
        servicePage.checkCheckBox(NatureElementsCheckBox.WATER.getRecord());

        //   //10. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePage.checkCheckBoxLogRecords();

        //   //11. Select radio
        servicePage.checkRadioButton(MetalsRadioButton.SELEN.getRecord());

        //   //12. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        servicePage.checkRadioButtonLogRecords();

        //13. Select in dropdown
        servicePage.clickDropDown(ColorsDropDowns.YELLOW.getRecord());

        //14. Assert that yellow item is selected
        servicePage.checkDropDown(ColorsDropDowns.YELLOW.getRecord());

        //14. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePage.checkDropDownLogRecords();
    }
}