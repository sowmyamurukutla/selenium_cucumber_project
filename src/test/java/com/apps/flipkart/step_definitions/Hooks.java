package com.apps.flipkart.step_definitions;

import com.apps.flipkart.utils.Actions;
import com.apps.flipkart.utils.ConfigManager;
import com.apps.flipkart.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static io.cucumber.java.Status.FAILED;

public class Hooks {

    @Before
    public void before() {
        DriverManager.initDriver(ConfigManager.getConfigProperty("browser"));
    }

    /*@AfterStep
    public void afterEachStep(Scenario scenario) {
//        scenario.getStatus();
        scenario.attach(Actions.getByteScreenshot(), "image/png",
                 Actions.getSystemDateMMDDYYYHHMMSS() );
    }*/

    @After
    public void after(Scenario scenario) {
        if(scenario.getStatus() == FAILED) {
            scenario.attach(Actions.getByteScreenshot(), "image/png",
                    Actions.getSystemDateMMDDYYYHHMMSS() );
        }
        DriverManager.quitDriver();
    }
}
