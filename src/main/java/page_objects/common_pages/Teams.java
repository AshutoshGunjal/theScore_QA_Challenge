package page_objects.common_pages;

public abstract class Teams extends Base {

    public abstract String getScreenTitle();

    public abstract void selectTab(String tabName);

    public abstract void selectTeam(String teamName);

    public abstract int getNumberOfTeamsSelected();

    public abstract void clickContinue();

    public abstract void navigatesBack();

}