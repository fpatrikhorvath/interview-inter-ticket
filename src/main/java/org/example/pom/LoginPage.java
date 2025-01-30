package org.example.pom;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    private final WebElement registerButton;

    public LoginPage(final AndroidDriver driver) {
        super(driver);
        this.registerButton = driver.findElement(By.id("com.interticket.budapest13:id/registrationLink"));
    }

    public void openSignUpForm(){
        registerButton.click();
    }
}
