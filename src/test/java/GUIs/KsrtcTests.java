package GUIs;

import GUIs.Base.DriverManager;
import GUIs.pages.KsrtcPages.BookingPage;
import GUIs.pages.KsrtcPages.ChoosingPaymentPage;
import GUIs.pages.KsrtcPages.HomePage;
import GUIs.pages.KsrtcPages.PaymentPage;
import Utilization.ConfigManager;
import Utilization.FakerUtils;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


@Feature("Ksrtc Tests")
public class KsrtcTests {

    private WebDriver driver;
    private HomePage homePage;
    private BookingPage bookingPage;
    private ChoosingPaymentPage choosingPaymentPage;
    private PaymentPage paymentPage;

    @BeforeMethod
    public void setUp() {
        ConfigManager.init("configs","src/test/resources/configs.properties");
        ConfigManager.init("testData","src/test/resources/testData.properties");
        driver = DriverManager.getDriver();
        driver.navigate().to(ConfigManager.getInstance().getProperty("configs","KsrtcBaseURL"));
        homePage = new HomePage(driver);
        bookingPage = new BookingPage(driver);
        choosingPaymentPage = new ChoosingPaymentPage(driver);
        paymentPage = new PaymentPage(driver);
    }

    @Test(description = "Verify KSRTC booking process from search to payment entry")
    public void testScenario1() {
        homePage.clickFromCityDropdown();
        homePage.enterFromCitySearch(ConfigManager.getInstance().getProperty("testData","From_City"));
        homePage.selectFirstFromCityResult();
        homePage.clickToCityDropdown();
        homePage.enterToCitySearch(ConfigManager.getInstance().getProperty("testData","To_City"));
        homePage.selectFirstToCityResult();
        homePage.clickDepartDateInput();
        homePage.selectTodayDate();
        homePage.clickSearchBusesButton();
        bookingPage.clickSelectSeatsButton();
        bookingPage.selectRandomAvailableSeat();
        bookingPage.clickBordingPoint();
        bookingPage.clickDroppingPointDDL();
        bookingPage.selectDroppingPoint();
        bookingPage.clickProvidePassengerDetailsButton();
        bookingPage.enterMobileNumber(ConfigManager.getInstance().getProperty("testData","Indian_PhoneNumber"));
        bookingPage.enterRandomEmail(FakerUtils.getRandomEmail());
        bookingPage.clickProceedAsGuest();
        bookingPage.enterPassengerName(FakerUtils.getRandomUsername());
        bookingPage.selectRandomPassengerGender();
        bookingPage.enterPassengerAge(FakerUtils.getRandomNumber(18,50));
        bookingPage.clickProceedToCheckout();
        choosingPaymentPage.selectPaymentOption();
        choosingPaymentPage.clickProceedToPay();
        choosingPaymentPage.clickAgreeTermsButton();
        choosingPaymentPage.clickProceedToPay();
        paymentPage.enterCardNumber(FakerUtils.getRandomCardNumber());
        paymentPage.enterCardExpiryDate(FakerUtils.getRandomCardExpiry());
        paymentPage.enterCardHolderName(FakerUtils.getRandomCardHolderName());
        paymentPage.enterCardCVV(FakerUtils.getRandomCardCVV());
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
