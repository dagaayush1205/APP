import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "root";
        String password = "daga";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String updateSQL = "UPDATE orders SET status = ? WHERE order_id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
                preparedStatement.setString(1, "Shipped");
                preparedStatement.setInt(2, 1);
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) updated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

