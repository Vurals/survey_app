Below you can find set up procedures:

1) First thing to do is setting up an android emulator you can download Android Studio and do that from there. (Android Studio Download: https://developer.android.com/studio)

2) Then you should be downloading the Flutter. Then go ahead and add Flutter to your envrionment variables path so that you can run Flutter commands on the cmd (If you want). (You can download Flutter from here: https://docs.flutter.dev/get-started/install/windows)

3) Then you should be downloading the Appium Server GUI so that you can run an Appium http server that listens to commands and executes them on the emulator. (You can download it from here: https://github.com/appium/appium-desktop/releases/tag/v1.22.2)

4) Before we start any application you should be careful that when you start the Appium Server GUI and click "Edit" button both of the SDK and Android Home fields are not empty and given appropriate paths.

5) Now you can set up an emulator from the Android Studio using the device manager. You can set up any android version you want but the version and the device name will be entered to the Appium capabilities, so that we recommend using version 10 or 

6) Now you can open the Flutter project using the Android Studio and click the run button so that it opens the emulator and runs the Flutter application. At this point you should be able to see the survey app on the emulator.

7) Before you run the tests capabilities should be entered correctly according to your emulator settings. Go to the Appium/src/test/java/ProjectTest.java file of the project and change the DEVICE_NAME and PLATFORM_VERSION variables that are at line 24 and 27 according to your emulator's settings.

8) At this point you have set up everything and ready to run the whole system, so first start the appium server and the emulator.

9) Then after emulator opens you can run the tests in the Appium/src/test/java/ProjectTest.java file.

