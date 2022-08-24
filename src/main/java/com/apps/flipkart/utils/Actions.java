package com.apps.flipkart.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.TimeZone;

public class Actions {
    private static final Logger LOGGER = LoggerFactory.getLogger(Actions.class);

    public Actions() {
    }

    public static byte[] getByteScreenshot()
    {
        try{
            File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(src);
            return fileContent;
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static String getSystemDateMMDDYYYHHMMSS() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static void sleep(int sleepInMilliSeconds) {
        try {
            LOGGER.info("Waiting for {} Seconds", sleepInMilliSeconds);
            Thread.sleep(sleepInMilliSeconds);
        } catch (Exception var2) {
            LOGGER.error("Sleep is interrupted");
        }
    }

    public static void openUrl(String url) {
        DriverManager.getDriver().get(url);
    }

    public static void enterText(By by, String value) {
        waitForElementClickable(by).sendKeys(value);
    }

    public static String getText(By by) {
        return waitUntilElementIsPresent(by).getText();
    }

    public static void click(By by) {
        waitForElementClickable(by).click();
    }

    public static WebElement waitForElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
                    Duration.ofSeconds(Long.parseLong(ConfigManager.getConfigProperty("explicit.wait.time"))));
            return (WebElement)wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static WebElement waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
                    Duration.ofSeconds(Long.parseLong(ConfigManager.getConfigProperty("explicit.wait.time"))));
            return (WebElement)wait.until(ExpectedConditions.visibilityOf(DriverManager.getDriver().findElement(by)));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void waitUntilElementIsNotVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
                Duration.ofSeconds(Long.parseLong(ConfigManager.getConfigProperty("explicit.wait.time"))));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        sleep(2);
    }

    public static WebElement waitUntilElementIsPresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
                Duration.ofSeconds(Long.parseLong(ConfigManager.getConfigProperty("explicit.wait.time"))));
        return (WebElement)wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static boolean isWebElementExists(By by) {
        try {
            if (DriverManager.getDriver().findElement(by).isDisplayed()) {
                LOGGER.info("WebElement [{}] found", by.toString());
                return true;
            } else {
                return false;
            }
        } catch (Exception var2) {
            return false;
        }
    }


}
