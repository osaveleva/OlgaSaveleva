package hw5;

import base.TestBaseSelenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import listener.AllureAttachementListener;
import org.testng.annotations.AfterClass;
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
    @AfterClass
    public void afterClass(){
        WebDriverRunner.getWebDriver().close();
    }

    @Flaky
    @Test
    public void checkServicePage() {

        //1. Assert Browser title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //2. Perform login
        servicePage.login("epam", "1234");

        //3. Assert User name in the left-top side of screen that user is loggined
        servicePage.userName.shouldHave(text("PITER CHAILOVSKIIA"));


    }
}
