package com.automationS.components;

import com.automationS.properties.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class ElementFindBy {

    WebDriver driver;
    WebDriverWait wait;

    public ElementFindBy(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, PropertiesLoader.explicitWaitTime);    //WebDriverWait is the class that implements wait interface
    }

    public By findBy(String element) throws Exception {
        By by;
        RepositoryLoader loader = new RepositoryLoader();
        loader.loadProperties();
        String elementValue = loader.getProperty(element);
        String findBy = elementValue.split(":")[0];
        String findByValue = elementValue.split(":")[1];
        if (findBy.equalsIgnoreCase("xpath")) {
            by = By.xpath(findByValue);
        }
        else if (findBy.equalsIgnoreCase("id")) {
            by = By.id(findByValue);
        }
        else if (findBy.equalsIgnoreCase("name")) {
            by = By.name(findByValue);
        }
        else if (findBy.equalsIgnoreCase("class")) {
            by = By.className(findByValue);
        }
        else if (findBy.equalsIgnoreCase("css")) {
            by = By.cssSelector(findByValue);
        }
        else if (findBy.equalsIgnoreCase("linkText")) {
            by = By.linkText(findByValue);
        }
        else if (findBy.equalsIgnoreCase("PartialLinkText")) {
            by = By.partialLinkText(findByValue);
        }
        else {
            throw new Exception("Invalid Locator Type/Value in [" +element + "]. Plesae check value in OR file");
        }
        return by;
    }

    public WebElement findElementBy(String element) throws Exception {
        By by = findBy(element);
        return waitUntillElementVisible(by);
    }
    public List<WebElement> findElementsBy(String element) throws Exception {
        By by = findBy(element);
        return waitUntillAllElementsVisible(by);
    }

    public WebElement waitUntillElementVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public WebElement waitUntillElementFound(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public WebElement waitUntillElementClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public boolean waitUntillElementDisappears(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public boolean waitUntillElementDisappears(By by) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public List<WebElement> waitUntillAllElementsVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
}