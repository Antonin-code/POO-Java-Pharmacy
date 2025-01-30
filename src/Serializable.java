package src;

import java.io.*;

public interface Serializable {
    public void Serialize() throws IOException;
    public void Deserialize();
//    File fichier =  new File("tmp/register.ser") ;
//    ObjectOutputStream oos;
//
//    static {
//        try {
//            oos = new ObjectOutputStream(new FileOutputStream(fichier));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
