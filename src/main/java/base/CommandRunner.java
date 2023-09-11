package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommandRunner {

    public static int runSyncCommand(String command) throws InterruptedException, IOException {
        Process p = Runtime.getRuntime().exec(command);
        return p.waitFor();
    }

    public static String runCommand(String command)
            throws IOException {
        BufferedReader br = getBufferedReader(command);
        String line;
        String allLine = "";
        while ((line = br.readLine()) != null) {
            allLine = allLine + "" + line + "\n";
        }
        return allLine;
    }

    public static BufferedReader getBufferedReader(String command) throws IOException {
        List<String> commands = new ArrayList<>();
        commands.add("/bin/sh");
        commands.add("-c");
        commands.add(command);
        ProcessBuilder builder = new ProcessBuilder(commands);
        Process process = builder.start();
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        return new BufferedReader(isr);
    }
}
