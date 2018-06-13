package com.academy.automation.practice.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {
    protected static final int DEFAULT_WAIT = 30;
    protected static final Logger LOG = LogManager.getLogger(BaseTest.class);

    protected WebDriver driver;
    protected String baseUrl;
    protected Properties prop;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(String browser) throws Exception {
        String path = System.getProperty("cfg");
        prop = new Properties();
        prop.load(new FileInputStream(path));

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome.driver"));
                //driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox.driver"));
                driver = new FirefoxDriver();
                break;
        }

        //baseUrl = prop.getProperty("url");
        //driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        //driver.quit();
    }
}
