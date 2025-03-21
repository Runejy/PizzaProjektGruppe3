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

    //getCollectionTime
    public double getTime() {
        return time;
    }

    //getTotalPrice
    public double getTotalPrice() {
        return totalPrice;
    }

    //getCustomerPhone
    public int getPhoneNr() {
        return phoneNr;
    }

    //getCustomerFirstName
    public String getName() {
        return name;
    }

    //getPizzas (return all ordered pizzas, maybe as an arraylist)
    public int getOrder() {
        return order;
    }

    //toString (return all pertinent information about order as string)
    @Override
    public String toString() {
        return "";
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


}

