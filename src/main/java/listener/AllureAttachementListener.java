package listener;

import com.codeborne.selenide.commands.TakeScreenshot;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AllureAttachementListener extends TestListenerAdapter {

    @Attachment(value = "Attachement {0}", type = "img/png")
    private byte[] makeScreenShots() {
        byte[] array = {1};
        try {
            return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        makeScreenShots();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        makeScreenShots();
    }
}
