package com.academy.automation.practice.manager.helper;

import com.academy.automation.practice.page.MyAccountPage;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class AccountHelper {

    private WebDriver driver;

    public AccountHelper(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName() {
        return new MyAccountPage(driver).getUserNameCapture();
    }
}
