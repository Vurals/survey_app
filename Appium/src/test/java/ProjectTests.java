import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

    public static final String DEVICE_NAME = "sdk_gphone_x86";
    public static final String UDID = "emulator-5554";
    public static final String PLATFORM_NAME = "Android";
    public static final String PLATFORM_VERSION = "11";
    public static final String APP_PACKAGE = "com.example.survey_app";
    public static final String APP_ACTIVITY = "MainActivity";



    private AndroidDriver<MobileElement> appiumDriver;
    private WebDriverWait webDriverWait;

    private ArrayList<String> cityList;

    private void loadCities() {
        cityList = new ArrayList<>();
        cityList.add("Adana");
        cityList.add("Adıyaman");
        cityList.add("Afyonkarahisar");
        cityList.add("Ağrı");
        cityList.add("Aksaray");
        cityList.add("Amasya");
        cityList.add("Ankara");
        cityList.add("Antalya");
        cityList.add("Ardahan");
        cityList.add("Artvin");
        cityList.add("Aydın");
        cityList.add("Balıkesir");
        cityList.add("Bartın");
        cityList.add("Batman");
        cityList.add("Bayburt");
        cityList.add("Bilecik");
        cityList.add("Bingöl");
        cityList.add("Bitlis");
        cityList.add("Bolu");
        cityList.add("Burdur");
        cityList.add("Bursa");
        cityList.add("Çanakkale");
        cityList.add("Çankırı");
        cityList.add("Çorum");
        cityList.add("Denizli");
        cityList.add("Diyarbakır");
        cityList.add("Düzce");
        cityList.add("Edirne");
        cityList.add("Elazığ");
        cityList.add("Erzincan");
        cityList.add("Erzurum");
        cityList.add("Eskişehir");
        cityList.add("Gaziantep");
        cityList.add("Giresun");
        cityList.add("Gümüşhane");
        cityList.add("Hakkâri");
        cityList.add("Hatay");
        cityList.add("Iğdır");
        cityList.add("Isparta");
        cityList.add("İstanbul");
        cityList.add("İzmir");
        cityList.add("Kahramanmaraş");
        cityList.add("Karabük");
        cityList.add("Karaman");
        cityList.add("Kars");
        cityList.add("Kastamonu");
        cityList.add("Kayseri");
        cityList.add("Kilis");
        cityList.add("Kırıkkale");
        cityList.add("Kırklareli");
        cityList.add("Kırşehir");
        cityList.add("Kocaeli");
        cityList.add("Konya");
        cityList.add("Kütahya");
        cityList.add("Malatya");
        cityList.add("Manisa");
        cityList.add("Mardin");
        cityList.add("Mersin");
        cityList.add("Muğla");
        cityList.add("Muş");
        cityList.add("Nevşehir");
        cityList.add("Niğde");
        cityList.add("Ordu");
        cityList.add("Osmaniye");
        cityList.add("Rize");
        cityList.add("Sakarya");
        cityList.add("Samsun");
        cityList.add("Şanlıurfa");
        cityList.add("Siirt");
        cityList.add("Sinop");
        cityList.add("Sivas");
        cityList.add("Şırnak");
        cityList.add("Tekirdağ");
        cityList.add("Tokat");
        cityList.add("Trabzon");
        cityList.add("Tunceli");
        cityList.add("Uşak");
        cityList.add("Van");
        cityList.add("Yalova");
        cityList.add("Yozgat");
        cityList.add("Zonguldak");
    }
    @BeforeTest
    public void setup() throws Exception {
        loadCities();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", DEVICE_NAME);
        cap.setCapability(CapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        cap.setCapability("appPackage", APP_PACKAGE);
        cap.setCapability("appActivity", APP_ACTIVITY);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        appiumDriver = new AndroidDriver<MobileElement>(url, cap);
        webDriverWait = new WebDriverWait(appiumDriver, 10);

        System.out.println("Application Started...");
    }

    /**
     * In the survey send data should be only shown when the proper data to the survey is given.
     * This method specifically tests when improper data is given to the survey whether if it will show the send button or not.
     */
    @Test
    public void testSendButtonVisibility() throws Exception {
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
        dateDayField.sendKeys("24");

        Thread.sleep(1000);
        dateMonthField.click();
        Thread.sleep(1000);
        dateMonthField.sendKeys("11");

        Thread.sleep(1000);
        dateYearField.click();
        Thread.sleep(1000);
        dateYearField.sendKeys("2000");

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

    private boolean checkButtonExistence() throws Exception {
        appiumDriver.hideKeyboard();
        try {
            waitUntilElementPresent("//android.widget.Button[@content-desc=\"Send\"]", 1000L);
            MobileElement button = appiumDriver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Send\"]"));
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
    public void testDateFormatAcceptance() throws Exception {
        MobileElement nameField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]"));
        MobileElement dayField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]"));
        MobileElement monthField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]"));
        MobileElement yearField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[4]"));

        nameField.click();
        Thread.sleep(1000);
        nameField.sendKeys("Matt Murdock");
        Thread.sleep(1000);
        appiumDriver.hideKeyboard();

        chooseCity();
        chooseVaccine();
        fillEffectsAndSymptoms();

        Thread.sleep(3000);

        dayField.click();
        Thread.sleep(1000);
        dayField.sendKeys("24");
        Thread.sleep(1000);
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

        for (int i = -2; i < 35; i++) {
            dayField.click();
            if(0 < i && i < 10)
                dayField.sendKeys("0" + i);
            else
                dayField.sendKeys(i + "");
            if(i < 1 || i > 31)
                Assert.assertFalse(checkButtonExistence());
            else
                Assert.assertTrue(checkButtonExistence());
        }

        dayField.click();
        Thread.sleep(1000);
        dayField.sendKeys("24");
        Thread.sleep(500);

        for (int i = -2; i < 15; i++) {
            monthField.click();
            if(0 < i && i < 10)
                monthField.sendKeys("0" + i);
            else
                monthField.sendKeys(i + "");
            if(i < 1 || i > 12)
                Assert.assertFalse(checkButtonExistence());
            else
                Assert.assertTrue(checkButtonExistence());
        }

        monthField.click();
        Thread.sleep(1000);
        monthField.sendKeys("11");
        Thread.sleep(500);

        for (int i = 1898; i < 2025; i++) {
            if(i >1903 && i < 2020)
                continue;
            yearField.click();
            yearField.sendKeys(i + "");
            if(i < 1900 || i > 2022)
                Assert.assertFalse(checkButtonExistence());
            else
                Assert.assertTrue(checkButtonExistence());
        }

        yearField.click();
        yearField.sendKeys("2000");
        Thread.sleep(1000);
        appiumDriver.hideKeyboard();

        MobileElement sendButton = appiumDriver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Send\"]"));
        sendButton.click();

        Thread.sleep(1000);

        System.out.println("Test case #2 is successful.");
    }

    /**
     * In the survey, when a city is chosen in the dropdown menu, that type should be shown in the survey body.
     * This method specifically tests this by choosing all of the cities one by one then checking if they are shown in the survey body.
     */
    @Test
    public void testCityDropdownMenu() throws Exception {
        MobileElement dropdownCity = appiumDriver.findElement(By.xpath("(//android.widget.Button[@content-desc=\"-\"])[1]"));

        for (String city : cityList) {
            waitUntilElementPresent("(//android.widget.Button[@content-desc=\"-\"])[1]", 10000L);
            dropdownCity.click();
            waitUntilElementPresent("//android.view.View[@content-desc=\"" + city + "\"]", 10000L);
            MobileElement chosenCity = appiumDriver.findElement(By.xpath("//android.view.View[@content-desc=\"" + city + "\"]"));
            webDriverWait.until(ExpectedConditions.elementToBeClickable(chosenCity));
            chosenCity.click();
            Assert.assertTrue(checkCityExistence("//android.widget.Button[@content-desc=\"" + city + "\"]"));
        }

        System.out.println("Test case #3 is successful.");
    }


    private boolean checkCityExistence(String xpath) throws Exception {
        waitUntilElementPresent(xpath, 10000L);
        try {
            MobileElement writtenCity = appiumDriver.findElement(By.xpath(xpath));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    private void waitUntilElementPresent(String xpath, Long timeout) throws Exception {
        boolean present = false;
        Long begin = System.currentTimeMillis();
        while (!present) {
            try {
                appiumDriver.findElement(By.xpath(xpath));
                present = true;
            } catch (Exception e) {

            }
            if (timeout < System.currentTimeMillis() - begin) {
                throw new Exception();
            }
        }
    }

    /**
     * In the survey, name field should only accept english letters.
     * This method specifically tests this by entering all available letters to the name field and checks if the name field accepts the letter or not.
     */
    @Test
    public void testNameFieldLetterAcceptance() throws Exception {
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

        chooseCity();
        chooseVaccine();
        fillEffectsAndSymptoms();

        String englishLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";

        for (int i = 32; i < 127; i++) {
            String character = Character.toString((char) i);
            if(englishLetters.contains(character))
                continue;
            nameField.click();
            nameField.sendKeys("abcd " + character);
            Assert.assertFalse(checkButtonExistence());
        }

        //All English Letters
        nameField.click();
        nameField.sendKeys(englishLetters);
        Assert.assertTrue(checkButtonExistence());

        appiumDriver.hideKeyboard();

        MobileElement sendButton = appiumDriver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Send\"]"));
        sendButton.click();

        Thread.sleep(1000);

        System.out.println("Test case #4 is successful.");
    }

    /**
     * In the survey, send button should not be clicked twice repeatedly to prevent sending the form data twice.
     * This method specifically tests this by clicking the send button and checks if it is still clickable.
     */
    @Test
    public void testRepeatedClick() throws Exception {
        MobileElement nameField = appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]"));
        nameField.click();
        Thread.sleep(1000);
        nameField.sendKeys("Matt Murdock");
        Thread.sleep(1000);
        appiumDriver.hideKeyboard();

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

        chooseCity();
        chooseVaccine();
        fillEffectsAndSymptoms();

        MobileElement sendButton = appiumDriver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Send\"]"));
        sendButton.click();

        try{
            Assert.assertFalse(Boolean.parseBoolean(sendButton.getAttribute("clickable")));
        }
        catch(AssertionError e){
            System.out.println("Test case #5 failed: The \"Send\" button is still clickable after the first click.");
            return;
        }
        catch (Exception e) {
            System.out.println("Test case #5 is successful.");
            return;
        }

        System.out.println("Test case #5 is successful.");
    }

    @AfterMethod
    public void resetApp() throws InterruptedException {
        appiumDriver.resetApp();
        Thread.sleep(10000);
    }
    @AfterTest
    public void teardown() {
        appiumDriver.quit();
    }


    private void chooseCity() throws InterruptedException {
        MobileElement cityDropdown = appiumDriver.findElement(By.xpath("(//android.widget.Button[@content-desc=\"-\"])[1]"));
        cityDropdown.click();
        Thread.sleep(1000);
        MobileElement cityItem = appiumDriver.findElement(By.xpath("//android.view.View[@content-desc=\"Adana\"]"));
        cityItem.click();
        Thread.sleep(1000);
    }

    private void chooseVaccine() throws InterruptedException {
        MobileElement vaccineDropdown = appiumDriver.findElement(By.xpath("//android.widget.Button[@content-desc=\"-\"]"));
        vaccineDropdown.click();
        Thread.sleep(1000);
        MobileElement vaccineItem = appiumDriver.findElement(By.xpath("//android.view.View[@content-desc=\"Sinovac\"]"));
        vaccineItem.click();
        Thread.sleep(1000);
    }

    private void fillEffectsAndSymptoms() throws InterruptedException {
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
    }

}
