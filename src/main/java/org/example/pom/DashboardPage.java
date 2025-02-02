package org.example.pom;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    @AndroidFindBy(id = "com.interticket.budapest13:id/toolBarProfileImage")
    private WebElement profileButton;

    public DashboardPage(final AndroidDriver driver) {
        super(driver);
    }

    public void openProfile() {
        profileButton.click();
    }
}
