package com.myauto.elements;

import com.myauto.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by File on 2017/5/26.
 */
public class CommonElement extends AbstractComponent {
    WebElement mainElement;
    By locator;
    By parent;

    public CommonElement(By locator) {
        this.locator = locator;
    }

    public CommonElement(By parent, By locator) {
        this.parent = parent;
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }

    public By getParent() {
        return parent;
    }

    @Override
    public void load() {
        WebElement parentElement;
        if (parent != null) {
            parentElement = findGlobalElement(parent);
            if (parentElement != null)
                mainElement = parentElement.findElement(locator);
            else
                mainElement = null;
        }
        else
            mainElement = findGlobalElement(locator);

        isLoaded = true;
    }

    public WebElement findElement(By locator) {
        load();
        try {
            return mainElement.findElement(locator);
        } catch (Exception e) {}
        return null;
    }

    public WebElement getMainElement() {
        load();
        return mainElement;
    }

    public boolean waitForDisappeared() {
        return super.waitForDisappeared(parent, locator);
    }

    public boolean waitForAppeared() {
        return super.waitForAppeared(parent, locator);
    }

    public boolean waitForAppeared(long timeout) {
        return super.waitForAppeared(parent, locator, timeout);
    }

    public boolean isDisplayed() {
        load();
        return mainElement.isDisplayed();
    }

    public boolean isEnabled() {
        load();
        return mainElement.isEnabled();
    }

    public boolean isSelected() {
        load();
        return mainElement.isSelected();
    }

    public boolean isPresent() {
        return isPresent(parent, locator);
    }

}
