package GUIs.Base;


import Utilization.ConfigManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class DriverFactory {

    public static WebDriver createInstance() {
        ConfigManager.init("configs","src/test/resources/configs.properties");
        String browserType = ConfigManager.getInstance().getProperty("configs","Browser").toUpperCase();
        WebDriver driver;

        switch (browserType) {
            case "CHROME":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browserType);
        }

        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1024,768));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
