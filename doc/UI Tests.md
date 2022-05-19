# UI Tests

Author of the document:

- Péter Tóth

Responsible for writing UI tests:

- Péter Tóth

## **Main ideas**

Whenever we talk about software testing, the following expressions come to mind first: unit tests, integration tests and exploratory tests. It's totally understandable since these tests verify that our program implements all the necessary features, contains no (or at least a small amount) of bugs and works as expected.

But what's the part of our application that the user first interacts with? It's the UI. The logic of the application might be beautifully designed but what if the UI is poorly constructed and doesn't display the expected data? In this case, the user will have a bad user experience and will stop using our apllication. This is where UI tests come into play.

## **Goals**

The goal of writing UI tests is to verify that we actually see what we should see on the screen. The application consists of multiple fragments with their own characteristics so I tried to test as many aspects of them as possible.

## **Used tools**

There are several tools available for UI testing like Appium or Selenium but the recommended one for Android applications is **_Espresso_**. Besides, there's an Android Studio plugin called **_Espresso Test Recorder_** which makes generating Espresso UI tests possible by interactig with the UI. This way, we don't need to manually write long and complex UI tests, instead, the plugin generates them for us. Of course, we can edit these test scenarios if necessary to customize our tests.

## **Tests**

- **LoginScreenAppearanceTest**

  This test is a pretty simple one, it only checks if the login screen displays all the expected elements: action bar with the _Login_ title, sign in button and login status

- **LoginTest**

  The test checks if the main page appears approprietaly after login. It should display a welcome message, a card with the text _Off_, a logout button and a navigation bar at the bottom of the screen

- **LogoutTest**

  The test is basically the reverse of the previous one. When we click the logout button, we should return to the login screen

- **MapAppearanceTest**

  One of the most significant part of the application UI is a real-time Google Maps map which is responsible for displaying the paths of the saved sessions. When we click the Map button on the main page, the map should appear on the next screen

- **TurnOnLocationTest**

  In order to record a session, we have to give the app permission to access our location. To do this, we need to click the card with the _Off_ label on the main screen. After it, another card should appear with the _On_ label

- **TurnOffLocationTest**

  When we want to finish recording the current session, wew need to click the card with the _On_ label. After it, the other card with the _Off_ label should appear again

- **StartSessionTest**

  Clicking the Sessions button on the bottom navigation bar navigates us to the Sessions screen. Here, after the recording has started, a session card should appear

- **SessionCardDefaultAppearanceTest**

  The previously mentioned session card displays default values when the session recording is still in progress. The session duration should show 0 minutes, and the session distance should show 0.00 km

- **OneMinuteFixLocationSessionTest**

  To simulate an actual session, I started a session recording and stopped it after 60 seconds. Meanwhile, the emulator maintained its original location. This way, the expected session duration is 1 minute and the session distance is the default 0.00 km

- **PathScreenTest**

  After recording a session, we can check out its path by clicking the viewInMap button on the session card. This should navigate us to the path screen where the Google Maps map should appear

## **Limitations**

While generating the UI tests, I encountered a small issue with _Espresso_ and _Espresso Test Recorder_. They're not capable of handling non-app UI so there was a test case I had to omit. When the recording starts, a notification appears on the status bar of the phone. I wanted to verify that it actually appears but since it's considered as non-app UI, it wasn't possible.

On the other hand, the same issue occurs when the Google sign in popup window appears. You have to manually press the button so the test can continue automatically.

## **Conclusions**

Previously, I hadn't had any experience with UI testing so it was great that I had the opportunity to gather experience with it. I tried to test as many parts of the UI as possible considering the limitations mentioned earlier. According to the test results, the UI works as expected. The layouts of the screens are displayed correctly and the expected data appears on them.
