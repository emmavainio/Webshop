import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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

    public String getPassword(String name) {
        String password = "";
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement("select password from customer where first_name = ?");
        ) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                password = rs.getString("password");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return password;
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
}
