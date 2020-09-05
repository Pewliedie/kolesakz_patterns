package com.epam.cdp.kzta2020.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/resources/cucumber_features/"
        , glue = {"com.epam.cdp.kzta2020.cucumber.step_definitions"}
        ,plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter"})
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
