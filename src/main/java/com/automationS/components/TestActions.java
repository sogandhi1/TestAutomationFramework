package com.automationS.components;

import com.automationS.browser.DriverManager;
import com.automationS.properties.PropertiesLoader;
import com.automationS.properties.PropertiesValidator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestActions {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public DriverManager driverManager;
    public BaseActions pageActions;

    @BeforeSuite
    public void setUpConfiguration() throws Exception {
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
        driverManager = new DriverManager();
    }

    @BeforeMethod (alwaysRun = true)
    public void setUpBrowser() {
        driverManager.loadDriver();
        driver.set(driverManager.getDriver());
        //driver = driverManager.getDriver();
        pageActions = new BaseActions(driver.get());
        pageActions.launchURL(PropertiesLoader.appURL);
    }
    
    @AfterMethod (alwaysRun = true)
    public void terrDownBrowser() {
        driverManager.closeBrowser();
    }

    @AfterSuite
    public void tearDownObject() {
        PropertiesLoader.configProperties = null;
    }
    
}
