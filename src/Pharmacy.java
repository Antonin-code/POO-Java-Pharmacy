package src;

public class Pharmacy {
    String name = "myPharmacy";
    String address = "17 rue Bel Air, Tombouctou";
    Stock stock = new Stock();

    public HistoricOrder getHistoricOrder() {
        return historicOrder;
    }

    public void setHistoricOrder(HistoricOrder historicOrder) {
        this.historicOrder = historicOrder;
    }

    HistoricOrder historicOrder = new HistoricOrder();
    public Pharmacy() {
        stock = new Stock();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
