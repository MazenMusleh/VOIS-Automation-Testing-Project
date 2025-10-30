package GUIs;

import GUIs.Base.DriverManager;
import GUIs.pages.AmazonPages.*;
import Utilization.CSVUtils;
import Utilization.ConfigManager;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

@Feature("Amazon Tests")
public class AmazonTests {
    private WebDriver driver;
    private EntryPage entryPage;
    private TopBarPage topBarPage;
    private ItemsPage itemsPage;
    private MyCartPage myCartPage;
    private LeftSideBarPage leftSideBarPage;


    @BeforeMethod
    public void setUp() {
        ConfigManager.init("configs","src/test/resources/configs.properties");
        ConfigManager.init("testData","src/test/resources/testData.properties");
        driver = DriverManager.getDriver();
        driver.navigate().to(ConfigManager.getInstance().getProperty("configs","AmazonBaseURL"));
        entryPage = new EntryPage(driver);
        topBarPage = new TopBarPage(driver);
        itemsPage = new ItemsPage(driver);
        myCartPage = new MyCartPage(driver);
        leftSideBarPage = new LeftSideBarPage(driver);
    }

    @Test(description = "Verify that a user can search for an item, select the first result, add it to the cart, and confirm it appears in the cart.")
    public void testScenario1() {
        String itemToSearch = ConfigManager.getInstance().getProperty("testData","ItemToSearch");
        entryPage.clickContinueShooping();
        topBarPage.searchForItem(itemToSearch);
        topBarPage.clickSearch();
        String ItemToAdd_Name = itemsPage.getFirstItemName();
        itemsPage.selectFirstItem();
        itemsPage.assertAddedItemsNumberEqualsOne();
        topBarPage.assertCartCountEqualsOne();
        topBarPage.clickCartButton();
        myCartPage.assertCartItemNameEquals(ItemToAdd_Name);
    }

    @DataProvider(name = "csvSearchData")
    public Object[][] getData() throws IOException {
        return CSVUtils.readCSV("src/test/resources/search_items.csv");
    }

    @Test(description = "Verify that a user can search for items from CSV, add to cart, and verify it appears.", dataProvider = "csvSearchData")
    public void testScenario1_DataDriven(String itemToSearch) {
        entryPage.clickContinueShooping();
        topBarPage.searchForItem(itemToSearch);
        topBarPage.clickSearch();
        String ItemToAdd_Name = itemsPage.getFirstItemName_DataDriven();
        itemsPage.selectFirstItem_DataDriven();
        itemsPage.assertAddedItemsNumberEqualsOne();
        topBarPage.assertCartCountEqualsOne();
        topBarPage.clickCartButton();
        myCartPage.assertCartItemNameEquals(ItemToAdd_Name);
    }



    @Test(description = "Verify that a user can navigate to Today's Deals, apply category and discount filters, add a deal item to the cart, and confirm the cart count updates correctly.")
    public void testScenario2() {
        entryPage.clickContinueShooping();
        topBarPage.clickPopupDismiss();
        topBarPage.clickTodayDeals();
        leftSideBarPage.clickSeeMore();
        leftSideBarPage.clickCategoryRadioButton();
        leftSideBarPage.moveSliderTo(0,100,11);
        itemsPage.clickFirstPlusButton();
        try {
            itemsPage.clickRightBarAddToCartButton();
        } catch (Exception e) {
            System.out.println("No Right Bar Add To Cart Button");
        }
        topBarPage.assertCartCountEqualsOne();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
