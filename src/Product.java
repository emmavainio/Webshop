public class Product {
    private int id;
    private double price;
    private String model;
    private Brand brand;
    private Colour colour;
    private Size size;
    private Inventory inventory;

    public Product(){}

    public Product(int id, double price, String model, Brand brand, Colour colour, Size size, Inventory inventory) {
        this.id = id;
        this.price = price;
        this.model = model;
        this.brand = brand;
        this.colour = colour;
        this.size = size;
        this.inventory = inventory;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Brand: " + brand.getBrand() + " | Model: " + model + " | Colour: " + colour.getColour()
                + " | Size: " + size.getSize() + " | Price: " + price;
    }
}
