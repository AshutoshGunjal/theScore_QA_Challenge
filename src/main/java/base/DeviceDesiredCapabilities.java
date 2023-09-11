package base;

import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.UtilProperties;

public class DeviceDesiredCapabilities {
    public static DesiredCapabilities get(String deviceName) throws Exception {
        DesiredCapabilities capabilities = CapabilitiesReader.getDesiredCapabilities(deviceName,
                UtilProperties.get("capabilities_location"));
        return capabilities;
    }
}
