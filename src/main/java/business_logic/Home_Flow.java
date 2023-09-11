package business_logic;

import org.junit.Assert;
import page_objects.common_pages.Home;
import page_objects.object_factory.PageObjectProvider;

public class Home_Flow {

    public void verifyHomeScreen() {
        Home home = (Home) PageObjectProvider.getPageObject("Home");
        Assert.assertTrue(home.isHomeScreen());
    }

    public void goToLeagueSelectionPage() {
        Home homePage = (Home) PageObjectProvider.getPageObject("Home");
        homePage.goToLeagueSelectionPage();
    }
}
