package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TextItemsAsserts {

    @DataProvider(name="parallelDataProvider", parallel = true)
    public Object[][] methodDataProvider() {
        return new Object[][] {{"To include good practices\nand ideas from successful\nEPAM project", 1},
                               {"To be flexible and\ncustomizable", 2},
                               {"To be multiplatform", 3},
                               {"Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…", 4}
        };
        }

    @Test(dataProvider = "parallelDataProvider")
     public void checktextItems(String s, int i){
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1. Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3. Assert that 4 texts on the Index Page under icons have proper text
        WebElement iconPractiseText = driver.findElement(By.cssSelector("div.row > div:nth-child("+i+") .benefit-txt"));
        assertTrue(iconPractiseText.isDisplayed());
        assertEquals(iconPractiseText.getText(), s);

        //4. Close Browser
        driver.close() ;

    }
}
