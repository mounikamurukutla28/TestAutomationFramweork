package com.automationByMounika.Components;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class RepositoryLoader {
    static Properties properties;
    public void loadProperties() throws Exception {
        FileInputStream fis  = new FileInputStream(new File("C:\\Java\\SeleniumAutomationFramework\\src\\test\\Resources\\OR.Properties"));
        properties = new Properties();
        properties.load(fis);


    }
    public String getProperty(String name) {
        return properties.getProperty(name);

    }
    public static void main(String[] args) throws Exception {
RepositoryLoader loader = new RepositoryLoader();
loader.loadProperties();
System.out.println(loader.getProperty("LoginPage.tbx_Username"));
    }

}

