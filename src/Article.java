public class Article {
    private int id;
    private int productId;
    private int sizeId;
    private int inventoryId;

    public Article() {}

    public Article(int id, int productId, int sizeId, int inventoryId) {
        this.id = id;
        this.productId = productId;
        this.sizeId = sizeId;
        this.inventoryId = inventoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }
}
