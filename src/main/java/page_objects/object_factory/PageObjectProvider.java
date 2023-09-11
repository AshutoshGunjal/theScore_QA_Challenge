package page_objects.object_factory;

import base.DeviceConstants.DevicePlatform;
import utilities.UtilProperties;

public class PageObjectProvider {

    public static Object getPageObject(String pageName) {
        switch(DevicePlatform.valueOf(UtilProperties.get("platform"))) {

            case ANDROID:
                try {
                    return Class.forName(UtilProperties.get("android_page_objects") + "." + "Android_" + pageName).newInstance();

                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            default:
                return null;
        }
    }

}