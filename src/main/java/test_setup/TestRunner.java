package test_setup;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json",
        "htlp:target/cucumber"},
        features = "src/test/feature_file/TestScenarios.feature",
        glue = {"classpath:test_setup", "classpath:src/test/feature_file/TestScenarios.feature"})
public class TestRunner {
}
