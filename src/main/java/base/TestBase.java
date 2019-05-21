package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public class TestBase {
   @BeforeSuite
   public void beforeSuite(){
      setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
   }

   @AfterSuite
   public void afterSuite(){
   }
}
