package net.lightcart;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.regex.Pattern;

/*Сделал проверку работы select'ов, смены настроек, проверка работы поиск, ввода текста в текстовое поле, проверка работы переключения вкладок, работы всплывающих эелементов, на примере
* скролап кнопки. Остальные проверки будут вариацией написанных.*/
public class TESTS extends SeleniumProperties{
    private final String email = "test@gmail.com";
    private final String pass = "testpass";
    /*Проверка смены страны и валюты*/
    @Test
    public void changeOptions() throws InterruptedException {
        mainPage.clickChangeButton();
        Thread.sleep(1000);
        mainPage.selectCountry("North Korea");
        mainPage.selectCurrency("Euros");
        mainPage.clickSaveButton();
    }
    /*Проверка авторизации*/
    @Test
    public void signIn()   {
        mainPage.clickSignInButton();
        mainPage.setEmail(email);
        mainPage.setPassword(pass);
        mainPage.clickLoginButton();
        Assert.assertEquals(loginPage.getLoginError(), "×\n" +
                "Wrong password or the account does not exist");

    }
    /*Проверка поиска*/
    @Test
    public void search()   {
        mainPage.setSearch("Duck");
        boolean searchComplete = Pattern.matches(".*demo.litecart.net/search.*",driver.getCurrentUrl());
        Assert.assertTrue(searchComplete);
    }
    /*Проверка работы вкладок*/
    @Test
    public void tabCheck()   {
        mainPage.clickLatestProducts();
        Assert.assertEquals("Latest Products", mainPage.getActiveTabName());
        mainPage.clickPopularProducts();
        Assert.assertEquals("Popular Products", mainPage.getActiveTabName());
        mainPage.clickCampaignProducts();
        Assert.assertEquals("Campaign Products", mainPage.getActiveTabName());
    }
    /*Проверка работы выпадающего списка rubber duck*/
    @Test
    public void dropdownCheck()   {
        mainPage.clickDropDowmRubberDuck();
        mainPage.clickSubcategory();
        boolean jumpComplete = Pattern.matches(".*demo.litecart.net/rubber-ducks-c-1/subcategory-c-2/.*",driver.getCurrentUrl());
        Assert.assertTrue(jumpComplete);
    }

    /*Проверка отображения кнопки СкролАп при прокрутке экрана и работы её после появления*/
    @Test
    public void scrollUp() {
        jse.executeScript("window.scrollBy(0,250)");
        wait.until(ExpectedConditions.visibilityOf(mainPage.scrollUpButtoun));
        mainPage.clickScrollUpButton();
    }

}
