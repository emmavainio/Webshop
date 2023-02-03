import java.sql.Timestamp;

public class Inventory {
    private int id;
    private int amount;
    private Timestamp created;
    private Timestamp lastUpdate;

    public Inventory() {}

    public Inventory(int id, int amount, Timestamp created, Timestamp lastUpdate) {
        this.id = id;
        this.amount = amount;
        this.created = created;
        this.lastUpdate = lastUpdate;
    }

    public Inventory(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
