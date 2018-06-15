package com.academy.automation.practice.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(groups = "login", dataProvider = "userName")
    public void testSuceessLogin(String userNameExpected) throws Exception {
        manager.goTo().home();
        manager.session().login();

        String userNameActual = manager.account().getUserName();
        Assert.assertEquals(userNameActual, userNameExpected);
        manager.session().logout();
    }

    @Test(groups = {"login", "provider"}, dataProvider = "loginIncorrectData")
    public void testIncorrectLogin(String login, String password, String expectedMessage) {
        manager.goTo().home();
        manager.session().tryLogin(login, password);
        String actualMsg = manager.session().getErrMessage();
        Assert.assertEquals(actualMsg, expectedMessage);
    }

    @DataProvider(name="userName")
    public Object[][] provideLoginCorrect() {
        return new Object[][] {
                {"Oleg Afanasiev"}
        };
    }


    // TODO read from excel
    @DataProvider(name="loginIncorrectData")
    public Object[][] provideLoginIncorrectData() {
        return new Object[][] {
                {"oleg.kh81@gmail.com", "123", "Invalid password."},
                {"123", "123qwerty", "Invalid email address."},
                {"", "123", "An email address required."},
        };
    }
}

