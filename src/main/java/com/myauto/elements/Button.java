package com.myauto.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by File on 2017/5/26.
 */
public class Button extends AbstractElement {
    private static WebElement button;

    public Button(By locator) {
        super(locator);
        button = findElement(locator);
    }

    public boolean click() {
        try {
            if (waitForClickable(button)) {
                button.click();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
