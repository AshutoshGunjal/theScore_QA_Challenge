package base;

import org.openqa.selenium.remote.DesiredCapabilities;

public class DeviceProperties {

    private String name;

    private String os;

    private boolean availability;

    private DesiredCapabilities capabilities;

    public DeviceProperties(String name, String os, boolean availability, DesiredCapabilities capabilities) {
        this.name = name;
        this.os = os;
        this.availability = availability;
        this.capabilities = capabilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public DesiredCapabilities getCapabilities() {
        return  capabilities;
    }

    public void setCapabilities(DesiredCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof DeviceProperties)) {
            return false;
        }

        DeviceProperties deviceProperties = (DeviceProperties) object;

        if(this.getName().equals(deviceProperties.getName()) && this.getOs().equals(deviceProperties.getOs()))
            return true;
        else
            return false;
    }
}
