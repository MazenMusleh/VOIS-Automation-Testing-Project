package GUIs.pages.AmazonPages;

import Utilization.ActionsUtils;
import Utilization.AssertionUtils;
import Utilization.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftSideBarPage {

    private WebDriver driver;
    private AssertionUtils assertionUtils;
    private WaitUtils waitUtils;
    private ActionsUtils actionsUtils;

    //Locators
    private final By SeeMore_Btn = By.xpath("(//a[contains(@class,'a-link-normal') and contains(@href,'javascript:void(0)')])[1]");
    private final By Automotive_Category_RadioBtn = By.xpath("//div[@data-testid='filter-departments-15690151']//i[@class='a-icon a-icon-radio']");
    private final By SliderTrack = By.xpath("(//span[@id='percentOff-label']//following::div[contains(@class,'RangeSlider-module__inputWrapper_')])[1]");
    private final By SliderHandle = By.xpath("(//span[@id='percentOff-label']//following::div[contains(@class,'RangeSlider-module__control_')])[1]");


    //Constructor
    public LeftSideBarPage(WebDriver driver) {
        this.driver = driver;
        assertionUtils = new AssertionUtils();
        waitUtils = new WaitUtils(driver);
        actionsUtils = new ActionsUtils(driver);
    }

    //Methods
    @Step("Click See More button")
    public void clickSeeMore() {
        waitUtils.waitForClickable(SeeMore_Btn, 10);
        driver.findElement(SeeMore_Btn).click();
    }

    @Step("Select category radio button")
    public void clickCategoryRadioButton() {
        waitUtils.waitForClickable(Automotive_Category_RadioBtn, 10);
        driver.findElement(Automotive_Category_RadioBtn).click();
    }

    @Step("Move slider to target value")
    public void moveSliderTo(int min, int max, int targetValue) {
        waitUtils.waitForVisibility(SliderTrack, 10);

        int trackWidth = driver.findElement(SliderTrack).getSize().width;
        int xOffset = (int) ((trackWidth * 0.15 * (targetValue - min)) / (max - min));

        actionsUtils.clickAndHoldByOffset(SliderHandle, xOffset, 0);
        actionsUtils.release();
    }

}
