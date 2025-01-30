package src;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Order {
    ArrayList<Product> listProducts = new ArrayList<>();
    public Order(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }
    public Order() {

    }


    String Date = new String();
    String Hour = new String();

}

