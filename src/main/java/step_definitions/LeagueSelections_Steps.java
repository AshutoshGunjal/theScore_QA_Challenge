package step_definitions;

import business_logic.Home_Flow;
import business_logic.League_Flow;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LeagueSelections_Steps {

    @Given("User is at home screen")
    public void verifyIfUserIsAtHomeScreen() {
        new Home_Flow().verifyHomeScreen();
    }

    @When("User goes to league selection page")
    public void goToLeagueSelection() {
        new Home_Flow().goToLeagueSelectionPage();
    }

    @And("League selection page gets opened")
    public void verifyIfLeaguePageOpened() {
        new League_Flow().verifyLeagueSelectionScreen();
    }

    @Then("User should be able to select the {string}")
    public void selectLeague(String league) {
        new League_Flow().verifyLeagueSelection(league.split(","));
    }

    @When("User goes to team selection page")
    public void gotToTeamSelectionPage() {
        new League_Flow().goToTeamSelectionPage();
    }

    @When ("User navigates back to home screen")
    public void goToHomeScreen() {
        new League_Flow().goToHomeScreen();
    }
}