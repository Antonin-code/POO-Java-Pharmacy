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
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(String sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
