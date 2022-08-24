package com.apps.flipkart.step_definitions;

import com.apps.flipkart.steps.LoginSteps;
import com.apps.flipkart.utils.ConfigManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;


public class LoginStepDefinitions {

    public LoginSteps loginSteps = new LoginSteps();

    @Given("I login to flipKart application with user details")
    public void iLoginToFlipKartApplicationWithUserDetails() {
        loginSteps.openFlipKartUrl();
        loginSteps.loginFlipKart(ConfigManager.getConfigProperty("userName"), ConfigManager.getConfigProperty("password"));
    }



    @Then("I verify user name is displayed as {string}")
    public void iVerifyUserNameIsDisplayedAs(String expectedName) {
        loginSteps.verifyLoggedInUserName(expectedName);
    }

    @Then("I verify login error message is displayed as {string}")
    public void iVerifyLoginErrorMessageIsDisplayedAs(String expectedErrorMessage) {
        loginSteps.verifyLoginErrorMessage(expectedErrorMessage);
    }

    @Given("I login to flipKart application with invalid user details")
    public void iLoginToFlipKartApplicationWithInvalidUserDetails(List<Map<String, String>> invalidCredentials) {
        loginSteps.openFlipKartUrl();
        loginSteps.loginFlipKart(invalidCredentials.get(0).get("userName"), invalidCredentials.get(0).get("password"));

    }
}
