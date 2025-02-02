package org.example.pom;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PostRegisterPage extends BasePage {
    @AndroidFindBy(id = "com.interticket.budapest13:id/skip")
    private WebElement skipButton;

    public PostRegisterPage(final AndroidDriver driver) {
        super(driver);
    }

    public PostRegisterPage clickOnSkipButton() {
        skipButton.click();

        return this;
    }


    public boolean isRegisterSuccessful() {
        return driver.findElement(By.id("com.interticket.budapest13:id/alertTitle")).isDisplayed();
    }
}
