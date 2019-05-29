package hw4;

import base.TestBaseSelenide;
import enums.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ServiceSelenidePageObject;
import utilities.Configuration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;


public class ServicePageSelenide extends TestBaseSelenide {

    private ServiceSelenidePageObject servicePage;
    private Configuration cfg;

    @BeforeClass
    public void beforeClass() {

        cfg = ConfigFactory.create(Configuration.class);
        servicePage = open(cfg.url(), ServiceSelenidePageObject.class);

    }

    @Test
    public void checkServicePage() {

        //1. Assert Browser title
        assertEquals(getWebDriver().getTitle(), cfg.mainDriverTitle());

        //2. Perform login
        servicePage.login(cfg.login(), cfg.password());

        //3. Assert User name in the left-top side of screen that user is loggined
        servicePage.checkUserNameTitle(cfg.pageTitle());

        // 4. Click on "Service" subcategory in the header and check that drop down contains options
        servicePage.checkServiceMenu(LeftMenuItems.SERVICE.getRecord());

        //5. Open through the header menu Service -> Different Elements Page
        servicePage.clickDiffElementMenuItem(SubMenuItems.DIFFERENT_ELEMENTS.getRecord());

        //6. Check interface on Different elements page, it contains all needed elements
        //6.1 Assert that there are 4 checkboxes
        servicePage.checkCheckBoxCollection(ElementsCheckBoxItems.values().length);

        //6.2. Assert that there are 4 radioButtons
        servicePage.checkRadioButtonCollection(MetalRadioButtonItems.values().length);

        //6.3. Assert that there is 1 dropdown list
        servicePage.checkDropDownCollection(cfg.dropdownCollectionSize());

        //6.4. Assert that there are 2 butttons
        servicePage.checkButtonCollection(DiffElementButtons.values().length);

        //7. Assert that there is Right Section

        servicePage.checkRightSection();

        //8. Assert that there is Left Section
        servicePage.checkLeftSection();

        //9. Select checkboxes
        servicePage.checkCheckBox(ElementsCheckBoxItems.WIND.getRecord());
        servicePage.checkCheckBox(ElementsCheckBoxItems.WATER.getRecord());

        //   //10. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePage.checkCheckBoxLogRecords();

        //   //11. Select radio
        servicePage.checkRadioButton(MetalRadioButtonItems.SELEN.getRecord());

        //   //12. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        servicePage.checkRadioButtonLogRecords();

        //13. Select in dropdown
        servicePage.clickDropDown(ColorsDropDownItems.YELLOW.getRecord());

        //14. Assert that yellow item is selected
        servicePage.checkDropDown(ColorsDropDownItems.YELLOW.getRecord());

        //14. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePage.checkDropDownLogRecords();
    }
}
