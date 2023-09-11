package test_setup;

import base.AppiumService;
import base.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks {
    @BeforeAll
    public static void setUp() {
        try {
            AppiumService.startAppiumDriverService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public static void cleanUpAfterTestScenarios(Scenario scenario) {
        DriverManager.quitCurrentDriver();
    }
}
