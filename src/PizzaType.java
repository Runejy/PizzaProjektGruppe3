import java.util.ArrayList;

public class PizzaType {

    private String name;
    private int price;
    private int number;
    private String description;
    private static ArrayList<PizzaType> menu = new ArrayList<>();

    public PizzaType(String name, int price, int number, String description) {
        this.name = name;
        this.price = price;
        this.number = number;
        this.description = description;
        menu.add(this);
    }

    public static void initializeMenu() {

    }
}
