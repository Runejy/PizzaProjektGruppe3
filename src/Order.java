import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import com.opencsv.bean.CsvBindByName;

public class Order {


    //--instance fields--

    //static list of all current orders
    private static final ArrayList<Order> orderList = new ArrayList<>();

    //Collection time in Localtime Format
    @CsvBindByName(column = "Collection Time")
    private LocalTime collectionTime;

    @CsvBindByName(column = "Customer Name")
    private String customerFirstName;

    @CsvBindByName(column = "Total Price (DKK)")
    private double totalPrice;

    @CsvBindByName(column = "Ordered Items")
    private String orderedItems;

    //ArrayList of arrays for each ordered item (each orderline should have an entry and an amount)
    private final ArrayList<OrderLine> orderedItemsList = new ArrayList<>();


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
        return (this.totalPrice);
    }

    public LocalTime getCollectionTime() {
        return this.collectionTime;

    }

    public String getOrderedItems() {
        return orderedItemsList.toString();
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

    public void removeItem(int pizzaNumber) {

        Pizza pizza = new Pizza(Menu.getType(pizzaNumber));

        //check if an orderLine in orderedItemsList already has that item
        for (OrderLine orderLine : orderedItemsList) {
            if (orderLine.getPizzaName().equals(pizza.getName())) {

                //if it does, do we reduce the amount of tht pizza
                orderLine.incrementAmount(-1);

                //exit early
                return;
            }
        }
    }

    //maybe a removeItem method here?

    //sortOrders method:
    public static void sortOrderList() {
        //probably a orderList.sort() call here
        orderList.sort(Comparator.comparing(Order::getCollectionTime));

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
                        """, stringBuilder,
                this.getTotalPrice(),
                this.getCustomerFirstName(),
                (this.collectionTime != null ? this.collectionTime.toString() : "Intet afhentningstidspunkt defineret"));
    }

    public static void writeOrderToFile(String MariosOrders) {
        try (Writer writer = new FileWriter(MariosOrders, true)) {
            if (new java.io.File(MariosOrders).length() == 0) {
            }
            // Initialize CSV Writer
            StatefulBeanToCsv<Order> beanToCsv = new StatefulBeanToCsvBuilder<Order>(writer)
                    .withSeparator(';')
                    .build();
            // Get the orders
            List<Order> orders = Order.getOrderList();

            // If no orders, exit
            if (orders.isEmpty()) {
                System.out.println("No orders to write.");
                return;
            }
            // Write orders to the CSV
            beanToCsv.write(orders);
            // Calculate and write the total sum
            double totalSum = orders.stream().mapToDouble(Order::getTotalPrice).sum();
            writer.write("\n;;---------------------\n");
            writer.write(String.format(";;Total Sum: %.2f DKK\n", totalSum));
            writer.write(";;---------------------\n");
            writer.flush(); // Ensure data is written
            System.out.println("Orders with total sum written to " + MariosOrders);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Order> getOrderList() {
        return orderList;

    }

    //--static methods--
    public static String getAllOrders() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Order order : orderList) {
            stringBuilder.append(order.toString());
        }

        return stringBuilder.toString();
    }


}