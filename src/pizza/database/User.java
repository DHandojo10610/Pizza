package pizza.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private static MysqlDataSource dataSource = new MysqlDataSource();

    private static void connectToDatabase() {
        String DB_URL = "jdbc:mysql://localhost:3306/db_pizza?serverTimezone=Asia/Jakarta";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "";

        dataSource.setUrl(DB_URL);
        dataSource.setUser(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
    }

    public static boolean checkUser(String email, String password) {
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT * FROM user WHERE email = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(querySelect);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return false;
    }

    public static String login(String email, String password) {
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT * FROM user WHERE email = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(querySelect);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            rs.next();

            return rs.getString("email");

        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    public static int getAccountByEmail(String username) {
        int status = 0;
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String querySelect = "SELECT email FROM user WHERE email = ?";
            PreparedStatement ps = conn.prepareStatement(querySelect);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                status = 1;
            }

            return status;
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return status;
    }

    public static int addUser(String name, String password) {
        connectToDatabase();
        try {
            Connection conn = dataSource.getConnection();

            String queryInsert = "INSERT INTO user(email, password) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(queryInsert);
            ps.setString(1, name);
            ps.setString(2, password);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return 0;
    }
}