import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    int pizzaID;
    double time;
    String name;
    int phoneNr;
    double totalPrice;

    Scanner input = new Scanner(System.in);
    String stringInput = input.nextLine();

    public Order(int pizzaID, double time, String name, int phoneNr, double totalPrice) {
        this.pizzaID =pizzaID;
        this.name = name;
        this.time = time;
        this.phoneNr = phoneNr;
        this.totalPrice = totalPrice;
    }

    public double getTime() {
        return time;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    //Display method (used as coupled with an object by . notation:
    public void displaySpecificOrder() {
        System.out.println("Pizza in preparation: " + pizzaID);
        System.out.println("Name of customer: " + name);
        System.out.println("Phone number: " + phoneNr);
        System.out.println("Total price of this order: " + totalPrice);
        System.out.println("__________________________________");
    }

    private static ArrayList<Order> orders = new ArrayList<>();

    while(true) {
        System.out.println("Please enter the order ID: of the pizza - press -1 to exit");
        String pizzaID = input.nextLine();
        if (pizzaID == -1) break;
        System.out.println("Please enter the time of pizza being finished - press -1 to exit");
        String time = input.nextLine();
        if (time == -1) break;
        System.out.println("Please enter name - press -1 to exit");
        String name = input.nextLine();
        if (name == -1) break;
        System.out.println("Please enter phone number of the customer - press -1 to exit");
        int phoneNr = input.nextInt();
        if (phoneNr == -1) break;
        System.out.println("Please enter the total price of this order - press -1 to exit");
        double totalPrice = input.nextDouble();
        if (totalPrice == -1) break;





    //mangler Scanner til telefonNr og en scanner til navn (Tiden er der en indbygget funktion til)
    // @Override
    //   public String toString() {
    //     String s = "Navn;" + name + "\n tiden er; " + time + "\n telefon nr; " + phoneNr;
    //   return s;
    // }

    //public addOrder() {
    //  System.out.println("Skriv venligst følgende oplysninger: order, time, name, phineNr and totalPrice");
    //input =
    //}

    //public void addPizza () {
    //  System.out.println("Vælg venligst den pizza du vil have");
    //input = add.nextLine();
    // input

    //}

    //constructor method (remember to add order to orders ArrayList)

    //---non-static methods---

    //getPizzas (return all ordered pizzas, maybe as an arraylist)

    //getTotalPrice

    //getCustomerFirstName

    //getCustomerPhone

    //getCollectionTime

    //toString (return all pertinent information about order as string)

    //---static methods---

    //printOrderList



}

public void main() {
}




//INstance fields for hvad en ordre skal inhdholde
//En ArrayList holder styr på alle ordre
//Constructor opretter et object i ordre klasse
//Setter og getter metode
}

        }
