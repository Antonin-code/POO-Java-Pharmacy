package src;

import com.sun.jdi.connect.Connector;

import java.util.List;
import java.util.Scanner;

public class Admin extends User implements InterfaceAdmin {
    public Admin(String pseudo, String mdp, String role) {
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
}