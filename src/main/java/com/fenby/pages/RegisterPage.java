package com.fenby.pages;

import com.myauto.elements.Button;
import com.myauto.elements.PasswordBox;
import com.myauto.elements.TextBox;
import com.myauto.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by wenjia on 6/13/2017.
 */
public class RegisterPage extends AbstractPage {
    @FindBy(name = "register_valid_form")
    private WebElement registerForm;

    private TextBox emailBox = new TextBox(By.xpath("//input[@id='id_email']"));
    private PasswordBox passwordBox = new PasswordBox(By.xpath("//input[@id='id_password1']"));
    private PasswordBox confirmedBox = new PasswordBox(By.xpath("//input[@id='id_password2']"));
    private Button registerButton = new Button(By.xpath("//button[@type='submit']"));


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

    public void setEmailAddr(String mailAddr) {
        emailBox.setText(mailAddr);
    }

    public void setPassword(String password) {
        passwordBox.setText(password);
    }

    public void setConfirmdePassword(String password) {
        confirmedBox.setText(password);
    }

    public String checkEmail() {
        WebElement msgErrRequired = registerForm.findElement(By.xpath(".//li[contains(@ng-show,'email.$error.required')]"));
        WebElement msgErrPattern = registerForm.findElement(By.xpath(".//li[contains(@ng-show,'email.$error.pattern')]"));
        WebElement msgValid = registerForm.findElement(By.xpath(".//li[contains(@ng-show,'email.$valid')]"));

        if (msgErrRequired.isDisplayed())
            return "required_err";

        if (waitForAppeared(msgErrPattern, 2))
            return "pattern_err";

        if (msgValid.isDisplayed())
            return "valid";

        return null;
    }

    public String checkPassword() {
        WebElement msgErrRequired = registerForm.findElement(By.xpath(".//li[contains(@ng-show,'password1.$error.required')]"));
        WebElement msgErrLength = registerForm.findElement(By.xpath(".//li[contains(@ng-show,'password1.$error.minlength')]"));

        if (msgErrRequired.isDisplayed())
            return "required_err";

        if (msgErrLength.isDisplayed())
            return "length_err";

        return "valid";
    }

    public String checkConfirmedPassword() {
        WebElement msgErrRequired = registerForm.findElement(By.xpath(".//li[contains(@ng-show,'password2.$error.required')]"));
        WebElement msgErrLength = registerForm.findElement(By.xpath(".//li[contains(@ng-show,'password2.$error.minlength')]"));

        if (msgErrRequired.isDisplayed())
            return "required_err";

        if (msgErrLength.isDisplayed())
            return "length_err";

        return "valid";
    }
}
