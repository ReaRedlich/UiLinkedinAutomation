package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    private final By connectionsButton = By.partialLinkText("500+ connections");

    public ProfilePage(WebDriver driver) { super(driver); }

    public void enter_to_profile_connections() {
        waitForElementToBeVisible(connectionsButton);
        driver.findElement(connectionsButton).click();
    }
}
