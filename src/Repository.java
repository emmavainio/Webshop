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
    public Map<Integer, Brand> getBrandMap() {
        Map<Integer, Brand> brandMap = new HashMap<>();
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from brand")
        ) {
            while (rs.next()) {
                Brand temp = new Brand();
                temp.setId(rs.getInt("id"));
                temp.setBrand(rs.getString("brand"));
                brandMap.put(temp.getId(), temp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return brandMap;
    }
    public Map<Integer, Category> getCategoryMap() {
        Map<Integer, Category> categoryMap = new HashMap<>();
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from category")
        ) {
            while (rs.next()) {
                Category temp = new Category();
                temp.setId(rs.getInt("id"));
                temp.setCategory(rs.getString("category"));
                categoryMap.put(temp.getId(), temp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return categoryMap;
    }
    public Map<Integer, City> getCityMap() {
        Map<Integer, City> cityMap = new HashMap<>();
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from city")
        ) {
            while (rs.next()) {
                City temp = new City();
                temp.setId(rs.getInt("id"));
                temp.setCity(rs.getString("city"));
                cityMap.put(temp.getId(), temp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return cityMap;
    }
    public Map<Integer, Colour> getColourMap() {
        Map<Integer, Colour> colourMap = new HashMap<>();
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from colour")
        ) {
            while (rs.next()) {
                Colour temp = new Colour();
                temp.setId(rs.getInt("id"));
                temp.setColour(rs.getString("colour"));
                colourMap.put(temp.getId(), temp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return colourMap;
    }
    public Map<Integer, Customer> getCustomerMap() {
        Map<Integer, Customer> customerMap = new HashMap<>();
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from customer")
        ) {
            while (rs.next()) {
                Customer temp = new Customer();
                temp.setId(rs.getInt("id"));
                temp.setCityId(rs.getInt("city_id"));
                temp.setFirstName(rs.getString("first_name"));
                temp.setLastName(rs.getString("last_name"));
                temp.setAddress(rs.getString("address"));
                temp.setPostalCode(rs.getString("postal_code"));
                temp.setUsername(rs.getString("username"));
                temp.setPassword(rs.getString("password"));
                customerMap.put(temp.getId(), temp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return customerMap;
    }
    public List<Customer> getCustomerList() {
        List<Customer> customerList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from customer")
        ) {
            while (rs.next()) {
                Customer temp = new Customer();
                temp.setId(rs.getInt("id"));
                temp.setCityId(rs.getInt("city_id"));
                temp.setFirstName(rs.getString("first_name"));
                temp.setLastName(rs.getString("last_name"));
                temp.setAddress(rs.getString("address"));
                temp.setPostalCode(rs.getString("postal_code"));
                temp.setUsername(rs.getString("username"));
                temp.setPassword(rs.getString("password"));
                customerList.add(temp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return customerList;
    }
    public List<Inventory> getInventoryList() {
        List<Inventory> inventoryList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from inventory")
        ) {
            while (rs.next()) {
                Inventory temp = new Inventory();
                temp.setId(rs.getInt("id"));
                temp.setAmount((int)rs.getInt("amount"));
                temp.setCreated(rs.getTimestamp("created"));
                temp.setLastUpdate(rs.getTimestamp("last_update"));
                inventoryList.add(temp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return inventoryList;
    }
    public Map<Integer, Order> getOrderMap() {
        Map<Integer, Order> orderMap = new HashMap<>();
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from `order`")
        ) {
            while (rs.next()) {
                Order temp = new Order();
                temp.setId(rs.getInt("id"));
                temp.setCustomerId(rs.getInt("customer_id"));
                temp.setPurchaseDate(rs.getTimestamp("purchase_date"));
                orderMap.put(temp.getId(), temp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return orderMap;
    }
    public List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select product.id as productid, price, model, " +
                     "brand.id as brandid, brand, colour.id as colourid, colour, \n" +
                     "\tsize.id as sizeid, size, inventory.id as inventoryid, amount, created, last_update from product\n" +
                     "inner join brand on brand.id = brand_id\n" +
                     "inner join size on size.id = size_id\n" +
                     "inner join colour on colour.id = colour_id\n" +
                     "inner join inventory on inventory.id = inventory_id;")
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
    public Map<Integer, Inventory> getInventoryMap() {
        Map<Integer, Inventory> inventoryMap = new HashMap<>();
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from inventory")
        ) {
            while (rs.next()) {
                Inventory temp = new Inventory();
                temp.setId(rs.getInt("id"));
                temp.setAmount((int)rs.getInt("amount"));
                temp.setCreated(rs.getTimestamp("created"));
                temp.setLastUpdate(rs.getTimestamp("last_update"));
                inventoryMap.put(temp.getId(), temp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return inventoryMap;
    }
    public Map<Integer, Size> getSizeMap() {
        Map<Integer, Size> sizeMap = new HashMap<>();
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from size")
        ) {
            while (rs.next()) {
                Size temp = new Size();
                temp.setId(rs.getInt("id"));
                temp.setSize(rs.getString("size"));
                sizeMap.put(temp.getId(), temp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return sizeMap;
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
}
