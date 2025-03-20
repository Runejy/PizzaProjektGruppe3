import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    int order;
    double time;
    String name;
    int phoneNr;
    double totalPrice;

    Scanner add = new Scanner(System.in);
    String stringInput = add.nextLine();

    private static ArrayList<Order> orders = new ArrayList<>();

    public Order(int order, double time, String name, int phoneNr, double totalPrice) {
        this.order =order;
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
