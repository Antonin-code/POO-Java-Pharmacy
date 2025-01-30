package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MainPharmacy {
    public static void main(String[] args) {
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
                    for (Product p : legendes) {
                        if (p.getName().equalsIgnoreCase(tmp)) {
                            while (true) {

                                System.out.println("Enter the quantity: ");
                                try {
                                    int inttmp = in.nextInt();
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
                                } catch (Exception _) {
                                }
                            }
                            break;
                        } else {
                            System.out.println("Sorry the product do not exist ! ");
                        }
                    }

                    String st = in.nextLine();
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