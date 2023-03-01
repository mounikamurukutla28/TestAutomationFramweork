package com.automationByMounika.browser;

import com.automationByMounika.Properties.PropertiesLoader;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    public static WebDriver driver;
    public void getDriver() {

    }
    public WebDriver setDriver(WebDriver driver) {
this.driver = driver;
        return null;
    }
    public void loadDriver(){
        Browser browser=null;
        String path = "";
        if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("chrome")) {
            browser = new Chrome(); //runtime polymorphism
           path =  PropertiesLoader.chromeDriverPath;

        } else if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("edge")) {
            browser = new Edge();
            path =  PropertiesLoader.edgeDriverPath;

        } else if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("firefox")) {
            browser = new Firefox();
            path =  PropertiesLoader.firefoxDriverPath;
        }
        browser.setHeadLess(PropertiesLoader.headless);
        browser.setPageLoadTimeOut(PropertiesLoader.pageLoadWaitTime);
        browser.setRemote(PropertiesLoader.remoteRun);
        browser.setMaximized(PropertiesLoader.maximizedMode);
        browser.setPreferences();
       WebDriver driver =  browser.loadBrowser(path);
       setDriver(driver);

    }
    public void closeBrowser() {
        driver.close();

    }
    public void closeAllBrowsers() {
        driver.quit();
    }

}
