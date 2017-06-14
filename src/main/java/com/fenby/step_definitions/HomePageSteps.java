package com.fenby.step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by wenjia on 6/13/2017.
 */
public class HomePageSteps extends FenbyBDD {

    @When("^Click signup button$")
    public void clickSignup() {
        homePage.clickSignup();

        registerPage.load();
    }

    @When("^Login with email \"(.*)\" and password \"(.*)\"$")
    public void loginWithUserPassword(String emailAddr, String password) {
        homePage.login(emailAddr, password);
    }

    @When("^User logout$")
    public void userLogout() {
        homePage.logout();
    }

    @Then("^Current page is new user home page$")
    public void isNewUserHomePage() {
        Assert.assertTrue("Current page is not new user home page",
                homePage.isLoaded() && homePage.isUserHomePage() && homePage.checkUserImage("default_avatar.jpeg"));
    }

    @Then("^Current page is user home page$")
    public void isUserHomePage() {
        Assert.assertTrue("Current page is not user home page",
                homePage.isLoaded() && homePage.isUserHomePage());
    }

    @Then("^Current page is guest home page$")
    public void isGuestHomePage() {
        Assert.assertTrue("Current page is not guest home page",
                homePage.isLoaded() && homePage.isGuestHomePage());
    }



}
