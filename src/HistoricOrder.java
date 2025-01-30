package src;

import java.io.*;
import java.util.ArrayList;

public class HistoricOrder implements Serializable {
    ArrayList<Order> allOrders;

    public HistoricOrder() {
        this.allOrders = new ArrayList<>();
    }


    @Override
    public void Serialize() throws IOException {
        File fichier =  new File("C:\\Users\\"+System.getProperty("user.name")+"\\OneDrive\\Bureau\\HistoricOrder.txt") ;
        fichier.createNewFile();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fichier));
        } catch (IOException e) {
            this.Serialize();
        }

        // création d'un objet à sérializer

        // sérialization de l'objet
        try {
            oos.writeObject(this.allOrders) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // fermeture du flux dans le bloc finally


    }

    @Override
    public void Deserialize() {


// dans une méthode main
        // on simplifie le code en retirant la gestion des exceptions
        File fichier =  new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\HistoricOrder.txt") ;

        // ouverture d'un flux sur un fichier
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichier));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // désérialization de l'objet
        try {
            this.allOrders = (ArrayList<Order>) ois.readObject() ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // fermeture du flux dans le bloc finally


    }
}
