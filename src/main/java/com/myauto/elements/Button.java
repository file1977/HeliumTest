package com.myauto.elements;

import org.openqa.selenium.By;

/**
 * Created by File on 2017/5/26.
 */
public class Button extends AbstractElement {
    public Button(By locator) {
        super(locator);
    }

    public Button(By parent, By locator) {
        super(parent, locator);
    }

    public boolean click() {
        try {
            if (waitForClickable(mainElement)) {
                mainElement.click();
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
