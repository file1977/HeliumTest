package com.fenby.step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by wenjia on 6/13/2017.
 */
public class RegisterSteps implements FenbyBDD {
    @When("^Create a new user with email \"(.*)\" and password \"(.*)\"$")
    public void createNewUser(String emailAddr, String password) {
        registerPage.setEmailAddr(emailAddr);
        registerPage.setPassword(password);
        registerPage.setConfirmdePassword(password);
        registerPage.getRegisterButton().click();

        homePage.load("userpage");
    }

    @When("^Set email as \"(.*)\", password as \"(.*)\" and confirmed password as \"(.*)\"$")
    public void setEmailPasswordConfirmedPassword(String emailAddr, String password, String confirmedPass) {
        registerPage.setEmailAddr(emailAddr);
        registerPage.setPassword(password);
        registerPage.setConfirmdePassword(confirmedPass);
    }

    @Then("^Register button is (.*)$")
    public void checkRegisterButton(String status) {
        switch (status.toLowerCase()) {
            case "enabled":
                Assert.assertTrue("Register button is not enabled", registerPage.getRegisterButton().isEnabled());
                break;
            case "disabled":
                Assert.assertFalse("Register button is not disabled", registerPage.getRegisterButton().isEnabled());
                break;
            default:
                Assert.fail("Not recognized status: " + status + ". Only enabled/disabled are allowed.");
        }
    }

    @Then("^Email box status is: (.*)$")
    public void checkEmailBoxStatus(String status) {
        if (status == null || (!status.equals("required_err") && !status.equals("pattern_err") && !status.equals("valid")))
            Assert.fail("Not recognized status: " + status + ". Only valid/required_err/pattern_err are allowed.");
        else
            Assert.assertEquals(status.toLowerCase(), registerPage.checkEmail());
    }

    @Then("^Password box status is: (.*)$")
    public void checkPasswordBoxStatus(String status) {
        if (status == null || (!status.equals("required_err") && !status.equals("length_err") && !status.equals("valid")))
            Assert.fail("Not recognized status: " + status + ". Only valid/required_err/length_err are allowed.");
        else
            Assert.assertEquals(status.toLowerCase(), registerPage.checkPassword());
    }

    @Then("^Confirmed password box status is: (.*)$")
    public void checkConfirmedPasswordBoxStatus(String status) {
        if (status == null || (!status.equals("required_err") && !status.equals("length_err") && !status.equals("valid")))
            Assert.fail("Not recognized status: " + status + ". Only valid/required_err/length_err are allowed.");
        else
            Assert.assertEquals(status.toLowerCase(), registerPage.checkConfirmedPassword());
    }

}
