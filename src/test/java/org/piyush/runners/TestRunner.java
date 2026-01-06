package org.piyush.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.piyush.steps", "org.piyush.hooks"},
        plugin = {"pretty"},
        monochrome = true,
        tags = "@naukri"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
