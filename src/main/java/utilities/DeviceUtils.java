package utilities;

import base.CommandRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class DeviceUtils {

    public static List<String> getListOfConnectedDevices() {
        List<String> listOfConnectedDevices = new ArrayList<>();

        try{
            String devices = CommandRunner.runCommand("source ~/.bash_profile;adb devices");
            devices = devices.replace("List of devices attached", "");
            devices = devices.replace("device", "");
            StringTokenizer tokens = new StringTokenizer(devices, " ");

            while(tokens.hasMoreTokens()) {
                listOfConnectedDevices.add(tokens.nextToken().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfConnectedDevices;
    }

    public static void installAppOnDevice(String deviceName, String appPath) throws IOException {
        try {
            CommandRunner.runSyncCommand("source ~/.bash_profile;adb -s "+deviceName+" install -r "+appPath);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
