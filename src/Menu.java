public class Menu {

    private static String userInput;

    public static void mainMenu() {

        //main menu loop
        while(true) {

            System.out.println("""
                === Velkommen til Marios pizzaria! ===
                1: Vis menu
                2: Vis ordreliste
                3: Luk
                """);

            //handle userInput

            //switch statement that calls other menu methods
        }

    }

    public static void addOrderMenu() {

        System.out.println("Hvilken pizza vil du have?");

        //handle userInput here

        //ask when the pizza will be collected

        //handle userInput and save it as a localTime type
    }

    public static void printOrderList() {

        System.out.println("\n=== Ordreliste ===");

        //if order list is empty, print that

        //print all orders as unordered list, sorted by time (soonest first)

        //options to add, complete or cancel an order
    }
}
