package page_objects.common_pages;

public abstract class Leagues extends Base {

    public abstract String getScreenTitle();

    public abstract void selectLeague(String leagueName);

    public abstract void doContinue();

    public abstract boolean isLeagueSelected(String leagueName);

    public abstract void goHomeScreen();

}