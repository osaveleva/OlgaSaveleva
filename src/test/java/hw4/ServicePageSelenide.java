package hw4;

import base.TestBaseSelenide;
import enums.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ServiceSelenidePageObject;
import utilities.PropertyManager;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;


public class ServicePageSelenide extends TestBaseSelenide {

    private ServiceSelenidePageObject servicePage;


    @BeforeClass
    public void beforeClass() {

        servicePage = open(PropertyManager.getInstance().getURL(), ServiceSelenidePageObject.class);
    }

    @Test
    public void checkServicePage() {

        //1. Assert Browser title
        assertEquals(getWebDriver().getTitle(), PropertyManager.getInstance().getMainDriverTitle());

        //2. Perform login
        servicePage.login(PropertyManager.getInstance().getLogin(), PropertyManager.getInstance().getPassword());

        //3. Assert User name in the left-top side of screen that user is loggined
        servicePage.checkUserNameTitle(PropertyManager.getInstance().getPageTitle());

        // 4. Click on "Service" subcategory in the header and check that drop down contains options
        servicePage.checkServiceMenu(LeftMenuItems.SERVICE.getRecord());

        //5. Open through the header menu Service -> Different Elements Page
        servicePage.clickDiffElementMenuItem(SubMenuItems.DIFFELEMENTS.getRecord());

        //6. Check interface on Different elements page, it contains all needed elements
        //6.1 Assert that there are 4 checkboxes
        servicePage.checkCheckBoxCollectionSize(CheckBoxItems.values().length);

        //6.2. Assert that there are 4 radioButtons
        servicePage.checkRadioButtonCollectionSize(RadioButtonItems.values().length);

        //6.3. Assert that there is 1 dropdown list
        servicePage.checkDropDownCollectionSize(PropertyManager.getInstance().getDropdownCollectionSize());

        //6.4. Assert that there are 2 butttons
        servicePage.checkButtonCollectionSize(DiffElementButtons.values().length);

        //7. Assert that there is Right Section

        servicePage.checkRightSectionVisibility();

        //8. Assert that there is Left Section
        servicePage.checkLeftSectionVisibility();

        //9. Select checkboxes
        servicePage.checkCheckBoxStatus(CheckBoxItems.WIND.getRecord());
        servicePage.checkCheckBoxStatus(CheckBoxItems.WATER.getRecord());

        //   //10. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePage.checkCheckBoxLogRecords();

        //   //11. Select radio
        servicePage.checkRadioButtonStatus(RadioButtonItems.SELEN.getRecord());

        //   //12. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        servicePage.checkRadioButtonLogRecords();

        //13. Select in dropdown
        servicePage.clickDropDown(DropDownItems.YELLOW.getRecord());

        //14. Assert that yellow item is selected
        servicePage.checkDropDownValue(DropDownItems.YELLOW.getRecord());

        //14. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePage.checkDropDownLogRecords();
    }
}
