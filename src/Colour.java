public class Colour {
    private int id;
    private String colour;

    public Colour() {}

    public Colour(int id, String colour) {
        this.id = id;
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return colour;
    }
}
