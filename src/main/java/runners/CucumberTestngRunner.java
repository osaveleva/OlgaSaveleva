package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

@CucumberOptions(features = "src/test/java/hw6", glue = "pageObjects")
public class CucumberTestngRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.startMaximized = true;
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
}

