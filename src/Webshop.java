import java.util.Map;
import java.util.Scanner;

public class Webshop {

    final Repository repository = new Repository();
    final Scanner sc = new Scanner(System.in);

    public boolean isCorrectCredentials(String username, String password) {
        return repository.getCustomerList().stream().anyMatch(c -> c.getUsername().equalsIgnoreCase(username) &&
                c.getPassword().equalsIgnoreCase(password));
    }

    public Webshop() {
        //prompta skriva in namn och lösen
        //kontrollera lösenord mot anv
        //prompta vilka produkter som finns
        //be anv skriva in vilken produkt som ska köpas

        while (true) {
            System.out.println("Welcome to the shoe shop!");

            System.out.print("Enter your username: ");
            final String username = sc.nextLine().trim();
            System.out.print("Enter your password: ");
            final String password = sc.nextLine().trim();

            if (isCorrectCredentials(username,password)) {
                System.out.println("Login successful!");
                break;
            }
            else
                System.out.println("Incorrect credentials");
        }


        System.out.println("Products to choose from:");
        System.out.println();
        //hittils ser allt bra ut

        //final List<Inventory> inventoryList = repository.getInventoryList();
        //inventoryList.forEach(e -> System.out.println(e.getCreated()));
        //Map<Integer, Inventory> inventoryMap = repository.getInventoryMap();
        //inventoryMap.forEach((k,v) -> System.out.println(v.getCreated()));
        //Map<Integer, Brand> brandMap = repository.getBrandMap();
        //brandMap.forEach((k, v) -> System.out.println(v));
        //Map<Integer, Category> catMap = repository.getCategoryMap();
        //catMap.forEach((k, v) -> System.out.println(v));
        //Map<Integer, City> cityMap = repository.getCityMap();
        //cityMap.forEach((k, v) -> System.out.println(v));
        //Map<Integer, Colour> colourMap = repository.getColourMap();
        //colourMap.forEach((k, v) -> System.out.println(v));
        Map<Integer, Customer> customerMap = repository.getCustomerMap();
        customerMap.forEach((k, v) -> System.out.println(v));
    }

    public static void main(String[] args) {
        new Webshop();
    }
}