package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPharmacy {
    public static void main(String[] args) {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.stock.category.add(new Category("Creme", "anti-irritant", new ArrayList<Product>()));
        Category cattmp = pharmacy.stock.category.getFirst();

        Product bd = new Product("bdd", 23.3F, 4);
        Product bd1 = new Product("bdd2", 3.3F, 34);
        Product bd2 = new Product("bdd1", 2.3F, 455);
        bd.AddProduct(cattmp.products);
        bd2.AddProduct(cattmp.products);
        bd1.AddProduct(cattmp.products);
        List<Order> listOrder = new ArrayList<>();
        boolean wanttobuy = true;
        while (wanttobuy) {
            System.out.println("Do you want to buy some products?");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if (input.equalsIgnoreCase("yes")) {
                while (true) {

                    Order order = new Order();
                    System.out.println("Enter product name: ");
                    String tmp = in.nextLine();
                    for (Product p : cattmp.products) {
                        if (p.getName().equalsIgnoreCase(tmp)) {
                            while (true) {

                                System.out.println("Enter the quantity: ");
                                try {
                                    int inttmp = in.nextInt();
                                    order.listProducts.add(new Product(tmp, p.getPrice(), inttmp));
                                    System.out.println("Successfully bought!");
                                    break;
                                } catch (Exception _) {
                                }
                            }
                            break;
                        }
                    }

                        String st = in.nextLine();
                        boolean flag = false;
                        while (!flag) {
                            System.out.println("Do you want to still want to buy some products?");
                            st = in.nextLine();
                            if (st.equalsIgnoreCase("no")) {
                                System.out.println("See you soon!");
                                flag = true;
                            } else if (!st.equalsIgnoreCase("yes")) {
                                System.out.println("Answer by yes or no.");
                            }
                            else {
                                flag = true;
                            }
                        }
                        if (st.equalsIgnoreCase("no")) {
                            wanttobuy = false;
                            break;
                        }

                }

            } else if (input.equalsIgnoreCase("no")) {

                break;
            } else {
                System.out.println("Answer by yes or no.");
            }
        }
        Order commande = new Order();

    }
}