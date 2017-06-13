package com.myauto.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Created by File on 2017/5/26.
 */
public class TextBox extends CommonElement {
    public TextBox(By locator) {
        super(locator);
    }

    public TextBox(By parent, By locator) {
        super(parent, locator);
    }

    public boolean setText(final String text) {
        load();

        if (waitForEnabled(mainElement) && waitForAppeared(mainElement)) {
            mainElement.clear();
            mainElement.sendKeys(text);

            try {
                wait.until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver webDriver) {
                        return mainElement.getAttribute("value").equals(text);
                    }
                });
            } catch (TimeoutException e) {
                System.out.println("Set text timeout!");
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;

        } else {
            return false;
        }
    }

}
