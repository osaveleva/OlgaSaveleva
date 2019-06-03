package hw6;

import enums.ColorsDropDowns;
import enums.ElementsCheckBox;
import enums.MetalsRadioButton;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ServiceCucumberPageObject;
import utilities.Configuration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertEquals;


public class ServicePageCucumber {

    private ServiceCucumberPageObject servicePage;
    private Configuration cfg;

    @BeforeClass
    public void beforeClass() {
        cfg = ConfigFactory.create(Configuration.class);
        servicePage = page(ServiceCucumberPageObject.class);
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
        servicePage.checkCheckBox(ElementsCheckBox.WIND.getRecord());
        servicePage.checkCheckBox(ElementsCheckBox.WATER.getRecord());

        //10. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePage.checkTrueCheckBoxLogRecords();

        //11. Select radio
        servicePage.checkRadioButton(MetalsRadioButton.SELEN.getRecord());

        //12. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        servicePage.checkRadioButtonLogRecords();

        //13. Select in dropdown
        servicePage.clickDropDown(ColorsDropDowns.YELLOW.getRecord());

        //14. Assert that yellow item is selected
        servicePage.checkDropDown(ColorsDropDowns.YELLOW.getRecord());

        //14. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePage.checkDropDownLogRecords();

        //15. Unselect and assert checkboxes
        servicePage.checkUnCheckBox(ElementsCheckBox.WIND.getRecord());
        servicePage.checkUnCheckBox(ElementsCheckBox.WATER.getRecord());

        //16. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePage.checkFalseCheckBoxLogRecords();
    }
}
