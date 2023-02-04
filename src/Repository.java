import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class Repository {

    private Properties p = new Properties();
    String path = "src/settings.properties";

    public Repository() {
        try {
            p.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getCustomerList() {
        List<Customer> customerList = new ArrayList<>();
        final String query = "select customer.id as customerid, first_name, last_name, address, postal_code, " +
                "username, password, city.id as cityid, city from Customer " +
                "inner join city on city.id = customer.city_id";
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)
        ) {
            while (rs.next()) {
                Customer temp = new Customer();
                temp.setId(rs.getInt("customerid"));
                temp.setFirstName(rs.getString("first_name"));
                temp.setLastName(rs.getString("last_name"));
                temp.setAddress(rs.getString("address"));
                temp.setPostalCode(rs.getString("postal_code"));
                temp.setUsername(rs.getString("username"));
                temp.setPassword(rs.getString("password"));
                temp.setCity(new City(rs.getInt("cityid"), rs.getString("city")));
                customerList.add(temp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return customerList;
    }
    public List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        final String query = "select product.id as productid, price, model, " +
                "brand.id as brandid, brand, colour.id as colourid, colour, " +
                "size.id as sizeid, size, inventory.id as inventoryid, amount, created, last_update from product " +
                "inner join brand on brand.id = brand_id " +
                "inner join size on size.id = size_id " +
                "inner join colour on colour.id = colour_id " +
                "inner join inventory on inventory.id = inventory_id";
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)
        ) {
            while (rs.next()) {
                Product temp = new Product();
                temp.setId(rs.getInt("productid"));
                temp.setModel(rs.getString("model"));
                temp.setPrice(rs.getDouble("price"));
                temp.setBrand(new Brand(rs.getInt("brandid"), rs.getString("brand")));
                temp.setInventory(new Inventory(rs.getInt("inventoryid"), rs.getInt("amount"),
                        rs.getTimestamp("created"), rs.getTimestamp("last_update")));
                temp.setSize(new Size(rs.getInt("sizeid"), rs.getString("size")));
                temp.setColour(new Colour(rs.getInt("colourid"), rs.getString("colour")));
                productList.add(temp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return productList;
    }
    public void addToCart(int customerId, int productId) {
        String query = "call addtocart(?, null, ?, ?)";
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             CallableStatement stmt = con.prepareCall(query);
        ) {
            stmt.setInt(1, customerId);
            stmt.setInt(2, productId);
            stmt.registerOutParameter(3, Types.VARCHAR);

            stmt.executeUpdate();
            System.out.println(stmt.getString(3));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Order> getOrderList() {
        List<Order> orderList = new ArrayList<>();
        final String query = "select `order`.id as orderid, purchase_date, customer.id as customerid, first_name, " +
                "last_name, address, postal_code, username, password, city.id as cityid, city from `order` " +
                "inner join customer on customer.id = customer_id " +
                "inner join city on city.id = customer.city_id;";
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)
        ) {
            while (rs.next()) {
                Order temp = new Order();
                temp.setId(rs.getInt("orderid"));
                temp.setPurchaseDate(rs.getTimestamp("purchase_date"));
                temp.setCustomer(new Customer(rs.getInt("customerid"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("address"),
                        rs.getString("postal_code"), new City(rs.getInt("cityid"),
                        rs.getString("city")), rs.getString("username"), rs.getString("password")));
                temp.setOrderedProducts(getProductListForOrder(rs.getInt("orderid")));
                orderList.add(temp);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return orderList;
    }
    public List<Product> getProductListForOrder(int orderNr) {

        List<Product> productList = new ArrayList<>();
        final String query = "select `order`.id as orderid, product.id as productid, price, model, brand.id as brandid, brand, colour.id as colourid, colour, size.id as sizeid, size, inventory.id as inventoryid, amount, created, last_update from `order` " +
                "inner join ordered_products on `order`.id = order_id " +
                "inner join product on product.id = product_id " +
                "inner join brand on brand.id = brand_id " +
                "inner join size on size.id = size_id " +
                "inner join colour on colour.id = colour_id " +
                "inner join inventory on inventory.id = inventory_id " +
                "where `order`.id = ?";
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement(query);
        ) {
            stmt.setInt(1, orderNr);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product temp = new Product();
                temp.setId(rs.getInt("productid"));
                temp.setModel(rs.getString("model"));
                temp.setPrice(rs.getDouble("price"));
                temp.setBrand(new Brand(rs.getInt("brandid"), rs.getString("brand")));
                temp.setInventory(new Inventory(rs.getInt("inventoryid"), rs.getInt("amount"),
                        rs.getTimestamp("created"), rs.getTimestamp("last_update")));
                temp.setSize(new Size(rs.getInt("sizeid"), rs.getString("size")));
                temp.setColour(new Colour(rs.getInt("colourid"), rs.getString("colour")));
                productList.add(temp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return productList;
    }
}
