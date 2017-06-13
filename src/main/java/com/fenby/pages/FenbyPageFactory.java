package com.fenby.pages;

/**
 * Created by wenjia on 5/25/2017.
 */
public class FenbyPageFactory {
    public RegisterPage createRegisterPage() {
        return new RegisterPage();
    }

    public HomePage createHomePage() {
        return new HomePage();
    }
}
