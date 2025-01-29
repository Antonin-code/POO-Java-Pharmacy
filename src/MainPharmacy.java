package src;

import java.util.ArrayList;

import java.util.List;

import java.util.*;

public class MainPharmacy {
    public static void main(String[] args) {

        //Cosmetique
        Cosmetic cosme1 = new Cosmetic("Kiko",10,5,"cosmetic");
        Cosmetic cosme2 = new Cosmetic("Sephora", 15, 7, "cosmetic");
        Cosmetic cosme3 = new Cosmetic("Oréal", 12, 6, "cosmetic");
        Cosmetic cosme4 = new Cosmetic("Maybelline", 18, 9, "cosmetic");

        //Bandage
        Bandage band1 = new Bandage("Bande adhésive", 50, 20, "bandage");
        Bandage band2 = new Bandage("Pansement stérile", 40, 15, "bandage");
        Bandage band3 = new Bandage("Bandage élastique", 60, 25, "bandage");
        Bandage band4 = new Bandage("Compresses médicales", 35, 10, "bandage");

        //Spray
        Spray spray1 = new Spray("Sterimar",25,15,"spray");
        Spray spray2 = new Spray("Désinfectant", 30, 20, "spray");
        Spray spray3 = new Spray("Anti-douleur", 28, 18, "spray");
        Spray spray4 = new Spray("Spray nasal", 22, 12, "spray");

        List<Product> allproduct = new ArrayList<>();

        // add of product in the array

        allproduct.add(band1);
        allproduct.add(band2);
        allproduct.add(band3);
        allproduct.add(band4);

        allproduct.add(spray1);
        allproduct.add(spray2);
        allproduct.add(spray3);
        allproduct.add(spray4);

        allproduct.add(cosme1);
        allproduct.add(cosme2);
        allproduct.add(cosme3);
        allproduct.add(cosme4);

        allproduct.sort(new Comparator<Product>() {
            public int compare(Product elmnt1, Product elmnt2) {
                return elmnt1.getName().compareTo(elmnt2.getName());  // trie par nom //
            }
        });

        // on affiche les produit trié//
        for (Product elmnt : allproduct) {
            System.out.println(elmnt.getName());
        }
    }
}
