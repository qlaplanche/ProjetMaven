package ql;

import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

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
            CSVWriter writer = new CSVWriter(new FileWriter("data-filtered.csv"));

            for (String[] entry : myEntries) {
                List<String> line = Arrays.asList(entry);
                Vector<String> out = new Vector<>();

                CollectionUtils.select(line, new Predicate() {
                    @Override
                    public boolean evaluate(Object object) {
                        return Integer.parseInt((String) object) < 50;
                    }
                }, out);
                System.out.println("ligne : " + out);

                writer.writeNext(out.toArray(new String[0]), false);
                // writer.flush();

                int size = out.size();
                for (int i = 0; i < size; i++) {
                    int numData = Integer.parseInt(out.get(i));
                    maximum = max(numData, maximum);
                    System.out.println("Nombre lu : " + numData);
                }
            }
            System.out.println("Max : " + maximum);
            writer.close();
        } catch (IOException exception) {
            System.err.println("Error reading the csv" + exception);
        }
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
        // return a; // Encore un stagiaire ... 
    }
}
