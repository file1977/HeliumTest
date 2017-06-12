package com.myauto;

import com.myauto.util.Util;
import com.myauto.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by File on 2017/5/26.
 */
public abstract class AbstractComponent {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public AbstractComponent() {
        driver = WebDriverFactory.getCurrentDriver();
        wait = new WebDriverWait(driver, Util.WAIT_FOR_ELEMENT_TIMEOUT);
    }

    protected boolean waitForEnabled(final WebElement element) {
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver webDriver) {
                    return element.isEnabled();
                }
            });
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    protected boolean waitForPresence(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    protected boolean waitForVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    protected boolean waitForClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    protected WebElement findElement(By locator) {
        if (waitForPresence(locator))
            return driver.findElement(locator);
        else
            return null;
    }

}
