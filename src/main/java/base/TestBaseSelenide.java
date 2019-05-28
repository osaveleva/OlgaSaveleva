package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageObjects.ServiceSelenidePageObject;

import static java.lang.System.setProperty;


public class TestBaseSelenide {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.startMaximized = true;
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @AfterSuite
    public void afterSuite() {

    }

}
