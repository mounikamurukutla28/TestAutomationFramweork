package com.automationByMounika.Properties;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesLoader {

    static Properties configProperties;
    public static String runOnBrowser;
    public static Boolean takeScreenShot;
    public static String chromeDriverPath;

    public static String firefoxDriverPath;
    public static String ieDriverPath;
    public static String edgeDriverPath;
    public static Boolean maximizedMode;
    public static Integer implicitWait;
    public static Integer explicitWait;
    public static Integer  pageLoadWaitTime;
    public static Boolean headless;
    public static Boolean deleteCookies;
    public static Boolean remoteRun;

    public static void initializeProperties() throws Exception {
        if (configProperties==null) {
            configProperties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(new File("C:\\Java\\SeleniumAutomationFramework\\src\\test\\Resources\\Config.properties"));
            configProperties.load(fileInputStream);
        }
        runOnBrowser =  configProperties.getProperty("runOnBrowser");
        takeScreenShot = Boolean.valueOf(configProperties.getProperty("takeScreenShot"));
        chromeDriverPath = configProperties.getProperty("chromeDriverPath");
        firefoxDriverPath = configProperties.getProperty("firefoxDriverPath");
        ieDriverPath =  configProperties.getProperty("ieDriverPath");
        edgeDriverPath =  configProperties.getProperty("edgeDriverPath");
        maximizedMode = Boolean.valueOf(configProperties.getProperty("maximizedMode"));
        implicitWait = Integer.valueOf(configProperties.getProperty("implicitWait"));
        explicitWait = Integer.valueOf(configProperties.getProperty("explicitWait"));
        pageLoadWaitTime = Integer.valueOf(configProperties.getProperty("pageLoadWaitTime"));
        headless = Boolean.valueOf(configProperties.getProperty("headless"));
        deleteCookies = Boolean.valueOf(configProperties.getProperty("deleteCookies"));
        remoteRun = Boolean.valueOf(configProperties.getProperty("remoteRun"));


    }
    public static void main(String[] args) throws Exception {
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
    }
}
