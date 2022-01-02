package nl.capite.cunsel.Helpers;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class nqHelper {

    public List<String> GetNQ100() throws IOException {
        File file = new File("nq100.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        List<String> ls = new ArrayList<>();
        String st;
        while ((st=reader.readLine())!=null) {
            ls.add(st);
        }
        return ls;
    }
}
