package src;

import java.util.List;

public class Cosmetic extends Product implements Stockable {

    public Cosmetic(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }




    @Override
    public void AddProduct(List<Product> products) {
        if (this.quantity > 0) {
            for (Product p : products) {
                if (p.getName().equals(this.getName())) {
                    System.out.println("Product already in stock");
                    return;
                }
            }
            products.add(this);
            System.out.println("Product added");
        } else {
            System.out.println("Quantity invalid");
        }
    }

    public void DelProduct(List <Product> products) {
        for (Product p : products) {
            if (p.getName().equals(this.getName())) {
                products.remove(this);
                System.out.println("Product deleted");
                return;
            }
        }

    }
}
