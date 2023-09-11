package business_logic;

import utilities.JSONUtils;
import org.json.simple.JSONObject;
import org.junit.Assert;
import page_objects.common_pages.Alerts;
import page_objects.common_pages.Dashboard;
import page_objects.common_pages.Notification;
import page_objects.common_pages.Teams;
import page_objects.object_factory.PageObjectProvider;

public class Team_Flow {
    public void verifyTeamSelectionScreen() {
        Teams teams = (Teams) PageObjectProvider.getPageObject("Teams");
        Assert.assertEquals("Choose your favourite teams", teams.getScreenTitle());
    }

    public void userSelectTab(String tabName) {
        Teams teams = (Teams) PageObjectProvider.getPageObject("Teams");
        teams.selectTab(tabName);
    }

    public void selectTeam(String leagueName, String[] teamCode) {
        Teams teams = (Teams) PageObjectProvider.getPageObject("Teams");
        for(String teamCodeName : teamCode) {
            teams.selectTeam((String)((JSONObject) JSONUtils.getLeaguesObject(leagueName).get("teams")).get(teamCodeName));
        }
    }

    public void verifyTeamSelection(String[] teamsName) {
        Teams teams = (Teams) PageObjectProvider.getPageObject("Teams");
        Assert.assertEquals(teamsName.length, teams.getNumberOfTeamsSelected());
    }

    public void goToAlertsPage() {
        Teams teams = (Teams) PageObjectProvider.getPageObject("Teams");
        teams.clickContinue();
    }

    public void verifyAlertsSettingPageOpens() {
        Alerts alerts = (Alerts) PageObjectProvider.getPageObject("Alerts");
        Assert.assertEquals("Never miss a game", alerts.getAlertsScreenTitle());
    }

    public void alertsDone() {
        Alerts alerts = (Alerts) PageObjectProvider.getPageObject("Alerts");
        alerts.clickDone();
    }

    public void verifyNotificationPageOpens() {
        Notification notification = (Notification) PageObjectProvider.getPageObject("Notification");
        Assert.assertEquals("Allow theScore to send you notifications?", notification.getNotificationTitle());
    }
    public void selectNotificationOption() {
        Notification notification = (Notification) PageObjectProvider.getPageObject("Notification");
        notification.selectsNotification();
    }

    public void verifyDashboardPageOpens() {
        Dashboard dashboard = (Dashboard) PageObjectProvider.getPageObject("Dashboard");
        Assert.assertTrue(dashboard.isDashboardPage());
    }

    public void verifySelectedTeamsListedOnDashboard(String[] teamsList) {
        Dashboard dashboard = (Dashboard) PageObjectProvider.getPageObject("Dashboard");
        for(String team : teamsList) {
            Assert.assertTrue(dashboard.isSelectedTeamsDisplayed(team.trim()));
        }
    }

    public void navigateToLeaguesScreen() {
        Teams teams = (Teams) PageObjectProvider.getPageObject("Teams");
        teams.navigatesBack();
    }
}
