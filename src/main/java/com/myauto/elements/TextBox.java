package com.myauto.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Created by File on 2017/5/26.
 */
public class TextBox extends AbstractElement {
    private WebElement textArea;

    public TextBox(By locator) {
        super(locator);
        textArea = findElement(locator);
    }

    public TextBox(WebElement parent, By locator) {
        super(locator);
        textArea = parent.findElement(locator);
    }

    public boolean setText(final String text) {
        if (waitForEnabled(textArea)) {
            textArea.clear();
            textArea.sendKeys(text);

            try {
                wait.until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver webDriver) {
                        return textArea.getAttribute("value").equals(text);
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
