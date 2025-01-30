package src;

import java.util.ArrayList;

public class Category {
    String categorie;
    String sousCategorie;
    ArrayList<Product> products;

    public Category( String categorie, String sousCategorie, ArrayList<Product> products) {
        this.sousCategorie = sousCategorie;
        this.products = products;
        this.categorie = categorie;
    }
}
