package com.apps.flipkart.pageobjects;

import org.openqa.selenium.By;

public class LoginPage {

    public static final By USERNAME = By.xpath("//div[@class ='_2QfC02']//input[@type='text']");
    public static final By PASSWORD = By.xpath("//div[@class ='_2QfC02']//input[@type='password']");
    public static final By LOGIN_BUTTON = By.xpath("//div[@class='_1D1L_j']");
    public static final By ERROR_MESSAGE = By.cssSelector("._2YULOR");

}
