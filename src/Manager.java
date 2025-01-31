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

        //Select the user to delete
        System.out.println("Who do you want to delete ?:");
        String pseudodel = sc.nextLine();
        boolean wasfound = false;
        //Search for him in the list of users
        for (User u : allusers.getAllUsers()) {
            if (u.pseudo.equals(pseudodel)) {
                //if found, remove it and tell the connected user about it

                allusers.removeUser(u);
                System.out.println("The user " + u.pseudo + " has been delete");
                wasfound = true;
                break;
            }
        }
        if (!wasfound){
            System.out.println("This user wasn't found");

        }
    }


    @Override
    public void Promote(AllUsers allUsers, User user1) {
        Scanner sc = new Scanner(System.in);
        //Select a User to Promote
        for (User u : allUsers.getAllUsers()) {

            System.out.println(u.pseudo + u.role);
        }

        boolean Userfound = true;

        User toBePromoted = new User();
        while (Userfound) {
            User newuser = null;
            System.out.println("Who do you want to promote ? ");
            String pseudoPromote = sc.nextLine();
            if(pseudoPromote.equals(user1.pseudo)){
                System.out.println("You cannot delete yourself.");
                continue;
            }
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
        newProduct =  new Product(nameproduct,prix,quantity,category);


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
