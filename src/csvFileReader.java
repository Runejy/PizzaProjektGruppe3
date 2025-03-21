import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


public class csvFileReader {

    public static void PizzaMenu() {

        // Use the correct RAW GitHub URL
        String csvUrl = "https://raw.githubusercontent.com/Runejy/PizzaProjektGruppe3/main/menu.csv";
        ArrayList<String> pizzaMenu = new ArrayList<>(); // Arraylist to store CSV lines

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(csvUrl).openStream(), StandardCharsets.UTF_8));
            Scanner scan = new Scanner(br);

            while (scan.hasNextLine()) {
                pizzaMenu.add(scan.nextLine()); // Add each line to the Arraylist
            }
            // Close Scanner and BufferedReader
            scan.close();
            br.close();

            //Print all in the Arraylist - for test:)
            //for(String line : pizzaMenu){
            // System.out.println(line);
            //}
        } catch (FileNotFoundException e) {
            System.out.println("File not found:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error closing file: " + e.getMessage());
        }
        //Print menu 1 and 14 from Arraylist - for test:)
        System.out.println(pizzaMenu.get(1));
        System.out.println(pizzaMenu.get(14));

    }
}


