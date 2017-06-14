package com.fenby.pages;

import com.myauto.elements.Button;
import com.myauto.elements.CommonElement;
import com.myauto.elements.PasswordBox;
import com.myauto.elements.TextBox;
import com.myauto.pages.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by wenjia on 6/13/2017.
 */
public class HomePage extends CommonPage {
    @FindBy(id = "header")
    WebElement headerSection;

    private CommonElement navbarRight = new CommonElement(By.className("navbar-right"));;
    private CommonElement loginDialog = new CommonElement(By.className("modal-dialog"));
    private TextBox dialogEmailBox = new TextBox(loginDialog.getLocator(), By.xpath(".//input[@ng-model='user.email']"));
    private PasswordBox dialogPasswordBox = new PasswordBox(loginDialog.getLocator(), By.xpath(".//input[@ng-model='user.password']"));
    private Button dialogLogin = new Button(loginDialog.getLocator(), By.xpath(".//button[contains(@ng-click, 'login()')]"));
    private Button signup = new Button(navbarRight.getLocator(), By.xpath(".//button[contains(@ng-click, 'signup')]"));
    private Button login = new Button(navbarRight.getLocator(), By.xpath(".//button[contains(@ng-click, 'login()')]"));
    private Button profile = new Button(navbarRight.getLocator(), By.xpath(".//li[contains(@class, 'nav-profile')]/a[contains(@class,'dropdown-toggle')]"));
    private Button logout = new Button(navbarRight.getLocator(), By.xpath(".//a[@ng-click='logout()']"));


    public HomePage() {
        super("http://www.fenby.com/");
    }

    @Override
    public boolean isLoaded() {
        return isLoaded && getCurrentUrl().equals(getUrl());
    }

    @Override
    public void load() {
        navbarRight.waitForAppeared();

        isLoaded = true;
    }

    public void load(String pageType) {
        load();
        switch (pageType.toLowerCase()) {
            case "userpage":
                profile.waitForAppeared();
                break;
            case "guestpage":
                signup.waitForAppeared();
                break;
        }
    }

    public void logout() {
        profile.click();
        logout.click();

        profile.waitForDisappeared();
        signup.waitForAppeared();
        login.waitForAppeared();

        load("guestpage");
    }

    public void login(String emailAddr, String password) {
        login.click();
        loginDialog.waitForAppeared();
        dialogEmailBox.setText(emailAddr);
        dialogPasswordBox.setText(password);
        dialogLogin.click();
        dialogLogin.waitForDisappeared();
        load("userpage");
    }

    public void clickSignup() {
        signup.click();
    }

    public void clickLogin() {
        login.click();
    }

    public boolean checkUserImage(String imageFileName) {
        WebElement userImage = profile.getMainElement().findElement(By.tagName("img"));

        if (userImage != null) {
            String imageSrc = userImage.getAttribute("src");
            if (imageSrc != null)
                return imageSrc.contains(imageFileName);
        }

        return false;
    }

    public boolean isUserHomePage() {
        return profile.isPresent();
    }

    public boolean isGuestHomePage() {
        return signup.isPresent();
    }
}
