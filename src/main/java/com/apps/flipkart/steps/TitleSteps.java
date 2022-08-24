package com.apps.flipkart.steps;

import com.apps.flipkart.utils.DriverManager;

import static org.assertj.core.api.Assertions.assertThat;

public class TitleSteps {

    String url_flipkart = "https://www.flipkart.com/";

    public void verifyTitle(String expectedTitle) {
        String actualTitle = DriverManager.getDriver().getTitle();
        assertThat(actualTitle).as("Title is not matched")
                .isEqualTo(expectedTitle);
    }



}
