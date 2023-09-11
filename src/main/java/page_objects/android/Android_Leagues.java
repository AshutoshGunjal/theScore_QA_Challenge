package page_objects.android;

import org.openqa.selenium.By;
import page_objects.common_pages.Leagues;

public abstract class Android_Leagues extends Leagues {

    By leaguePageTitleText = By.id("com.fivemobile.thescore:id/title_onboarding");

    By continueButton = By.id("com.fivemobile.thescore:id/btn_primary");

    By allowButton = By.id("com.fivemobile.thescore:id/btn_allow");

    By allowPermissionButton = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");

    By backButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    @Override
    public String getScreenTitle() {
        return getText(leaguePageTitleText);
    }

    @Override
    public void selectLeague(String leagueCode) {
        click(By.xpath("//android.widget.TextView[contains(@text,'"+leagueCode+"')]"));
    }

    @Override
    public void doContinue() {
        click(continueButton);
        handleLocationPopUp();
    }

    public boolean isLeagueSelected(String leagueCode) {
        return isElementPresent(By.xpath("//*[@resource-id='com.fivemobile.thescore:id/chips_container']//android.widget.TextView[contains(@text,'"+leagueCode+"')]"));
    }

    public void goHomeScreen() {
        click(backButton);
    }

    public void handleLocationPopUp(){
        if(isElementPresent(allowButton)){
            click(allowButton);
            click(allowPermissionButton);
        }else if(isElementPresent(allowPermissionButton)){
            click(allowPermissionButton);
        }else{
            return;
        }

    }
}