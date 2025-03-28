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
            userInput = Input.getUserNumber(3);

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

        System.out.println("=== MENU ===\n");
        Menu.printMenu();
        System.out.println("Skriv \"tilbage\" for at gå tilbage:");
        userInput = Input.getUserString();
    }

    public static void showOrdersMenu() {

        while(true) {
            System.out.println("=== Ordreliste ===");

            //if order list is empty, print that
            if (Order.getAmountOfOrders() == 0) {
                System.out.println("Ingen ordrer at vise");
            } else {
                //print all orders as unordered list, sorted by time (soonest first)
                System.out.println(Order.getAllOrders());
            }

            //options to add, complete or cancel an order
            System.out.println("""
                    1: Tilføj ordre
                    2: Fuldfør ordre
                    3: Annuller Ordre
                    4: Tilbage""");

            userInput = Input.getUserNumber(4);

            switch (userInput) {
                case "1" :
                    addOrderMenu();
                    break;
                case "2" :
                    if (Order.getAmountOfOrders() == 0) {
                        System.out.println("Der er ingen ordrer at fuldføre");
                        continue;
                    }
                    completeOrderMenu();
                    break;
                case "3" :
                    if (Order.getAmountOfOrders() == 0) {
                        System.out.println("Der er ingen ordrer at annullere");
                        continue;
                    }
                    cancelOrderMenu();
                    break;
                case "4" :
                    return;
            }
        }
    }

    public static void completeOrderMenu() {

        System.out.println("Vælg en ordre at fuldføre:");
        System.out.println(Order.getOrdersAsNumberedList());
        System.out.println((Order.getAmountOfOrders()+1) + ": tilbage");

        userInput = Input.getUserNumber(Order.getAmountOfOrders()+1);

        if (Integer.parseInt(userInput) == Order.getAmountOfOrders()+1) {
            return;
        }

        Order.getOrder(Integer.parseInt(userInput)).complete();
    }

    public static void cancelOrderMenu() {

        System.out.println("Vælg en ordre at annullere:");
        System.out.println(Order.getOrdersAsNumberedList());
        System.out.println((Order.getAmountOfOrders()+1) + ": tilbage");

        userInput = Input.getUserNumber(Order.getAmountOfOrders()+1);

        if (Integer.parseInt(userInput) == Order.getAmountOfOrders()+1) {
            return;
        }

        Order.removeOrder(Order.getOrder(Integer.parseInt(userInput)));
    }

    public static void addOrderMenu() {

        //create new order
        Order order = new Order();

        while(true) {

            System.out.println("Ordre:");

            //print pizzas currently in order (empty when first entering this menu)
            System.out.println(order.getPizzas());

            System.out.println("""
                    1: tilføj pizza til ordre
                    2: Fuldfør
                    3: Tilbage""");

            //handle userInput here
            userInput = Input.getUserNumber(3);

            switch (userInput) {
                case "1" :
                    addPizzasToOrderMenu(order);
                    break;
                case "2" :
                    //Go to next iteration of loop if order has no pizzas yet
                    if (order.isEmpty()) {
                        System.out.println("Du kan ikke fuldføre en tom ordre!");
                        continue;
                    }

                    //if user has entered pizzas into the order, allow them to complete the order by ensuring they give a name and a collection time
                    System.out.println("Hvem afhenter ordren? (fornavn)");

                    userInput = Input.getUserString();

                    order.setCustomerFirstName(userInput);

                    System.out.println("Hvornår afhentes ordren? (hh:mm)");

                    userInput = Input.getTime();

                    order.setCollectionTime(userInput);

                    //after finishing the order, sort the list of total orders
                    Order.sortOrderList();

                    return;
                case "3" :
                    //Remove order from ArrayList of orders
                    Order.removeOrder(order);
                    return;
            }
        }
    }

    public static void addPizzasToOrderMenu(Order order) {

        System.out.println("Tilføj en pizza:");

        //Print available menu
        Menu.printMenu();

        //after printing all available pizzas, print option to go back to previous menu
        System.out.println((Menu.getLength()+1) + ": Tilbage");

        //get userInput with valid number (amount of pizzas + 1)
        userInput = Input.getUserNumber(Menu.getLength()+1);

        //if user chooses to go back, return to previous menu
        if (userInput.equals(String.valueOf(Menu.getLength()+1))) {
            return;
        }

        //if user hasn't chosen to go back, that means they chose one of the available pizzas to add to the order
        order.addItem(Integer.parseInt(userInput));
    }
}
