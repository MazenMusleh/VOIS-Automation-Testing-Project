package Utilization;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ScreenshotsUtils {

    static WebDriver driver;

    public ScreenshotsUtils(WebDriver driver) {
        this.driver = driver;
    }


    public byte[] captureScreenshot(String testName) {
        if (driver == null) {
            System.out.println("WebDriver is null, cannot capture screenshot.");
            return new byte[0];
        }

        try {
            // Format filename with test name + timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = testName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";
            String screenshotsDir = System.getProperty("user.dir") + File.separator + "screenshots";
            File screenshotsFolder = new File(screenshotsDir);

            if (!screenshotsFolder.exists()) {
                screenshotsFolder.mkdirs();
            }

            // Take screenshot and save to file
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(screenshotsFolder, screenshotName);
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved at: " + dest.getAbsolutePath());

            // Return bytes for reporting (e.g., Allure attachment)
            return Files.readAllBytes(dest.toPath());

        } catch (IOException e) {
            System.out.println("Error while saving screenshot: " + e.getMessage());
            return new byte[0];
        }
    }
}
