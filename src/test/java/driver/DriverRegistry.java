package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class DriverRegistry {
    private final static String nodeBinaryPath = System.getenv("NODE_BINARY_PATH");
    private final static String logFilePath = System.getenv("APPIUM_TESTS_LOG_PATH");
    private final static String appiumBinaryPath = System.getenv("APPIUM_BINARY_PATH");
    private final static String platform = System.getenv("APPIUM_TESTS_APP_PLATFORM");
    private final static String absolutePathToApp = System.getenv("APPIUM_TESTS_APP_PATH");
    private final static String host = System.getenv("APPIUM_TESTS_HOST");
    private final static int port = Integer.parseInt(System.getenv("APPIUM_TESTS_PORT"));

    private static DesiredCapabilities desiredCapabilities;
    private static AppiumDriverLocalService service;
    private static AppiumDriver driver;

    public static void startService() {
        getService().start();
    }

    public static void stopService() {
        getService().stop();
    }

    private static AppiumDriverLocalService getService() {
        if(service == null) {
            service = buildService();
        }
        return service;
    }

    public static AppiumDriver getDriver() {
        if(driver == null || driver.getSessionId() == null) {
            driver = createDriver(service);
        }
        return driver;
    }

    private static AppiumDriverLocalService buildService() {
        return new AppiumServiceBuilder()
                .withCapabilities(getDesiredCapabilities())
                .withIPAddress(host)
                .usingPort(port)
                .withLogFile(new File(logFilePath))
                .usingDriverExecutable(new File(nodeBinaryPath))
                .withAppiumJS(new File(appiumBinaryPath))
                .build();
    }

    public static String getPlatform() {
        return platform;
    }

    private static AppiumDriver createDriver(AppiumDriverLocalService service) {
        if(getPlatform().equals("android")) {
            return new AndroidDriver(service, getDesiredCapabilities());
        } else {
            return new IOSDriver(service, getDesiredCapabilities());
        }
    }

    private static DesiredCapabilities getDesiredCapabilities() {
        if(desiredCapabilities == null) {
            desiredCapabilities = new DesiredCapabilitiesReader(platform, absolutePathToApp).getDesiredCapabilities();
        }
        return desiredCapabilities;
    }
}
