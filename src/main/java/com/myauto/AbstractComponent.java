package com.myauto;

import com.myauto.util.Util;
import com.myauto.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * Created by File on 2017/5/26.
 */
public abstract class AbstractComponent {
    protected static WebDriver driver;
    protected WebDriverWait wait;
    protected boolean isLoaded = false;


    public AbstractComponent() {
        driver = WebDriverFactory.getCurrentDriver();
        wait = new WebDriverWait(driver, Util.WAIT_FOR_ELEMENT_TIMEOUT);
    }

    protected boolean isLoaded() {
        return isLoaded;
    }

    ;

    protected void load() {
        isLoaded = true;
    }

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

    public boolean waitForDisappeared(WebElement element) {
        if (element == null)
            return true;

        try {
            return wait.until(ExpectedConditions.invisibilityOfAllElements(Collections.singletonList(element)));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForAppeared(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForAppeared(By locator, long timeout) {
        try {
            return wait.withTimeout(timeout, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locator)) != null;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean waitForAppeared(By parent, final By locator) {
        if (parent != null) {
            final WebElement parentElement = findGlobalElement(parent);
            if (parentElement == null)
                return false;

            try {
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
            } catch (TimeoutException e) {
                return false;
            }
        } else
            return waitForAppeared(locator);
    }

    protected boolean waitForAppeared(By parent, final By locator, long timeout) {
        if (parent != null) {
            final WebElement parentElement = findGlobalElement(parent);
            if (parentElement == null)
                return false;

            try {

                return wait.withTimeout(timeout, TimeUnit.SECONDS).until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver webDriver) {
                        try {
                            WebElement element = parentElement.findElement(locator);

                            return element.isDisplayed();
                        } catch (Exception e) {
                            return false;
                        }
                    }
                });
            } catch (TimeoutException e) {
                return false;
            }

        } else
            return waitForAppeared(locator, timeout);
    }

    public boolean waitForAppeared(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForAppeared(WebElement element, long timeout) {
        try {
            return wait.withTimeout(timeout, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(element)) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForPresence(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator)) != null;
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

    public WebElement findGlobalElement(By locator) {
        if (waitForPresence(locator))
            try {
                return driver.findElement(locator);
            } catch (Exception e) {
            }
        return null;
    }

}
