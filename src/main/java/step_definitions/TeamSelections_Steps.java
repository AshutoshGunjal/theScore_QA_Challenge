package step_definitions;

import business_logic.Team_Flow;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TeamSelections_Steps {

    @Then("Team selection page gets opened")
    public void verifyTeamsPageOpened() {
        new Team_Flow().verifyTeamSelectionScreen();
    }

    @When("User selects the tab {string}")
    public void selectTabInTeamPage(String tabName) {
        new Team_Flow().userSelectTab(tabName);
    }

    @And("User should be able to select teams {string} for {string}")
    public void selectTeams(String leagueName, String teamCode) {

    }

    @Then("User should be able to see the selected league {string} and teams {string}")
    public void verifyLeagueAndTeams(String leagues, String teams) {
        String[] leaguesArray = leagues.split(",");
        String[] teamsArray = teams.split(",");

        String[] leaguesAndTeams = new String[teamsArray.length + leaguesArray.length];

        System.arraycopy(leaguesArray, 0, leaguesAndTeams, 0, leaguesArray.length);
        System.arraycopy(teamsArray, 0, leaguesAndTeams, 0, teamsArray.length);

        new Team_Flow().verifyTeamSelection(leaguesAndTeams);
    }

    @When("User clicks on alerts settings page")
    public void goToAlertsSettingsPage() {
        new Team_Flow().goToAlertsPage();
    }

    @And("Alert settings page gates opened")
    public void verifyIfAlertsPageOpens() {
        new Team_Flow().verifyAlertsSettingPageOpens();
    }

    @Then("User continues from alert settings page")
    public void continueFromAlertsSettingsPage() {
        new Team_Flow().alertsDone();
    }

    @And("User should be on notifications page")
    public void verifyNotificationsPageOpens() {
        new Team_Flow().verifyNotificationPageOpens();
    }

    @Then("Selects the choice for notifications")
    public void selectNotificationChoice() {
        new Team_Flow().selectNotificationOption();
    }

    @Then("User must land on a dashboard page")
    public void verifyLandinOnDashboardPage() {
        new Team_Flow().verifyDashboardPageOpens();
    }

    @And("User should be able to see the selected teams {string}")
    public void verifySelectedTeamsListed(String teams) {
        new Team_Flow().verifySelectedTeamsListedOnDashboard(teams.split(","));
    }

    @When("User navigates back to league selection")
    public void goToLeagueSelectionPage() {
        new Team_Flow().navigateToLeaguesScreen();
    }
}