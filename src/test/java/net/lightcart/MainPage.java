package net.lightcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPage {
    @FindBy (xpath = "//a[contains(text(),'Change')]")
    private WebElement changeButton;
    @FindBy (xpath = "//select[@name='country_code']")
    private WebElement countrySelect;
    @FindBy (xpath = "//button[@name='save']")
    private WebElement saveButton;
    @FindBy (xpath = "//select[@name='currency_code']")
    private WebElement currencySelect;
    @FindBy (xpath = "//a[contains(text(),'Sign In')]")
    private WebElement signInButton;
    @FindBy (xpath = "//input[@placeholder='Email Address']")
    private WebElement emailField;
    @FindBy (xpath = "//input[@placeholder='Password']")
    private WebElement passField;
    @FindBy (xpath = "//button[@name='login']")
    private WebElement logginButton;
    @FindBy (xpath = "//input[@placeholder='Search products …']")
    private WebElement searchField;
    @FindBy (xpath = " //a[contains(text(),'Campaign Products')]")
    private WebElement campaignProducts;
    @FindBy (xpath = "//a[contains(text(),'Popular Products')]")
    private WebElement popularProducts;
    @FindBy (xpath = "//a[contains(text(),'Latest Products')]")
    private WebElement latestProducts;
    @FindBy (xpath = "//ul[@class='nav nav-justified nav-tabs']//li[@class='active']")
    private WebElement activeTab;
    @FindBy (xpath = "//a[@class='dropdown-toggle'][contains(text(),'Rubber Ducks')]")
    private WebElement dropDowmRubberDuck;
    @FindBy (xpath = "//a[contains(text(),'Subcategory')]")
    private WebElement subcategory;
    @FindBy (id = "scroll-up")
    public WebElement scrollUpButtoun;
    public MainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    public void clickChangeButton() {
        changeButton.click();
    }

    public void clickSaveButton() {
        saveButton.click();
    }
    public void clickSignInButton() {
        signInButton.click();
    }
    public void selectCountry(String countryName) {
        Select select = new Select(countrySelect);
        select.selectByVisibleText(countryName);
    }

    public void selectCurrency(String currencyName) {
        Select select = new Select(currencySelect);
        select.selectByVisibleText(currencyName);
    }

    public void setEmail(String email) {
        emailField.sendKeys(email);
    }

    public void setPassword(String password){
        passField.sendKeys(password);
    }

    public void clickLoginButton() {
        logginButton.click();
    }

    public void setSearch(String searchText) {
        searchField.sendKeys(searchText);
        searchField.submit();
    }
    public void clickCampaignProducts() {
        campaignProducts.click();
    }

    public void clickPopularProducts() {
        popularProducts.click();
    }

    public void clickLatestProducts() {
        latestProducts.click();
    }

    public void clickDropDowmRubberDuck() {
        dropDowmRubberDuck.click();
    }

    public void clickSubcategory() {
        subcategory.click();
    }

    public String getActiveTabName() {
        return activeTab.getText();
    }

    public void clickScrollUpButton() {
        scrollUpButtoun.click();
    }


}
