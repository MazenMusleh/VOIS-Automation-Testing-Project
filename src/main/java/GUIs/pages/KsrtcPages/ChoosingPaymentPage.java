package GUIs.pages.KsrtcPages;

import Utilization.JavaScriptUtils;
import Utilization.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChoosingPaymentPage {

    private WebDriver driver;
    private WaitUtils waitUtils;
    private JavaScriptUtils javaScriptUtils;

    //Locators
    private By PaymentOption_Easebuzz = By.xpath("//div[contains(@class,'pay-opts-item')]");
    private By AgreeTerms_Btn = By.xpath("//div[text()='AGREE']");
    private By ProceedToPay_Btn = By.xpath("//div[contains(@class,'navswitchbtn') and normalize-space(text())='PROCEED TO PAY']");

    //Constructor
    public ChoosingPaymentPage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        javaScriptUtils = new JavaScriptUtils(driver);
    }

    //Methods
    @Step("Select the Easebuzz payment option")
    public void selectPaymentOption() {
        waitUtils.waitForClickable(PaymentOption_Easebuzz, 10);
        javaScriptUtils.scrollToElement(PaymentOption_Easebuzz);
        driver.findElement(PaymentOption_Easebuzz).click();
    }

    @Step("Accept terms and conditions")
    public void clickAgreeTermsButton() {
        waitUtils.waitForClickable(AgreeTerms_Btn, 10);
        javaScriptUtils.scrollToElement(AgreeTerms_Btn);
        driver.findElement(AgreeTerms_Btn).click();
    }

    @Step("Click on 'PROCEED TO PAY' button")
    public void clickProceedToPay() {
        waitUtils.waitForClickable(ProceedToPay_Btn, 10);
        javaScriptUtils.scrollToElement(ProceedToPay_Btn);
        driver.findElement(ProceedToPay_Btn).click();
    }
}
