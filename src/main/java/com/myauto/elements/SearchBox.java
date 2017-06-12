package com.myauto.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by File on 2017/5/26.
 */
public class SearchBox extends AbstractElement {
    private TextBox inputSearch;
    private WebElement buttonSearch;

    public SearchBox(By locator) {
        super(locator);
        inputSearch = new TextBox(findElement(locator), By.tagName("input"));
        buttonSearch = findElement(locator).findElement(By.id("button-search"));
    }

    public SearchBox(By rootLocator, By inputLoctor, By buttonLocator) {
        super(rootLocator);
        inputSearch = new TextBox(inputLoctor);
        buttonSearch = findElement(buttonLocator);
    }

    public void search(String content) {
        inputSearch.setText(content);
        buttonSearch.click();
    }

}
