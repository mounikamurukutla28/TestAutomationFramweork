package com.automationByMounika.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Chrome extends Browser {
    ChromeOptions chromeOptions;
    @Override
    public void setPreferences() {
        chromeOptions = new ChromeOptions();
        if(isHeadLess()) { //it will run the testcase without opening the browser in background.
            chromeOptions.setHeadless(true);
        }
        if (isMaximized()) {
            chromeOptions.addArguments("start-maximized");
        }
        Map prefs = new HashMap();
        prefs.put("disable-popup-blocking", false);
    }

    @Override
    public WebDriver loadBrowser(String path) {
        WebDriver driver=null;
        System.setProperty("webdriver.chrome.driver", path);
        if (isRemote()) {
            try {
                driver = new RemoteWebDriver(new URL("http://loaclhost:4444/wd/hub"), chromeOptions); //this is how we use seleniumgrid.
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().pageLoadTimeout(getPageLoadTimeOut(), TimeUnit.MILLISECONDS);
            if (isDeleteCookies()) {
                driver.manage().deleteAllCookies();
            }
        }
        return driver;
    }
}
