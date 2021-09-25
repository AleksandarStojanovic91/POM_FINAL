package steps;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    DriverManager driverManager;

    public void init(String browser, String browserVersion, String waitTime){
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getWebDriver(browserVersion);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(waitTime), TimeUnit.SECONDS);

        System.out.println("THREAD_ID: "+Thread.currentThread().getId());
        System.out.println("DRIVER_ID: "+((ChromeDriver)driver).getSessionId());
    }

    public void quit(){
        driverManager.quitWebDriver();
    }

    public void takeScreenshot(String fileName) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("src/test/screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reportScreenshot(String screenshotName, String screenshotDesc){
        takeScreenshot(screenshotName);
        Path content = Paths.get("src/test/screenshots/"+screenshotName+".png");
        try(InputStream is = Files.newInputStream(content)){
            Allure.addAttachment(screenshotDesc,is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
