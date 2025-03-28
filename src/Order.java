import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Order {

    //--instance fields--

    //static list of all current orders
    private static final ArrayList<Order> orderList = new ArrayList<>();

    //ArrayList of arrays for each ordered item (each orderline should have an entry and an amount)
    private final ArrayList<OrderLine> orderedItemsList = new ArrayList<>();

    //Collection time in Localtime Format
    private LocalTime collectionTime;

    private String customerFirstName;
    private double totalPrice;

    //constructor
    public Order() {
        orderList.add(this);
    }

    //---non-static methods---

    //--setters--
    public void setCustomerFirstName(String firstName) {
        this.customerFirstName = firstName;

    }

    public void setCollectionTime(String time) {

        String[] times = time.split(":");

        try {
            this.collectionTime = LocalTime.of(Integer.parseInt(times[0]), Integer.parseInt(times[1]));
        } catch (Exception e) {
            throw new IllegalArgumentException("Collection time not a valid time!");
        }
    }

    //--getters
    public String getCustomerFirstName() {
        return this.customerFirstName;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public LocalTime getCollectionTime() {
        return this.collectionTime;
    }

    //--other methods--
    public void addItem(int pizzaNumber) {

        Pizza pizza = new Pizza(Menu.getType(pizzaNumber));
        //update totalPrice
        this.totalPrice += pizza.getPrice();

        //check if an orderLine in orderedItemsList already has that item
        for (OrderLine orderLine : orderedItemsList) {
            if (orderLine.getPizzaName().equals(pizza.getName())) {

                //if it does increment that orderLine by 1
                orderLine.incrementAmount(1);

                //exit early
                return;
            }
        }

        //if item is not found in orderedItemsList, create a new orderLine with the item
        OrderLine orderLine = new OrderLine(pizza);

        //add it to the ArrayList of orderLines
        orderedItemsList.add(orderLine);
    }

    public boolean isEmpty() {
        return orderedItemsList.isEmpty();
    }

    public String getPizzas() {

        StringBuilder stringBuilder = new StringBuilder();

        for (OrderLine orderLine : orderedItemsList) {
            stringBuilder.append("•").append(orderLine).append("\n");
        }

        return stringBuilder.toString();
    }

    //method for completing order, should call static removeOrder method on itself after writing to CSV
    public void complete() {
        //write to csv file here

        Order.removeOrder(this);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        for (OrderLine orderLine : orderedItemsList) {
            stringBuilder.append("•").append(orderLine).append("\n");
        }



        return String.format("""
                %s
                Totalpris: %.2f dkk
                Afhentes af: %s
                Klokken: %s
                ----------
                """,stringBuilder,
                this.getTotalPrice(),
                this.getCustomerFirstName(),
                (this.collectionTime != null ? this.collectionTime.toString() : "Intet afhentningstidspunkt defineret"));
    }

    //--static methods--

    public static void sortOrderList() {
        //probably a orderList.sort() call here
        orderList.sort(Comparator.comparing(Order::getCollectionTime));
    }

    public static Order getOrder(int orderNumber) {
        return orderList.get(orderNumber-1);
    }

    public static void removeOrder(Order order) {
        orderList.remove(order);
    }

    public static int getAmountOfOrders() {
        return orderList.size();
    }

    public static String getOrdersAsNumberedList() {

        StringBuilder stringBuilder = new StringBuilder();

        int orderNumber = 1;
        for (Order order : orderList) {
            stringBuilder.append(orderNumber).append(":\n").append(order.toString());
            orderNumber++;
        }

        return stringBuilder.toString();
    }

    public static String getAllOrders() {

        StringBuilder stringBuilder = new StringBuilder();

        for (Order order : orderList) {
            stringBuilder.append(order.toString());
        }

        return stringBuilder.toString();
    }



}

