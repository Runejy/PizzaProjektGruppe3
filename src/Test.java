public class Test {
    public static void main(String[] args) {


        Menu.initializeMenu();

        Order order = new Order();
        order.setCustomerFirstName("John");
        order.addItem(14);
        order.addItem(14);
        order.addItem(13);
        System.out.println("Hvornår skal ordren hentes?");
        String userInput = Input.getTime();
        order.setCollectionTime(userInput);

        System.out.println(Order.getAllOrders());
    }
}
