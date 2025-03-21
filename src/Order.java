import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    int order;
    double time;
    String name;
    int phoneNr;
    double totalPrice;

    private static ArrayList<Order> orders = new ArrayList<>();

    public Order(int order, double time, String name, int phoneNr, double totalPrice) {
        this.order = order;
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

    public void addPizza() {
        System.out.println("Vælg venligst den pizza du vil have");

    }

    //---static methods---


}

