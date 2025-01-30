package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class AppiumFactory {
    private static final String  PLATFORM_NAME          = "Android";
    private static final String  UI_AUTOMATOR_2         = "UiAutomator2";
    private static final String  APP_PACKAGE            = "com.interticket.budapest13";
    private static final String  APP_ACTIVITY           = "com.interticket.smartcity.ui.MainActivity";
    private static final Boolean AUTO_GRANT_PERMISSIONS = true;
    private static final Boolean AUTO_DISMISS_ALERTS    = true;
    private static final String  PROTOCOL               = "http";
    private static final String  IP                     = "127.0.0.1";
    private static final int     PORT                   = 4723;
    private static final int     TIMEOUT_IN_SECONDS     = 30;

    private static AndroidDriver driver;
    private static boolean       isInitialized = false;


    public static AndroidDriver getDriver() {
        if (!isInitialized) {
            isInitialized = true;
            init();
        }
        return driver;
    }

    public static void tearDown() {
        if (isInitialized) {
            isInitialized = false;

            driver.quit();
        }
    }

    private static URL getUrl() {
        try {
            return new URI(PROTOCOL + "://" + IP + ":" + PORT).toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    private static void init() {
        try {
            // Configure desired capabilities
            final DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", PLATFORM_NAME);
            capabilities.setCapability("automationName", UI_AUTOMATOR_2);
            capabilities.setCapability("appPackage", APP_PACKAGE);
            capabilities.setCapability("appActivity", APP_ACTIVITY);
            capabilities.setCapability("autoGrantPermissions", AUTO_GRANT_PERMISSIONS);
            capabilities.setCapability("autoDismissAlerts", AUTO_DISMISS_ALERTS);

            // Initialize AppiumDriver instance
            final URL appiumServerUrl = getUrl();
            driver = new AndroidDriver(appiumServerUrl, capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(TIMEOUT_IN_SECONDS * 1000));

        } catch (Exception e) {
            throw new RuntimeException("Appium driver init error");
        }
    }
}
