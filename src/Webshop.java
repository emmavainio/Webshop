
import java.util.List;
import java.util.Scanner;

public class Webshop {

    final Repository repository = new Repository();
    final Scanner sc = new Scanner(System.in);

    public boolean isCorrectCredentials(String username, String password) {
        return repository.getCustomerList().stream().anyMatch(c -> c.getUsername().equalsIgnoreCase(username) &&
                c.getPassword().equalsIgnoreCase(password));
    }
    public List<Product> getAllAvailableProducts() {
        return repository.getProductList().stream().filter(p -> p.getInventory().getAmount() > 0).toList();
    }
    public Product getProduct(String brand, String model, String colour, String size) {
        return getAllAvailableProducts().stream().filter(p -> p.getBrand().getBrand().equalsIgnoreCase(brand) &&
                p.getModel().equalsIgnoreCase(model) && p.getColour().getColour().equalsIgnoreCase(colour) &&
                p.getSize().getSize().equalsIgnoreCase(size)).toList().get(0);
    }
    public boolean isAvailableProduct(String brand, String model, String colour, String size) {
        return repository.getProductList().stream().anyMatch(p ->
                p.getInventory().getAmount() > 0 &&
                p.getBrand().getBrand().equalsIgnoreCase(brand) &&
                p.getModel().equalsIgnoreCase(model) &&
                p.getColour().getColour().equalsIgnoreCase(colour) &&
                p.getSize().getSize().equalsIgnoreCase(size));
    }
    public int getCustomerId (String username) {
        return repository.getCustomerList().stream().filter(p -> p.getUsername().
                equalsIgnoreCase(username)).toList().get(0).getId();
    }

    public Webshop() {

        String username;
        while (true) {
            System.out.println("Welcome to the shoe shop!");

            System.out.print("Enter your username: ");
            username = sc.nextLine().trim();
            System.out.print("Enter your password: ");
            final String password = sc.nextLine().trim();

            if (isCorrectCredentials(username,password)) {
                System.out.println("Login successful!");
                System.out.println();
                break;
            }
            else
                System.out.println("Incorrect credentials, try again!");
        }
        System.out.println("Available products:");
        getAllAvailableProducts().forEach(System.out::println);

        while (true) {
            System.out.println("Enter information for the shoe you want to purchase:");
            System.out.print("Brand: ");
            final String brand = sc.nextLine().trim();
            System.out.print("Model: ");
            final String model = sc.nextLine().trim();
            System.out.print("Colour: ");
            final String colour = sc.nextLine().trim();
            System.out.print("Size: ");
            final String size = sc.nextLine().trim();

            if (isAvailableProduct(brand, model, colour, size)) {
                int productId = getProduct(brand, model, colour, size).getId();
                int customerId = getCustomerId(username);
                repository.addToCart(customerId,productId);
                break;
            }
            else
                System.out.println("The product does not exist or is out of stock");
        }
    }
    public static void main(String[] args) {
        new Webshop();
    }
}