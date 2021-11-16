package com.automationS.properties;

import com.automationS.ConfigurationException;

import static com.automationS.properties.PropertiesLoader.*;

public class PropertiesValidator {

    public static void validateConfigurations() throws Exception {
        if (runOnBrowser.equalsIgnoreCase("Chrome")) {
            if (chromeDriverPath.isEmpty()) {
                throw new ConfigurationException("ChromeDriverPath empty");
            }
        }
        if (runOnBrowser.equalsIgnoreCase("Firefox")) {
            if (firefoxDriverPath.isEmpty()) {
                throw new ConfigurationException("FirefoxDriverPath empty");
            }
        }
        if (runOnBrowser.equalsIgnoreCase("Edge")) {
            if (edgeDriverPath.isEmpty()) {
                throw new ConfigurationException("EdgeDriverPath empty");
            }
        }
        if (runOnBrowser.equalsIgnoreCase("IE")) {
            if (ieDriverPath.isEmpty()) {
                throw new ConfigurationException("IEDriverPath empty");
            }
        }
    }
}
