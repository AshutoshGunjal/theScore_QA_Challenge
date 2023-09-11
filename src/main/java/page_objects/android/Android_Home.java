package page_objects.android;

import org.openqa.selenium.By;
import page_objects.common_pages.Home;

public class Android_Home extends Home {

    By continueButton = By.id("com.fivemobile.thescore:id/btn_primary");

    @Override
    public void goToLeagueSelectionPage() {
        click(continueButton);
    }

    @Override
    public boolean isHomeScreen() {
        return false;
    }
}