package org.pages;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConnectionsPage extends BasePage {
    private final By connectionsResults = By.className("reusable-search__result-container");
    private final By connectionTitle = By.cssSelector("[class*='entity-result__title-text']");
    private final By connectionPrimaryTitle = By.cssSelector("[class*='entity-result__primary-subtitle']");
    private final By connectionSecondaryTitle = By.cssSelector("[class*='entity-result__secondary-subtitle']");
    private final By connectionInsights = By.cssSelector("[class*='entity-result__insights']");

    public ConnectionsPage(WebDriver driver) {
        super(driver);
    }

    public void extract_connections_to_json() {
        waitForElementToBeVisible(connectionsResults);

        JSONArray jsonArray = new JSONArray();
        List<WebElement> elements = driver.findElements(connectionsResults);
        for (WebElement element : elements) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("myName", element.findElement(connectionTitle).getText().split("\n")[0]);
            jsonObject.put("myWorkplace", element.findElement(connectionPrimaryTitle).getText());
            jsonObject.put("city", element.findElement(connectionSecondaryTitle).getText());
            jsonObject.put("connections", element.findElement(connectionInsights).getText());
            jsonArray.put(jsonObject);
        }
        try (FileWriter fileWriter = new FileWriter("connections.json")) {
            fileWriter.write(jsonArray.toString());
        } catch (IOException ex) {
            ex.fillInStackTrace();
        }
    }
}
