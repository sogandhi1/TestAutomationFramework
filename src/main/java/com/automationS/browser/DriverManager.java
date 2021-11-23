package com.automationS.browser;

import com.automationS.properties.PropertiesLoader;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    public void loadDriver() {
        Browser browser = null;
        String path = "";
        if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("Chrome")) {
            browser = new Chrome();
            path = PropertiesLoader.chromeDriverPath;
        } else if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("Edge")) {
            browser = new Edge();
            path = PropertiesLoader.edgeDriverPath;
        } else if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("Firefox")) {
            browser = new Firefox();
            path = PropertiesLoader.firefoxDriverPath;
        }
        browser.setHeadless(PropertiesLoader.headless);
        browser.setDeleteCookies(PropertiesLoader.deleteCookies);
        browser.setMaximized(PropertiesLoader.maximizeMode);
        browser.setPageLoadTiemout(PropertiesLoader.pageLoadWaitTime);
        browser.setPreferences();
        WebDriver driver = browser.loadBrowser(path);
        setDriver(driver);
    }

    public void closeBrowser() {

        driver.get().close();
    }

    public void closeAllBrowser() {

        driver.get().quit();
    }
}
