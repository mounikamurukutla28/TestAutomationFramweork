package com.automationByMounika.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Edge extends Browser {
    EdgeOptions edgeOptions;
    @Override
    public void setPreferences() {
edgeOptions = new EdgeOptions();

        Map prefs = new HashMap();
        prefs.put("disable-popup-blocking", false);
    }

    @Override
    public WebDriver loadBrowser(String path) {
        WebDriver driver=null;
        System.setProperty("webdriver.edge.driver", path);
        if (isRemote()) {
            try {
                driver = new RemoteWebDriver(new URL("http://loaclhost:4444/wd/hub"), edgeOptions); //this is how we use seleniumgrid.
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            driver = new EdgeDriver(edgeOptions);
            if (isMaximized()) {
                driver.manage().window().maximize();
            }
            driver.manage().timeouts().pageLoadTimeout(getPageLoadTimeOut(), TimeUnit.MILLISECONDS);
            if (isDeleteCookies()) {
                driver.manage().deleteAllCookies();
            }
        }
        return driver;
    }
}
