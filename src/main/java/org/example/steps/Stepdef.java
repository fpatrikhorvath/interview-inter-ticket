package org.example.steps;

import io.appium.java_client.android.AndroidDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.AppiumFactory;
import org.example.TestNGCucumberRunner;
import org.example.pom.DashboardPage;
import org.example.pom.LoginPage;
import org.example.pom.PostRegisterPage;
import org.example.pom.RegisterPage;
import org.example.services.MailingService;
import org.testng.Assert;


public class Stepdef{
    private MailingService   mailingService;
    private AndroidDriver    driver;
    private DashboardPage    dashboardPage;
    private LoginPage        loginPage;
    private RegisterPage     registerPage;
    private PostRegisterPage postRegisterPage;
    @Before
    public void setUp() {
        mailingService   = new MailingService();
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
        //Faker lib maybe
        registerPage.maximizeForm()
                .fillFirstName("Tihamer")
                .fillLastName("Tesztelesi")
                .fillEmailAddress(mailingService.getEmailAddress())
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

    @And("I validate that the registration email")
    public void iValidateThatTheRegistrationEmail() {
        System.out.println("Validation link: " + mailingService.getValidationLink());
    }

    /**
     * I wouldn't use it on prod
     *
     * @param seconds number of seconds
     */
    @And("I wait {int} seconds")
    public void iWaitSeconds(final int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
