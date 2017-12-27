package util;

import java.io.*;
import java.util.ArrayList;

public class Utils {

    public static ArrayList<String> importData() {
        ArrayList<String> data = new ArrayList<>();
        String CurrentLine = "";

        try (BufferedReader br = new BufferedReader(new FileReader("src" + File.separator + "main" + File.separator + "ressources" + File.separator + "data"))) {

            while ((CurrentLine = br.readLine()) != null) {
                data.add(CurrentLine);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return data;
    }
}

