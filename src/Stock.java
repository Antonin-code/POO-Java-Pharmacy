package src;

import java.util.*;

public class Stock {
    List<Product> allproduct;

    public Stock() {
        this.allproduct = new ArrayList<>();
    }

    public void addProduct(Product product) {
        allproduct.add(product);
    }

    public List<Product> sort() {
        allproduct.sort(Comparator.comparing(Product::getName));
        return allproduct;
    }

    public void display() {
        System.out.println("Liste des produits en stock :");
        for (Product elmnt : allproduct) {
            System.out.println("nom : " + elmnt.getName() + " | prix : " + elmnt.getPrice() + " | quantité : " + elmnt.getQuantity() + " | catégorie : " + elmnt.getCategory() );
        }
    }


    public List<Product> sortByQuantity() {
        int n = allproduct.size();
        for (int i = 1; i < n; i++) {
            Product key = allproduct.get(i);
            int j = i - 1;

            while (j >= 0 && allproduct.get(j).getQuantity() > key.getQuantity()) {
                allproduct.set(j + 1, allproduct.get(j));
                j--;
            }

            allproduct.set(j + 1, key);
        }
        return allproduct;
    }

//    public List<Product> sortByQuantity() {
//        int n = allproduct.size();
//        List<Product> result = new ArrayList<>(n);
//        for (int i = 1; i < n; i++) {
//            Product key = allproduct.get(i);
//            int j = 0;
//            while (j < result.size() && result.get(j).getQuantity() < key.getQuantity()) {
//                j++;
//            }
//            result.add(j , key);
//        }
//        return result;
//    }

    public static int compareStrings(String word1, String word2) {
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            if ((int) word1.charAt(i) != (int) word2.charAt(i))
                return (int) word1.charAt(i) - (int) word2.charAt(i);
        }
        if (word1.length()
                != word2.length())
            return word1.length() - word2.length();
        else
            return 0;
    }

    public Product recherche(String name) {
        int left = 0;
        int right = allproduct.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            String currentName = allproduct.get(middle).getName();

            int comparison = compareStrings(currentName, name);

            if (comparison == 0) {
                // Trouvé, retourne l'élément
                return allproduct.get(middle);
            } else if (comparison < 0) {

                left = middle + 1;
            } else {

                right = middle - 1;
            }
        }
        // Si l'élément n'est pas trouvé
        return null; // Vous pouvez gérer l'absence d'élément différemment
    }

}