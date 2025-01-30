package src;

import java.util.List;

public class Bandage extends Product implements Stockable {

    public Bandage(String name, float price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;

    }



}
