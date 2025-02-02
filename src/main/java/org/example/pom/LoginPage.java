package org.example.pom;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    @AndroidFindBy(id = "com.interticket.budapest13:id/registrationLink")
    private WebElement registerButton;

    public LoginPage(final AndroidDriver driver) {
        super(driver);
    }

    public void openSignUpForm() {
        registerButton.click();
    }
}
