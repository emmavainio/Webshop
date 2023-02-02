public class Product {
    private int id;
    private double price;
    private String model;
    private int brandId;
    private int colourId;
    private int sizeId;
    private int inventoryId;

    public Product(){}

    public Product(int id, double price, String model, int brandId, int colourId, int sizeId, int inventoryId) {
        this.id = id;
        this.price = price;
        this.model = model;
        this.brandId = brandId;
        this.colourId = colourId;
        this.sizeId = sizeId;
        this.inventoryId = inventoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getColourId() {
        return colourId;
    }

    public void setColourId(int colourId) {
        this.colourId = colourId;
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

    @Override
    public String toString() {
        return model + " price: " + price;
    }
}
