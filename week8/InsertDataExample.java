import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "root";
        String password = "daga";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String insertSQL = "INSERT INTO products (name, price) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                preparedStatement.setString(1, "ProductName");
                preparedStatement.setDouble(2, 99.99);
              preparedStatement.setString(1, "ProductName");
                preparedStatement.setDouble(2, 99.99);
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

