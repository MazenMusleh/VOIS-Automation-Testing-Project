package GUIs.pages.AmazonPages;

import Utilization.AssertionUtils;
import Utilization.JavaScriptUtils;
import Utilization.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopBarPage {

    private WebDriver driver;
    private WaitUtils waitUtils;
    private AssertionUtils assertionUtils;
    private JavaScriptUtils javaScriptUtils;

    //Locators
    private final By SearchBar_TxtField = By.id("twotabsearchtextbox");
    private final By Search_Btn = By.id("nav-search-submit-button");
    private final By Cart_Count = By.id("nav-cart-count");
    private final By Cart_Btn = By.id("nav-cart");
    private final By TodayDeals_Btn = By.xpath("//a[@data-csa-c-content-id='nav_cs_gb']");
    private final By Popup_Dismiss = By.xpath("//span[@class='a-button-inner']//input[@data-action-type='DISMISS']");

    //Constructor
    public TopBarPage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        assertionUtils = new AssertionUtils();
        javaScriptUtils = new JavaScriptUtils(driver);
    }

    //Methods
    @Step("Search for item: {item}")
    public void searchForItem(String item) {
        waitUtils.waitForVisibility(SearchBar_TxtField, 10);
        driver.findElement(SearchBar_TxtField).clear();
        driver.findElement(SearchBar_TxtField).sendKeys(item);
    }

    @Step("Click 'Search' button")
    public void clickSearch() {
        waitUtils.waitForVisibility(Search_Btn, 10);
        driver.findElement(Search_Btn).click();
    }

    @Step("Get cart count from top bar")
    public String getCartCount() {
        waitUtils.waitForVisibility(Cart_Count, 10);
        javaScriptUtils.scrollToElement(Cart_Count);
        return driver.findElement(Cart_Count).getText().trim();
    }

    @Step("Assert cart count equals 1")
    public void assertCartCountEqualsOne() {
        String actual = getCartCount();
        assertionUtils.assertEqualsHard(actual, "1", "Cart count not equals 1");
    }

    @Step("Click on the Cart button to navigate to cart page")
    public void clickCartButton() {
        javaScriptUtils.scrollToTop();
        waitUtils.waitForClickable(Cart_Btn, 10);
        driver.findElement(Cart_Btn).click();
    }

    @Step("Click 'Dismiss' button inside popup")
    public void clickPopupDismiss() {
        waitUtils.waitForVisibility(Popup_Dismiss, 10);
        driver.findElement(Popup_Dismiss).click();
    }

    @Step("Click 'Today's Deals' button")
    public void clickTodayDeals() {
        waitUtils.waitForVisibility(TodayDeals_Btn, 10);
        driver.findElement(TodayDeals_Btn).click();
    }
}
