package hw5;

import base.TestBaseSelenide;
import enums.LogRecordsCheckBox;
import enums.LogRecordsDropDown;
import enums.LogRecordsRadioButton;
import enums.SubMenuItems;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import listener.AllureAttachementListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.ServiceSelenidePageObjectAllure;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

@Feature("Smoke test")
@Story("ServicePage failure testing")
@Listeners(AllureAttachementListener.class)

public class ServicePageSelenideFail extends TestBaseSelenide {

    private ServiceSelenidePageObjectAllure servicePage;


    @BeforeClass
    public void beforeClass() {

        servicePage = open("https://epam.github.io/JDI/", ServiceSelenidePageObjectAllure.class);
    }

    @Flaky
    @Test
    public void checkServicePage() {

        //1. Assert Browser title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //2. Perform login
        servicePage.login("epam", "1234");

        //3. Assert User name in the left-top side of screen that user is loggined
        servicePage.userName.shouldHave(text("PITER CHAILOVSKII"));

        // 4. Click on "Service" subcategory in the header and check that drop down contains options
        servicePage.clickMenuItem(servicePage.menuCollection, "Service");
        for (SubMenuItems sm : SubMenuItems.values()) {
            $$(".sub > li").findBy(text(sm.getRecord())).should(exist);
        }

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
        servicePage.checkCheckBox(servicePage.checkboxValueCollection, "Wind").shouldBe(checked);
        servicePage.checkCheckBox(servicePage.checkboxValueCollection, "Water").shouldBe(checked);

        //10. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        for (LogRecordsCheckBox lg : LogRecordsCheckBox.values()) {
            $$(".panel-body-list.logs > li").findBy(text(lg.getRecord())).shouldBe(visible);
        }

        //11. Select radio
        servicePage.checkCheckBox(servicePage.radioButtonValueCollection, "Selen").should(exist);

        //12. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        for (LogRecordsRadioButton rb : LogRecordsRadioButton.values()) {
            $$(".panel-body-list.logs > li").findBy(text(rb.getRecord())).should(exist);
        }

        //13. Select in dropdown
        servicePage.clickDropDown();
        servicePage.clickMenuItem(servicePage.dropdonwCollection, "Yellow").shouldBe(selected);

        //14. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        for (LogRecordsDropDown dd : LogRecordsDropDown.values()) {
            $$(".panel-body-list.logs > li").findBy(text(dd.getRecord())).should(exist);
        }
    }
}
