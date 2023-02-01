public class Product {
    private int id;
    private double price;
    private String productName;
    private int brandId;
    private int colourId;

    public Product(){}

    public Product(int id, double price, String productName, int brandId, int colourId) {
        this.id = id;
        this.price = price;
        this.productName = productName;
        this.brandId = brandId;
        this.colourId = colourId;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    @Override
    public String toString() {
        return productName;
    }
}
