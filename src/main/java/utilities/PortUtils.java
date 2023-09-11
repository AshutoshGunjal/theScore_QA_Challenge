package utilities;

import utilities.UtilProperties;

import java.io.IOException;
import java.net.Socket;

public class PortUtils {

    public static int getAvailablePort() {
        String[] ports = UtilProperties.get("ports").split(",");
        for (String str_port : ports) {
            int port = Integer. parseInt(str_port);
            if (isPortAvailable(port))
                return port;
        }
        return 0;
    }

    private static boolean isPortAvailable(int port) {
        try (Socket ignored = new Socket("localhost", port)) {
            return false;
        } catch (IOException ignored) {
            return true;
        }
    }
}