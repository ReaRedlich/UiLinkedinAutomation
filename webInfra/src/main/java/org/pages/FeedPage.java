package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FeedPage extends BasePage {
    private final By meButton = By.id("ember15");
    private final By viewProfileButton = By.xpath("//a[contains(@class, 'artdeco-button--secondary') and text()='View Profile']");

    public FeedPage(WebDriver driver) {
        super(driver);
    }

    public void go_to_my_profile() {
        waitForElementToBeClickable(meButton);
        driver.findElement(meButton).click();
        waitForElementToBeVisible(viewProfileButton);
        driver.findElement(viewProfileButton).click();
    }
}
