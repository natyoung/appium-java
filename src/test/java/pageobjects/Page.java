package pageobjects;

import driver.DriverRegistry;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class Page {
    private static final long WEB_DRIVER_WAIT_TIMEOUT_IN_SECONDS = 30L;
    private static AppiumDriver driver;

    Page() {
        driver = DriverRegistry.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    void waitForElement(WebElement element) {
        final WebDriverWait wait = new WebDriverWait(driver, WEB_DRIVER_WAIT_TIMEOUT_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
