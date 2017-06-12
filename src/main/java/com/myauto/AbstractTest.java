package com.myauto;

import com.myauto.util.WebDriverFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

/**
 * Created by wenjia on 5/25/2017.
 */
public abstract class AbstractTest {
    protected static WebDriver driver;

    public AbstractTest() {
        driver = WebDriverFactory.getChromeDriver();
    }

    @BeforeClass
    public static void init() {
    }

    @AfterClass
    public static void clean() {
        driver.quit();
    }
}
