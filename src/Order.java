package src;

import java.util.ArrayList;

public class Order {
    ArrayList<Product> listProducts = new ArrayList<>();
    public Order(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }
    public Order() {

    }
}
