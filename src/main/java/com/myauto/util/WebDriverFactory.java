package com.myauto.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by wenjia on 5/25/2017.
 */
public class WebDriverFactory {
    private static WebDriver driver;

    public static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-infobars");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().timeouts().implicitlyWait(Util.WAIT_FOR_ELEMENT_TIMEOUT, TimeUnit.SECONDS);

        driver = chromeDriver;

        return chromeDriver;
    }

    public static WebDriver getIEDriver() {
        WebDriver ieDriver = new InternetExplorerDriver();
        ieDriver.manage().timeouts().implicitlyWait(Util.WAIT_FOR_ELEMENT_TIMEOUT, TimeUnit.SECONDS);

        driver = ieDriver;

        return ieDriver;
    }

    public static WebDriver getFirefoxDriver() {
        ProfilesIni allProfiles = new ProfilesIni();
        FirefoxProfile profile = allProfiles.getProfile("WebDriver");
        profile.setPreference("foo.bar", 23);
        WebDriver ffDriver = new FirefoxDriver(profile);
        ffDriver.manage().timeouts().implicitlyWait(Util.WAIT_FOR_ELEMENT_TIMEOUT, TimeUnit.SECONDS);

        driver = ffDriver;

        return ffDriver;
    }

    public static WebDriver getCurrentDriver() {
        return driver;
    }
}
