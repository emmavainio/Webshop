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
    public List<Product> getProductList() {
        List<Product> articleList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from product")
        ) {
            while (rs.next()) {
                Product temp = new Product();
                temp.setId(rs.getInt("id"));
                temp.setPrice(rs.getDouble("price"));
                temp.setInventoryId((int)rs.getInt("inventory_id"));
                temp.setSizeId(rs.getInt("size_id"));
                temp.setInventoryId(rs.getInt("inventory_id"));
                articleList.add(temp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return articleList;
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
}
