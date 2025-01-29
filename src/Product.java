package src;

public abstract class Product {
    String name;
    float price;
    int quantity;
    String category;

    public Product(String name, float price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {return name;}
    public float getPrice () {return price;}
    public int getQuantity() { return quantity ;}
    public String getCategory () {return category;}
}
