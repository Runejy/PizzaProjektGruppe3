import java.util.ArrayList;

public class PizzaType {

    //--Instance fields--
    private final int number;
    private final String name;
    private final String description;
    private final double price;

    //--constructor--
    public PizzaType( int number, String name, String description, double price) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //--getters--
    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    //--other methods--
    @Override
    public String toString(){
        return String.format("%d: %s | %s | %.2f dkk",this.number, this.name, this.description, this.price);
    }
}
