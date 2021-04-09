package com.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitsSwitcher {
    private WebDriver driver;

    public WaitsSwitcher(WebDriver driver) {
        this.driver = driver;
    }

    public void setImplicitWaits(int seconds){
        if (seconds > 0) {
            driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        }
    }

    public <V> V setExplicitWait(int seconds, Function<? super WebDriver, V> condition){
        WebDriverWait driverWait = new WebDriverWait(driver, seconds);
        V wait = driverWait.until(condition);
        return wait;
    }
}
