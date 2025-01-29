package src;

import java.util.List;

public class Product implements Stockable {
    protected int id;
    protected String name;
    protected float price;
    protected int quantity;
     protected String description;

    public Product(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
