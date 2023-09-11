package page_objects.android;


import org.openqa.selenium.By;
import page_objects.common_pages.Teams;

public abstract class Android_Teams extends Teams {

    By getTeamsPageTitle = By.id("com.fivemobile.thescore:id/title_onboarding");

    By totalElements = By.xpath("//*[@resource-id='com.fivemobile.thescore:id/chips_container']//android.view.ViewGroup");

    By backButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]\n");

    By continueButton = By.id("com.fivemobile.thescore:id/btn_primary");

    @Override
    public String getScreenTitle() {
        return getText(getTeamsPageTitle);
    }

    @Override
    public void selectTab(String tabName) {
        click(By.xpath("//android.widget.HorizontalScrollView[@id,'com.fivemobile.thescore:id/tabLayout']//android.widget.LinearLayout[@content-desc='"+tabName+"']"));
    }
    @Override
    public void selectTeam(String teamName) {
        click(By.xpath("//android.widget.TextView[contains(@text,'"+teamName+"')]"));
    }

    @Override
    public int getNumberOfTeamsSelected() {
        return getTotalMatchedElements(totalElements) - 1;
    }

    @Override
    public void clickContinue() {
        click(continueButton);
    }

    @Override
    public void navigatesBack() {
        click(backButton);
    }
}