import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProjectTests {

    public static final String DEVICE_NAME = "Pixel 2 API 29";
    public static final String UDID = "emulator-5554";
    public static final String PLATFORM_NAME = "Android";
    public static final String PLATFORM_VERSION = "10";
    public static final String APP_PACKAGE = "com.example.survey_app";
    public static final String APP_ACTIVITY = "com.example.survey_app.MainActivity";



    private AndroidDriver<MobileElement> appiumDriver;
    private WebDriverWait webDriverWait;

    @BeforeTest
    public void setup() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", DEVICE_NAME);
        cap.setCapability(CapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        cap.setCapability("appPackage", APP_PACKAGE);
        cap.setCapability("appActivity", APP_ACTIVITY);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        appiumDriver = new AndroidDriver<MobileElement>(url, cap);

        System.out.println("Application Started...");
    }

    /**
     * In the survey send data should be only shown when the proper data to the survey is given.
     * This method specifically tests when improper data is given to the survey whether if it will show the send button or not.
     */
    @Test
    public void testSendButtonVisibility() throws InterruptedException {
        MobileElement nameFiled = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]"));
        MobileElement dateDayField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]"));
        MobileElement dateMonthField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]"));
        MobileElement dateYearField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[4]"));
        MobileElement sideEffectField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[5]"));
        MobileElement pcrTextField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[6]"));
        MobileElement dropdownMenu = appiumDriver.findElement(By.xpath("(//android.widget.Button[@content-desc=\"-\"])[1]"));
        MobileElement dropdownVaccine = appiumDriver.findElement(By.xpath("(//android.widget.Button[@content-desc=\"-\"])[2]"));

        //Name
        Thread.sleep(1000);
        nameFiled.click();
        Thread.sleep(1000);
        nameFiled.sendKeys("Bora");

        Assert.assertFalse(checkButtonExistence());
        System.out.println("Assertion#1 Passed");

        //Date
        Thread.sleep(1000);
        dateDayField.click();
        Thread.sleep(1000);
        dateDayField.sendKeys("00");

        Thread.sleep(1000);
        dateMonthField.click();
        Thread.sleep(1000);
        dateMonthField.sendKeys("00");

        Thread.sleep(1000);
        dateYearField.click();
        Thread.sleep(1000);
        dateYearField.sendKeys("00");

        Assert.assertFalse(checkButtonExistence());
        System.out.println("Assertion#2 Passed");

        //Dropdown City
        Thread.sleep(1000);
        dropdownMenu.click();
        Thread.sleep(1000);

        Thread.sleep(2000);
        MobileElement chosenCity = appiumDriver.findElement(By.xpath("//android.view.View[@content-desc=\"Ağrı\"]"));
        Thread.sleep(1000);
        chosenCity.click();

        Assert.assertFalse(checkButtonExistence());
        System.out.println("Assertion#3 Passed");

        //Dropdown Vaccine
        Thread.sleep(1000);
        dropdownVaccine.click();
        Thread.sleep(1000);

        Thread.sleep(2000);
        MobileElement chosenVaccine = appiumDriver.findElement(By.xpath("//android.view.View[@content-desc=\"Sinovac\"]"));
        Thread.sleep(1000);
        chosenVaccine.click();

        Assert.assertFalse(checkButtonExistence());
        System.out.println("Assertion#4 Passed");

        //Side Effect
        Thread.sleep(1000);
        sideEffectField.click();
        Thread.sleep(1000);
        sideEffectField.sendKeys("Bora");

        Assert.assertFalse(checkButtonExistence());
        System.out.println("Assertion#5 Passed");

        //PCR Field
        appiumDriver.hideKeyboard();
        Thread.sleep(1000);
        pcrTextField.click();
        Thread.sleep(1000);
        pcrTextField.sendKeys("Bora");
        appiumDriver.hideKeyboard();

        Assert.assertTrue(checkButtonExistence());
        System.out.println("Assertion#6 Passed");

        System.out.println("\nTest Case#1 Passed");
    }

    private boolean checkButtonExistence() throws InterruptedException {
        appiumDriver.hideKeyboard();
        Thread.sleep(1000);
        try {
            MobileElement button = appiumDriver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Gönder\"]"));
            return true;
        }
        catch (Exception e) {
            return false;
        }
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
    public void testNameFieldLetterAcceptance() throws InterruptedException {
        MobileElement nameField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]"));
        
        //Fill other fields first
        MobileElement dayField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]"));
        MobileElement monthField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]"));
        MobileElement yearField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[4]"));

        dayField.click();
        Thread.sleep(1000);
        dayField.sendKeys("24");
        Thread.sleep(1000);
        //webDriverWait.until(ExpectedConditions.textToBePresentInElement(dayField, "24"));
        appiumDriver.hideKeyboard();
        monthField.click();
        Thread.sleep(1000);
        monthField.sendKeys("11");
        Thread.sleep(1000);
        appiumDriver.hideKeyboard();
        yearField.click();
        yearField.sendKeys("2000");
        Thread.sleep(1000);
        appiumDriver.hideKeyboard();

        MobileElement cityDropdown = appiumDriver.findElement(By.xpath("(//android.widget.Button[@content-desc=\"-\"])[1]"));
        cityDropdown.click();
        Thread.sleep(1000);
        MobileElement cityItem = appiumDriver.findElement(By.xpath("//android.view.View[@content-desc=\"Adana\"]"));
        cityItem.click();
        Thread.sleep(1000);

        MobileElement vaccineDropdown = appiumDriver.findElement(By.xpath("//android.widget.Button[@content-desc=\"-\"]"));
        vaccineDropdown.click();
        Thread.sleep(1000);
        MobileElement vaccineItem = appiumDriver.findElement(By.xpath("//android.view.View[@content-desc=\"Sinovac\"]"));
        vaccineItem.click();
        Thread.sleep(1000);

        MobileElement sideEffectField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[5]"));
        MobileElement symptomField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[6]"));

        sideEffectField.click();
        sideEffectField.sendKeys("None");
        Thread.sleep(1000);
        appiumDriver.hideKeyboard();
        symptomField.click();
        symptomField.sendKeys("None");
        Thread.sleep(1000);
        appiumDriver.hideKeyboard();

        nameField.click();

        String englishLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";

        for (int i = 32; i < 127; i++) {
            String character = Character.toString((char) i);
            if(englishLetters.contains(character))
                continue;
            nameField.sendKeys("abcd " + character);
            Thread.sleep(1000);
            appiumDriver.hideKeyboard();
            assert
        }

        //All English Letters
        nameField.sendKeys(englishLetters);
        Thread.sleep(1000);
        appiumDriver.hideKeyboard();



        MobileElement sendButton = appiumDriver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Gönder\"]"));
        sendButton.click();

        Thread.sleep(5000);
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
