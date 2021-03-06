package com.myauto.elements;

import org.openqa.selenium.By;

/**
 * Created by File on 2017/5/26.
 */
public class SearchBox extends CommonElement {
    private TextBox inputSearch;
    private Button buttonSearch;

    public SearchBox(By locator) {
        super(locator);
        inputSearch = new TextBox(locator, By.tagName("input"));
        buttonSearch = new Button(locator, By.id("button-search"));
    }

    public SearchBox(By searchBox, By input, By button) {
        super(searchBox);
        inputSearch = new TextBox(searchBox, input);
        buttonSearch = new Button(searchBox, button);
    }

    @Override
    public void load() {
        inputSearch.load();
        buttonSearch.load();
        isLoaded = true;
    }

    public void search(String content) {
        load();

        inputSearch.setText(content);
        buttonSearch.click();
    }

}
