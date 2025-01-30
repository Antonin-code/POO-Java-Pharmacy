package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

import java.util.List;

import java.util.*;

public class MainPharmacy {
    public static void main(String[] args) {

        //Cosmetique
        Cosmetic cosme1 = new Cosmetic("Kiko",10);
        Cosmetic cosme2 = new Cosmetic("Sephora", 15 );
        Cosmetic cosme3 = new Cosmetic("Oréal", 12);
        Cosmetic cosme4 = new Cosmetic("Maybelline", 18);

        //Bandage
        Bandage band1 = new Bandage("Bande adhésive", 50, 20, "bandage");
        Bandage band2 = new Bandage("Pansement stérile", 40, 0, "bandage");
        Bandage band3 = new Bandage("Bandage élastique", 60, 0, "bandage");
        Bandage band4 = new Bandage("Compresses médicales", 35, 10, "bandage");

        //Spray
        Spray spray1 = new Spray("Sterimar",25);
        Spray spray2 = new Spray("Désinfectant", 30);
        Spray spray3 = new Spray("Anti-douleur", 28);
        Spray spray4 = new Spray("Spray nasal", 22  );

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

        // on affiche les produits trié//
        for (Product elmnt : allproduct) {
            if (elmnt.getQuantity() == 0){
                System.out.println("nom : " + elmnt.getName() +" : Out of stock");
            }
            System.out.println("nom : " + elmnt.getName() + " | prix : " + elmnt.getPrice() + " | quantité : " + elmnt.getQuantity() + " | catégorie : " + elmnt.getCategory() );
        }
        List<Product> legendes = new ArrayList<Product>();
        List<Product> listProductCommande = new ArrayList<>();
        List<Order> HistoricOrder = new ArrayList<>();
        Bandage bd = new Bandage("bdd", 23.3F, 4, "Lebandant");
        Bandage bd1 = new Bandage("bdd2", 3.3F, 34, "Lebandant");
        Bandage bd2 = new Bandage("bdd1", 2.3F, 455, "Lebandant");
        bd.AddProduct(legendes);
        bd2.AddProduct(legendes);
        bd1.AddProduct(legendes);
        List<Order> listOrder = new ArrayList<>();
        boolean wanttobuy = true;

        System.out.println("Do you want to see purchases ? ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println(HistoricOrder);
        }



        while (wanttobuy) {
            System.out.println("Do you want to buy some products?");
            Scanner in = new Scanner(System.in);
            if (in.nextLine().equalsIgnoreCase("yes")) {
                Order order = new Order();

                while (true) {

                    System.out.println("Enter product name: ");
                    String tmp = in.nextLine();
                    boolean found = false;
                    for (Product p : legendes) {
                        if (p.getName().equalsIgnoreCase(tmp)) {
                            found = true;
                            while (true) {

                                System.out.println("Enter the quantity: ");
                                try {
                                    String testint = in.nextLine();
                                    boolean isint= true;
                                    for (int i = 0; i < testint.length(); i++) {
                                        if(!Character.isDigit(testint.charAt(i))) {
                                            isint= false;
                                            break;
                                        }
                                    }
                                    if (isint) {
                                        int inttmp = Integer.valueOf(testint) ;

                                        if (inttmp > 0 && inttmp <= p.getQuantity()) {

                                            order.listProducts.add(new Bandage(tmp, p.getPrice(), inttmp, p.getCategory()));
                                            if (p.getQuantity() < 5) {
                                                System.out.println("The product is lower than 5!");
                                            }
                                            System.out.println("Successfully bought!");
                                            break;
                                        } else {
                                            System.out.println("You cant buy the quantity you asked !");
                                        }
                                    }
                                    else {
                                        System.out.println("Enter a number");
                                    }

                                } catch (Exception _) {
                                }
                            }
                            break;
                        }

                    }
                    if (!found){
                        System.out.println("Désolé le produit n'existe pas !");


                    }

                    String st = new String();
                    boolean flag = false;
                    while (!flag) {
                        System.out.println("Do you want to still want to buy some products?");
                        st = in.nextLine();
                        if (st.equalsIgnoreCase("no")) {
                            System.out.println("See you soon!");
                            System.out.println(java.time.LocalDate.now());
                            for (Product p : order.listProducts) {
                                for (Product p2 : legendes) {
                                    if (p.getName().equalsIgnoreCase(p2.getName())) {
                                        p2.setQuantity(p2.getQuantity() - p.getQuantity());
                                        System.out.println("Il reste actuellement :" + p2.quantity + " " +  p2.getName());
                                    }
                                    flag = true;
                                }
                            }
                        } else if (!st.equalsIgnoreCase("yes")) {
                            System.out.println("Answer by yes or no.");
                        } else {
                            flag = true;
                        }
                    }
                    if (st.equalsIgnoreCase("no")) {
                        wanttobuy = false;
                        order.Hour = java.time.LocalTime.now().toString();
                        order.Date = java.time.LocalDate.now().toString();
                        HistoricOrder.addFirst(order);

                        break;
                    }


                }

            } else if (in.nextLine().equalsIgnoreCase("no")) {

                break;
            } else {
                System.out.println("Answer by yes or no.");
            }
        }

        Order commande = new Order();
        for (Order o : HistoricOrder) {
            System.out.println( o.Hour + " " + o.Date );
        for (Product p : o.listProducts) {
            System.out.println(p.quantity + " " + p.name);

        }

        }


    }
}
