import appium_flutter_driver.finder.FlutterElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class ProjectTests {

    public static final String DEVICE_NAME = "sdk_gphone_x86";
    public static final String UDID = "emulator-5554";
    public static final String PLATFORM_NAME = "ANDROID";
    public static final String PLATFORM_VERSION = "11";
    public static final String APP_PACKAGE = "com.example.survey_app";
    public static final String APP_ACTIVITY = "com.example.survey_app.MainActivity";



    private AppiumDriver<MobileElement> appiumDriver;
    private WebDriverWait webDriverWait;

    @BeforeTest
    public void setup() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", DEVICE_NAME);
        cap.setCapability(MobileCapabilityType.UDID, UDID);
        cap.setCapability(CapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        cap.setCapability("appPackage", APP_PACKAGE);
        cap.setCapability("appActivity", APP_ACTIVITY);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        appiumDriver = new AppiumDriver<MobileElement>(url, cap);
        webDriverWait = new WebDriverWait(appiumDriver, 10);

        System.out.println("Application Started...");
    }

    /**
     * In the survey send data should be only shown when the proper data to the survey is given.
     * This method specifically tests when improper data is given to the survey whether if it will show the send button or not.
     */
    @Test
    public void testSendButtonVisibility() throws InterruptedException {
        FlutterElement a;
    }

    /**
     * In the survey, in the date field format should be DD/MM/YYYY and no other format is accepted.
     * This method specifically tests when improper format is given to the date field whether if it will allow the improper format or not.
     */
    @Test
    public void testDateFormatAcceptance() {

    }

    /**
     * In the survey, when a vaccination type is chosen in the dropdown menu, that type should be shown in the survey body.
     * This method specifically tests this by choosing all of the vaccination types one by one then checking if they are shown in the survey body.
     */
    @Test
    public void testVaccinationTypeDropdownMenu() {

    }

    /**
     * In the survey, name field should only accept english letters.
     * This method specifically tests this by entering all available letters to the name field and checks if the name field accepts the letter or not.
     */
    @Test
    public void testNameFieldLetterAcceptance() {

    }

    /**
     * In the survey, send button should not be clicked twice repeatedly to prevent sending the form data twice.
     * This method specifically tests this by clicking the send button and checks if it is still clickable.
     */
    @Test
    public void checkTestButtonVisibility() {

    }

    @AfterTest
    public void teardown() {
        appiumDriver.quit();
    }

}
