package src;

import java.io.*;
import java.util.ArrayList ;

public class Stats implements Serializable{
    double CA;
    ArrayList<Product> soldProducts = new ArrayList<Product>();
    public Stats() {
     }

    public ArrayList<Product> sortByQuantity() {
        int n = soldProducts.size();
        for (int i = 1; i < n; i++) {
            Product key = soldProducts.get(i);
            int j = i - 1;

            while (j >= 0 && soldProducts.get(j).getQuantity() > key.getQuantity()) {
                soldProducts.set(j + 1, soldProducts.get(j));
                j--;
            }

            soldProducts.set(j + 1, key);
        }
        return soldProducts;
    }

    @Override
    public void Serialize() {

        File fichier =  new File("C:\\Users\\"+System.getProperty("user.name")+"\\OneDrive\\Bureau\\Stats.txt") ;
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fichier));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // création d'un objet à sérializer

        // sérialization de l'objet
        try {
            oos.writeObject(this.soldProducts) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // fermeture du flux dans le bloc finally


    }

    @Override
    public void Deserialize() {


// dans une méthode main
        // on simplifie le code en retirant la gestion des exceptions
        File fichier =  new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Stats.txt") ;

        // ouverture d'un flux sur un fichier
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichier));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // désérialization de l'objet
        try {
            this.soldProducts = (ArrayList<Product>) ois.readObject() ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // fermeture du flux dans le bloc finally


    }

    public void GetStats (HistoricOrder historicOrder){
        for (Order orderH : historicOrder.allOrders) {
            for (Product productH : orderH.listProducts){
                boolean alreadyInStats = false;
                for (Product productS : this.soldProducts){
                    if (productS.getName().equals(productH.getName())){
                        productS.setQuantity(productS.getQuantity() + productH.getQuantity());
                        alreadyInStats = true;
                        break;
                    }

                }
                if (!alreadyInStats) {
                    this.soldProducts.add(productH);
                }
            }
        }
        double CA = 0;
        for (Product productS : this.soldProducts){
            CA += productS.getQuantity() * productS.getPrice();
        }
        System.out.println("le produit le plus vendu est :" + this.soldProducts.getLast().getName());
        System.out.println(CA);
        System.out.println();
        this.sortByQuantity();
        for (int i = this.soldProducts.size()-1; i >= 0 ; i--){
            System.out.println("nom : " + this.soldProducts.get(i).getName() + " | prix : " + this.soldProducts.get(i).getPrice() + " | quantité : " + this.soldProducts.get(i).getQuantity() + " | catégorie : " + this.soldProducts.get(i).getCategory());
        }
}

}
