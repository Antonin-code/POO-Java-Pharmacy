package src;

import java.util.List;
import java.util.Scanner;

public class Manager extends User implements InterfaceAdmin, InterfaceDoctor{
    public Manager(String pseudo, String mdp,  String role) {
        super(pseudo, mdp, role);
    }

    @Override
    public void DelUser(AllUsers allusers) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Who do you want to delete ?:");
        String pseudodel = sc.nextLine();
        boolean wasfound = false;
        for (User u : allusers.getAllUsers()) {
            if (u.pseudo.equals(pseudodel)) {
                allusers.removeUser(u);
                System.out.println("The user " + u.pseudo + " has been delete");
                wasfound = true;
                break;
            }
        }
        if (!wasfound){
            System.out.println("This user wasnt found");

        }
    }

    @Override
    public void Promote(AllUsers allUsers) {
        Scanner sc = new Scanner(System.in);
        for (User u : allUsers.getAllUsers()) {
            if (!(u instanceof Customer)) {
                System.out.println(u.pseudo + u.role);
            }
        }

        boolean Userfound = true;

        User toBePromoted = new User();
        while (Userfound) {
            User newuser = null;
            System.out.println("Who do you want to promote ? ");
            String pseudoPromote = sc.nextLine();
            for (User u : allUsers.getAllUsers()) {
                if (u.getPseudo().equalsIgnoreCase(pseudoPromote)) {
                    toBePromoted = u;
                    Userfound = false;
                    break;
                }
            }

            if (Userfound) {
                System.out.println("User not found. Try again.");
            }
        }

        System.out.println("Wich role do you want to chose ? ");
        String categoryPromote = sc.nextLine();
        User newuser = new  User();
        switch (categoryPromote){
            case "Doctor":
                newuser = new Doctor(toBePromoted.pseudo, toBePromoted.mdp, categoryPromote);
                break;
            case "Manager":
                newuser = new Manager(toBePromoted.pseudo, toBePromoted.mdp, categoryPromote);
                break;
            case "Admin":
                newuser = new Admin(toBePromoted.pseudo, toBePromoted.mdp, categoryPromote);
                break;
            case "Customer":
                newuser = new Customer(toBePromoted.pseudo, toBePromoted.mdp, categoryPromote);
                break;
        }

        allUsers.removeUser(toBePromoted);
        allUsers.addUser(newuser);

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
