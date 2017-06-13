package com.fenby;

import com.fenby.pages.FenbyPageFactory;
import com.fenby.pages.HomePage;
import com.fenby.pages.RegisterPage;
import com.myauto.AbstractTest;


/**
 * Created by wenjia on 5/25/2017.
 */
public abstract class FenbyTest extends AbstractTest {
    protected RegisterPage registerPage;
    protected HomePage homePage;

    public FenbyTest() {
        FenbyPageFactory pageFactory = new FenbyPageFactory();

        registerPage = pageFactory.createRegisterPage();
        homePage = pageFactory.createHomePage();
    }
}
