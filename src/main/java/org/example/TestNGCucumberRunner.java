package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        publish = true,
        glue = {"org.example.steps",}
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
}
