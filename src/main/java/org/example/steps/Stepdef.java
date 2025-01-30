package org.example.steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.AppiumFactory;
import org.example.pom.DashboardPage;
import org.example.pom.LoginPage;
import org.example.pom.PostRegisterPage;
import org.example.pom.RegisterPage;
import org.testng.Assert;

public class Stepdef {
    private AndroidDriver    driver;
    private DashboardPage    dashboardPage;
    private LoginPage        loginPage;
    private RegisterPage     registerPage;
    private PostRegisterPage postRegisterPage;

    @Before
    public void setUp() {
        driver = AppiumFactory.getDriver();
    }

    @After
    public void tearDown() {
        AppiumFactory.tearDown();
    }

    @Given("I open up the sign up form")
    public void iOpenUpSignUpForm() {
        dashboardPage = new DashboardPage(driver);

        dashboardPage.openProfile();

        loginPage = new LoginPage(driver);
        loginPage.openSignUpForm();
    }

    @When("I fill the sign up form")
    public void iFillTheSignUpForm() {
        registerPage = new RegisterPage(driver);
        //Faker lib
        registerPage.fillFirstName("Tihamer")
                .fillLastName("Tesztelesi")
                .fillEmailAddress("adastros1@gmail.com")
                .fillPasswordInput("Teszt1234-")
                .fillPasswordAgainInput("Teszt1234-")
                .acceptTCCheckbox()
                .acceptDPPolicyCheckbox()
                .clickOnRegister();

        postRegisterPage = new PostRegisterPage(driver);
        postRegisterPage.clickOnSkipButton();
    }


    @Then("I validate that the registration is successful")
    public void iValidateRegistrationSuccessful() {
        Assert.assertTrue(postRegisterPage.isRegisterSuccessful());
    }
}
