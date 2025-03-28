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

    //--global variables--

    //ArrayList for storing each pizzaType
    private static final ArrayList<PizzaType> menuList = new ArrayList<>();

    //--getters--
    public static PizzaType getType(int pizzaNumber) {
        try {
            return menuList.get(pizzaNumber-1);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("You attempted to create a pizza of a type that does not exist on menu");
        }
    }

    public static int getLength() {
        return menuList.size();
    }

    //--various methods--
    private static void add(PizzaType pt) {
        menuList.add(pt);
    }

    public static void printMenu() {

        for (PizzaType pt : menuList) {
            System.out.println(pt);
        }
    }

    public static void initializeMenu() {

        //local ArrayList of String arrays for storing information about each type of pizza
        ArrayList<String[]> pizzaInfo = new ArrayList<>();

        //check if  menu file exists
        File menuFile = new File("menu.csv");

        if(!menuFile.exists() && !menuFile.isDirectory()) {
            throw new RuntimeException("Fil ikke fundet: " + menuFile.getAbsolutePath());
        }

        //build CSV parser using the openCSV library
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(false)
                .build();

        //build CSV reader using openCSV in try-with-resources block (auto closes csvReader after use
        try (
                CSVReader csvReader = new CSVReaderBuilder(Files.newBufferedReader(menuFile.toPath()))
                .withCSVParser(parser)
                .withSkipLines(1)
                .build();
        ) {

            //read CSV file and send to pizzaInfo list
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                pizzaInfo.add(line);
            }

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        //create new pizzaType objects for each array in Arraylist and add them to menuList
        try {
            for (String[] pizza : pizzaInfo) {
                int number = Integer.parseInt(pizza[0]);
                String name = pizza[1];
                String description = pizza[2];
                double price = Double.parseDouble(pizza[3]);

                PizzaType pizzaType = new PizzaType(number, name, description, price);
                Menu.add(pizzaType);
            }
        } catch (Exception e) {
            throw new RuntimeException("Kunne ikke indlæse menu. Vær venligst sikker på at den er indskrevet i korrekt format");
        }

        //throw error if there are no pizzas in menu.csv
        if (menuList.isEmpty()) {
            throw new RuntimeException("Menuen er tom, indsæt minimum ét element på menuen!");
        }
    }
}
