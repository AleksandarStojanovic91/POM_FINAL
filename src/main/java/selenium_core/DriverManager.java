package selenium_core;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract void createWebDriver(String BROWSER_VERSION);

    public void quitWebDriver(){
        if(null != driver){
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getWebDriver(String BROWSER_VERSION){
        if(null == driver){
            createWebDriver(BROWSER_VERSION);
        }
        return
                driver;
    }

}