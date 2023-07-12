package entities;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryStatisticsManager {
    public static List<Country> countries = new ArrayList<>();

    public void loadDataFromFile(String filename) {
        try (InputStream is = getClass().getResourceAsStream(filename)) {
            Scanner scanner = new Scanner(is);
            scanner.useDelimiter(",|\\n");

            while (scanner.hasNext()) {
                //Fill in the blanks
                String text = scanner.nextLine();
                if (!text.contains("Name")){
                    countries.add(new Country(text));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
