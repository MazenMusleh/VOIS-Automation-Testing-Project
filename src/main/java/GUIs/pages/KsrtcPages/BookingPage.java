package GUIs.pages.KsrtcPages;

import Utilization.FakerUtils;
import Utilization.JavaScriptUtils;
import Utilization.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class BookingPage {

    private WebDriver driver;
    private WaitUtils waitUtils;
    private JavaScriptUtils javaScriptUtils;

    //Locators
    private By SelectSeats_Btn = By.xpath("//div[@class='selectbutton' and contains(text(),'Select Seats')]");
    private By Available_Seats = By.xpath("//div[contains(@class,'seatlook') and not(contains(@style,'not-allowed'))]");
    private By BordingPoint_Option = By.xpath("//div[contains(@class,'pick--val')]");
    private By DroppingPoint_DDL = By.xpath("(//div[contains(@class,'point-inp')])[2]");
    private By DropOption_Option = By.xpath("//div[contains(@class,'drop--val')]");
    private By ProvidePassengerDetails_Btn = By.xpath("//div[contains(@class,'btnPassDetails')]");
    private By Mobile_TextField = By.xpath("//input[@name='mobileNo']");
    private By Email_TextField = By.xpath("//input[@name='email']");
    private By ProceedAsGuest_Btn = By.xpath("//div[contains(@class,'navswitchbtn')]");
    private By PassengerName_TextField = By.xpath("//input[@name='paxName[0]']");
    private By PassengerAge_TextField = By.xpath("//input[@name='paxAge[0]']");
    private By PassengerGender_DDL = By.xpath("//input[@name='paxGender[0]']");
    private By PassengerGender_Options = By.xpath("//div[contains(@class,'pass--inp--drop')]//div[contains(@class,'ddn')]/div");
    private By ProceedToCheckout_Btn = By.xpath("//div[contains(@class,'navswitchbtn') and normalize-space(text())='Proceed to Checkout']");


    //Constructor
    public BookingPage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        javaScriptUtils = new JavaScriptUtils(driver);
    }

    //Methods
    @Step("Click on 'Select Seats' button")
    public void clickSelectSeatsButton() {
        waitUtils.waitForClickable(SelectSeats_Btn, 10);
        javaScriptUtils.scrollToElement(SelectSeats_Btn);
        driver.findElement(SelectSeats_Btn).click();
    }

    @Step("Select a random available seat")
    public void selectRandomAvailableSeat() {
        waitUtils.waitForVisibility(Available_Seats, 10);
        List<WebElement> seats = driver.findElements(Available_Seats);
        if (seats.isEmpty()) {
            throw new RuntimeException("No available seats found!");
        }
        Random random = new Random();
        javaScriptUtils.scrollToElement(Available_Seats);
        seats.get(random.nextInt(seats.size())).click();
    }

    @Step("Select Bording Point")
    public void clickBordingPoint() {
        waitUtils.waitForClickable(BordingPoint_Option, 10);
        javaScriptUtils.scrollToElement(BordingPoint_Option);
        driver.findElement(BordingPoint_Option).click();
    }

    @Step("Click 'Select Dropping Point' DDL")
    public void clickDroppingPointDDL() {
        waitUtils.waitForClickable(DroppingPoint_DDL, 10);
        javaScriptUtils.scrollToElement(DroppingPoint_DDL);
        driver.findElement(DroppingPoint_DDL).click();
    }

    @Step("Select Dropping Point")
    public void selectDroppingPoint() {
        waitUtils.waitForClickable(DropOption_Option, 10);
        javaScriptUtils.scrollToElement(DropOption_Option);
        driver.findElement(DropOption_Option).click();
    }

    @Step("Click 'Provide Passenger Details' button")
    public void clickProvidePassengerDetailsButton() {
        waitUtils.waitForClickable(ProvidePassengerDetails_Btn, 10);
        javaScriptUtils.scrollToElement(ProvidePassengerDetails_Btn);
        driver.findElement(ProvidePassengerDetails_Btn).click();
    }

    @Step("Enter mobile number")
    public void enterMobileNumber(String MobileNumber) {
        waitUtils.waitForVisibility(Mobile_TextField, 10);
        driver.findElement(Mobile_TextField).clear();
        driver.findElement(Mobile_TextField).sendKeys(MobileNumber);
    }

    @Step("Enter random email")
    public void enterRandomEmail(String Email) {
        waitUtils.waitForVisibility(Email_TextField, 10);
        driver.findElement(Email_TextField).clear();
        driver.findElement(Email_TextField).sendKeys(Email);
    }

    @Step("Click 'Proceed to passenger detail as guest user'")
    public void clickProceedAsGuest() {
        waitUtils.waitForClickable(ProceedAsGuest_Btn, 10);
        javaScriptUtils.scrollToElement(ProceedAsGuest_Btn);
        driver.findElement(ProceedAsGuest_Btn).click();
    }

    @Step("Enter passenger name")
    public void enterPassengerName(String PassengerName) {
        waitUtils.waitForVisibility(PassengerName_TextField, 10);
        driver.findElement(PassengerName_TextField).clear();
        driver.findElement(PassengerName_TextField).sendKeys(PassengerName);
    }

    @Step("Enter passenger age")
    public void enterPassengerAge(int PassengerAge) {
        waitUtils.waitForVisibility(PassengerAge_TextField, 10);
        driver.findElement(PassengerAge_TextField).clear();
        driver.findElement(PassengerAge_TextField).sendKeys(String.valueOf(PassengerAge));
    }

    @Step("Select random passenger gender")
    public void selectRandomPassengerGender() {
        waitUtils.waitForClickable(PassengerGender_DDL, 10);
        driver.findElement(PassengerGender_DDL).click();
        waitUtils.waitForVisibility(PassengerGender_Options, 10);
        List<WebElement> genderOptions = driver.findElements(PassengerGender_Options);
        WebElement randomGender = genderOptions.get(new Random().nextInt(genderOptions.size()));
        javaScriptUtils.scrollToElement(PassengerGender_Options);
        randomGender.click();
    }

    @Step("Click on 'Proceed to Checkout' button")
    public void clickProceedToCheckout() {
        waitUtils.waitForClickable(ProceedToCheckout_Btn, 10);
        javaScriptUtils.scrollToElement(ProceedToCheckout_Btn);
        driver.findElement(ProceedToCheckout_Btn).click();
    }

}
