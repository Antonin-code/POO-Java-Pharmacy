package src;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Order implements Serializable{
    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getHour() {
        return Hour;
    }

    public void setHour(String hour) {
        Hour = hour;
    }

    ArrayList<Product> listProducts = new ArrayList<>();
    public Order(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }
    public Order() {

    }


    String Date = new String();
    String Hour = new String();

}

