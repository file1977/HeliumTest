package com.myauto.pages;

import com.myauto.AbstractComponent;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by wenjia on 5/25/2017.
 */
public abstract class AbstractPage extends AbstractComponent {
    private String url;

    protected AbstractPage() {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    protected AbstractPage(String url) {
        this.url = url;

        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(url);
        load();
    }

    public String getUrl() {
        return url;
    }

    protected abstract boolean isLoaded();

    protected abstract void load();
}
