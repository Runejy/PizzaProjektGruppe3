import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

    //ArrayList for storing each pizzaType
    private static ArrayList<PizzaType> menu = new ArrayList<>();

    //ArrayList of String arrays for storing the info necessary for building each pizzaType object
    private static ArrayList<String[]> pizzaInfo = new ArrayList<>();

    public static void add(PizzaType pt) {
        menu.add(pt);
    }

    public static void printMenu() {

        for (PizzaType pt : menu) {
            System.out.println(pt);
        }
    }

    public static int getLength() {
        return menu.size();
    }

    public static void initializeMenu() {

        //check if  menu file exists
        File menuFile = new File("menu.csv");

        if(!menuFile.exists() && !menuFile.isDirectory()) {
            throw new RuntimeException("Menu filen kunne ikke findes på computeren!");
        }

        //build CSV parser using external library openCSV
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(false)
                .build();

        //build CSV reader using openCSV
        try (CSVReader csvReader = new CSVReaderBuilder(Files.newBufferedReader(menuFile.toPath()))
                .withCSVParser(parser)
                .withSkipLines(0)
                .build()) {


            //check if menu file is empty
            if (csvReader.readNext() == null) {
                throw new RuntimeException("Menuen er tom. Indsæt venligst minimum ét element på menuen");
            }

            //read CSV file and send to pizzaInfo list
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                pizzaInfo.add(line);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        //create new pizzaType objects for each array in Arraylist
        for (String[] pizza : pizzaInfo) {
            int number = Integer.parseInt(pizza[0]);
            String name = pizza[1];
            String description = pizza[2];
            double price = Double.parseDouble(pizza[3]);

            PizzaType pizzaType = new PizzaType(number, name, description, price);
            menu.add(pizzaType);
        }

        for (PizzaType pt : menu) {
            System.out.println(pt.toString());
        }

    }
}
