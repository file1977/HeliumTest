package com.fenby.pages;

import com.myauto.elements.Button;
import com.myauto.elements.CommonElement;
import com.myauto.elements.PasswordBox;
import com.myauto.elements.TextBox;
import com.myauto.pages.CommonPage;
import org.openqa.selenium.By;


/**
 * Created by wenjia on 6/13/2017.
 */
public class RegisterPage extends CommonPage {
    private CommonElement registerForm = new CommonElement(By.name("register_valid_form"));
    private TextBox emailBox = new TextBox(By.xpath("//input[@id='id_email']"));
    private PasswordBox passwordBox = new PasswordBox(By.xpath("//input[@id='id_password1']"));
    private PasswordBox confirmedBox = new PasswordBox(By.xpath("//input[@id='id_password2']"));
    private Button registerButton = new Button(By.xpath("//button[@type='submit']"));

    private CommonElement msgErrRequired = new CommonElement(registerForm.getLocator(), By.xpath(".//li[contains(@ng-show,'email.$error.required')]"));
    private CommonElement msgErrPattern = new CommonElement(registerForm.getLocator(), By.xpath(".//li[contains(@ng-show,'email.$error.pattern')]"));
    private CommonElement msgValid = new CommonElement(registerForm.getLocator(), By.xpath(".//li[contains(@ng-show,'email.$valid')]"));


    public RegisterPage() {
        super("http://www.fenby.com/register/");
    }

    @Override
    public void load() {
        emailBox.waitForAppeared();
//            registerButton.load();
//            passwordBox.load();
        confirmedBox.waitForAppeared();
        isLoaded = true;
    }

    public TextBox getEmailBox() {
        return emailBox;
    }

    public PasswordBox getPasswordBox() {
        return passwordBox;
    }

    public PasswordBox getConfirmedBox() {
        return confirmedBox;
    }

    public Button getRegisterButton() {
        return registerButton;
    }

    public boolean setEmailAddr(String mailAddr) {
        emailBox.setText(mailAddr);

        if (msgErrPattern.waitForAppeared(2))
            return false;

        if (msgValid.waitForAppeared())
            return true;

        return false;
    }

    public void setPassword(String password) {
        passwordBox.setText(password);
    }

    public void setConfirmdePassword(String password) {
        confirmedBox.setText(password);
    }

    public String checkEmail() {
        if (msgErrRequired.isDisplayed())
            return "required_err";

        if (msgErrPattern.waitForAppeared(2))
            return "pattern_err";

        if (msgValid.isDisplayed())
            return "valid";

        return null;
    }

    public String checkPassword() {
        CommonElement msgErrRequired = new CommonElement(registerForm.getLocator(), By.xpath(".//li[contains(@ng-show,'password1.$error.required')]"));
        CommonElement msgErrLength = new CommonElement(registerForm.getLocator(), By.xpath(".//li[contains(@ng-show,'password1.$error.minlength')]"));

        if (msgErrRequired.isDisplayed())
            return "required_err";

        if (msgErrLength.isDisplayed())
            return "length_err";

        return "valid";
    }

    public String checkConfirmedPassword() {
        CommonElement msgErrRequired = new CommonElement(registerForm.getLocator(), By.xpath(".//li[contains(@ng-show,'password2.$error.required')]"));
        CommonElement msgErrLength = new CommonElement(registerForm.getLocator(), By.xpath(".//li[contains(@ng-show,'password2.$error.minlength')]"));

        if (msgErrRequired.isDisplayed())
            return "required_err";

        if (msgErrLength.isDisplayed())
            return "length_err";

        return "valid";
    }
}
