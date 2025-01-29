package src;

import java.util.ArrayList;
import java.util.List;

public class MainPharmacy {
    public static void main(String[] args) {
        List<Product> legendes = new ArrayList<Product>();
        Bandage bd = new Bandage("bdd", 23.3F, 4, "Lebandant");
        Bandage bd1 = new Bandage("bdd2", 3.3F, 34, "Lebandant");
        Bandage bd2 = new Bandage("bdd1", 2.3F, 455, "Lebandant");
        bd.AddProduct(legendes);
        bd2.AddProduct(legendes);
        bd1.AddProduct(legendes);
        for (Product p : legendes) {
            System.out.println(p.getName());
        }
        bd.DelProduct(legendes);
        for (Product p : legendes) {
            System.out.println(p.getName());
        }
        bd.DelProduct(legendes);

    }
}