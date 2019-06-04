package runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.System.setProperty;

@CucumberOptions(features = "src/test/resources/features/hw6/UserTablePageCucumberTest.feature", glue = "pageObjects")
public class CucumberTestngRunner extends AbstractTestNGCucumberTests {
    private utilities.Configuration cfg = ConfigFactory.create(utilities.Configuration.class);
    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        Configuration.startMaximized = true;
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

    }

}

