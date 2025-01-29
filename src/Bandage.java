package src;

import java.util.List;

public class Bandage extends Product implements Stockable {

    @Override
    public void AddProduct(List<Product> products) {

        if (this.quantity>0){
              for (Product p : products) {
                  if (getName().equals(this.getName())){
                      products.add(this);
                      System.out.println("Product added");

                      return;
                  }
              }
            System.out.println("Product already in stock");

        }
        else {
            System.out.println("Quantity invalid");

        }

    }

}
