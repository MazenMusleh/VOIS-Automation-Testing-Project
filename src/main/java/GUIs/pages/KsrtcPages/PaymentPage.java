package GUIs.pages.KsrtcPages;

import Utilization.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    //Locators
    private By CardNumber_TextField = By.xpath("//input[@name='card_number']");
    private By ExpiryDate_TextField = By.xpath("//input[@name='card_exp_date']");
    private By CardHolderName_TextField = By.xpath("//input[@name='card_holder_name']");
    private By CVV_TextField = By.xpath("//input[@name='card_cvv']");

    //Constructor
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    //Methods
    @Step("Enter card number")
    public void enterCardNumber(String CardNumber) {
        waitUtils.waitForVisibility(CardNumber_TextField, 10);
        driver.findElement(CardNumber_TextField).clear();
        driver.findElement(CardNumber_TextField).sendKeys(CardNumber);
    }

    @Step("Enter card expiry date")
    public void enterCardExpiryDate(String ExpiryDate) {
        waitUtils.waitForVisibility(ExpiryDate_TextField, 10);
        driver.findElement(ExpiryDate_TextField).clear();
        driver.findElement(ExpiryDate_TextField).sendKeys(ExpiryDate);
    }

    @Step("Enter card holder name")
    public void enterCardHolderName(String CardHolderName) {
        waitUtils.waitForVisibility(CardHolderName_TextField, 10);
        driver.findElement(CardHolderName_TextField).clear();
        driver.findElement(CardHolderName_TextField).sendKeys(CardHolderName);
    }

    @Step("Enter card CVV")
    public void enterCardCVV(String CVV) {
        waitUtils.waitForVisibility(CVV_TextField, 10);
        driver.findElement(CVV_TextField).clear();
        driver.findElement(CVV_TextField).sendKeys(CVV);
    }
}
