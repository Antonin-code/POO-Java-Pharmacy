package src;

import java.util.List;

import java.util.ArrayList;

public interface Stockable {
    public void AddProduct(Stock stock  );
    public void AddProduct(Stats stats);
    public void AddProduct(Order order);
    public void DelProduct(List<Product> products);
}
