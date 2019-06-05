package hw4;

import base.TestBaseSelenide;
import enums.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DifferentElementsSelenidePageObject;
import utilities.Configuration;

import static com.codeborne.selenide.Selenide.open;
import static enums.NatureElementsCheckBox.*;
import static enums.LeftMenuItems.DIFFERENT_ELEMENTS;
import static enums.LeftMenuItems.SERVICE;
import static org.testng.Assert.assertEquals;


public class ServicePageSelenide extends TestBaseSelenide {

    private DifferentElementsSelenidePageObject servicePage;
    private Configuration cfg;

    @BeforeClass
    public void beforeClass() {

        cfg = ConfigFactory.create(Configuration.class);
        servicePage = open(cfg.url(), DifferentElementsSelenidePageObject.class);

    }

    @Test
    public void checkServicePage() {

        //1. Assert Browser title
        servicePage.checkTitle();

        //2. Perform login
        servicePage.login(cfg.login(), cfg.password());

        //3. Assert User name in the left-top side of screen that user is loggined
        servicePage.checkUserNameTitle();

        // 4. Click on "Service" subcategory in the header and check that drop down contains options
        // TODO
        servicePage.clickMenu(SERVICE);
        servicePage.checkServiceMenu();

        //5. Open through the header menu Service -> Different Elements Page
        // TODO
        servicePage.clickMenu(SERVICE, DIFFERENT_ELEMENTS);

        //6. Check interface on Different elements page, it contains all needed elements
        //6.1 Assert that there are 4 checkboxes
        servicePage.checkNatureElements();

        //6.2. Assert that there are 4 radioButtons
        // TODO
        servicePage.checkMetals();

        //6.3. Assert that there is 1 dropdown list
        // TODO
        servicePage.checkColors();

        //6.4. Assert that there are 2 butttons
        // TODO
        servicePage.checkButtons();

        //7. Assert that there is Right Section
        servicePage.checkRightSection();

        //8. Assert that there is Left Section
        servicePage.checkLeftSection();

        //9. Select checkboxes
        // TODO 1. Method name
        // TODO 2. Parameter type, might be several of it
        servicePage.clickNatureElements(WIND, WATER);
       // servicePage.checkCheckBox(NatureElementsCheckBox.WATER.getRecord());

        //10. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePage.checkTrueCheckBoxLogRecords();

        //11. Select radio
        servicePage.clickMetals(MetalsRadioButton.SELEN.getRecord());

        //12. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        servicePage.checkRadioButtonLogRecords();

        //13. Select in dropdown
        servicePage.clickDropDown(ColorsDropDowns.YELLOW.getRecord());

        //14. Assert that yellow item is selected
        servicePage.checkDropDown(ColorsDropDowns.YELLOW.getRecord());

        //14. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePage.checkDropDownLogRecords();

        //15. Unselect and assert checkboxes
        servicePage.checkUnCheckBox(WIND.getRecord());
        servicePage.checkUnCheckBox(NatureElementsCheckBox.WATER.getRecord());

        //16. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePage.checkFalseCheckBoxLogRecords();
    }
}
