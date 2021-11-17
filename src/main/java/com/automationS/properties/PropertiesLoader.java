package com.automationS.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties configProperties;

    public static String runOnBrowser;
    public static Boolean takeScreenshot;
    public static String chromeDriverPath;
    public static String ieDriverPath;
    public static String edgeDriverPath;
    public static String firefoxDriverPath;
    public static Boolean maximizeMode;
    public static Integer implicitWaitTime;
    public static Integer explicitWaitTime;
    public static Integer pageLoadWaitTime;
    public static boolean headless;
    public static boolean deleteCookies;
    public static boolean remoteRun;
    public static String appURL;

    public static void initializeProperties() throws Exception {
        if (configProperties == null) {
            configProperties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + "//src//test//resources//configs.properties"));
            configProperties.load(fileInputStream);
        }
        runOnBrowser = configProperties.getProperty("RunOnBrowser");
        takeScreenshot = Boolean.valueOf(configProperties.getProperty("TakeScreenshot"));
        chromeDriverPath = configProperties.getProperty("ChromeDriverPath");
        ieDriverPath = configProperties.getProperty("IEDriverPath");
        edgeDriverPath = configProperties.getProperty("EdgeDriverPath");
        firefoxDriverPath = configProperties.getProperty("FirefoxDriverPath");
        maximizeMode = Boolean.valueOf(configProperties.getProperty("MaximizeMode"));
        implicitWaitTime = Integer.valueOf(configProperties.getProperty("ImplicitWait"));
        explicitWaitTime = Integer.valueOf(configProperties.getProperty("ExplicitWait"));
        pageLoadWaitTime = Integer.valueOf(configProperties.getProperty("PageLoadWait"));
        headless = Boolean.valueOf(configProperties.getProperty("Headless"));
        deleteCookies = Boolean.valueOf(configProperties.getProperty("DeleteCookies"));
        remoteRun = Boolean.valueOf(configProperties.getProperty("RemoteRun"));
        appURL = configProperties.getProperty("AppURL");
    }

    public static void main(System[] args) throws Exception {
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
    }
}
