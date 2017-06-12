package com.alo7.step_definitions;


import com.myauto.pages.AbstractPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by wenjia on 6/1/2017.
 */
public class CommonSteps implements Alo7BDD {

    @Given("^(.*) page is open$")
    public void openLoginPage(String pageName) {
        AbstractPage page;

        switch (pageName.toLowerCase()) {
            case "login":
                page = loginPage;
                break;
            case "classhome":
                page = classHomePage;
                break;
            case "homeworks":
                page = homeworksPage;
                break;
            default:
                page = loginPage;
        }

        page.openPage();
    }

    @Then("Close the browser")
    public void closeBrowser() {
        driver.quit();
    }

}
