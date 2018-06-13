package com.academy.test.automation.practice.test;

import com.academy.test.automation.practice.page.HomePage;
import com.academy.test.automation.practice.page.WomenPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTests extends BaseTest {

    @Test
    public void testWomenMenu() {

        // 1 ШАГ - перейти на страницу
        // TODO
        driver.get(baseUrl);

        // 2 ШАГ - клик по меню "Women"
        HomePage homePage = new HomePage(driver);
        WomenPage womenPage = homePage.clickWomenLink();

        // 3 ШАГ - считываю заголовок "Women"
        String womenCaptureText = womenPage.getWomenCapture();

        // 4 ШАГ - проверяем соответствие заголовока тексту "Women"
        Assert.assertEquals(womenCaptureText, "Women");
    }
}
