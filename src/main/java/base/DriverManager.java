package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;

public class DriverManager {
    private static HashMap<Long, HashMap<String,Object>> drivers = new HashMap<Long, HashMap<String,Object>>();

    public static AppiumDriver getAppiumDriver() {

        Long desiredKey = Thread.currentThread().getId();
        for (Entry<Long, HashMap<String,Object>> entry : drivers.entrySet()) {
            if (desiredKey == entry.getKey())
                return (AppiumDriver)entry.getValue().get("driver");
        }

        DeviceProperties device = DeviceManager.getListOfDevicesAvailable();
        if(Objects.isNull(device)){
            System.out.println("No connected device found");
            return null;
        }

        DesiredCapabilities capabilities = device.getCapabilities();
        if(Objects.isNull(capabilities)) {
            System.out.println("No capabilities found for the device "+device.getName());
            return null;
        }

        try {
            DeviceManager.installApplication(device);
        } catch (IOException e) {
            System.out.println("App could not be installed the device "+device.getName());
            return null;
        }

        AppiumDriver driver = null;
        try {
            URL url = AppiumService.getAppiumServerUrl();
            driver = new AppiumDriver(url, capabilities);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        HashMap<String,Object> driverMap = new HashMap<String,Object>();
        driverMap.put("device",device);
        driverMap.put("driver",driver);

        drivers.put(Thread.currentThread().getId(), driverMap);
        return driver;
    }

    public static void quitCurrentDriver(){
        Long desiredKey = Thread.currentThread().getId();
        getAppiumDriver().quit();
        drivers.remove(desiredKey);
        System.out.println(drivers);
    }
}
