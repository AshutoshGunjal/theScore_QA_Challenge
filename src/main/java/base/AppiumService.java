package base;

import utilities.PortUtils;
import utilities.UtilProperties;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumService {
    private static int portNumber;

    public static void startAppiumDriverService() throws IOException {
        if(UtilProperties.get("appium_auto_run").equals("false")){
            portNumber = Integer.parseInt(UtilProperties.get("ports").split(",")[0]);
            return;
        }

        System.out.println(String.format("Starting Appium server"));
        portNumber = PortUtils.getAvailablePort();
        Runtime.getRuntime().exec("appium -p "+portNumber);
    }

    public static void stopAppiumDriverService() throws IOException {
        if(UtilProperties.get("appium_auto_run").equals("false")) {
            return;
        }

        try {
            CommandRunner.runSyncCommand("kill -9 "+portNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static URL getAppiumServerUrl() throws MalformedURLException {
        return new URL(UtilProperties.get("appium_host_url") + ":"+portNumber+"/wd/hub/");
    }
}