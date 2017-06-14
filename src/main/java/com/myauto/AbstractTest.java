package com.myauto;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Created by wenjia on 5/25/2017.
 */
public abstract class AbstractTest extends CommonConfig{
    @BeforeClass
    public static void init() {
    }

    @AfterClass
    public static void clean() {
        driver.quit();
    }
}
