package src;

import java.io.IOException;
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
    public static void main(String[] args) throws IOException{
        ArrayList<Product> legendes = new ArrayList<Product>();
        ArrayList<Product> listProductCommande = new ArrayList<>();
        ArrayList<Order> HistoricOrder = new ArrayList<>();
        AllUsers allusers = new AllUsers();
        Product bd = new Product("bdd", 23.3F, 4, "Lebandant");
        Product bd1 = new Product("bdd2", 3.3F, 34, "Lebandant");
        Product bd2 = new Product("bdd1", 2.3F, 455, "Lebandant");
        bd.AddProduct(legendes);
        bd2.AddProduct(legendes);
        bd1.AddProduct(legendes);
        ArrayList<Order> listOrder = new ArrayList<>();
        boolean connected = true;
        Admin Pierre = new Admin("Pierre", "pierreAdmin", "Admin");
        Customer Sylvain = new Customer("Sylvain", "sylvainlebg", "Customer");
        Doctor Steph = new Doctor("Steph", "stephlebg", "Doctor");
        Customer Invite = new Customer("invite","","Customer");
        allusers.addUser(Pierre);
        allusers.addUser(Sylvain);
        allusers.addUser(Steph);
        allusers.addUser(Invite);
        User user1 = null;

        Scanner sc = new Scanner(System.in);
        boolean currentlyconnecting = true;
        while (currentlyconnecting) {
            System.out.println("1. Sign in \n2. Login");
            String choix = sc.nextLine();
            if (choix.equals("1")) {
                System.out.println("Enter a pseudo:");
                String pseudo = sc.nextLine();
                System.out.println("Enter a password:");
                String mdp = sc.nextLine();
                boolean useralreadyexist = false;
                for (User user : allusers.AllUsers) {
                    if (user.pseudo.equals(pseudo)) {
                        System.out.println("This pseudo already exists");
                        useralreadyexist = true;
                    }
                }
                if (!useralreadyexist) {
                    user1 = new Customer(pseudo, mdp, "Customer");
                    allusers.AllUsers.add(user1);
                    currentlyconnecting = false;
                }
            } else if (choix.equals("2")) {
                System.out.println("Enter invite to log in as a guest.");
                System.out.println("Enter you're pseudo:");
                String pseudo = sc.nextLine();
                if (pseudo.equalsIgnoreCase("invite")){
                    user1 = Invite;
                    currentlyconnecting = false;
                }
                else {
                    System.out.println("Enter you're password:");
                    String mdp = sc.nextLine();
                    for (User user : allusers.AllUsers) {
                        if (user.pseudo.equals(pseudo) && user.mdp.equals(mdp)) {
                            System.out.println("Connected !!");
                            currentlyconnecting = false;
                            System.out.println(user.pseudo);
                            user1 = user;
                        }
                    }
                }
            }
        }

        while (connected) {
            if (user1 instanceof Admin) {
                System.out.println("1. Delete user");
                System.out.println("2. Promote or Distute");
                System.out.println("3. Logout");
                String chose = sc.nextLine();
                if (chose.equals("1")) {
                    ((Admin) user1).DelUser(allusers);
                    for (User user : allusers.getAllUsers()) {
                        System.out.println(user);
                        System.out.println(user.pseudo);

                    }
                }
                if (chose.equals("2")) {
                    ((Admin) user1).Promote(allusers);
                    for (User user : allusers.getAllUsers()) {
                        System.out.println(user.pseudo + user.role);
                    }
                }
                if (chose.equals("3")) {
                    connected = false;
                }

            } else if (user1 instanceof Customer) {
                System.out.println("1. Logout");
                String chose = sc.nextLine();

            } else if (user1 instanceof Doctor) {

                System.out.println("1. Add a product");
                System.out.println("2. Logout");
                String choose = sc.nextLine();
                if (choose.equals("1")) {
                    ((Doctor) user1).AddProduct(legendes);
                    for (Product elmnt : legendes) {
                        System.out.println(elmnt.name + elmnt.price);

                    }
                }
                if (choose.equals("2")) {
                    connected = false;
                }
            } else if (user1 instanceof Manager) {
                System.out.println("1. Delete user ");
                System.out.println("2. Add a product");
                System.out.println("3. Logout");
                String choose = sc.nextLine();
                if (choose.equals("1")) {
                    ((Admin) user1).DelUser(allusers);
                    for (User user : allusers.getAllUsers()) {
                        System.out.println(user);
                        System.out.println(user.pseudo);
                    }
                }
                if (choose.equals("2")) {
                    ((Doctor) user1).AddProduct(legendes);
                    for (Product elmnt : legendes) {
                        System.out.println(elmnt.name + elmnt.quantity);
                    }
                }
                if (choose.equals("3")) {
                    connected = false;
                }
            }

        }


        Stats stats = new Stats();
        Stock stock = new Stock();
        Pharmacy pharmacy = new Pharmacy();
        // pharmacy.stock.alize();
        // add of product in the array

        for (Product elmnt : stock.sort()) {
            if (elmnt.getQuantity() == 0) {
                System.out.println("nom : " + elmnt.getName() + " : Out of stock");
            } else {
                System.out.println("nom : " + elmnt.getName() + " | prix : " + elmnt.getPrice() + " | quantité : " + elmnt.getQuantity() + " | catégorie : " + elmnt.getCategory());
            }
        }

        System.out.println("_________");

        for (Product elmnt : stock.sortByQuantity()) {
            if (elmnt.getQuantity() == 0) {
                System.out.println("nom : " + elmnt.getName() + " : Out of stock");
            } else {
                System.out.println("nom : " + elmnt.getName() + " | prix : " + elmnt.getPrice() + " | quantité : " + elmnt.getQuantity() + " | catégorie : " + elmnt.getCategory());
                if (elmnt.getQuantity() < 5) {
                    System.out.println(elmnt.getName() + " à réaprovisioner");
                }
            }
        }

        stock.sort();
        while (true) {
            System.out.println("Saisissez le médicament que vous souhaitez rechercher : ");
            String word = sc.nextLine();

            Product elmnt = stock.recherche(word);
            if (elmnt != null) {
                System.out.println("nom : " + elmnt.getName() + " | prix : " + elmnt.getPrice() + " | quantité : " + elmnt.getQuantity() + " | catégorie : " + elmnt.getCategory());
            } else {
                System.out.println("We couldn't find such product");
            }
            String answer = CheckYesOrNo(sc, "Do you want to search for another product? (yes/no)");
            if (answer.equalsIgnoreCase("no")) {
                break;
            }
        }

        legendes = new ArrayList<Product>();
        HistoricOrder historicOrder = new HistoricOrder();
        Product bd3 = new Product("bdd", 23.3F, 2, "Lebandant");
        Product bd4 = new Product("bdd2", 3.3F, 4, "Lebandant");
        Product bd5 = new Product("bdd1", 2.3F, 5, "Lebandant");
        Order ordertmp = new Order();
        bd3.AddProduct(ordertmp.listProducts);
        bd4.AddProduct(ordertmp.listProducts);
        bd5.AddProduct(ordertmp.listProducts);
        historicOrder.allOrders.add(ordertmp);

        historicOrder.Serialize();
        stats.GetStats(historicOrder);

        bd.AddProduct(legendes);
        bd2.AddProduct(legendes);
        bd1.AddProduct(legendes);

//        Product bd3 = new Product("bdd", 23.3F, 2, "Lebandant");
//        Product bd4 = new Product("bdd2", 3.3F, 4, "Lebandant");
//        Product bd5 = new Product("bdd1", 2.3F, 5, "Lebandant");
//        Order ordertmp = new Order();
//        bd3.AddProduct(ordertmp.listProducts);
//        bd4.AddProduct(ordertmp.listProducts);
//        bd5.AddProduct(ordertmp.listProducts);
//         historicOrder.allOrders.add(ordertmp);


        historicOrder.Serialize();
        boolean wanttobuy = true;
        // pharmacy.stock.Serialize();
        System.out.println("Do you want to see purchases ? ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println(historicOrder.allOrders);
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
                        if (p.getName().equalsIgnoreCase(tmp) && p.getQuantity() > 0) {
                            boolean alreadyOrdered = false;
                            for (Product p1 : order.listProducts) {
                                if (p1.getName().equalsIgnoreCase(tmp)) {
                                    alreadyOrdered = true;
                                }
                            }
                            if (!alreadyOrdered) {

                                found = true;
                                while (true) {

                                    System.out.println("Enter the quantity: ");
                                    try {
                                        String testint = in.nextLine();
                                        boolean isint = true;
                                        for (int i = 0; i < testint.length(); i++) {
                                            if (!Character.isDigit(testint.charAt(i))) {
                                                isint = false;
                                                break;
                                            }
                                        }
                                        if (isint) {
                                            int inttmp = Integer.valueOf(testint);

                                            if (inttmp > 0 && inttmp <= p.getQuantity()) {

                                                order.listProducts.add(new Product(tmp, p.getPrice(), inttmp, p.getCategory()));
                                                if (p.getQuantity() < 5) {
                                                    System.out.println("The product is lower than 5!");
                                                }
                                                System.out.println("Successfully bought!");
                                                break;
                                            } else {
                                                System.out.println("You cant buy the quantity you asked !");
                                            }
                                        } else {
                                            System.out.println("Enter a number");
                                        }

                                    } catch (Exception e) {
                                    }
                                }
                                break;
                            } else {
                                System.out.println("You already have this product");
                                found = true;
                            }
                        }
                    }
                    if (!found) {
                        System.out.println("Sorry the product doesn't exist !");
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
                                        System.out.println("Il reste actuellement :" + p2.quantity + " " + p2.getName());
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
                        historicOrder.allOrders.addFirst(order);
                        historicOrder.Serialize();
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
        for (Order o : historicOrder.allOrders) {
            System.out.println(o.Hour + " " + o.Date);
            for (Product p : o.listProducts) {
                System.out.println(p.quantity + " " + p.name);

            }

        }


    }
    public static String CheckYesOrNo(Scanner sc,String msg) {

        String answer;
        while (true) {
            System.out.println(msg);
            answer = sc.nextLine();
            if (answer.equalsIgnoreCase("no")) {
                return answer;
            }
            else if (answer.equalsIgnoreCase("yes")) {
                return answer;
            }
            else {
                System.out.println("Answer by yes or no.");
            }
        }
    }
}
