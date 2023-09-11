package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By usernameField = By.id("session_key");
    private final By passwordField = By.id("session_password");
    private final By signInButton = By.cssSelector("[data-id='sign-in-form__submit-btn']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        driver.get("https://www.linkedin.com/home");
    }

    public void login(String username, String password) {
        waitForElementToBeVisible(usernameField);
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }
}
