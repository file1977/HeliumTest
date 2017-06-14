package com.myauto;

import com.myauto.util.WebDriverFactory;
import org.openqa.selenium.WebDriver;

/**
 * Created by wenjia on 5/25/2017.
 */
public abstract class CommonConfig {
    static WebDriver driver = WebDriverFactory.getChromeDriver();
}
