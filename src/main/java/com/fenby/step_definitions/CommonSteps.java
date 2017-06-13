package com.fenby.step_definitions;


import com.myauto.pages.AbstractPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by wenjia on 6/1/2017.
 */
public class CommonSteps implements FenbyBDD {

    @Given("^(.*) page is open$")
    public void openLoginPage(String pageName) {
        AbstractPage page;

        switch (pageName.toLowerCase()) {
            case "register":
                page = registerPage;
                break;
            case "home":
                page = homePage;
                break;
            default:
                page = homePage;
        }

        page.openPage();
    }

    @Then("Close the browser")
    public void closeBrowser() {
        driver.quit();
    }

}
