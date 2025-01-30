package src;

import java.util.*;

public class Stock {
    List<Product> allproduct;

    public Stock() {
        this.allproduct = new ArrayList<>();
    }

    public void addProduct(Product product) {
        allproduct.add(product);
    }

    public List<Product> sort() {
        allproduct.sort(Comparator.comparing(Product::getName));
        return allproduct;
    }

    public List<Product> sortByQuantity() {
        List<Product> result = new ArrayList();
        
        return result;
    }
}