package business_logic;

import org.junit.Assert;
import page_objects.common_pages.Leagues;
import page_objects.object_factory.PageObjectProvider;

public class League_Flow {

    public void verifyLeagueSelectionScreen() {
        Leagues league = (Leagues) PageObjectProvider.getPageObject("Leagues");
        Assert.assertEquals("Choose your favourite leagues", league.getScreenTitle());
    }

    public void verifyLeagueSelection(String[] leagueArray) {
        Leagues leaguePageObject = (Leagues) PageObjectProvider.getPageObject("Leagues");

        for(String league : leagueArray) {
            leaguePageObject.selectLeague(league);
            Assert.assertTrue(leaguePageObject.isLeagueSelected(league));
        }
    }

    public void goToTeamSelectionPage() {
        Leagues leaguesPage = (Leagues) PageObjectProvider.getPageObject("Leagues");
        leaguesPage.doContinue();
    }

    public void goToHomeScreen() {
        Leagues leaguesPage = (Leagues) PageObjectProvider.getPageObject("Leagues");
        leaguesPage.goHomeScreen();
    }
}
