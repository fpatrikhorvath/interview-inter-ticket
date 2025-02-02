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
        driver           = AppiumFactory.getDriver();
        dashboardPage    = new DashboardPage(driver);
        loginPage        = new LoginPage(driver);
        registerPage     = new RegisterPage(driver);
        postRegisterPage = new PostRegisterPage(driver);
    }

    @After
    public void tearDown() {
        AppiumFactory.tearDown();
    }

    @Given("I open up the sign up form")
    public void iOpenUpSignUpForm() {
        dashboardPage.openProfile();

        loginPage.openSignUpForm();
    }

    @When("I fill the sign up form")
    public void iFillTheSignUpForm() {
        //Faker lib
        registerPage.maximizeForm()
                .fillFirstName("Tihamer")
                .fillLastName("Tesztelesi")
                .fillEmailAddress("adastros1@gmail.com")
                .fillPasswordInput("Teszt1234-")
                .fillPasswordAgainInput("Teszt1234-")
                .acceptTCCheckbox()
                .acceptDPPolicyCheckbox()
                .clickOnRegister();

        postRegisterPage.clickOnSkipButton();
    }


    @Then("I validate that the registration is successful")
    public void iValidateRegistrationSuccessful() {
        Assert.assertTrue(postRegisterPage.isRegisterSuccessful());
    }

}
