package com.apps.flipkart.steps;

import com.apps.flipkart.utils.Actions;
import com.apps.flipkart.utils.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.apps.flipkart.pageobjects.HomePage.LOGGED_IN_USER_NAME;
import static com.apps.flipkart.pageobjects.LoginPage.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    public void openFlipKartUrl() {
        Actions.openUrl(ConfigManager.getConfigProperty("app.url"));
        LOGGER.info("Successfully opened the url");
    }

    public void loginFlipKart(String userName, String passWord) {
        Actions.enterText(USERNAME, userName);
        Actions.enterText(PASSWORD, passWord);
        Actions.click(LOGIN_BUTTON);
        LOGGER.info("Successfully Logged into the FlipKart");
        Actions.sleep(1500);
    }

    public void verifyLoggedInUserName(String expectedName) {
        String actualName = Actions.getText(LOGGED_IN_USER_NAME);
        assertThat(actualName).as("User names are not matched")
                .isEqualTo(expectedName);
    }

    public void verifyLoginErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = Actions.getText(ERROR_MESSAGE);
        assertThat(actualErrorMessage).as("Error message is not matched")
                .isEqualTo(expectedErrorMessage);
    }

}
