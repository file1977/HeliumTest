package com.myauto.pages;

import com.myauto.AbstractComponent;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by wenjia on 5/25/2017.
 */
public class CommonPage extends AbstractComponent {
    private String url;

    public CommonPage() {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public CommonPage(String url) {
        this.url = url;

        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        if (url != null && !url.isEmpty()) {
            driver.get(url);
            load();
        }
    }

    public void quit() {
        driver.quit();
    }

    public String getUrl() {
        return url;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
