package src;

import java.util.ArrayList;

import java.util.List;

import java.util.*;

public class MainPharmacy {
    public static void main(String[] args) {

        //Cosmetique
        Cosmetic cosme1 = new Cosmetic("Kiko",10,4,"cosmetic");
        Cosmetic cosme2 = new Cosmetic("Sephora", 15, 2, "cosmetic");
        Cosmetic cosme3 = new Cosmetic("Oréal", 12, 6, "cosmetic");
        Cosmetic cosme4 = new Cosmetic("Maybelline", 18, 9, "cosmetic");

        //Bandage
        Bandage band1 = new Bandage("Bande adhésive", 50, 20, "bandage");
        Bandage band2 = new Bandage("Pansement stérile", 40, 0, "bandage");
        Bandage band3 = new Bandage("Bandage élastique", 60, 0, "bandage");
        Bandage band4 = new Bandage("Compresses médicales", 35, 10, "bandage");

        //Spray
        Spray spray1 = new Spray("Sterimar",25,15,"spray");
        Spray spray2 = new Spray("Désinfectant", 30, 20, "spray");
        Spray spray3 = new Spray("Anti-douleur", 28, 18, "spray");
        Spray spray4 = new Spray("Spray nasal", 22, 12, "spray");
    
        Stock stock = new Stock();

        // add of product in the array

        stock.addProduct(band1);
        stock.addProduct(band2);
        stock.addProduct(band3);
        stock.addProduct(band4);

        stock.addProduct(spray1);
        stock.addProduct(spray2);
        stock.addProduct(spray3);
        stock.addProduct(spray4);

        stock.addProduct(cosme1);
        stock.addProduct(cosme2);
        stock.addProduct(cosme3);
        stock.addProduct(cosme4);

        // on affiche les produits trié//
        for (Product elmnt : stock.sort()) {
            if (elmnt.getQuantity() == 0){
                System.out.println("nom : " + elmnt.getName() +" : Out of stock");
            }
            else {
                System.out.println("nom : " + elmnt.getName() + " | prix : " + elmnt.getPrice() + " | quantité : " + elmnt.getQuantity() + " | catégorie : " + elmnt.getCategory());
            }
        }

        System.out.println("_________");

        for (Product elmnt : stock.sortByQuantity()) {
            if (elmnt.getQuantity() == 0){
                System.out.println("nom : " + elmnt.getName() +" : Out of stock");
            }
            else {
                System.out.println("nom : " + elmnt.getName() + " | prix : " + elmnt.getPrice() + " | quantité : " + elmnt.getQuantity() + " | catégorie : " + elmnt.getCategory());
                if(elmnt.getQuantity()<5){
                    System.out.println(elmnt.getName() + " à réaprovisioner");
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Saisissez le médicament que vous souhaitez rechercher : ");
        String word = sc.nextLine();

        stock.sort();
        Product elmnt  = stock.recherche(word);
        System.out.println("nom : " + elmnt.getName() + " | prix : " + elmnt.getPrice() + " | quantité : " + elmnt.getQuantity() + " | catégorie : " + elmnt.getCategory());



    }
}
