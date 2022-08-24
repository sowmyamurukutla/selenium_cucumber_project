package com.apps.flipkart.step_definitions;

import com.apps.flipkart.steps.LoginSteps;
import com.apps.flipkart.steps.TitleSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TitleStepDefinitions {


    TitleSteps titleSteps = new TitleSteps();
    LoginSteps loginSteps = new LoginSteps();

    @Given("I open the flipKart application")
    public void iOpenTheFlipKartApplication() {
        loginSteps.openFlipKartUrl();
    }

    @Then("I verify the title of flipKart application is {string}")
    public void iVerifyTheTitleOfFlipKartApplicationIs(String expectedTitle) {
        titleSteps.verifyTitle(expectedTitle);
    }
}
