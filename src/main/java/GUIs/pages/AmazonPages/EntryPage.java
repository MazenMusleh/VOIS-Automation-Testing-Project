package GUIs.pages.AmazonPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntryPage {

    private WebDriver driver;

    //Locators
    private final By ContinueShoping_Btn = By.xpath("//button[@type='submit']");

    //Constructor
    public EntryPage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    @Step("Click 'Continue Shopping' button")
    public void clickContinueShooping() {
        driver.findElement(ContinueShoping_Btn).click();
    }
}
