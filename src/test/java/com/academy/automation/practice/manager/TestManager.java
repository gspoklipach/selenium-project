package com.academy.automation.practice.manager;

import com.academy.automation.practice.manager.helper.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestManager {
    private static int DEFAULT_WAIT = 30;
    protected final Properties prop = new Properties();
    private String baseUrl;

    private WebDriver driver;
    private NavigationHelper navigationHelper;

    public WebDriver getDriver() {
        return driver;
    }

    public void init(String browser) throws IOException {
        String path = System.getProperty("cfg");
        prop.load(new FileInputStream(path));
        baseUrl = prop.getProperty("url");

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome.driver"));
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox.driver"));
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        //        driver.manage().window().maximize();

        navigationHelper = new NavigationHelper(driver, baseUrl);
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public void stop() {
        driver.quit();
    }
}
