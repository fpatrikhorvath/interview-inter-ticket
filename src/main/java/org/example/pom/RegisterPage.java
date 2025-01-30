package org.example.pom;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.HashMap;

public class RegisterPage extends BasePage {
    private final WebElement firstNameInput;
    private final WebElement lastNameInput;
    private final WebElement emailAddressInput;
    private final WebElement passwordInput;
    private final WebElement passwordAgainInput;
    private final WebElement dpPolicyCheckbox;
    private final WebElement tcCheckbox;

    private final WebElement registerButton;

    public RegisterPage(final AndroidDriver driver) {
        super(driver);

        this.firstNameInput     = driver.findElement(By.id("com.interticket.budapest13:id/firstName"));
        this.lastNameInput      = driver.findElement(By.id("com.interticket.budapest13:id/lastName"));
        this.emailAddressInput  = driver.findElement(By.id("com.interticket.budapest13:id/email"));
        this.passwordInput      = driver.findElement(By.id("com.interticket.budapest13:id/newPassword"));
        this.passwordAgainInput = driver.findElement(By.id("com.interticket.budapest13:id/newPasswordConfirmation"));
        this.dpPolicyCheckbox   = driver.findElement(By.id("com.interticket.budapest13:id/acceptDPPolicyCheckbox"));
        this.tcCheckbox         = driver.findElement(By.id("com.interticket.budapest13:id/acceptTCCheckbox"));
        this.registerButton     = driver.findElement(By.id("com.interticket.budapest13:id/next"));
    }

    public RegisterPage fillFirstName(final String firstName) {
        firstNameInput.sendKeys(firstName);

        return this;
    }

    public RegisterPage fillLastName(final String lastName) {
        lastNameInput.sendKeys(lastName);

        return this;
    }

    public RegisterPage fillEmailAddress(final String emailAddress) {
        emailAddressInput.sendKeys(emailAddress);

        return this;
    }

    public RegisterPage fillPasswordInput(final String password) {
        passwordInput.sendKeys(password);

        return this;
    }

    public RegisterPage fillPasswordAgainInput(final String password) {
        passwordAgainInput.sendKeys(password);

        return this;
    }

    public RegisterPage acceptDPPolicyCheckbox() {
        dpPolicyCheckbox.click();

        return this;
    }

    public RegisterPage acceptTCCheckbox() {
        tcCheckbox.click();

        return this;
    }

    public RegisterPage clickOnRegister() {
        registerButton.click();

        return this;
    }

}
