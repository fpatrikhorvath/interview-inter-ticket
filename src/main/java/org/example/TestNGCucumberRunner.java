package org.example;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        plugin = { "pretty", "html:target/cucumber-report.html" },
        monochrome = true,
        glue = {"org.example.steps"}
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
}
