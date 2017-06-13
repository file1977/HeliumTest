package com.myauto.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Created by File on 2017/5/26.
 */
public class PasswordBox extends AbstractElement {
    public PasswordBox(By locator) {
        super(locator);
    }

    public PasswordBox(By parent, By locator) {
        super(parent, locator);
    }

    public boolean setText(final String text) {
        if (waitForEnabled(mainElement)) {
            mainElement.clear();
            mainElement.sendKeys(text);

            try {
                wait.until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver webDriver) {
                        return mainElement.getAttribute("value").length() == text.length();
                    }
                });
            } catch (TimeoutException e) {
                System.out.println("Set password timeout!");
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
