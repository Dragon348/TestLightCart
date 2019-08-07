package net.lightcart;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumProperties {
    public WebDriver driver;
    public MainPage mainPage;
    public LoginPage loginPage;
    protected JavascriptExecutor jse;
    protected WebDriverWait wait;
    @Before
    public void setConfig() {
        System.setProperty("webdriver.chrome.driver", "F:\\Projects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.litecart.net/");
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        jse = (JavascriptExecutor)driver;
        wait = new WebDriverWait(driver, 5);
    }
    @After
    public void afterTest() {
        driver.quit();
    }
}
