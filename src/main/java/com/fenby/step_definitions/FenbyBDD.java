package com.fenby.step_definitions;

import com.fenby.pages.FenbyPageFactory;
import com.fenby.pages.HomePage;
import com.fenby.pages.RegisterPage;
import com.myauto.BDDSteps;
import com.myauto.util.WebDriverFactory;
import org.openqa.selenium.WebDriver;

/**
 * Created by wenjia on 6/1/2017.
 */
public interface FenbyBDD extends BDDSteps{
    WebDriver driver = WebDriverFactory.getChromeDriver();
    FenbyPageFactory pageFactory = new FenbyPageFactory();

    RegisterPage registerPage = pageFactory.createRegisterPage();
    HomePage homePage = pageFactory.createHomePage();

}
