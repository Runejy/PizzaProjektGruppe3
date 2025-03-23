public class Pizza {

    //--instance fields--
    private final PizzaType type;

    //--Constructor--
    public Pizza(PizzaType type) {
        this.type = type;
    }

    //--getters--
    public int getNumber() {
        return type.getNumber();
    }

    public String getName() {
        return type.getName();
    }

    public String getDescription() {
        return type.getDescription();
    }

    public double getPrice() {
        return type.getPrice();
    }

    //--other methods--
    @Override
    public String toString() {
        return this.getName();
    }
}
