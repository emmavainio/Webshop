import java.util.Scanner;

public class SalesSupport {

    final Repository repository = new Repository();
    final Scanner sc = new Scanner(System.in);

    OrderFilterInterface sizeSearch = (o, wordToSearch) -> o.getOrderedProducts().stream().anyMatch
            (product -> product.getSize().getSize().equalsIgnoreCase(wordToSearch));

    OrderFilterInterface colourSearch = (o, wordToSearch) -> o.getOrderedProducts().stream().anyMatch
            (product -> product.getColour().getColour().equalsIgnoreCase(wordToSearch));

    OrderFilterInterface brandSearch = (o, wordToSearch) -> o.getOrderedProducts().stream().anyMatch
            (product -> product.getBrand().getBrand().equalsIgnoreCase(wordToSearch));

    /*

    2. En rapport som listar alla kunder och hur många ordrar varje kund har lagt. Skriv ut namn
    och sammanlagda antalet ordrar för varje kund.

    3. En rapport som listar alla kunder och hur mycket pengar varje kund, sammanlagt, har
    beställt för. Skriv ut varje kunds namn och summa.

    4. En rapport som listar beställningsvärde per ort. Skriv ut orternas namn och summa.

    5. En topplista över de mest sålda produkterna som listar varje modell och hur många ex som
    har sålts av den modellen. Skriv ut namn på modellen och hur många ex som sålts.
     */



    public void printSizeColourBrandReport(String wordToSearchFor, OrderFilterInterface reportType){
        //repository.getOrderList().stream().filter(o -> reportType.orderFilter(o, wordToSearchFor)).forEach(order -> System.out.println(order.getCustomer()));
        repository.getOrderList().stream().filter(o -> reportType.orderFilter(o, wordToSearchFor)).map(Order::getCustomer).
                map(Customer::toString).distinct().forEach(System.out::println);
        System.out.println();
    }

    public SalesSupport (){
        //repository.getCustomerList().stream().forEach(c -> System.out.println(c));
        //repository.getOrderList().stream().forEach(o -> System.out.println(o.getCustomer() + " " + o.getPurchaseDate()));
        //repository.getOrderList().stream().filter(o -> o.getId() == 1).forEach(order -> System.out.println(order.getOrderedProducts()));
        while (true) {
            System.out.println("""
                Select option:
                1 - Customer report by size/colour/brand
                2 - Report including customers and amount of orders
                3 - Report including customers and amount spent
                4 - Report including order value per city
                5 - Top-list of products""");
            final int input = sc.nextInt();
            if (input == 1) {
                System.out.println("""
                        Select which type of report:
                        1 - Size
                        2 - Colour
                        3 - Brand""");
                final int reportOption = sc.nextInt(); sc.nextLine();
                if (reportOption == 1) {
                    System.out.print("Enter the size: ");
                    String size = sc.nextLine().trim();
                    System.out.println("Customers that have purchased shoes in size " + size + ":");
                    printSizeColourBrandReport(size, sizeSearch);
                }
                else if (reportOption == 2) {
                    System.out.print("Enter the colour: ");
                    String colour = sc.nextLine().trim();
                    System.out.println("Customers that have purchased shoes in colour " + colour + ":");
                    printSizeColourBrandReport(colour, colourSearch);
                }
                else if (reportOption == 3) {
                    System.out.print("Enter the brand: ");
                    String brand = sc.nextLine().trim();
                    System.out.println("Customers that have purchased shoes from brand " + brand + ":");
                    printSizeColourBrandReport(brand, brandSearch);
                }
            }
        }


    }

    public static void main(String[] args) {
        new SalesSupport();
    }
}
