import com.automationS.browser.DriverManager;
import com.automationS.components.ElementFindBy;
import com.automationS.properties.PropertiesLoader;
import com.automationS.properties.PropertiesValidator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SampleTest {

    @Test
    public void loadBrowserTest() throws Exception {
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
        DriverManager driverManager = new DriverManager();
        driverManager.loadDriver();
        driverManager.driver.get("https://www.google.com/");
        Thread.sleep(3000);
        ElementFindBy findBy = new ElementFindBy(driverManager.driver);
        WebElement element = findBy.findElementBy("GooglePage.tbx_Search");
        element.sendKeys("Testing Framework");
        Thread.sleep(3000);
        driverManager.closeAllBrowser();
    }

}
