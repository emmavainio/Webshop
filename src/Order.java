import java.sql.Timestamp;

public class Order {
    private int id;
    private Timestamp purchaseDate;
    private int customerId;

    public Order() {}

    public Order(int id, Timestamp purchaseDate, int customerId) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.customerId = customerId;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
