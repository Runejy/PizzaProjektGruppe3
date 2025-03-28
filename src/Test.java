public class Test {
    public static void main(String[] args) {


        Menu.initializeMenu();


        Order order1 = new Order();
        order1.setCustomerFirstName("Jens");
        System.out.println("Hvornår skal ordren hentes?");
        String userInput = Input.getTime();
        order1.setCollectionTime(userInput);
        order1.addItem(1);
        order1.addItem(1);
        order1.addItem(1);

        Order order2 = new Order();
        order2.setCustomerFirstName("Søren");
        System.out.println("Hvornår skal ordren hentes?");
        String userInput1 = Input.getTime();
        order2.setCollectionTime(userInput1);
        order2.addItem(2);
        order2.addItem(5);

        Order.writeOrderToFile("MariosOrders.csv");









    }
}
