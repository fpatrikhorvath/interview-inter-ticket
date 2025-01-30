package org.example.pom;

import io.appium.java_client.android.AndroidDriver;

public abstract class BasePage {
    protected final AndroidDriver driver;

    protected BasePage(final AndroidDriver driver) {
        this.driver = driver;
    }
}
