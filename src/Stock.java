package src;

import java.io.*;
import java.util.*;

public class Stock implements Serializable{
    //ArrayList<Product> allproduct;
    ArrayList<Product> allproduct;

    public Stock() {
        this.allproduct = new ArrayList<>();
    }

    public void addProduct(Product product) {
        allproduct.add(product);
    }

    public ArrayList<Product> sort() {
        allproduct.sort(Comparator.comparing(Product::getName));
        return allproduct;
    }

    public void display() {
        System.out.println("Liste des produits en stock :");
        for (Product elmnt : allproduct) {
            System.out.println("nom : " + elmnt.getName() + " | prix : " + elmnt.getPrice() + " | quantité : " + elmnt.getQuantity() + " | catégorie : " + elmnt.getCategory() );
        }
    }


    public ArrayList<Product> sortByQuantity() {
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

//    public ArrayList<Product> sortByQuantity() {
//        int n = allproduct.size();
//        ArrayList<Product> result = new ArrayList<>(n);
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
    @Override
    public void Serialize() {


// dans une méthode main
        // on simplifie le code en retirant la gestion des exceptions
        File fichier =  new File("C:\\Users\\"+System.getProperty("user.name")+"\\OneDrive\\Bureau\\Stock.txt") ;

        // ouverture d'un flux sur un fichier
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fichier));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // création d'un objet à sérializer

        // sérialization de l'objet
        try {
            oos.writeObject(this.allproduct) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // fermeture du flux dans le bloc finally


    }

    @Override
    public void Deserialize() {


// dans une méthode main
        // on simplifie le code en retirant la gestion des exceptions
        File fichier =  new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Stock.txt") ;

        // ouverture d'un flux sur un fichier
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichier));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // désérialization de l'objet
        try {
                this.allproduct = (ArrayList<Product>)ois.readObject() ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // fermeture du flux dans le bloc finally


    }


}

