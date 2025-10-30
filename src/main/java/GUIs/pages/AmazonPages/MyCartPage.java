package GUIs.pages.AmazonPages;

import Utilization.AssertionUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyCartPage {

    private WebDriver driver;
    private AssertionUtils assertionUtils;

    //Locators
    private final By AddedItemName_Header = By.xpath("//h4[@class='a-text-normal']");


    //Constructor
    public MyCartPage(WebDriver driver) {
        this.driver = driver;
        assertionUtils = new AssertionUtils();
    }

    //Methods
    @Step("Get item name text from cart")
    public String getCartItemName() {
        return driver.findElement(AddedItemName_Header).getText().trim();
    }

    @Step("Assert cart item name equals : {expectedName}")
    public void assertCartItemNameEquals(String expectedName) {
        String actual = getCartItemName();
        assertionUtils.assertTrueHard(expectedName.contains(actual.replace("…", "").trim()), "Cart item name mismatch.");
    }
}
