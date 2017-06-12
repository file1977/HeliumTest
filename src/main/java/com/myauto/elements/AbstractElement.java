package com.myauto.elements;

import com.myauto.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by File on 2017/5/26.
 */
public abstract class AbstractElement extends AbstractComponent {
    By locator;
    WebElement root;

    protected AbstractElement(By locator) {
        this.locator=locator;
    }

    protected AbstractElement(WebElement parent, By locator) {
        this.root = parent;
        this.locator=locator;
    }

}
