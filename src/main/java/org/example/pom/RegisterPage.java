package org.example.pom;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    @AndroidFindBy(id = "com.interticket.budapest13:id/firstName")
    private WebElement firstNameInput;

    @AndroidFindBy(id = "com.interticket.budapest13:id/lastName")
    private WebElement lastNameInput;

    @AndroidFindBy(id = "com.interticket.budapest13:id/email")
    private WebElement emailAddressInput;

    @AndroidFindBy(id = "com.interticket.budapest13:id/newPassword")
    private WebElement passwordInput;

    @AndroidFindBy(id = "com.interticket.budapest13:id/newPasswordConfirmation")
    private WebElement passwordAgainInput;

    @AndroidFindBy(id = "com.interticket.budapest13:id/acceptDPPolicyCheckbox")
    private WebElement dpPolicyCheckbox;

    @AndroidFindBy(id = "com.interticket.budapest13:id/acceptTCCheckbox")
    private WebElement tcCheckbox;

    @AndroidFindBy(id = "com.interticket.budapest13:id/next")
    private WebElement registerButton;

    public RegisterPage(final AndroidDriver driver) {
        super(driver);
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
