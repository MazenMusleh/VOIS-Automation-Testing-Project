package GUIs.pages.AmazonPages;

import Utilization.AssertionUtils;

import Utilization.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemsPage {

    private WebDriver driver;
    private AssertionUtils assertionUtils;
    private WaitUtils waitUtils;

    //Locators
    private final By FirstAddToCart_Btn = By.id("a-autoid-2-announce");
    private final By FirstAddToCart_Btn_DataDriven = By.id("a-autoid-1-announce");
    private final By AddedItems_Count = By.xpath("//span[@data-a-selector='value']");
    private final By FirstItem_Name = By.xpath("(//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal'])[1]");
    private final By FirstItem_Name_DataDriven = By.xpath("(//a[contains(@class,'a-link-normal') and contains(@class,'s-line-clamp-2')])[1]");
    private final By FirstPlus_Btn = By.xpath("//button[@data-testid='add-to-cart-button']");
    private final By RightBarAddToCart_Btn = By.xpath("//button[@data-testid='add-to-cart-variational-modal-button']");


    //Constructor
    public ItemsPage(WebDriver driver) {
        this.driver = driver;
        assertionUtils = new AssertionUtils();
        waitUtils = new WaitUtils(driver);
    }

    //Methods
    @Step("Select the first item")
    public void selectFirstItem() {
        waitUtils.waitForClickable(FirstAddToCart_Btn, 10);
        driver.findElement(FirstAddToCart_Btn).click();
    }

    @Step("Select the first item")
    public void selectFirstItem_DataDriven() {
        waitUtils.waitForClickable(FirstAddToCart_Btn_DataDriven, 10);
        driver.findElement(FirstAddToCart_Btn_DataDriven).click();
    }

    @Step("Get name of the first item")
    public String getFirstItemName() {
        waitUtils.waitForVisibility(FirstItem_Name, 10);
        return driver.findElement(FirstItem_Name).getText().trim();
    }

    @Step("Get name of the first item")
    public String getFirstItemName_DataDriven() {
        waitUtils.waitForVisibility(FirstItem_Name_DataDriven, 10);
        return driver.findElement(FirstItem_Name_DataDriven).getText().trim();
    }


    @Step("Get number of items added")
    public String getAddedItemsNumber() {
        waitUtils.waitForVisibility(AddedItems_Count, 10);
        return driver.findElement(AddedItems_Count).getText().trim();
    }

    @Step("Assert items number equals to 1")
    public void assertAddedItemsNumberEqualsOne() {
        String actual = getAddedItemsNumber();
        assertionUtils.assertEqualsHard(actual, "1", "Record number not equals 1");
    }

    @Step("Click First '+' Button")
    public void clickFirstPlusButton() {
        waitUtils.waitForClickable(FirstPlus_Btn, 10);
        driver.findElement(FirstPlus_Btn).click();
    }

    @Step("Click on 'Right Bar Add To Cart' button inside modal")
    public void clickRightBarAddToCartButton() {
        waitUtils.waitForClickable(RightBarAddToCart_Btn, 10);
        driver.findElement(RightBarAddToCart_Btn).click();
    }


}
