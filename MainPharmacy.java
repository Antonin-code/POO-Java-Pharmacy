import src.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainPharmacy {
    public static void main(String[] args) throws IOException {
        Stock stock = new Stock();
        ArrayList<Product> legendes = new ArrayList<Product>();
        ArrayList<Product> listProductCommande = new ArrayList<>();
        ArrayList<Order> HistoricOrder = new ArrayList<>();
        AllUsers allusers = new AllUsers();
        Product bd = new Product("bdd", 23.3F, 4, "Lebandant");
        Product bd1 = new Product("bdd2", 3.3F, 34, "Lebandant");
        Product bd2 = new Product("bdd1", 2.3F, 455, "Lebandant");
        bd.AddProduct(stock);
        bd2.AddProduct(stock);
        bd1.AddProduct(stock);
        ArrayList<Order> listOrder = new ArrayList<>();
        boolean connected = true;
        Admin Pierre = new Admin("Pierre", "pierreAdmin", "Admin");
        Customer Sylvain = new Customer("Sylvain", "sylvainlebg", "Customer");
        Doctor Steph = new Doctor("Steph", "stephlebg", "Doctor");
        Customer Invite = new Customer("invite", "", "Customer");
        allusers.addUser(Pierre);
        allusers.addUser(Sylvain);
        allusers.addUser(Steph);
        allusers.addUser(Invite);
        User user1 = null;
        HistoricOrder historicOrder = new HistoricOrder();
        Product bd3 = new Product("bdd", 23.3F, 2, "Lebandant");
        Product bd4 = new Product("bdd2", 3.3F, 4, "Lebandant");
        Product bd5 = new Product("bdd1", 2.3F, 5, "Lebandant");
        Order ordertmp = new Order();
        bd3.AddProduct(ordertmp);
        bd4.AddProduct(ordertmp);
        bd5.AddProduct(ordertmp);
        historicOrder.AddOrder(ordertmp);

        historicOrder.Serialize();
        Stats stats = new Stats();

      //  stats.GetStats(historicOrder);

        bd.AddProduct(stock);
        bd2.AddProduct(stock);
        bd1.AddProduct(stock);

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
                for (User user : allusers.getAllUsers()) {
                    if (user.getPseudo().equals(pseudo)) {
                        System.out.println("This pseudo already exists");
                        useralreadyexist = true;
                    }
                }
                if (!useralreadyexist) {
                    user1 = new Customer(pseudo, mdp, "Customer");
                    allusers.addUser(user1);
                    currentlyconnecting = false;
                }
            } else if (choix.equals("2")) {
                System.out.println("Enter 'invite' to log in as a guest.");
                System.out.println("Enter you're pseudo:");
                String pseudo = sc.nextLine();
                if (pseudo.equalsIgnoreCase("invite")) {
                    user1 = Invite;
                    currentlyconnecting = false;
                } else {
                    System.out.println("Enter you're password:");
                    String mdp = sc.nextLine();
                    for (User user : allusers.getAllUsers()) {
                        if (user.getPseudo().equals(pseudo) && user.getMdp().equals(mdp)) {
                            System.out.println("Connected !!");
                            currentlyconnecting = false;
                            System.out.println(user.getPseudo());
                            user1 = user;
                        }
                    }
                }
            }
        }


        if (user1 instanceof Admin) {
            boolean finishsession = true;
            while (finishsession) {
                String answer;
                while (true) {
                    System.out.println("1. Delete user");
                    System.out.println("2. Promote or Distute");
                    System.out.println("3. Search product");
                    System.out.println("4. Logout");
                    answer = sc.nextLine();
                    if (answer.equals("1")) {
                        break;
                    } else if (answer.equals("2")) {
                        break;
                    } else if (answer.equals("3")) {
                        break;
                    } else if (answer.equals("4")) {
                        break;
                    } else {
                        System.out.println("Select a menu with its number");
                    }
                }
                String chose = answer;

                if (chose.equals("1")) {
                    ((Admin) user1).DelUser(allusers);
                    for (User user : allusers.getAllUsers()) {
                        System.out.println(user);
                        System.out.println(user.getPseudo());

                    }
                }
                if (chose.equals("2")) {
                    ((Admin) user1).Promote(allusers, user1);
                    for (User user : allusers.getAllUsers()) {
                        System.out.println(user.getPseudo() + user.getRole());
                    }
                }
                if(chose.equals("3")){
                    stock.sort();
                    while (true) {
                        System.out.println("Enter the name of the medicament that you want to search : ");
                        String word = sc.nextLine();

                        Product elmnt = stock.recherche(word);
                        if (elmnt != null) {
                            System.out.println("nom : " + elmnt.getName() + " | prix : " + elmnt.getPrice() + " | quantité : " + elmnt.getQuantity() + " | catégorie : " + elmnt.getCategory());
                        } else {
                            System.out.println("We couldn't find such product");
                        }
                        String answers = CheckYesOrNo(sc, "Do you want to search for another product? (yes/no)");
                        if (answers.equalsIgnoreCase("no")) {
                            break;
                        }
                    }
                }
                if (chose.equals("4")) {
                    finishsession = false;
                }
            }
        } else if (user1 instanceof Customer) {
            boolean finishsession = true;
            while (finishsession) {
                String answer;
                while (true) {
                    System.out.println("1. Command");
                    System.out.println("2. Search product");
                    System.out.println("3. Logout");

                    answer = sc.nextLine();
                    if (answer.equals("1")) {
                        break;
                    } else if (answer.equals("2")) {
                        break;
                    } else if (answer.equals("3")) {
                        break;
                    } else {
                        System.out.println("Select a menu with its number");
                    }
                }
                String chose = answer;
                if (chose.equals("1")) {
                    MakeOrder(historicOrder, stock.getAllproduct());
                } else if (chose.equals("2")) {
                    stock.sort();
                    while (true) {
                        System.out.println("Enter the name of the medicament that you want to search : ");
                        String word = sc.nextLine();

                        Product elmnt = stock.recherche(word);
                        if (elmnt != null) {
                            System.out.println("nom : " + elmnt.getName() + " | prix : " + elmnt.getPrice() + " | quantité : " + elmnt.getQuantity() + " | catégorie : " + elmnt.getCategory());
                        } else {
                            System.out.println("We couldn't find such product");
                        }
                        String answers = CheckYesOrNo(sc, "Do you want to search for another product? (yes/no)");
                        if (answers.equalsIgnoreCase("no")) {
                            break;
                        }
                    }
                } else if (chose.equals("3")) {
                    finishsession = false;
                }
            }
        } else if (user1 instanceof Doctor) {
            boolean finishsession = true;
            while (finishsession) {
                String answer;
                while (true) {
                    System.out.println("1. Add a product");
                    System.out.println("2. Search product");
                    System.out.println("3. Logout");
                    answer = sc.nextLine();
                    if (answer.equals("1")) {
                        break;
                    } else if (answer.equals("2")) {
                        break;
                    } else {
                        System.out.println("Select a menu with its number");
                    }
                }
                String choose = answer;


                if (choose.equals("1")) {
                    ((Doctor) user1).AddProduct(stock.getAllproduct());
                }
                if(choose.equals("2")){
                    stock.sort();
                    while (true) {
                        System.out.println("Enter the name of the medicament that you want to search : ");
                        String word = sc.nextLine();

                        Product elmnt = stock.recherche(word);
                        if (elmnt != null) {
                            System.out.println("nom : " + elmnt.getName() + " | prix : " + elmnt.getPrice() + " | quantité : " + elmnt.getQuantity() + " | catégorie : " + elmnt.getCategory());
                        } else {
                            System.out.println("We couldn't find such product");
                        }
                        String answers = CheckYesOrNo(sc, "Do you want to search for another product? (yes/no)");
                        if (answers.equalsIgnoreCase("no")) {
                            break;
                        }
                    }
                }
                if (choose.equals("3")) {
                    finishsession = false;
                    connected = false;
                }
            }
        } else if (user1 instanceof Manager) {
            boolean finishsession = true;
            while (finishsession) {
                String answer;
                while (true) {
                    System.out.println("1. Delete user ");
                    System.out.println("2. Add a product");
                    System.out.println("3. Promote");
                    System.out.println("4. Search product");
                    System.out.println("5. Logout");
                    answer = sc.nextLine();
                    if (answer.equals("1")) {
                        break;
                    } else if (answer.equals("2")) {
                        break;
                    } else if (answer.equals("3")) {
                        break;
                    } else if (answer.equals("4")) {
                        break;
                    } else if (answer.equals("5")) {
                        break;
                    } else {
                        System.out.println("Select a menu with its number");
                    }
                }
                String choose = answer;

                if (choose.equals("1")) {
                    ((Admin) user1).DelUser(allusers);
                    for (User user : allusers.getAllUsers()) {
                        System.out.println(user);
                        System.out.println(user.getPseudo());
                    }
                }
                if (choose.equals("2")) {
                    ((Doctor) user1).AddProduct(stock.getAllproduct());
                }
                if (choose.equals("3")) {
                    ((Admin) user1).Promote(allusers, user1);
                    for (User user : allusers.getAllUsers()) {
                        System.out.println(user.getPseudo() +""+ user.getRole());
                    }
                }
                if (choose.equals("4")){
                    stock.sort();
                    while (true) {
                        System.out.println("Enter the name of the medicament that you want to search : ");
                        String word = sc.nextLine();

                        Product elmnt = stock.recherche(word);
                        if (elmnt != null) {
                            System.out.println("nom : " + elmnt.getName() + " | prix : " + elmnt.getPrice() + " | quantité : " + elmnt.getQuantity() + " | catégorie : " + elmnt.getCategory());
                        } else {
                            System.out.println("We couldn't find such product");
                        }
                        String answers = CheckYesOrNo(sc, "Do you want to search for another product? (yes/no)");
                        if (answers.equalsIgnoreCase("no")) {
                            break;
                        }
                    }
                }
                if (choose.equals("5")){
                    finishsession = false;
                }
            }
        }


        stock = new Stock();
        Pharmacy pharmacy = new Pharmacy();
        // pharmacy.stock.alize();
        // add of product in the array

        for (Product elmnt : stock.sort()) {
            if (elmnt.getQuantity() == 0) {
                System.out.println("Name : " + elmnt.getName() + " : Out of stock");
            } else {
                System.out.println("Name : " + elmnt.getName() + " | Price : " + elmnt.getPrice() + " | Quantity : " + elmnt.getQuantity() + " | Category : " + elmnt.getCategory());
            }
        }

        System.out.println("_________");

        for (Product elmnt : stock.sortByQuantity()) {
            if (elmnt.getQuantity() == 0) {
                System.out.println("Name : " + elmnt.getName() + " : Out of stock");
            } else {
                System.out.println("Name : " + elmnt.getName() + " | Price : " + elmnt.getPrice() + " | Quantity : " + elmnt.getQuantity() + " | Category : " + elmnt.getCategory());
                if (elmnt.getQuantity() < 5) {
                    System.out.println(elmnt.getName() + " need a restock");
                }
            }
        }


//        Product bd3 = new Product("bdd", 23.3F, 2, "Lebandant");
//        Product bd4 = new Product("bdd2", 3.3F, 4, "Lebandant");
//        Product bd5 = new Product("bdd1", 2.3F, 5, "Lebandant");
//        Order ordertmp = new Order();
//        bd3.AddProduct(ordertmp.listProducts);
//        bd4.AddProduct(ordertmp.listProducts);
//        bd5.AddProduct(ordertmp.listProducts);
//         historicOrder.allOrders.add(ordertmp);


        historicOrder.Serialize();
        SeePurchases(historicOrder);
        stats.GetStats(historicOrder);


    }

    public static void SeePurchases(HistoricOrder historicOrder) throws IOException {
        // pharmacy.stock.Serialize();
        System.out.println("Do you want to see purchases ? ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            for (Order order : historicOrder.getAllOrders()) {
                for (Product elmnt : order.getListProducts()) {

                    if (elmnt.getQuantity() == 0) {
                        System.out.println("Name : " + elmnt.getName() + " : Out of stock");
                    } else {
                        System.out.println("Name : " + elmnt.getName() + " | Price : " + elmnt.getPrice() + " | Quantity : " + elmnt.getQuantity() + " | Category : " + elmnt.getCategory());
                        if (elmnt.getQuantity() < 5) {
                            System.out.println(elmnt.getName() + "Need a restock");
                        }
                    }
                }
            }
            System.out.println(historicOrder.getAllOrders());
        }
    }

    public static void MakeOrder(HistoricOrder historicOrder, ArrayList<Product> productsInStock) throws IOException {
        boolean wanttobuy = true;

        while (wanttobuy) {
            System.out.println("Do you want to buy some products?");
            Scanner in = new Scanner(System.in);
            if (in.nextLine().equalsIgnoreCase("yes")) {
                Order order = new Order();

                while (true) {

                    System.out.println("Enter product name: ");
                    String tmp = in.nextLine();
                    boolean found = false;
                    for (Product p : productsInStock) {
                        if (p.getName().equalsIgnoreCase(tmp) && p.getQuantity() > 0) {
                            boolean alreadyOrdered = false;
                            for (Product p1 : order.getListProducts()) {
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

                                                order.getListProducts().add(new Product(tmp, p.getPrice(), inttmp, p.getCategory()));
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
                            for (Product p : order.getListProducts()) {
                                for (Product p2 : productsInStock) {
                                    if (p.getName().equalsIgnoreCase(p2.getName())) {
                                        p2.setQuantity(p2.getQuantity() - p.getQuantity());
                                        System.out.println("Actually its remains :" + p2.getQuantity() + " " + p2.getName());
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
                        order.setHour(java.time.LocalTime.now().toString());
                        order.setDate(java.time.LocalDate.now().toString());
                        historicOrder.getAllOrders().addFirst(order);
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
        for (Order o : historicOrder.getAllOrders()) {
            System.out.println(o.getHour() + " " + o.getHour());
            for (Product p : o.getListProducts()) {
                System.out.println(p.getQuantity() + " " + p.getName());

            }

        }

    }

    public static String CheckYesOrNo(Scanner sc, String msg) {

        String answer;
        while (true) {
            System.out.println(msg);
            answer = sc.nextLine();
            if (answer.equalsIgnoreCase("no")) {
                return answer;
            } else if (answer.equalsIgnoreCase("yes")) {
                return answer;
            } else {
                System.out.println("Answer by yes or no.");
            }
        }
    }
}
