package com.fenby.pages;

import com.myauto.CommonConfig;

/**
 * Created by wenjia on 5/25/2017.
 */
public abstract class FenbyPageFactory extends CommonConfig {
    static protected RegisterPage registerPage = new RegisterPage();
    static protected HomePage homePage = new HomePage();
}
