package com.fenby.pages;

import com.myauto.elements.Button;
import com.myauto.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by wenjia on 6/13/2017.
 */
public class HomePage extends AbstractPage {
    @FindBy(id = "header")
    WebElement headerSection;

    @FindBy(className = "navbar-right")
    WebElement navbarRight;

    Button signup = new Button(By.xpath("//button[contains(@ng-click, 'signup')]"));
    Button login = new Button(By.xpath("//button[contains(@ng-click, 'login()')]"));
    Button profile = new Button(By.xpath("//li[contains(@class, 'nav-profile')]/a[contains(@class,'dropdown-toggle')]"));
    Button logout = new Button(By.xpath("//a[@ng-click='logout()']"));


    public HomePage() {
        super("http://www.fenby.com/");
    }

    @Override
    public boolean isLoaded() {
        waitForVisible(navbarRight);
        return getCurrentUrl().equals(getUrl());
    }

    @Override
    public void load() {
        waitForVisible(navbarRight);

        if (isGuestHomePage()) {
            signup.load();
            login.load();
        } else if (isUserHomePage()) {
            profile.load();
            logout.load();
        }
    }

    public void logout() {
        profile.click();
        logout.click();

        profile.waitForDisappeared();
        signup.waitForAppeared();

        load();
    }

    public void clickSignup() {
        signup.click();
    }

    public void clickLogin() {
        login.click();
    }

    public boolean checkUserImage(String imageFileName) {
        return profile.getMainElement().findElement(By.tagName("img")).getAttribute("src").contains(imageFileName);
    }

    public boolean isUserHomePage() {
        return profile.isPresent();
    }

    public boolean isGuestHomePage() {
        return signup.isPresent();
    }
}
