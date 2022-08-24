package com.apps.flipkart.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@flipKart",
        monochrome =true,
        plugin = {"pretty", "json:target/cucumber.json",  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/resources/features",
        glue = "com.apps.flipkart.step_definitions"
)
public class TestRunner {
}
