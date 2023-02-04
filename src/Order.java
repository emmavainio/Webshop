import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private Timestamp purchaseDate;
    private Customer customer;
    private List<Product> orderedProducts = new ArrayList<>();
    public Order() {}

    public Order(int id, Timestamp purchaseDate, Customer customer, List<Product> orderedProducts) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.customer = customer;
        this.orderedProducts = orderedProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<Product> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }
}
