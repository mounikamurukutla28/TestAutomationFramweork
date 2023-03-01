package com.automationByMounika.Properties;

import javax.naming.ConfigurationException;

import static com.automationByMounika.Properties.PropertiesLoader.*;

public class PropertiesValidator {
    public static void validateConfigurations() throws Exception{
        if (runOnBrowser.equalsIgnoreCase("chrome")) {
            if(chromeDriverPath.isEmpty()) {
                throw new ConfigurationException("Chromedriver path  empty");
            }  if (runOnBrowser.equalsIgnoreCase("firefox")) {
                if (firefoxDriverPath.isEmpty()){
                    throw new ConfigurationException("firefoxdriver path empty");
                }
                if (edgeDriverPath.isEmpty()){
                    if (edgeDriverPath.isEmpty()){
                        throw new ConfigurationException("edgedriver path empty");

                    } else if (runOnBrowser.equalsIgnoreCase("ie")) {
                        if (ieDriverPath.isEmpty()) {
                            throw new ConfigurationException("iedriver path empty");
                        }
                    }
                }
            }
        }
    }

}
