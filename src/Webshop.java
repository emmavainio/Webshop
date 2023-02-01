import java.util.List;

public class Webshop {

    Repository r = new Repository();

    public Webshop() {
        //prompta skriva in namn och lösen
        //kontrollera lösenord mot anv
        //prompta vilka produkter som finns
        //be anv skriva in vilken produkt som ska köpas
        List<Inventory> il = r.getInventoryList();
        il.forEach(e -> System.out.println(e.getCreated()));


    }

    public static void main(String[] args) {
        new Webshop();
    }
}