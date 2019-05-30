package hw5;

import base.TestBaseSelenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import listener.AllureAttachementListener;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.ServiceSelenidePageObjectAllureFail;
import utilities.Configuration;

import static utilities.HomePageValues.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

@Feature("Smoke test")
@Story("ServicePage failure testing")
@Listeners(AllureAttachementListener.class)

public class ServicePageSelenideAllureFail extends TestBaseSelenide {

    private Configuration cfg;
    private ServiceSelenidePageObjectAllureFail servicePage;

    @BeforeClass
    public void beforeClass() {

        cfg = ConfigFactory.create(Configuration.class);
        servicePage = open(cfg.url(), ServiceSelenidePageObjectAllureFail.class);
    }

    @AfterClass
    public void afterClass(){
        WebDriverRunner.getWebDriver().close();
    }

    @Flaky
    @Test
    public void checkServicePage() {

        //1. Assert Browser title
        assertEquals(getWebDriver().getTitle(), MAINDRIVERTITLE);

        //2. Perform login
        servicePage.login(cfg.login(), cfg.password());

        //3. Assert User name in the left-top side of screen that user is loggined
        servicePage.checkUserNameTitle();


    }
}
