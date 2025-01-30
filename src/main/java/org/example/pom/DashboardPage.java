package org.example.pom;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage{
    private final WebElement profileButton;

    public DashboardPage(final AndroidDriver driver) {
        super(driver);
        this.profileButton = driver.findElement(By.id("com.interticket.budapest13:id/toolBarProfileImage"));
    }
    public void openProfile(){
        profileButton.click();
    }
}
