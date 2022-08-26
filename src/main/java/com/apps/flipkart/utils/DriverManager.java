package com.apps.flipkart.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;

public class DriverManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverManager.class);
    private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return (WebDriver)WEB_DRIVER_THREAD_LOCAL.get();
    }

    private static void setDriver(WebDriver driver) {
        WEB_DRIVER_THREAD_LOCAL.set(driver);
    }

    public static void quitDriver() {
        WebDriver driver = (WebDriver)WEB_DRIVER_THREAD_LOCAL.get();
        if (driver != null) {
            driver.quit();
        }
    }

    public static void initDriver(String browser) {
        try {
            LOGGER.info("Browser : {}", browser);
            WebDriver driver;
            if (browser.equalsIgnoreCase("firefox")) {
                String driverExe = Paths.get("drivers", ConfigManager.getConfigProperty("firefox.driver.binary.path")).toString();
                System.setProperty("webdriver.gecko.driver", driverExe);
                driver = new FirefoxDriver();
            } else {
                String driverExe = Paths.get("drivers", ConfigManager.getConfigProperty("chrome.driver.binary.path")).toString();
                System.setProperty("webdriver.chrome.driver", driverExe);
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            setDriver(driver);
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
            throw new RuntimeException(exception);
        }
    }



}
