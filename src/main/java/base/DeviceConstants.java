package base;
public class DeviceConstants {

    public enum DevicePlatform {

        ANDROID("android");

        private final String name;

        DevicePlatform(String name) {
            this.name = name;
        }
    }
}
