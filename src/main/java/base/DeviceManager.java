package base;

import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.DeviceUtils;
import utilities.UtilProperties;
import java.io.IOException;

public class DeviceManager {

    public static DeviceProperties getListOfDevicesAvailable() {
        for (String deviceName : DeviceUtils.getListOfConnectedDevices()) {
            try {
                DesiredCapabilities capabilities = DeviceDesiredCapabilities.get(deviceName);
                if (capabilities != null) {
                    String platform = capabilities.getCapability("platformName").toString();

                    if (platform.equalsIgnoreCase(UtilProperties.get("platform"))) {
                        return new DeviceProperties(deviceName, platform, true, capabilities);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void installApplication(DeviceProperties deviceProperties) throws IOException {

        if(UtilProperties.get("app_auto_install").equals("false"))
            return;
        DeviceUtils.installAppOnDevice(deviceProperties.getName(), System.getProperty("user.dir") + "/" +
                UtilProperties.get("app_path"));
    }
}
