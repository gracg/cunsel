package nl.capite.cunsel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class util {
    public static  Properties getProperties() throws IOException {
        var f = Files.newInputStream(Paths.get("application.properties"));
        var p = new Properties();
        p.load(f);
        return p;
    }


}