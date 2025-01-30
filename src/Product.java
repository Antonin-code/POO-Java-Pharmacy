package src;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.Element;

public class Product implements Serializable {
    String name;
    float price;
    int quantity;
    String category;

       String id;
       String description;

    public Product(String name,  int quantity) {
        {
            this.name = name;
            this.quantity = quantity;
        }}
    public Product(String name, float price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
  }


    public void setName(String name) {
        this.name = name;
    }


    public void setPrice(float price) {
        this.price = price;
    }




    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {return name;}
    public float getPrice () {return price;}
    public int getQuantity() { return quantity ;}
    public String getCategory () {return category;}

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void AddProduct(ArrayList<Product> products) {
        if (this.quantity >= 0) {
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

    public void DelProduct(ArrayList<Product> products) {
        for (Product p : products) {
            if (p.getName().equals(this.getName())) {
                products.remove(this);
                System.out.println("Product deleted");
                return;
            }
        }

    }
}

