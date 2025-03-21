import java.util.ArrayList;

public class PizzaType {

    private String name;
    private double price;
    private int number;
    private String description;
    private static ArrayList<PizzaType> menu = new ArrayList<>();

    public PizzaType( int number, String name, String description, double price) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.price = price;
        Menu.add(this);
    }

    @Override
    public String toString(){
        return String.format("%d: %s | %s | %.2f dkk",this.number, this.name, this.description, this.price);
    }
}
