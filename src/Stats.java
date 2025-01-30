package src;

import java.io.*;
import java.util.ArrayList ;

public class Stats implements Serializable{
    double CA;
    ArrayList<Product> soldProducts = new ArrayList<Product>();
    public Stats() {
     }
    @Override
    public void Serialize() {

        File fichier =  new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\Stats.txt") ;
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
}
