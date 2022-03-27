const wdio = require("webdriverio")
const assert = require("assert");
const finder = require("appium-flutter-finder");



const opts = {
    path: '/wd/hub',
    port: 4723,
    capabilities: {
        platformName: "Android",
        platformVersion: "11",
        deviceName: "sdk_gphone_x86",
        app: 'C:\\Survey_app\\Build\\app\\outputs\\apk\\debug\\app-debug.apk',
        appPackage: "com.example.survey_app",
        appActivity: "MainActivity"
    }
};


async function main () {
  const driver = await wdio.remote(opts);

  const el = driver.findElement(By.xpath("[@key=nameField]"));
  console.log(el)

  console.log("end");
}
main();
