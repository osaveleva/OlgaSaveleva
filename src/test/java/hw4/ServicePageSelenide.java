package hw4;

import base.TestBaseSelenide;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ServiceSelenidePageObject;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ServicePageSelenide extends TestBaseSelenide{

    private ServiceSelenidePageObject servicePage;


    @BeforeClass
    public void beforeClass() {

        servicePage = open("https://epam.github.io/JDI/", ServiceSelenidePageObject.class);
    }

    @Test
    public void checkServicePage(){
        List<String> subMenuItems = Arrays.asList("Support", "Dates", "Complex Table", "Simple Table", "Table with pages", "Different elements");

        //1. Assert Browser title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //2. Perform login
        servicePage.login("epam", "1234");

        //3. Assert User name in the left-top side of screen that user is loggined
        servicePage.userName.shouldHave(text("PITER CHAILOVSKII"));

        // 4. Click on "Service" subcategory in the header and check that drop down contains options
        servicePage.service.click();
        assertTrue(servicePage.getSubMenuItems().containsAll(subMenuItems));

        //5. Open through the header menu Service -> Different Elements Page
        servicePage.differentElements.click();

        //6. Check interface on Different elements page, it contains all needed elements
        $$(".label-checkbox").shouldHaveSize(4);
        $$(".label-radio").shouldHaveSize(4);
        $$(".colors").shouldHaveSize(1);
        $$(".main-content .uui-button").shouldHaveSize(2);

       }
}
