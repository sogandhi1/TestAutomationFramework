package com.automationS.components;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;

public class BaseActions {
    WebDriver driver;

    public BaseActions(WebDriver driver) {
        this.driver = driver;
    }

    public void clickIt(String elementRef) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            elementBy.click();
        } catch (Exception e) {
        }
    }

    public void typeInTo(String elementRef, String text) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            elementBy.click();
            elementBy.clear();
            elementBy.sendKeys(text);
        } catch (Exception e) {
        }
    }

    public String getTextFromElement(String elementRef) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            return elementBy.getText();
        } catch (Exception e) {
            return null;
        }
    }

    public String getAttributeForElement(String elementRef, String attributeType) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            return elementBy.getAttribute(attributeType);
        } catch (Exception e) {
            return null;
        }
    }

    public void selectValueFromDropdown(String elementRef, String selectBy, String option) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            Select dropDown = new Select(elementBy);
            if (selectBy.equalsIgnoreCase("visibleText")) {
                dropDown.selectByVisibleText(option);
            } else if (selectBy.equalsIgnoreCase("value")) {
                dropDown.selectByValue(option);
            } else if (selectBy.equalsIgnoreCase("index")) {
                dropDown.selectByIndex(Integer.parseInt(option));
            }
        } catch (Exception e) {
        }
    }

    public void switchToSecondWindow(String elementRef) {
        try {
            driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
        } catch (Exception e) {
        }
    }

    public void switchToLastWindow(String elementRef) {
        try {
            ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
            int lastWindow = windows.size() - 1;
            driver.switchTo().window(windows.get(lastWindow));
        } catch (Exception e) {
        }
    }

    public void hitEnter(String elementRef) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            elementBy.sendKeys(Keys.ENTER);
        } catch (Exception e) {
        }
    }

    public void hitTab(String elementRef) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            elementBy.sendKeys(Keys.TAB);
        } catch (Exception e) {
        }
    }

    public void launchURL(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
        }
    }

    public void refreshPage() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            new Actions(driver).sendKeys(Keys.F5);
        }
    }

    public void switchToAlertAndAccept() {
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
        }
    }

    public void switchToAlertAndDismiss() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {
        }
    }

    public void switchToFrame(String elementRef) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            driver.switchTo().frame(elementBy);
        } catch (Exception e) {
        }
    }

    public void switchToOriginalPageFromIFrame(String elementRef) {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
        }
    }

    public void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollInToView(true)", element);
        } catch (Exception e) {
        }
    }

    public void scrollToTop() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        } catch (Exception e) {
        }
    }

    public void scrollToBottom() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        } catch (Exception e) {
        }
    }

    public void hoverOnTo(String elementRef) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            Actions a = new Actions(driver);
            a.moveToElement(elementBy).build().perform();
        } catch (Exception e) {
        }
    }

    public void dragAndDrop(String elementRef1, String elementRef2) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy1 = findObj.findElementBy(elementRef1);
            WebElement elementBy2 = findObj.findElementBy(elementRef2);
            Actions a = new Actions(driver);
            a.dragAndDrop(elementBy1,elementBy2).build().perform();
        } catch (Exception e) {
        }
    }

    public void rightClickOnElement(String elementRef) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            Actions a = new Actions(driver);
            a.contextClick(elementBy).build().perform();
        } catch (Exception e) {
        }
    }

    public void doubleClickOnElement(String elementRef) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            Actions a = new Actions(driver);
            a.doubleClick(elementBy).build().perform();
        } catch (Exception e) {
        }
    }

    public boolean isEnabled(String elementRef) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            return elementBy.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDisplayed(String elementRef) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            return elementBy.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}


