public class Pizza {
    //instance fields here
    int number;
    String name;
    String description;
    int price;

    public Pizza(int number, String name, String description, int price) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }


    public String toString() {
        return "";
    }
}
