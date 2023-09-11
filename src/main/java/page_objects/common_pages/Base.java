package page_objects.common_pages;

import base.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Base {

    protected AppiumDriver driver;

    public Base() {
        this.driver = DriverManager.getAppiumDriver();
    }

    public void click(By by){
        driver.findElement(by).click();
    }

    public boolean isElementPresent(By by) {
        WebElement element;
        try {
            element = driver.findElement(by);
        } catch (NoSuchElementException exception) {
        }
        return false;
    }

    public int getTotalMatchedElements(By by) {
        return driver.findElements(by).size();
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }
}