package com.academy.automation.practice.manager.helper;

import org.openqa.selenium.WebDriver;

public class NavigationHelper {

    private WebDriver driver;
    private String baseUrl;

    public NavigationHelper(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    public void toHome() {
        driver.get(baseUrl);
    }
}
