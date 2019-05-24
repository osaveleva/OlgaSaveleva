package hw4;

import base.TestBaseSelenide;
import enums.LogRecordsCheckBox;
import enums.LogRecordsRadioButton;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ServiceSelenidePageObject;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ServicePageSelenide extends TestBaseSelenide {

    private ServiceSelenidePageObject servicePage;


    @BeforeClass
    public void beforeClass() {

        servicePage = open("https://epam.github.io/JDI/", ServiceSelenidePageObject.class);
    }

    @Test
    public void checkServicePage() {
        List<String> subMenuItems = Arrays.asList("Support", "Dates", "Complex Table", "Simple Table", "Table with pages", "Different elements");

        //1. Assert Browser title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //2. Perform login
        servicePage.login("epam", "1234");

        //3. Assert User name in the left-top side of screen that user is loggined
        servicePage.userName.shouldHave(text("PITER CHAILOVSKII"));

        // 4. Click on "Service" subcategory in the header and check that drop down contains options
        servicePage.clickMenuItem(servicePage.menuCollection, "Service");
        assertTrue(servicePage.getSubMenuItems(servicePage.subCollection).containsAll(subMenuItems));

        //5. Open through the header menu Service -> Different Elements Page
        servicePage.clickMenuItem(servicePage.subCollection, "Different elements");

        //6. Check interface on Different elements page, it contains all needed elements
        $$(".label-checkbox").shouldHaveSize(4);
        $$(".label-radio").shouldHaveSize(4);
        $$(".colors").shouldHaveSize(1);
        $$(".main-content .uui-button").shouldHaveSize(2);

        //7. Assert that there is Right Section
        $("div[name='log-sidebar']").shouldBe(visible);

        //8. Assert that there is Left Section
        $("div[name='navigation-sidebar']").shouldBe(visible);

        //9. Select checkboxes
        servicePage.checkCheckBox(servicePage.checkboxValueCollection,"Wind").shouldBe(checked);
        servicePage.checkCheckBox(servicePage.checkboxValueCollection,"Water").shouldBe(checked);

        //10. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        for (LogRecordsCheckBox lg: LogRecordsCheckBox.values()){
            assertTrue(servicePage.checkLog(lg.getRecord()));
        }

        //11. Select radio
        servicePage.checkCheckBox(servicePage.radioButtonValueCollection,"Selen").shouldBe(checked);

        //12. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        for (LogRecordsRadioButton rb: LogRecordsRadioButton.values()){
            assertTrue(servicePage.checkLog(rb.getRecord()));
        }

    }
}
