package com.myauto;

import com.myauto.util.Util;
import com.myauto.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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

    protected abstract boolean isLoaded();

    protected abstract void load();

    public boolean isPresent(By locator) {
        try {
            return driver.findElement(locator) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPresent(By parent, By locator) {
        try {
            if (parent != null)
                return driver.findElement(parent).findElement(locator) != null;
            else
                return isPresent(locator);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForEnabled(final WebElement element) {
        try {
            return wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver webDriver) {
                    return element.isEnabled();
                }
            });
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForDisappeared(By locator) {
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForDisappeared(By parent, By locator) {
        if (parent != null) {
            try {
                final WebElement element = driver.findElement(parent).findElement(locator);

                return wait.until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver webDriver) {
                        return !element.isDisplayed();
                    }
                });

            } catch (Exception e) {
                return false;
            }
        } else
            return waitForDisappeared(locator);
    }

    public boolean waitForAppeared(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForAppeared(By parent, final By locator) {
        if (parent != null) {
            waitForAppeared(parent);
            final WebElement parentElement = findElement(parent);

            return wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver webDriver) {
                    try {
                        WebElement element = parentElement.findElement(locator);

                        return element.isDisplayed();
                    } catch (Exception e) {
                        return false;
                    }
                }
            });
        } else
            return waitForAppeared(locator);
    }

    public boolean waitForPresence(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator)) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForVisible(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForVisible(WebElement element, long timeout) {
        try {
            return wait.withTimeout(timeout, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(element)) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForClickable(WebElement element) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element)) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement findElement(By locator) {
        if (waitForPresence(locator))
            return driver.findElement(locator);
        else
            return null;
    }

}
