package org.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.ConnectionsPage;
import org.pages.FeedPage;
import org.pages.LoginPage;
import org.pages.ProfilePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinkedinTests {
    private final String username = "{Please enter your username}";
    private final String password = "{Please enter your password}";
    private LoginPage loginPage;
    private FeedPage feedPage;
    private ProfilePage profilePage;
    private ConnectionsPage connectionsPage;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        feedPage = new FeedPage(driver);
        profilePage = new ProfilePage(driver);
        connectionsPage = new ConnectionsPage(driver);
    }

    @AfterTest
    public void tearDown() {
        loginPage.quitDriver();
    }

    @Test
    public void test_extractConnectionsToJson() {
        loginPage.openLoginPage();
        loginPage.login(username, password);
        feedPage.go_to_my_profile();
        profilePage.enter_to_profile_connections();
        connectionsPage.extract_connections_to_json();
    }
}
