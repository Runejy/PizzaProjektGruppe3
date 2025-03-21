public class Navigation {

    private static String userInput;

    public static void mainMenu() {

        //main menu loop
        while(true) {

            System.out.println("""
                === Velkommen til Marios pizzaria! ===
                1: Vis menu
                2: Vis ordreliste
                3: Luk""");

            //handle userInput
            userInput = UserInput.getUserNumber(3);

            //switch statement that calls other menu methods
            switch (userInput) {
                case "1":
                    //call menu that shows available pizzas
                    showAvailablePizzasMenu();
                    break;
                case "2":
                    //call menu that shows all current orders
                    showOrdersMenu();
                    break;
                case "3":
                    return;
            }
        }

    }

    public static void showAvailablePizzasMenu() {

    }

    public static void showOrdersMenu() {

        System.out.println("\n=== Ordreliste ===");

        //if order list is empty, print that

        //print all orders as unordered list, sorted by time (soonest first)

        //options to add, complete or cancel an order
    }

    public static void addOrderMenu() {

        while(true) {

            System.out.println("Hvilken pizza vil du have?");

            //handle userInput here
            userInput = UserInput.getUserString();

            //ask when the pizza will be collected

            //handle userInput and save it as a localTime type
        }
    }
}
