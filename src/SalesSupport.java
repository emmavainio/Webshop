import java.util.Scanner;
import java.util.stream.Collectors;

public class SalesSupport {

    final Repository repository = new Repository();
    final Scanner sc = new Scanner(System.in);

    OrderReportInterface sizeReport = (o, wordToSearch) -> o.getOrderedProducts().stream().anyMatch
            (product -> product.getSize().getSize().equalsIgnoreCase(wordToSearch));

    OrderReportInterface colourReport = (o, wordToSearch) -> o.getOrderedProducts().stream().anyMatch
            (product -> product.getColour().getColour().equalsIgnoreCase(wordToSearch));

    OrderReportInterface brandReport = (o, wordToSearch) -> o.getOrderedProducts().stream().anyMatch
            (product -> product.getBrand().getBrand().equalsIgnoreCase(wordToSearch));


    public void printSizeColourBrandReport(String wordToSearchFor, OrderReportInterface reportType){
        repository.getOrderList().stream().filter(o -> reportType.search(o, wordToSearchFor)).
                map(Order::getCustomer).distinct().forEach(System.out::println);
        System.out.println();
    }
    public void printAmountOfOrdersPerCustomer() {
        repository.getOrderList().stream().collect(Collectors.groupingBy(Order::getCustomer)).
                forEach((key, value) -> System.out.println(key + ": antal ordrar: " + value.size()));
        System.out.println();
    }

    public void printTotalAmountSpentByCustomer() {
        repository.getOrderList().stream().collect(Collectors.groupingBy(Order::getCustomer)).
                forEach((key, value) -> System.out.println(key.getFirstName() + " " + key.getLastName() +
                        " | Total amount: " + value.stream().flatMap(o -> o.getOrderedProducts().stream()).
                        map(Product::getPrice).mapToDouble(e -> e).sum()));
    }

    public SalesSupport (){

        while (true) {
            System.out.println("""
                Select option:
                1 - Customer report by size/colour/brand
                2 - Report including customers and amount of orders
                3 - Report including customers and amount spent
                0 - Exit""");
            final int reportOption = sc.nextInt();
            if (reportOption == 1) {
                System.out.println("""
                        Select which type of report:
                        1 - Size
                        2 - Colour
                        3 - Brand""");
                final int firstReportType = sc.nextInt(); sc.nextLine();
                if (firstReportType == 1) {
                    System.out.print("Enter the size: ");
                    String size = sc.nextLine().trim();
                    System.out.println("Customers that have purchased shoes in size " + size + ":");
                    printSizeColourBrandReport(size, sizeReport);
                }
                else if (firstReportType == 2) {
                    System.out.print("Enter the colour: ");
                    String colour = sc.nextLine().trim();
                    System.out.println("Customers that have purchased shoes in colour " + colour + ":");
                    printSizeColourBrandReport(colour, colourReport);
                }
                else if (firstReportType == 3) {
                    System.out.print("Enter the brand: ");
                    String brand = sc.nextLine().trim();
                    System.out.println("Customers that have purchased shoes from brand " + brand + ":");
                    printSizeColourBrandReport(brand, brandReport);
                }
            }
            else if (reportOption == 2) {
                printAmountOfOrdersPerCustomer();
            }
            else if (reportOption == 3) {
                printTotalAmountSpentByCustomer();
            }
            else if (reportOption == 0) {
                System.exit(0);
            }
        }
    }
    public static void main(String[] args) {
        new SalesSupport();
    }
}
