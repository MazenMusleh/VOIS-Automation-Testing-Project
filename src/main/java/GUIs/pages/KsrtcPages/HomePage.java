package GUIs.pages.KsrtcPages;

import Utilization.JavaScriptUtils;
import Utilization.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    //Locators
    private By FromCity_Dropdown = By.id("fromCity_chosen");
    private By FromCity_SearchInput = By.xpath("//div[@id='fromCity_chosen']//div[contains(@class,'chosen-search')]//input");
    private By FromCity_FirstOption = By.xpath("(//div[@id='fromCity_chosen']//ul[contains(@class,'chosen-results')]//li[contains(@class,'active-result')])[1]");
    private By ToCity_Dropdown = By.id("toCity_chosen");
    private By ToCity_SearchInput = By.xpath("//div[@id='toCity_chosen']//div[contains(@class,'chosen-search')]//input");
    private By ToCity_FirstOption = By.xpath("(//div[@id='toCity_chosen']//ul[contains(@class,'chosen-results')]//li[contains(@class,'active-result')])[1]");
    private By DepartDate_Input = By.id("departDate");
    private By Today_Date = By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//td[contains(@class,'ui-datepicker-today')]//a");
    private By SearchBuses_Btn = By.xpath("//div[@id='submitSearch' and contains(@class,'search--btn')]");



    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    //Methods
    @Step("Click on From City dropdown")
    public void clickFromCityDropdown() {
        waitUtils.waitForClickable(FromCity_Dropdown, 10);
        driver.findElement(FromCity_Dropdown).click();
    }

    @Step("Enter '{cityName}' into From City search input")
    public void enterFromCitySearch(String cityName) {
        waitUtils.waitForVisibility(FromCity_SearchInput, 10);
        driver.findElement(FromCity_SearchInput).clear();
        driver.findElement(FromCity_SearchInput).sendKeys(cityName);
    }

    @Step("Select first city from From City results")
    public void selectFirstFromCityResult() {
        waitUtils.waitForVisibility(FromCity_FirstOption, 10);
        driver.findElement(FromCity_FirstOption).click();
    }

    @Step("Click on To City dropdown")
    public void clickToCityDropdown() {
        waitUtils.waitForClickable(ToCity_Dropdown, 10);
        driver.findElement(ToCity_Dropdown).click();
    }

    @Step("Enter '{cityName}' into To City search input")
    public void enterToCitySearch(String cityName) {
        waitUtils.waitForVisibility(ToCity_SearchInput, 10);
        driver.findElement(ToCity_SearchInput).clear();
        driver.findElement(ToCity_SearchInput).sendKeys(cityName);
    }

    @Step("Select first city from To City results")
    public void selectFirstToCityResult() {
        waitUtils.waitForVisibility(ToCity_FirstOption, 10);
        driver.findElement(ToCity_FirstOption).click();
    }

    @Step("Click on Departure Date input to open calendar")
    public void clickDepartDateInput() {
        waitUtils.waitForClickable(DepartDate_Input, 10);
        driver.findElement(DepartDate_Input).click();
    }

    @Step("Select today's date from calendar")
    public void selectTodayDate() {
        waitUtils.waitForVisibility(Today_Date, 10);
        driver.findElement(Today_Date).click();
    }

    @Step("Click on 'Search Buses' button")
    public void clickSearchBusesButton() {
        waitUtils.waitForClickable(SearchBuses_Btn, 10);
        driver.findElement(SearchBuses_Btn).click();
    }


}
