import java.util.ArrayList;
import java.util.Scanner;


enum Pizza {
    VESUVIO(57), AMERIKANER(53), CACCIATORE(57), CARBONA(63), DENNIS(65), BERTIL(57), SILVIA(61), VICTORIA(61),
    TORONFO(61), CAPRICCIOS(61), HAWAI(61), LE_BLISSOLA(61), VENEZIA(61), MAFIA(61);

    private final int PRICE;

    Pizza(int PRICE) {
        this.PRICE = PRICE;
    }

    public int getPRICE() {
        return PRICE;
    }
}

public class MariosPizza {

    private static ArrayList<Pizza> pizzaOrders = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Pizza[] pizzas = Pizza.values();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== Velkommen til Marios pizzaria! ===");
            System.out.println("1. Vis menu.");
            System.out.println("2. Vis order liste.");
            System.out.println("3. Tilføj ordrer.");
            System.out.println("4. Slet ordrer.");
            System.out.println("5. Luk programmet.");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < pizzas.length; i++) {
                        System.out.println((i + 1) + ": " + pizzas[i] + " (kr " + pizzas[i].getPRICE() + ")");
                    }
                    break;
                case 2:
                    showOrder();
                    break;
                case 3:
                    addOrder();
                    break;
            }
        }
    }

    private static void addOrder() {
        System.out.println("Hvilken pizza ska' du have min ven? (1-14)");
        int pizNum = scanner.nextInt();

        if (pizNum >= 1 && pizNum <= pizzas.length) {
            Pizza pizChoice = pizzas[pizNum - 1];
            System.out.println("Du har valgt: "+pizChoice);
            pizzaOrders.add(pizChoice);
        } else {
            System.out.println("Ugyldigt valg, vælg et tal fra menuen");
        }
    }


    public static void showOrder() {
        if (pizzaOrders.isEmpty()) {
            System.out.println("Order liste er tom");
        } else {
            System.out.println("\n= Order liste =");
            for (Pizza pizza : pizzaOrders) {
                System.out.println(pizza);
            }
        }
    }
}