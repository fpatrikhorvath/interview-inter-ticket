import io.appium.java_client.android.AndroidDriver;
import org.example.AppiumFactory;
import org.example.pom.DashboardPage;
import org.example.pom.LoginPage;
import org.example.pom.PostRegisterPage;
import org.example.pom.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterSuite {
    // Declare AppiumDriver instance
    private AndroidDriver    driver;
    private DashboardPage    dashboardPage;
    private LoginPage        loginPage;
    private RegisterPage     registerPage;
    private PostRegisterPage postRegisterPage;

    @BeforeTest
    public void setUp() {
        driver = AppiumFactory.getDriver();
    }

    @AfterTest
    public void tearDown() {
        AppiumFactory.tearDown();
    }

    @Test
    public void registerUser() {
        dashboardPage = new DashboardPage(driver);

        dashboardPage.openProfile();

        loginPage = new LoginPage(driver);
        loginPage.openSignUpForm();

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

        Assert.assertTrue(postRegisterPage.isRegisterSuccessful());
    }
}
