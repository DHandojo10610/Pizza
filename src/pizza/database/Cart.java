package pizza.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cart {
    private static MysqlDataSource dataSource = new MysqlDataSource();

    private static void connectToDatabase() {
        String DB_URL = "jdbc:mysql://localhost:3306/db_pizza?serverTimezone=Asia/Jakarta";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "";

        dataSource.setUrl(DB_URL);
        dataSource.setUser(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
    }

    public static ArrayList<String[]> getMenu(){
        ArrayList<String[]> data = new ArrayList<>();
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT * FROM cart";
            PreparedStatement ps = conn.prepareStatement(querySelect);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String menu = rs.getString("menu");
                String price = rs.getString("stock");

                String[] tempData = {menu, price};
                data.add(tempData);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
}