import java.io.File;
import java.util.ArrayList;

public class Menu {

    private static ArrayList<PizzaType> menu = new ArrayList<>();

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
        File menu = new File("menu.csv");

        if(!menu.exists() && !menu.isDirectory()) {
            throw new RuntimeException("Menu filen kunne ikke findes på computeren!");
        }

        //read menu.csv

        //create pizzaType objects and store them in ArrayList

    }
}
