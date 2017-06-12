package com.alo7.step_definitions;

import com.alo7.pages.FenbyPageFactory;
import com.alo7.pages.ClassHomePage;
import com.alo7.pages.HomeworksPage;
import com.alo7.pages.LoginPage;
import com.myauto.BDDSteps;
import com.myauto.util.WebDriverFactory;
import org.openqa.selenium.WebDriver;

/**
 * Created by wenjia on 6/1/2017.
 */
public interface Alo7BDD extends BDDSteps{
    static WebDriver driver = WebDriverFactory.getChromeDriver();
    FenbyPageFactory pageFactory = new FenbyPageFactory();
    static LoginPage loginPage = pageFactory.createLoginPage();
    static ClassHomePage classHomePage = pageFactory.createClassHomePage();
    static HomeworksPage homeworksPage = pageFactory.createHomeworksPage();
}
