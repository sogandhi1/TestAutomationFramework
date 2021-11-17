package com.automationS.components;

import com.automationS.browser.DriverManager;
import com.automationS.properties.PropertiesLoader;
import com.automationS.properties.PropertiesValidator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestActions {

    WebDriver driver;
    DriverManager driverManager;
    public BaseActions pageActions;

    @BeforeSuite
    public void setUpConfiguration() throws Exception {
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
        driverManager = new DriverManager();
    }

    @BeforeMethod
    public void setUpBrowser() {
        driverManager.loadDriver();
        driver = driverManager.getDriver();
        pageActions = new BaseActions(driver);
        pageActions.launchURL(PropertiesLoader.appURL);
    }
    
    @AfterMethod
    public void terrDownBrowser() {
        driverManager.closeBrowser();
    }

    @AfterSuite
    public void tearDownObject() {
        PropertiesLoader.configProperties = null;
    }
    
}
