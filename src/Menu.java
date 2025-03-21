import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Menu {

    //ArrayList for storing each pizzaType
    private static final ArrayList<PizzaType> menuList = new ArrayList<>();

    //ArrayList of String arrays for storing the info necessary for building each pizzaType object
    private static final ArrayList<String[]> pizzaInfo = new ArrayList<>();

    public static void add(PizzaType pt) {
        menuList.add(pt);
    }

    public static void printMenu() {

        for (PizzaType pt : menuList) {
            System.out.println(pt);
        }
    }

    public static void initializeMenu() {

        //check if  menu file exists
        File menuFile = new File("menu.csv");

        if(!menuFile.exists() && !menuFile.isDirectory()) {
            throw new RuntimeException("Menu filen kunne ikke findes i denne folder!");
        }

        //build CSV parser using the openCSV library
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(false)
                .build();

        //build CSV reader using openCSV in try-with-resources block (auto closes csvReader after use
        try (CSVReader csvReader = new CSVReaderBuilder(Files.newBufferedReader(menuFile.toPath()))
                .withCSVParser(parser)
                .withSkipLines(1)
                .build()) {


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
            Menu.add(pizzaType);
        }

        //throw error if there are no pizzas in menu.csv
        if (menuList.isEmpty()) {
            throw new RuntimeException("Menuen er tom, indsæt minimum ét element på menuen!");
        }
    }
}
