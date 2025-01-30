package src;

import java.util.List;
import java.util.Scanner;

public class Doctor extends User implements InterfaceDoctor{
    public Doctor(String pseudo, String mdp,  String role) {
        super(pseudo, mdp, role);
    }

    @Override
    public void AddProduct(List<Product> products) {
        Scanner sc = new Scanner(System.in);
        Product newProduct = null;
        System.out.println("What is the name of the  product that you wantt to introduce ? ");
        String nameproduct = sc.nextLine();
        System.out.println("Wich category");
        String category = sc.nextLine();
        System.out.println("Wich price ?");
        int prix = sc.nextInt();
        System.out.println("Wich quandtity ?");
        int quantity = sc.nextInt();

        switch (category) {
            case "Bandage":
                newProduct = new Bandage(nameproduct, prix, quantity, category);
                break;
            case "Cosmetic":
                newProduct = new Cosmetic(nameproduct, prix, quantity, category);
                break;

            case "Spray":
                newProduct = new Spray(nameproduct, prix, quantity, category);
                break;
            default:
                System.out.println("This category is invalid");
        }
        if (newProduct.quantity > 0) {
            for (Product p : products) {
                if (p.getName().equals(newProduct.name)) {
                    System.out.println("Product already in stock");
                    return;
                }
            }
        products.add(newProduct);
        System.out.println("Product added");
        }
        else {
        System.out.println("Quantity invalid");
        }
    }
}
