package com.myauto.elements;

import com.myauto.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by File on 2017/5/26.
 */
public abstract class AbstractElement extends AbstractComponent {
    WebElement mainElement;
    By locator;
    By parent;

    protected AbstractElement(By locator) {
        this.locator=locator;
    }

    protected AbstractElement(By parent, By locator) {
        this.parent = parent;
        this.locator=locator;
    }

    @Override
    public boolean isLoaded() {
        return false;
    }

    @Override
    public void load() {
        if (parent != null)
            mainElement = findElement(parent).findElement(locator);
        else
            mainElement = findElement(locator);
    }

    public WebElement getMainElement() {
        return mainElement;
    }

    public boolean waitForDisappeared() {
        return super.waitForDisappeared(parent, locator);
    }

    public boolean waitForAppeared() {
        return super.waitForAppeared(parent, locator);
    }


    public boolean isDisplayed() {
        return mainElement.isDisplayed();
    }

    public boolean isEnabled() {
        return mainElement.isEnabled();
    }

    public boolean isSelected() {
        return mainElement.isSelected();
    }

    public boolean isPresent() {
        return isPresent(parent, locator);
    }

}
