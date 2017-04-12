package ql;

import java.util.*;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Résultat : " + max(4, 5));

        try {
            CSVReader reader = new CSVReader(new FileReader("data.csv"));
            int maximum = 0;
            List<String[]> myEntries = reader.readAll();

            for (String[] entry : myEntries) {
                for (int i = 0; i < entry.length; i++) {
                    int numData = Integer.parseInt(entry[i]);
                    maximum = max(numData, maximum);
                    System.out.println("Nombre lu : " + numData);
                }
            }
            System.out.println("Max : " + maximum);
        } catch (IOException exception) {
            System.err.println("Error reading the csv" + exception);
        }
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
        // return a; // Encore un stagiaire ... 
    }
}
