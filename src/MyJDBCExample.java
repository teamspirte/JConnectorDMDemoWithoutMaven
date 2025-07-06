import java.sql.*;

public class MyJDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/DMJConnector";
        String user = "root";
        String pass = "root";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load driver (optional with newer JDBC, but safe)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ Connected!");

            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Course: %s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("course"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { /*ignore*/ }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { /*ignore*/ }
            try { if (conn != null) conn.close(); } catch (SQLException e) { /*ignore*/ }
        }
    }
}
