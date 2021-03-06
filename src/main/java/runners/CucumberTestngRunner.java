package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static java.lang.System.setProperty;

@CucumberOptions(features = "src/test/resources/features/hw6", glue = {"pageObjects"})
public class CucumberTestngRunner extends AbstractTestNGCucumberTests {
    private utilities.Configuration cfg = ConfigFactory.create(utilities.Configuration.class);

    @BeforeSuite
    public void beforeSuite() {
        Configuration.startMaximized = true;
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }


    @BeforeMethod
    public void beforeMethod() {
        open(cfg.url());
    }

    @AfterMethod
    public void afterMethod() {
        closeWebDriver();
    }

}

