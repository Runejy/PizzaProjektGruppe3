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
        //check if file exists

        //read menu.csv

        //create pizzaType objects and store them in ArrayList

    }
}
