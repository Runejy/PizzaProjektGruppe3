public class OrderLine {
    //--instance fields--
    private final Pizza pizza;
    private int amount;

    //--constructor--
    public OrderLine(Pizza pizza) {
        this.pizza = pizza;
        this.amount = 1;
    }

    //--methods--

    public String getPizzaName() {
        return this.pizza.getName();
    }
    public void incrementAmount(int amount) {
        this.amount += amount;
    }

    public String toString() {
        return String.format("%dx %s",this.amount, this.pizza);
    }
}
